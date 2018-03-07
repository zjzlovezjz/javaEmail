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
 * �ʼ����͵Ĺ�����
 */
public class MailUtils {

	/**
	 * �����ʼ��ķ���
	 * @param to�� ��˭���ʼ�
	 * @param code���ʼ��ļ�����
	 * @throws MessagingException 
	 * @throws Exception 
	 */
	public static void sendMail(String to,String code) throws Exception{
		//1.�������Ӷ������ӵ����������
		Properties props = new Properties();
		//props.setProperty("localhost", value)  ��Ϊ���ڱ��ط������������������ʡ�ԡ�
		Session session = Session.getInstance(props,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				//ͨ���û���������Ϳ��Ե�¼�����������������,���������˷����ʼ�
				return new PasswordAuthentication("service@store.com", "111"); 
			}
			
		} );
		//2.�����ʼ�����
		Message message = new MimeMessage(session);
		    //2.1 ���÷�����
		    message.setFrom(new InternetAddress("service@store.com"));
		    //2.2�����ռ���
		    message.setRecipient(RecipientType.TO, new InternetAddress(to));
		    //2.3�����ʼ�������
		    message.setSubject("����XX���ļ����ʼ�");
		    //2.4�����ʼ�������
		    message.setContent("<h1>����XX���ļ����ʼ�,����������������:</h1><h3><a href='http://localhost:8080/regist_web/ActiveServlet?code="+code+"'>http://localhost:8080/regist_web/ActiveServlet?code="+code+"</a></h3>", "text/html;charset=UTF-8");
		//3.����һ�⼤���ʼ�
		    Transport.send(message);
		
	}
	
}
