package RunnableTest;
/**
 * 死锁的起因：多个进程对资源的争夺
 * 		1.竞争非剥夺性资源
 * 		2.竞争可消耗性资源
 * 		3.进程的推进顺序不当
 * 死锁的四个必要条件：互斥条件，请求和保持条件，不可剥夺条件，环路等待条件
 * 预防死锁：破坏死锁形成的必要条件
 * 避免死锁：不让系统进入不安全状态，银行家算法和安全性算法
 * 检测死锁和接触死锁：剥夺资源或是撤销进程(线程)
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
					System.out.println("线程t1成功获取资源并执行结束");
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
					System.out.println("线程t2成功获取资源并执行结束");
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

