package com.hc.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool <Job extends Runnable> implements ThreadPool<Job>{

	//�̳߳����������
	private static final int MAX_WORKER_NUMBERS = 10;
	
	//�̳߳�Ĭ������
	private static final int DEFAULT_WORKER_NUMBERS = 5;
	
	//�̳߳���С����
	private static final int MIN_WOKER_NUMBERS = 1;
	
	//�����б�,������������빤��(����ʹ��һ����������,���������-������ģʽ��ʵ��)(�����б�������Ƶ����д����,���ѡ����LinkedList��Ϊ��Ĭ��ʵ��)
	private final LinkedList<Job> jobs = new LinkedList<Job>();
	
	//�������б�(�������б���ҪƵ����д����,���ʹ����ArrayList��Ϊ��Ĭ��ʵ��)
	private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
	
	//�������̵߳�����
	private int workerNum = DEFAULT_WORKER_NUMBERS;
	
	//�̱߳������(ԭ����,��֤������ԭ����)
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
			//���һ������,Ȼ�����֪ͨ
			synchronized(jobs){//ʵ�ֶԹ����б������
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
				throw new IllegalArgumentException("���������߳�����");
			}
			//���ո�������ֹͣworker
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

	//������,���������ߵĽ�ɫ
	class Worker implements Runnable{
		
		//�Ƿ���,ʹ����volatile,��֤�����ڴ�ɼ���
		private volatile boolean running = true;
		
		@Override
		public void run() {
			while(running){
				Job job=null;
				synchronized(jobs){
					//����б�Ϊ��,wait
					while(jobs.isEmpty()){
						try {
							jobs.wait();
						} catch (InterruptedException e) {
							//���ܵ��ⲿ��WorkerThread���жϲ���,����
							Thread.currentThread().interrupt();
							return;
						}
					}
					//ȡ��һ��jobs
					job=jobs.removeFirst();
				}
				if(jobs!=null){
					try{
						job.run();
					}catch(Exception e){
						//����job�е�Exception
					}
				}
			}
		}
		
		//�º͵���ֹ�߳�,ʹ���߳�����ֹʱ�л���ȥ������Դ
		public void shutdown(){
			running = false;
		}
	}
	
}
