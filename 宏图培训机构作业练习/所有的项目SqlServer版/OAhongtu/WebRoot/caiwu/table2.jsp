<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- 支出列表页面 -->

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
	function check1(){
		var f1=document.getElementById("f1").value;
		var f2=document.getElementById("f2").value;
		
		location.href="lcy/zhichu1.action?ff1="+f1+"&ff2="+f2;												
	}
	function check2(){
		
		var f3=document.getElementById("f3").value;
		//alert(f3);
		location.href="lcy/zhichu2.action?ff3="+f3;												
	}
	
	
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
	
	//局部刷新1
	function ByYear(){
	
		$("#ipt").val("");
		var year=$("#year").val();
		//alert(year);
		$.post("lcy/json!selByYear2.action",{id:year},function(data){
			var money=data.f;
			//alert(data.f);
			$("#ipt").val(money);
		},"json");
	
	}
	//局部刷新2
	function ByYearMonth(){
	$("#ipt2").val("");
		var year1=$("#year1").val();
		var month1=$("#month1").val();
		//alert(year1);
		//alert(month1);
		$.post("lcy/json!selByYearMonth2.action",{id1:year1,id2:month1},function(data){
			var money=data.f;
			$("#ipt2").val(money);
		},"json");
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
								<a href="#">支出管理</a>
							</li>
							
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 支出管理
									</h2>

									
								</div>
								<div class="box-content">
									<div class="alert alert-info" style="height: 70px;">
										<a href="caiwu/add2.jsp" class="btn btn-success" style="float: right;"><i class="glyphicon glyphicon-pencil"></i> 添加支出</a>
									</div>
									
									
									
									<div>
								
									<font style="display:block;color: green;font-family: 'Microsoft YaHei';">查询金额</font>
									
									<select id="year"  style="width: 70px;">
										<option value="2016" >2016</option>	
										<option value="2015">2015</option>
										<option value="2014">2014</option>
										<option value="2013">2013</option>
										<option value="2015">2012</option>
									</select>
									年的总支出
									<font color="red">&yen;</font><input style="display: inline;width: 100px;font-weight: bold;"  type="text" id="ipt" style="width: 80px;font-weight: bold;"/>
									
									<input type="button" value="查询" onclick="ByYear();">
									
								
								<br/>
									
									<select id="year1"  style="width: 70px;">
										<option value="2016" >2016</option>	
										<option value="2015">2015</option>
										<option value="2014">2014</option>
									</select>
									年
									<select id="month1"  style="width: 50px;">
										<c:forEach begin="1" end="12" var="i">
											<option value="${i }">${i }</option>
										</c:forEach>
									</select>
									月
									的总支出
									<font color="red">&yen;</font><input style="display: inline;width: 100px;font-weight: bold;"  type="text" id="ipt2" style="width: 80px;font-weight: bold;"/>
									
									
									<input type="button" value="查询" onclick="ByYearMonth();">
									
								</div>
								
								<br/>
								
									
									
									<table
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th>
													序号
												</th>
												<th>
													支出项目
												</th>
												<th>
													支出金额
												</th>
												<th>
													经手人
												</th>
												<th>
													支出时间
												</th>
												<th width="20%">
													备注
												</th>
												
												<th width="20%">
													操作
												</th>
											</tr>
										</thead>
										<tbody>
											
										<c:forEach items="${list}" var="obj">
											<tr>
												<td>
													${obj.ZHICHU_ID }
												</td>
												<td class="center">
													<c:if test="${obj.ZHICHU_XIANGMU==0}">员工工资</c:if>
													<c:if test="${obj.ZHICHU_XIANGMU==1}">公司旅游</c:if>
													<c:if test="${obj.ZHICHU_XIANGMU==2}">员工生日</c:if>
													<c:if test="${obj.ZHICHU_XIANGMU==3}">年终奖</c:if>
													<c:if test="${obj.ZHICHU_XIANGMU==4}">接待</c:if>
													<c:if test="${obj.ZHICHU_XIANGMU==5}">办公用品</c:if>
													<c:if test="${obj.ZHICHU_XIANGMU==6}">报销</c:if>
													<c:if test="${obj.ZHICHU_XIANGMU==7}">其他</c:if>
												</td>
												<td class="center">
													${obj.ZHICHU_JINE }
												</td>
												<td class="center">
													${obj.JINGSHOUREN }
												</td>
												<td class="center">
													${obj.ZHICHU_TIME }
												</td>
												<td class="center">
													${obj.BEIZHU }
												</td>
												
												
												<td>
													<a class="btn btn-primary" href="lcy/toupd2.action?id=${obj.ZHICHU_ID }"> <i
														class="glyphicon glyphicon-edit icon-white"></i> 编辑 </a>
													<a class="btn btn-danger" href="lcy/del2.action?id=${obj.ZHICHU_ID }" onclick="javascript:return del();"> <i
														class="glyphicon glyphicon-trash icon-white"></i> 删除 </a>
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
