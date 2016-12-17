package socket;
import java.net.*;
import java.io.*;
/**
 * 获取资源：源代码
 * 获取百度首页源代码
 * @author hc
 *
 */
public class URLDemo02 {

	public static void main(String[] args) throws Exception{
		//
		URL url=new URL("http://www.baidu.com");	//主页，默认资源
		
		//获取资源
		String msg;
		//使用转换流，并制定编码格式为UTF-8
		BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));   
		while(null!=(msg=br.readLine())){
			System.out.println(msg);
		}
		
		//也可以这么写,如果出现乱码，采用以上的方式
//		byte [] buf=new byte[1024];
//		InputStream is=url.openStream();
//		int len=0;
//		while(-1!=(len=is.read())){
//			System.out.println(new String(buf,0,len));
//		}
		br.close();
	}

}
