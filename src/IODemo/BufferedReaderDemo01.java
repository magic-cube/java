package IODemo;
import java.io.*;
/**
 * 缓冲流
 * 缓冲流要套接在相应的节点流之上，对读写的数据提供了缓冲的功能，提高了读写的效率
 * 缓冲区：显著的减少了对硬盘的读写次数，保护了硬盘
 * 
 * BufferedReader（Reader in）
 * BufferedReader（Reader in, int size） 自定义缓冲区的大小
 * 
 * @author hc
 *
 */
public class BufferedReaderDemo01 {
	public static void main(String args[]){
		try{
			BufferedReader br = new BufferedReader(new FileReader("C:/my/test.txt"));
			String s=null;
			/*
			 * BufferedReader有一个很好用的方法如下
			 * readLine(),当做字符串，一次读取一行
			 * 即便只是为了这个方法而要给别的流上套上BufferedReader也是值得的
			 */
			while((s=br.readLine())!=null){
				System.out.print(s);
			}
			br.close();
		}catch(IOException e1){
			e1.printStackTrace();
		}
	}
}
