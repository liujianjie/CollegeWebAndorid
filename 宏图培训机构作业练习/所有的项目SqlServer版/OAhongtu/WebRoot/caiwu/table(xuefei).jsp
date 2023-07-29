<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- 学费页面 -->

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

	<script type="text/javascript">
		function check(){
			//班级
			var sel1=document.getElementById("sel1").value; 
			//学期
			var sel2=document.getElementById("sel2").value;
			//alert("sel1: "+sel1+ "    "+"sel2: "+sel2);
			location.href="lcy/xuefei.action?id1="+sel1+"&id2="+sel2;
		}
	</script>

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
								<a href="homepage(tea).jsp">首页</a>
							</li>
							<li>
								<a href="#">学生收费信息</a>
							</li>
							
							
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 学生收费信息
									</h2>

									
								</div>
								<div class="box-content">
									<div class="alert alert-info" style="height: 70px;">
										
										<a href="lcy/findAllClass.action" class="btn btn-success" style="float: right;">
										<i
											class="glyphicon glyphicon-pencil"></i> 添加学费缴纳记录</a>
									</div>
									
									<div>
										<font size="3" color="#2fb98c"><b>收费情况</b></font>
									</div>
									
									<br/>
									
									<table
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th>
													学生ID
												</th>
												<th>
													学生姓名
												</th>
												<th>
													学生班级
												</th>
												
												<th>
													学期
												</th>
												<th>
													实际缴费
												</th>
												<th>
													经手人
												</th>
												<th>
													缴费方式
												</th>
												<th>
													缴费时间
												</th>
											</tr>
										</thead>
										<tbody>
											
										<c:forEach items="${list1}" var="obj">
											<tr>
												<td class="center">
													${obj.stuid }
												</td>
												<td class="center">
													${obj.stuname }
												</td>
												<td class="center">
													${obj.stuclass }
												</td>
												<td class="center">
													<c:if test="${obj.xueqiId==1 }">第一學期</c:if>
													<c:if test="${obj.xueqiId==2 }">第二學期</c:if>
													<c:if test="${obj.xueqiId==3 }">第三學期</c:if>
												</td>
												<td class="center">
													${obj.jine }
												</td>
												<td class="center">
													${obj.jingshouren }
												</td>
												<td class="center">
													<c:if test="${obj.jiaofeiFangshi==0 }">现金</c:if>
													<c:if test="${obj.jiaofeiFangshi==1 }">银行转账</c:if>
													<c:if test="${obj.jiaofeiFangshi==2 }">支付宝转账</c:if>
													<c:if test="${obj.jiaofeiFangshi==3 }">支票</c:if>
												</td>
												<td class="center">
													${obj.xuefeiTime }
												</td>
											</tr>
										</c:forEach>
											
											
										</tbody>
									</table>
									
									<hr style="border: 1px solid #e0e0e0;"/>
									
									<div>
										<font size="3" color="#2fb98c"><b>缴纳状态</b></font>
									</div>
									
									<br/>
									
									<div>
										<b>班级：</b>
										<select id="sel1"  style="width: 100px;">
											<c:forEach items="${list3}" var="user">
												<option value="${user.CLASSID }" ${num1==user.CLASSID?'selected':'' }>${user.CLASSNAME }</option>
											</c:forEach>
										</select>
										
										<b>学期：</b>
										<select id="sel2"  style="width: 100px;">
											
												<option value="1" ${num2==1?'selected':'' }>第一学期</option>
												<option value="2" ${num2==2?'selected':'' }>第二学期</option>
												<option value="3" ${num2==3?'selected':'' }>第三学期</option>
											
										</select>
										
										
										<input type="button" value="查看"  onclick="check();">
										
										
									</div>
									<br/>
									<table
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th>
													学生ID
												</th>
												<th>
													学生姓名
												</th>
												<th>
													学生班级
												</th>
												
												<th>
													学期
												</th>
												<th>
													缴费状态
												</th>
												
												
											</tr>
										</thead>
										
										
										<tbody>
											
										<c:forEach items="${list2}" var="ob">
											<tr>
												<td class="center">
													${ob.STUID }
												</td>
												<td class="center">
													${ob.STUNAME }
												</td>
												<td class="center">
													${ob.STUCLASS }
												</td>
												<td class="center">
													<c:if test="${ob.XUEQI_ID==1}">第一學期</c:if>
													<c:if test="${ob.XUEQI_ID==2}">第二學期</c:if>
													<c:if test="${ob.XUEQI_ID==3}">第三學期</c:if>
												</td>
												<td class="center">
													<c:if test="${ob.STATUS=='已缴清' }"><span class="label label-default">${ob.STATUS }</span></c:if>
													<c:if test="${ob.STATUS=='未缴清' }"><span class="label label-danger">${ob.STATUS }</span></c:if>
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


	</body>
</html>
