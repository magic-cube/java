package RunnableTest;
/**
 * ���������ӳ���
 * �����������ĸ���Ҫ��������������������ͱ������������ɰ�����������·�ȴ�����
 * @author hc
 *
 */
public class TestDeadLock implements Runnable{
	public int num=0;
	static Object o1=new Object(),o2=new Object();
	public void run(){
		System.out.println("num="+num);
		if(num==0){
			synchronized(o2){
				try{
					//��t2��סo2�Ļ��ᣬ�Ŵ�Ч��
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				synchronized(o1){
					System.out.println("1");
				}
			}
		}
		if(num==1){
			synchronized(o1){
				try{
					//��t1��סo1�Ļ���
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				synchronized(o2){
					System.out.println("2");
				}
			}
		}

	}
	public static void main(String args[]){
		O ot1=new O();
		O ot2=new O();
		ot1.num=1;
		ot2.num=0; 
		Thread t1=new Thread(ot1);
		Thread t2=new Thread(ot2);

		
		t1.start();
		t2.start();
//		TestDeadLock tdl1=new TestDeadLock();
//		TestDeadLock tdl2=new TestDeadLock();
//		tdl1.num=1;
//		tdl2.num=0;
//		Thread t1=new Thread(tdl1);
//		Thread t2=new Thread(tdl2);
//		t1.start();
//		t2.start();
	}
}
class O implements Runnable{
	/*
	 * ֮ǰ����ס����˼������⣬��Ȼ�������Object������static�ģ���Ϊ��������������Ҫ��֤o1,o2ֻ��һ��
	 * ��֤�����̷߳��ʵ���ͬһ��o1,o2
	 */
	static Object o1=new Object();
	static Object o2=new Object();
	public int num=0;
	public void run(){
		System.out.println("num="+num);
		if(num==0){
			synchronized(o2){
				try{
					//��t2��סo2�Ļ��ᣬ�Ŵ�Ч��
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				synchronized(o1){
					System.out.println("1");
				}
			}
		}
		if(num==1){
			synchronized(o1){
				try{
					//��t1��סo1�Ļ���
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				synchronized(o2){
					System.out.println("2");
				}
			}
		}
	}
}
