package com.hc.thread;

public interface ThreadPool<Job extends Runnable> {
	
	//ִ��һ��Job,���Job��Ҫʵ��Runnable
	void execute(Job job);
	
	//�ر��̳߳�
	void shutdown();
	
	//���ӹ������߳�
	void adddWorders(int num);
	
	//���ٹ������߳�
	void removeWorkers(int num);
	
	//�õ����ڵȴ�ִ�е���������
	int getJobSize();
}
