import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//Iterator�����remove�����ǵ���������ɾ��Ԫ�ص�Ψһ�İ�ȫ�ķ���
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
				//������c.remove()  ���������
			}
			System.out.println(s);
			//System.out.println((String)i.next());
		}
		System.out.println("------");
		//foreach����ȷ��ɾ��
		for(String s:c){
			System.out.println(s);
		}
		System.out.println();
		
		String a ="bbbbb";
		System.out.println(a.length());
	}

}
