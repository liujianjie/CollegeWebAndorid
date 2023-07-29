<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- 工资主界面 -->

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

		<style>

.ipt{
	width: 80px;
	font: 15px Arial;
	outline: 0; /*输入框被点击时外边框不显示蓝色*/
}

#ipt1 {
	width: 50px;
	font: 15px Arial;
	outline: 0; /*输入框被点击时外边框不显示蓝色*/
}
#ipt2 {
	width: 50px;
	font: 15px Arial;
	outline: 0; /*输入框被点击时外边框不显示蓝色*/
}


.txt {
	color: #0099ff;
	border-bottom: 1px solid #7d7d7d; /* 下划线效果 */
	border-top: 0px;
	border-left: 0px;
	border-right: 0px;
	background-color: transparent; /* 背景色透明 */
}
</style>

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

				<div id="content" class="col-lg-10 col-sm-10" style="width: 100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="#">首页</a>
							</li>
							<li>
								<a href="#">财务管理</a>
							</li>
							<li>
								<a href="#">工资管理</a>
							</li>

						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-user"></i> 员工工资
									</h2>


								</div>
								<div class="box-content">
									<div>
										<input id="ipt1" type="text" value="${year }" name="" id="" class="txt" />
										<b>年</b>
										<input id="ipt2" type="text" value="${month }" name="" id="" class="txt" />
										<b>月</b>&nbsp;&nbsp;
										<b>工资表</b>
									</div>

									<table
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th rowspan="2">
													<span style="line-height: 50px;">部门</span>
												</th>

												<th rowspan="2">
													<span style="line-height: 50px;">员工</span>
												</th>


												<th rowspan="2">
													<span style="line-height: 50px;">职务</span>
												</th>
												<th rowspan="2">
													<span style="line-height: 50px;">底薪</span>
												</th>
												<th rowspan="2">
													<span style="line-height: 50px;">考核天数</span>
												</th>


												<th colspan="2">
													<span style="margin-left: 30px;">缺勤天数</span>
												</th>
												<th colspan="2" align="center">
													<span style="margin-left: 30px;">其他扣款</span>
												</th>


												<th rowspan="2">
													<span style="line-height: 50px;">其他工资</span>
												</th>

												<th rowspan="2">
													<span style="line-height: 50px;">总工资</span>
												</th>
												<th rowspan="2">
													<span style="line-height: 50px;">时间</span>
												</th>
												<th rowspan="2">
													<span style="line-height: 50px;">操作</span>
												</th>


											</tr>
											<tr>

												<th>
													病事假
												</th>
												<th>
													未出勤
												</th>

												<th>
													违纪罚款
												</th>
												<th>
													迟到/漏打卡
												</th>


											</tr>
										</thead>
										<tbody>
											<c:forEach begin="1" end="8">
												<tr>

													<td>
														技术部
													</td>


													<td>
														
													</td>


													<td>
														
													</td>

													<td>
														<input type="text" style="width: 50px;">
													</td>

													<td>
														<input type="text" style="width: 50px;">
													</td>
													
													<td>
														<input type="text" style="width: 50px;">
													</td>
														
													<td>
														<input type="text" style="width: 50px;">
													</td>
													
													<td>
														<input type="text" style="width: 50px;">
													</td>
													
													<td>
														<input type="text" style="width: 50px;">
													</td>
													
													<td>
														
													</td>

													<td>
														<input type="text" style="width: 50px;font-weight: bold;" readonly="readonly">
													</td>

													<td>
														
													</td>

													<td>
														<a class="btn btn-info" href="#"> <i
															class="glyphicon glyphicon-edit icon-white"></i> 结算 </a>
													</td>

												</tr>
											</c:forEach>
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


	<script type="text/javascript">
			function f1(inp){
				//alert("进来");
				inp.style.display="none";
				
				var ID=inp.id;
				//alert(ID);
				var id=ID.substring(ID.indexOf("s")+1,ID.length);
				//alert(id);
				//alert("i"+id);
				document.getElementById("i"+id).style.display="inline";
				document.getElementById("i"+id).select();
			}
			
			function tijiao(ipt){
				
			}
	</script>

	</body>
</html>
