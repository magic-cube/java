package safe;

public class bank {
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
		if(!(Request[0]<=need[n][0]&&Request[1]<=need[n][1]&&Request[2]<=need[n][2])){
			System.out.println("错误，请求资源超过了所宣布最大值");
			return false;
		}
		if(!(Request[0]<=available[0]&&Request[1]<=available[1]&&Request[2]<=available[2])){
			System.out.println("尚无足够资源,等待");
			return false;
		}
		//试分配
		for(int i=0;i<3;i++){
			available[i]=available[i]-Request[i];
			allocation[n][i]=allocation[n][i]+Request[i];
			need[n][i]=need[n][i]-Request[i];
		}
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
	//安全性算法
	public boolean checkSafe(int availa[]){
		//工作向量work  此时的可用资源数
		int [] work=availa;
		System.out.print("此时work的值：");
		for(int i=0;i<work.length;i++){
			System.out.print(work[i]+" ");
		}
		System.out.println();
		boolean finish[]=new boolean[5];//值默认false
		/**
		 * 这块没有检查零，导致结果错误
		 */
		int i=0;
		for(;i<5;i++){
			if(finish[i]==false&&need[i][0]<=work[0]&&need[i][1]<=work[1]&&need[i][2]<=work[2]){
				
				for(int j=0;j<3;j++){
					work[j]=work[j]+allocation[i][j];
				}
//				System.out.print("此时work的值：");
//				for(int i=0;i<work.length;i++){
//					System.out.print(work[i]+" ");
//				}
				System.out.println(i+"成功分配");
				finish[i]=true;
				//重新重未分配中的找
				i=0;
			}
			//未找到符合要求的，找一下个
		}
		//判断finish是否都为true
		for(int j=0;j<5;j++){
			if(finish[j]==false){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		bank b=new bank();
		b.show();
		int request[]=new int[]{1,0,2};
		b.banker(1, request);
	}

}
