package GenericTest;
/**
 * ����
 * �ṩ�˱��������ͼ�飬ʡȥ��ǿ������ת���Ĳ���
 * ��Ϊ��ȫ������
 */
import java.util.ArrayList;
import java.util.List;

public class SimpleGeneric {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		
		//JDK1.4֮ǰ
		List l2 = new ArrayList();
		l2.add("a");
		l2.add(1);
		l2.add(1.2);
		
		//ȡ������ʱ�����ǿ������ת�� ���鷳
		Object o1=l2.get(0);
		String s1=(String)o1;
		
		//����ȫ
		//���׳�ClassCastException�쳣
		//Integer i1 =(Integer)l2.get(0);
		if(l2.get(0) instanceof Integer){
			Integer i1 =(Integer)l2.get(0);
		}

	}

}