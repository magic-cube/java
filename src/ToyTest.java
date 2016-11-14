interface HasBatteries{
	void h();
}
interface Waterproof{
	void w();
}
interface Shoots{
	void s();
}

class Toy{
	Toy(){
		
	}
	Toy(int i){
		
	}
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
	FancyToy(){
		super(1);
	}
	public void h(){
		System.out.println("h");
	}
	public void w(){
		System.out.println("w");
	}
	public void s(){
		System.out.println("s");
	}
}

public class ToyTest{
	static void printinfo(Class cc){
		System.out.println("ClassName: "+cc.getName());
		System.out.println("is interface? "+cc.isInterface());
		System.out.println("SimpleName: "+cc.getSimpleName());
		System.out.println(cc.getCanonicalName());
		System.out.println();
	}
	public static void main(String args[]){
		//只是持有FancyToy的引用，而不是对象，不能去调用它的成员数据以及方法
		Class c=FancyToy.class;
		printinfo(c);
		System.out.println("-----分割线------");
		for(Class face:c.getInterfaces()){
			printinfo(face);
		}
		
		Class c2 =c.getSuperclass();
		printinfo(c2);
		System.out.println("----");
		
		//向Class引用添加泛型语法，让编译器强制执行额外的类型检查
		Class<?> intclass =int.class;
		intclass=double.class;
		
		
		//如果一个static域不是final的，那么对他访问时，总要求他在被读取之前，要先进行链接（为这个域分配存储空间），
		//和初始化（初始化该存储空间）
		
		
	}
}









