package socket;
import java.net.*;
import java.io.*;
/**
 * ��ȡ��Դ��Դ����
 * ��ȡ�ٶ���ҳԴ����
 * @author hc
 *
 */
public class URLDemo02 {

	public static void main(String[] args) throws Exception{
		//
		URL url=new URL("http://www.baidu.com");	//��ҳ��Ĭ����Դ
		
		//��ȡ��Դ
		String msg;
		//ʹ��ת���������ƶ������ʽΪUTF-8
		BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));   
		while(null!=(msg=br.readLine())){
			System.out.println(msg);
		}
		
		//Ҳ������ôд,����������룬�������ϵķ�ʽ
//		byte [] buf=new byte[1024];
//		InputStream is=url.openStream();
//		int len=0;
//		while(-1!=(len=is.read())){
//			System.out.println(new String(buf,0,len));
//		}
		br.close();
	}

}
