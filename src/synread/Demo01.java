package synread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ͬ�����ƣ����̲߳������ʼ��ϵ��̰߳�ȫ
 * ��������ArrayList HashSet HashMap�ȶ����̲߳���ȫ��
 * Collections�ṩ��synchronizedXxx������������ָ��������װ��ͬ��
 * @author hc
 *
 */
public class Demo01 {
	public static void main(String args[]){
		List<String> list = new ArrayList<String>();
		list.add("a");
		//�����̰߳�ȫ��list��ͬ����
		List<String> list2=Collections.synchronizedList(list);
		System.out.println("�̰߳�ȫ��list������ϣ�");
	}
}
