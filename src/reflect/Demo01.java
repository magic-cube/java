package reflect;

import java.awt.List;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

//反射类的构造函数并创建对象，可以理解为解剖构造函数
public class Demo01 {
	
	Class clazz;
	
	@Before
	public void before() throws ClassNotFoundException{
		clazz=Class.forName("reflect.Person");
	}
	
	//反射类的构造函数
	@Test
	public void test() throws Exception{
		/*
		 * 调用了公有的无参构造器
		 */
		Constructor con1=clazz.getConstructor(null);
		Person p=(Person)con1.newInstance(null);
		System.out.println(p.name);
		
		
	}
	
	@Test
	public void test2() throws Exception{
		/*
		 * 调用了公有的有参构造器
		 */
		Constructor con1=clazz.getConstructor(String.class);
		Person p=(Person)con1.newInstance("");
	}
	
	@Test
	public void test3() throws Exception{
		/*
		 * 调用了私有的构造器
		 */
	
		Constructor con=clazz.getDeclaredConstructor(int.class);
		con.setAccessible(true);
		Person p=(Person)con.newInstance(1);
		System.out.println(p.name);
	}
	
	/*
	 * 反射创建对象的另一种方式
	 * 使用Class类的newInstance()方法
	 */
	@Test
	public void test4() throws Exception{
		//会调用无参构造器
		Person p=(Person)clazz.newInstance();
		System.out.println(p.name);
	}
}










