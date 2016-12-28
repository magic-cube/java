package annotation;
import java.lang.reflect.*;

import Demo.User;
/**
 * ͨ������API��̬���������ԣ�������������
 * @author �´�
 *
 */
public class Reflection01 {
	
	public static void main(String args[]){
		String path="Demo.User";
		try {
			Class c=Class.forName(path);
			/*
			 * ��̬����������
			 * ͨ�������õ������Ϣ
			 * ֮��ͨ��newInstance����ȥ��̬�Ĵ��������Ķ���
			 * �õ������Ժ��ǻ�����Ϊ����Ϊ����ɹ��ɹ�
			 */
			User u=(User)c.newInstance();  //��ʵ�ǵ�����User���޲ι�����,
			//���䱻����Ӧ���ڿ�Դ���֮�У��ܶ��ܴ��������ʱ����ͨ��newInstance�ķ�ʽȥ����һ�������
			//���JavaBean����Ҫ���޲εĹ�����
			Constructor<User> con=c.getDeclaredConstructor(int.class,int.class,String.class);
			User u2=con.newInstance(1001,18,"haochuan");
			System.out.println(u2.getUname());
			
			/*
			 * ͨ������API
			 * ��̬������ͨ����
			 */
			Method method02=c.getDeclaredMethod("getUname");
			User u3=(User)c.newInstance();
			//u3.setUname("�´�");//�������ֱ���ö�����ã�ͨ���������
			Method method01=c.getDeclaredMethod("setUname", String.class);
			method01.invoke(u3,"�´�");
			String str=(String)method02.invoke(u3);
			System.out.println(str);
			
			/*
			 * ͨ������APIȥ��̬�ò�������
			 */
			User u4=(User)c.newInstance();
			Field f=c.getDeclaredField("uname");
			//������Բ�������ȫ�Լ���ˣ�����ֱ�ӷ���
			f.setAccessible(true);
			f.set(u4, "�´�4");//ͨ������ֱ��д����
			System.out.println(u4.getUname());
			System.out.println(f.get(u4));//ͨ�����������
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
