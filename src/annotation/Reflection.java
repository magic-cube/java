package annotation;
/**
 * 反射
 * reflection
 * 通过反射动态得获取类的信息
 * 当一个class被加载时，JVM便自动产生一个class对象,这个对象包含了完整的类的结构信息
 * @author hc
 *
 */
public class Reflection {
	
	//@SuppressWarnings("all")
	public static void main(String args[]){
		String path="annotation.Demo01";
		try {
			//Class.forName("完整类名")的形式
			Class c=Class.forName(path);
			System.out.println(c);
			//类字面常量形式     完整类名.class
			Class c2=Demo.MapDemo1.class;
			System.out.println(c2);
			
			//javase5中Class<?>要优于平凡的class，虽然两者等价
			//向Class添加泛型语法的原因仅仅是为了提供编译器类型检查
			Class<?> c3=Demo.MapDemo2.class;
			System.out.println(c3.hashCode());
			
			
			Class<?> strClass=path.getClass();
			Class<?> strClass2=String.class;
			System.out.println("两个Class对象是否为同一对象？    "+(strClass==strClass2));
			
			
			Class intClass=int.class;
			
			System.out.println("分析测试数组的Class对象");
			//以维度区分
			int[] arr01=new int[10];
			int[] arr02=new int[30];
			int[][] arr03=new int[10][10];
			System.out.println(arr01.getClass().hashCode());
			System.out.println(arr02.getClass().hashCode());
			System.out.println(arr03.getClass().hashCode());
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
