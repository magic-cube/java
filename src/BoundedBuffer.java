import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 固定大小的阻塞队列
 * @author hc
 *
 */
public class BoundedBuffer {
	
	final Lock lock=new ReentrantLock(); 
	final Condition full=lock.newCondition();
	final Condition empty=lock.newCondition();
	
	final Object [] items=new Object[100];
	
	private int count,takeptr,putptr;
	
	public void put(Object value){
		try{
			lock.lock();
			while(count==items.length){
				try {
					full.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			items[putptr]=value;
			if(++putptr==items.length){
				putptr=0;
			}
			count++;
			
			empty.signal();
		}finally{
			lock.unlock();
		}
	}
	
	public Object take(){
		try{
			lock.lock();
			while(count==0){
				try{
					empty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Object value=items[count];
			
			if(++takeptr==items.length){
				takeptr=0;
			}
			count--;
			
			full.signal();
			
			return value;
		}finally{
			lock.unlock();
		}
	}
}


