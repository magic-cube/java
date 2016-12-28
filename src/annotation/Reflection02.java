package annotation;
/**
 * 普通方法调用，发射动态方法调用与关闭访问安全检查的反射动态方法调用的效率比较
 */
import java.lang.reflect.*;
import Demo.User;

public class Reflection02 {
	public static void test01(){
		User u1=new User();
		long startTime=System.currentTimeMillis();
		for(int i=0;i<1000000000L;i++){
			u1.getUname();
		}
		long endTime=System.currentTimeMillis();
		System.out.println("普通方法调用，执行10亿次，耗时："+(endTime-startTime)+"ms");
	}
	
	public static void test02()throws Exception{
		Class c=Class.forName("Demo.User");
		Method method=c.getDeclaredMethod("getUname", null);
		User u2=(User)c.newInstance();
		
		//method.setAccessible(true);未关闭安全访问检查
		long startTime=System.currentTimeMillis();
		for(int i=0;i<1000000000L;i++){
			method.invoke(u2, null);
		}
		long endTime=System.currentTimeMillis();
		System.out.println("反射动态方法调用，执行10亿次，耗时："+(endTime-startTime)+"ms");
		
	}
	
	public static void test03()throws Exception{
		Class c=Class.forName("Demo.User");
		Method method=c.getDeclaredMethod("getUname", null);
		User u2=(User)c.newInstance();
		
		method.setAccessible(true);//关闭安全访问检查
		long startTime=System.currentTimeMillis();
		for(int i=0;i<1000000000L;i++){
			method.invoke(u2, null);
		}
		long endTime=System.currentTimeMillis();
		System.out.println("反射动态方法调用，跳过安全检查，执行10亿次，耗时："+(endTime-startTime)+"ms");
		
	}
	public static void main(String args[])throws Exception{
		test01();
		test02();
		test03();
	}
}
