package RunnableTest;
/**
 * 创建线程的两种方式
 * 1.实现Runnable接口
 * 2.从Thread类继承
 * 	   推荐去实现接口，它赋予了你灵活性，尽量不要去从Thread继承
 * @author hc
 *
 */
public class Demo01 {
	public static void main(String args[]){
		//创建并启动线程t1
		T t= new T();
		Thread t1=new Thread(t);
		t1.start();
		//创建并启动线程p   本身就是一个Thread
		P p=new P();
		p.start();
		
//		Thread t2=new Thread(p);
//		t2.start();
		
		for(int i=0;i<100;i++){
			System.out.println("Main----"+i);
		}
	}
}
//实现Runnable接口，重写run()
class T implements Runnable{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("T----"+i);
		}
	}
}
//从Thread继承，重写run()
class P extends Thread{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("P----"+i);
		}
	}
}