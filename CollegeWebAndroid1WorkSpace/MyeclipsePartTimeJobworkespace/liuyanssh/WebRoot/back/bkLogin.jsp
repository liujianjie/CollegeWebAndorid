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
<script type="text/javascript" src="<%=basePath%>js/jquery-2.1.4.min.js"></script>

<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>css/font-awesome.min.css"
	rel="stylesheet">

<link href="<%=basePath%>css/animate.min.css" rel="stylesheet">
<link href="<%=basePath%>css/style.min.css" rel="stylesheet">
<script>if (window.top !== window.self) {
		window.top.location = window.location;
	}
</script>

</head>

<body>
	<div class="middle-box text-center loginscreen  animated fadeInDown">

		<form method="post" id="myform">

			<div>
				<div>

					<h1 class="logo-name"></h1>

				</div>
				<h3>欢迎</h3>

				<div class="form-group">
					<font color="red"><span id="show"></span></font>
				</div>
				<div class="form-group">
					<input type="text" name="staffUserName" id="staffUserName"
						class="form-control" placeholder="用户名" required="">
				</div>
				<div class="form-group">
					<input type="password" name="staffUserPwd" id="staffUserPwd"
						class="form-control" placeholder="密码" required="">
				</div>
				<button type="button" class="btn btn-primary block full-width m-b"
					id="login2" onclick="check()">登 录</button>
				<button type="button" class="btn btn-primary block full-width m-b"
					onclick="location.href='<%=basePath%>/back/bkRegister.jsp'">注册</button>

			</div>
		</form>
	</div>
	
	<script src="<%=basePath%>js/bootstrap.min.js"></script>

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
			var username = $("#staffUserName").val();
			var pwd = $("#staffUserPwd").val();
			if (username == "" && pwd == "") {
				$("#show").html("<i class='fa fa-times-circle'>用户名和密码不能为空!</i> ");
			} else if (username == "") {
				$("#show").html("<i class='fa fa-times-circle'>用户名不能为空!</i> ");
			} else if (pwd == "") {
				$("#show").html("<i class='fa fa-times-circle'>密码不能为空!</i> ");
			} else {
				$.ajax({
					url : "<%=basePath%>bkuser/bglogin.action",
					type : "post",
					data : $("#myform").serialize(),
					dataType : "text",
					 success  : function(data) {  
             			if(data == "true"){
             				 window.location.href="<%=basePath%>front/frameset.jsp"
             			}else{
             				  $("#show").html("用户名密码输入错误")
             			}
			        }
				});
			}
		}
	</script>

</body>
<script type="text/javascript" src="<%=basePath%>js/canvas-particle.js"></script>
</html>
