<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Free HTML5 Bootstrap Admin Template</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description"
			content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
		<meta name="author" content="Muhammad Usman">

		<!-- The styles -->
		<link id="bs-css" href="css/bootstrap-cerulean.min.css"
			rel="stylesheet">

		<link href="css/charisma-app.css" rel="stylesheet">
		<link href='bower_components/fullcalendar/dist/fullcalendar.css'
			rel='stylesheet'>
		<link href='bower_components/fullcalendar/dist/fullcalendar.print.css'
			rel='stylesheet' media='print'>
		<link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
		<link href='bower_components/colorbox/example3/colorbox.css'
			rel='stylesheet'>
		<link href='bower_components/responsive-tables/responsive-tables.css'
			rel='stylesheet'>
		<link
			href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css'
			rel='stylesheet'>
		<link href='css/jquery.noty.css' rel='stylesheet'>
		<link href='css/noty_theme_default.css' rel='stylesheet'>
		<link href='css/elfinder.min.css' rel='stylesheet'>
		<link href='css/elfinder.theme.css' rel='stylesheet'>
		<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
		<link href='css/uploadify.css' rel='stylesheet'>
		<link href='css/animate.min.css' rel='stylesheet'>
		<!-- jQuery -->
		<script src="bower_components/jquery/jquery.min.js"></script>

		<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

		<!-- The fav icon -->
		<link rel="shortcut icon" href="img/favicon.ico">
		

	</head>
	<!--#63a8c9-->
	<body style="background-color: #c1e3f2">
		<!--<body style="background-image: url('img/bg1.jpg');">-->
		<div class="ch-container">
			<div class="row">
				<!--<img alt="Charisma Logo" src="img/5.png" class="hidden-xs"/>-->
				<div class="row">
					<div class="col-md-12 center login-header">

						<h1 class="animated rubberBand">
														<img src="img/6.png"/><span style="font-family: 华文行楷;">宏图软件办公系统</span>
<!--							<span style="font-family: 华文行楷;">宏图软件办公系统</span>-->
						</h1>
						<br />
					</div>
					<!--/span-->
				</div>
				<!--/row-->

				<div class="row">
					<div class="well col-md-5 center login-box"
						style="padding-right: 19px; padding-top: 19px; padding-bottom: 30px;">
						<div class="alert alert-info">
							Please login with your Username and Password.
						</div>
						
						
						<form class="form-horizontal" action="chenru/login.action" method="post">
							<fieldset>
								<div class="input-group input-group-lg">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user gray"></i></span>
									<input type="text" class="form-control" placeholder="用户名" name="username" id="uname">
								</div>
								<div class="clearfix"></div>
								<br>

								<div class="input-group input-group-lg">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock gray"></i> </span>
									<input type="password" class="form-control" placeholder="密码" name="password" id="pwd">
								</div>
								<div class="clearfix"></div>
								<!-- 选择登录者类型 -->

								<div class="box-content">
									<div class="control-group"  style="magin-left:350px;">
										<label class="remember" for="ctime" style="font-family: 华文行楷; font-size: 20px;">
											登录者 ：
										</label>
										<div class="control-group"
											style="height: 40px;display: inline-block; margin-bottom: 0; vertical-align: middle;margin-top: 5px;">
											<label class="remember" style="font-family: 华文行楷; font-size: 20px;">
												<input type="radio" name="loginkind" value="0" checked>
												教工
											</label>
											<label class="remember" style="font-family: 华文行楷; font-size: 20px;">
												<input type="radio" name="loginkind" value="1">
												学生
											</label>
											</div>
<!--												<div style="width:10px;"></div>-->
<!--											<div class="input-prepend" style="float: right;">-->
											</div>
											</div>
											<div class="clearfix"></div>

											<p class="center col-md-5">
												<button type="submit" class="btn btn-primary"
													style="font-family: 华文行楷; font-size: 24px;">
													登&nbsp;&nbsp;录
												</button>
											</p>
							</fieldset>
						</form>
					</div>
					<!--/span-->
				</div>
				<!--/row-->
			</div>
			<!--/fluid-row-->

		</div>
		<!--/.fluid-container-->

		<!-- external javascript -->

		<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

		<!-- library for cookie management -->
		<script src="js/jquery.cookie.js"></script>
		<!-- calender plugin -->
		<script src='bower_components/moment/min/moment.min.js'></script>
		<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
		<!-- data table plugin -->
		<script src='js/jquery.dataTables.min.js'></script>

		<!-- select or dropdown enhancer -->
		<script src="bower_components/chosen/chosen.jquery.min.js"></script>
		<!-- plugin for gallery image view -->
		<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
		<!-- notification plugin -->
		<script src="js/jquery.noty.js"></script>
		<!-- library for making tables responsive -->
		<script src="bower_components/responsive-tables/responsive-tables.js"></script>
		<!-- tour plugin -->
		<script
			src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
		<!-- star rating plugin -->
		<script src="js/jquery.raty.min.js"></script>
		<!-- for iOS style toggle switch -->
		<script src="js/jquery.iphone.toggle.js"></script>
		<!-- autogrowing textarea plugin -->
		<script src="js/jquery.autogrow-textarea.js"></script>
		<!-- multiple file upload plugin -->
		<script src="js/jquery.uploadify-3.1.min.js"></script>
		<!-- history.js for cross-browser state change on ajax -->
		<script src="js/jquery.history.js"></script>
		<!-- application script for Charisma demo -->
		<script src="js/charisma.js"></script>


	</body>
</html>
