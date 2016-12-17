package socket;
import java.net.*;
/**
 * 封装端口：在InetAddress基础上+端口
 * @author hc
 *
 */
public class InetSocketDemo {

	public static void main(String[] args) throws Exception{
		
		InetSocketAddress address=new InetSocketAddress("127.0.0.1",8888);
		//源码内部会调用这个方法
		//InetAddress.getByName("127.0.0.1");
		//InetSocketAddress(InetAddress.getByName("127.0.0.1"),8888)
		
		System.out.println(address.getHostName());
		//System.out.println(address.getPort());
		InetAddress add=address.getAddress();
		System.out.println("\n"+add.getHostAddress());
		System.out.println(add.getHostName());
	}

}
