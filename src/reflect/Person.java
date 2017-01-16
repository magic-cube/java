package reflect;

import java.util.List;

public class Person {
	
	private int age=10;
	
	public String name="aaa";
	
	public Person(){
		System.out.println("personÎŞ²Î");
	}
	public Person(String name){
		System.out.println("person name");
	}
	
	private Person(int i){
		System.out.println("list");
	}
}
