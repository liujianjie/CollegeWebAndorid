package com.ht.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * spring������
 * 
 * @author tianyong
 * 
 */
public class SecurityInterceptor implements HandlerInterceptor {

	public String[] allowUrls;// ��û���ֿ���ֱ�����ò����ص���Դ�������ڴ����������ų�

	public void setAllowUrls(String[] allowUrls) {
		this.allowUrls = allowUrls;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String requestUrl = request.getRequestURI().replace(request.getContextPath(), "");
		response.setContentType("text/html; charset=utf-8");
		HttpSession session = request.getSession(true);
		boolean GL = false;// �ж���û������
		boolean returnStatu = true;// �жϼ̲�����ִ������
		System.out.println("��ʾ: URL������......" + requestUrl);
		if (null != allowUrls && allowUrls.length >= 1)
			for (String url : allowUrls) {
				if (requestUrl.contains(url)) {
					System.out.println("��ʾ: ��URL������...");
					GL = true;
					return true;
				}
			}
		if (GL == false) {// û�б�����
			// �жϵ�½����ǰ̨���Ǻ�̨
			String system = (String) session.getAttribute("system");
			String consystem = SystemContant.System;
			if (system != null) {// sessionδʧЧ ����
				if (system.equals("ǰ̨ϵͳ")) {
					Object obj = session.getAttribute("user");
					String path = session.getServletContext().getContextPath();
					if (obj == null || "".equals(obj.toString()) || SystemContant.tuser == null) {
						System.out.println("��ʾ: ǰ̨ϵͳsession: ��ʧЧ >");
						// throw new SessionTimeoutException();// ���ص������ļ��ж����·��
						// response.sendRedirect(SystemConstants.LOGIN_URL);
						PrintWriter out = response.getWriter();
						StringBuilder builder = new StringBuilder();
						builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
						builder.append("alert(\"ҳ����ڣ������µ�¼\");");
						builder.append("window.top.location.href=\"" + path + "/foregroundSystem/login.jsp\"");
						builder.append("</script>");
						out.print(builder.toString());
						try {
							out.flush();
						} finally {
							out.close();
						}
						returnStatu = false;
					} else {
						System.out.println("��ʾ: ǰ̨ϵͳsession: �ѵ�¼ δʧЧ >");
						returnStatu = true;
					}
				} else if (system.equals("��̨ϵͳ")) {
					// ��ȡ��ǰ��½�û���Ϣ
					Object obj = session.getAttribute("backuser");
					String path = session.getServletContext().getContextPath();
					if (obj == null || "".equals(obj.toString()) || SystemContant.buser == null) {
						System.out.println("��ʾ: ��̨ϵͳsession: ��ʧЧ >");
						// throw new SessionTimeoutException();// ���ص������ļ��ж����·��
						// response.sendRedirect(SystemConstants.LOGIN_URL);
						PrintWriter out = response.getWriter();
						StringBuilder builder = new StringBuilder();
						builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
						builder.append("alert(\"ҳ����ڣ������µ�¼\");");
						// �жϵ�ǰ��½�����ĸ�ϵͳ �Ӷ��������ĸ���½����
						builder.append("window.top.location.href=\"" + path + "/backgroundSystem/login.jsp\"");
						builder.append("</script>");
						out.print(builder.toString());
						try {
							out.flush();
						} finally {
							out.close();
						}
						returnStatu = false;
					} else {
						System.out.println("��ʾ: ��̨ϵͳsession: �ѵ�¼ δʧЧ >");
						returnStatu = true;
					}
				}
			} else if (system == null && consystem != null) {// sessionʧЧ,���ǳ�����û������
				if (consystem.equals(SystemContant.ForegroundSystem)) {
					Object obj = session.getAttribute("user");
					String path = session.getServletContext().getContextPath();
					if (obj == null || "".equals(obj.toString()) || SystemContant.tuser == null) {
						System.out.println("��ʾ: ǰ̨ϵͳsession: ��ʧЧ >");
						// throw new SessionTimeoutException();// ���ص������ļ��ж����·��
						// response.sendRedirect(SystemConstants.LOGIN_URL);
						PrintWriter out = response.getWriter();
						StringBuilder builder = new StringBuilder();
						builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
						builder.append("alert(\"ҳ����ڣ������µ�¼\");");
						builder.append("window.top.location.href=\"" + path + "/foregroundSystem/login.jsp\"");
						builder.append("</script>");
						out.print(builder.toString());
						try {
							out.flush();
						} finally {
							out.close();
						}
						returnStatu = false;
					} else {
						System.out.println("��ʾ: ǰ̨ϵͳsession: �ѵ�¼ δʧЧ >");
						returnStatu = true;
					}
				} else if (consystem.equals(SystemContant.BackgroundSystem)) {
					// ��ȡ��ǰ��½�û���Ϣ
					Object obj = session.getAttribute("backuser");
					String path = session.getServletContext().getContextPath();
					if (obj == null || "".equals(obj.toString()) || SystemContant.buser == null) {
						System.out.println("��ʾ: ��̨ϵͳsession: ��ʧЧ >");
						// throw new SessionTimeoutException();// ���ص������ļ��ж����·��
						// response.sendRedirect(SystemConstants.LOGIN_URL);
						PrintWriter out = response.getWriter();
						StringBuilder builder = new StringBuilder();
						builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");
						builder.append("alert(\"ҳ����ڣ������µ�¼\");");
						// �жϵ�ǰ��½�����ĸ�ϵͳ �Ӷ��������ĸ���½����
						builder.append("window.top.location.href=\"" + path + "/backgroundSystem/login.jsp\"");
						builder.append("</script>");
						out.print(builder.toString());
						try {
							out.flush();
						} finally {
							out.close();
						}
						returnStatu = false;
					} else {
						System.out.println("��ʾ: ��̨ϵͳsession: �ѵ�¼ δʧЧ >");
						returnStatu = true;
					}
				}
			}
		}
		return returnStatu; // ����true�������������ú����ŵ���postHandle(),
							// false ���������ִ������ķ���
	}
}