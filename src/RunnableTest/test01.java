package RunnableTest;
/**
 * ����ʹ�������ڲ���ķ�ʽ����һ���߳�
 * 
 * Thread��Ĺ��췽��
 * Thread()
 * Thread(Runnable,String name)
 * Thread(String name)
 * 
 * @author hc
 *
 */
public class test01 {
	public static void main(String args[]){
		//Thread�Ĺ��췽��
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