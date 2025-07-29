
package monaco_editor.monaco.languages.typescript;
import java.util.List;
import javax.annotation.Nonnull;
import net.kurobako.monacofx.js.JsContext;
import net.kurobako.monacofx.js.JsProxy;

/**
 * See {@code monaco.d.ts:6237:29}<br>
 * Original signature:<br>
 * {@code interface CompilerOptions  }<br>
 */
@SuppressWarnings("unused")
public class CompilerOptions extends JsProxy {

	public CompilerOptions(@Nonnull JsContext context, @Nonnull Object receiver) { super(context, receiver); }

 
	public CompilerOptions(@Nonnull JsContext context) { super(context); }

 
	/**
	 * See {@code monaco.d.ts:6238:15}<br>
	 * Original signature:<br>
	 * {@code allowJs?: boolean; }<br>
	 */
	public boolean allowJs() { return get("allowJs", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6238:15}<br>
	 * Original signature:<br>
	 * {@code allowJs?: boolean; }<br>
	 */
	public CompilerOptions allowJs(@Nonnull Boolean value) {
		set("allowJs", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6239:36}<br>
	 * Original signature:<br>
	 * {@code allowSyntheticDefaultImports?: boolean; }<br>
	 */
	public boolean allowSyntheticDefaultImports() { return get("allowSyntheticDefaultImports", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6239:36}<br>
	 * Original signature:<br>
	 * {@code allowSyntheticDefaultImports?: boolean; }<br>
	 */
	public CompilerOptions allowSyntheticDefaultImports(@Nonnull Boolean value) {
		set("allowSyntheticDefaultImports", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6240:28}<br>
	 * Original signature:<br>
	 * {@code allowUmdGlobalAccess?: boolean; }<br>
	 */
	public boolean allowUmdGlobalAccess() { return get("allowUmdGlobalAccess", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6240:28}<br>
	 * Original signature:<br>
	 * {@code allowUmdGlobalAccess?: boolean; }<br>
	 */
	public CompilerOptions allowUmdGlobalAccess(@Nonnull Boolean value) {
		set("allowUmdGlobalAccess", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6241:28}<br>
	 * Original signature:<br>
	 * {@code allowUnreachableCode?: boolean; }<br>
	 */
	public boolean allowUnreachableCode() { return get("allowUnreachableCode", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6241:28}<br>
	 * Original signature:<br>
	 * {@code allowUnreachableCode?: boolean; }<br>
	 */
	public CompilerOptions allowUnreachableCode(@Nonnull Boolean value) {
		set("allowUnreachableCode", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6242:25}<br>
	 * Original signature:<br>
	 * {@code allowUnusedLabels?: boolean; }<br>
	 */
	public boolean allowUnusedLabels() { return get("allowUnusedLabels", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6242:25}<br>
	 * Original signature:<br>
	 * {@code allowUnusedLabels?: boolean; }<br>
	 */
	public CompilerOptions allowUnusedLabels(@Nonnull Boolean value) {
		set("allowUnusedLabels", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6243:20}<br>
	 * Original signature:<br>
	 * {@code alwaysStrict?: boolean; }<br>
	 */
	public boolean alwaysStrict() { return get("alwaysStrict", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6243:20}<br>
	 * Original signature:<br>
	 * {@code alwaysStrict?: boolean; }<br>
	 */
	public CompilerOptions alwaysStrict(@Nonnull Boolean value) {
		set("alwaysStrict", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6244:15}<br>
	 * Original signature:<br>
	 * {@code baseUrl?: string; }<br>
	 */
	public String baseUrl() { return get("baseUrl", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6244:15}<br>
	 * Original signature:<br>
	 * {@code baseUrl?: string; }<br>
	 */
	public CompilerOptions baseUrl(@Nonnull String value) {
		set("baseUrl", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6245:15}<br>
	 * Original signature:<br>
	 * {@code charset?: string; }<br>
	 */
	public String charset() { return get("charset", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6245:15}<br>
	 * Original signature:<br>
	 * {@code charset?: string; }<br>
	 */
	public CompilerOptions charset(@Nonnull String value) {
		set("charset", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6246:15}<br>
	 * Original signature:<br>
	 * {@code checkJs?: boolean; }<br>
	 */
	public boolean checkJs() { return get("checkJs", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6246:15}<br>
	 * Original signature:<br>
	 * {@code checkJs?: boolean; }<br>
	 */
	public CompilerOptions checkJs(@Nonnull Boolean value) {
		set("checkJs", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6294:17}<br>
	 * Original signature:<br>
	 * {@code composite?: boolean; }<br>
	 */
	public boolean composite() { return get("composite", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6294:17}<br>
	 * Original signature:<br>
	 * {@code composite?: boolean; }<br>
	 */
	public CompilerOptions composite(@Nonnull Boolean value) {
		set("composite", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6247:19}<br>
	 * Original signature:<br>
	 * {@code declaration?: boolean; }<br>
	 */
	public boolean declaration() { return get("declaration", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6247:19}<br>
	 * Original signature:<br>
	 * {@code declaration?: boolean; }<br>
	 */
	public CompilerOptions declaration(@Nonnull Boolean value) {
		set("declaration", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6250:22}<br>
	 * Original signature:<br>
	 * {@code declarationDir?: string; }<br>
	 */
	public String declarationDir() { return get("declarationDir", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6250:22}<br>
	 * Original signature:<br>
	 * {@code declarationDir?: string; }<br>
	 */
	public CompilerOptions declarationDir(@Nonnull String value) {
		set("declarationDir", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6248:22}<br>
	 * Original signature:<br>
	 * {@code declarationMap?: boolean; }<br>
	 */
	public boolean declarationMap() { return get("declarationMap", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6248:22}<br>
	 * Original signature:<br>
	 * {@code declarationMap?: boolean; }<br>
	 */
	public CompilerOptions declarationMap(@Nonnull Boolean value) {
		set("declarationMap", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6251:24}<br>
	 * Original signature:<br>
	 * {@code disableSizeLimit?: boolean; }<br>
	 */
	public boolean disableSizeLimit() { return get("disableSizeLimit", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6251:24}<br>
	 * Original signature:<br>
	 * {@code disableSizeLimit?: boolean; }<br>
	 */
	public CompilerOptions disableSizeLimit(@Nonnull Boolean value) {
		set("disableSizeLimit", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6252:47}<br>
	 * Original signature:<br>
	 * {@code disableSourceOfProjectReferenceRedirect?: boolean; }<br>
	 */
	public boolean disableSourceOfProjectReferenceRedirect() { return get("disableSourceOfProjectReferenceRedirect", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6252:47}<br>
	 * Original signature:<br>
	 * {@code disableSourceOfProjectReferenceRedirect?: boolean; }<br>
	 */
	public CompilerOptions disableSourceOfProjectReferenceRedirect(@Nonnull Boolean value) {
		set("disableSourceOfProjectReferenceRedirect", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6253:26}<br>
	 * Original signature:<br>
	 * {@code downlevelIteration?: boolean; }<br>
	 */
	public boolean downlevelIteration() { return get("downlevelIteration", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6253:26}<br>
	 * Original signature:<br>
	 * {@code downlevelIteration?: boolean; }<br>
	 */
	public CompilerOptions downlevelIteration(@Nonnull Boolean value) {
		set("downlevelIteration", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6254:15}<br>
	 * Original signature:<br>
	 * {@code emitBOM?: boolean; }<br>
	 */
	public boolean emitBOM() { return get("emitBOM", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6254:15}<br>
	 * Original signature:<br>
	 * {@code emitBOM?: boolean; }<br>
	 */
	public CompilerOptions emitBOM(@Nonnull Boolean value) {
		set("emitBOM", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6249:27}<br>
	 * Original signature:<br>
	 * {@code emitDeclarationOnly?: boolean; }<br>
	 */
	public boolean emitDeclarationOnly() { return get("emitDeclarationOnly", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6249:27}<br>
	 * Original signature:<br>
	 * {@code emitDeclarationOnly?: boolean; }<br>
	 */
	public CompilerOptions emitDeclarationOnly(@Nonnull Boolean value) {
		set("emitDeclarationOnly", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6255:29}<br>
	 * Original signature:<br>
	 * {@code emitDecoratorMetadata?: boolean; }<br>
	 */
	public boolean emitDecoratorMetadata() { return get("emitDecoratorMetadata", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6255:29}<br>
	 * Original signature:<br>
	 * {@code emitDecoratorMetadata?: boolean; }<br>
	 */
	public CompilerOptions emitDecoratorMetadata(@Nonnull Boolean value) {
		set("emitDecoratorMetadata", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6316:23}<br>
	 * Original signature:<br>
	 * {@code esModuleInterop?: boolean; }<br>
	 */
	public boolean esModuleInterop() { return get("esModuleInterop", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6316:23}<br>
	 * Original signature:<br>
	 * {@code esModuleInterop?: boolean; }<br>
	 */
	public CompilerOptions esModuleInterop(@Nonnull Boolean value) {
		set("esModuleInterop", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6256:30}<br>
	 * Original signature:<br>
	 * {@code experimentalDecorators?: boolean; }<br>
	 */
	public boolean experimentalDecorators() { return get("experimentalDecorators", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6256:30}<br>
	 * Original signature:<br>
	 * {@code experimentalDecorators?: boolean; }<br>
	 */
	public CompilerOptions experimentalDecorators(@Nonnull Boolean value) {
		set("experimentalDecorators", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6257:40}<br>
	 * Original signature:<br>
	 * {@code forceConsistentCasingInFileNames?: boolean; }<br>
	 */
	public boolean forceConsistentCasingInFileNames() { return get("forceConsistentCasingInFileNames", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6257:40}<br>
	 * Original signature:<br>
	 * {@code forceConsistentCasingInFileNames?: boolean; }<br>
	 */
	public CompilerOptions forceConsistentCasingInFileNames(@Nonnull Boolean value) {
		set("forceConsistentCasingInFileNames", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6258:21}<br>
	 * Original signature:<br>
	 * {@code importHelpers?: boolean; }<br>
	 */
	public boolean importHelpers() { return get("importHelpers", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6258:21}<br>
	 * Original signature:<br>
	 * {@code importHelpers?: boolean; }<br>
	 */
	public CompilerOptions importHelpers(@Nonnull Boolean value) {
		set("importHelpers", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6259:23}<br>
	 * Original signature:<br>
	 * {@code inlineSourceMap?: boolean; }<br>
	 */
	public boolean inlineSourceMap() { return get("inlineSourceMap", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6259:23}<br>
	 * Original signature:<br>
	 * {@code inlineSourceMap?: boolean; }<br>
	 */
	public CompilerOptions inlineSourceMap(@Nonnull Boolean value) {
		set("inlineSourceMap", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6260:21}<br>
	 * Original signature:<br>
	 * {@code inlineSources?: boolean; }<br>
	 */
	public boolean inlineSources() { return get("inlineSources", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6260:21}<br>
	 * Original signature:<br>
	 * {@code inlineSources?: boolean; }<br>
	 */
	public CompilerOptions inlineSources(@Nonnull Boolean value) {
		set("inlineSources", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6261:23}<br>
	 * Original signature:<br>
	 * {@code isolatedModules?: boolean; }<br>
	 */
	public boolean isolatedModules() { return get("isolatedModules", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6261:23}<br>
	 * Original signature:<br>
	 * {@code isolatedModules?: boolean; }<br>
	 */
	public CompilerOptions isolatedModules(@Nonnull Boolean value) {
		set("isolatedModules", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6262:11}<br>
	 * Original signature:<br>
	 * {@code jsx?: JsxEmit; }<br>
	 */
	public JsxEmit jsx() { return get("jsx", ofJsEnum(JsxEmit.class)); }

 	/**
	 * See {@code monaco.d.ts:6262:11}<br>
	 * Original signature:<br>
	 * {@code jsx?: JsxEmit; }<br>
	 */
	public CompilerOptions jsx(@Nonnull JsxEmit value) {
		set("jsx", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6293:18}<br>
	 * Original signature:<br>
	 * {@code jsxFactory?: string; }<br>
	 */
	public String jsxFactory() { return get("jsxFactory", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6293:18}<br>
	 * Original signature:<br>
	 * {@code jsxFactory?: string; }<br>
	 */
	public CompilerOptions jsxFactory(@Nonnull String value) {
		set("jsxFactory", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6263:24}<br>
	 * Original signature:<br>
	 * {@code keyofStringsOnly?: boolean; }<br>
	 */
	public boolean keyofStringsOnly() { return get("keyofStringsOnly", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6263:24}<br>
	 * Original signature:<br>
	 * {@code keyofStringsOnly?: boolean; }<br>
	 */
	public CompilerOptions keyofStringsOnly(@Nonnull Boolean value) {
		set("keyofStringsOnly", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6264:11}<br>
	 * Original signature:<br>
	 * {@code lib?: string[]; }<br>
	 */
	public List<String> lib() { return get("lib", ofArray(ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:6264:11}<br>
	 * Original signature:<br>
	 * {@code lib?: string[]; }<br>
	 */
	public CompilerOptions lib(@Nonnull List<String> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6265:14}<br>
	 * Original signature:<br>
	 * {@code locale?: string; }<br>
	 */
	public String locale() { return get("locale", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6265:14}<br>
	 * Original signature:<br>
	 * {@code locale?: string; }<br>
	 */
	public CompilerOptions locale(@Nonnull String value) {
		set("locale", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6266:15}<br>
	 * Original signature:<br>
	 * {@code mapRoot?: string; }<br>
	 */
	public String mapRoot() { return get("mapRoot", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6266:15}<br>
	 * Original signature:<br>
	 * {@code mapRoot?: string; }<br>
	 */
	public CompilerOptions mapRoot(@Nonnull String value) {
		set("mapRoot", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6267:28}<br>
	 * Original signature:<br>
	 * {@code maxNodeModuleJsDepth?: number; }<br>
	 */
	public double maxNodeModuleJsDepth() { return get("maxNodeModuleJsDepth", ofMapped(double.class)); }

 	/**
	 * See {@code monaco.d.ts:6267:28}<br>
	 * Original signature:<br>
	 * {@code maxNodeModuleJsDepth?: number; }<br>
	 */
	public CompilerOptions maxNodeModuleJsDepth(@Nonnull Double value) {
		set("maxNodeModuleJsDepth", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6268:14}<br>
	 * Original signature:<br>
	 * {@code module?: ModuleKind; }<br>
	 */
	public ModuleKind module() { return get("module", ofJsEnum(ModuleKind.class)); }

 	/**
	 * See {@code monaco.d.ts:6268:14}<br>
	 * Original signature:<br>
	 * {@code module?: ModuleKind; }<br>
	 */
	public CompilerOptions module(@Nonnull ModuleKind value) {
		set("module", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6269:24}<br>
	 * Original signature:<br>
	 * {@code moduleResolution?: ModuleResolutionKind; }<br>
	 */
	public ModuleResolutionKind moduleResolution() { return get("moduleResolution", ofJsEnum(ModuleResolutionKind.class)); }

 	/**
	 * See {@code monaco.d.ts:6269:24}<br>
	 * Original signature:<br>
	 * {@code moduleResolution?: ModuleResolutionKind; }<br>
	 */
	public CompilerOptions moduleResolution(@Nonnull ModuleResolutionKind value) {
		set("moduleResolution", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6270:15}<br>
	 * Original signature:<br>
	 * {@code newLine?: NewLineKind; }<br>
	 */
	public NewLineKind newLine() { return get("newLine", ofJsEnum(NewLineKind.class)); }

 	/**
	 * See {@code monaco.d.ts:6270:15}<br>
	 * Original signature:<br>
	 * {@code newLine?: NewLineKind; }<br>
	 */
	public CompilerOptions newLine(@Nonnull NewLineKind value) {
		set("newLine", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6271:14}<br>
	 * Original signature:<br>
	 * {@code noEmit?: boolean; }<br>
	 */
	public boolean noEmit() { return get("noEmit", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6271:14}<br>
	 * Original signature:<br>
	 * {@code noEmit?: boolean; }<br>
	 */
	public CompilerOptions noEmit(@Nonnull Boolean value) {
		set("noEmit", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6272:21}<br>
	 * Original signature:<br>
	 * {@code noEmitHelpers?: boolean; }<br>
	 */
	public boolean noEmitHelpers() { return get("noEmitHelpers", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6272:21}<br>
	 * Original signature:<br>
	 * {@code noEmitHelpers?: boolean; }<br>
	 */
	public CompilerOptions noEmitHelpers(@Nonnull Boolean value) {
		set("noEmitHelpers", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6273:21}<br>
	 * Original signature:<br>
	 * {@code noEmitOnError?: boolean; }<br>
	 */
	public boolean noEmitOnError() { return get("noEmitOnError", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6273:21}<br>
	 * Original signature:<br>
	 * {@code noEmitOnError?: boolean; }<br>
	 */
	public CompilerOptions noEmitOnError(@Nonnull Boolean value) {
		set("noEmitOnError", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6274:25}<br>
	 * Original signature:<br>
	 * {@code noErrorTruncation?: boolean; }<br>
	 */
	public boolean noErrorTruncation() { return get("noErrorTruncation", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6274:25}<br>
	 * Original signature:<br>
	 * {@code noErrorTruncation?: boolean; }<br>
	 */
	public CompilerOptions noErrorTruncation(@Nonnull Boolean value) {
		set("noErrorTruncation", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6275:34}<br>
	 * Original signature:<br>
	 * {@code noFallthroughCasesInSwitch?: boolean; }<br>
	 */
	public boolean noFallthroughCasesInSwitch() { return get("noFallthroughCasesInSwitch", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6275:34}<br>
	 * Original signature:<br>
	 * {@code noFallthroughCasesInSwitch?: boolean; }<br>
	 */
	public CompilerOptions noFallthroughCasesInSwitch(@Nonnull Boolean value) {
		set("noFallthroughCasesInSwitch", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6276:21}<br>
	 * Original signature:<br>
	 * {@code noImplicitAny?: boolean; }<br>
	 */
	public boolean noImplicitAny() { return get("noImplicitAny", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6276:21}<br>
	 * Original signature:<br>
	 * {@code noImplicitAny?: boolean; }<br>
	 */
	public CompilerOptions noImplicitAny(@Nonnull Boolean value) {
		set("noImplicitAny", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6277:25}<br>
	 * Original signature:<br>
	 * {@code noImplicitReturns?: boolean; }<br>
	 */
	public boolean noImplicitReturns() { return get("noImplicitReturns", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6277:25}<br>
	 * Original signature:<br>
	 * {@code noImplicitReturns?: boolean; }<br>
	 */
	public CompilerOptions noImplicitReturns(@Nonnull Boolean value) {
		set("noImplicitReturns", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6278:22}<br>
	 * Original signature:<br>
	 * {@code noImplicitThis?: boolean; }<br>
	 */
	public boolean noImplicitThis() { return get("noImplicitThis", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6278:22}<br>
	 * Original signature:<br>
	 * {@code noImplicitThis?: boolean; }<br>
	 */
	public CompilerOptions noImplicitThis(@Nonnull Boolean value) {
		set("noImplicitThis", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6282:27}<br>
	 * Original signature:<br>
	 * {@code noImplicitUseStrict?: boolean; }<br>
	 */
	public boolean noImplicitUseStrict() { return get("noImplicitUseStrict", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6282:27}<br>
	 * Original signature:<br>
	 * {@code noImplicitUseStrict?: boolean; }<br>
	 */
	public CompilerOptions noImplicitUseStrict(@Nonnull Boolean value) {
		set("noImplicitUseStrict", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6283:13}<br>
	 * Original signature:<br>
	 * {@code noLib?: boolean; }<br>
	 */
	public boolean noLib() { return get("noLib", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6283:13}<br>
	 * Original signature:<br>
	 * {@code noLib?: boolean; }<br>
	 */
	public CompilerOptions noLib(@Nonnull Boolean value) {
		set("noLib", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6284:17}<br>
	 * Original signature:<br>
	 * {@code noResolve?: boolean; }<br>
	 */
	public boolean noResolve() { return get("noResolve", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6284:17}<br>
	 * Original signature:<br>
	 * {@code noResolve?: boolean; }<br>
	 */
	public CompilerOptions noResolve(@Nonnull Boolean value) {
		set("noResolve", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6279:29}<br>
	 * Original signature:<br>
	 * {@code noStrictGenericChecks?: boolean; }<br>
	 */
	public boolean noStrictGenericChecks() { return get("noStrictGenericChecks", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6279:29}<br>
	 * Original signature:<br>
	 * {@code noStrictGenericChecks?: boolean; }<br>
	 */
	public CompilerOptions noStrictGenericChecks(@Nonnull Boolean value) {
		set("noStrictGenericChecks", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6280:22}<br>
	 * Original signature:<br>
	 * {@code noUnusedLocals?: boolean; }<br>
	 */
	public boolean noUnusedLocals() { return get("noUnusedLocals", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6280:22}<br>
	 * Original signature:<br>
	 * {@code noUnusedLocals?: boolean; }<br>
	 */
	public CompilerOptions noUnusedLocals(@Nonnull Boolean value) {
		set("noUnusedLocals", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6281:26}<br>
	 * Original signature:<br>
	 * {@code noUnusedParameters?: boolean; }<br>
	 */
	public boolean noUnusedParameters() { return get("noUnusedParameters", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6281:26}<br>
	 * Original signature:<br>
	 * {@code noUnusedParameters?: boolean; }<br>
	 */
	public CompilerOptions noUnusedParameters(@Nonnull Boolean value) {
		set("noUnusedParameters", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6285:11}<br>
	 * Original signature:<br>
	 * {@code out?: string; }<br>
	 */
	public String out() { return get("out", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6285:11}<br>
	 * Original signature:<br>
	 * {@code out?: string; }<br>
	 */
	public CompilerOptions out(@Nonnull String value) {
		set("out", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6286:14}<br>
	 * Original signature:<br>
	 * {@code outDir?: string; }<br>
	 */
	public String outDir() { return get("outDir", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6286:14}<br>
	 * Original signature:<br>
	 * {@code outDir?: string; }<br>
	 */
	public CompilerOptions outDir(@Nonnull String value) {
		set("outDir", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6287:15}<br>
	 * Original signature:<br>
	 * {@code outFile?: string; }<br>
	 */
	public String outFile() { return get("outFile", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6287:15}<br>
	 * Original signature:<br>
	 * {@code outFile?: string; }<br>
	 */
	public CompilerOptions outFile(@Nonnull String value) {
		set("outFile", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6288:13}<br>
	 * Original signature:<br>
	 * {@code paths?: MapLike<string[]>; }<br>
	 */
	public MapLike<List<String>> paths() { return get("paths", MapLike ::new); }

 	/**
	 * See {@code monaco.d.ts:6288:13}<br>
	 * Original signature:<br>
	 * {@code paths?: MapLike<string[]>; }<br>
	 */
	public CompilerOptions paths(@Nonnull MapLike<List<String>> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6289:26}<br>
	 * Original signature:<br>
	 * {@code preserveConstEnums?: boolean; }<br>
	 */
	public boolean preserveConstEnums() { return get("preserveConstEnums", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6289:26}<br>
	 * Original signature:<br>
	 * {@code preserveConstEnums?: boolean; }<br>
	 */
	public CompilerOptions preserveConstEnums(@Nonnull Boolean value) {
		set("preserveConstEnums", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6290:24}<br>
	 * Original signature:<br>
	 * {@code preserveSymlinks?: boolean; }<br>
	 */
	public boolean preserveSymlinks() { return get("preserveSymlinks", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6290:24}<br>
	 * Original signature:<br>
	 * {@code preserveSymlinks?: boolean; }<br>
	 */
	public CompilerOptions preserveSymlinks(@Nonnull Boolean value) {
		set("preserveSymlinks", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6291:15}<br>
	 * Original signature:<br>
	 * {@code project?: string; }<br>
	 */
	public String project() { return get("project", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6291:15}<br>
	 * Original signature:<br>
	 * {@code project?: string; }<br>
	 */
	public CompilerOptions project(@Nonnull String value) {
		set("project", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6292:22}<br>
	 * Original signature:<br>
	 * {@code reactNamespace?: string; }<br>
	 */
	public String reactNamespace() { return get("reactNamespace", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6292:22}<br>
	 * Original signature:<br>
	 * {@code reactNamespace?: string; }<br>
	 */
	public CompilerOptions reactNamespace(@Nonnull String value) {
		set("reactNamespace", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6295:22}<br>
	 * Original signature:<br>
	 * {@code removeComments?: boolean; }<br>
	 */
	public boolean removeComments() { return get("removeComments", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6295:22}<br>
	 * Original signature:<br>
	 * {@code removeComments?: boolean; }<br>
	 */
	public CompilerOptions removeComments(@Nonnull Boolean value) {
		set("removeComments", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6312:25}<br>
	 * Original signature:<br>
	 * {@code resolveJsonModule?: boolean; }<br>
	 */
	public boolean resolveJsonModule() { return get("resolveJsonModule", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6312:25}<br>
	 * Original signature:<br>
	 * {@code resolveJsonModule?: boolean; }<br>
	 */
	public CompilerOptions resolveJsonModule(@Nonnull Boolean value) {
		set("resolveJsonModule", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6296:15}<br>
	 * Original signature:<br>
	 * {@code rootDir?: string; }<br>
	 */
	public String rootDir() { return get("rootDir", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6296:15}<br>
	 * Original signature:<br>
	 * {@code rootDir?: string; }<br>
	 */
	public CompilerOptions rootDir(@Nonnull String value) {
		set("rootDir", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6297:16}<br>
	 * Original signature:<br>
	 * {@code rootDirs?: string[]; }<br>
	 */
	public List<String> rootDirs() { return get("rootDirs", ofArray(ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:6297:16}<br>
	 * Original signature:<br>
	 * {@code rootDirs?: string[]; }<br>
	 */
	public CompilerOptions rootDirs(@Nonnull List<String> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6299:27}<br>
	 * Original signature:<br>
	 * {@code skipDefaultLibCheck?: boolean; }<br>
	 */
	public boolean skipDefaultLibCheck() { return get("skipDefaultLibCheck", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6299:27}<br>
	 * Original signature:<br>
	 * {@code skipDefaultLibCheck?: boolean; }<br>
	 */
	public CompilerOptions skipDefaultLibCheck(@Nonnull Boolean value) {
		set("skipDefaultLibCheck", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6298:20}<br>
	 * Original signature:<br>
	 * {@code skipLibCheck?: boolean; }<br>
	 */
	public boolean skipLibCheck() { return get("skipLibCheck", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6298:20}<br>
	 * Original signature:<br>
	 * {@code skipLibCheck?: boolean; }<br>
	 */
	public CompilerOptions skipLibCheck(@Nonnull Boolean value) {
		set("skipLibCheck", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6300:17}<br>
	 * Original signature:<br>
	 * {@code sourceMap?: boolean; }<br>
	 */
	public boolean sourceMap() { return get("sourceMap", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6300:17}<br>
	 * Original signature:<br>
	 * {@code sourceMap?: boolean; }<br>
	 */
	public CompilerOptions sourceMap(@Nonnull Boolean value) {
		set("sourceMap", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6301:18}<br>
	 * Original signature:<br>
	 * {@code sourceRoot?: string; }<br>
	 */
	public String sourceRoot() { return get("sourceRoot", ofMapped(String.class)); }

 	/**
	 * See {@code monaco.d.ts:6301:18}<br>
	 * Original signature:<br>
	 * {@code sourceRoot?: string; }<br>
	 */
	public CompilerOptions sourceRoot(@Nonnull String value) {
		set("sourceRoot", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6302:14}<br>
	 * Original signature:<br>
	 * {@code strict?: boolean; }<br>
	 */
	public boolean strict() { return get("strict", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6302:14}<br>
	 * Original signature:<br>
	 * {@code strict?: boolean; }<br>
	 */
	public CompilerOptions strict(@Nonnull Boolean value) {
		set("strict", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6304:27}<br>
	 * Original signature:<br>
	 * {@code strictBindCallApply?: boolean; }<br>
	 */
	public boolean strictBindCallApply() { return get("strictBindCallApply", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6304:27}<br>
	 * Original signature:<br>
	 * {@code strictBindCallApply?: boolean; }<br>
	 */
	public CompilerOptions strictBindCallApply(@Nonnull Boolean value) {
		set("strictBindCallApply", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6303:27}<br>
	 * Original signature:<br>
	 * {@code strictFunctionTypes?: boolean; }<br>
	 */
	public boolean strictFunctionTypes() { return get("strictFunctionTypes", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6303:27}<br>
	 * Original signature:<br>
	 * {@code strictFunctionTypes?: boolean; }<br>
	 */
	public CompilerOptions strictFunctionTypes(@Nonnull Boolean value) {
		set("strictFunctionTypes", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6305:24}<br>
	 * Original signature:<br>
	 * {@code strictNullChecks?: boolean; }<br>
	 */
	public boolean strictNullChecks() { return get("strictNullChecks", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6305:24}<br>
	 * Original signature:<br>
	 * {@code strictNullChecks?: boolean; }<br>
	 */
	public CompilerOptions strictNullChecks(@Nonnull Boolean value) {
		set("strictNullChecks", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6306:36}<br>
	 * Original signature:<br>
	 * {@code strictPropertyInitialization?: boolean; }<br>
	 */
	public boolean strictPropertyInitialization() { return get("strictPropertyInitialization", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6306:36}<br>
	 * Original signature:<br>
	 * {@code strictPropertyInitialization?: boolean; }<br>
	 */
	public CompilerOptions strictPropertyInitialization(@Nonnull Boolean value) {
		set("strictPropertyInitialization", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6307:21}<br>
	 * Original signature:<br>
	 * {@code stripInternal?: boolean; }<br>
	 */
	public boolean stripInternal() { return get("stripInternal", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6307:21}<br>
	 * Original signature:<br>
	 * {@code stripInternal?: boolean; }<br>
	 */
	public CompilerOptions stripInternal(@Nonnull Boolean value) {
		set("stripInternal", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6308:36}<br>
	 * Original signature:<br>
	 * {@code suppressExcessPropertyErrors?: boolean; }<br>
	 */
	public boolean suppressExcessPropertyErrors() { return get("suppressExcessPropertyErrors", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6308:36}<br>
	 * Original signature:<br>
	 * {@code suppressExcessPropertyErrors?: boolean; }<br>
	 */
	public CompilerOptions suppressExcessPropertyErrors(@Nonnull Boolean value) {
		set("suppressExcessPropertyErrors", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6309:38}<br>
	 * Original signature:<br>
	 * {@code suppressImplicitAnyIndexErrors?: boolean; }<br>
	 */
	public boolean suppressImplicitAnyIndexErrors() { return get("suppressImplicitAnyIndexErrors", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6309:38}<br>
	 * Original signature:<br>
	 * {@code suppressImplicitAnyIndexErrors?: boolean; }<br>
	 */
	public CompilerOptions suppressImplicitAnyIndexErrors(@Nonnull Boolean value) {
		set("suppressImplicitAnyIndexErrors", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6310:14}<br>
	 * Original signature:<br>
	 * {@code target?: ScriptTarget; }<br>
	 */
	public ScriptTarget target() { return get("target", ofJsEnum(ScriptTarget.class)); }

 	/**
	 * See {@code monaco.d.ts:6310:14}<br>
	 * Original signature:<br>
	 * {@code target?: ScriptTarget; }<br>
	 */
	public CompilerOptions target(@Nonnull ScriptTarget value) {
		set("target", value);
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6311:23}<br>
	 * Original signature:<br>
	 * {@code traceResolution?: boolean; }<br>
	 */
	public boolean traceResolution() { return get("traceResolution", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6311:23}<br>
	 * Original signature:<br>
	 * {@code traceResolution?: boolean; }<br>
	 */
	public CompilerOptions traceResolution(@Nonnull Boolean value) {
		set("traceResolution", value);
		return this;
	}

 	/**
	 * <p>Paths used to compute primary types search locations</p>
	 * See {@code monaco.d.ts:6315:17}<br>
	 * Original signature:<br>
	 * {@code typeRoots?: string[]; }<br>
	 */
	public List<String> typeRoots() { return get("typeRoots", ofArray(ofMapped(String.class))); }

 	/**
	 * <p>Paths used to compute primary types search locations</p>
	 * See {@code monaco.d.ts:6315:17}<br>
	 * Original signature:<br>
	 * {@code typeRoots?: string[]; }<br>
	 */
	public CompilerOptions typeRoots(@Nonnull List<String> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6313:13}<br>
	 * Original signature:<br>
	 * {@code types?: string[]; }<br>
	 */
	public List<String> types() { return get("types", ofArray(ofMapped(String.class))); }

 	/**
	 * See {@code monaco.d.ts:6313:13}<br>
	 * Original signature:<br>
	 * {@code types?: string[]; }<br>
	 */
	public CompilerOptions types(@Nonnull List<String> value) {
		
		return this;
	}

 	/**
	 * See {@code monaco.d.ts:6317:31}<br>
	 * Original signature:<br>
	 * {@code useDefineForClassFields?: boolean; }<br>
	 */
	public boolean useDefineForClassFields() { return get("useDefineForClassFields", ofMapped(boolean.class)); }

 	/**
	 * See {@code monaco.d.ts:6317:31}<br>
	 * Original signature:<br>
	 * {@code useDefineForClassFields?: boolean; }<br>
	 */
	public CompilerOptions useDefineForClassFields(@Nonnull Boolean value) {
		set("useDefineForClassFields", value);
		return this;
	}

 
}
