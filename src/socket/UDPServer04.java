package socket;
import java.net.*;
import java.io.*;
public class UDPServer04 {
	public static void main(String args[]) throws Exception{
		//
		DatagramSocket server=new DatagramSocket(8887);
		//���յ�����
		byte [] buf=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf,buf.length);
		//����
		while(true){
			server.receive(dp);
			ByteArrayInputStream bis=new ByteArrayInputStream(buf);
			DataInputStream dis=new DataInputStream(bis);
			//��һ��double����
			System.out.println(dis.readDouble());
		}
		
	}
}
