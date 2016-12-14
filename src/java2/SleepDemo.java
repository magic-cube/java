package java2;
/**
 * 用sleep模拟倒计时
 * @author hc
 *
 */
public class SleepDemo {
	public static void main(String args[]){
		System.out.println("核打击启动倒计时开始：");
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
				System.out.println("发射！");
				try{
					Thread.sleep(5000);
				}catch(Exception e){
					e.printStackTrace();
				}
				System.out.println("OK!广岛被炸了！");
			}
		}
	}
}
