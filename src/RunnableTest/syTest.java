package RunnableTest;
/**
 * ͬ�������Ĳ���
 * @author hc
 *
 */
public class syTest implements Runnable{
	
	private int a=1;
	static syTest s=new syTest();
	public synchronized void m1(){
		a=100;
		try {
			//��֤t1��m1ִ�й����У��Ƿ��ִ��m2�ı���,��m2�Ƿ��ȴ�m1ִ��
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("m1--->a="+a);
	}
	public synchronized void m2(){
		a=200;
		System.out.println("m2--->a="+a);
	}
	public void run(){
			s.m1();
	}
	public static void main(String args[]){
		Thread t1=new Thread(s);
		t1.start();
		//��֤t1�߳�����main�߳�ִ��
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		s.m2();
	}
}
