package shop.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import goods.entity.User;


/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //��ȡ�û���������
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //�ж��û��������Ƿ���ȷ��
        //�ж���֤���Ƿ�һ��
        String userCode = request.getParameter("formCode");
        String serverCode = (String) request.getSession().getAttribute("code");

        if (userCode.equals(serverCode)) {
            //��֤����ȷ�������¼
            if ("admin".equals(username) && "admin".equals(password)) {
                //��¼�ɹ�
                User u = new User();
                u.setUsername(username);
                u.setPassword(password);
                HttpSession session = request.getSession();
                session.setAttribute("key", u);
                //�Լ�����cookie����sessionʹ���Լ���cookie
                Cookie c = new Cookie("JESSIONID", session.getId());
                c.setMaxAge(3600 * 24 * 7);
                c.setPath("/charp1_easy");
                response.sendRedirect("/index.jsp");
            } else {  //��¼ʧ��
                response.getWriter().print("��¼ʧ��,�û�����������󣡣���");
            }
        } else {
            //��֤�����
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            request.setAttribute("error", "�û������������");
            rd.forward(request, response);
        }
    }
}
