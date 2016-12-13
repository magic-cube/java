package RunnableTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 创建线程的方法之三
 * 1.实现Callable接口,重写call
 * 2.借助执行调度器ExecutorService
 * @author hc
 *
 */
public class CallableTset {
	public static void main(String args[]) throws InterruptedException, ExecutionException{
		//创建线程
		ExecutorService ser=Executors.newFixedThreadPool(1);
		R r1=new R();
		//获取值
		Future<Integer> result=ser.submit(r1);
		int n=result.get();
		System.out.println(n);
		//停止服务
		ser.shutdownNow();
	}
}
class R implements Callable<Integer>{
	public Integer call(){
		return 1000;
	}
}