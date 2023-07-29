package action;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class email {
	public static void main(String[] args) {
        SimpleEmail email = new SimpleEmail();
        //设置发送主机的服务器地址 
        email.setHostName("smtp.qq.com");
        
        try {
            //设置收件人邮箱 
            email.addTo("1219277604@qq.com","孙悟空");
            //设置发件人邮箱
            email.setFrom("1219277604@qq.com","孙悟空");
            //如果要求身份验证，设置用户名、密码，分别为发件人在邮件服务器上注册的用户名和密码 
            email.setAuthentication("1219277604@qq.com", "svbaswhgbuqjgbib");
            //设置邮件的主题
            email.setSubject("2222");
            //邮件正文消息
            email.setMsg("3333");
            
            /*********************************/
            email.setSSL(true);
            email.setSslSmtpPort("465"); // 设定SSL端口
            /*********************************/
            
            email.send();
            System.out.println("邮件发送成功！");
             
        } catch (EmailException e) {          
            e.printStackTrace();
        }
    }
}
