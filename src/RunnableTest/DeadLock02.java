package RunnableTest;
/**
 * һ��������������
 * �ʣ���m1ִ�еĹ����У�m2��ִ�������£�
 * 
 * ������
 * 		synchronizedֻ����ס����Щ��������ִ���ڼ䣬���������߳�ִ�У�
 * 		������߳���ȫ�п���ȥ����û�б������ķ���
 * @author hc
 *
 */
public class DeadLock02 implements Runnable{
	int num=100;
	public synchronized void m1(){
		num=1000;
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			
		}
		System.out.println("m1---->num="+num);
	}
	
	public void m2(){
		System.out.println("m2-->num="+num);
	}
	
	public void run(){
		m1();
	}
	
	public static void main(String args[]){
		DeadLock02 dl2=new DeadLock02();
		Thread t1=new Thread(dl2);
		t1.start();
		
		/*
		 * ע��˴������m1ִ�й����У�m2����ִ�У���ô��m1 sleep�����У�m2������num��ֵӦ��Ϊ100
		 * ���m2��ִ�У���ô��������Ӧ����m1�޸ĺ��num��ֵ��Ϊ1000
		 */
		try{
			//���߳���˯����t1��ִ��
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		dl2.m2();
	}
}
