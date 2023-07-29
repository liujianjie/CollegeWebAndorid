package action;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class CopyOfemail2 {

		 public static void main(String[] args) {
		        SimpleEmail email = new SimpleEmail();
		        //设置发送主机的服务器地址 
		        email.setHostName("smtp.163.com");
		        
		        try {
		            //设置收件人邮箱
		            email.addTo("kangyu.cn@163.com","kangyu");
		             
		            //设置发件人邮箱
		            email.setFrom("kangyu.cn@163.com","kangyu");
		             
		            //如果要求身份验证，设置用户名、密码，分别为发件人在邮件服务器上注册的用户名和密码 
		            email.setAuthentication("kangyu", "******");
		            //设置邮件的主题
		            email.setSubject("Hello,This is my first email Application");
		            //邮件正文消息
		            email.setMsg("I am kangyu,This is JavaMail Application");
		            email.send();
		            System.out.println("邮件发送成功！");
		             
		        } catch (EmailException e) {          
		            e.printStackTrace();
		        }
		   
    }
}
