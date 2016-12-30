/*
 * 类加载器的层次结构
 * 存在逻辑上的父子关系，但内部并不是以继承的形式实现，而采用组合的方式
 */
public class ClassLoader02 {
	public static void main(String args[]){
		System.out.println("类加载器的层次结构");
		//AppClassLoader
		System.out.println(ClassLoader.getSystemClassLoader());
		//ExtClassLoader
		System.out.println(ClassLoader.getSystemClassLoader().getParent());
		//因为引导类加载器是用原生代码写的，因而java获取不到
		System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
		
		
	}
}
