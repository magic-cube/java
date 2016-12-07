package IODemo;
import java.io.*;
/**
 * ת����
 * InputStreamReader&OutputStreamWriter
 * StringBuilder��append����
 * ��󣡻���BufferedReader���á�����
 * @author hc
 *
 */
public class TestTransForm {
	
	public static void main(String[] args) {
		try{
			InputStreamReader inr=new InputStreamReader(new FileInputStream("C:/my/liuke.txt"));
			BufferedReader br=new BufferedReader(inr);
			String s;
			StringBuilder sb= new StringBuilder();
			while((s=br.readLine())!=null){
				sb.append(s+"\n");
			}
			inr.close();
			br.close();
			String sb2=sb.toString();
			System.out.println(sb2);
		}catch(IOException e){
			System.out.println("��è����");
		}
	}

}
