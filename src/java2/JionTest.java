package java2;
import java.util.concurrent.*;
/**
 * Join��������
 * ִ�е�����,ExecutorService
 * CallAble  �����з���ֵ�����Զ���throw�쳣
 * @author hc
 *
 */
public class JionTest {
	public static void main(String args[]){
		A1 a1=new A1();
		Thread t1=new Thread(a1);
		//���������ֶ�ֹͣ����
		t1.start();
		for(int i=0;i<10;i++){
			if(i==5){
				try{
					t1.join();//i==5ʱ������join��main��������ȴ�t1ִ�����
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			System.out.println("main----"+i);
		}
		
		
		
	}
}
class A1 implements Runnable{
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("a1----"+i);
		}
	}
}
