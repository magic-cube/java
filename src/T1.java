import java.util.Scanner;

public class T1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n =in.nextInt();
		int []a =new int [10];
		int cnt=1;
		for(int i=0;i<cnt;i++){
			if(n==1){
				cnt--;
				break;
			}
			if(n%2==0){
				n=n/2;
				a[i]=2;
				cnt++;
			}else{
				a[i]=n;
			}
		}
		for(int i=0;i<cnt;i++){
			System.out.println(a[i]);
		}
	}

}
