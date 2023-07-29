<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
<link type="text/css" href="css/main.css" rel="stylesheet"/>
 <link type="text/css" href="css/autoplay.css" rel="stylesheet"/> 
<script type="text/javascript" src="js/autoplay.js"></script>

</head>
<body>
<!--1.LOGO --> 
<%@include  file="head.jsp"  %>
<!-- 2.网站菜单列表 -->
<%@include  file="nav.jsp"  %>
<br><br><br>
<div style="width:100%;text-align:center">
	<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
		用户名：<input type="text" name="username" />${registerMessage}<br>
		密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" /><br>
		<!--验证码：<input type="text" name="formCode" /><br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<img src="/charp1_easy/CheckServlet"><br/>-->
			<input type="submit" value="登录" />
			<input type="reset" value="重填" />
	</form>
</div>
<br><br><br>
	<!-- 底部版权栏 -->
	<%@include  file="foot.jsp"  %>
</body>
</html>