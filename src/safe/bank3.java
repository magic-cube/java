package safe;
/**
 * 不能多次分配，此时work与available指向同一个地方
 */
import java.util.Scanner;

public class bank3 {
	int available[] = new int[]{3,3,2};//可用资源
	int max[][] = new int[][]{{7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3}};//最大资源数
	int allocation[][] = new int[][]{{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}};//已分配的资源数
	int need[][] = new int[][]{{7,4,3},{1,2,2},{6,0,0},{0,1,1},{4,3,1}};//尚需的资源数

	void show(){
		System.out.println("进程号      Max   Allocation Need   ");
		System.out.println("     A  B  C  A  B  C  A  B  C");
		for(int i = 0;i<5;i++){
			System.out.print(i+"    ");
			for(int m = 0;m<3;m++){
				System.out.print(max[i][m]+"  ");
			}
			for(int m = 0;m<3;m++){
				System.out.print(allocation[i][m]+"  ");
			}
			for(int m = 0;m<3;m++){
				System.out.print(need[i][m]+"  ");
			}
			System.out.println();
		}
	}
	//银行家算法
	public boolean banker(int n,int []request){
		int num=n;
		int[] Request=request;//请求的资源
		if((Request[0]<=need[n][0]&&Request[1]<=need[n][1]&&Request[2]<=need[n][2])==false){
			System.out.println("错误，请求资源超过了所宣布最大值");
			return false;
		}
		if((Request[0]<=available[0]&&Request[1]<=available[1]&&Request[2]<=available[2])==false){
			System.out.println("尚无足够资源,等待");
			return false;
		}else{
			//试分配
			for(int i=0;i<3;i++){
				available[i]=available[i]-Request[i];
				allocation[n][i]=allocation[n][i]+Request[i];
				need[n][i]=need[n][i]-Request[i];
			}
//测试available的值
//System.out.println("available的值：");
//for(int i=0;i<available.length;i++){
//	System.out.print(available[i]+" ");
//}
			System.out.println();
			//安全性检查
			boolean flag=checkSafe(available);
			if(flag==true){//安全性检查通过
				System.out.println("可以安全分配");
				return true;
				
			}else{//未通过安全性检查
				System.out.println("不能够安全分配");
				//恢复之前的数据
				for(int i=0;i<3;i++){
					available[i]=available[i]+Request[i];
					allocation[n][i]=allocation[n][i]-Request[i];
					need[n][i]=need[n][i]+Request[i];
				}
				return false;
			}
		}
	}
	//安全性算法
	public boolean checkSafe(int availa[]){
		//工作向量work  此时的可用资源数
		int [] work=availa;
		System.out.print("work的初值：");
		for(int i=0;i<work.length;i++){
			System.out.print(work[i]+" ");
		}
		System.out.println();
		boolean finish[]=new boolean[5];//值默认false
		int i=0;
		while(i<5){
			if(finish[i]==false&&need[i][0]<=work[0]&&need[i][1]<=work[1]&&need[i][2]<=work[2]){
				
				for(int j=0;j<3;j++){
					work[j]=work[j]+allocation[i][j];
				}
				System.out.print("此时work的值：");
				for(int j=0;j<work.length;j++){
					System.out.print(work[j]+" ");
				}
				System.out.println("    "+i+"成功分配");
				finish[i]=true;
				//重新重未分配中的找
				i=0;
			}else{
				//未找到符合要求的，找一下个
				i++;
			}
		}
		//判断finish是否都为true
		for(int j=0;j<5;j++){
			if(finish[j]==false){
				return false;
			}
		}
		return true;
	}
	//初始化
	public void init(){
		while(true){
			Scanner in=new Scanner(System.in);
			System.out.println("请输入发起请求的进程（0-4）：");
			int n=in.nextInt();
			System.out.println("请依次输入所请求各类资源的个数:");
			int request[]=new int[3];
			for(int i=0;i<request.length;i++){
				request[i]=in.nextInt();
			}
			banker(n,request);
//System.out.println("available的值：");
//for(int i=0;i<available.length;i++){
//	 System.out.print(available[i]+" ");
//}
			System.out.println("资源分配表：");
			show();
			System.out.println("是否继续请求分配（y/n）");
			String s=in.next();
			if(s.equalsIgnoreCase("n")){
				break;
			}
		}
	}
	
	public static void main(String args[]){
		bank3 b=new bank3();
		System.out.println("t0时刻资源分配表：");
		b.show();
		b.init();
		
//		int request[]=new int[]{3,3,1};
//		b.banker(4, request);
	}

}
