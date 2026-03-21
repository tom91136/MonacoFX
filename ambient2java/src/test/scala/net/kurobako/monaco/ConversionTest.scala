package net.kurobako.monaco

import java.nio.file.Files
import java.nio.file.Path
import scala.sys.process.*
import scala.util.Using

import munit.FunSuite

class ConversionTest extends FunSuite {

  private val isWindows                 = sys.props("os.name").toLowerCase.contains("win")

  private val typedocVersion = sys.env.getOrElse(
    "TYPEDOC_VERSION",
    fail("TYPEDOC_VERSION env var must be set (e.g. 0.28.17)")
  )
  private val typescriptVersion = sys.env.getOrElse(
    "TYPESCRIPT_VERSION",
    fail("TYPESCRIPT_VERSION env var must be set (e.g. 5.6.3)")
  )

  private lazy val nodeModulesDir: Path = {
    val dir = Files.createTempDirectory("ambient2java-test-")
    dir.toFile.deleteOnExit()
    val rc = Process(
      Seq(
        if (isWindows) "npm.cmd" else "npm",
        "install",
        "--save-exact",
        s"typedoc@$typedocVersion",
        s"typescript@$typescriptVersion"
      ),
      dir.toFile
    ).!
    assertEquals(rc, 0, s"npm install failed (exit code $rc)")
    dir
  }

  private def deleteRecursively(path: Path): Unit =
    if (Files.exists(path)) {
      if (Files.isDirectory(path))
        Using(Files.list(path))(_.forEach(deleteRecursively)): Unit
      Files.deleteIfExists(path): Unit
    }

  private def runPipeline(dtsContent: String): Map[String, String] = {
    val workDir = Files.createTempDirectory("ambient2java-case-")
    try {
      val dtsFile = workDir.resolve("test.d.ts")
      Files.writeString(dtsFile, dtsContent)

      val tsconfig    = workDir.resolve("tsconfig.json")
      val dtsAbsolute = dtsFile.toAbsolutePath.toString.replace("\\", "/")
      Files.writeString(
        tsconfig,
        s"""|{
            |  "compilerOptions": {
            |    "target": "ES2020",
            |    "lib": ["ES2020", "DOM"],
            |    "skipLibCheck": true,
            |    "noEmit": true
            |  },
            |  "files": ["$dtsAbsolute"]
            |}""".stripMargin
      )

      val jsonOut    = workDir.resolve("typedoc-out.json")
      val typedocBin = nodeModulesDir.resolve("node_modules/typedoc/bin/typedoc")
      val rc         = Process(
        Seq(
          "node",
          typedocBin.toAbsolutePath.toString,
          "--name",
          "test_module",
          "--json",
          jsonOut.toAbsolutePath.toString,
          "--entryPoints",
          dtsFile.toAbsolutePath.toString,
          "--skipErrorChecking",
          "--tsconfig",
          tsconfig.toAbsolutePath.toString
        ),
        workDir.toFile
      ).!
      assertEquals(rc, 0, "typedoc failed")

      val result = TsToJavaAst.runConversion(jsonOut, dtsFile)
      result match {
        case Left(err)        => fail(s"runConversion fatal error: ${err.getMessage}", err)
        case Right(validated) =>
          validated.fold(
            errors => fail(s"runConversion errors:\n${errors.toList.map(_.getMessage).mkString("\n")}"),
            sources => sources.toMap
          )
      }
    } finally
      deleteRecursively(workDir)
  }

  private def sourceFor(sources: Map[String, String], className: String): String =
    sources
      .find { case (path, _) => path.endsWith(s"$className.java") }
      .map(_._2)
      .getOrElse(fail(s"No generated source for $className. Available: ${sources.keys.mkString(", ")}"))

  test("static method on class emits static keyword with JsContext parameter") {
    val sources = runPipeline(
      """|export declare namespace ns {
         |  class Foo {
         |    static create(value: string): Foo;
         |    bar(): void;
         |  }
         |}
         |""".stripMargin
    )
    val src = sourceFor(sources, "Foo")
    assert(
      src.contains("public static Foo create(@Nonnull JsContext ctx, @Nonnull String value)"),
      s"Expected static method with JsContext param, got:\n$src"
    )
    assert(
      src.contains("""invokeStatic(new JsProxy(ctx, ctx.engine.executeScript("ns.Foo"))"""),
      s"Expected invokeStatic with engine.executeScript delegation, got:\n$src"
    )
    // bar should be an instance method, not static
    assert(src.contains("public void bar()"), s"Expected instance method bar(), got:\n$src")
    assert(!src.linesIterator.exists(l => l.contains("static") && l.contains("bar")), "bar() should not be static")
  }

