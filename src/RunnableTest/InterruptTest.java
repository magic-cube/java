package RunnableTest;

import java.util.Date;

/*
 * sleep()方法测试
 */
public class InterruptTest {
	public static void main(String args[]){
		T2 t=new T2();
		Thread t1=new Thread(t);
		t1.start();
		
		//让主线程sleep十秒后打断sleep的t1，否则会直接打断
		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//打断sleep的t1线程
		t1.interrupt();
	}
}
class T2 implements Runnable{
	public void run(){
		while(true){
			try{
				System.out.println("===="+new Date()+"====");
				Thread.sleep(1000);
			}catch(Exception e){
				return;
			}
		}
	}
}