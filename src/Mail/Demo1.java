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
 * �򵥵��ı��ʼ����ͳ���
 * 15619225472@163.com --> 120433911@qq.com
 * @author hc
 *
 */
public class Demo1 {
	
	public static void main(String[] args) throws Exception {
		
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");//���߳���,��Ҫ��֤
		props.setProperty("mail.transport.protocol", "smtp");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		
		Message msg = new MimeMessage(session);
		msg.setText("���!");
		msg.setFrom(new InternetAddress("15619225472@163.com"));
		
		Transport transport = session.getTransport();
		transport.connect("smtp.163.com",25,"15619225472","hc19950910");
		transport.sendMessage(msg,new Address[]{new InternetAddress("120433911@qq.com")});
		//transport.send(msg,new Address[]{new InternetAddress("15619225472@163.com")});
		//�����send��һ����̬����,������˰�������,���ʼ������ڵ�һϵ�ж���
		//ʹ��send����sendMessageȡ��������Ҫ���ͼ����ʼ�,��:sendMessage����һ��,���ü���,��send�ͻ����Ӻü���
		transport.close();
		
	}
	
}