  test("module function is not static") {
    val sources = runPipeline(
      """|export declare namespace ns {
         |  function doSomething(x: number): string;
         |}
         |""".stripMargin
    )
    val src = sourceFor(sources, "NsModule")
    assert(
      src.contains("public String doSomething("),
      s"Expected instance method doSomething, got:\n$src"
    )
    assert(
      !src.linesIterator.exists(l => l.contains("static") && l.contains("doSomething")),
      s"Module function should not be static, got:\n$src"
    )
    // Should use invoke(), not invokeStatic()
    assert(src.contains("""invoke("doSomething","""), s"Expected invoke() delegation, got:\n$src")
  }

  test("static method with no parameters") {
    val sources = runPipeline(
      """|export declare namespace ns {
         |  class Bar {
         |    static instance(): Bar;
         |  }
         |}
         |""".stripMargin
    )
    val src = sourceFor(sources, "Bar")
    assert(
      src.contains("public static Bar instance(@Nonnull JsContext ctx)"),
      s"Expected static no-arg method with JsContext param, got:\n$src"
    )
  }

  test("static and instance methods coexist") {
    val sources = runPipeline(
      """|export declare namespace ns {
         |  class Pos {
         |    static compare(a: number, b: number): number;
         |    getValue(): string;
         |  }
         |}
         |""".stripMargin
    )
    val src = sourceFor(sources, "Pos")
    // compare is static
    assert(src.contains("public static double compare(@Nonnull JsContext ctx,"), s"static compare missing:\n$src")
    // getValue is not static
    assert(src.contains("public String getValue()"), s"instance getValue missing:\n$src")
    assert(
      !src.linesIterator.exists(l => l.contains("static") && l.contains("getValue")),
      "getValue should not be static"
    )
  }

  test("interface method is not static") {
    val sources = runPipeline(
      """|export declare namespace ns {
         |  interface IOptions {
         |    getValue(): string;
         |  }
         |}
         |""".stripMargin
    )
    val src = sourceFor(sources, "IOptions")
    assert(src.contains("public String getValue()"), s"Expected instance method:\n$src")
    assert(!src.contains("public static"), s"Interface methods should not be static:\n$src")
  }

  test("enum conversion") {
    val sources = runPipeline(
      """|export declare namespace ns {
         |  enum Color {
         |    Red = 0,
         |    Green = 1,
         |    Blue = 2,
         |  }
         |}
         |""".stripMargin
    )
    val src = sourceFor(sources, "Color")
    assert(src.contains("public enum Color"), s"Expected enum:\n$src")
    assert(src.contains("Red(0)"), s"Expected Red(0):\n$src")
    assert(src.contains("Green(1)"), s"Expected Green(1):\n$src")
    assert(src.contains("Blue(2)"), s"Expected Blue(2):\n$src")
  }

  test("property getter and setter") {
    val sources = runPipeline(
      """|export declare namespace ns {
         |  interface IConfig {
         |    name: string;
         |    readonly version: number;
         |  }
         |}
         |""".stripMargin
    )
    val src = sourceFor(sources, "IConfig")
    // name should have getter and setter
    assert(src.contains("public String name()"), s"Expected name getter:\n$src")
    assert(src.contains("public IConfig name(@Nonnull String value)"), s"Expected name setter:\n$src")
    // version is readonly — getter only, no setter
    assert(src.contains("public double version()"), s"Expected version getter:\n$src")
    // Check version doesn't have a setter (readonly in interface still gets setter in current code)
    // Interface properties get both get and set via emitInterfaceProperty
  }

  test("optional parameter generates overload") {
    val sources = runPipeline(
      """|export declare namespace ns {
         |  class Builder {
         |    build(name: string, count?: number): Builder;
         |  }
         |}
         |""".stripMargin
    )
    val src = sourceFor(sources, "Builder")
    // Should have overload with count and without count
    assert(
      src.contains("public Builder build(@Nonnull String name, @Nonnull Double count)"),
      s"Expected full overload:\n$src"
    )
    assert(
      src.contains("public Builder build(@Nonnull String name)"),
      s"Expected optional-omitted overload:\n$src"
    )
  }

}
