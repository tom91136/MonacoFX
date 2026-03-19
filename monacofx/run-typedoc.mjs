#!/usr/bin/env node
// Wrapper to invoke typedoc with posix-normalized paths (typedoc rejects backslashes on Windows).
import { execFileSync } from "child_process";
import { writeFileSync, mkdirSync } from "fs";
import { resolve, dirname } from "path";

const [,, jsonOut, entryPoint] = process.argv;
if (!jsonOut || !entryPoint) {
  console.error("Usage: node run-typedoc.mjs <json-out> <entry-point>");
  process.exit(1);
}

const p = s => resolve(s).replace(/\\/g, "/");
const outDir = dirname(resolve(jsonOut));

mkdirSync(outDir, { recursive: true });

const tsconfig = resolve(outDir, "tsconfig.json");
writeFileSync(tsconfig, JSON.stringify({
  compilerOptions: { target: "ES2020", lib: ["ES2020", "DOM"], skipLibCheck: true, noEmit: true },
  files: [p(entryPoint)]
}));

// Resolve typedoc's actual JS entry point (node_modules/.bin/typedoc is a bash script on Windows)
const typedocMain = resolve("node_modules/typedoc/bin/typedoc");

execFileSync(process.execPath, [
  typedocMain,
  "--json", p(jsonOut),
  "--entryPoints", p(entryPoint),
  "--skipErrorChecking",
  "--tsconfig", p(tsconfig),
], { stdio: "inherit" });
