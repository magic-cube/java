package java2;
import java.util.concurrent.*;
/**
 * Join方法测试
 * 执行调度器,ExecutorService
 * CallAble  可以有返回值，可以对外throw异常
 * @author hc
 *
 */
public class JionTest {
	public static void main(String args[]){
		A1 a1=new A1();
		Thread t1=new Thread(a1);
		//启动，需手动停止服务
		t1.start();
		for(int i=0;i<10;i++){
			if(i==5){
				try{
					t1.join();//i==5时，调用join，main阻塞，需等待t1执行完毕
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
