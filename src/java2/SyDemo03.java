package java2;
/**
 * 单例设计模式
 * @author hc
 *
 */
public class SyDemo03 {
	public static void main(String args[]){
		
	}
}
/*
 * 饿汉式
 * 1.构造器私有化
 * 2.声明私有的静态属性，同时创建该对象
 * 3.创建一个对外的静态方法返回该变量
 */
class MyJvm1{
	private static MyJvm1 instance=new MyJvm1();
	private MyJvm1(){
		
	}
	public static MyJvm1 getJvm(){
		return instance;
	}
}
/*
 * 饿汉式，(提高效率)
 * 类在使用的时候才会被加载，属性一定会被加载，方法在用的时候才会被加载
 * 使用内部类，延缓加载时机，只要你没用到getJvm(),便不会加载
 * @author hc
 *
 */
class MyJvm3{
	//使用内部类，延缓加载时机
	public static class Jvmholder{
		private static MyJvm3 instance=new MyJvm3();
	}
	private MyJvm3(){
		
	}
	public static MyJvm3 getJvm(){
		return Jvmholder.instance;
	}
}
/*
 * 懒汉式
 * 1.构造器私有化
 * 2.声明私有的静态属性
 * 3.创建一个对外的静态方法返回该变量
 */
class MyJvm2{
	private static MyJvm2 instance=null;
	private MyJvm2(){
		
	}
	public static MyJvm2 getJvm(){
		//经典的双层检查机制
		if(instance==null){		//提高效率
			synchronized(MyJvm2.class){
				if(instance==null){		//保证安全
					instance=new MyJvm2();
				}
			}
		}
		return instance;
	}
}