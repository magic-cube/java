package synread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 只读控制
 * 1.emptyXxx()-->空的不可变集合
 * 2.singletonXxx() -->一个元素的不可变集合
 * 3.unmodifiableXxx()	-->不可变容器
 * 
 * emptyList  .... set  Map
 * singletonLis   ....  set   Map
 * unmodifiableList  ...   set   Map
 * 
 * @author hc
 *
 */
public class Demo02 {
	public static void main(String args[]){
		List<String> list = new ArrayList<String>();
		list.add("a");
		//不希望再向list中添加元素
		//只读控制,制作了一个类似list快照或者说视图的东西，不能向这个快照添加东西，但可以向原容器添加东西
		List<String> list2= Collections.unmodifiableList(list);
		
		list.add("b");
		
		//list2.add("a");
		for(String s:list2){
			System.out.println(s);
		}
		
	}
	public static Set<String> f(Set<String> set){
		if(null==set){
			//返回一个空元素集合，避免了外部获取NullPointerExceptin，空指针异常
			return Collections.EMPTY_SET;
		}
		return set;
	}
}
