package net.kurobako.monaco

import java.io.File
import java.nio.file.Files
import java.nio.charset.StandardCharsets
import javax.tools.{DiagnosticCollector, JavaFileObject, ToolProvider}

import scala.jdk.CollectionConverters._

import better.files.{File => BFile}
import cats.data.Validated

class ConversionIntegrationSuite extends munit.FunSuite {

  private val targetDir     = new File(sys.props.getOrElse("target.dir", "target"))
  private val testClasspath = sys.props.getOrElse("test.classpath", sys.props.getOrElse("java.class.path", ""))

  // Files produced by the downloadMonacoTypes / generateTypedocJson SBT tasks
  private val downloadDir = new File(targetDir, "monaco-download")
  private val typedocJson = new File(downloadDir, "typedoc.json")
  private val monacoDir   = new File(downloadDir, "node_modules/monaco-editor")
  private val dtsFile     = {
    val v1 = new File(monacoDir, "monaco.d.ts")
    val v2 = new File(monacoDir, "esm/vs/editor/editor.api.d.ts")
    if (v1.exists()) v1 else v2
  }

  test("Monaco download produces typedoc JSON and .d.ts file") {
    assume(typedocJson.exists(), s"TypeDoc JSON not found at $typedocJson — run 'sbt generateTypedocJson' first")
    assume(dtsFile.exists(), s"Monaco .d.ts not found under $monacoDir")
  }

  test("Monaco conversion produces Java sources without errors") {
    assume(typedocJson.exists(), s"TypeDoc JSON not found — run 'sbt generateTypedocJson' first")
    assume(dtsFile.exists(), s"Monaco .d.ts not found — run 'sbt downloadMonacoTypes' first")

    TsToJavaAst.runConversion(BFile(typedocJson.getAbsolutePath), BFile(dtsFile.getAbsolutePath)) match {
      case Left(e) =>
        fail(s"Fatal conversion error: ${e.getMessage}", e)
      case Right(Validated.Invalid(errors)) =>
        fail(s"Conversion produced ${errors.size} errors:\n${errors.toList.map(_.getMessage).mkString("\n")}")
      case Right(Validated.Valid(sources)) =>
        assert(sources.nonEmpty, "Expected generated sources to be non-empty")
    }
  }

  test("Monaco conversion produces Java sources that compile") {
    assume(typedocJson.exists(), s"TypeDoc JSON not found — run 'sbt generateTypedocJson' first")
    assume(dtsFile.exists(), s"Monaco .d.ts not found — run 'sbt downloadMonacoTypes' first")

    val sources = TsToJavaAst.runConversion(BFile(typedocJson.getAbsolutePath), BFile(dtsFile.getAbsolutePath)) match {
      case Right(Validated.Valid(srcs)) => srcs
      case other =>
        assume(false, s"Conversion did not succeed: $other")
        Nil
    }

    val errors = compileJavaSources(sources, testClasspath)
    if (errors.nonEmpty)
      fail(s"Compilation produced ${errors.size} errors:\n${errors.take(20).mkString("\n")}")
  }

  private def compileJavaSources(sources: List[(String, String)], classpath: String): List[String] = {
    val compiler = ToolProvider.getSystemJavaCompiler
    if (compiler == null) return Nil

    val tempDir = Files.createTempDirectory("monaco-compile-test").toFile
    try {
      sources.foreach { case (relPath, content) =>
        val outFile = new File(tempDir, relPath)
        outFile.getParentFile.mkdirs()
        Files.write(outFile.toPath, content.getBytes(StandardCharsets.UTF_8))
      }

      val sourceFiles  = sources.map { case (relPath, _) => new File(tempDir, relPath) }
      val diagnostics  = new DiagnosticCollector[JavaFileObject]
      val fileManager  = compiler.getStandardFileManager(diagnostics, null, StandardCharsets.UTF_8)
      val fileObjects  = fileManager.getJavaFileObjectsFromFiles(sourceFiles.asJava)
      val options      = List("-classpath", classpath, "--release", "11").asJava

      val task = compiler.getTask(null, fileManager, diagnostics, options, null, fileObjects)
      task.call()
      fileManager.close()

      diagnostics.getDiagnostics.asScala
        .filter(_.getKind == javax.tools.Diagnostic.Kind.ERROR)
        .map(d => s"${d.getSource.getName}:${d.getLineNumber}: ${d.getMessage(null)}")
        .toList
    } finally {
      deleteRecursively(tempDir)
    }
  }

  private def deleteRecursively(file: File): Unit = {
    if (file.isDirectory) file.listFiles().foreach(deleteRecursively)
    val _ = file.delete()
  }
}
