import java.util.Random;

/**
 * ϣ������
 * @author hc
 *
 */
public class Shell_sort {
	static int count1;
	static int count2;
	public static void ShellSort(int a[],int n){
		for(int d=n/2;d>0;d/=2){  /*ϣ����������*/
			for(int j=d;j<n;j++){
				int temp=a[j];
				int i;
				for(i=j;i>=d&&a[i-d]>temp;i-=d){
					a[i]=a[i-d];
					count2++;
				}
				a[i]=temp;
			}
		}
	}
	public static void InsertionSort(int a[],int n){
		for(int j=1;j<n;j++){
			int temp=a[j];   
			int i;
			for(i=j;i>0&&a[i-1]>temp;i--){
				a[i]=a[i-1];
				count1++;
			}
			a[i]=temp;
		}
	}
	public static void BubbleSort(int a[],int n){
		for(int j=1;j<n;j++){
			int flag=0;
			for(int i=0;i<n-j;i++){
				if(a[i]>a[i+1]){
					int temp=a[i];
					a[i]=a[i+1];
					a[i+1]=temp;
					flag=1;
				}
				if(flag==0){
					break;
				}
			}
		}
	}
	public static void main(String args[]){
		int a[]={0,89,2,23,1,56,92,15,7,21,9,24,78,98,6,54,33,12,76,88,34,99};
		int b[]={0,89,2,23,1,56,92,15,7,21,9,24,78,98,6,54,33,12,76,88,34,100};
		int n=a.length;
		ShellSort(a,n);
		System.out.println("ϣ����������");
		for(int i=0;i<n;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println("��������"+count2+"�ν���");
		int n1=b.length;
		InsertionSort(b,n1);
		System.out.println("������������");
		for(int i=0;i<n;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		System.out.println("��������"+count1+"�ν���");
		
		

	}
}
