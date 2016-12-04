package synread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 同步控制：多线程并发访问集合的线程安全
 * 常用容器ArrayList HashSet HashMap等都是线程不安全的
 * Collections提供了synchronizedXxx（）方法，将指定容器包装成同步
 * @author hc
 *
 */
public class Demo01 {
	public static void main(String args[]){
		List<String> list = new ArrayList<String>();
		list.add("a");
		//制作线程安全的list（同步）
		List<String> list2=Collections.synchronizedList(list);
		System.out.println("线程安全的list制作完毕！");
	}
}
