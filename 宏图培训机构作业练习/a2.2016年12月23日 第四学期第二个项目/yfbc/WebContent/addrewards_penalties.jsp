<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>奖惩记录添加</title>
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
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-8 col-sm-offset-0">
				<button class="btn btn-primary"
					onclick="location.href='javascript:history.go(-1);'">返回</button>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>奖惩记录添加</h5>
						</div>
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="signupForm" action="add.do"
								method="post" enctype="multipart/form-data">
								<div class="form-group">
									<label class="col-sm-3 control-label">用户名：</label>
									<div class="col-sm-6">
										<input type="hidden" name="userid"
											value="${uservo.users.id}" /> <input type="text"
											class="form-control" value="${uservo.users.username }"
											readonly="readonly"> <span
											class="help-block m-b-none"></span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">岗位：</label>
									<div class="col-sm-6">
										<input class="form-control" type="text" readonly="readonly"
											value="${uservo.pname}" aria-required="true"
											aria-invalid="false" class="valid">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">奖励金额：</label>
									<div class="col-sm-6">
										<input class="form-control" name="bonus" type="text"
											aria-required="true" aria-invalid="false" class="valid">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">奖励原因：</label>
									<div class="col-sm-6">
										<textarea name="bonus_cause" cols="52" rows="4"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">处罚金额：</label>
									<div class="col-sm-6">
										<input class="form-control" name="fine" type="text"
											aria-required="true" aria-invalid="false" class="valid">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">处罚原因：</label>
									<div class="col-sm-6">
										<textarea name="fine_cause" cols="52" rows="4"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">记录时间：</label>
									<div class="col-sm-6">
										<input name="recordtime" class="form-control"
											onclick="WdatePicker();" type="text" readonly="readonly"
											aria-required="true" aria-invalid="false" class="valid">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-8 col-sm-offset-8">
										<button class="btn btn-primary" type="submit">&nbsp;&nbsp;&nbsp;提交&nbsp;&nbsp;&nbsp;</button>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-8 col-sm-offset-8">注：奖励和处罚选填一项，原因可不填。
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- 全局js -->
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script>

	<!-- 自定义js -->
	<script
		src="${pageContext.request.contextPath}/js/content.min.js?v=1.0.0"></script>

	<!-- jQuery Validation plugin javascript-->
	<script
		src="${pageContext.request.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/plugins/validate/messages_zh.min.js"></script>
<!-- 时间控件 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
</body>
</html>