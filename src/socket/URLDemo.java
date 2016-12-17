package socket;
import java.net.*;
public class URLDemo {
	public static void main(String args[]) throws MalformedURLException{
		//绝对路径构建URL
		URL url=new URL("http://www.baidu.com:80/index.html?uname=hc");
		System.out.println("协议："+url.getProtocol());
		System.out.println("域名："+url.getHost());
		System.out.println("端口："+url.getPort());
		System.out.println("资源"+url.getFile());
		System.out.println("锚点："+url.getRef());
		//参数，存在锚点时返回null，不存在锚点时返回正确
		System.out.println("参数："+url.getQuery());
		
		//相对路径构建
		url=new URL("http://www.baidu.com:80");
		url=new URL(url,"3.tst");
		System.out.println(url.toString());
	}
}
