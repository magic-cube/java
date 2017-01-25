package RunnableTest;
/**
 * �����������Է��ʲ�ϥ��ͬһ����Դ��ֻ��һ�����������ǲ��еģ���Ҫ��ÿ�����ʸ���Դ�ķ�������һ����
 * �Ը���Դ���л������
 * @author hc
 *
 */
public class DeadLock03 implements Runnable{
	int n=100;
	
	public synchronized void m1() throws Exception{
		n=1000;
		Thread.sleep(1000);
		System.out.println("m1--"+n);
	}
	
	//��������ȱ�m2�õ��ˣ�Ҳ����m2��ִ����,����sleep�����У���ȥִ��m1
	public synchronized void m2() throws Exception{
		Thread.sleep(2500);
		n=2000;
		System.out.println("m2--->"+n);
	}
	
	public void run(){
		try{
			m1();
		}catch(Exception e){
			
		}
	}
	public static void main(String[] args) throws InterruptedException {
		DeadLock03 dl=new DeadLock03();
		Thread t1= new Thread(dl);
		t1.start();
		try{
			//��Ϊ����m1��ִ�У������������߳�˯
			Thread.sleep(100);
			dl.m2();
		}catch(Exception e){
			e.printStackTrace();
		}
		Thread.sleep(2000);
		System.out.println("n���ڵ�ʵ��ֵΪ��"+dl.n);
	}

}
