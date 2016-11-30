package java2;
/**
 * 排序规则的业务类
 * @author hc
 *
 */
public class StringCmp implements java.util.Comparator<String>{
	/*
	 * 按长度比较
	 * s1长度>s2长度，返回正数
	 * 				    负数
	 * 				    零
	 */
	public  int compare(String s1,String s2){
		int len1=s1.length();
		int len2=s2.length();
		return len1>len2?1:(len1==len2?0:-1);
		//也可以直接相减
		//return len1-len2;
	}
	
	public static void main(String[] args) {
		String s1="aaaaa";
		String s2="aa";
		StringCmp sc= new StringCmp();
		System.out.println(sc.compare(s1, s2));

	}

}
