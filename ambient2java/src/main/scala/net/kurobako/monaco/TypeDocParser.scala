package net.kurobako.monaco

import better.files.File
import cats.syntax.all._
import net.kurobako.monaco.Ast.{Name, Sym}
import net.kurobako.monaco.TsAst.ClassLike.{TsClass, TsInterface}
import net.kurobako.monaco.TsAst.TsAccessor._
import net.kurobako.monaco.TsAst.TsEnum.TsEnumEntry
import net.kurobako.monaco.TsAst.TsName._
import net.kurobako.monaco.TsAst.TsType._
import net.kurobako.monaco.TsAst._
import net.kurobako.monaco.TypeDoc.{ReflectionFlag, ReflectionKind, TypeKind}
import ujson.Value.Value
import ujson.{Num, StringRenderer}

import scala.collection.immutable.ArraySeq

object TypeDocParser {

	implicit class RichValue(private val v: Value) extends AnyVal {
		def ??(s: String): Option[Value] = v.objOpt.flatMap(_.get(s))
		def ??[A](s: String, f: Value => Option[A]): Option[A] = v.objOpt >>= (_.get(s)) >>= f
		def !![A](key: String, f: Value => Option[A]): ParseM[A] = (v !! key) >>= (f(_).otherwise(s"Missing `$key` for dictionary $v"))
		def !!(key: String): ParseM[Value] = for {
			obj <- v.objOpt.otherwise(s"Accessing property `$key` on non dictionary value $v")
			value <- obj.get(key).otherwise(s"Missing `$key` for dictionary $v")
		} yield value

		def intOpt: Option[Int] = v match {
			case Num(d) if d.isValidInt => d.toInt.some
			case _                      => none
		}
		def listOpt: Option[List[Value]] = v.arrOpt.map(_.toList)
		def dictOpt: Option[Map[String, Value]] = v.objOpt.map(_.toMap)

	}

	def detailed[A](value: Value, name: String)(f: => ParseM[A]): ParseM[A] = {
		f.leftMap(e => new Exception(s"Unable to parse $name: \n ${ujson.transform(value, StringRenderer(indent = 4))}", e))
	}

	def parseComment(value: Value): Option[Comment] = {
		(value ?? "comment").map(x => Comment(
			x ?? ("shortText", _.strOpt),
			x ?? ("text", _.strOpt)))
	}

	def parseTopLevel(value: Value, kind: ReflectionKind): ParseM[TopLevel] = detailed(value, "TopLevel")(for {
		id <- value !! ("id", _.intOpt)
		rawName <- value !! ("name", _.strOpt)
		name <- Sym(rawName)
		rawFlags <- value !! ("flags", _.dictOpt)
		flags <- rawFlags.toVector.traverse { case (k, v) =>
			for {
				flag <- ReflectionFlag(k).otherwise(s"Unknown flag entry $k = $v for $value")
				enabled <- v.boolOpt.otherwise(s"Expected Flag ($flag) value to be bool but got $v")
			} yield flag -> enabled
		}.map(_.toMap)
		sources <- (value ?? "sources" >>= (_.listOpt)).toList
			.flatTraverse(_.traverse { rawSource =>
				for {
					fileName <- rawSource !! ("fileName", _.strOpt)
					line <- rawSource !! ("line", _.intOpt)
					ch <- rawSource !! ("character", _.intOpt)
				} yield Source(fileName, line, ch)
			})
	} yield TopLevel(Meta(id, name, kind, flags, sources, parseComment(value)), value))


