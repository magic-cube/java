package java2;
/**
 * 模拟抢票
 * @author hc
 *
 */
public class web12306 {
	public static void main(String args[]){
		W w=new W();
		Thread t1=new Thread(w,"路人甲");
		Thread t2=new Thread(w,"路人乙");
		Thread t3=new Thread(w,"路人丙");
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
			 * 保证这段操作的原子性，要不全执行，要么不执行
			 * 实现对num的互斥访问
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
				System.out.println(Thread.currentThread().getName()+"抢到了"+num--);
			}
		}
	}
}