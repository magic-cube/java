import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//List的常用算法
public class NormalList {

	public static void main(String[] args) {
		List l1 = new LinkedList();
		for(int i=0;i<5;i++){
			l1.add("a"+i);
		}
		System.out.println(l1);
		//随机排列
		Collections.shuffle(l1);
		System.out.println(l1);
		//排序
		Collections.sort(l1);
		System.out.println(l1);
		//采用“折半”查找法查找
		System.out.println(Collections.binarySearch(l1,"a1"));
		
		//逆序
		//链表的逆序，效率要更高一些，只需改变一下指针
		Collections.reverse(l1);
		System.out.println(l1);
		
	}

}
