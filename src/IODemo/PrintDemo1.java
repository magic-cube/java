package IODemo;
/*
 * �����PrintStream
 * out��Ĭ�����λ��Ϊdos���ڣ�ps.setOut(ps),�ı������λ��ΪĿ���ļ���λ��
 */
import java.io.*;
public class PrintDemo1 {
	public static void main(String args[]){
		PrintStream ps=null;
		try{
			FileOutputStream fos=new FileOutputStream("C:/my/haochuan.txt");
			ps= new PrintStream(fos);
		}catch(IOException e){
			e.printStackTrace();
		}
		if(ps!=null){
			
			System.setOut(ps);
		}
		int n=0;
		int len=0;
		int len2=0;
		for(int i=0;i<300;i++){
			System.out.print((char)i);
//			//�����ʮ���ַ���һ��
//			if(len2++>=20){
//				System.out.print("\t");
//				len2=0;
//			}
			//���ü��һ�ٸ��ַ���һ��
			if(len++>=60){
				System.out.println();
				len=0;
			}
			
		}
	}
}
