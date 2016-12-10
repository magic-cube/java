package RunnableTest;
/**
 * 死锁的例子程序
 * 死锁产生的四个必要条件：互斥条件，请求和保持条件，不可剥夺条件，环路等待条件
 * @author hc
 *
 */
public class TestDeadLock implements Runnable{
	public int num=0;
	static Object o1=new Object(),o2=new Object();
	public void run(){
		System.out.println("num="+num);
		if(num==0){
			synchronized(o2){
				try{
					//给t2锁住o2的机会，放大效果
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				synchronized(o1){
					System.out.println("1");
				}
			}
		}
		if(num==1){
			synchronized(o1){
				try{
					//给t1锁住o1的机会
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				synchronized(o2){
					System.out.println("2");
				}
			}
		}

	}
	public static void main(String args[]){
		O ot1=new O();
		O ot2=new O();
		ot1.num=1;
		ot2.num=0; 
		Thread t1=new Thread(ot1);
		Thread t2=new Thread(ot2);

		
		t1.start();
		t2.start();
//		TestDeadLock tdl1=new TestDeadLock();
//		TestDeadLock tdl2=new TestDeadLock();
//		tdl1.num=1;
//		tdl2.num=0;
//		Thread t1=new Thread(tdl1);
//		Thread t2=new Thread(tdl2);
//		t1.start();
//		t2.start();
	}
}
class O implements Runnable{
	/*
	 * 之前锁不住，百思不得其解，恍然醒悟，这个Object必须是static的，此为互斥条件，必须要保证o1,o2只有一份
	 * 保证两个线程访问的是同一份o1,o2
	 */
	static Object o1=new Object();
	static Object o2=new Object();
	public int num=0;
	public void run(){
		System.out.println("num="+num);
		if(num==0){
			synchronized(o2){
				try{
					//给t2锁住o2的机会，放大效果
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				synchronized(o1){
					System.out.println("1");
				}
			}
		}
		if(num==1){
			synchronized(o1){
				try{
					//给t1锁住o1的机会
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				synchronized(o2){
					System.out.println("2");
				}
			}
		}
	}
}
