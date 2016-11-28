package Demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * �ּ�洢
 * ����������࣬һ�Զ�
 * 
 * ͳ�Ƶ��ʳ��ֵĴ���
 * i feel like i am always searching for something , for someone
 * 
 * 1.�ָ��ַ���
 * 2.�ּ�洢
 * 3.��Ҫ��鿴���ʳ��ִ���
 * 
 * @author hc
 *
 */
public class MapDemo1 {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		Map<String,MapDemo2> map2 = new HashMap<String,MapDemo2>();
		//�ָ��ַ���
		String[] str="i feel like i am always searching for something , for someone".split(" ");
		
		//�ּ�洢
		for(String key:str){
			//System.out.println(key);       //�鿴�Ƿ��ַ����ɹ��ָ�
			
			//�ּ�
//			if(!map.containsKey(key)){         //�鿴�Ƿ���ڸõ���
//				map.put(key, 1);
//			}else{             //������
//				map.put(key, map.get(key)+1);         //��������ڣ���value��ֵ��һ������ͳ���ַ������ֵĴ���
//			}
			
			//��һ��д��
			Integer value=map.get(key);
			if(null==value){
				map.put(key, 1);
			}else{
				map.put(key, value+1);
			}
			
			
			//
			MapDemo2 value2=map2.get(key);
			if(null==value2){
				value2=new MapDemo2();
				map2.put(key, value2);
			}
			value2.setCount(value2.getCount()+1);
			
		}
		//�鿴
		//����key
		Set<String> keySet =map.keySet();
		for(String key:keySet){
			Integer value=map.get(key);
			System.out.println(key+" : "+value);
		}
	}		

}

//��������
class EntryM{
	private Object key;
	private Object value;
	EntryM(){
		
	}
	EntryM(Object key,Object value){
		this.key=key;
		this.value=value;
	}
}
