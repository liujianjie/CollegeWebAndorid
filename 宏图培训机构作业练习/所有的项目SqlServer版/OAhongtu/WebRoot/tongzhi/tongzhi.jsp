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
	//确认是否删除
	function del(){
		var msg = "您真的确定要删除吗？";
		if (confirm(msg)==true){
			return true;
		}
		else{
			return false;
		}
	}
</script>
	</head>

	<body>
	
	<div class="ch-container">
    <div class="row"> 


				<div id="content" class="col-lg-10 col-sm-10" style="width:100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
						<li>
								<a href="homepage(tea).jsp">首页</a>
							</li>
							<li>
								<a href="#">发布公告</a>
							</li>
							
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 
										<c:if test="${num==1}">员工公告</c:if>
										<c:if test="${num==2}">学生公告</c:if>
										
									</h2>

								</div>
								<div class="box-content">
									<div class="alert alert-info" style="height: 70px;">
										<c:if test="${num==1}"><a href="tongzhi/TongZhiadd.jsp" class="btn btn-success" style="float: right;"><i
											class="glyphicon glyphicon-pencil"></i> 添加员工公告</a></c:if>
										<c:if test="${num==2}"><a href="tongzhi/TongZhiadd2.jsp" class="btn btn-success" style="float: right;"><i
											class="glyphicon glyphicon-pencil"></i> 添加学生公告</a></c:if>
										
									</div>
								
									
									<table
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th>
													序号
												</th>
												<th>
													标题
												</th>
												<th>
													状态
												</th>	
												<th>
													发布人
												</th>
												<th>
													发布时间
												</th>																						
												<th width="28%">
													操作
												</th>
											</tr>
										</thead>
										<tbody>
											
										<c:forEach items="${list}" var="xtz">
											<tr>
												<td>
													${xtz.MSGID }
												</td>
												<td>
													${xtz.MSGTITLE}
																
												</td>
												<td>
													<c:if test="${xtz.MSGSTATUS==0}">
														<span class="label label-default">未发布</span>
													</c:if>	
													<c:if test="${xtz.MSGSTATUS==1}">
														<span class="label label-success">已发布</span>
													</c:if>														
												</td>
												<td>
													${xtz.FABUREN}
																
												</td>
												<td>
													${xtz.FABUTIME}
																
												</td>	
												
																					
												<td>  
												  
												<c:if test="${xtz.MSGSTATUS==0}">
												<a class="btn btn-success" href="xiebaolei/fabu.action?id=${xtz.MSGID }"> <i
														class="glyphicon glyphicon-share-alt"></i> 发布 </a>
														
													<a class="btn btn-primary" href="xiebaolei/xq.action?id=${xtz.MSGID }">
														<i class="glyphicon glyphicon-zoom-in icon-white"></i> 详情 </a>
														
															<a class="btn btn-info" href="xiebaolei/toupd.action?id=${xtz.MSGID }"> <i
														class="glyphicon glyphicon-edit icon-white"></i> 编辑 </a>
														
													<a class="btn btn-danger" href="xiebaolei/del.action?id=${xtz.MSGID }" onclick="return del();"> <i
														class="glyphicon glyphicon-trash icon-white"></i> 删除 </a>
														
												</c:if>
													
													 
												<c:if test="${xtz.MSGSTATUS==1}">
													<a class="btn btn-primary" href="xiebaolei/xq.action?id=${xtz.MSGID }">
														<i class="glyphicon glyphicon-zoom-in icon-white"></i> 详情 </a>
															<a class="btn btn-info" href="xiebaolei/toupd.action?id=${xtz.MSGID }"> <i
														class="glyphicon glyphicon-edit icon-white"></i> 编辑 </a>
														
													<a class="btn btn-danger" href="xiebaolei/del.action?id=${xtz.MSGID }" onclick="return del();"> <i
														class="glyphicon glyphicon-trash icon-white"></i> 删除 </a>
												</c:if>
												
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
