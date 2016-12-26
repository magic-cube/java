package safe;

import java.util.Scanner;

public class bank5 {
	int[] available;//可用资源
	int max[][];//最大资源数
	int allocation[][];//已分配的资源数
	int need[][];//尚需的资源数
	public void scan(){
		Scanner in=new Scanner(System.in);
		System.out.println("请输入进程数目以及所请求的资源个数：");
		int m=in.nextInt();
		int n=in.nextInt();
		max=new int[m][n];
		allocation=new int[m][n];
		need=new int[m][n];
		available=new int[n];
		System.out.println("请输入可用资源的数目：");
		for(int i=0;i<available.length;i++){
			available[i]=in.nextInt();
		}
		System.out.println("请依次输入进程最大需求的资源数目：");
		for(int i=0;i<max.length;i++){
			for(int j=0;j<max[i].length;j++){
				max[i][j]=in.nextInt();
			}
		}
		
		System.out.println("请依次输入进程已分配的资源数目：");
		for(int i=0;i<allocation.length;i++){
			for(int j=0;j<allocation[i].length;j++){
				allocation[i][j]=in.nextInt();
			}
		}
		
		System.out.println("请依次输入进程需要的资源数目：");
		for(int i=0;i<need.length;i++){
			for(int j=0;j<need[i].length;j++){
				need[i][j]=in.nextInt();
			}
		}
		
	}
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
			int a=available[0];
			int b=available[1];
			int c=available[2];
			boolean flag=checkSafe(a,b,c);
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
	public boolean checkSafe(int a,int b,int c){
		//工作向量work  此时的可用资源数
		int [] work=new int[3];
		work[0]=a;work[1]=b;work[2]=c;
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
		bank5 b=new bank5();
		b.scan();
		boolean flag=b.checkSafe(3, 3, 2);
		if(flag==true){
			System.out.println("此时系统处于安全状态");
		}
		System.out.println("t0时刻资源分配表：");
		b.show();
		b.init();
		
//		int request[]=new int[]{3,3,1};
//		b.banker(4, request);
	}

}
