package com.ht.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("PictureCheckCode")
public class PictureCheckCode {
	@RequestMapping("getPictureCheckCode")
	public void getPictureCheckCode(HttpServletRequest request,HttpServletResponse response){
		 	response.setHeader("Pragma", "No-cache");  
	        response.setHeader("Cache-Control", "No-cache");  
	        response.setDateHeader("Expires", 0);  
	        //ָ�����ɵ���ӦͼƬ,һ������ȱ����仰,�������.  
	        response.setContentType("image/jpeg");  
	        response.setContentType("image/jpeg");  
	        try {
				OutputStream os = response.getOutputStream();
			 
	        int width = 83, height = 30;  
	        // ����ָ�����ߺ�BufferedImage����  
	        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);  
	  
	        Graphics g = image.getGraphics(); // �û��ʻ���image��  
	        Color c = g.getColor(); // ���浱ǰ���ʵ���ɫ
	        //������
	        g.fillRect(0, 0, width, height);  
	          
	  
	            char[] ch = "abcdefghjkmnpqrstuvwxyz2345678901".toCharArray(); // �漴�������ַ��� ������ i l(СдL) o��СдO�� 1������1��0(����0)  
	            int length = ch.length; // �漴�ַ����ĳ���  
	            String sRand = ""; // �����漴�������ַ���  
	            Random random = new Random();  
	            for (int i = 0; i < 4; i++) {  
	            // ��������  
	            g.setFont(getFont());  
	            // �漴����0-9������  
	            String rand = new Character(ch[random.nextInt(length)]).toString();  
	            sRand += rand;  
	            // ���������ɫ  
	            g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));  
	            g.drawString(rand, 20 * i + 6, 25);  
	        }  
	        //�����漴���ŵ�  
	        for (int i = 0; i < 20; i++) {  
	            int x1 = random.nextInt(width);  
	            int y1 = random.nextInt(height);  
	            g.drawOval(x1, y1, 2, 2);  
	        }  
	         // �����ʵ���ɫ�����û�ȥ  
	        g.setColor(c); 
	        // �ͷŴ�ͼ�ε��������Լ���ʹ�õ�����ϵͳ��Դ��
	        g.dispose();  
	  
	        //����֤���¼��session  
	        request.getSession().removeAttribute("safecode");
	        request.getSession().setAttribute("safecode", sRand);  
	        ImageIO.write(image, "JPEG", os); 
	        	os.flush();
	        	os.close();
	        	
	        	
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	
	  private Font getFont() {  
	        //����random�����������������
	        Random random = new Random();
	        //�����������飬����װ��ͬ�������Font����
	        Font font[] = new Font[5];  
	        font[0] = new Font("Ravie", Font.PLAIN, 24);  
	        font[1] = new Font("Antique Olive Compact", Font.PLAIN, 24);  
	        font[2] = new Font("Forte", Font.PLAIN, 24);  
	        font[3] = new Font("Wide Latin", Font.PLAIN, 24);  
	        font[4] = new Font("Gill Sans Ultra Bold", Font.PLAIN, 24);  
	        return font[random.nextInt(5)];  
	    }  
	  
	  @RequestMapping("getsession")
	  @ResponseBody
	  public Map<String, Object> GetSession(HttpServletRequest request){
		  Map<String, Object> map = new HashMap<String, Object>();
		  String session = (String) request.getSession().getAttribute("safecode");
		  map.put("session", session);
		return map;
		  
	  }
}
