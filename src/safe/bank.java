package safe;

public class bank {
	int available[] = new int[]{3,3,2};//������Դ
	int max[][] = new int[][]{{7,5,3},{3,2,2},{9,0,2},{2,2,2},{4,3,3}};//�����Դ��
	int allocation[][] = new int[][]{{0,1,0},{2,0,0},{3,0,2},{2,1,1},{0,0,2}};//�ѷ������Դ��
	int need[][] = new int[][]{{7,4,3},{1,2,2},{6,0,0},{0,1,1},{4,3,1}};//�������Դ��

	void show(){
		System.out.println("���̺�      Max   Allocation Need   ");
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
	//���м��㷨
	public boolean banker(int n,int []request){
		int num=n;
		int[] Request=request;//�������Դ
		if(!(Request[0]<=need[n][0]&&Request[1]<=need[n][1]&&Request[2]<=need[n][2])){
			System.out.println("����������Դ���������������ֵ");
			return false;
		}
		if(!(Request[0]<=available[0]&&Request[1]<=available[1]&&Request[2]<=available[2])){
			System.out.println("�����㹻��Դ,�ȴ�");
			return false;
		}
		//�Է���
		for(int i=0;i<3;i++){
			available[i]=available[i]-Request[i];
			allocation[n][i]=allocation[n][i]+Request[i];
			need[n][i]=need[n][i]-Request[i];
		}
		//��ȫ�Լ��
		boolean flag=checkSafe(available);
		if(flag==true){//��ȫ�Լ��ͨ��
			System.out.println("���԰�ȫ����");
			return true;
			
		}else{//δͨ����ȫ�Լ��
			System.out.println("���ܹ���ȫ����");
			//�ָ�֮ǰ������
			for(int i=0;i<3;i++){
				available[i]=available[i]+Request[i];
				allocation[n][i]=allocation[n][i]-Request[i];
				need[n][i]=need[n][i]+Request[i];
			}
			return false;
		}
	}
	//��ȫ���㷨
	public boolean checkSafe(int availa[]){
		//��������work  ��ʱ�Ŀ�����Դ��
		int [] work=availa;
		System.out.print("��ʱwork��ֵ��");
		for(int i=0;i<work.length;i++){
			System.out.print(work[i]+" ");
		}
		System.out.println();
		boolean finish[]=new boolean[5];//ֵĬ��false
		/**
		 * ���û�м���㣬���½������
		 */
		int i=0;
		for(;i<5;i++){
			if(finish[i]==false&&need[i][0]<=work[0]&&need[i][1]<=work[1]&&need[i][2]<=work[2]){
				
				for(int j=0;j<3;j++){
					work[j]=work[j]+allocation[i][j];
				}
//				System.out.print("��ʱwork��ֵ��");
//				for(int i=0;i<work.length;i++){
//					System.out.print(work[i]+" ");
//				}
				System.out.println(i+"�ɹ�����");
				finish[i]=true;
				//������δ�����е���
				i=0;
			}
			//δ�ҵ�����Ҫ��ģ���һ�¸�
		}
		//�ж�finish�Ƿ�Ϊtrue
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
