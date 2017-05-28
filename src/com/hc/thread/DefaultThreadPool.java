package com.hc.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool <Job extends Runnable> implements ThreadPool<Job>{

	//线程池最大限制数
	private static final int MAX_WORKER_NUMBERS = 10;
	
	//线程池默认数量
	private static final int DEFAULT_WORKER_NUMBERS = 5;
	
	//线程池最小数量
	private static final int MIN_WOKER_NUMBERS = 1;
	
	//工作列表,将会向里面插入工作(可以使用一个阻塞队列,会简化生产者-消费者模式的实现)(工作列表会伴随着频繁的写操作,因而选用了LinkedList作为其默认实现)
	private final LinkedList<Job> jobs = new LinkedList<Job>();
	
	//工作者列表(工作者列表不需要频繁的写操作,因而使用了ArrayList作为其默认实现)
	private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
	
	//工作者线程的数量
	private int workerNum = DEFAULT_WORKER_NUMBERS;
	
	//线程编号生成(原子类,保证操作的原子性)
	private AtomicLong threadNum = new AtomicLong();
	
	public DefaultThreadPool() {
		initializeWorkers(DEFAULT_WORKER_NUMBERS);
	}
	
	public DefaultThreadPool(int num){
		workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num < MIN_WOKER_NUMBERS ? MIN_WOKER_NUMBERS : num;
		initializeWorkers(workerNum);
	}
	
	private void initializeWorkers(int num) {
		for(int i=0;i<num;i++){
			Worker worker=new Worker();
			workers.add(worker);
			Thread thread=new Thread(worker,"Thread-Worker-"+threadNum.incrementAndGet());
			thread.start();
		}
	}

	@Override
	public void execute(Job job) {
		if(job!=null){
			//添加一个工作,然后进行通知
			synchronized(jobs){//实现对工作列表互斥访问
				jobs.addLast(job);
				jobs.notify();
			}
		}
	}

	@Override
	public void shutdown() {
		for (Worker worker : workers) {
			worker.shutdown();
		}
	}

	@Override
	public void adddWorders(int num) {
		synchronized(jobs){
			if(num+this.workerNum>MAX_WORKER_NUMBERS){
				num=MAX_WORKER_NUMBERS-this.workerNum;
			}
			initializeWorkers(num);
			this.workerNum += num;
		}
	}

	@Override
	public void removeWorkers(int num) {
		synchronized(jobs){
			if(num>=this.workerNum){
				throw new IllegalArgumentException("超过现有线程数量");
			}
			//按照给定数量停止worker
			for(int i=0;i<num;i++){
				Worker worker=workers.get(i);
				if(workers.remove(worker) ){
					worker.shutdown();
				}
			}
			this.workerNum-=num;
			
		}
	}

	@Override
	public int getJobSize() {
		
		return jobs.size();
	}

	//工作者,担当消费者的角色
	class Worker implements Runnable{
		
		//是否工作,使用了volatile,保证了其内存可见性
		private volatile boolean running = true;
		
		@Override
		public void run() {
			while(running){
				Job job=null;
				synchronized(jobs){
					//如果列表为空,wait
					while(jobs.isEmpty()){
						try {
							jobs.wait();
						} catch (InterruptedException e) {
							//感受到外部对WorkerThread的中断操作,返回
							Thread.currentThread().interrupt();
							return;
						}
					}
					//取出一个jobs
					job=jobs.removeFirst();
				}
				if(jobs!=null){
					try{
						job.run();
					}catch(Exception e){
						//忽略job中的Exception
					}
				}
			}
		}
		
		//温和地终止线程,使得线程在终止时有机会去清理资源
		public void shutdown(){
			running = false;
		}
	}
	
}
