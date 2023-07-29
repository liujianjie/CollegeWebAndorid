<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>宏图软件办公系统</title>
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
		<link rel="shortcut icon" href="img/5.png">
	</head>

	<body>
		<%
			List list = (List) request.getSession().getAttribute("rootlist");
		%>
		<!-- topbar starts -->
		<div class="navbar navbar-default" role="navigation">

			<div class="navbar-inner">
				<button type="button" class="navbar-toggle pull-left animated flip">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp"> <img
						alt="Charisma Logo" src="img/5.png" class="hidden-xs" /> <span>HONGTU</span>
				</a>

				<!-- user dropdown starts -->
				<div class="btn-group pull-right">
					<button class="btn btn-default dropdown-toggle"
						data-toggle="dropdown">
						<i class="glyphicon glyphicon-user"></i><span
							class="hidden-sm hidden-xs">
								<c:choose>
									<c:when test="${login == '0' }"> ${teacher.ename } </c:when>
									<c:when test="${login == '1' }"> ${stu.intenname } </c:when>
								</c:choose>
							</span>
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li>
							<a href="#">Profile</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="login.jsp">退出</a>
						</li>
					</ul>
				</div>
				<!-- user dropdown ends -->

				<!-- theme selector starts -->
				<div class="btn-group pull-right theme-container animated tada">
					<button class="btn btn-default dropdown-toggle"
						data-toggle="dropdown">
						<i class="glyphicon glyphicon-tint"></i><span
							class="hidden-sm hidden-xs"> 皮肤</span>
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" id="themes">
						<li>
							<a class="ajax-link" data-value="classic" href="index.jsp"><i
								class="whitespace"></i> Classic</a>
						</li>
						<li>
							<a class="ajax-link" data-value="cerulean" href="index.jsp"><i
								class="whitespace"></i> Cerulean</a>
						</li>
						<li>
							<a class="ajax-link" data-value="cyborg" href=""><i
								class="whitespace"></i> Cyborg</a>
						</li>
						<li>
							<a class="ajax-link" data-value="simplex" href="#"><i
								class="whitespace"></i> Simplex</a>
						</li>
						<li>
							<a class="ajax-link" data-value="darkly" href="index.jsp"><i
								class="whitespace"></i> Darkly黑色</a>
						</li>
						<li>
							<a class="ajax-link" data-value="lumen" href="#"><i
								class="whitespace"></i> Lumen</a>
						</li>
						<li>
							<a class="ajax-link" data-value="slate" href=""><i
								class="whitespace"></i> Slate</a>
						</li>
						<li>
							<a class="ajax-link" data-value="spacelab" href="/index.jsp"><i
								class="whitespace"></i> Spacelab</a>
						</li>
						<li>
							<a class="ajax-link" data-value="united" href="/index.jsp"><i
								class="whitespace"></i> United</a>
						</li>
					</ul>
				</div>
				<!-- theme selector ends -->


			</div>
		</div>
		<!-- topbar ends -->
		<div class="ch-container">
			<div class="row">
				
				<!-- 侧边栏开始-->
				<div class="col-sm-2 col-lg-2">
					<div class="sidebar-nav">
						<div class="nav-canvas">
							<div class="nav-sm nav nav-stacked">
							</div>

							<ul class="nav nav-pills nav-stacked main-menu" id="divLink">

								<%
									if (list.contains("1")) {
								%>
								<li>
									<a class="ajax-link" href="index.jsp"><i
										class="glyphicon glyphicon-home"></i><span> 首页</span>
									</a>
								</li>

								<%
									}
								%>

								<!--日常办公系统-->
								<%
									if (list.contains("2")) {
								%>
								<li class="accordion">
									<a href="homepage.jsp"><i
										class=" glyphicon glyphicon-tasks"></i><span> 日常办公</span>
									</a>
									<ul class="nav nav-pills nav-stacked">
									<%
										if (list.contains("3")) {
									%>
										<li>
											<a href="liulirong/deptlist">部门管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("4")) {
									%>
										<li>
											<a href="liulirong/emp!list">员工管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("5")) {
									%>
										<li>
											<a href="liulirong/rizhilist">员工工作日志管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("5")) {
									%>
										<li>
											<a href="liulirong/myrizhi">我的日志</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("6")) {
									%>
										<li>
											<a href="chenru/dutyslist.action">值班管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("7")) {
									%>
										<li>
											<a href="chenru/mydutyslist.action">我的值班管理</a>
										</li>
									<%
										}
									%>
									
									<%
										if (list.contains("8")) {
									%>
										<li>
											<a href="liulirong/exam!zhiban">值班安排</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("9")) {
									%>
										<li>
											<a href="#">待办事项</a>
										</li>
									<%
										}
									%>
									</ul>
								</li>

								<%
									}
								%>
								<%
									if (list.contains("10")) {
								%>
								<li class="accordion">
									<a href="homepage.jsp"><i class="glyphicon glyphicon-folder-open"></i><span>
											教务管理</span>
									</a>
									<ul class="nav nav-pills nav-stacked">
									
									<%
										if (list.contains("11")) {
									%>
										<li>
											<a href="jiaowu/courselist.jsp">课程管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("12")) {
									%>
										<li>
											<a href="chenru/fedlist.action">教员反馈</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("70")) {
									%>
										<li>
											<a href="chenru/stufedlist.action?stuclassid=${stu.classid }">教员反馈（学生）</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("13")) {
									%>
										<li>
											<a href="chenru/viewfeed.action">查看反馈（领导）</a>
										</li>
								    <%
										}
									%>
									<%
										if (list.contains("14")) {
									%>
										<li>
											<a href="chenru/viewfeed2.action?teaid=${teacher.eid }">查看反馈（老师）</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("15")) {
									%>
										<li>
											<a href="chenru/dislist.action">研讨会管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("16")) {
									%>
										<li>
											<a href="chenru/dislist1.action">查看研讨会（领导）</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("17")) {
									%>
										<li>
											<a href="chenru/cplist.action">课程进度管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("18")) {
									%>
										<li>
											<a href="chenru/cplist1.action">查看课程进度（领导）</a>
										</li>
									<%
										}
									%>
									</ul>
								</li>
						<%
							}
						%>
						<%
							if (list.contains("19")) {
						%>
								<li class="accordion">
									<a href="homepage.jsp"><i class="glyphicon glyphicon-th-large"></i><span>
											学生管理</span>
									</a>
									<ul class="nav nav-pills nav-stacked">
									<%
										if (list.contains("20")) {
									%>
										<li>
											<a href="classes/clslist">班级管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("21")) {
									%>
										<li>
											<a href="hourse/hrslist">宿舍管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("22")) {
									%>
										<li>
											<a href="stu/listsx">学生信息管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("23")) {
									%>
										<li>
											<a href="score/scosx">成绩管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("71")) {
									%>
										<li>
											<a href="score/scosx2">成绩管理(学生)</a>
										</li>
										<!-- 只查看 -->
									<%
										}
									%>
									<%
										if (list.contains("24")) {
									%>
										<li>
											<a href="prj/prjsx">项目答辩管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("72")) {
									%>
										<li>
											<a href="prj/prjsx2">项目答辩管理(学生)</a>
										</li>
										<!-- 只查看 -->
									<%
										}
									%>
									<%
										if (list.contains("25")) {
									%>
										<li>
											<a href="says/sayssx">谈心记录管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("73")) {
									%>
										<li>
											<a href="says/sayssx2">谈心记录管理(学生)</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("26")) {
									%>
										<li>
											<a href="summary/smysx">学生总结管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("74")) {
									%>
										<li>
											<a href="summary/smysx2">学生总结管理(学生)</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("27")) {
									%>
										<li>
											<a href="job/jobsx">就业管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("28")) {
									%>
										<li>
											<a href="lev/levsx">请假管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("75")) {
									%>
										<li>
											<a href="lev/levsx2">请假管理(学生)</a>
										</li>
										<!-- 可以申请 -->
									<%
										}
									%>
									<%
										if (list.contains("29")) {
									%>
										<li>
											<a href="sbk/sbklist">意见反馈</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("75")) {
									%>
										<li>
											<a href="sbk/sbksx2">意见反馈(学生)</a>
										</li>
										<!-- 只查看自己的反馈 -->
									<%
										}
									%>
									</ul>
								</li>
					<%
						}
					%>
					<%
						if (list.contains("30")) {
					%>
								<li class="accordion">
									<a href="homepage.jsp"><i class="glyphicon glyphicon-book"></i><span>
											财务管理</span>
									</a>
									<ul class="nav nav-pills nav-stacked">
									<%
										if (list.contains("31")) {
									%>
										<li>
											<a href="lcy/shouru.action">收入管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("32")) {
									%>
										<li>
											<a href="lcy/zhichu.action">支出管理</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("33")) {
									%>
										<li>
											<a href="lcy/xuefei.action">学生收费</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("34")) {
									%>
										<li>
											<a href="lcy/salarylist.action">工资管理</a>
										</li>
									<%
										}
									%>
									</ul>
								</li>
					<%
						}
					%>
					<%
						if (list.contains("35")) {
					%>
								<li class="accordion">
									<a href="homepage.jsp"><i class="glyphicon glyphicon-list-alt"></i><span>
											招生管理</span>
									</a>
									<ul class="nav nav-pills nav-stacked">
									<%
										if (list.contains("36")) {
									%>
										<li>
											<a href="zz/list1.action">招生名单</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("37")) {
									%>
										<li>
											<a href="zz/list2.action">预定报名学生</a>
										</li>
									<%
										}
									%>
									</ul>
								</li>
					<%
						}
					%>
					<%
						if (list.contains("38")) {
					%>
								<li class="accordion">
									<a href="#"><i class="glyphicon glyphicon-hdd"></i><span>
											考勤管理</span>
									</a>
									<ul class="nav nav-pills nav-stacked">
									<%
										if (list.contains("63")) {
									%>
										<li>
											<a href="liulirong/exam!kaolist.action">查看考勤</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("62")) {
									%>
										<li>
											<a href="liulirong/exam!mykaolist.action">我的考勤</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("39")) {
									%>
										<li>
											<a href="liulirong/exam!tokaoadd.action">考勤异议申报</a>
										</li>
									<%
										}
									%>
									</ul>
								</li>
					<%
						}
					%>
					<%
						if (list.contains("40")) {
					%>
								<li class="accordion">
									<a href="#"><i class="glyphicon glyphicon-eject"></i><span>
											办公用品管理</span>
									</a>
									<ul class="nav nav-pills nav-stacked">
									<%
										if (list.contains("41")) {
									%>
										<li>
											<a href="#">办公用品申购</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("42")) {
									%>
										<li>
											<a href="#">办公用品申领</a>
										</li>
									<%
										}
									%>
									</ul>
								</li>
					<%
						}
					%>
					<%
						if (list.contains("43")) {
					%>
								<li class="accordion">
									<a href="#"><i class="glyphicon glyphicon-magnet"></i><span>
											请假/加班管理</span>
									</a>
									<ul class="nav nav-pills nav-stacked">
									<%
										if (list.contains("44")) {
									%>
										<li>
											<a href="liulirong/exam!listhol">请休/假申请</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("80")) {
									%>
										<li>
											<a href="liulirong/exam!mylisthol">我的请休/假申请</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("45")) {
									%>
										<li>
											<a href="liulirong/exam!myjiabanlist">我的加班申请</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("61")) {
									%>
										<li>
											<a href="liulirong/exam!jialist">加班申请</a>
										</li>
									<%
										}
									%>
									</ul>
								</li>
				<%
					}
				%>
				<%
					if (list.contains("46")) {
				%>
								<li class="accordion">
									<a href="#"><i class=" glyphicon glyphicon-folder-close"></i><span>
											巡查管理</span>
									</a>
									<ul class="nav nav-pills nav-stacked">
									<%
										if (list.contains("47")) {
									%>
										<li>
											<a href="datas/listxun.jsp">班级巡查</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("48")) {
									%>
										<li>
											<a href="liulirong/toaddxun.action">我的班级巡查</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("49")) {
									%>
										<li>
											<a href="liulirong/roomlist">宿舍巡查</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("50")) {
									%>
										<li>
											<a href="liulirong/myroomlist">我的宿舍巡查</a>
										</li>
									<%
										}
									%>
									</ul>
								</li>
				<%
					}
				%>
				<%
					if (list.contains("51")) {
				%>
								<li class="accordion">
									<a href="#"><i class="glyphicon glyphicon-barcode"></i><span>
											电脑领用管理</span>
									</a>
									<ul class="nav nav-pills nav-stacked">
									<%
										if (list.contains("52")) {
									%>
										<li>
											<a href="apl/aplsx">备用电脑领用</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("77")) {
									%>
										<li>
											<a href="apl/aplsx2">备用电脑领用(学生)</a>
										</li>
									<%
										}
									%>
									</ul>
								</li>
				<%
					}
				%>
				
				<%
					if (list.contains("53")) {
				%>
								<li class="accordion">
									<a href="#"><i class="glyphicon glyphicon-bullhorn"></i><span>
											通知/公告</span>
									</a>
									<ul class="nav nav-pills nav-stacked">
									<%
										if (list.contains("54")) {
									%>
										<li>
											<a href="xiebaolei/list1.action">发布员工公告</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("55")) {
									%>
										<li>
											<a href="xiebaolei/list3.action">查看员工公告</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("56")) {
									%>
										<li>
											<a href="xiebaolei/list2.action">发布学生公告</a>
										</li>
									<%
										}
									%>
									<%
										if (list.contains("57")) {
									%>
										<li>
											<a href="xiebaolei/list4.action">查看学生公告</a>
										</li>
									<%
										}
									%>
									</ul>
								</li>
				<%
					}
				%>
				<%
					if (list.contains("58")) {
				%>
								<li class="accordion">
									<a href="#"><i class="glyphicon glyphicon-cog"></i><span>
											权限管理</span>
									</a>
									<ul class="nav nav-pills nav-stacked">
									<%
										if (list.contains("59")) {
									%>
										<li>
											<a href="liulirong/emp!rootlist">用户权限</a>
										</li>
										<%
											}
										%>
										<%
											if (list.contains("60")) {
										%>
										<li>
											<a href="liulirong/emp!stulist">学生权限</a>
										</li>
										<%
											}
										%>
									</ul>
								</li>
					<%
						}
					%>
							</ul>

						</div>
					</div>
				</div>

				<!--/span-->
				<!--侧边栏结束 -->

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

				<div id="content" class="col-lg-10 col-sm-10">

					<!-- content starts -->
					<iframe id="ifmshow" width="100%" height="3000" name="ifmshow"
						src="${login==1?"homepage2.jsp":"homepage(tea).jsp" }"  frameborder="0" scrolling="no"></iframe>
					<!-- content ends -->

				</div>
				<!--/#content.col-md-0-->
			</div>
			<!--/fluid-row-->


			<hr>

			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">

				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								×
							</button>
							<h3>
								Settings
							</h3>
						</div>
						<div class="modal-body">
							<p>
								Here settings can be configured...
							</p>
						</div>
						<div class="modal-footer">
							<a href="#" class="btn btn-default" data-dismiss="modal">Close</a>
							<a href="#" class="btn btn-primary" data-dismiss="modal">Save
								changes</a>
						</div>
					</div>
				</div>
			</div>

			<footer class="row">
			<p class="col-md-9 col-sm-9 col-xs-12 copyright">
				&copy;
				<a href="http://usman.it" target="_blank">Muhammad Usman</a> 2012 -
				2015
			</p>

			<p class="col-md-3 col-sm-3 col-xs-12 powered-by">
				Powered by:
				<a href="http://usman.it/free-responsive-admin-template">Charisma</a>
			</p>
			</footer>


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

			<script type="text/javascript">


var alink = document.getElementById("divLink").getElementsByTagName("ul");
for(var j=0;j<alink.length;j++){

var liclink=alink[j].getElementsByTagName("li");
		for(var k=0;k<liclink.length;k++){
				var clink=liclink[k].getElementsByTagName("a")
					for (var i=0; i<clink.length; i++)
					{
								clink[i].onclick = function() {
								document.getElementById("ifmshow").src = this.href;
								event.returnValue = false;
							};
					}
			}
}

 </script>
	</body>
</html>
