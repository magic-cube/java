package java2;
import java.io.*;
import java.net.*;

public class TCPClient2 {
	public static void main(String args[]){
		//请求连接
		try{
			Socket client=new Socket("127.0.0.1",9999);
			//利用流传送数据
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			dos.writeInt(20);
			
			dos.close();
			client.close();
		}catch(IOException e){
			System.out.println("请求建立连接失败");
			e.printStackTrace();
		}
	}
}
