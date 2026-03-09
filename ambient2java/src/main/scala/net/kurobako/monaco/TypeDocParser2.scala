package net.kurobako.monaco

import scala.collection.immutable.ArraySeq

import better.files.File
import cats.syntax.all.*
import mouse.all.*
import net.kurobako.monaco.Ast.Name
import net.kurobako.monaco.Ast.Sym
import net.kurobako.monaco.TsAst.*
import net.kurobako.monaco.TsAst.TsAccessor.*
import net.kurobako.monaco.TsAst.TsAccessorKind.*
import net.kurobako.monaco.TsAst.TsEnumEntry
import net.kurobako.monaco.TsAst.TsName.*
import net.kurobako.monaco.TsAst.TsType.*
import net.kurobako.monaco.TypeDoc.ReflectionFlag
import net.kurobako.monaco.TypeDoc.ReflectionKind
import net.kurobako.monaco.TypeDoc.TypeKind
import upickle.default.*
import upickle.implicits.key

object TypeDocParser2 {

  @key("type") enum TSType derives ReadWriter {
    @key("intrinsic") case TSIntrinsicType(name: String)
    @key("inferred") case TSInferredType(name: String)
    @key("array") case TSArrayType(elementType: TSType)
    @key("union") case TSUnionType(types: List[TSType])
    @key("tuple") case TSTupleType(elements: List[TSType])
    @key("reflection") case TSReflectionType(declaration: TSReflection)
    @key("query") case TSQueryType(queryType: TSType)
    @key("indexedAccess") case TSIndexedAccessType(indexType: TSType, objectType: TSType)
    @key("intersection") case TSIntersectionType(types: List[TSType])
    @key("stringLiteral") case TSStringLiteralType(value: String)
    @key("reference") case TSReferenceType(
        name: String,
        id: Option[Int] = None,
        typeArguments: List[TSType] = Nil,
        externalUrl: Option[String] = None,
        packageName: Option[String] = None
    )
    @key("conditional") case TSConditionalType(
        checkType: TSType,
        extendsType: TSType,
        trueType: TSType,
        falseType: TSType
    )
    @key("typeParameter") case TSTypeParameterType(
        name: String,
        constraint: Option[TSType] = None,
        default: Option[TSType] = None
    )
    @key("typeOperator") case TSTypeOperatorType(
        operator: String,
        target: TSType
    )
    @key("predicate") case TSPredicateType(
        name: String,
        asserts: Boolean,
        targetType: Option[TSType] = None
    )

    @key("unknown") case TSUnknown(name: String)
  }

  case class Source(fileName: String, line: Int, character: Int) derives ReadWriter
  case class Group(title: String, kind: Int, children: List[Int]) derives ReadWriter
  case class Flags(isExported: Boolean = false, isLet: Boolean = false) derives ReadWriter
  case class Comment(shortText: Option[String] = None, text: Option[String] = None) derives ReadWriter
  case class TSReflection(
      id: Int,
      name: String,
      kind: Int,
      kindString: Option[String] = None,
      flags: Flags = Flags(),
      comment: Option[Comment] = None,
      originalName: Option[String] = None,
      children: List[TSReflection] = Nil,
      sources: List[Source] = Nil,
      signatures: List[TSReflection] = Nil,
      parameters: List[TSReflection] = Nil,
      typeParameter: List[TSReflection] = Nil,
      extendedTypes: List[TSType] = Nil,
      defaultValue: Option[String] = None,
      inheritedFrom: Option[TSType] = None,
      @key("type") tpe: Option[TSType] = None,
      groups: List[Group] = Nil
  ) derives ReadWriter {

    inline def childrenOfKind(inline kind: ReflectionKind): List[TSReflection] = children.filter(_.kind == kind.kind)
  }

  private def liftVar(r: TSReflection, enclosing: Name, src: ArraySeq[String]): ParseM[TsVariable[TsType[TsName]]] =
    for {
      meta   <- liftMeta(r)
      rawTpe <- r.tpe.otherwise("Missing var type")
      tpe    <- liftType(rawTpe, Some(meta))
    } yield TsVariable(
      name = enclosing :+ meta.name,
      id = meta.id,
      tpe = tpe,
      const = meta.enabled(ReflectionFlag.Const),
      doc = meta.docLns(src)
    )

  def liftGlobal(root: TSReflection, src: ArraySeq[String]): ParseM[TsGlobal[TsType[TsName]]] =
    for {
      meta <- liftMeta(root)
      _    <- Either.cond(
        meta.kind == ReflectionKind.Global,
        (),
        new RuntimeException(s"Expected Global, got ${meta.kind}")
      )
      name      = Name(meta.name)
      modules   = root.childrenOfKind(ReflectionKind.Module).flatMap(liftModule(_, name, src).toOption)
      variables = root.childrenOfKind(ReflectionKind.Variable).flatMap(liftVar(_, name, src).toOption)
    } yield TsGlobal(name, meta.id, modules, variables, meta.docLns(src))

