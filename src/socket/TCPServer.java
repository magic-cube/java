package socket;

import java.net.*;
import java.io.*;

/**
 * Server��
 * ��Ϊ��ȷ�����ж���Client��������������һ��Server������ѭ��
 * ÿ��һ������������accept()
 * accept()������ʽ��
 * @author hc
 *
 */
public class TCPServer {
	public static void main(String args[]) throws Exception{
		//��������
		ServerSocket ss=new ServerSocket(6666);
		//�ȴ�����
		while(true){
			Socket s=ss.accept();
			System.out.println("A client connect");
			DataInputStream dis=new DataInputStream(s.getInputStream());
			//readUTF()Ҳ������ʽ��
			System.out.println(dis.readUTF());
			dis.close();
		}
		 
	}
}
