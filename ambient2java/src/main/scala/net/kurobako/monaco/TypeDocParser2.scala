package net.kurobako.monaco

import scala.collection.immutable.ArraySeq

import cats.syntax.all.*
import mouse.all.*
import net.kurobako.monaco.Ast.Name
import net.kurobako.monaco.Ast.Sym
import net.kurobako.monaco.TsAst.*
import net.kurobako.monaco.TsAst.TsAccessor.*
import net.kurobako.monaco.TsAst.TsAccessorKind.*
import net.kurobako.monaco.TsAst.TsName.*
import net.kurobako.monaco.TsAst.TsType.*
import net.kurobako.monaco.TypeDoc.ReflectionFlag
import upickle.default.*
import upickle.implicits.key

object TypeDocParser2 {

  private object K {
    val Project       = 1; val Namespace      = 4; val Enum             = 8
    val EnumMember    = 16; val Variable      = 32; val Function        = 64
    val Class         = 128; val Interface    = 256; val Constructor    = 512
    val Property      = 1024; val Method      = 2048; val TypeParameter = 131072
    val Accessor      = 262144; val TypeAlias = 2097152
    val CallSignature = 4096; val Parameter   = 32768
    val Reference     = 4194304
  }

  // XXX external refs (TypeDoc 0.26+) carry object targets instead of numeric ids; this index resolves them
  private var externalNameToId: Map[String, Int] = Map.empty

  // XXX root-level types indexed by id --TypeDoc emits full definitions at project root that module aliases point to
  private var rootTypeById: Map[Int, TSReflection] = Map.empty

