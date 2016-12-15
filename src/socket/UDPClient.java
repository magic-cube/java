package socket;
import java.net.*;
/**
 * UDP¿Í»§¶Ë
 * DatagramSocket
 * DatagramPacket
 * @author hc
 *
 */
public class UDPClient {

	public static void main(String[] args) throws Exception{
		byte [] buf=(new String("hello")).getBytes();
		DatagramSocket ds=new DatagramSocket(9999);
		DatagramPacket dp=new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",8888));
		ds.send(dp);
		ds.close();
	}

}
