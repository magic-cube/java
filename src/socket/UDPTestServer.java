package socket;
import java.net.*;
public class UDPTestServer {

	public static void main(String[] args) throws Exception{
		byte [] buf=(new String("hello").getBytes());
		DatagramSocket server=new DatagramSocket(6666);
		//UDP�����ݰ��Դ�Ŀ��ip�Ͷ˿ںţ��Լ�Ѱַ
		DatagramPacket dp=new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",8888));
		server.send(dp);
		
		server.close();
	}

}
