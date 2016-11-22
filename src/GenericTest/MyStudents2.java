package GenericTest;
/**
 * 自定义泛型类的使用
 * 在声明时指定具体类型，
 * 操作的必须是引用类型，不能是基本类型
 * @author hc
 *
 */
public class MyStudents2 {
	public static void main(String args[]){
		MyStudents<Integer> stu = new MyStudents<Integer>();
		//stu.setJavase("a");     提过编译期间类型检查      
		stu.setJavase(80);
		stu.getJavase();            //自动类型转换
	}
}
