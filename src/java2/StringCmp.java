package java2;
/**
 * ��������ҵ����
 * @author hc
 *
 */
public class StringCmp implements java.util.Comparator<String>{
	/*
	 * �����ȱȽ�
	 * s1����>s2���ȣ���������
	 * 				    ����
	 * 				    ��
	 */
	public  int compare(String s1,String s2){
		int len1=s1.length();
		int len2=s2.length();
		return len1>len2?1:(len1==len2?0:-1);
		//Ҳ����ֱ�����
		//return len1-len2;
	}
	
	public static void main(String[] args) {
		String s1="aaaaa";
		String s2="aa";
		StringCmp sc= new StringCmp();
		System.out.println(sc.compare(s1, s2));

	}

}
