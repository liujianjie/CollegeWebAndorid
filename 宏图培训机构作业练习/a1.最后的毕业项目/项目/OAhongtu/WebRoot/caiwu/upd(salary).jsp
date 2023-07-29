<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- 工资修改页面 -->

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

<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
	function check(){
		var kaohe=$("#kaohe").val();
		var xinzi=$("#xinzi").val();
		var other_salary=$("#other_salary").val();
		var weichuqin=$("#weichuqin").val();
		var bingshijia=$("#bingshijia").val();
		var weiji=$("#weiji").val();
		var fakuan=$("#fakuan").val();
		//alert(kaohe);
		if(kaohe==""){
			alert("请填写考核天数！");
			return false;
		}
		if(isNaN(kaohe)){
			alert("考核天数必须是数字！");
			return false;
		}
		if(kaohe%1!=0){
			alert("考核天数必须是整数！");
			return false;
		}
		
		if(xinzi==""){
			alert("请填写薪资标准！");
			return false;
		}
		if(isNaN(xinzi)){
			alert("薪资必须是数字！");
			return false;
		}
		
		if(other_salary!=""&&isNaN(other_salary)){
			alert("其他工资必须是数字！");
			return false;
		}
		
		if(weichuqin!=""&&isNaN(weichuqin)){
			alert("未出勤天数必须是数字！");
			return false;
		}
		if(weichuqin!=""&&weichuqin%1!=0){
			alert("未出勤天数必须是整数！");
			return false;
		}
		
		
		if(weiji!=""&&isNaN(weiji)){
			alert("违纪罚款必须是数字！");
			return false;
		}
		
		if(bingshijia!=""&&isNaN(bingshijia)){
			alert("病事假天数必须是数字！");
			return false;
		}
		if(bingshijia!=""&&bingshijia%1!=0){
			alert("病事假天数必须是整数！");
			return false;
		}
		
		if(fakuan!=""&&isNaN(fakuan)){
			alert("迟到罚款必须是数字！");
			return false;
		}
		
		return true;
		
		
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
								<a href="index.jsp" target="_blank">主页</a>
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
                <h2><i class="glyphicon glyphicon-edit"></i> 添加工资信息</h2>

                <div class="box-icon">
                    <a href="#" class="btn btn-setting btn-round btn-default"><i
                            class="glyphicon glyphicon-cog"></i></a>
                    <a href="#" class="btn btn-minimize btn-round btn-default"><i
                            class="glyphicon glyphicon-chevron-up"></i></a>
                    <a href="#" class="btn btn-close btn-round btn-default"><i
                            class="glyphicon glyphicon-remove"></i></a>
                </div>
            </div>
            <div class="box-content">
            
       <form action="lcy/upd_salary.action" method="post">
			<div class="ch-container">

				<input type="hidden" value="${sala.salaryId }" name="sa.salaryId">
				
				<input type="hidden" value="${sala.empid }" name="sa.empid">
				
				<div>
					<!-- 
						<select name="sa.saYear">
										<option value="2016" ${sala.saYear==2016?'selected':'' }>2016</option>	
										<option value="2017" ${sala.saYear==2017?'selected':'' }>2017</option>
										<option value="2018" ${sala.saYear==2018?'selected':'' }>2018</option>
					</select>
					 -->
					<input type="text" name="sa.saYear" value="${sala.saYear }" class="form-control" readonly="readonly" style="width: 100px;display: inline;">
					年
					<!-- 
					<select name="sa.saMonth">
										<c:forEach begin="1" end="12" var="i">
											<option value="${i }" ${sala.saMonth==i?'selected':'' }>${i }</option>
										</c:forEach>
					</select>
					 -->
					<input type="text" name="sa.saMonth" value="${sala.saMonth }" class="form-control" readonly="readonly" style="width: 100px;display: inline;">
					月
				</div>


				<table
					class="table table-striped table-bordered bootstrap-datatable datatable responsive"
					width="80%">
					<tbody>
					
					<tr>

						<td>
							<b>员工姓名</b>
						</td>
						<td class="center" width="40%">
							<!-- 
							<select name="sa.empid">
							<c:forEach items="${list}" var="emp">
								<option value="${emp.eid }">${emp.ename}</option>
							</c:forEach>
								
							</select>
							 -->
							 <input style="display: inline; width: 80px;" class="form-control" type="text"  readonly="readonly" value="${sala.ename}">
						</td>

					
						<td class="center">
							考核天数
						</td>
						<td >

							<input style="display: inline; width: 60px;" id="kaohe" type="text" value="${sala.kaohe }" name="sa.kaohe"> 
							天
						</td>
					
						
					</tr>


					<tr>


						
						<td class="center">
							薪资标准
						</td>
						<td class="center">

							<font size="4"  color="red">&yen;</font>
							<input id="xinzi" type="text"  name="sa.xinzi"
								style="display: inline; width: 80px;" value="${sala.xinzi }">
						</td>
						
						
						<td>
							其他工资
						</td>
						<td class="center">
							<font size="4"  color="red">&yen;</font>
							<input id="other_salary" type="text"  name="sa.otherSalary"
								style="display: inline; width: 80px;" value="${sala.otherSalary }">
						</td>
					</tr>
					<tr>
						<td class="center">
							未出勤
						</td>
						<td class="center">

							<input id="weichuqin" type="text"  name="sa.weichuqinN" style="display: inline-block; width: 50px;"
								value="${sala.weichuqinN }" >
							天
						</td>

						<td>
							违纪罚款
						</td>
						<td class="center">
							<font size="4" color="red">&yen;</font>
							
							<input id="weiji" type="text"  name="sa.weijiF" style="display: inline; width: 80px;"
								value="${sala.weijiF }">
						</td>

					</tr>

					<tr>
						<td>
							病事假
						</td>
						<td class="center">

							<input id="bingshijia" type="text" name="sa.bingshijiaN" style="display: inline-block; width: 50px;"
								 value="${sala.bingshijiaN }"/>
							天
						</td>
						
						<td class="center">
							迟到/漏打卡

						</td>
						<td class="center">

							<font size="4" color="red">&yen;</font>
							<input id="fakuan" name="sa.chidaoF"  type="text" 
								style="display: inline; width: 80px;"
								value="${sala.chidaoF }">
						</td>

						
					</tr>
					
					<tr>

						<td class="center">
							结算人
						</td>
						<td class="center">
							<input type="text" value="${teacher.ename }" readonly="readonly" name="sa.jiesuanren" 
								class="form-control" style="display: inline; width: 120px;">

						</td>

						
						<td class="center">
							
						</td>
						<td class="center">
							 
								

						</td>


					</tr>

					</tbody>

				</table>




				<!-- submit提交按钮样式 -->
				<div class="box-content">
					<div class="control-group">
						<button type="submit" onclick="return check();" class="btn btn-default">
							<b>结算</b>
						</button>
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


	</body>
</html>
