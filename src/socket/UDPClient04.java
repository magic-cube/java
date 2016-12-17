package socket;
import java.net.*;
import java.io.*;
public class UDPClient04 {
	public static void main(String args[]) throws Exception{
		double num=89.12;
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(bos);
		dos.writeDouble(num);
		byte [] buf=bos.toByteArray();
		
		DatagramSocket client=new DatagramSocket(9999);
		DatagramPacket dp=new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",8887));
		
		client.send(dp);
		
		//¹Ø±Õ×ÊÔ´
		dos.close();
		client.close();
	}
}
