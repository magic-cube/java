/*
 * ��������Ĳ�νṹ
 * �����߼��ϵĸ��ӹ�ϵ�����ڲ��������Լ̳е���ʽʵ�֣���������ϵķ�ʽ
 */
public class ClassLoader02 {
	public static void main(String args[]){
		System.out.println("��������Ĳ�νṹ");
		//AppClassLoader
		System.out.println(ClassLoader.getSystemClassLoader());
		//ExtClassLoader
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		//��Ϊ���������������ԭ������д�ģ����java��ȡ����
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		
		
	}
}
