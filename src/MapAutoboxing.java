import java.util.HashMap;
import java.util.Map;
/**
 * 自动打包，解包
 * jdk1.5之后
 * 在合适的时机自动打包，解包
 * 	自动将基础类型转换成对象
 * 	自动将对象转换成基础类型
 * @author hc
 *
 */
public class MapAutoboxing {

	public static void main(String[] args) {
		Map m =new HashMap();
		//put要求放进去的是对象，jdk1.5之后支持了自动打包机制，将基础类型的1自动打包成Integer类型
		m.put("a",1);
		//unboxing  自动解包
		System.out.println(m.get("a"));
	}

}
