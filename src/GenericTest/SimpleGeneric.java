package GenericTest;
/**
 * 泛型
 * 提供了编译器类型检查，省去了强制类型转换的步骤
 * 更为安全，方便
 */
import java.util.ArrayList;
import java.util.List;

public class SimpleGeneric {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		
		//JDK1.4之前
		List l2 = new ArrayList();
		l2.add("a");
		l2.add(1);
		l2.add(1.2);
		
		//取出数据时需进行强制类型转换 很麻烦
		Object o1=l2.get(0);
		String s1=(String)o1;
		
		//不安全
		//会抛出ClassCastException异常
		//Integer i1 =(Integer)l2.get(0);
		if(l2.get(0) instanceof Integer){
			Integer i1 =(Integer)l2.get(0);
		}

	}

}