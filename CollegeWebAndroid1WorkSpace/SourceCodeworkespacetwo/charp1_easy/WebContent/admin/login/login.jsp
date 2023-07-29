<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<link href="${pageContext.request.contextPath}
/admin/css/Style.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<table width="452" height="290" border="0" cellspacing="0"
		cellpadding="0" align="center">
		<tr>
			<td height="74"><img alt=""
				src="${pageContext.request.contextPath}
			/admin/images/logintitle.gif">
			</td>
		</tr>
		<tr>
			<td align="center" valign="middle"
				background="${pageContext.request.contextPath}
			/admin/images/loginbg.gif">
				<form action="/charp1_easy/admin/login/home.jsp" method="post">
					用户名：<input type="text" name="username" /><br />
					<br /> 密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password"
						name="password" /><br />
					<!--  验证码：<input type="text" name="formCode" /><br/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<img src="/charp1_easy/CheckServlet"><br/>-->
					<br /> <input type="submit" value="登录" /> <input type="reset"
						value="清除" />
				</form>
			</td>
		</tr>

	</table>
</body>
</html>