package IODemo;
/*
 * 输出流PrintStream
 * out的默认输出位置为dos窗口，ps.setOut(ps),改变了输出位置为目标文件的位置
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
//			//间隔二十个字符换一列
//			if(len2++>=20){
//				System.out.print("\t");
//				len2=0;
//			}
			//设置间隔一百个字符换一行
			if(len++>=60){
				System.out.println();
				len=0;
			}
			
		}
	}
}
