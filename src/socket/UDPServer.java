package socket;
import java.net.*;
/**
 * UDP�����
 * DatagramSocket
 * DatagramPacket
 * �������ϸ������Ͻ���UDP�����ڷ��������ն�֮��
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
