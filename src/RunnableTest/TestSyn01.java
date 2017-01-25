package RunnableTest;
/**
 * �߳�ͬ��  synchronized
 * ͬһ���߳��������������߳�
 * ���Կ�����num���ٽ���Դ����Ҫ�������л������
 * һ�£���num++֮��sleep����Ϊ�˿��������̶߳����������˷��ʣ��޸������Σ���������num��ֵ����
 * ����synchronized(this),������ǰ����
 * ������
 * @author hc
 *
 */
public class TestSyn01 {
	public static void main(String args[]){
		Td td1=new Td();
		Thread t1=new Thread(td1);
		Thread t2=new Thread(td1);
		
		t1.start();
		t2.start();
	}
}

class Timer {
	private static int num=0;
	//Ҳ����ֱ������һ������,�������Ϊͬ��������Ӧ���ǣ�ִ����������Ĺ����У���ǰ����������
	public /*synchronized*/ void add(String name){
		
		synchronized(this){
			//�������������л�����ʣ��ٽ�����p v ����,ִ������ͷ���
			num++;
			try{
				//sleepһ�£�����һ���̻߳��ᡣ���� (�Ŵ�Ч��) ���û�У����ܵõ���ȷ���������Ȼ�����Ŵ���Ŀ���
				Thread.sleep(1);
			}catch(InterruptedException e){
				
			}
			System.out.println(name+"���ǵ�"+num+"��ʹ��timer���߳�");
		}
	}
}
/*
 * �߳���
 */
class Td implements Runnable{

	Timer timer=new Timer();
	public void run(){
		//Thread.currentThread,��ȡ��ǰ�߳�
		timer.add(Thread.currentThread().getName());
		
	}
}