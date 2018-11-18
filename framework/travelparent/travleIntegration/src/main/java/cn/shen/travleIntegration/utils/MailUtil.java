package cn.shen.travleIntegration.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.io.InputStream;
import java.util.Properties;

/**
 * 发送邮件工具类
 */
public final class MailUtil {
	private MailUtil(){}
	/**
	 * 发送邮件
	 * 参数一:发送邮件给谁
	 * 参数二:发送邮件的内容
	 */
	public static void sendMail(String toEmail, String emailMsg) throws Exception {
		//1_创建Java程序与163邮件服务器的连接对象
		Properties props = new Properties();
		InputStream inputStream = MailUtil.class.getClassLoader().getResourceAsStream("mail.properties");
		props.load(inputStream);
		//创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props.getProperty("username"), props.getProperty("password"));//发件方的用户名和密码
			}
		};
		//执行验证
		Session session = Session.getInstance(props, auth);
		//2_创建一封邮件
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(props.getProperty("from")));//设置邮件发送方
		message.setRecipient(RecipientType.TO, new InternetAddress(toEmail));//设置发件方式和邮件接收方
		message.setSubject("用户激活");//设置邮件标题
		message.setContent(emailMsg, "text/html;charset=UTF-8");//设置邮件内容
		//3_发送邮件
		Transport.send(message);
	}
	/**
	 * 测试类
	 */
	/*public static void main(String[] args) throws Exception{
		String toEmail = "shenxinr@outlook.com";
		String emailMsg = "用户校验";
		sendMail(toEmail,emailMsg);
		System.out.println("发送成功。。。");
	}*/
}









