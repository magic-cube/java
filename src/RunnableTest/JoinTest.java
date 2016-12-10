package RunnableTest;
/*
 * join()方法测试
 * 将两个线程合并为一个线程
 * main必须等待t1执行完，因为成了一个线程，所以类似于方法调用
 */
public class JoinTest {
	public static void main(String args[]){
		T3 t=new T3();
		Thread t1=new Thread(t);
		t1.start();
		try{
			t1.join();
		}catch(InterruptedException e){
			
		}
		for(int i=0;i<10;i++){
			System.out.println("i am main");
		}
	}
}
class T3 implements Runnable{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("i am T3 ");
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				return ;
			}
		}
	}
}