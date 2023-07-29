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
 * Function: 生成验证码Controller. <br/>
 * date: 2013-12-10 上午11:37:42 <br/>
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
		Graphics g = image.getGraphics(); // 该画笔画在image上
		Color c = g.getColor(); // 保存当前画笔的颜色
		// 填充矩形
		g.fillRect(0, 0, width, height);
		char[] ch = "abcdefghjkmnpqrstuvwxyz2345678901".toCharArray(); // 随即产生的字符串
																		// 1（数字1）0(数字0)
		int length = ch.length; // 随即字符串的长度
		String sRand = ""; // 保存随即产生的字符串
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			// 设置字体
			g.setFont(getFont());
			// 随即生成0-9的数字
			String rand = new Character(ch[random.nextInt(length)]).toString();
			sRand += rand;
			// 设置随机颜色
			g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
			g.drawString(rand, 20 * i + 6, 25);
		}
		// 产生随即干扰点
		for (int i = 0; i < 20; i++) {
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			g.drawOval(x1, y1, 2, 2);
		}
		// 将画笔的颜色再设置回去
		g.setColor(c);
		// 释放此图形的上下文以及它使用的所有系统资源。
		g.dispose();

		// store the text in the session
		// 将验证码记录到session
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
		// 创建random对象用来生成随机数
		Random random = new Random();
		// 创建字体数组，用来装不同的字体的Font对象
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
