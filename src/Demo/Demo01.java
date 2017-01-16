package Demo;

import org.junit.Test;

/*
 * 可变长参数
 */
public class Demo01 {
	
	@Test
	public void test1(){
		sum(1,2,3,4,5,6);
	}
	
	public void sum(int ...nums){
		int sum=0;
		for(int i:nums){
			sum+=i;
		}
		System.out.println(sum);
	}
}
