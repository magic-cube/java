import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//Person�Ĳ�����
public class JunitTest {
	
	/*
	 * ����before��afterע��ķ�������ÿ�����Է���ִ��ǰ��ִ��һ��
	 * ���磬������before��д��Դ�ĳ�ʼ�����룬��after��д��Դ���ͷŴ��� 
	 */
	
	//��Ϊÿ������Ҫ��Person�Ķ��������ά��һ������
	//�����Ͳ���Ҫ��ÿ�����Է����ж�����һ�������
	Person p;
	
	
	@Before
	public void before(){
		p=new Person();
		System.out.println("before!");
	}
	
	@Test
	public void testRun(){
		//Person p=new Person();
		p.run();
	}
	
	@Test
	public void testEat(){
		//Person p=new Person();
		p.eat();
	}
	
	@After
	public void after(){
		System.out.println("after!");
		System.out.println();
		//�ͷ���Դ
		p=null;
	}
	
	
}
