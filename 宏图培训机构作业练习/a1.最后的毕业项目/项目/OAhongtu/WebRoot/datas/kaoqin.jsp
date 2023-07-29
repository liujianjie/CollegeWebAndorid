<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'addxuncha.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<link rel="stylesheet" type="text/css"
			href="TimePick/jquery.datetimepicker.css" />
		<link rel="stylesheet"
			href="kindeditor-4.1.10/themes/default/default.css" />
		<script charset="utf-8" src="kindeditor-4.1.10/kindeditor-min.js"></script>
		<script type="text/javascript">
		var editor;
		KindEditor.ready(function(k){
			 editor=k.create("#kind_editor", {
				items : [
							'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
							'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
							'insertunorderedlist', '|', 'emoticons']
					});
		});
</script>
	</head>

	<body>
		<jsp:include page="common.jsp"></jsp:include>
		<div class="ch-container">
			<div class="row">

				<div id="content" class="col-lg-10 col-sm-10" style="width: 100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="homepage(tea).jsp">首页</a>
							</li>
							<li>
								<a href="#">考勤异议申报</a>
							</li>
						</ul>
					</div>

					<form action="liulirong/exam!kaoadd.action" method="post">
						<div class="row">
							<div class="box col-md-12">
								<div class="box-inner" style="height:450px;">
									<div class="box-header well" data-original-title="">
										<h2>
											<i class="glyphicon glyphicon-edit"></i> 考勤异议申报
										</h2>

										<div class="box-icon">
											<a href="#" class="btn btn-minimize btn-round btn-default"><i
												class="glyphicon glyphicon-chevron-up"></i> </a>
											<a href="#" class="btn btn-close btn-round btn-default"><i
												class="glyphicon glyphicon-remove"></i> </a>
										</div>
									</div>

									<div class="box-content" style="padding: 14px;">
										<label for="exampleInputEmail1">
											姓名：
										</label>
										<div class="control-group"
											style="height: 30px; width: 300px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 20px">
											<input type="text" class="form-control" value="${teacher.ename }" name="kaoqin.ename"
												placeholder="请输入姓名" style="width: 210px;" disabled="disabled">
										</div>

										<label for="exampleInputEmail1">
											时间：
										</label>
										<div class="control-group"
											style="height: 30px; width: 250px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 20px">
											<input type="text" class="form-control" name="kaoqin.kdate"
												placeholder="请输入时间" style="width: 215px;"
												onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});">
										</div>
										
									</div><br/>
									<label for="exampleInputEmail1">
											&nbsp;&nbsp;原因：
										</label>
									<div class="control-group"
										style="height: 30px; width: 250px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 10px">
										<textarea cols="85" rows="7" name="kaoqin.kresion"
											id="kind_editor"></textarea>
									</div>

									<br /><br /><br /><br /><br /><br /><br/><br/>
									&nbsp;&nbsp;
									<label for="exampleInputEmail1"
										style="color: red; font-size: 12px;">
										备注：在三天内说明原因，超过三天按制度执行。
									</label>
									<div class="box-content" style="height: 130px">
										<b>直属领导：</b>
										<div
											style="height: 30px; width: 50px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 10px;">
											<select data-rel="chosen" name="kaoqin.ksid"
												style="width: 200px;">
												<c:forEach items="${list}" var="k">
													<option value="${k.dmid }">
														${k.dmname }
													</option>
												</c:forEach>
											</select>
										</div>
										<div class="box-content">
											<div class="control-group">
												<button type="submit" class="btn btn-default"
													style="width: 100px; margin-left: 310px; margin-top: 8px;">
													<b>添 加</b>
												</button>
											</div>
										</div>
									</div>
								</div>
							</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 日期类型 -->
		<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	</body>
</html>
