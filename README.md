MonacoFX
==========

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

Embedded Monaco (VS Code) editor for JavaFX, based on WebView and custom URL schemes handlers.

Features

 * Fully typed Java interfaces generated directly from Monaco's TypeScript definitions
 * Works in Swing via JFXPanel
 * Bundled Monaco editor -- no external downloads at runtime

Known limitations:

 * Java >= 17 and OpenJFX 22+ required
 * Enabling ligatures has no effect as JavaFX currently does not support [rendering ligatures](https://bugs.openjdk.java.net/browse/JDK-8091616)

## Project structure

```
MonacoFX/
  js-support/        -- JavaScript bridge layer (JsProxy, JsContext)
  monacofx/          -- Core library: MonacoPane, generated Monaco API bindings
  monacofx-sample/   -- Sample app with editor, diff, and JShell worksheet tabs
  ambient2java/      -- Scala/SBT code generator: TypeDoc JSON -> Java sources
```

## Prerequisites

 * JDK 17+
 * Maven (or use the included `./mvnw` wrapper)

## How to build

Build the entire project:

    ./mvnw clean package

This installs Node via `frontend-maven-plugin`, downloads Monaco from npm, and
compiles everything. The Maven wrapper is included so you do not need Maven
installed.

## Development workflow

### 1. First-time setup / full rebuild

    ./mvnw clean install

This builds all modules in dependency order: `js-support` -> `monacofx` -> `monacofx-sample`.

### 2. Re-generate Monaco Java bindings

The generated Monaco API sources live in `monacofx/target/generated-sources/monaco/`
(not checked into git). To regenerate after changing the code generator or bumping
the Monaco version:

    ./mvnw exec:exec@sync -pl monacofx

This runs the SBT code generator under `ambient2java/` and copies the output.
To run the code generator independently (useful for debugging):

    cd ambient2java
    sbt -Dmonaco.version=0.55.1 runMonacoConversion

### 3. Compile after editing Java sources

    ./mvnw compile

### 4. Run the sample app

    ./mvnw exec:java -pl monacofx-sample

### 5. Run tests

UI tests require a display (real or virtual via Xvfb):

    DISPLAY=:0 ./mvnw test

Tests are skipped automatically when no DISPLAY is set.

### 6. Run integration tests (code generator)

    cd ambient2java
    sbt -Dmonaco.version=0.55.1 "it/test"

These tests verify that the generated Java sources compile and pass type checks.
Requires `js-support` to be built first (`./mvnw package -pl js-support`).

### 7. Code formatting

The project uses [Spotless](https://github.com/diffplug/spotless) with
[Palantir Java Format](https://github.com/palantir/palantir-java-format) to
enforce a consistent code style. Formatting is checked automatically during
`mvn verify`.

To auto-format all Java sources:

    ./mvnw spotless:apply

To check formatting without modifying files:

    ./mvnw spotless:check

### 8. Bump the Monaco version

1. Update `<monaco.version>` in `pom.xml`
2. Update `"monaco-editor"` version in `monacofx/package.json`
3. Re-generate bindings: `./mvnw exec:exec@sync -pl monacofx`
4. Fix any compilation errors in `monacofx/` or `monacofx-sample/`
5. Run integration tests to verify

## Release process

1. Commit all changes before release
2. Make sure `~/.m2/settings.xml` has the Sonatype OSSRH credentials:

    ```xml
    <server>
      <id>ossrh</id>
      <username>your-sonatype-username</username>
      <password>your-sonatype-password</password>
    </server>
    ```

   Also ensure the machine has a GPG key configured for artifact signing and
   SSH access to GitHub for pushing tags.

3. Dry run:

       ./mvnw release:prepare -DdryRun=true -Darguments=-DskipTests

4. Clean up the dry run:

       ./mvnw release:clean

5. Prepare the release (tags and bumps the version):

       ./mvnw release:prepare -Darguments=-DskipTests

6. Inspect the commits, then push:

       git push && git push --tags

7. Perform the release (builds, signs, uploads to Sonatype):

       ./mvnw clean release:perform -Darguments=-DskipTests

8. Complete the release by closing and releasing the staging repository:

       cd target/checkout && ./mvnw nexus-staging:release

## Licence

    Copyright 2024 WeiChen Lin

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