	def parseType(tpeDictName: Option[String], value: Value, ctx: Option[Meta]): ParseM[TsType[TsName]] = detailed(value, "Type")(for {
		obj <- tpeDictName match {
			case Some(x) => value !! x
			case None    => value.pureF
		}
		rawType <- obj !! ("type", _.strOpt)
		tpeKind <- TypeKind(rawType).otherwise(s"Unable to parse TypeKind $rawType")
		tpe <- tpeKind match {
			case TypeKind.Conditional   => TsTerminal(TsAny).pureF
			case TypeKind.IndexedAccess => TsTerminal(TsAny).pureF
			case TypeKind.TypeOperator  => TsTerminal(TsAny).pureF
			case TypeKind.Reflection    => TsTerminal(TsAny).pureF

			case TypeKind.Query         => parseType("queryType".some, obj, ctx).map(TsTypeOf(_))
			case TypeKind.Predicate     => parseType("targetType".some, obj, ctx).map(TsGuard(_))
			case TypeKind.Array         => parseType("elementType".some, obj, ctx).map(TsArray(_))
			case TypeKind.Union         => for (components <- obj !! ("types", _.listOpt); xs <- components.traverse(parseType(none, _, ctx))) yield TsUnion(xs)
			case TypeKind.Tuple         => for (components <- obj !! ("elements", _.listOpt); xs <- components.traverse(parseType(none, _, ctx))) yield TsTuple(xs)
			case TypeKind.Intersection  => for (types <- obj !! ("types", _.listOpt); xs <- types.traverse(parseType(none, _, ctx))) yield TsIntersection(xs)
			case TypeKind.StringLiteral => (obj !! ("value", _.strOpt)).map(TsStringLiteral(_)).map(TsTerminal(_))
			case TypeKind.TypeParameter => for (name <- obj !! ("name", _.strOpt); raw <- Sym(name)) yield TsTerminal(TsTypeVar(raw))
			case TypeKind.Unknown       => obj ?? ("name", _.strOpt) match {
				case Some(x) =>
					// try int literals first
					x.toIntOption match {
						case Some(x) => TsTerminal(TsIntLiteral(x)).pureF
						case None    => failF(s"Should be a ${TypeKind.StringLiteral} really")
					}
				case None    => failF("Unknown kind that has no name")
			}
			case TypeKind.Reference     => for {
				name <- obj !! ("name", _.strOpt)
				args = obj ?? ("typeArguments", _.listOpt)
				partial <- name match {
					case "object" => TsTerminal(TsObject).pureF
					case name     => Sym(name).map(TsRef(_, obj ?? ("id", _.intOpt))).map(TsTerminal(_))
				}
				lifted <- args match {
					case Some(xs) => xs.traverse(parseType(none, _, ctx)).map(TsGeneric(partial, _))
					case None     => (partial).pureF
				}
			} yield lifted
			case TypeKind.Intrinsic     => (obj !! ("name", _.strOpt)) >>= {
				case "string"    => TsTerminal(TsString).pureF
				case "boolean"   => TsTerminal(TsBool).pureF
				case "number"    => TsTerminal(TsNum).pureF
				case "null"      => TsTerminal(TsNull).pureF
				case "void"      => TsTerminal(TsVoid).pureF
				case "undefined" => TsTerminal(TsUndef).pureF
				case "true"      => TsTerminal(TsTrue).pureF
				case "false"     => TsTerminal(TsFalse).pureF
				case "any"       => TsTerminal(TsAny).pureF
				case "this"      => ctx match {
					case Some(meta) => TsTerminal(TsRef(meta.name, meta.id.some)).pureF
					case None       => failF(s"Type requires `this` but not context was provided for $obj")
				}
				case ""          => failF("Empty type name")
				case name        => failF(s"Unknown intrinsic type `$name`")
			}
		}
	} yield tpe)


	def parseKind(value: Value): ParseM[ReflectionKind] = {
		(value !! ("kind", _.intOpt)) >>= (rawKind => ReflectionKind(rawKind).otherwise(s"Unknown kind $rawKind for $value"))
	}

	def parseKinds[A](dictName: String, only: ReflectionKind)(v: Value)(f: TopLevel => ParseM[A]): ParseM[List[A]] =
		(v ?? (dictName, _.listOpt)).getOrElse(List.empty).traverseFilter { value =>
			parseKind(value) >>= (kind =>
				if (kind == only) parseTopLevel(value, kind).flatMap(x => f(x).map(Some(_)))
				else none.pureF)
		}

	def parseVariable(enclosing: Name, tl: TopLevel, srcLns: ArraySeq[String]): ParseM[TsVariable[TsType[TsName]]] = detailed(tl.value, "Variable") {
		parseType("type".some, tl.value, none).map { tpe =>
			TsVariable(enclosing :+ tl.meta.name, tl.meta.id, tpe, tl.meta.enabled(ReflectionFlag.Const), tl.meta.docLns(srcLns))
		}
	}

	def parseFunctionLike(enclosing: Name, tl: TopLevel,
						  name: String,
						  nameCheck: Sym => Boolean,
						  ctx: Option[Meta],
						  srcLns: ArraySeq[String]): ParseM[(Name, Meta, List[TsSignature[TsType[TsName]]], Boolean)] = detailed(tl.value, name) {
		parseKinds("signatures", ReflectionKind.CallSignature)(tl.value) { sig =>
			for {
				_ <-
					if (nameCheck(sig.meta.name)) ().pureF
					else failF("Mismatched name between TL and Signature")
				params <- parseKinds("parameters", ReflectionKind.Parameter)(sig.value) { param =>
					parseType("type".some, param.value, ctx).map(TsParameter(
						param.meta.name, _,
						param.meta.enabled(ReflectionFlag.Rest),
						param.meta.enabled(ReflectionFlag.Optional), parseComment(param.value)))
				}
				retTpe <- parseType("type".some, sig.value, ctx)
				tpeParams <- parseKinds("typeParameter", ReflectionKind.TypeParameter)(sig.value) { tp =>
					for {
						name <- (tp.value !! ("name", _.strOpt)).flatMap(Sym(_))
						bound <- (tp.value ?? "type").traverse(parseType(none, _, ctx))
					} yield name -> bound
				}
			} yield TsSignature(tpeParams, params, retTpe, sig.meta.docLns(srcLns))
		}.map((enclosing :+ tl.meta.name, tl.meta, _, (tl.value ?? "inheritedFrom").isDefined))
	}

