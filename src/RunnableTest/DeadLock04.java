package RunnableTest;
/**
 * ���������򣺶�����̶���Դ������
 * 		1.�����ǰ�������Դ
 * 		2.��������������Դ
 * 		3.���̵��ƽ�˳�򲻵�
 * �������ĸ���Ҫ��������������������ͱ������������ɰ�����������·�ȴ�����
 * Ԥ���������ƻ������γɵı�Ҫ����
 * ��������������ϵͳ���벻��ȫ״̬�����м��㷨�Ͱ�ȫ���㷨
 * ��������ͽӴ�������������Դ���ǳ�������(�߳�)
 * @author hc
 *
 */
public class DeadLock04 implements Runnable{
	private boolean flag=true;
	private int b=100;
	static Object o1=new Object();
	static Object o2=new Object();
	public void m1(){
		b=1000;
		
	}
	public void run(){
		if(flag){
			synchronized(o1){
				try{
					Thread.sleep(500);
				}catch(Exception e){
					
				}
				synchronized(o2){
					System.out.println("�߳�t1�ɹ���ȡ��Դ��ִ�н���");
				}
			}
		}
		if(flag==false){
			synchronized(o2){
				try{
					Thread.sleep(500);
				}catch(Exception e){
					
				}
				synchronized(o1){
					System.out.println("�߳�t2�ɹ���ȡ��Դ��ִ�н���");
				}
			}
		}
	}
	public static void main(String args[]) throws InterruptedException{
		DeadLock04 d4=new DeadLock04();
		DeadLock04 d44=new DeadLock04();
		d44.flag=false;
		Thread t1=new Thread(d4);
		Thread t2=new Thread(d44);
		t1.start();
		t2.start();
		
	}
}

