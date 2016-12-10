package RunnableTest;

import java.util.Date;

/*
 * sleep()��������
 */
public class InterruptTest {
	public static void main(String args[]){
		T2 t=new T2();
		Thread t1=new Thread(t);
		t1.start();
		
		//�����߳�sleepʮ�����sleep��t1�������ֱ�Ӵ��
		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//���sleep��t1�߳�
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