	def parseTpeAlias(enclosing: Name, tl: TopLevel, srcLns: ArraySeq[String]): ParseM[TsTypeAlias[TsType[TsName]]] = detailed(tl.value, "TypeAlias") {
		parseType("type".some, tl.value, none).map { tpe =>
			// TODO type parameters here
			TsTypeAlias(enclosing :+ tl.meta.name, tl.meta.id, tpe, tl.meta.docLns(srcLns))
		}
	}

	def parseEnum(enclosing: Name, tl: TopLevel, srcLns: ArraySeq[String]): ParseM[TsEnum[TsType[TsName]]] = detailed(tl.value, "Enum") {
		for {
			partial <- parseKinds("children", ReflectionKind.EnumMember)(tl.value) { member =>
				(member.value !! ("defaultValue", _.strOpt)).map(v => (v, TsEnumEntry(member.meta.name, _, member.meta.docLns(srcLns))))
			}
			(_, resolved) <- partial.foldLeftM((Map[Sym, Int](), List[TsEnumEntry]())) { case ((lut, ys), (v, f)) =>
				(v.toIntOption match {
					case Some(const) => f(const).pureF
					case None        => Sym(v) >>= (lut.get(_).otherwise(s"Unknown enum reference `$v`").map(f(_)))
				}).map(x => (lut + (x.symbol -> x.ordinal), ys :+ x))
			}
		} yield TsEnum[TsType[TsName]](enclosing :+ tl.meta.name, tl.meta.id, resolved, tl.meta.docLns(srcLns))
	}


	def parseClassLike(enclosing: Name, tl: TopLevel, srcLns: ArraySeq[String]): ParseM[
		(Name,
			List[TsProperty[TsType[TsName]]],
			List[TsMethod[TsType[TsName]]],
			List[Int],
			List[ ( Sym , Option[ TsType[TsName]] )] )
	] = for {
		props <- parseKinds("children", ReflectionKind.Property)(tl.value) { prop =>
			parseType("type".some, prop.value, tl.meta.some).map(tpe =>
				TsProperty(
					prop.meta.name,
					tpe,
					prop.meta.enabled(ReflectionFlag.Readonly),
					prop.meta.enabled(ReflectionFlag.Optional),
					prop.meta.docLns(srcLns)))
		}

		methods <- parseKinds("children", ReflectionKind.Method)(tl.value) { method =>
			parseFunctionLike(enclosing, method, "Method", _ == method.meta.name, tl.meta.some, srcLns).map {
				case (_, meta, sigs, inherited) => TsMethod(meta.name, sigs, meta.enabled(ReflectionFlag.Static), meta.docLns(srcLns), inherited)
			}
		}

		parents <- (tl.value ?? ("extendedTypes", _.listOpt)).toList.flatTraverse { levels =>
			//levels.traverse(parseType(none, _, tl.meta.some))
			levels.traverse(_ !! ("id", _.intOpt))
		}

		tpeParams <- parseKinds("typeParameter", ReflectionKind.TypeParameter)(tl.value) { tp =>


			(tp.value !! ("name", _.strOpt)).flatMap(Sym(_).map(_ -> None)) // FIXME get bounds
		}

	} yield (enclosing :+ tl.meta.name, props, methods, parents, tpeParams)

