/**
 * ��������ص�ȫ����
 * 1.���أ����ֽ����ļ����ص��ڴ��У��ڶ�������һ��Class���������������
 * 2.���ӣ���֤���Ƿ����JVM�淶����׼����Ϊ��̬�����洢�ռ䣩����������������������еķ��������滻Ϊֱ�����õĹ��̣�
 * 3.��ʼ������ʼ����̬��Ĵ洢�ռ�
 * @author hc
 *
 */

public class ClassLoader01 {
	
	
	static{
		System.out.println("��̬��ʼ����ClassLoader");
	}
	
	public static void main(String args[]){
		System.out.println("��ClassLoader��main����");
		A a=new A();
		System.out.println(A.width+"\n");
		
		A a2=new A();
		System.out.println("�ڶ��α�����ʱ�����֣����еľ�̬������Ϊ����");
		/*
		 * ��̬��ʼ����ֻ�����౻�״μ���ʱ�Żᷢ��
		 */
		System.out.println("\n��width��ֵ�Լ��������Ĵ�ӡ˳����Կ�������������ִ�����������");
		System.out.println("�ܽ᣺��ʼ��˳������и��࣬�Ƚ��и����һϵ�ж�����֮���Ⱦ�̬����"
				+ "\n֮���ǷǾ�̬��������ǹ�����");
	}
}
class A extends A_Father{
	/*
	 * ����ع����г�ʼ��˳��
	 * ��̬��ʼ��-->��ͨ��ʼ��-->����������������ʽ��Ҳ�Ǿ�̬�ģ�
	 * �����ʱ�����Ƕ�֪��������һ����Ķ���ʱ����������Ĺ�������
	 * �䱾��ԭ�����ڽ��о�̬��ʼ������Ϊ��������ʽ��Ҳ�Ǿ�̬��
	 * �ܲпᣬ�������ӱ�����֪�еĵ�һ��ִ�б�������һ��ִ��
	 */
	public static int width=100;
	static{
		System.out.println("��̬��ʼ����A�Ķ���������");
		width=300;
	}
	public A(){
		System.out.println("��A�Ĺ�������ִ����");
		width=1000;
	}
	/*
	 * �����޷���ֹ�Զ���ʼ���ķ��������������ڹ�����������֮ǰ����
	 */
}
/*
 * ��Ȼ��Ҳ�����Object���static��
 *
 */
class A_Father /*extends Object*/{
	static{
		System.out.println("��̬��ʼ����A_Father");
	}
	public A_Father(){
		System.out.println("��A_Father�Ĺ��췽��ִ����");
	}
}






