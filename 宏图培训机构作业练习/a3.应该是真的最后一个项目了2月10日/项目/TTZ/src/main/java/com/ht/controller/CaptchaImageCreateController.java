package com.ht.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.google.code.kaptcha.Producer;

/**
 * ClassName: CaptchaImageCreateController <br/>
 * Function: ������֤��Controller. <br/>
 * date: 2013-12-10 ����11:37:42 <br/>
 * 
 * @author chenzhou1025@126.com
 */
@Controller
public class CaptchaImageCreateController {
	private Producer captchaProducer = null;

	@Autowired
	public void setCaptchaProducer(Producer captchaProducer) {
		this.captchaProducer = captchaProducer;
	}

	@RequestMapping("/Getcode")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Set to expire far in the past.
		response.setDateHeader("Expires", 0);
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");

		// return a jpeg
		response.setContentType("image/jpeg");

		int width = 83, height = 30;
		// create the text for the image

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics(); // �û��ʻ���image��
		Color c = g.getColor(); // ���浱ǰ���ʵ���ɫ
		// ������
		g.fillRect(0, 0, width, height);
		char[] ch = "abcdefghjkmnpqrstuvwxyz2345678901".toCharArray(); // �漴�������ַ���
																		// 1������1��0(����0)
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
		// �����漴���ŵ�
		for (int i = 0; i < 20; i++) {
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			g.drawOval(x1, y1, 2, 2);
		}
		// �����ʵ���ɫ�����û�ȥ
		g.setColor(c);
		// �ͷŴ�ͼ�ε��������Լ���ʹ�õ�����ϵͳ��Դ��
		g.dispose();

		// store the text in the session
		// ����֤���¼��session
		request.getSession().removeAttribute("safecode");
		request.getSession().setAttribute("safecode", sRand);

		ServletOutputStream out = response.getOutputStream();

		// write the data out
		ImageIO.write(image, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}

	private Font getFont() {
		// ����random�����������������
		Random random = new Random();
		// �����������飬����װ��ͬ�������Font����
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
	public Map<String, Object> GetSession(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String session = (String) request.getSession().getAttribute("safecode");
		map.put("session", session);
		return map;

	}
}
