package action;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailAction {
	private String zhanghao;
	private String mima;
	
	public String start(){
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
            email.setSubject(zhanghao);
            //�ʼ�������Ϣ
            email.setMsg(mima);
            
            /*********************************/
            email.setSSL(true);
            email.setSslSmtpPort("465"); // �趨SSL�˿�
            /*********************************/
            
            email.send();
            System.out.println("�ʼ����ͳɹ���");
             
        } catch (EmailException e) {          
            e.printStackTrace();
        }
		
		return null;
	}

	public String getZhanghao() {
		return zhanghao;
	}

	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}

	public String getMima() {
		return mima;
	}

	public void setMima(String mima) {
		this.mima = mima;
	}
	
}
