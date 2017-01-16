package Demo;

public class Enumeration {
	
	
	//这里调用的时候就只能传递规定好的值，而不能从外部去new
	public void test(){
		print(Grade.A);
	}
	
	public void print(Grade g){	//A B C D E
		
	}
	
}
class Grade{
	
	/*
	 * jdk1.5之前，使用自定义类来实现
	 * 私有化构造器，防止外部随意创建对象
	 */
	private Grade(){
		
	}
	
	public static final Grade A=new Grade();
	public static final Grade B=new Grade();
	public static final Grade C=new Grade();
	public static final Grade D=new Grade();
	public static final Grade E=new Grade();
}