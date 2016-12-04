package IODemo;
import java.io.*;
public class TestFileOutputStream {
	public static void main(String args[]){
		int b=0;
		FileInputStream in =null;
		FileOutputStream out =null;
		try{
			in=new FileInputStream("C:/Users/hc/workspace/1/src/IODemo/TestFileInputStream.java");
			out=new FileOutputStream("C:/my/TestFileInputStream.java");
			while((b=in.read())!=-1){
				System.out.print((char)b);
			}
			while((b=in.read())!=-1){
				out.write(b);
			}
			in.close();
			out.close();
		}catch(FileNotFoundException e){
			System.out.println("未找到指定文件");
			System.exit(-1);
		}catch(IOException e2){
			System.out.println("文件复制错误");
		}
		System.out.println("文件复制成功");
	}
}
