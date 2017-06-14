package Mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 简单的文本邮件发送程序
 * 15619225472@163.com --> 120433911@qq.com
 * @author hc
 *
 */
public class Demo1 {
	
	public static void main(String[] args) throws Exception {
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");//告诉程序,需要认证
		props.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		
		Message msg = new MimeMessage(session);
		msg.setText("你好!");
		msg.setFrom(new InternetAddress("15619225472@163.com"));
		
		Transport transport = session.getTransport();
		transport.connect("smtp.163.com",25,"15619225472","hc19950910");
		transport.sendMessage(msg,new Address[]{new InternetAddress("120433911@qq.com")});
		//transport.send(msg,new Address[]{new InternetAddress("15619225472@163.com")});
		//上面的send是一个静态方法,他完成了包括连接,发邮件等在内的一系列动作
		//使用send还是sendMessage取决于你需要发送几个邮件,如:sendMessage连接一次,发好几次,而send就会连接好几次
		transport.close();
		
	}
	
}
