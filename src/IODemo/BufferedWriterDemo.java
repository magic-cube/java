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
				//换行
				bw.newLine();
			}
			//将流中的数据全部写出到目的地
			bw.flush();
			//读到文件末尾
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
