#!/usr/bin/env node
// Reads a .d.ts file, extracts top-level declaration names (not inside
// `declare namespace/module/global`), and writes a patched copy with an
// explicit `export { ... }` appended so TypeDoc 0.26 documents them.
//
// Usage: node export-toplevel.mjs <input.d.ts> <output.d.ts>
//
// Expects `typescript` to be installed in the current working directory's
// node_modules (the build.sbt task already installs it there).

import { createRequire } from "module";
import { readFileSync, writeFileSync } from "fs";

const require = createRequire(process.cwd() + "/package.json");
const ts = require("typescript");

const [,, inputPath, outputPath] = process.argv;
if (!inputPath || !outputPath) {
  console.error("Usage: node export-toplevel.mjs <input.d.ts> <output.d.ts>");
  process.exit(1);
}

const src = readFileSync(inputPath, "utf-8");
const sf = ts.createSourceFile(inputPath, src, ts.ScriptTarget.Latest, true);

const names = [];

for (const stmt of sf.statements) {
  // Skip `declare namespace`, `declare module`, `declare global` blocks
  if (ts.isModuleDeclaration(stmt)) continue;

  // Skip `export { ... }` / `export =` / `export default`
  if (ts.isExportDeclaration(stmt) || ts.isExportAssignment(stmt)) continue;

  let name = undefined;

  if (ts.isInterfaceDeclaration(stmt))    name = stmt.name.text;
  if (ts.isClassDeclaration(stmt))        name = stmt.name?.text;
  if (ts.isEnumDeclaration(stmt))         name = stmt.name.text;
  if (ts.isTypeAliasDeclaration(stmt))    name = stmt.name.text;
  if (ts.isFunctionDeclaration(stmt))     name = stmt.name?.text;
  if (ts.isVariableStatement(stmt)) {
    for (const decl of stmt.declarationList.declarations) {
      if (ts.isIdentifier(decl.name)) names.push(decl.name.text);
    }
    continue;
  }

  if (name) names.push(name);
}

// Filter out internal/generated alias prefixes that shouldn't be exported
const filtered = names.filter(n =>
  !n.startsWith("editor_main_") &&
  !n.startsWith("monaco_contribution") &&
  !n.startsWith("index_d_")
);

console.log(`Found ${filtered.length} top-level declarations to export`);

const exportLine = `export { ${filtered.join(", ")} };`;
writeFileSync(outputPath, src + "\n" + exportLine + "\n", "utf-8");
