package RunnableTest;
/**
 * 生产者消费者问题再研究
 * 修改生产者和消费者每次操作完的睡眠时间,分别观察
 * 生产者消费者睡眠时间相同的效果
 * 生产者睡的时间短的效果
 * 消费者睡的时间短的效果
 * @author hc
 *
 */
public class ProducerConsumer {
	public static void main(String args[]){
		SynStack ss=new SynStack();
		
		Producer p=new Producer(ss);
		Consumer c=new Consumer(ss);
		
		Thread p1=new Thread(p);
		Thread c1=new Thread(c);
		p1.start();
		try{
			c1.sleep(500);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		c1.start();
	}
}
/*
 * 生产者类
 */
class Producer implements Runnable{
	SynStack ss=null;
	Producer(SynStack ss){
		this.ss=ss;
	}
	public void run(){
		for(int i=0;i<20;i++){
			WoTou w=new WoTou();
			ss.push(w);
			System.out.println("生产者正在向缓冲区中放第"+i+"个WoTou...");
			//生产者每次放完，睡眠一秒，放大效果
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
/*
 * 消费者类
 */
class Consumer implements Runnable{
	SynStack ss=null;
	Consumer(SynStack ss){
		this.ss=ss;
	}
	public void run(){
		for(int i=0;i<20;i++){
			//消费者拿，至于他要拿来干嘛，随他高兴，此处没做处理,只是拿到了这个对象
			ss.pop();
			System.out.println("消费者正在从缓冲区中拿第"+i+"个WoTou...");
			//生产者每次放完，睡眠一秒，放大效果
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
class SynStack{
	int index=0;
	//限定缓冲区的大小为6
	WoTou [] arrWT=new WoTou[6];
	
	public synchronized void push(WoTou w){
		//缓冲区满，等待，使用if会存在潜在的危险
		while(index==arrWT.length){
			System.out.println("\n缓冲区满，生产者等待\n");
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		//不满，叫醒wait的线程
		this.notify();
		arrWT[index]=w;
		index++;
	}
	public synchronized WoTou pop(){
		//缓冲区空，等待,使用if会存在潜在的危险
		while(index==0){
			System.out.println("\n缓冲区空，消费者等待\n");
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		//不满，叫醒wait的线程
		this.notify();
		index--;
		return arrWT[index];
	}
}
class WoTou{
	private int i;
	WoTou(){
		
	}
}