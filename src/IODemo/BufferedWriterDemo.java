package IODemo;
import java.io.*;
public class BufferedWriterDemo {
	public static void main(String args[]){
		try{
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:/my/liuke.txt"));
			BufferedReader br = new BufferedReader(new FileReader("C:/my/liuke.txt"));
			String s=null;
			for(int i=1;i<=100;i++){
				s=String.valueOf(Math.random());
				bw.write(s);
				//����
				bw.newLine();
			}
			//�����е�����ȫ��д����Ŀ�ĵ�
			bw.flush();
			//�����ļ�ĩβ
			while((s=br.readLine())!=null){
				System.out.println(s);
			}
			
			bw.close();
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
