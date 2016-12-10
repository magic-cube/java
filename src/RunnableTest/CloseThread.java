package RunnableTest;
/*
 * 关闭一个线程，比较好的一个方法
 * 对外提供设置flag==false的shutDown方法
 */
public class CloseThread {
	public static void main(String args[]){
		D3 d=new D3();
		Thread t1=new Thread(d);
		t1.start();
		for(int i=0;i<50;i++){
			System.out.println("main-"+i);
		}
		//在main线程结束后，调用shutDown方法，结束线程t1
		System.out.println("Thread main is over");
		d.shutDown();
	}
}
class D3 implements Runnable{
	private boolean flag=true;
	public void run(){
		int i=0;
		while(flag){
			System.out.println("D---"+i++);
		}
	}
	public void shutDown(){
		flag=false;
	}
}
