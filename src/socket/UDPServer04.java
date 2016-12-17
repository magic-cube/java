package socket;
import java.net.*;
import java.io.*;
public class UDPServer04 {
	public static void main(String args[]) throws Exception{
		//
		DatagramSocket server=new DatagramSocket(8887);
		//接收的容器
		byte [] buf=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf,buf.length);
		//接收
		while(true){
			server.receive(dp);
			ByteArrayInputStream bis=new ByteArrayInputStream(buf);
			DataInputStream dis=new DataInputStream(bis);
			//读一个double过来
			System.out.println(dis.readDouble());
		}
		
	}
}
