package socket;
import java.io.*;
import java.net.*;

public class TestSockServer {
	public static void main(String args[]){
		try{
			ServerSocket ss=new ServerSocket(999);
			Socket s=ss.accept();
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			
			String str;
			if((str=dis.readUTF())!=null){
				System.out.println(str);
				System.out.println("From:"+s.getInetAddress());
				System.out.println("Port:"+s.getPort());
			}
			dos.writeUTF("hello,i am server");
			
			dos.close();
			dis.close();
			s.close();
		}catch(Exception e){
			
		}
	}
}
