package socket;
import java.net.*;
/**
 * UDP服务端
 * DatagramSocket
 * DatagramPacket
 * 。。。严格意义上讲，UDP不存在服务端与接收端之分
 * @author hc
 *
 */
public class UDPServer {

	public static void main(String[] args) throws Exception {
		byte [] buf =new byte[1024];
		DatagramSocket ds=new DatagramSocket(8888);
		DatagramPacket dp=new DatagramPacket(buf,buf.length);
		while(true){
			ds.receive(dp);
			System.out.println(new String(buf,0,dp.getLength()));
		}
	}

}