  def liftMeta(r: TSReflection): ParseM[Meta] = for {
    sym  <- Sym(r.name)
    kind <- ReflectionKind(r.kind).otherwise(s"Unknown kind: ${r.kind}")
    flags =
      (r.flags.isExported ?? Set(ReflectionFlag.Exported)) ++
        (r.flags.isLet ?? Set(ReflectionFlag.Let))
  } yield Meta(
    id = r.id,
    name = sym,
    kind = kind,
    flags = flags,
    sources = r.sources.map(s => TsAst.Source(s.fileName, s.line, s.character)),
    comment = r.comment.map(c => TsAst.Comment(c.shortText, c.text))
  )

  private def liftModule(r: TSReflection, enclosing: Name, src: ArraySeq[String]): ParseM[TsModule[TsType[TsName]]] =
    for {
      meta <- liftMeta(r)
      name = enclosing :+ meta.name

      variables  = r.childrenOfKind(ReflectionKind.Variable).flatMap(liftVar(_, name, src).toOption)
      functions  = Nil // r.childrenOfKind(ReflectionKind.Function).flatMap(_.toFunction(letName, src).toOption)
      aliases    = Nil // r.childrenOfKind(ReflectionKind.TypeAlias).flatMap(_.toTypeAlias(letName, src).toOption)
      enums      = Nil // r.childrenOfKind(ReflectionKind.Enum).flatMap(_.toEnum(letName, src).toOption)
      classes    = Nil // r.childrenOfKind(ReflectionKind.Class).flatMap(_.toClass(letName, src).toOption)
      interfaces = Nil // r.childrenOfKind(ReflectionKind.Interface).flatMap(_.toInterface(letName, src).toOption)
      modules    = r.childrenOfKind(ReflectionKind.Module).flatMap(liftModule(_, name, src).toOption)

    } yield TsModule(
      name = name,
      id = meta.id,
      functions = functions,
      variables = variables,
      aliases = aliases,
      enums = enums,
      classes = classes,
      interfaces = interfaces,
      modules = modules,
      doc = meta.docLns(src)
    )

  private def liftType(js: TSType, ctx: Option[Meta]): ParseM[TsType[TsName]] = js match {
    // 1) References & generics
    case TSType.TSReferenceType(n, idOpt, args, _, _) =>
      (if (n == "object") TsTerminal(TsObject).pureF
       else Sym(n).map(s => TsTerminal(TsRef(s, idOpt))).elaborate(s"Bad sym: $n"))
        .flatMap {
          case base if args.isEmpty => base.pureF
          case base                 => args.traverse(liftType(_, ctx)).map(TsGeneric(base, _))
        }

    // 2) Intrinsics, including `this`
    case TSType.TSIntrinsicType(n) =>
      n match {
        case "string"    => Right(TsTerminal(TsString))
        case "boolean"   => Right(TsTerminal(TsBool))
        case "number"    => Right(TsTerminal(TsNum))
        case "null"      => Right(TsTerminal(TsNull))
        case "void"      => Right(TsTerminal(TsVoid))
        case "undefined" => Right(TsTerminal(TsUndef))
        case "true"      => Right(TsTerminal(TsTrue))
        case "false"     => Right(TsTerminal(TsFalse))
        case "any"       => Right(TsTerminal(TsAny))
        case "this"      =>
          ctx match {
            case Some(m) => Right(TsTerminal(TsRef(m.name, Some(m.id))))
            case None    => failF("`this` with no context")
          }
        case other => failF(s"Unknown intrinsic: $other")
      }

    // 3) Literals & unknown
    case TSType.TSStringLiteralType(v)       => Right(TsTerminal(TsStringLiteral(v)))
    case TSType.TSInferredType(n)            => failF("Shouldn't see `inferred` here")
    case TSType.TSTypeParameterType(n, _, _) =>
      Sym(n).map(s => TsTerminal(TsTypeVar(s))).elaborate(s"Bad typeParam: $n")
    case TSType.TSPredicateType(_, _, Some(t)) => liftType(t, ctx).map(TsGuard(_))
    case TSType.TSPredicateType(_, _, None)    => failF("Missing predicate target")
    case TSType.TSUnknown(n)                   => n.toIntOption
        .map(i => Right(TsTerminal(TsIntLiteral(i))))
        .getOrElse(failF(s"Should be a ${TypeKind.StringLiteral} really"))

    // 4) Structural
    case TSType.TSArrayType(e)         => liftType(e, ctx).map(TsArray(_))
    case TSType.TSUnionType(ts)        => ts.traverse(liftType(_, ctx)).map(TsUnion(_))
    case TSType.TSTupleType(es)        => es.traverse(liftType(_, ctx)).map(TsTuple(_))
    case TSType.TSIntersectionType(ts) => ts.traverse(liftType(_, ctx)).map(TsIntersection(_))

    // 5) collapse to `any`
    case TSType.TSConditionalType(_, _, _, _)
        | TSType.TSIndexedAccessType(_, _)
        | TSType.TSTypeOperatorType(_, _)
        | TSType.TSReflectionType(_) => Right(TsTerminal(TsAny))

    // 6) query
    case TSType.TSQueryType(q) => liftType(q, ctx).map(TsTypeOf(_))
  }

}
