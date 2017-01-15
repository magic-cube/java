import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//Person的测试类
public class JunitTest {
	
	/*
	 * 加上before和after注解的方法会在每个测试方法执行前后都执行一遍
	 * 例如，可以在before中写资源的初始化代码，在after中写资源的释放代码 
	 */
	
	//因为每个都需要类Person的对象，在这块维护一个对象
	//这样就不需要在每个测试方法中都创建一遍对象了
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
		//释放资源
		p=null;
	}
	
	
}
