package Mail;

import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;


public class Demo2 {
	
	public static void main(String[] args) throws Exception {
		/*
		 * ����session
		 */
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");//
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", "smtp.163.com");//
		Session session = Session.getInstance(props,
				new Authenticator()
				{
					/*
					 * ����ģʽ 
					 */
					//�� Authenticator ʹ�õ����ݳ����ߡ���ֻ���û���������Ĵ洢�⡣
					protected PasswordAuthentication getPasswordAuthentication(){ 
						return new PasswordAuthentication("15619225472","hc19950910"); 
					} 
				}
		);
		session.setDebug(true);
		/*
		 * ����Message
		 */
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("15619225472@163.com"));
		msg.setSubject("����");
		msg.setRecipients(RecipientType.TO, 
				InternetAddress.parse("120433911@qq.com,15619225472@163.com"));
		//msg.setContent("<span style='color:red'>���� ��� !<span>", "text/html;charest=gbk");
		msg.setText("���� ���!");
		
		Transport.send(msg);
	}
	
}
