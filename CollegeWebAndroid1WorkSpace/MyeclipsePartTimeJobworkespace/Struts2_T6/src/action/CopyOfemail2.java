package action;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class CopyOfemail2 {

		 public static void main(String[] args) {
		        SimpleEmail email = new SimpleEmail();
		        //���÷��������ķ�������ַ 
		        email.setHostName("smtp.163.com");
		        
		        try {
		            //�����ռ�������
		            email.addTo("kangyu.cn@163.com","kangyu");
		             
		            //���÷���������
		            email.setFrom("kangyu.cn@163.com","kangyu");
		             
		            //���Ҫ�������֤�������û��������룬�ֱ�Ϊ���������ʼ���������ע����û��������� 
		            email.setAuthentication("kangyu", "******");
		            //�����ʼ�������
		            email.setSubject("Hello,This is my first email Application");
		            //�ʼ�������Ϣ
		            email.setMsg("I am kangyu,This is JavaMail Application");
		            email.send();
		            System.out.println("�ʼ����ͳɹ���");
		             
		        } catch (EmailException e) {          
		            e.printStackTrace();
		        }
		   
    }
}
