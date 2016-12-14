package java2;
/**
 * 单例设计模式
 * 懒汉式
 * 1.构造器私有化，防止外部直接创建对象
 * 2.声明一个私有的静态变量
 * 3.创建一个对外的公共静态方法访问该变量,如果该变量没有对象，创建该对象
 * @author hc
 *
 */
public class SynDemo02 {	
	public static void main(String args[]){
		//构造器私有化了，外部不能直接创建对象
		//Jvm j=new Jvm();
		Jvm jvm=Jvm.getJvm3();
		System.out.println(jvm.n);
	}
}
class Jvm{
	private static Jvm jvm=null;
	int n=10;
	private Jvm(){
		
	}
	public static Jvm getJvm3(){
		//加一层判断，如果存在对象，直接返回，提高了效率
		/*
		 * 经典的双层检查(Double Checking)
		 */
		if(null==jvm){
			synchronized(Jvm.class){
				if(null==jvm){
					try{
						Thread.sleep(1000);
					}catch(Exception e){
						e.printStackTrace();
					}
					jvm=new Jvm();
				}
			}
		}
		return jvm;
	}
	public static synchronized Jvm getJvm1(){
		if(null==jvm){
			try{
				//放大错误发生的概率
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
			jvm=new Jvm();
		}
		return jvm;
	}
	public static Jvm getJvm2(){
		//效率不高，发现即使存在对象，也需要等,
		synchronized(Jvm.class){
			if(null==jvm){
				try{
					Thread.sleep(1000);
				}catch(Exception e){
					e.printStackTrace();
				}
				jvm=new Jvm();
			}
		}
		return jvm;
	}

}
