import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ForTest {
	/*
	 * ��ǿforѭ����ʹ��
	 * ֻ���������ʵ����IterAble�ļ�����
	 */
	
	@Test
	public void test1(){
		int arr[]={1,2,4};
		for(int i :arr){
			System.out.println(i);
		}
	}
	
	@Test
	public void test2(){
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		for(Integer i:list){
			System.out.println(i);
		}
	}
}
