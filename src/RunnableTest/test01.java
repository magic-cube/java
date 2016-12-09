package RunnableTest;
/**
 * 尝试使用匿名内部类的方式启动一个线程
 * 
 * Thread类的构造方法
 * Thread()
 * Thread(Runnable,String name)
 * Thread(String name)
 * 
 * @author hc
 *
 */
public class test01 {
	public static void main(String args[]){
		//Thread的构造方法
		Thread t1=new Thread(new Thread (){
			public void run(){
				for(int i=0;i<100;i++){
					System.out.println("t1-----"+i);
				}
			}
		},"t1");
		t1.start();
		for(int i=0;i<100;i++){
			System.out.println("Main----"+i);
		}
	}
}