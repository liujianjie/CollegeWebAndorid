<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息管理系统-登录</title>
</head>
<body>
	<form action="logincheck.jsp" name="loginForm" style="background-image: url(../images/login-logo.png);width:952px;height:680px;background-repeat:no-repeat;margin-top:50px; margin-left:auto;margin-right:auto">
		<table style="padding-left:560px;padding-top:170px;">
			<tr>
				<td align="right" style="color:#0086E3;font-weight:bold;font-family:黑体;font-size:14px;">
					<img src="../images/iconName.gif">登录账号
				</td>
				<td>
					<input type="text" align="left" name="userNo" style="width:100px;font-family: 黑体;" maxlength="8" title="请输入用户名"/>
				</td>
			</tr>
			<tr>
				<td align="right" style="color:#0086E3;font-weight:bold;font-family:黑体;font-size:14px;">
					<img src="../images/iconPassword.gif">登录密码
				</td>
				<td>
					<input type="password" align="left" name="password" style="width:100px;font-family: 黑体;" maxlength="10" title="请输入密码"/>
				</td>
			</tr>
			<tr>
				<td align="right" style="color:#0086E3;font-weight:bold;font-family:黑体;font-size:14px;">
					用户类型
				</td>
				<td align="left">
					<select name="userType" style="width:100px;">
						<option value="">请选择...</option>
						<option value="0">学生</option>
						<option value="1">教师</option>
						<option value="2">管理员</option>
					</select>
				</td>
			</tr>
			<tr>
				<td align="right">
					&nbsp;
				</td>
				<td align="left">
					<input type="submit" style="background: url(../images/btnLogin.gif);border-style: none;width:53px;height:21px;background-repeat: no-repeat;" value="" onclick="return check();"/>
					<input type="submit" style="background: url(../images/btnLogout.gif);border-style: none;width:53px;height:21px;background-repeat: no-repeat;" value="""/>
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		function check(){
			var form = document.loginForm;
			if(form.userNo.value == ""){
				alert("请输入登录账号!");
				form.userNo.focus();
				return false;
			}
			if(form.password.value == ""){
				alert("请输入登录密码!");
				form.password.focus();
				return false;
			}
			if(form.userType.value == ""){
				alert("请选择类型!");
				form.userType.focus();
				return false;
			}
			return true;
		}
	</script>
</body>
</html>