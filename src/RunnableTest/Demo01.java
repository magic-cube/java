package RunnableTest;
/**
 * 创建线程的两种方式
 * 实现Runnable接口
 * 从Thread类继承
 * @author hc
 *
 */
public class Demo01 {
	public static void main(String args[]){
		//创建并启动线程t1
		T t= new T();
		Thread t1=new Thread(t);
		t1.start();
		//创建并启动线程t2
		P p=new P();
		Thread t2=new Thread(p);
		t2.start();
		
		
		for(int i=0;i<100;i++){
			System.out.println("Main----"+i);
		}
	}
}
class T implements Runnable{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("T----"+i);
		}
	}
}
class P extends Thread{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("P----"+i);
		}
	}
}