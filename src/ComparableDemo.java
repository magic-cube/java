import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

//һЩ���߰���ķ��ͣ��Լ�Iterator���͵��÷�
public class ComparableDemo {
	public static void main(String  args[]){
		Collection<String> c = new ArrayList<String>();
		c.add("haochuan");
		c.add("asdasd");
		String []s1 ={"asdad","qweqwe","rtyery"};
		//���һ������   ��Collections.addAll()
		Collections.addAll(c, s1);
		Iterator<String> it=c.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
//��д��compareTo���������ڱ�����TreeMap����TreeSet��Ԫ�أ�����ʵ��compareable�ӿ�
//���÷��ͣ��涨��ֻ׼���뷺���ڵ�Ԫ�رȽ�
class Name implements Comparable<Name>{
	int age;
	public int compareTo(Name n){
		if(this.age>n.age)return -1;
		else if(this.age<n.age)return 1;
		else return 0;
	}
}