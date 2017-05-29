package com.hc.thread.webserver;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.hc.thread.DefaultThreadPool;
import com.hc.thread.ThreadPool;

public class SimpleHttpServer {
	
	//都使用了static修饰,保证线程池对象只有一份,处于绝对的单例环境下
	static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<HttpRequestHandler>();
	
	static String basePath;
	
	static ServerSocket serverSocket;
	
	static int port;
	
	public static void setPort(int port){
		if(port>0){
			SimpleHttpServer.port=port;
		}
	}
	
	public static void setBasePath(String basePath){
		if(basePath!=null&&new File(basePath).exists()&&new File(basePath).isDirectory()){
			SimpleHttpServer.basePath=basePath;
		}
	}
	
	public static void start() throws IOException{
		serverSocket=new ServerSocket(port);
		Socket socket=null;
		while((socket=serverSocket.accept()) != null){
			threadPool.execute(new HttpRequestHandler(socket));
		}
		serverSocket.close();
	}
	
	static class HttpRequestHandler implements Runnable{
		private Socket socket;
		
		public HttpRequestHandler(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			String line=null;
			BufferedReader br=null;
			BufferedReader reader=null;
			PrintWriter out=null;
			InputStream in=null;
			try {
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String header=reader.readLine();
				String filePath=basePath+header.split(" ")[1];
				out=new PrintWriter(socket.getOutputStream());
				
				ByteArrayOutputStream baos=new ByteArrayOutputStream();
				//如果请求资源的后缀为jpg或者ico,则读取资源输出
				if(filePath.endsWith("jpg")||filePath.endsWith("ico")){
					in=new FileInputStream(filePath);
					
					int i=0;
					while((i=in.read())!=-1){
						baos.write(i);
					}
					byte[] array=baos.toByteArray();
					out.println("HTTP/1.1 200 OK");
					out.println("Server:Molly");
					out.println("Content-Type: image/jpeg");
					out.println("Content-Length: "+array.length);
					out.println("");
					socket.getOutputStream().write(array,0,array.length);
				}else{
					br=new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
					out=new PrintWriter(socket.getOutputStream());
					out.println("HTTP/1.1 200 OK");
					out.println("Server:Molly");
					out.println("Content-Type: text/html; charset=utf-8");
					out.println("");
					while((line=br.readLine()) != null){
						out.println(line);
					}
				}
				out.flush();
			} catch (IOException e) {
				out.println("HTTP/1.1 500");
				out.println("");
				out.flush();
			}finally{
				close(br,in,reader,out,socket);
			}
		}
		
		//jdk1.7 以后释放资源的做法  实现AutoCloseable接口
		public static void close(Closeable... closeables){
			if(closeables!=null){
				for (Closeable closeable : closeables) {
					try {
						closeable.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
	}
}





