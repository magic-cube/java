package RunnableTest;
/**
 * �����̵߳����ַ�ʽ
 * 1.ʵ��Runnable�ӿ�
 * 2.��Thread��̳�
 * 	   �Ƽ�ȥʵ�ֽӿڣ���������������ԣ�������Ҫȥ��Thread�̳�
 * @author hc
 *
 */
public class Demo01 {
	public static void main(String args[]){
		//�����������߳�t1
		T t= new T();
		Thread t1=new Thread(t);
		t1.start();
		//�����������߳�p   �������һ��Thread
		P p=new P();
		p.start();
		
//		Thread t2=new Thread(p);
//		t2.start();
		
		for(int i=0;i<100;i++){
			System.out.println("Main----"+i);
		}
	}
}
//ʵ��Runnable�ӿڣ���дrun()
class T implements Runnable{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("T----"+i);
		}
	}
}
//��Thread�̳У���дrun()
class P extends Thread{
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println("P----"+i);
		}
	}
}