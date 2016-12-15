package socket;
import java.io.*;
import java.net.*;
public class TestClient {
	public static void main(String args[]){
		try{
			Socket s1=new Socket("127.0.0.1",8888);
			DataInputStream dis=new DataInputStream(s1.getInputStream());
			System.out.println(dis.readUTF());
			dis.close();
			s1.close();
		}catch(ConnectException conn){
			conn.printStackTrace();
			System.out.println("服务器连接失败");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
