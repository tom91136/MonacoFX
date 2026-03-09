package net.kurobako.monaco

import scala.collection.immutable.ArraySeq

object TypeDoc {

  enum ReflectionKind(val kind: Int) {
    case Global               extends ReflectionKind(0)
    case ExternalModule       extends ReflectionKind(1)
    case Module               extends ReflectionKind(2)
    case Enum                 extends ReflectionKind(4)
    case EnumMember           extends ReflectionKind(16)
    case Variable             extends ReflectionKind(32)
    case Function             extends ReflectionKind(64)
    case Class                extends ReflectionKind(128)
    case Interface            extends ReflectionKind(256)
    case Constructor          extends ReflectionKind(512)
    case Property             extends ReflectionKind(1024)
    case Method               extends ReflectionKind(2048)
    case CallSignature        extends ReflectionKind(4096)
    case IndexSignature       extends ReflectionKind(8192)
    case ConstructorSignature extends ReflectionKind(16384)
    case Parameter            extends ReflectionKind(32768)
    case TypeLiteral          extends ReflectionKind(65536)
    case TypeParameter        extends ReflectionKind(131072)
    case Accessor             extends ReflectionKind(262144)
    case GetSignature         extends ReflectionKind(524288)
    case SetSignature         extends ReflectionKind(1048576)
    case ObjectLiteral        extends ReflectionKind(2097152)
    case TypeAlias            extends ReflectionKind(4194304)
    case Event                extends ReflectionKind(8388608)

    case ClassOrInterface   extends ReflectionKind(Class.kind | Interface.kind)
    case VariableOrProperty extends ReflectionKind(Variable.kind | Property.kind)
    case FunctionOrMethod   extends ReflectionKind(ReflectionKind.Function.kind | Method.kind)
    case ClassMember
        extends ReflectionKind(Accessor.kind | Constructor.kind | Method.kind | Property.kind | Event.kind)
    case SomeSignature extends ReflectionKind(
          CallSignature.kind | IndexSignature.kind | ConstructorSignature.kind | GetSignature.kind | SetSignature.kind
        )
    case SomeModule extends ReflectionKind(Module.kind | ExternalModule.kind)
    case SomeType   extends ReflectionKind(Interface.kind | TypeLiteral.kind | TypeParameter.kind | TypeAlias.kind)
    case SomeValue  extends ReflectionKind(Variable.kind | Function.kind | ObjectLiteral.kind)

  }
  object ReflectionKind {
    val All: Seq[ReflectionKind] = ArraySeq(
      Global,
      ExternalModule,
      Module,
      Enum,
      EnumMember,
      Variable,
      Function,
      Class,
      Interface,
      Constructor,
      Property,
      Method,
      CallSignature,
      IndexSignature,
      ConstructorSignature,
      Parameter,
      TypeLiteral,
      TypeParameter,
      Accessor,
      GetSignature,
      SetSignature,
      ObjectLiteral,
      TypeAlias,
      Event,
      ClassOrInterface,
      VariableOrProperty,
      FunctionOrMethod,
      ClassMember,
      SomeSignature,
      SomeModule,
      SomeType,
      SomeValue
    )
    val Lookup: Map[Int, ReflectionKind]         = All.map(x => x.kind -> x).toMap
    def apply(kind: Int): Option[ReflectionKind] = Lookup.get(kind)
  }

  enum ReflectionFlag(val kind: Int, val name: String) {
    case None                extends ReflectionFlag(0, "isNone")
    case Private             extends ReflectionFlag(1, "isPrivate")
    case Protected           extends ReflectionFlag(2, "isProtected")
    case Public              extends ReflectionFlag(4, "isPublic")
    case Static              extends ReflectionFlag(8, "isStatic")
    case Exported            extends ReflectionFlag(16, "isExported")
    case ExportAssignment    extends ReflectionFlag(32, "isExportAssignment")
    case External            extends ReflectionFlag(64, "isExternal")
    case Optional            extends ReflectionFlag(128, "isOptional")
    case DefaultValue        extends ReflectionFlag(256, "isDefaultValue")
    case Rest                extends ReflectionFlag(512, "isRest")
    case ConstructorProperty extends ReflectionFlag(1024, "isConstructorProperty")
    case Abstract            extends ReflectionFlag(2048, "isAbstract")
    case Const               extends ReflectionFlag(4096, "isConst")
    case Let                 extends ReflectionFlag(8192, "isLet")
    case Readonly            extends ReflectionFlag(16384, "isReadonly")
  }
  object ReflectionFlag {
    val All: Seq[ReflectionFlag] = ArraySeq(
      None,
      Private,
      Protected,
      Public,
      Static,
      Exported,
      ExportAssignment,
      External,
      Optional,
      DefaultValue,
      Rest,
      ConstructorProperty,
      Abstract,
      Const,
      Let,
      Readonly
    )
    val Lookup: Map[String, ReflectionFlag]         = All.map(x => x.name -> x).toMap
    def apply(name: String): Option[ReflectionFlag] = Lookup.get(name)
  }

  enum TypeKind(val name: String) {
    case Reference     extends TypeKind("reference")
    case Intrinsic     extends TypeKind("intrinsic")
    case Array         extends TypeKind("array")
    case Union         extends TypeKind("union")
    case Tuple         extends TypeKind("tuple")
    case Reflection    extends TypeKind("reflection")
    case Conditional   extends TypeKind("conditional")
    case Query         extends TypeKind("query")
    case IndexedAccess extends TypeKind("indexedAccess")
    case TypeParameter extends TypeKind("typeParameter")
    case TypeOperator  extends TypeKind("typeOperator")
    case Intersection  extends TypeKind("intersection")
    case Predicate     extends TypeKind("predicate")
    case StringLiteral extends TypeKind("stringLiteral")
    case Unknown       extends TypeKind("unknown")

  }
  object TypeKind {
    val All: Seq[TypeKind] = ArraySeq(
      Reference,
      Intrinsic,
      Array,
      Union,
      Tuple,
      Reflection,
      Conditional,
      Query,
      IndexedAccess,
      TypeParameter,
      TypeOperator,
      Intersection,
      Predicate,
      StringLiteral,
      Unknown
    )
    val Lookup: Map[String, TypeKind]         = All.map(x => x.name -> x).toMap
    def apply(name: String): Option[TypeKind] = Lookup.get(name)
  }

}
