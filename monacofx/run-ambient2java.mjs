#!/usr/bin/env node
// Invokes ambient2java's TsToJavaAst via sbt, skipping if sbt wrapper is not found.
import { execSync } from "child_process";
import { existsSync } from "fs";
import { resolve, join } from "path";

const [,, projectRoot, typedocJson, monacoDts, outputDir] = process.argv;
if (!projectRoot || !typedocJson || !monacoDts || !outputDir) {
  console.error("Usage: node run-ambient2java.mjs <project-root> <typedoc-json> <monaco-dts> <output-dir>");
  process.exit(1);
}

const ambient2javaDir = resolve(projectRoot, "ambient2java");
const isWindows = process.platform === "win32";
const sbtWrapper = join(ambient2javaDir, isWindows ? "sbt.bat" : "sbt");

if (!existsSync(sbtWrapper)) {
  console.log("=== sbt wrapper not found, skipping code generation (using committed sources) ===");
  process.exit(0);
}

console.log("=== Running ambient2java: TsToJavaAst ===");
const sbtCmd = isWindows ? `call sbt.bat` : `./sbt`;
const mainArgs = `${resolve(typedocJson)} ${resolve(monacoDts)} ${resolve(outputDir)}`;
execSync(`${sbtCmd} "runMain net.kurobako.monaco.TsToJavaAst ${mainArgs}"`, {
  cwd: ambient2javaDir,
  stdio: "inherit",
  shell: true,
});
console.log("=== Code generation complete ===");
