package annotation;

import java.util.ArrayList;
import java.util.List;

//默认继承自Object类
public class Demo01 /*extends Object*/{
	
	//使用自定义注解
	@MyAnnotation(name={"chuan","光"},stdName=" ",n=10)
	public void my(){
		
	}
	
	
	//重写Object类的toString方法
	@Override
	public String toString(){
		return "";
	}
	
	//废弃的方法，不建议使用
	@Deprecated
	public static void test(){
		
	}
	
	//抑制所有警告
	@SuppressWarnings("all")
	public void d1(){
		List list=new ArrayList();
	}
	
	public static void main(String[] args) {
		//废弃的方法,例如Data类的p什么方法
		test();
	}

}
