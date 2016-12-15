package socket;
import java.io.*;
import java.net.*;
/**
 * Client端
 * 启动时先启动Server端，再启动Client端
 * 编写时同时编写
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
