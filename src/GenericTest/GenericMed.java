package GenericTest;
/**
 * 泛型方法的使用
 * 遵循一个准则：无论何时，只要你能做到，就应该使用泛型方法
 * 我们可以像调用普通方法一样调用泛型方法
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
