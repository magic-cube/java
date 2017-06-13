import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ª∫¥Ê¿‡
 * @author hc
 *
 */
public class CacheDemo {
	private Map<String,Object> cache=new HashMap<String,Object>();
	
	private Map m=new ConcurrentHashMap();
	private ReadWriteLock rwl=new ReentrantReadWriteLock();
	public Object get(String key){
		Object value=null;
		rwl.readLock().lock();
		try{
			value=cache.get(key);
			if(value==null){
				rwl.readLock().unlock();
				rwl.writeLock().lock();
				try{
					value="queryDB";
				}finally{
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
			}
		}finally{
			rwl.readLock().unlock();
		}
		return value;
	}
}
