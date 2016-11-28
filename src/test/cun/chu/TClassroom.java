package test.cun.chu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TClassroom {
	//private Map<Integer,ClassRoom> map= new HashMap<Integer,ClassRoom>();
	
	/*
	 * ��list�д��ѧ������
	 */
	public List<Student> init(){
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1,"haochuan",100));
		list.add(new Student(2,"junzhao",90));
		list.add(new Student(2,"aguang",80));
		return list;
	}
	/*
	 * ͳ�Ʒ���
	 * ������󣬷ּ�洢
	 */
	public Map<Integer,ClassRoom>  count(List<Student> list){
		Map<Integer,ClassRoom> map = new HashMap<Integer,ClassRoom>();
		//����list���������ڸñ�ŵİ༶�������������ڣ����
		for(Student s:list){
			String name=s.getName();
			int no=s.getNo();
			int score=s.getScore();
			ClassRoom c = map.get(no);
			if(null==c){
				c=new ClassRoom();
				map.put(no, c);
			}
			c.getList().add(s);
			c.setTotal(c.getTotal()+score);
			
		}
		return map; 
	}
	/*
	 * ����Map
	 * ͳ�Ʋ鿴ÿ������ܷ֣�ƽ����
	 */
	public  void view(Map<Integer,ClassRoom> map){
		Set<Integer> set =map.keySet();
		//��ȡ����������
		Iterator<Integer> it =set.iterator();
		while(it.hasNext()){
			Integer no=it.next();
			ClassRoom c= map.get(no);
			//��ȡ�ܷ֣�����ƽ����
			double totalScore=c.getTotal();
			double avgScore=totalScore/(c.getList().size());
			System.out.println("no:"+no+"--> "+"total:"+totalScore+"-->  "+"avg:"+avgScore);
		}
		
	}
	public static void main(String[] args) {
		TClassroom t = new TClassroom();
		List<Student> list=t.init();
		Map<Integer,ClassRoom> map=t.count(list);
		t.view(map);
		
	}

}
