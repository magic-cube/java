package annotation;
/**
 * ����
 * reflection
 * ͨ�����䶯̬�û�ȡ�����Ϣ
 * ��һ��class������ʱ��JVM���Զ�����һ��class����,��������������������Ľṹ��Ϣ
 * @author hc
 *
 */
public class Reflection {
	
	//@SuppressWarnings("all")
	public static void main(String args[]){
		String path="annotation.Demo01";
		try {
			//Class.forName("��������")����ʽ
			Class c=Class.forName(path);
			System.out.println(c);
			//�����泣����ʽ     ��������.class
			Class c2=Demo.MapDemo1.class;
			System.out.println(c2);
			
			//javase5��Class<?>Ҫ����ƽ����class����Ȼ���ߵȼ�
			//��Class��ӷ����﷨��ԭ�������Ϊ���ṩ���������ͼ��
			Class<?> c3=Demo.MapDemo2.class;
			System.out.println(c3.hashCode());
			
			
			Class<?> strClass=path.getClass();
			Class<?> strClass2=String.class;
			System.out.println("����Class�����Ƿ�Ϊͬһ����    "+(strClass==strClass2));
			
			
			Class intClass=int.class;
			
			System.out.println("�������������Class����");
			//��ά������
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
