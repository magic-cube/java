package java2;
import java.io.*;
import java.net.*;

public class TCPClient {
	public static void main(String args[]){
		//��������
		try{
			Socket client=new Socket("127.0.0.1",9999);
			//��������������
			DataOutputStream dos=new DataOutputStream(client.getOutputStream());
			dos.writeInt(10);
			
			dos.close();
			client.close();
		}catch(IOException e){
			System.out.println("����������ʧ��");
			e.printStackTrace();
		}
	}
}
