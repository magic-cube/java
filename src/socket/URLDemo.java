package socket;
import java.net.*;
public class URLDemo {
	public static void main(String args[]) throws MalformedURLException{
		//����·������URL
		URL url=new URL("http://www.baidu.com:80/index.html?uname=hc");
		System.out.println("Э�飺"+url.getProtocol());
		System.out.println("������"+url.getHost());
		System.out.println("�˿ڣ�"+url.getPort());
		System.out.println("��Դ"+url.getFile());
		System.out.println("ê�㣺"+url.getRef());
		//����������ê��ʱ����null��������ê��ʱ������ȷ
		System.out.println("������"+url.getQuery());
		
		//���·������
		url=new URL("http://www.baidu.com:80");
		url=new URL(url,"3.tst");
		System.out.println(url.toString());
	}
}
