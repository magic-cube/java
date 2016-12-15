package socket;
import java.io.*;
import java.net.*;
public class TestSockClient {

	public static void main(String[] args) {
		try{
			//LocalHost
			Socket s=new Socket("127.0.0.1",999);
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		
			dos.writeUTF("hi,i am client");
			String str;
			if((str=dis.readUTF())!=null){
				System.out.println(str);
			}
		}catch(Exception e){
			
		}
	}

}
