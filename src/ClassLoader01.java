/**
 * 测试类加载的全过程
 * 1.加载，将字节码文件加载到内存中，在堆中生成一个Class对象，类加载器参与
 * 2.链接，验证（是否符合JVM规范），准备（为静态域分配存储空间），解析（虚拟机将常量池中的符号引用替换为直接引用的过程）
 * 3.初始化，初始化静态域的存储空间
 * @author hc
 *
 */

public class ClassLoader01 {
	
	
	static{
		System.out.println("静态初始化类ClassLoader");
	}
	
	public static void main(String args[]){
		System.out.println("类ClassLoader的main方法");
		A a=new A();
		System.out.println(A.width+"\n");
		
		A a2=new A();
		System.out.println("第二次被加载时，发现：所有的静态动作均为发生");
		/*
		 * 静态初始化，只有在类被首次加载时才会发生
		 */
		System.out.println("\n从width的值以及各个语句的打印顺序可以看出，构造器的执行是最后发生的");
		System.out.println("总结：初始化顺序，如果有父类，先进行父类的一系列动作，之后先静态对象，"
				+ "\n之后是非静态对象，最后是构造器");
	}
}
class A extends A_Father{
	/*
	 * 类加载过程中初始化顺序：
	 * 静态初始化-->普通初始化-->构造器（构造器隐式的也是静态的）
	 * 最早的时候，我们都知道，创建一个类的对象时，会调用它的构造器，
	 * 其本质原因是在进行静态初始化，因为构造器隐式的也是静态的
	 * 很残酷，构造器从本来认知中的第一个执行变成了最后一个执行
	 */
	public static int width=100;
	static{
		System.out.println("静态初始化类A的动作发生了");
		width=300;
	}
	public A(){
		System.out.println("类A的构造器被执行了");
		width=1000;
	}
	/*
	 * 我们无法阻止自动初始化的发生，并且他会在构造器被调用之前发生
	 */
}
/*
 * 当然，也会调用Object类的static块
 *
 */
class A_Father /*extends Object*/{
	static{
		System.out.println("静态初始化类A_Father");
	}
	public A_Father(){
		System.out.println("类A_Father的构造方法执行了");
	}
}






