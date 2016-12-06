package IODemo;
import java.io.*;
/**
 * 使用InputStream和OutputStream时是面向8位字节流
 * 一次操作一个字节
 * 使用Reader和Writer时是面向字符流  16bit  兼容了UniCode
 * 一次操作一个字符，两个字节
 * 所以使用InputStream时不能成功读取一个汉字，一个汉字两个字节，每次拿出半个字读。。。
 * 添加Reader和Writer继承继承结构就是为了在所有i/o操作中都能支持UniCode
 * @author hc
 *
 */
public class CopyDemo01 {
	public static void main(String args[]){
		int b=0;
		FileReader in = null;
		FileWriter out = null;
		try{
			in= new FileReader("C:/Users/hc/workspace/1/src/IODemo/TestFileInputStream.java");
			out = new FileWriter("C:/my/t1.java");
			/*
			 * 将源文件内容打印到控制台
			 * in.read()==-1时文件结束
			 * 同时将它写到输出流中
			 */
			while((b=in.read())!=-1){
				System.out.print((char)b);
				out.write(b);
			}
			//关闭输入
			in.close();
			//关闭输出
			out.close();
		}catch(FileNotFoundException e1){
			System.out.println("未找到指定文件");
			System.exit(-1);
		}catch(IOException e){
			System.out.println("文件复制出错！");
			System.exit(-1);
		}
	}
}
