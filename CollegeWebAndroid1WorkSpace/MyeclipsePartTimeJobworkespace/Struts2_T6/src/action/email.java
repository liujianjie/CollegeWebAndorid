package action;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class email {
	public static void main(String[] args) {
        SimpleEmail email = new SimpleEmail();
        //���÷��������ķ�������ַ 
        email.setHostName("smtp.qq.com");
        
        try {
            //�����ռ������� 
            email.addTo("1219277604@qq.com","�����");
            //���÷���������
            email.setFrom("1219277604@qq.com","�����");
            //���Ҫ�������֤�������û��������룬�ֱ�Ϊ���������ʼ���������ע����û��������� 
            email.setAuthentication("1219277604@qq.com", "svbaswhgbuqjgbib");
            //�����ʼ�������
            email.setSubject("2222");
            //�ʼ�������Ϣ
            email.setMsg("3333");
            
            /*********************************/
            email.setSSL(true);
            email.setSslSmtpPort("465"); // �趨SSL�˿�
            /*********************************/
            
            email.send();
            System.out.println("�ʼ����ͳɹ���");
             
        } catch (EmailException e) {          
            e.printStackTrace();
        }
    }
}
