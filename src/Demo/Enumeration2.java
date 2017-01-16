package Demo;

import org.junit.Test;

public class Enumeration2 {
	
	@Test
	public void test(){
		print(Age.E);
	}
	
	public void print(Age a){
		System.out.println(a.getValue());
	}
	
}
/*
 * jdk1.5֮��ʹ��ö�����������
 * ö������Ȼ�ĵ�������JVM��֤���ɷ�ֹ����ͷ����л���©��
 */
enum Age{
	A("100-90"),B("89-80"),C("79-70"),D("69-60"),E("59-0");
	
	private String value;
	private Age(String value){
		this.value=value;
	}
	
	public String getValue(){
		return this.value;
	}
	
}
