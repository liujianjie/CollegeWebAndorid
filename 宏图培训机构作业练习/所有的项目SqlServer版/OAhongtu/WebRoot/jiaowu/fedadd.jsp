<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<base href="<%=basePath%>">
	<head>
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
		function  changeitems(){
		$(".cla").html("<option>--请选择反馈的班级--</option>");
			$.post("chenru/frm?empid="+$("#emp1").val(),{},function(data){
				var list = data.lists;
				for(var i=0;i<list.length;i++){
					$(".cla").append($("<option>",{
						"value":list[i].CLASSID,
						"text":list[i].CLASSNAME
					}))
				}
			},'json')
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
								<a href="javascript:history.go(-1);">返回上一页</a>
							</li>
						</ul>
					</div>
	            <!-- content starts -->
<div class="row">
    <div class="box col-md-12">
        <div class="box-inner" style="height: 420px;">
            <div class="box-header well" data-original-title="">
                <h2><i class="glyphicon glyphicon-edit"></i> 添加教员反馈</h2>

            </div>
            
            <div class="box-content">
                <form role="form" action="chenru/fedadd.action" method="post">
                
<!-- 普通框 -->
										<div class="box-content">
											<b>&nbsp;&nbsp;年 份：</b>
											<div class="form-group"
												style="height: 40px; width: 110px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 15px;">
												<input type="text" class="form-control"
													name="fed.fedtime" placeholder="请输入年份">
											</div>

											<!-- 普通框 -->
											<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;月 份 ：</b>
											<div class="form-group"
												style="height: 30px; width: 110px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 15px;">
													
													<select  name="fed.fedmonth"  data-rel="chosen"  style="width:200px;">
							<option>--请选择反馈月份--</option>
								<option  value="1" >一月</option>
								<option  value="2" >二月</option>
								<option  value="3" >三月</option>
								<option  value="4" >四月</option>
								<option  value="5" >五月</option>
								<option  value="6" >六月</option>
								<option  value="7" >七月</option>
								<option  value="8" >八月</option>
								<option  value="9" >九月</option>
								<option  value="10" >十月</option>
								<option  value="11" >十一月</option>
								<option  value="12" >十二月</option>
							</select>
													
											</div>
										</div>
<!-- 时间日历框 -->                  
                     <div class="box-content">
							<div class="control-group">
                        <label for="ctime">&nbsp;&nbsp;结束时间 ：</label>
						<div class="control-group" style="height:40px;width:300px;display: inline-block;margin-bottom: 0;vertical-align:middle;margin-left:5px">
	                        <input type="text" class="form-control" name="fed.fedendtime" placeholder="请选择结束时间" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});">
	                    </div>
                    </div>  
                <br/>
   <!-- 下拉框 -->             
					<div class="box-content">
							<div class="control-group">
							<label class="control-label" for="selectError">反馈对象：</label>
							<div class="controls" style="height:30px;width:350px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;">
							
							<select  onchange="changeitems();"  data-rel="chosen"  style="width:200px;" name="fed.empid" id="emp1">
							<option>--请选择反馈的对象--</option>
								<c:forEach items="${listemp}" var="emp">
								<option  value="${emp.eid}" >${emp.ename }</option>
								</c:forEach>							
							</select>
							</div>
						</div>
                    </div>
                    <br/>
<!-- 下拉框 -->             
					<div class="box-content">
							<div class="control-group">
							<label class="control-label" for="selectError">反馈班级：</label>
							<div id="controls" class="controls" style="height:30px;width:350px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;">
								<select style="width:200px;" name="fed.classid" class="cla">
								<option>--请选择反馈的班级--</option>
								</select>
							</div>
						</div>
                    </div>
                    <br/>
                    
<!-- submit提交按钮样式 -->                    
                    <div class="box-content">
						<div class="control-group">
                    		<button type="submit" class="btn btn-default" style="width:130px;margin-left:120px;"><b>添 加</b></button>
                    	</div>
                    </div>
                </form>

            </div>
        </div>
    </div>
    <!--/span-->

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
<!-- 日期类型 -->
		<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>


	</body>
</html>
