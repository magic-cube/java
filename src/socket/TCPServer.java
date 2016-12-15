package socket;

import java.net.*;
import java.io.*;

/**
 * Server端
 * 因为不确定会有多少Client端连进来，所以一般Server都是死循环
 * 每有一个人连进来就accept()
 * accept()是阻塞式的
 * @author hc
 *
 */
public class TCPServer {
	public static void main(String args[]) throws Exception{
		//建立监听
		ServerSocket ss=new ServerSocket(6666);
		//等待接受
		while(true){
			Socket s=ss.accept();
			System.out.println("A client connect");
			DataInputStream dis=new DataInputStream(s.getInputStream());
			//readUTF()也是阻塞式的
			System.out.println(dis.readUTF());
			dis.close();
		}
		 
	}
}
