package socket;
import java.io.*;
import java.net.*;
public class TestServer {
	public static void main(String args[]){
		try{
			ServerSocket ss=new ServerSocket(8888);
			while(true){
				Socket s1=ss.accept();
				DataOutputStream dos=new DataOutputStream(s1.getOutputStream());
				dos.writeUTF("hello\t"+s1.getInetAddress()+"\tport#\t"+s1.getPort()+"\nbye!");
				dos.close();
				s1.close();
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("程序运行出错");
		}
	}
}
