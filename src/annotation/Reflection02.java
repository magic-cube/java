package annotation;
/**
 * ��ͨ�������ã����䶯̬����������رշ��ʰ�ȫ���ķ��䶯̬�������õ�Ч�ʱȽ�
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
		System.out.println("��ͨ�������ã�ִ��10�ڴΣ���ʱ��"+(endTime-startTime)+"ms");
	}
	
	public static void test02()throws Exception{
		Class c=Class.forName("Demo.User");
		Method method=c.getDeclaredMethod("getUname", null);
		User u2=(User)c.newInstance();
		
		//method.setAccessible(true);δ�رհ�ȫ���ʼ��
		long startTime=System.currentTimeMillis();
		for(int i=0;i<1000000000L;i++){
			method.invoke(u2, null);
		}
		long endTime=System.currentTimeMillis();
		System.out.println("���䶯̬�������ã�ִ��10�ڴΣ���ʱ��"+(endTime-startTime)+"ms");
		
	}
	
	public static void test03()throws Exception{
		Class c=Class.forName("Demo.User");
		Method method=c.getDeclaredMethod("getUname", null);
		User u2=(User)c.newInstance();
		
		method.setAccessible(true);//�رհ�ȫ���ʼ��
		long startTime=System.currentTimeMillis();
		for(int i=0;i<1000000000L;i++){
			method.invoke(u2, null);
		}
		long endTime=System.currentTimeMillis();
		System.out.println("���䶯̬�������ã�������ȫ��飬ִ��10�ڴΣ���ʱ��"+(endTime-startTime)+"ms");
		
	}
	public static void main(String args[])throws Exception{
		test01();
		test02();
		test03();
	}
}
