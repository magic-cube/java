import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//Iterator对象的remove方法是迭代过程中删除元素的唯一的安全的方法
public class IteratorTest {
	
	public static void main(String[] args) {
		Collection<String > c = new ArrayList<String>();
		c.add("aaa");
		c.add("bbbb");
		c.add("c");
		Iterator<String> i =c.iterator();
		while(i.hasNext()){
			String s= i.next();
			
			if(s.length()>3){
				i.remove();
				//若果是c.remove()  会产生例外
			}
			System.out.println(s);
			//System.out.println((String)i.next());
		}
		System.out.println("------");
		//foreach遍历确认删除
		for(String s:c){
			System.out.println(s);
		}
		System.out.println();
		
		String a ="bbbbb";
		System.out.println(a.length());
	}

}
