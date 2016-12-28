package annotation;

import java.lang.reflect.*;
/**
 * 通过反射的API获取类的各种信息
 * 属性 field
 * 方法  method
 * 构造器 
 * @author hc
 *
 */
public class ReflectionAPI {
	public static void main(String args[]){
		String path="Demo.User";
		try {
			Class c=Class.forName(path);
			
			
			//获取属性
			Field fid=c.getDeclaredField("id");
			Field[] fields=c.getDeclaredFields();
			System.out.println("获取到的属性数组的长度："+fields.length);
			
			for (Field field : fields) { // for each遍历
				System.out.println("属性："+field);
			}
			System.out.println("------华丽丽的分割线-------");
			//获取方法
			Method[] methods=c.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println("方法："+method);
			}
			
			System.out.println("------华丽丽的分割线-------");
			//获取构造器
			Constructor constructor3=c.getDeclaredConstructor(int.class,int.class,String.class);
			System.out.println("单独获取的指定构造器：\n"+constructor3);
			Constructor[] constructor=c.getDeclaredConstructors();
			for (Constructor constructor2 : constructor) {
				System.out.println("构造器："+constructor2);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
