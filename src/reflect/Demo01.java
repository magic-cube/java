package reflect;

import java.awt.List;
import java.lang.reflect.Constructor;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

//������Ĺ��캯�����������󣬿������Ϊ���ʹ��캯��
public class Demo01 {
	
	Class clazz;
	
	@Before
	public void before() throws ClassNotFoundException{
		clazz=Class.forName("reflect.Person");
	}
	
	//������Ĺ��캯��
	@Test
	public void test() throws Exception{
		/*
		 * �����˹��е��޲ι�����
		 */
		Constructor con1=clazz.getConstructor(null);
		Person p=(Person)con1.newInstance(null);
		System.out.println(p.name);
		
		
	}
	
	@Test
	public void test2() throws Exception{
		/*
		 * �����˹��е��вι�����
		 */
		Constructor con1=clazz.getConstructor(String.class);
		Person p=(Person)con1.newInstance("");
	}
	
	@Test
	public void test3() throws Exception{
		/*
		 * ������˽�еĹ�����
		 */
	
		Constructor con=clazz.getDeclaredConstructor(int.class);
		con.setAccessible(true);
		Person p=(Person)con.newInstance(1);
		System.out.println(p.name);
	}
	
	/*
	 * ���䴴���������һ�ַ�ʽ
	 * ʹ��Class���newInstance()����
	 */
	@Test
	public void test4() throws Exception{
		//������޲ι�����
		Person p=(Person)clazz.newInstance();
		System.out.println(p.name);
	}
}










