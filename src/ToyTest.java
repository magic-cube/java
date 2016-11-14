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
		//ֻ�ǳ���FancyToy�����ã������Ƕ��󣬲���ȥ�������ĳ�Ա�����Լ�����
		Class c=FancyToy.class;
		printinfo(c);
		System.out.println("-----�ָ���------");
		for(Class face:c.getInterfaces()){
			printinfo(face);
		}
		
		Class c2 =c.getSuperclass();
		printinfo(c2);
		System.out.println("----");
		
		//��Class������ӷ����﷨���ñ�����ǿ��ִ�ж�������ͼ��
		Class<?> intclass =int.class;
		intclass=double.class;
		
		
		//���һ��static����final�ģ���ô��������ʱ����Ҫ�����ڱ���ȡ֮ǰ��Ҫ�Ƚ������ӣ�Ϊ��������洢�ռ䣩��
		//�ͳ�ʼ������ʼ���ô洢�ռ䣩
		
		
	}
}









