package GenericTest;
/**
 * ���ͷ�����ʹ��
 * ��ѭһ��׼�����ۺ�ʱ��ֻҪ������������Ӧ��ʹ�÷��ͷ���
 * ���ǿ����������ͨ����һ�����÷��ͷ���
 * @author hc
 *
 */
public class GenericMed {
	public <T> void f(T a){
		System.out.println(a.getClass().getName());
	}
	public static void main(String args[]){
		GenericMed gd = new GenericMed();
		Student1 s1 = new Student1();
		gd.f(s1);
	}
}
class Student1{
	
}
