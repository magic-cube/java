import java.util.Scanner;
//×Ö·û´®µÄÄæÐò
public class Cl {
	public static void main(String args[]){
		String s;
		Scanner in =new Scanner(System.in);
		s=in.nextLine();
		System.out.println(s.length());
		for(int i=s.length()-1;i>=0;i--){
			System.out.println(s.charAt(i));
		}
	}
}
