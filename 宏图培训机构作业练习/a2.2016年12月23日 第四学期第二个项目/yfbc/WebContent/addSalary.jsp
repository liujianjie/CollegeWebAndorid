<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>工资</title>
<meta name="keywords" content="">
<meta name="description">

<link
	href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/style.min.css?v=3.2.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/fileUpload.css?v=3.2.0"
	rel="stylesheet">
	
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-8 col-sm-offset-0">
				<button class="btn btn-primary"
					onclick="location.href='javascript:history.go(-1);'">返回</button>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-sm-12">
				<div class="col-sm-1"></div>
				<div class="col-sm-10">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>工资添加</h5>
						</div>
						<div class="ibox-content">
							<!-- 							表格上方start -->
							<div class="col-sm-12">
								<div class="col-sm-2">
									<input type="text" id="year" name="year" value="${year }"
										class="form-control" placeholder="请输入年份">
								</div>
								<div class="col-sm-2">
									<select class="form-control" id="m" name="m">
										<option>月份</option>
										<c:forEach begin="1" end="12" varStatus="mm">
											<c:if test="${mm.index==month}">
												<option value="${mm.index }" selected>${mm.index }
												</option>
											</c:if>
											<c:if test="${mm.index!=month}">
												<option value="${mm.index }">${mm.index }</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-2">
									<div class="row">
										<a class="btn btn-primary"
											href="expSalaryExcel.do">导出本地数据</a>
									</div>

								</div>
								<div class="col-sm-2">
									<div class="row">
										<a data-toggle="modal" class="btn btn-primary"
											href="addSalary.jsp#modal-form">导入本地数据</a>
									</div>
								</div>
							</div>
							<!-- 							表格上方end -->
							<!-- 						表格数据start	 -->
							<table class="table table-hover" id="tab">
								<thead>
									<tr>
										<th>用户姓名</th>
										<th>岗位</th>
										<th>基本工资</th>
										<th>提成工资</th>
										<th>奖励金额</th>
										<th>处罚金额</th>
										<th>实发工资</th>
										<th>时间</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${salaryVoList}" var="salaryvo" begin="0" end="${salaryVoList.size() }" varStatus="index">
										<tr>
		<td id="td_${index.index }_0" style="DISPLAY:none">${salaryvo.salary.userid }</td>
		<td id="td_${index.index }_1">${salaryvo.username }</td>
		<td id="td_${index.index }_2" style="DISPLAY:none">${salaryvo.salary.positionid }</td>
		<td id="td_${index.index }_3">${salaryvo.positionname }</td>
		<td id="td_${index.index }_4">${salaryvo.salary.basesal }</td>
		<td id="td_${index.index }_5">${salaryvo.salary.deduction_wage }</td>
		<td id="td_${index.index }_6">${salaryvo.salary.bonus }</td>
		<td id="td_${index.index }_7">${salaryvo.salary.fine }</td>
		<td id="td_${index.index }_8">${salaryvo.salary.sfgz }</td>
		<td id="td_${index.index }_9">
		<fmt:formatDate value="${salaryvo.salary.time }" type="date" pattern="yyyy-MM-dd"/>
		</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<input type="hidden" value="${salaryVoList.size() }" id="listsize"/>
							<!-- 						表格数据end	 -->
						</div>
					</div>
				</div>
				<div class="col-sm-1"></div>
			</div>
		</div>
	</div>


	<!-- 弹出form表单 start-->
	<div id="modal-form" class="modal fade" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<div class="row">
						<div class="col-sm-12">
							<div class="ibox float-e-margins">
								<div class="ibox-title">
									<h5>选择本地数据</h5>
								</div>
								<div class="ibox-content">
									<form class="form-horizontal m-t" id="signupForm"
										action="${pageContext.request.contextPath}/salary/addsalaryExcel.do"
										method="post" enctype="multipart/form-data">
										<!-- 								<input id="fileSelect" name="fileSelect" type="file" -->
										<!-- 									accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" /> -->
										<div class="uploader white">
											<input type="text" class="filename" readonly="readonly">
											<input type="button" class="button" value="上传..."> <input
												type="file" name="fileSelect" size="30"
												accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel">
										</div>
										<div class="form-group">
											<div class="col-sm-8 col-sm-offset-8">
												<button class="btn btn-primary" type="submit">&nbsp;&nbsp;&nbsp;提交&nbsp;&nbsp;&nbsp;</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 弹出form表单 end-->

	<!-- 全局js -->
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script>

	<!-- 自定义js -->
	<script
		src="${pageContext.request.contextPath}/js/content.min.js?v=1.0.0"></script>

	<!-- DROPZONE -->
	<script
		src="${pageContext.request.contextPath}/js/plugins/dropzone/dropzone.js"></script>
	<script>
		$(document).ready(
				function() {
					Dropzone.options.myAwesomeDropzone = {
						autoProcessQueue : false,
						uploadMultiple : true,
						parallelUploads : 100,
						maxFiles : 100,
						init : function() {
							var a = this;
							this.element.querySelector("button[type=submit]")
									.addEventListener("click", function(b) {
										b.preventDefault();
										b.stopPropagation();
										a.processQueue()
									});
							this.on("sendingmultiple", function() {
							});
							this.on("successmultiple", function(c, b) {
							});
							this.on("errormultiple", function(c, b) {
							});
						}
					}
				});
	</script>
	<!-- jQuery Validation plugin javascript-->
	<script
		src="${pageContext.request.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/plugins/validate/messages_zh.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js">
		
	</script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/fileUpload.js">
	</script>
	<script type="text/javascript">
		$(function() {
			var issuccess=${issuccess};
			console.log(issuccess);
			if(issuccess!=null&&issuccess!=''){
				console.log(issuccess);
				if(issuccess==1){
					alert("导入成功，数据已保存");
					console.log("yes");
				}
				if(issuccess==2){
					alert("导入失败，请再次确认数据");
					console.log("no");
				}
			}
			
		});
	</script>
</body>

</html>