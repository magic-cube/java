package RunnableTest;
/**
 * 一道死锁的面试题
 * 问：在m1执行的过程中，m2能执行吗？如下：
 * 
 * 解析：
 * 		synchronized只是锁住了那些步骤在他执行期间，不允许别的线程执行，
 * 		但别的线程完全有可能去访问没有被锁定的方法
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
		 * 注意此处，如果m1执行过程中，m2不能执行，那么在m1 sleep过程中，m2看到的num的值应该为100
		 * 如果m2能执行，那么他看到的应该是m1修改后的num的值，为1000
		 */
		try{
			//主线程先睡，让t1先执行
			Thread.sleep(1000);
		}catch(Exception e){
			e.printStackTrace();
		}
		dl2.m2();
	}
}
