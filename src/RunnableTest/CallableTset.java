package RunnableTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * �����̵߳ķ���֮��
 * 1.ʵ��Callable�ӿ�,��дcall
 * 2.����ִ�е�����ExecutorService
 * @author hc
 *
 */
public class CallableTset {
	public static void main(String args[]) throws InterruptedException, ExecutionException{
		//�����߳�
		ExecutorService ser=Executors.newFixedThreadPool(1);
		R r1=new R();
		//��ȡֵ
		Future<Integer> result=ser.submit(r1);
		int n=result.get();
		System.out.println(n);
		//ֹͣ����
		ser.shutdownNow();
	}
}
class R implements Callable<Integer>{
	public Integer call(){
		return 1000;
	}
}