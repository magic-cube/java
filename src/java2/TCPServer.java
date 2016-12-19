package java2;
import java.io.*;
import java.net.*;

public class TCPServer {
	public static void main(String args[]){
		try {
			
			ServerSocket server=new ServerSocket(9999);
			Socket s=null;
			while(true){
				s=server.accept();
				DataInputStream dis=new DataInputStream(s.getInputStream());
				System.out.println("a client connect:");
				System.out.println("InetAddress:"+s.getInetAddress());
				System.out.println("port:"+s.getPort());
				System.out.println(dis.readInt());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
