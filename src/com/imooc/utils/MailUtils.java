package com.imooc.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * 邮件发送的工具类
 */
public class MailUtils {

	/**
	 * 发送邮件的方法
	 * @param to： 给谁发邮件
	 * @param code：邮件的激活码
	 * @throws MessagingException 
	 * @throws Exception 
	 */
	public static void sendMail(String to,String code) throws Exception{
		//1.创建连接对象，连接到邮箱服务器
		Properties props = new Properties();
		//props.setProperty("localhost", value)  因为是在本地服务器，所以这个可以省略。
		Session session = Session.getInstance(props,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				//通过用户名和密码就可以登录到邮箱服务器里面了,用它给别人发送邮件
				return new PasswordAuthentication("service@store.com", "111"); 
			}
			
		} );
		//2.创建邮件对象
		Message message = new MimeMessage(session);
		    //2.1 设置发件人
		    message.setFrom(new InternetAddress("service@store.com"));
		    //2.2设置收件人
		    message.setRecipient(RecipientType.TO, new InternetAddress(to));
		    //2.3设置邮件的主题
		    message.setSubject("来自XX网的激活邮件");
		    //2.4设置邮件的正文
		    message.setContent("<h1>来自XX网的激活邮件,激活请点击以下链接:</h1><h3><a href='http://localhost:8080/regist_web/ActiveServlet?code="+code+"'>http://localhost:8080/regist_web/ActiveServlet?code="+code+"</a></h3>", "text/html;charset=UTF-8");
		//3.发送一封激活邮件
		    Transport.send(message);
		
	}
	
}
