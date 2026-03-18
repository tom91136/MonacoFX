import java.time.Instant

def outDir = new File(project.build.directory, "generated-sources/js-types/net/kurobako/monacofx/js")
outDir.mkdirs()

def pkg = "package net.kurobako.monacofx.js;"
def now = Instant.now().toString()
def generated = """@javax.annotation.processing.Generated(value = "generate-js-types.groovy", date = "$now")"""

// --- JsFunctionN (0..4) ---

(0..4).each { n ->
    def typeParams = (0..<n).collect { "A$it" } + ["R"]
    def typeParamStr = "<${typeParams.join(', ')}>"
    def args = (0..<n).collect { "A$it a$it" }.join(', ')
    def argNames = (0..<n).collect { "a$it" }.join(', ')
    def delegateTypeParams = typeParams.join(', ')
    def objArgs = (0..<n).collect { "Object a$it" }.join(', ')
    def casts = (0..<n).collect { "(A$it) a$it" }.join(', ')
    def suppress = n >= 1 ? '\n    @SuppressWarnings("unchecked")' : ''

    def fnDoc = n == 0 ? "/** A zero-argument JS function ({@code () => R}). */" :
                n == 1 ? "/** A single-argument JS function ({@code (A0) => R}). */" :
                         "/** A ${n}-argument JS function ({@code (${(0..<n).collect { "A$it" }.join(', ')}) => R}). */"

    outDir.toPath().resolve("JsFunction${n}.java").text = """\
$pkg

$fnDoc
$generated
@FunctionalInterface
public interface JsFunction${n}${typeParamStr} extends JsFn {
    R invoke($args);

    @Override default Object wrap() { return new Delegate<>(this); }
$suppress
    class Delegate<$delegateTypeParams> implements JsFunction${n}<$delegateTypeParams> {
        private final JsFunction${n}<$delegateTypeParams> fn;
        public Delegate(JsFunction${n}<$delegateTypeParams> fn) { this.fn = fn; }
        @Override public R invoke($args) { return fn.invoke($argNames); }
        @Override public Object wrap() { return this; }
        public Object apply_(${objArgs}) { return invoke(${casts}); }
    }
}
"""
}

// --- JsUnionN (2..4) ---

(2..4).each { n ->
    def typeParams = (0..<n).collect { "T$it" }
    def typeParamStr = "<${typeParams.join(', ')}>"
    def foldParams = (0..<n).collect { "Function<? super T$it, T> ifT$it" }.join(', ')
    def foldChain = (1..<n).collect { "\n\t\t\t\t.or(() -> maybeT${it}().map(ifT${it}))" }.join('')
    def identities = (0..<n).collect { "Function.identity()" }.join(', ')

    def factories = (0..<n).collect { "\tstatic $typeParamStr JsUnion${n}$typeParamStr t${it}(T$it t$it) { return new T${it}Projection<>(t$it); }" }.join('\n')

    def accessors = (0..<n).collect { i -> """\
\tOptional<T$i> maybeT${i}();
\tdefault T$i getT${i}() { return maybeT${i}().get(); }
\tdefault boolean isT${i}() { return maybeT${i}().isPresent(); }
""" }.join('\n')

    def projections = (0..<n).collect { i ->
        def maybes = (0..<n).collect { j ->
            "\t\t@Override public Optional<T$j> maybeT${j}() { return ${j == i ? 'Optional.of(value)' : 'Optional.empty()'}; }"
        }.join('\n')
        """\
\tclass T${i}Projection<${typeParams.join(', ')}> implements JsUnion${n}<${typeParams.join(', ')}> {
\t\tprivate final T$i value;
\t\tprivate T${i}Projection(T$i value) { this.value = value; }
$maybes
\t\t@Override public String toString() { return "JsUnion${n}T${i}Projection(" + value + ')'; }
\t\t@Override public boolean equals(Object o) {
\t\t\tif (this == o) return true;
\t\t\tif (o == null || getClass() != o.getClass()) return false;
\t\t\tT${i}Projection<${(0..<n).collect { '?' }.join(', ')}> that = (T${i}Projection<${(0..<n).collect { '?' }.join(', ')}>) o;
\t\t\treturn Objects.equals(value, that.value);
\t\t}
\t\t@Override public int hashCode() { return Objects.hash(value); }
\t}"""
    }.join('\n\n')

    outDir.toPath().resolve("JsUnion${n}.java").text = """\
$pkg

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

/** A ${n}-way tagged union (TypeScript {@code ${(0..<n).collect { "T$it" }.join(' | ')}} &rarr; JS untagged value). */
$generated
@SuppressWarnings("OptionalGetWithoutIsPresent")
public interface JsUnion${n}$typeParamStr extends JsUnion {

$factories

$accessors
\tdefault <T> T fold($foldParams) {
\t\treturn maybeT0().map(ifT0)$foldChain
\t\t\t\t.orElseThrow(AssertionError::new);
\t}

\t@Override default Object unite() { return fold($identities); }

$projections
}
"""
}

// --- JsTupleN (2..4) ---

(2..4).each { n ->
    def typeParams = (0..<n).collect { "T$it" }
    def typeParamStr = "<${typeParams.join(', ')}>"
    def fields = (0..<n).collect { "\tpublic final T$it t$it;" }.join('\n')
    def ctorParams = (0..<n).collect { "T$it t$it" }.join(', ')
    def ctorAssigns = (0..<n).collect { "this.t$it = t$it;" }.join(' ')
    def getters = (0..<n).collect { "\tpublic T$it t${it}() { return t$it; }" }.join('\n')
    def elements = (0..<n).collect { "t$it" }.join(', ')
    def equalsChain = (0..<n).collect { "Objects.equals(t$it, that.t$it)" }.join(" && ")
    def hashArgs = (0..<n).collect { "t$it" }.join(', ')
    def toStringParts = (0..<n).collect { i -> i == 0 ? "t$i" : "\", \" + t$i" }.join(' + ')

    outDir.toPath().resolve("JsTuple${n}.java").text = """\
$pkg

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/** A ${n}-element tuple (TypeScript {@code [${(0..<n).collect { "T$it" }.join(', ')}]} &rarr; JS array). */
$generated
public final class JsTuple${n}$typeParamStr implements JsTuple {

$fields

\tpublic JsTuple${n}($ctorParams) { $ctorAssigns }
$getters

\t@Override public List<Object> elements() { return Arrays.asList($elements); }

\t@Override public boolean equals(Object o) {
\t\tif (this == o) return true;
\t\tif (o == null || getClass() != o.getClass()) return false;
\t\tJsTuple${n}<${(0..<n).collect { '?' }.join(', ')}> that = (JsTuple${n}<${(0..<n).collect { '?' }.join(', ')}>) o;
\t\treturn $equalsChain;
\t}
\t@Override public int hashCode() { return Objects.hash($hashArgs); }
\t@Override public String toString() { return "JsTuple${n}(" + $toStringParts + ')'; }
}
"""
}

log.info("Generated JsFunction0-4, JsUnion2-4, JsTuple2-4 into ${outDir}")
