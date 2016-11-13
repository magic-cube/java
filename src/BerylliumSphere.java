
public class BerylliumSphere {
	public static BerylliumSphere[] f(int n){
		BerylliumSphere [] a = new BerylliumSphere[n];
		for(int i=0;i<n;i++){
			a[i]=new BerylliumSphere();
		}
		return a;
	}
	public static void main(String args[]){
		BerylliumSphere []s=f(10);
	}
}
