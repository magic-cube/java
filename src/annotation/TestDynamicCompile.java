package annotation;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * ≤‚ ‘∂ØÃ¨±‡“Î
 * 
 * @author hc
 *
 */
public class TestDynamicCompile {
	public static void main(String args[]){
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
		int result=compiler.run(null, null, null, "c:/my/HelloWorld.java");
		System.out.println(result==0?"±‡“Î≥…π¶£°":"±‡“Î ß∞‹£°");
	}
}
