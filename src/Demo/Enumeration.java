package Demo;

public class Enumeration {
	
	
	//������õ�ʱ���ֻ�ܴ��ݹ涨�õ�ֵ�������ܴ��ⲿȥnew
	public void test(){
		print(Grade.A);
	}
	
	public void print(Grade g){	//A B C D E
		
	}
	
}
class Grade{
	
	/*
	 * jdk1.5֮ǰ��ʹ���Զ�������ʵ��
	 * ˽�л�����������ֹ�ⲿ���ⴴ������
	 */
	private Grade(){
		
	}
	
	public static final Grade A=new Grade();
	public static final Grade B=new Grade();
	public static final Grade C=new Grade();
	public static final Grade D=new Grade();
	public static final Grade E=new Grade();
}