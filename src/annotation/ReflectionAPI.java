package annotation;

import java.lang.reflect.*;
/**
 * ͨ�������API��ȡ��ĸ�����Ϣ
 * ���� field
 * ����  method
 * ������ 
 * @author hc
 *
 */
public class ReflectionAPI {
	public static void main(String args[]){
		String path="Demo.User";
		try {
			Class c=Class.forName(path);
			
			
			//��ȡ����
			Field fid=c.getDeclaredField("id");
			Field[] fields=c.getDeclaredFields();
			System.out.println("��ȡ������������ĳ��ȣ�"+fields.length);
			
			for (Field field : fields) { // for each����
				System.out.println("���ԣ�"+field);
			}
			System.out.println("------�������ķָ���-------");
			//��ȡ����
			Method[] methods=c.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println("������"+method);
			}
			
			System.out.println("------�������ķָ���-------");
			//��ȡ������
			Constructor constructor3=c.getDeclaredConstructor(int.class,int.class,String.class);
			System.out.println("������ȡ��ָ����������\n"+constructor3);
			Constructor[] constructor=c.getDeclaredConstructors();
			for (Constructor constructor2 : constructor) {
				System.out.println("��������"+constructor2);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
