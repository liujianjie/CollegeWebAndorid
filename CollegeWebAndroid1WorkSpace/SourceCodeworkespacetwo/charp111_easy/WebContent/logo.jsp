<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--1.网站顶部 --> 
<div>
  <table cellspacing="0" width="100%">
   <tr>
     
     <td><img src="images/logo.png" width="200" height="60" border="0"/></td>
     <td style="text-align:right">
     <%
     String name=(String) request.getAttribute("name");
     if (name!=null) out.println(name+",您好");
     %>
     
     
     <img src="images/cart.gif" width="26" height="23"/>&nbsp;
       <a href="/charp111_easy/appli/submit.jsp">评论</a>
       <a href="/charp111_easy/cartshow.jsp">购物车</a>
      |<a href="helpcenter.jsp">帮助中心</a>
      |<a href="ShowMe.jsp">我的信息</a>
      |<a href="Login.jsp">登录</a>
<!--       |<a href="registration.jsp">注册</a> -->

      |<a href="register.jsp">注册</a>
     </td>
   </tr>    
  </table>
</div>
</body>
</html>