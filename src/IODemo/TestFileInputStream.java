package IODemo;
/**
 * java IO
 */
import java.io.*;

public class TestFileInputStream {

	public static void main(String[] args) {
		int b=0;
		FileInputStream in = null;
		try{
			in=new FileInputStream("C:/Users/hc/workspace/1/src/IODemo/TestFileInputStream.java");
		}catch(FileNotFoundException e){
			System.out.println("未找到指定文件");
			System.exit(-1);
		}
		
		
		try{
			long num=0;
			while((b=in.read())!=-1){
				System.out.print((char)b);
				//记录读取的字节数
				num++;
			}
			System.out.println();
			System.out.println("共读取了"+num+"个字节");
		}catch(IOException e){
			System.out.println("文件读取错误");
			System.exit(-1);
		}

	}

}
