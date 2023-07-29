<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">   
  <head>
    <base href="<%=basePath%>">
    
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
		
		<link rel="stylesheet" type="text/css"
			href="TimePick/jquery.datetimepicker.css" />
			
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
								<a href="javascript:history.go(-1);">返回上一页</a>
							</li>
						</ul>
					</div>
	     <!-- content starts -->
<div class="row">
    <div class="box col-md-12">
        <div class="box-inner">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-edit"></i> 添加部门</h2>

            </div>
            <br/>
            <div class="alert alert-info"
				style="padding-top: 7px; border-bottom-width: 0px; padding-bottom: 7px; height: 52px; padding-left: 870px; border-top-width: 1px;">
				
				<a class="btn btn-success" href="liulirong/deptmanlist.action">
					<i class="glyphicon glyphicon-zoom-in icon-white"></i> 添加部门负责人 </a>
			</div>
            
            <div class="box-content">
                <form role="form" action="liulirong/deptadd" method="post">
                    <div class="box-content">
                    	<label >部门名称: </label>
						<div class="control-group" style="height:30px;width:300px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:30px">
	                        <input type="text" class="form-control" name="dept.dname" placeholder="请输入部门" style="width:370px;">
	                    </div>
                    </div>
  
                    <div class="box-content">
                   			<label class="control-label" for="selectError">部门负责人</label>
							<div class="control-group"style="height:20px;width:300px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:15px">
								
								<div class="controls">
									<select name="dept.deptman" data-rel="chosen" style="width:370px;">
										<c:forEach items="${mlist}" var="m">
										<option value="${m.dmid }">${m.dmname }</option>	
										</c:forEach>							
									</select>
								</div>
							</div>
                  	  </div>
                    
                    <!-- submit提交按钮样式 -->                    
                    <div class="box-content">
						<div class="control-group">
                    		<button type="submit" class="btn btn-default">添加</button>
                    	</div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div><!--/row-->
    <!-- content ends -->

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
