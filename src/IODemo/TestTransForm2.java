package IODemo;
import java.io.*;
/**
 * 转换流
 * 将字节流转换成字符流
 * OutputStreamWriter
 * true,在原有基础上添加
 * @author hc
 */
public class TestTransForm2 {
	public static void main(String args[]){
		try{
			OutputStreamWriter ops= new OutputStreamWriter(new FileOutputStream("C:/my/hc.txt",true));
			String s;
//			BufferedReader brd = new BufferedReader(new FileReader("C:/my/liuke.txt"));
//			while((s=brd.readLine())!=null){
//				ops.write(s);
//				System.out.println();
//			}
			//可以直接写一个字符串进去
			ops.write("abcdefj higklmn opq rst uvw xyzxyz now you see i can say my abc");
			//将输出流中的数据写出到目的地
			ops.flush();
			//要记得关
//			brd.close();
			ops.close();
		}catch(IOException e){
			System.out.println("有猫饼！");
		}
	}
}
