import java.util.Scanner;

public class T2 {	
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int n =in.nextInt();
		for(int i=2;i<=n;i++){
			if(n%i==0){
				n/=i;
				System.out.println(i);
			}
		}
	}
}
