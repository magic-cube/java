package java2;
/**
 * ��sleepģ�⵹��ʱ
 * @author hc
 *
 */
public class SleepDemo {
	public static void main(String args[]){
		System.out.println("�˴����������ʱ��ʼ��");
		for(int i=10;i>=0;i--){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(i);
			if(i==0){
				try{
					Thread.sleep(2000);
				}catch(Exception e){
					e.printStackTrace();
				}
				System.out.println("���䣡");
				try{
					Thread.sleep(5000);
				}catch(Exception e){
					e.printStackTrace();
				}
				System.out.println("OK!�㵺��ը�ˣ�");
			}
		}
	}
}
