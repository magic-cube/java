import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class ForTest {
	/*
	 * 增强for循环的使用
	 * 只用于数组或实现了IterAble的集合类
	 */
	
	@Test
	public void test1(){
		int arr[]={1,2,4};
		for(int i :arr){
			System.out.println(i);
		}
	}
	
	@Test
	public void test2(){
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		for(Integer i:list){
			System.out.println(i);
		}
	}
	
	/*
	 * map的遍历,第一种方式,得到keySet，再用map.get()得到值;
	 */
	@Test
	public void test3(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		Set<String> set=map.keySet();
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String key=it.next();
			String value=map.get(key);
			System.out.println(key+":"+value);
		}
	}
	/*
	 * map的遍历,第二种方式
	 */
	@Test
	public void test4(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		Set entryset=map.entrySet();
		Iterator it=entryset.iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry=(Entry<String, String>) it.next();
			String key=entry.getKey();
			String value=entry.getValue();
			System.out.println(key+" "+value);
		}
	}
	
	/*
	 * 增强for遍历map的第一种方式
	 */
	@Test
	public void test5(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		for(String m:map.keySet()){
			String key=m;
			String value=map.get(key);
			System.out.println(key+" "+value);
		}
	}
	
	/*
	 * 增强for遍历map的第二种方式
	 */
	@Test
	public void test6(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		for(Entry<String, String> m:map.entrySet()){
			String key=m.getKey();
			String value=m.getValue();
			System.out.println(key+" "+value);
		}
	}
	
}
