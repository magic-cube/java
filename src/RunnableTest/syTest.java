package RunnableTest;
/**
 * 同步方法的测试
 * @author hc
 *
 */
public class syTest implements Runnable{
	
	private int a=1;
	static syTest s=new syTest();
	public synchronized void m1(){
		a=100;
		try {
			//验证t1的m1执行过程中，是否会执行m2的保障,看m2是否会等待m1执行
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
		//保证t1线程先于main线程执行
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		s.m2();
	}
}
