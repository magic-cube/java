package RunnableTest;
/**
 * �������������������о�
 * �޸������ߺ�������ÿ�β������˯��ʱ��,�ֱ�۲�
 * ������������˯��ʱ����ͬ��Ч��
 * ������˯��ʱ��̵�Ч��
 * ������˯��ʱ��̵�Ч��
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
 * ��������
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
			System.out.println("�����������򻺳����зŵ�"+i+"��WoTou...");
			//������ÿ�η��꣬˯��һ�룬�Ŵ�Ч��
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
/*
 * ��������
 */
class Consumer implements Runnable{
	SynStack ss=null;
	Consumer(SynStack ss){
		this.ss=ss;
	}
	public void run(){
		for(int i=0;i<20;i++){
			//�������ã�������Ҫ��������������ˣ��˴�û������,ֻ���õ����������
			ss.pop();
			System.out.println("���������ڴӻ��������õ�"+i+"��WoTou...");
			//������ÿ�η��꣬˯��һ�룬�Ŵ�Ч��
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
	//�޶��������Ĵ�СΪ6
	WoTou [] arrWT=new WoTou[6];
	
	public synchronized void push(WoTou w){
		//�����������ȴ���ʹ��if�����Ǳ�ڵ�Σ��
		while(index==arrWT.length){
			System.out.println("\n���������������ߵȴ�\n");
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		//����������wait���߳�
		this.notify();
		arrWT[index]=w;
		index++;
	}
	public synchronized WoTou pop(){
		//�������գ��ȴ�,ʹ��if�����Ǳ�ڵ�Σ��
		while(index==0){
			System.out.println("\n�������գ������ߵȴ�\n");
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		//����������wait���߳�
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