	def parseClass(enclosing: Name, tl: TopLevel, srcLns: ArraySeq[String]): ParseM[TsClass[TsType[TsName]]] = detailed(tl.value, "Class") {
		for {
			ctors <- parseKinds("children", ReflectionKind.Constructor)(tl.value) { method =>
				parseFunctionLike(enclosing, method, "Constructor", _ == Sym.unsafe(s"new ${tl.meta.name}"), tl.meta.some, srcLns).map {
					case (_, _, sigs, inherited) => TsCtor(sigs, inherited)
				}
			}
			(name, props, methods, parents, tpeParams) <- parseClassLike(enclosing, tl, srcLns)

			accessors <- parseKinds("children", ReflectionKind.Accessor)(tl.value) { prop =>
				def parseAccessor(element: String) = (prop.value ?? (element, _.listOpt)).traverse {
					case x :: Nil => parseType("type".some, x, none)
					case xs       => failF(s"Expected exactly 1 get signatures, got $xs")
				}

				for {
					getter <- parseAccessor("getSignature")
					setter <- parseAccessor("setSignature")
					(tpe, kind) <- (getter, setter) match {
						case (None, None)       => failF("Missing type for getter and setter")
						case (Some(g), Some(s)) =>
							if (g != s) failF(s"Getter and setter has different types, getter = $g, setter = $s ")
							else (g -> TsGetterAndSetter).pureF
						case (Some(g), None)    => (g -> TsGetter).pureF
						case (None, Some(s))    => (s -> TsSetter).pureF
					}
				} yield TsAccessor(prop.meta.name, tpe, kind, prop.meta.docLns(srcLns))
			}

		} yield TsClass[TsType[TsName]](name, tl.meta.id, parents, tpeParams, ctors, methods, props, accessors, tl.meta.docLns(srcLns))
	}

	def parseInterface(enclosing: Name, tl: TopLevel, srcLns: ArraySeq[String]): ParseM[TsInterface[TsType[TsName]]] = detailed(tl.value, "Interface") {
		for {
			(name, props, methods, parents, tpeParams) <- parseClassLike(enclosing, tl, srcLns)
		} yield TsInterface[TsType[TsName]](name, tl.meta.id, parents, tpeParams, methods, props, tl.meta.docLns(srcLns))
	}

	def parseModule(enclosing: Name, tl: TopLevel, srcLns: ArraySeq[String]): ParseM[List[TsModule[TsType[TsName]]]] = detailed(tl.value, "Module") {
		val name = enclosing :+ tl.meta.name
		for {
			variables <- parseKinds("children", ReflectionKind.Variable)(tl.value)(parseVariable(name, _, srcLns))
			functions <- parseKinds("children", ReflectionKind.Function)(tl.value) { x =>
				parseFunctionLike(name, x, "Function", _ == x.meta.name, none, srcLns)
					.map { case (name, meta, sigs, _) => TsFunction(name, meta.id, sigs, meta.docLns(srcLns)) }
			}
			tpeAliases <- parseKinds("children", ReflectionKind.TypeAlias)(tl.value)(parseTpeAlias(name, _, srcLns))

			enums <- parseKinds("children", ReflectionKind.Enum)(tl.value)(parseEnum(name, _, srcLns))
			interfaces <- parseKinds("children", ReflectionKind.Interface)(tl.value)(parseInterface(name, _, srcLns))
			classes <- parseKinds("children", ReflectionKind.Class)(tl.value)(parseClass(name, _, srcLns))


			children <- parseKinds("children", ReflectionKind.Module)(tl.value)(parseModule(name, _, srcLns)).map(_.flatten)
			module = TsModule[TsType[TsName]](name, tl.meta.id, functions, variables, tpeAliases, enums, classes, interfaces, children, tl.meta.docLns(srcLns))
		} yield module +: children
	}

	def parseGlobal(v: Value, srcLns: ArraySeq[String]): ParseM[TsGlobal[TsType[TsName]]] = {
		def requireKind(m: Meta)(is: ReflectionKind) = if (m.kind == is) ().pureF else failF(s"Expected $is but got ${m.kind}")
		for {
			kind <- parseKind(v)
			TopLevel(meta, value) <- parseTopLevel(v, kind)
			_ <- requireKind(meta)(ReflectionKind.Global)
			name = Name(meta.name)
			modules <- parseKinds("children", ReflectionKind.Module)(value)(parseModule(name, _, srcLns))
			variables <- parseKinds("children", ReflectionKind.Variable)(value)(parseVariable(name, _, srcLns))
		} yield TsGlobal(name, meta.id, modules.flatten, variables, meta.docLns(srcLns))
	}

	def apply(typeDocAstPath: File, tsSourcePath: File): ParseM[TsGlobal[TsType[TsName]]] = for {
		tsDocAstStr <- time(s"Read: $typeDocAstPath")(Either.catchNonFatal(typeDocAstPath.contentAsString))
		tsSource <- time(s"Read: $tsSourcePath")(Either.catchNonFatal(tsSourcePath.lines.to(ArraySeq)))
		tsAst <- time("JsonAst")(Either.catchNonFatal(ujson.read(tsDocAstStr)))
		result <- time("TsAst")(parseGlobal(tsAst, tsSource))
	} yield result

}
