<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>TTZ 后台登录</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="css/font-awesome.min.css?v=4.3.0" rel="stylesheet">

<link href="css/animate.min.css" rel="stylesheet">
<link href="css/style.min.css?v=3.2.0" rel="stylesheet">
<script>if (window.top !== window.self) {
		window.top.location = window.location;
	}
</script>
<%
	session.setAttribute("system", "后台系统");
%>
</head>

<body class="gray-bg">

	<div class="middle-box text-center loginscreen  animated fadeInDown">
		<div>
			<div>

				<h1 class="logo-name">TTZ</h1>

			</div>
			<h3>欢迎使用 TTZ</h3>

			<div class="form-group">
				<font color="red"><span id="show"></span></font>
			</div>
			<div class="form-group">
				<input type="text" name="username" id="username"
					class="form-control" placeholder="用户名" required="">
			</div>
			<div class="form-group">
				<input type="password" name="pwd" id="pwd" class="form-control"
					placeholder="密码" required="">
			</div>
			<button type="button" class="btn btn-primary block full-width m-b"
				onclick="check()">登 录</button>

			
		</div>
	</div>

	<!-- 全局js -->
	<script src="js/jquery-2.1.1.min.js"></script>
	<script src="js/bootstrap.min.js?v=3.4.0"></script>

	<!-- 登录jquery -->
	<script type="text/javascript">
	
	
		//按键登录   支持火狐
		document.onkeydown = function(event) {
			e = event ? event : (window.event ? window.event : null);
			var currKey = 0;
			currKey = e.keyCode || e.which || e.charCode;
			if (currKey == 13) {
				check();
			}
		};
	
		function check() {
			var username = $("#username").val();
			var pwd = $("#pwd").val();
			if (username == "" && pwd == "") {
				$("#show").html("<i class='fa fa-times-circle'>用户名和密码不能为空!</i> ");
			} else if (username == "") {
				$("#show").html("<i class='fa fa-times-circle'>用户名不能为空!</i> ");
			} else if (pwd == "") {
				$("#show").html("<i class='fa fa-times-circle'>密码不能为空!</i> ");
			} else {
	
				$.post("${pageContext.request.contextPath}/backlogin/login.action", {
					username : username,
					pwd : pwd
				}, function(result) {
					var statu = result.statu;
					if (statu == 1) {
						location.href = "${pageContext.request.contextPath}/backgroundSystem/index.jsp"
					}
					if (statu == 0) {
						$("#show").html("<i class='fa fa-times-circle'>用户名或密码错误</i> ");
					}
				}, "json");
			}
		}
	</script>


</body>

</html>