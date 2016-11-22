package GenericTest;
/**
 * 自定义泛型类
 * 1. <>  单个大写字母，尽可能见名知意
 * 2. T Type  
 * 	  K V  Key Value
 * 	  E Element 
 * 3.注意： 泛型不能使用在静态属性上
 * 		    指定的类型不能是基本类型
 * @author hc
 *
 */
public class MyStudents<T> {
	private T javase;
	
	//private statci T t;       泛型不能使用在静态属性上
	
	public MyStudents(){
		
	}
	public MyStudents(T javase){
		this.javase=javase;
	}
	
	public T getJavase(){
		return javase;
	}
	public void setJavase(T javase){
		this.javase=javase;
	}

}
