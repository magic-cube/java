package RunnableTest;
/*
 * join()��������
 * �������̺߳ϲ�Ϊһ���߳�
 * main����ȴ�t1ִ���꣬��Ϊ����һ���̣߳����������ڷ�������
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