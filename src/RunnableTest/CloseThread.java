package RunnableTest;
/*
 * �ر�һ���̣߳��ȽϺõ�һ������
 * �����ṩ����flag==false��shutDown����
 */
public class CloseThread {
	public static void main(String args[]){
		D3 d=new D3();
		Thread t1=new Thread(d);
		t1.start();
		for(int i=0;i<50;i++){
			System.out.println("main-"+i);
		}
		//��main�߳̽����󣬵���shutDown�����������߳�t1
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
