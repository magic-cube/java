package java2;
/**
 * ģ����Ʊ
 * @author hc
 *
 */
public class web12306 {
	public static void main(String args[]){
		W w=new W();
		Thread t1=new Thread(w,"·�˼�");
		Thread t2=new Thread(w,"·����");
		Thread t3=new Thread(w,"·�˱�");
		t1.start();
		t2.start();
		t3.start();
		
	}
}
class W implements Runnable{
	private int num=50;
	public void run(){
		t();
	}
	public void t(){
		while(true){
			/*
			 * ��֤��β�����ԭ���ԣ�Ҫ��ȫִ�У�Ҫô��ִ��
			 * ʵ�ֶ�num�Ļ������
			 */
			synchronized(this){
				if(num<=0){
					break;
				}
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+"������"+num--);
			}
		}
	}
}