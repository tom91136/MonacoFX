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

  private val downloadDir = new File(targetDir, "monaco-download")
  private val typedocJson = new File(downloadDir, "typedoc-out.json")
  private val monacoDir   = new File(downloadDir, "node_modules/monaco-editor")
  private val dtsFile     = {
    val v1 = new File(monacoDir, "monaco.d.ts")
    val v2 = new File(monacoDir, "esm/vs/editor/editor.api.d.ts")
    if (v1.exists()) v1 else v2
  }

  test("Monaco download produces typedoc JSON and .d.ts file") {
    assume(typedocJson.exists(), s"TypeDoc JSON not found at $typedocJson: run 'sbt generateTypedocJson' first")
    assume(dtsFile.exists(), s"Monaco .d.ts not found under $monacoDir")
  }

  test("Monaco conversion produces Java sources without errors") {
    assume(typedocJson.exists(), s"TypeDoc JSON not found: run 'sbt generateTypedocJson' first")
    assume(dtsFile.exists(), s"Monaco .d.ts not found: run 'sbt downloadMonacoTypes' first")

    TsToJavaAst.runConversion(BFile(typedocJson.getAbsolutePath), BFile(dtsFile.getAbsolutePath)) match {
      case Left(e) =>
        fail(s"Fatal conversion error: ${e.getMessage}", e)
      case Right(Validated.Invalid(errors)) =>
        fail(s"Conversion produced ${errors.size} errors:\n${errors.toList.map(_.getMessage).mkString("\n")}")
      case Right(Validated.Valid(sources)) =>
        assert(sources.nonEmpty, "Expected generated sources to be non-empty")
        // XXX Monaco 0.55.1 produces 297 files; 250 is a conservative lower-bound
        assert(
          sources.size >= 250,
          s"Only ${sources.size} files generated: sub-namespace traversal may be broken (expected >= 250)"
        )
    }
  }

  test("Monaco conversion produces Java sources that compile") {
    assume(typedocJson.exists(), s"TypeDoc JSON not found: run 'sbt generateTypedocJson' first")
    assume(dtsFile.exists(), s"Monaco .d.ts not found: run 'sbt downloadMonacoTypes' first")

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

  // XXX assignment to typed variables catches the "everything is JSObject" regression
  private val typeCheckSnippet: (String, String) =
    "monaco_editor/MonacoApiTypeCheck.java" ->
      """package monaco_editor;
        |import monaco_editor.monaco.EditorModule;
        |import monaco_editor.monaco.editor.IStandaloneCodeEditor;
        |import monaco_editor.monaco.editor.IStandaloneEditorConstructionOptions;
        |import monaco_editor.monaco.editor.ITextModel;
        |import monaco_editor.monaco.editor.IStandaloneDiffEditor;
        |import monaco_editor.monaco.editor.IStandaloneDiffEditorConstructionOptions;
        |import monaco_editor.monaco.editor.IDiffEditorModel;
        |import netscape.javascript.JSObject;
        |/** Compile-only type-assertion class: never instantiated at runtime. */
        |@SuppressWarnings("unused")
        |class MonacoApiTypeCheck {
        |    // create() must return IStandaloneCodeEditor, not JSObject
        |    IStandaloneCodeEditor checkCreate(
        |            EditorModule ed, JSObject el, IStandaloneEditorConstructionOptions opts) {
        |        return ed.create(el, opts);
        |    }
        |    // createModel() must return ITextModel, not JSObject
        |    ITextModel checkCreateModel(EditorModule ed) {
        |        return ed.createModel("text", "javascript");
        |    }
        |    // setModel() must accept ITextModel (not renamed to setModel_ or removed)
        |    void checkSetModel(IStandaloneCodeEditor editor, ITextModel model) {
        |        editor.setModel(model);
        |    }
        |    // createDiffEditor() must return IStandaloneDiffEditor, not JSObject
        |    IStandaloneDiffEditor checkCreateDiffEditor(
        |            EditorModule ed, JSObject el, IStandaloneDiffEditorConstructionOptions opts) {
        |        return ed.createDiffEditor(el, opts);
        |    }
        |    // diff setModel() must accept IDiffEditorModel
        |    void checkDiffSetModel(IStandaloneDiffEditor diff, IDiffEditorModel model) {
        |        diff.setModel(model);
        |    }
        |}
        |""".stripMargin

  test("Monaco API has correct types (not JSObject)") {
    assume(typedocJson.exists(), s"TypeDoc JSON not found: run 'sbt generateTypedocJson' first")
    assume(dtsFile.exists(), s"Monaco .d.ts not found: run 'sbt downloadMonacoTypes' first")

    val sources = TsToJavaAst.runConversion(BFile(typedocJson.getAbsolutePath), BFile(dtsFile.getAbsolutePath)) match {
      case Right(Validated.Valid(srcs)) => srcs
      case other =>
        assume(false, s"Conversion did not succeed: $other")
        Nil
    }

    val errors = compileJavaSources(sources :+ typeCheckSnippet, testClasspath)
    if (errors.nonEmpty)
      fail(s"Type-assertion compilation failed (${errors.size} errors):\n${errors.take(20).mkString("\n")}")
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
      val options      = List("-classpath", classpath, "--release", "17").asJava

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
