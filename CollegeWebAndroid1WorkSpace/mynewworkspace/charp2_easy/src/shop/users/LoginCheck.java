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
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //判断用户名密码是否正确，
        //判断验证码是否一致
        String userCode = request.getParameter("formCode");
        String serverCode = (String) request.getSession().getAttribute("code");

        if (userCode.equals(serverCode)) {
            //验证码正确，允许登录
            if ("admin".equals(username) && "admin".equals(password)) {
                //登录成功
                User u = new User();
                u.setUsername(username);
                u.setPassword(password);
                HttpSession session = request.getSession();
                session.setAttribute("key", u);
                //自己创建cookie，让session使用自己的cookie
                Cookie c = new Cookie("JESSIONID", session.getId());
                c.setMaxAge(3600 * 24 * 7);
                c.setPath("/charp1_easy");
                response.sendRedirect("/index.jsp");
            } else {  //登录失败
                response.getWriter().print("登录失败,用户名或密码错误！！！");
            }
        } else {
            //验证码错误
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            request.setAttribute("error", "用户名或密码错误");
            rd.forward(request, response);
        }
    }
}
