package GenericTest;
/**
 * �Զ��巺����
 * 1. <>  ������д��ĸ�������ܼ���֪��
 * 2. T Type  
 * 	  K V  Key Value
 * 	  E Element 
 * 3.ע�⣺ ���Ͳ���ʹ���ھ�̬������
 * 		    ָ�������Ͳ����ǻ�������
 * @author hc
 *
 */
public class MyStudents<T> {
	private T javase;
	
	//private statci T t;       ���Ͳ���ʹ���ھ�̬������
	
	public MyStudents(){
		
	}
	public MyStudents(T javase){
		this.javase=javase;
	}
	
	public T getJavase(){
		return javase;
	}
	public void setJavase(T javase){
		this.javase=javase;
	}

}
