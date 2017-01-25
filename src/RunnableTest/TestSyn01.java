package RunnableTest;
/**
 * 线程同步  synchronized
 * 同一个线程类启动的两个线程
 * 可以看出，num是临界资源，需要对他进行互斥访问
 * 一下，让num++之后sleep，是为了看出两个线程都对他进行了访问，修改了两次，导致最终num的值出错
 * 加上synchronized(this),锁定当前对象
 * 互斥锁
 * @author hc
 *
 */
public class TestSyn01 {
	public static void main(String args[]){
		Td td1=new Td();
		Thread t1=new Thread(td1);
		Thread t2=new Thread(td1);
		
		t1.start();
		t2.start();
	}
}

class Timer {
	private static int num=0;
	//也可以直接锁定一个方法,不能理解为同步方法，应该是，执行这个方法的过程中，当前对象被锁定！
	public /*synchronized*/ void add(String name){
		
		synchronized(this){
			//以下区域均需进行互斥访问，临界区，p v 操作,执行完后释放锁
			num++;
			try{
				//sleep一下，给另一个线程机会。。。 (放大效果) 如果没有，可能得到正确结果，但依然存在着错误的可能
				Thread.sleep(1);
			}catch(InterruptedException e){
				
			}
			System.out.println(name+"你是第"+num+"个使用timer的线程");
		}
	}
}
/*
 * 线程类
 */
class Td implements Runnable{

	Timer timer=new Timer();
	public void run(){
		//Thread.currentThread,获取当前线程
		timer.add(Thread.currentThread().getName());
		
	}
}