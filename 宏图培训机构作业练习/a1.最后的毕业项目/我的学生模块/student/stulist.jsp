<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<!--
        ===
        This comment should NOT be removed.

        Charisma v2.0.0

        Copyright 2012-2014 Muhammad Usman
        Licensed under the Apache License v2.0
        http://www.apache.org/licenses/LICENSE-2.0

        http://usman.it
        http://twitter.com/halalit_usman
        ===
    -->
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

	<body>
	
	<div class="ch-container">
    <div class="row"> 

				<noscript>
					<div class="alert alert-block col-md-12">
						<h4 class="alert-heading">
							Warning!
						</h4>

						<p>
							You need to have
							<a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
							enabled to use this site.
						</p>
					</div>
				</noscript>

				<div id="content" class="col-lg-10 col-sm-10" style="width:100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="#">学生管理</a>
							</li>
							<li>
								<a href="stu/list">学生信息管理</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-user"></i> Datatable +
										Responsive
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-setting btn-round btn-default"><i
											class="glyphicon glyphicon-cog"></i>
										</a>
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i>
										</a>
										<a href="#" class="btn btn-close btn-round btn-default"><i
											class="glyphicon glyphicon-remove"></i>
										</a>
									</div>
								</div>
								<div class="box-content">
									<div class="alert alert-info">
										For help with such table please check
										<a href="http://datatables.net/" target="_blank">http://datatables.net/</a>
									</div>
									<table id="table"
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
										<!-- 这里显示除去查找能查到的信息或者简单的信息 外的信息 -->
										<!-- 比如 班级、爱好、家庭住址、就读疑问、头像、状态、入学信息 -->
											<tr>
												<th>
													姓名
												</th>
												<th>
													性别
												</th>
												<th>
													年龄
												</th>
												<th>
													生日
												</th>
												<th>
													家长姓名
												</th>
												<th>
													联系电话
												</th>
												<th>
													家长联系电话
												</th>
												<th>
													操作
												</th>
											</tr>
										</thead>
										<tbody>
										<s:iterator value="list" var="stu">
											<tr>
												<td>
													<s:property value="#stu.intenname"/>
												</td>
												<td class="center">
													<s:property value="#stu.intensex"/>
												</td>
												<td class="center">
													<s:property value="#stu.intenage"/>
												</td>
												<td class="center" width="10%">
													<s:property value="#stu.intenbir"/>
												</td>
												<td class="center">
													<s:property value="#stu.intenfat"/>
												</td>
												<td class="center">
													<s:property value="#stu.intentel"/>
												</td>
												<td class="center">
													<s:property value="#stu.intenfatel"/>
												</td>
												<td class="center">
													<a class="btn btn-success" href="stu/seldan?intenid=10001"> <i
														class="glyphicon glyphicon-zoom-in icon-white"></i> View </a>
													<a class="btn btn-info" href="#"> <i
														class="glyphicon glyphicon-edit icon-white"></i> 编辑 </a>
													<a class="btn btn-danger" href="#"> <i
														class="glyphicon glyphicon-trash icon-white"></i> Delete </a>
												</td>
											</tr>
											
										</s:iterator>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<!--/span-->

					</div>
				
					</div>
					<!--/row-->

					<!-- content ends -->
				</div>
				<!--/#content.col-md-0-->
			</div>
			<!--/fluid-row-->
		
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
