package java2;
/**
 * �������ģʽ
 * @author hc
 *
 */
public class SyDemo03 {
	public static void main(String args[]){
		
	}
}
/*
 * ����ʽ
 * 1.������˽�л�
 * 2.����˽�еľ�̬���ԣ�ͬʱ�����ö���
 * 3.����һ������ľ�̬�������ظñ���
 */
class MyJvm1{
	private static MyJvm1 instance=new MyJvm1();
	private MyJvm1(){
		
	}
	public static MyJvm1 getJvm(){
		return instance;
	}
}
/*
 * ����ʽ��(���Ч��)
 * ����ʹ�õ�ʱ��Żᱻ���أ�����һ���ᱻ���أ��������õ�ʱ��Żᱻ����
 * ʹ���ڲ��࣬�ӻ�����ʱ����ֻҪ��û�õ�getJvm(),�㲻�����
 * @author hc
 *
 */
class MyJvm3{
	//ʹ���ڲ��࣬�ӻ�����ʱ��
	public static class Jvmholder{
		private static MyJvm3 instance=new MyJvm3();
	}
	private MyJvm3(){
		
	}
	public static MyJvm3 getJvm(){
		return Jvmholder.instance;
	}
}
/*
 * ����ʽ
 * 1.������˽�л�
 * 2.����˽�еľ�̬����
 * 3.����һ������ľ�̬�������ظñ���
 */
class MyJvm2{
	private static MyJvm2 instance=null;
	private MyJvm2(){
		
	}
	public static MyJvm2 getJvm(){
		//�����˫�������
		if(instance==null){		//���Ч��
			synchronized(MyJvm2.class){
				if(instance==null){		//��֤��ȫ
					instance=new MyJvm2();
				}
			}
		}
		return instance;
	}
}