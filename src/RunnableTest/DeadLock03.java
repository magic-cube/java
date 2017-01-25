package RunnableTest;
/**
 * 两个方法可以访问并膝盖同一个资源，只给一个方法加锁是不行的，需要给每个访问该资源的方法都加一把锁
 * 对该资源进行互斥访问
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
	
	//这把锁首先被m2拿到了，也就是m2先执行了,在他sleep过程中，又去执行m1
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
			//因为想让m1先执行，所以先让主线程睡
			Thread.sleep(100);
			dl.m2();
		}catch(Exception e){
			e.printStackTrace();
		}
		Thread.sleep(2000);
		System.out.println("n现在的实际值为："+dl.n);
	}

}
