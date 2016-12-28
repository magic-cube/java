package annotation;
import java.lang.reflect.*;

import Demo.User;
/**
 * 通过反射API动态操作：属性，方法，构造器
 * @author 郝川
 *
 */
public class Reflection01 {
	
	public static void main(String args[]){
		String path="Demo.User";
		try {
			Class c=Class.forName(path);
			/*
			 * 动态操作构造器
			 * 通过反射拿到类的信息
			 * 之后通过newInstance（）去动态的创建这个类的对象
			 * 拿道对象以后！那还不是为所欲为？想干哈干哈
			 */
			User u=(User)c.newInstance();  //其实是调用了User的无参构造器,
			//反射被大量应用于开源框架之中，很多框架创建对象的时候都是通过newInstance的方式去创建一个对象的
			//因而JavaBean必须要有无参的构造器
			Constructor<User> con=c.getDeclaredConstructor(int.class,int.class,String.class);
			User u2=con.newInstance(1001,18,"haochuan");
			System.out.println(u2.getUname());
			
			/*
			 * 通过反射API
			 * 动态操作普通方法
			 */
			Method method02=c.getDeclaredMethod("getUname");
			User u3=(User)c.newInstance();
			//u3.setUname("郝川");//这个属于直接用对象调用，通过反射调用
			Method method01=c.getDeclaredMethod("setUname", String.class);
			method01.invoke(u3,"郝川");
			String str=(String)method02.invoke(u3);
			System.out.println(str);
			
			/*
			 * 通过反射API去动态得操作属性
			 */
			User u4=(User)c.newInstance();
			Field f=c.getDeclaredField("uname");
			//这个属性不用做安全性检查了，可以直接访问
			f.setAccessible(true);
			f.set(u4, "郝川4");//通过反射直接写属性
			System.out.println(u4.getUname());
			System.out.println(f.get(u4));//通过反射读属性
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
