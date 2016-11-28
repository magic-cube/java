package Demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 分拣存储
 * 即，分组归类，一对多
 * 
 * 统计单词出现的次数
 * i feel like i am always searching for something , for someone
 * 
 * 1.分割字符串
 * 2.分拣存储
 * 3.按要求查看单词出现次数
 * 
 * @author hc
 *
 */
public class MapDemo1 {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		Map<String,MapDemo2> map2 = new HashMap<String,MapDemo2>();
		//分割字符串
		String[] str="i feel like i am always searching for something , for someone".split(" ");
		
		//分拣存储
		for(String key:str){
			//System.out.println(key);       //查看是否将字符串成功分割
			
			//分拣
//			if(!map.containsKey(key)){         //查看是否存在该单词
//				map.put(key, 1);
//			}else{             //不存在
//				map.put(key, map.get(key)+1);         //如果不存在，将value的值加一，用于统计字符串出现的次数
//			}
			
			//另一种写法
			Integer value=map.get(key);
			if(null==value){
				map.put(key, 1);
			}else{
				map.put(key, value+1);
			}
			
			
			//
			MapDemo2 value2=map2.get(key);
			if(null==value2){
				value2=new MapDemo2();
				map2.put(key, value2);
			}
			value2.setCount(value2.getCount()+1);
			
		}
		//查看
		//遍历key
		Set<String> keySet =map.keySet();
		for(String key:keySet){
			Integer value=map.get(key);
			System.out.println(key+" : "+value);
		}
	}		

}

//。。。。
class EntryM{
	private Object key;
	private Object value;
	EntryM(){
		
	}
	EntryM(Object key,Object value){
		this.key=key;
		this.value=value;
	}
}
