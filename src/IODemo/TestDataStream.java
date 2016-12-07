package IODemo;
/*
 * 数据流
 * DataInputStream与DataOutputStream
 * 属于处理流，需要套在节点流之上
 */
import java.io.*;
public class TestDataStream {
	public static void main(String args[]){
		//字节数组
		ByteArrayOutputStream baos= new ByteArrayOutputStream();
		DataOutputStream ds=new DataOutputStream(baos);
		try{
			//写进字节数组
			ds.writeDouble(Math.random());
			ds.writeBoolean(true);
			ByteArrayInputStream bais= new ByteArrayInputStream(baos.toByteArray());
			
			//输出bais中的字节数
			System.out.println(bais.available());
			
			DataInputStream dis= new DataInputStream(bais);
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			
			
			ds.close();
			dis.close();
		}catch(IOException e){
			
		}
	}
}
