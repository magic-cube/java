package socket;
import java.net.*;
public class UDPTestClient {

	public static void main(String[] args) throws Exception{
		byte[] buf=new byte[1024];
		DatagramSocket client=new DatagramSocket(8888);
		DatagramPacket dp=new DatagramPacket(buf,buf.length);
		while(true){
			client.receive(dp);
			//dp.getLength(),��ȡ���͵����ݰ���ʵ�ʳ���
			System.out.println(new String(buf,0,dp.getLength()));
		}
	}

}
