package synread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * ֻ������
 * 1.emptyXxx()-->�յĲ��ɱ伯��
 * 2.singletonXxx() -->һ��Ԫ�صĲ��ɱ伯��
 * 3.unmodifiableXxx()	-->���ɱ�����
 * 
 * emptyList  .... set  Map
 * singletonLis   ....  set   Map
 * unmodifiableList  ...   set   Map
 * 
 * @author hc
 *
 */
public class Demo02 {
	public static void main(String args[]){
		List<String> list = new ArrayList<String>();
		list.add("a");
		//��ϣ������list�����Ԫ��
		//ֻ������,������һ������list���ջ���˵��ͼ�Ķ��������������������Ӷ�������������ԭ������Ӷ���
		List<String> list2= Collections.unmodifiableList(list);
		
		list.add("b");
		
		//list2.add("a");
		for(String s:list2){
			System.out.println(s);
		}
		
	}
	public static Set<String> f(Set<String> set){
		if(null==set){
			//����һ����Ԫ�ؼ��ϣ��������ⲿ��ȡNullPointerExceptin����ָ���쳣
			return Collections.EMPTY_SET;
		}
		return set;
	}
}
