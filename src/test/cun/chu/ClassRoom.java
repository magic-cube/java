package test.cun.chu;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
	private int no;		//�༶��
	private int total;  //�ܷ�
	private List<Student> list;         //ѧ���б�
	ClassRoom(){
		list=new ArrayList();
	}
	ClassRoom(int no){
		super();
		this.no=no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
class Student{
	private int no;			//�༶��
	private int score;		//�ɼ�	
	private String name;	//����
	
//	private int id;        //ѧ��
	public Student() {
	
	}
	public Student(int no,String name, int score) {
		super();
//		this.id=id;
		this.no=no;
		this.name = name;
		this.score = score;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	
	
	
}


















