package socket;
import java.io.*;
import java.net.*;
/**
 * Client��
 * ����ʱ������Server�ˣ�������Client��
 * ��дʱͬʱ��д
 * @author hc
 *
 */
public class TCPClient {
	public static void main(String args[]) throws Exception{
		Socket s=new Socket("127.0.0.1",6666);
		OutputStream os=s.getOutputStream();
		DataOutputStream dos=new DataOutputStream(os);
		dos.writeUTF("\nhello server");
		dos.flush();
		dos.close();
		s.close();
	}
}