  private def buildNameIndex(r: TSReflection): Map[String, Int] = {
    val buf                         = scala.collection.mutable.Map[String, Int]()
    def walk(n: TSReflection): Unit = {
      val k = n.kind
      if (k == K.Interface || k == K.Class || k == K.Enum || k == K.TypeAlias) {
        buf.getOrElseUpdate(n.name, n.id): Unit // XXX first occurrence wins (prefer real definitions over aliases)
      }
      n.children.foreach(walk)
    }
    walk(r)
    buf.toMap
  }

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
        id: Option[Int] = None, // TypeDoc 0.16 field
        target: Option[ujson.Value] =
          None, // TypeDoc 0.26: number (local ID) or {sourceFileName, qualifiedName} (external)
        typeArguments: List[TSType] = Nil,
        externalUrl: Option[String] = None,
        packageName: Option[String] = None,
        refersToTypeParameter: Boolean = false
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
    @key("namedTupleMember") case TSNamedTupleMemberType(
        element: TSType,
        name: String,
        isOptional: Boolean = false
    )
    @key("literal") case TSLiteralType(value: ujson.Value)
    @key("mapped") case TSMappedType(
        parameter: String = "",
        parameterType: Option[TSType] = None,
        templateType: Option[TSType] = None,
        readonlyModifier: Option[String] = None,
        optionalModifier: Option[String] = None
    )
    @key("unknown") case TSUnknown(name: String)
  }

  case class Source(fileName: String, line: Int, character: Int) derives ReadWriter
  case class Group(title: String, kind: Option[Int] = None, children: List[Int] = Nil) derives ReadWriter

  case class Flags(
      isPrivate: Boolean = false,
      isProtected: Boolean = false,
      isPublic: Boolean = false,
      isStatic: Boolean = false,
      isExported: Boolean = false,
      isOptional: Boolean = false,
      isRest: Boolean = false,
      isConst: Boolean = false,
      isReadonly: Boolean = false,
      isAbstract: Boolean = false,
      isLet: Boolean = false
  ) derives ReadWriter

  case class CommentContent(kind: String, text: String) derives ReadWriter
  case class Comment(
      shortText: Option[String] = None,   // TypeDoc 0.16
      text: Option[String] = None,        // TypeDoc 0.16
      summary: List[CommentContent] = Nil // TypeDoc 0.25+
  ) derives ReadWriter

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
      implementedTypes: List[TSType] = Nil,
      defaultValue: Option[String] = None,
      inheritedFrom: Option[TSType] = None,
      @key("type") tpe: Option[TSType] = None,
      groups: List[Group] = Nil,
      getSignature: Option[TSReflection] = None,
      setSignature: Option[TSReflection] = None,
      target: Option[ujson.Value] = None
  ) derives ReadWriter {

    def childrenOfKind(kind: Int): List[TSReflection] = children.filter(_.kind == kind)
  }

  def liftMeta(r: TSReflection): ParseM[Meta] = for {
    sym <- Sym(r.name)
    flags =
      (r.flags.isPrivate ?? Set(ReflectionFlag.Private)) ++
        (r.flags.isProtected ?? Set(ReflectionFlag.Protected)) ++
        (r.flags.isPublic ?? Set(ReflectionFlag.Public)) ++
        (r.flags.isStatic ?? Set(ReflectionFlag.Static)) ++
        (r.flags.isExported ?? Set(ReflectionFlag.Exported)) ++
        (r.flags.isOptional ?? Set(ReflectionFlag.Optional)) ++
        (r.flags.isRest ?? Set(ReflectionFlag.Rest)) ++
        (r.flags.isConst ?? Set(ReflectionFlag.Const)) ++
        (r.flags.isReadonly ?? Set(ReflectionFlag.Readonly)) ++
        (r.flags.isAbstract ?? Set(ReflectionFlag.Abstract)) ++
        (r.flags.isLet ?? Set(ReflectionFlag.Let))
    comment = r.comment.map { c =>
      val summaryText = c.summary.map(_.text).mkString
      val mainText    = c.shortText.orElse(Option.when(summaryText.nonEmpty)(summaryText))
      TsAst.Comment(mainText, c.text)
    }
  } yield Meta(
    id = r.id,
    name = sym,
    flags = flags,
    sources = r.sources.map(s => TsAst.Source(s.fileName, s.line, s.character)),
    comment = comment
  )

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

  private def liftSignature(
      r: TSReflection,
      ctx: Option[Meta],
      src: ArraySeq[String]
  ): ParseM[List[TsSignature[TsType[TsName]]]] =
    r.signatures.traverse { sig =>
      for {
        sigMeta <- liftMeta(sig)
        params  <- sig.parameters.traverse { param =>
          for {
            paramMeta <- liftMeta(param)
            rawTpe    <- param.tpe.otherwise(s"Missing type for parameter ${param.name}")
            tpe       <- liftType(rawTpe, ctx)
          } yield TsParameter(
            paramMeta.name,
            tpe,
            paramMeta.enabled(ReflectionFlag.Rest),
            paramMeta.enabled(ReflectionFlag.Optional),
            paramMeta.comment
          )
        }
        rawRetTpe <- sig.tpe.otherwise(s"Missing return type for signature ${sig.name}")
        retTpe    <- liftType(rawRetTpe, ctx)
        tpeParams <- sig.typeParameter.traverse { tp =>
          for {
            tpMeta <- liftMeta(tp)
            bound  <- tp.tpe.traverse(liftType(_, ctx))
          } yield tpMeta.name -> bound
        }
      } yield TsSignature(tpeParams, params, retTpe, sigMeta.docLns(src))
    }

  private def liftFunction(
      r: TSReflection,
      enclosing: Name,
      src: ArraySeq[String]
  ): ParseM[TsFunction[TsType[TsName]]] =
    for {
      meta <- liftMeta(r)
      sigs <- liftSignature(r, None, src)
    } yield TsFunction(enclosing :+ meta.name, meta.id, sigs, meta.docLns(src))

  private def liftTypeAlias(
      r: TSReflection,
      enclosing: Name,
      src: ArraySeq[String]
  ): ParseM[TsTypeAlias[TsType[TsName]]] =
    for {
      meta   <- liftMeta(r)
      rawTpe <- r.tpe.otherwise("Missing type alias type")
      tpe    <- liftType(rawTpe, None)
    } yield TsTypeAlias(enclosing :+ meta.name, meta.id, tpe, meta.docLns(src))

  private def liftEnum(
      r: TSReflection,
      enclosing: Name,
      src: ArraySeq[String]
  ): ParseM[TsEnum[TsType[TsName]]] =
    for {
      meta    <- liftMeta(r)
      partial <- r.childrenOfKind(K.EnumMember).traverse { member =>
        liftMeta(member).flatMap { memberMeta =>
          // XXX TypeDoc 0.25 uses defaultValue; 0.26+ uses type.value (literal type)
          val value = member.defaultValue.orElse(member.tpe.collect {
            case TSType.TSLiteralType(v) => v.toString.stripPrefix("\"").stripSuffix("\"")
          })
          value
            .otherwise(s"Missing defaultValue for enum member ${member.name}")
            .map(v => (v, (ordinal: Int) => TsEnumEntry(memberMeta.name, ordinal, memberMeta.docLns(src))))
        }
      }
      (_, resolved) <- partial.foldLeftM((Map[Sym, Int](), List[TsEnumEntry]())) {
        case ((lut, ys), (v, f)) =>
          (v.toIntOption match {
            case Some(const) => f(const).pureF
            case None        => Sym(v) >>= (lut.get(_).otherwise(s"Unknown enum reference `$v`").map(f))
          }).map(x => (lut + (x.symbol -> x.ordinal), ys :+ x))
      }
    } yield TsEnum[TsType[TsName]](enclosing :+ meta.name, meta.id, resolved, meta.docLns(src))

  private def liftAccessor(
      r: TSReflection,
      enclosing: Name,
      ctx: Option[Meta],
      src: ArraySeq[String]
  ): ParseM[TsAccessor[TsType[TsName]]] =
    for {
      meta   <- liftMeta(r)
      getter <-
        r.getSignature.traverse(sig => sig.tpe.otherwise("Missing getter return type").flatMap(liftType(_, ctx)))
      setter      <- r.setSignature.traverse(sig => sig.tpe.otherwise("Missing setter type").flatMap(liftType(_, ctx)))
      (tpe, kind) <- (getter, setter) match {
        case (None, None)       => failF("Missing type for both getter and setter")
        case (Some(g), Some(s)) =>
          if (g != s) failF(s"Getter and setter have different types: getter=$g, setter=$s")
          else (g -> TsGetterAndSetter).pureF
        case (Some(g), None) => (g -> TsGetter).pureF
        case (None, Some(s)) => (s -> TsSetter).pureF
      }
    } yield TsAccessor(meta.name, tpe, kind, meta.docLns(src))

  private def liftClassLike(r: TSReflection, enclosing: Name, src: ArraySeq[String]): ParseM[
    (
        Name,
        List[TsProperty[TsType[TsName]]],
        List[TsMethod[TsType[TsName]]],
        List[Int],
        List[(Sym, Option[TsType[TsName]])]
    )
  ] =
    for {
      meta <- liftMeta(r)
      name = enclosing :+ meta.name

      props <- r.childrenOfKind(K.Property).traverse { prop =>
        for {
          propMeta <- liftMeta(prop)
          rawTpe   <- prop.tpe.otherwise(s"Missing type for property ${prop.name}")
          tpe      <- liftType(rawTpe, Some(meta))
        } yield TsProperty(
          propMeta.name,
          tpe,
          propMeta.enabled(ReflectionFlag.Readonly),
          propMeta.enabled(ReflectionFlag.Optional),
          propMeta.docLns(src)
        )
      }

      methods <- r.childrenOfKind(K.Method).traverse { method =>
        for {
          methodMeta <- liftMeta(method)
          sigs       <- liftSignature(method, Some(meta), src)
        } yield TsMethod(
          methodMeta.name,
          sigs,
          methodMeta.enabled(ReflectionFlag.Static),
          methodMeta.docLns(src),
          method.inheritedFrom.isDefined
        )
      }

      parents = r.extendedTypes.collect {
        case TSType.TSReferenceType(_, Some(id), _, _, _, _, _)              => id
        case TSType.TSReferenceType(_, None, Some(ujson.Num(n)), _, _, _, _) => n.toInt
      }

      tpeParams <- r.typeParameter.traverse { tp =>
        for {
          tpMeta <- liftMeta(tp)
          bound  <- tp.tpe.traverse(liftType(_, Some(meta)))
        } yield tpMeta.name -> bound
      }
    } yield (name, props, methods, parents, tpeParams)

  private def liftClass(
      r: TSReflection,
      enclosing: Name,
      src: ArraySeq[String]
  ): ParseM[TsClass[TsType[TsName]]] =
    for {
      meta                                       <- liftMeta(r)
      (name, props, methods, parents, tpeParams) <- liftClassLike(r, enclosing, src)
      ctors                                      <- r.childrenOfKind(K.Constructor).traverse { ctor =>
        liftSignature(ctor, Some(meta), src).map(sigs => TsCtor(sigs, ctor.inheritedFrom.isDefined))
      }
      accessors <- r.childrenOfKind(K.Accessor).traverse(liftAccessor(_, enclosing, Some(meta), src))
    } yield TsClass[TsType[TsName]](
      name,
      meta.id,
      parents,
      tpeParams,
      ctors,
      methods,
      props,
      accessors,
      meta.docLns(src)
    )

  private def liftInterface(
      r: TSReflection,
      enclosing: Name,
      src: ArraySeq[String]
  ): ParseM[TsInterface[TsType[TsName]]] =
    for {
      meta                                       <- liftMeta(r)
      (name, props, methods, parents, tpeParams) <- liftClassLike(r, enclosing, src)
      // XXX callable interfaces (IEvent, ICommandHandler, etc.) have top-level call signatures
      callSigs <- r.signatures.filter(_.kind == K.CallSignature).traverse { sig =>
        for {
          sigMeta <- liftMeta(sig)
          params  <- sig.parameters.traverse { param =>
            for {
              paramMeta <- liftMeta(param)
              rawTpe    <- param.tpe.otherwise(s"Missing type for call sig parameter ${param.name}")
              tpe       <- liftType(rawTpe, Some(meta))
            } yield TsParameter(
              paramMeta.name,
              tpe,
              paramMeta.enabled(ReflectionFlag.Rest),
              paramMeta.enabled(ReflectionFlag.Optional),
              paramMeta.comment
            )
          }
          rawRetTpe <- sig.tpe.otherwise(s"Missing return type for call signature")
          retTpe    <- liftType(rawRetTpe, Some(meta))
          tpeParams <- sig.typeParameter.traverse { tp =>
            for {
              tpMeta <- liftMeta(tp)
              bound  <- tp.tpe.traverse(liftType(_, Some(meta)))
            } yield tpMeta.name -> bound
          }
        } yield TsSignature(tpeParams, params, retTpe, sigMeta.docLns(src))
      }
    } yield TsInterface[TsType[TsName]](name, meta.id, parents, tpeParams, methods, props, meta.docLns(src), callSigs)

  private def isExternalAlias(r: TSReflection): Boolean =
    r.tpe.exists {
      case TSType.TSReferenceType(_, _, Some(ujson.Obj(_)), _, _, _, _) => true
      case _                                                            => false
    }

  private def aliasToInterface(
      r: TSReflection,
      enclosing: Name,
      src: ArraySeq[String]
  ): Option[TsInterface[TsType[TsName]]] =
    liftMeta(r).toOption.map { meta =>
      TsInterface[TsType[TsName]](enclosing :+ meta.name, meta.id, Nil, Nil, Nil, Nil, meta.docLns(src))
    }

  private def liftModule(r: TSReflection, enclosing: Name, src: ArraySeq[String]): ParseM[TsModule[TsType[TsName]]] =
    for {
      meta <- liftMeta(r)
      // XXX Monaco 0.55+ exports root namespace as "m"; map back to "monaco" for Java package names
      resolvedName = if (meta.name.value == "m") Sym.unsafe("monaco") else meta.name
      name         = enclosing :+ resolvedName

      variables      = r.childrenOfKind(K.Variable).flatMap(liftVar(_, name, src).toOption)
      functions      = r.childrenOfKind(K.Function).flatMap(liftFunction(_, name, src).toOption)
      allTypeAliases = r.childrenOfKind(K.TypeAlias)
      enums          = r.childrenOfKind(K.Enum).flatMap(liftEnum(_, name, src).toOption)
      classes        = r.childrenOfKind(K.Class).flatMap(liftClass(_, name, src).toOption)
      realInterfaces = r.childrenOfKind(K.Interface).flatMap(liftInterface(_, name, src).toOption)
      modules        = r.childrenOfKind(K.Namespace).flatMap(liftModule(_, name, src).toOption)

      localNames = (realInterfaces.map(_.name.sym) ++ classes.map(_.name.sym) ++ enums.map(_.name.sym)).toSet
      (rootResolvable, remainingAliases) = allTypeAliases.partition { a =>
        Sym(a.name).exists(s => !localNames.contains(s)) &&
        a.tpe.exists {
          case TSType.TSReferenceType(_, _, Some(ujson.Num(tid)), _, _, _, _) => rootTypeById.contains(tid.toInt)
          case _                                                              => false
        }
      }
      (externalAliases, normalAliasReflections) =
        remainingAliases.partition(a => isExternalAlias(a) && Sym(a.name).exists(s => !localNames.contains(s)))
      aliases        = normalAliasReflections.flatMap(liftTypeAlias(_, name, src).toOption)
      stubInterfaces = externalAliases.flatMap(aliasToInterface(_, name, src))
      rootInterfaces = rootResolvable.flatMap { a =>
        val targetId = a.tpe.collect {
          case TSType.TSReferenceType(_, _, Some(ujson.Num(tid)), _, _, _, _) => tid.toInt
        }
        targetId.flatMap(rootTypeById.get).flatMap { rootRefl =>
          rootRefl.kind match {
            case K.Interface => liftInterface(rootRefl, name, src).toOption
            case K.Class     => liftClass(rootRefl, name, src).toOption.map(c =>
                TsInterface[TsType[TsName]](
                  name :+ Sym.unsafe(a.name),
                  c.id,
                  c.parents,
                  c.typeParams,
                  c.methods,
                  c.properties,
                  c.doc
                )
              )
            case _ => None
          }
        }
      }
      referenceInterfaces = r.childrenOfKind(K.Reference).flatMap { ref =>
        val refName = Sym(ref.name)
        if (refName.exists(localNames.contains)) None
        else ref.target.collect { case n: ujson.Num => n.value.toInt }
          .flatMap(rootTypeById.get).flatMap { rootRefl =>
            val refFullName = name :+ Sym.unsafe(ref.name)
            rootRefl.kind match {
              case K.Interface => liftInterface(rootRefl, name, src).toOption.map(i =>
                  i.copy(name = refFullName)
                )
              case K.Class => liftClass(rootRefl, name, src).toOption.map(c =>
                  TsInterface[TsType[TsName]](
                    refFullName,
                    c.id,
                    c.parents,
                    c.typeParams,
                    c.methods,
                    c.properties,
                    c.doc
                  )
                )
              case _ => None
            }
          }
      }
      interfaces = realInterfaces ++ stubInterfaces ++ rootInterfaces ++ referenceInterfaces

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

  def liftGlobal(root: TSReflection, src: ArraySeq[String]): ParseM[TsGlobal[TsType[TsName]]] = {
    externalNameToId = buildNameIndex(root)
    rootTypeById = root.children
      .filter(c => c.kind == K.Interface || c.kind == K.Class || c.kind == K.Enum)
      .map(c => c.id -> c).toMap
    if (rootTypeById.nonEmpty)
      System.err.println(s"Root type index: ${rootTypeById.size} interfaces/classes/enums at project root")
    for {
      _ <- Either.cond(
        root.kind == K.Project,
        (),
        new RuntimeException(s"Expected Project (kind=${K.Project}), got kind=${root.kind}")
      )
      meta <- liftMeta(root)
      name      = Name(meta.name)
      modules   = root.childrenOfKind(K.Namespace).flatMap(liftModule(_, name, src).toOption)
      variables = root.childrenOfKind(K.Variable).flatMap(liftVar(_, name, src).toOption)

    } yield TsGlobal(name, meta.id, modules, variables, meta.docLns(src))
  }

  private def liftType(js: TSType, ctx: Option[Meta]): ParseM[TsType[TsName]] = js match {
    case TSType.TSReferenceType(n, id, target, args, _, _, refersToTypeParam) =>
      // XXX id = TypeDoc 0.16; target = TypeDoc 0.26 (number = local, object = external -> fall back to name index)
      val idOpt: Option[Int] = id.orElse(target.collect { case ujson.Num(n) => n.toInt })
        .orElse(target.collect { case _: ujson.Obj => () }.flatMap(_ => externalNameToId.get(n)))
      (if (refersToTypeParam) Sym(n).map(s => TsTerminal(TsTypeVar(s))).elaborate(s"Bad typeParam ref: $n")
       else if (n == "object") TsTerminal(TsObject).pureF
       else Sym(n).map(s => TsTerminal(TsRef(s, idOpt))).elaborate(s"Bad sym: $n"))
        .flatMap {
          case base if args.isEmpty => base.pureF
          case base                 => args.traverse(liftType(_, ctx)).map(TsGeneric(base, _))
        }

    case TSType.TSIntrinsicType(n) =>
      n match {
        case "string"                               => Right(TsTerminal(TsString))
        case "boolean"                              => Right(TsTerminal(TsBool))
        case "number"                               => Right(TsTerminal(TsNum))
        case "null"                                 => Right(TsTerminal(TsNull))
        case "void"                                 => Right(TsTerminal(TsVoid))
        case "undefined"                            => Right(TsTerminal(TsUndef))
        case "true"                                 => Right(TsTerminal(TsTrue))
        case "false"                                => Right(TsTerminal(TsFalse))
        case "any" | "unknown" | "never" | "object" => Right(TsTerminal(TsAny))
        case "this"                                 =>
          ctx match {
            case Some(m) => Right(TsTerminal(TsRef(m.name, Some(m.id))))
            case None    => failF("`this` with no context")
          }
        case other => failF(s"Unknown intrinsic: $other")
      }

    case TSType.TSStringLiteralType(v)       => Right(TsTerminal(TsStringLiteral(v)))
    case TSType.TSLiteralType(ujson.Str(s))  => Right(TsTerminal(TsStringLiteral(s)))
    case TSType.TSLiteralType(ujson.Num(n))  => Right(TsTerminal(TsIntLiteral(n.toInt)))
    case TSType.TSLiteralType(ujson.Bool(b)) => Right(TsTerminal(if (b) TsTrue else TsFalse))
    case TSType.TSLiteralType(ujson.Null)    => Right(TsTerminal(TsNull))
    case TSType.TSLiteralType(other)         => failF(s"Unsupported literal value: $other")
    case TSType.TSInferredType(_)            => failF("Shouldn't see `inferred` here")
    case TSType.TSTypeParameterType(n, _, _) =>
      Sym(n).map(s => TsTerminal(TsTypeVar(s))).elaborate(s"Bad typeParam: $n")
    case TSType.TSPredicateType(_, _, Some(t)) => liftType(t, ctx).map(TsGuard(_))
    case TSType.TSPredicateType(_, _, None)    => failF("Missing predicate target")
    case TSType.TSUnknown(n)                   => n.toIntOption
        .map(i => Right(TsTerminal(TsIntLiteral(i))))
        .getOrElse(failF(s"Should be a stringLiteral really"))

    case TSType.TSArrayType(e)                     => liftType(e, ctx).map(TsArray(_))
    case TSType.TSUnionType(ts)                    => ts.traverse(liftType(_, ctx)).map(TsUnion(_))
    case TSType.TSTupleType(es)                    => es.traverse(liftType(_, ctx)).map(TsTuple(_))
    case TSType.TSIntersectionType(ts)             => ts.traverse(liftType(_, ctx)).map(TsIntersection(_))
    case TSType.TSNamedTupleMemberType(elem, _, _) => liftType(elem, ctx)

    // `readonly T[]` -- unwrap the operator and lift the inner array type
    case TSType.TSTypeOperatorType("readonly", inner) => liftType(inner, ctx)
    // `keyof T` and other type operators we can't represent -- fall through to TsAny
    case TSType.TSConditionalType(_, _, _, _)
        | TSType.TSIndexedAccessType(_, _)
        | TSType.TSTypeOperatorType(_, _)
        | TSType.TSMappedType(_, _, _, _, _)
        | TSType.TSReflectionType(_) => Right(TsTerminal(TsAny))

    case TSType.TSQueryType(q) => liftType(q, ctx).map(TsTypeOf(_))
  }

}
