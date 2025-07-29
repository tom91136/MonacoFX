package net.kurobako.monaco

import scala.collection.immutable.ArraySeq

object TypeDoc {
	sealed abstract class ReflectionKind(val kind: Int)
	object ReflectionKind {
		case object Global extends ReflectionKind(0)
		case object ExternalModule extends ReflectionKind(1)
		case object Module extends ReflectionKind(2)
		case object Enum extends ReflectionKind(4)
		case object EnumMember extends ReflectionKind(16)
		case object Variable extends ReflectionKind(32)
		case object Function extends ReflectionKind(64)
		case object Class extends ReflectionKind(128)
		case object Interface extends ReflectionKind(256)
		case object Constructor extends ReflectionKind(512)
		case object Property extends ReflectionKind(1024)
		case object Method extends ReflectionKind(2048)
		case object CallSignature extends ReflectionKind(4096)
		case object IndexSignature extends ReflectionKind(8192)
		case object ConstructorSignature extends ReflectionKind(16384)
		case object Parameter extends ReflectionKind(32768)
		case object TypeLiteral extends ReflectionKind(65536)
		case object TypeParameter extends ReflectionKind(131072)
		case object Accessor extends ReflectionKind(262144)
		case object GetSignature extends ReflectionKind(524288)
		case object SetSignature extends ReflectionKind(1048576)
		case object ObjectLiteral extends ReflectionKind(2097152)
		case object TypeAlias extends ReflectionKind(4194304)
		case object Event extends ReflectionKind(8388608)

		case object ClassOrInterface extends ReflectionKind(Class.kind | Interface.kind)
		case object VariableOrProperty extends ReflectionKind(Variable.kind | Property.kind)
		case object FunctionOrMethod extends ReflectionKind(ReflectionKind.Function.kind | Method.kind)
		case object ClassMember extends ReflectionKind(Accessor.kind | Constructor.kind | Method.kind | Property.kind | Event.kind)
		case object SomeSignature extends ReflectionKind(CallSignature.kind | IndexSignature.kind | ConstructorSignature.kind | GetSignature.kind | SetSignature.kind)
		case object SomeModule extends ReflectionKind(Module.kind | ExternalModule.kind)
		case object SomeType extends ReflectionKind(Interface.kind | TypeLiteral.kind | TypeParameter.kind | TypeAlias.kind)
		case object SomeValue extends ReflectionKind(Variable.kind | Function.kind | ObjectLiteral.kind)
		val All   : Seq[ReflectionKind]      = ArraySeq(
			Global, ExternalModule, Module, Enum, EnumMember, Variable, Function, Class, Interface, Constructor,
			Property, Method, CallSignature, IndexSignature, ConstructorSignature, Parameter, TypeLiteral,
			TypeParameter, Accessor, GetSignature, SetSignature, ObjectLiteral, TypeAlias, Event, ClassOrInterface,
			VariableOrProperty, FunctionOrMethod, ClassMember, SomeSignature, SomeModule, SomeType, SomeValue)
		val Lookup: Map[Int, ReflectionKind] = All.map(x => x.kind -> x).toMap
		def apply(kind: Int): Option[ReflectionKind] = Lookup.get(kind)
	}

	sealed abstract class ReflectionFlag(val kind: Int, val name: String)
	object ReflectionFlag {
		case object None extends ReflectionFlag(0, "isNone")
		case object Private extends ReflectionFlag(1, "isPrivate")
		case object Protected extends ReflectionFlag(2, "isProtected")
		case object Public extends ReflectionFlag(4, "isPublic")
		case object Static extends ReflectionFlag(8, "isStatic")
		case object Exported extends ReflectionFlag(16, "isExported")
		case object ExportAssignment extends ReflectionFlag(32, "isExportAssignment")
		case object External extends ReflectionFlag(64, "isExternal")
		case object Optional extends ReflectionFlag(128, "isOptional")
		case object DefaultValue extends ReflectionFlag(256, "isDefaultValue")
		case object Rest extends ReflectionFlag(512, "isRest")
		case object ConstructorProperty extends ReflectionFlag(1024, "isConstructorProperty")
		case object Abstract extends ReflectionFlag(2048, "isAbstract")
		case object Const extends ReflectionFlag(4096, "isConst")
		case object Let extends ReflectionFlag(8192, "isLet")
		case object Readonly extends ReflectionFlag(16384, "isReadonly")
		val All   : Seq[ReflectionFlag]         = ArraySeq(
			None, Private, Protected, Public, Static, Exported, ExportAssignment, External,
			Optional, DefaultValue, Rest, ConstructorProperty, Abstract, Const, Let, Readonly)
		val Lookup: Map[String, ReflectionFlag] = All.map(x => x.name -> x).toMap
		def apply(name: String): Option[ReflectionFlag] = Lookup.get(name)
	}

	sealed abstract class TypeKind(val name: String)
	object TypeKind {
		case object Reference extends TypeKind("reference")
		case object Intrinsic extends TypeKind("intrinsic")
		case object Array extends TypeKind("array")
		case object Union extends TypeKind("union")
		case object Tuple extends TypeKind("tuple")
		case object Reflection extends TypeKind("reflection")
		case object Conditional extends TypeKind("conditional")
		case object Query extends TypeKind("query")
		case object IndexedAccess extends TypeKind("indexedAccess")
		case object TypeParameter extends TypeKind("typeParameter")
		case object TypeOperator extends TypeKind("typeOperator")
		case object Intersection extends TypeKind("intersection")
		case object Predicate extends TypeKind("predicate")
		case object StringLiteral extends TypeKind("stringLiteral")
		case object Unknown extends TypeKind("unknown")
		val All   : Seq[TypeKind]         = ArraySeq(
			Reference, Intrinsic, Array, Union, Tuple, Reflection, Conditional, Query, IndexedAccess,
			TypeParameter, TypeOperator, Intersection, Predicate, StringLiteral, Unknown)
		val Lookup: Map[String, TypeKind] = All.map(x => x.name -> x).toMap
		def apply(name: String): Option[TypeKind] = Lookup.get(name)
	}

}
