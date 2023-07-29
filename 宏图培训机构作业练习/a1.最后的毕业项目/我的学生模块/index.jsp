<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<link rel="shortcut icon" href="img/favicon.ico">
	</head>

	<body>
    <!-- topbar starts -->
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html"> <img alt="Charisma Logo" src="img/logo20.png" class="hidden-xs"/>
                <span>HONGTU</span></a>

            <!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> admin</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="#">Profile</a></li>
                    <li class="divider"></li>
                    <li><a href="login.html">退出</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->

            <!-- theme selector starts -->
            <div class="btn-group pull-right theme-container animated tada">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-tint"></i><span
                        class="hidden-sm hidden-xs"> 皮肤</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" id="themes">
                    <li><a data-value="classic" href="#"><i class="whitespace"></i> Classic</a></li>
                    <li><a data-value="cerulean" href="#"><i class="whitespace"></i> Cerulean</a></li>
                    <li><a data-value="cyborg" href="#"><i class="whitespace"></i> Cyborg</a></li>
                    <li><a data-value="simplex" href="#"><i class="whitespace"></i> Simplex</a></li>
                    <li><a data-value="darkly" href="#"><i class="whitespace"></i> Darkly黑色</a></li>
                    <li><a data-value="lumen" href="#"><i class="whitespace"></i> Lumen</a></li>
                    <li><a data-value="slate" href="#"><i class="whitespace"></i> Slate</a></li>
                    <li><a data-value="spacelab" href="#"><i class="whitespace"></i> Spacelab</a></li>
                    <li><a data-value="united" href="#"><i class="whitespace"></i> United</a></li>
                </ul>
            </div>
            <!-- theme selector ends -->

            <ul class="collapse navbar-collapse nav navbar-nav top-menu">
                <li><a href="#"><i class="glyphicon glyphicon-globe"></i> Visit Site</a></li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown"><i class="glyphicon glyphicon-star"></i> Dropdown </a>
                     
                </li>
                <li>
                    <form class="navbar-search pull-left">
                        <input placeholder="搜一搜" class="search-query form-control col-md-10" name="query"
                               type="text">
                    </form>
                </li>
            </ul>

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
                        <li class="nav-header">流程</li>
                        <li><a class="ajax-link" href="index.jsp"><i class="glyphicon glyphicon-home"></i><span> 首页</span></a>
                        </li>

					<!--日常办公系统-->
					<li class="accordion">
                            <a href="homepage.jsp"><i class=" glyphicon glyphicon-eye-open"></i><span> 日常办公</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="calendar.jsp">部门管理</a></li>
                                <li><a href="table.jsp">员工管理</a></li>
								<li><a href="gallery.jsp">员工工作日志管理</a></li>
								<li><a href="#">值班管理</a></li>
							<li><a href="#">电脑领用管理</a></li>
							<li><a href="#">报销申请管理</a></li>
							<li><a href="#">待办事项</a></li>
                            </ul>
                        </li>


						<li class="accordion">
                            <a href="homepage.jsp"><i class="glyphicon glyphicon-hdd"></i><span> 教务管理</span></a>
                            <ul class="nav nav-pills nav-stacked"  id="divLink">
                                <li><a href="table.jsp">课程管理</a></li>
                                <li><a href="#">分班管理</a></li>
								<li><a href="#">教员反馈</a></li>
                                <li><a href="#">研讨会管理</a></li>
								<li><a href="#">课程进度管理</a></li>                                
                            </ul>
                        </li>


						<li class="accordion">
                            <a href="homepage.jsp"><i class="glyphicon glyphicon-book"></i><span> 学生管理</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#">班级管理</a></li>
                                <li><a href="#">宿舍管理</a></li>
								<li><a href="stu/list">学生信息管理</a></li>
                                <li><a href="#">谈心记录管理</a></li>
								<li><a href="#">奖罚管理</a></li>
                                <li><a href="#">成绩管理</a></li>
							 <li><a href="#">学生总结管理</a></li>
							  <li><a href="#">就业管理</a></li>
							<li><a href="#">请假管理</a></li>
							  <li><a href="#">意见反馈</a></li>
                            </ul>
                        </li>

						<li class="accordion">
                            <a href="homepage.jsp"><i class="glyphicon glyphicon-hdd"></i><span> 财务管理</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="lcy/list.action">收入管理</a></li>
								<li><a href="#">支出管理</a></li>
                                <li><a href="#">报销管理</a></li>
								<li><a href="#">工资管理</a></li>                                
                            </ul>
                        </li>

						<li class="accordion">
                            <a href="homepage.jsp"><i class="glyphicon glyphicon-hdd"></i><span> 招生管理</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="#">意向学生管理</a></li>
								<li><a href="#">预定报名学生管理</a></li>
                            </ul>
                        </li>

					<li class="accordion">
								<a href="#"><i class="glyphicon glyphicon-hdd"></i><span> 考勤管理</span></a>
								 <ul class="nav nav-pills nav-stacked">
									<li><a href="#">导入考勤数据</a></li>
									 <li><a href="#">考勤异议申报</a></li>
								 </ul>
							</li>
					
					
								<li class="accordion">
								<a href="#"><i class="glyphicon glyphicon-hdd"></i><span> 办公用品管理</span></a>
								 <ul class="nav nav-pills nav-stacked">
									<li><a href="#">办公用品申购</a></li>
									 <li><a href="#">办公用品申领</a></li>
								 </ul>
							</li>

							<li class="accordion">
								<a href="#"><i class="glyphicon glyphicon-hdd"></i><span> 请假/加班管理</span></a>
								 <ul class="nav nav-pills nav-stacked">
									<li><a href="#">请假申请</a></li>
									<li><a href="#">加假申请</a></li>
									 <li><a href="#">休假申请</a></li>
								 </ul>
							</li>
						
							<li class="accordion">
								<a href="#"><i class="glyphicon glyphicon-hdd"></i><span> 巡查管理</span></a>
								 <ul class="nav nav-pills nav-stacked">
									<li><a href="#">班级巡查</a></li>
									 <li><a href="#">宿舍巡查</a></li>
								 </ul>
							</li>
							
								<li class="accordion">
								<a href="#"><i class="glyphicon glyphicon-hdd"></i><span> 项目答辩管理</span></a>
								 <ul class="nav nav-pills nav-stacked">
									<li><a href="#">答辩评分模板</a></li>
									 <li><a href="#">导出评分表格</a></li>
									 <li><a href="#">导入答辩成绩</a></li>
								 </ul>
							</li>
							

 						  <li class="accordion">
								<a href="#"><i class="glyphicon glyphicon-hdd"></i><span> 电脑领用管理</span></a>
								 <ul class="nav nav-pills nav-stacked">
									<li><a href="#">赠送电脑领用</a></li>
									 <li><a href="#">备用电脑领用</a></li>
									 </ul>
							</li>
							
							<li class="accordion">
								<a href="#"><i class="glyphicon glyphicon-hdd"></i><span> 学生收费管理</span></a>
								 <ul class="nav nav-pills nav-stacked">
									<li><a href="#">收费标准管理</a></li>
								 </ul>
							</li>
							
								<li class="accordion">
								<a href="#"><i class="glyphicon glyphicon-hdd"></i><span> 通知/公告</span></a>
								 <ul class="nav nav-pills nav-stacked">
								 <li><a href="#">系统公告</a></li>
									<li><a href="#">员工公告</a></li>
									<li><a href="#">学生公告</a></li>
								 </ul>
							</li>
							
                    </ul>
                    
                    <label id="for-is-ajax" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on menu</label>
                </div>
            </div>
        </div> 		

        <!--/span-->
        <!--侧边栏结束 -->

        <noscript>
            <div class="alert alert-block col-md-12">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <div id="content" class="col-lg-10 col-sm-10">
        
            <!-- content starts -->
 <iframe id="ifmshow" width="100%" height="2000" name="ifmshow"  src="homepage.jsp" frameborder="1" scrolling="no"></iframe>
    <!-- content ends -->
    
    </div><!--/#content.col-md-0-->
</div><!--/fluid-row-->


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
<script src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
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
