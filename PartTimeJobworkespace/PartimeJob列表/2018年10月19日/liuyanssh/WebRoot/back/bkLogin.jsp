<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="textml; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>后台管理</title>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=basePath%>js/jquery1.8.3.min.js"></script>
</head>

<body>
	<div class="login_box">
		<!--  <div class="login_l_img"><img src="images/login-img.png" /></div>
      <div class="login">
          <div class="login_logo"><a href="#"><img src="images/login_logo.png" /></a></div>
          <div class="login_name">
               <p>后台管理系统</p>
          </div> -->
		<form method="post" id="myform">
			<input name="staffUserName" type="text" value="用户名"
				onfocus="this.value=''"
				onblur="if(this.value==''){this.value='用户名'}"> <span
				id="password_text">密码</span> <input name="staffUserPwd"
				type="password" id="password" /> <input type="button" value="登录"
				id="login2"><input type="button" onclick="location.href='<%=basePath%>/back/bkRegister.jsp'"value="注册"
				id="login2">
		</form>
	</div>
</body>
<script type="text/javascript" src="<%=basePath%>js/canvas-particle.js"></script>
<script>
	$("#login2").click(function() {
		$.ajax({
			url : "bkuser/bglogin.action",
			type : "post",
			data : $("#myform").serialize(),
			dataType : "text",
			success : function(data) {
				if (data == "true") {
					alert("welcom to back");
					window.location.href = "<%=basePath%>front/frameset.jsp"
				} else {
					$("#myform").before("<span>用户名密码输入错误</span>")
				}
			}
		})

	})
</script>

</html>
<