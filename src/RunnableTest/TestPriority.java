package RunnableTest;
/*
 * 线程优先级 priority
 * getPriority()
 * setPriority()
 * Thread.NORM_PRIORITY=5
 */
public class TestPriority {
	public static void main(String args[]){
		A1 a=new A1();
		B1 b=new B1();
		Thread t1=new Thread(a);
		Thread t2=new Thread(b);
		t1.setPriority(Thread.NORM_PRIORITY+3);
		t1.start();
		t2.start();
	}
}
class A1 implements Runnable{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("A1"+i);
		}
	}
}
class B1 implements Runnable{
	public void run(){
		for(int i=0;i<1000;i++){
			System.out.println("B1-----"+i);
		}
	}
}