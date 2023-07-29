<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body style="overflow-x:hidden;overflow-y:hidden;">
<div>
  <table cellspacing="0" width="100%">
   <tr>
     
     <td><img src="images/logo.png"  margin-left: 30px  border="0"/></td>
     <td style="text-align:right">
      <%
      String name =(String)request.getAttribute("name");
      if(name!=null)   out.println(name + "您好！");
      %>
         
     <img src="images/cart.gif" width="26" height="23"/>&nbsp;

       <a href="${pageContext.request.contextPath}/FindAllBookCarServlet">购物车</a>
      |<a href="#">帮助中心</a>
      |<a href="myInformation.jsp">我的信息</a>
      |<a href="login.jsp">登录</a>
      |<a href="register.jsp">注册</a>
     </td>
   </tr>    
  </table>
</div>
</body>
</html>