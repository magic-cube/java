package IODemo;
import java.io.*;
/*
 * 阻塞式程序，也称同步式程序，等待输入
 */
public class TestTransForm3 {
	public static void main(String args[]){
		InputStreamReader inr=new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(inr);
		String s=null;
		try{
			s=br.readLine();
			while(s!=null){
				if(s.equalsIgnoreCase("exit")) break;
				System.out.println(s.toUpperCase());
				s=br.readLine();
			}
			inr.close();
			br.close();
		}catch(IOException e){
			System.out.println("有猫饼！");
		}
	}
}
