import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

//一些乱七八糟的泛型，以及Iterator泛型的用法
public class ComparableDemo {
	public static void main(String  args[]){
		Collection<String> c = new ArrayList<String>();
		c.add("haochuan");
		c.add("asdasd");
		String []s1 ={"asdad","qweqwe","rtyery"};
		//添加一组数据   用Collections.addAll()
		Collections.addAll(c, s1);
		Iterator<String> it=c.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
//重写了compareTo方法，对于被用于TreeMap或者TreeSet的元素，必须实现compareable接口
//利用泛型，规定了只准许与泛型内的元素比较
class Name implements Comparable<Name>{
	int age;
	public int compareTo(Name n){
		if(this.age>n.age)return -1;
		else if(this.age<n.age)return 1;
		else return 0;
	}
}