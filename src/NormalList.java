import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
//List�ĳ����㷨
public class NormalList {

	public static void main(String[] args) {
		List l1 = new LinkedList();
		for(int i=0;i<5;i++){
			l1.add("a"+i);
		}
		System.out.println(l1);
		//�������
		Collections.shuffle(l1);
		System.out.println(l1);
		//����
		Collections.sort(l1);
		System.out.println(l1);
		//���á��۰롱���ҷ�����
		System.out.println(Collections.binarySearch(l1,"a1"));
		
		//����
		//���������Ч��Ҫ����һЩ��ֻ��ı�һ��ָ��
		Collections.reverse(l1);
		System.out.println(l1);
		
	}

}
