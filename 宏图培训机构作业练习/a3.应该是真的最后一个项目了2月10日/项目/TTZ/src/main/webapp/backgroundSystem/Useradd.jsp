<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>用户管理</title>
<meta name="keywords" content="">
<meta name="description">

<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/style.min.css?v=3.2.0"
	rel="stylesheet">
<!-- 文件 -->
<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/fileUpload.css?v=3.2.0"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/foregroundSystem/css/style2.css">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>添加用户</h5>
						</div>
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="signupForm"
								action="${pageContext.request.contextPath }/backuser/add.action"
								method="post" enctype="multipart/form-data">
								<div class="form-group">
									<label class="col-sm-3 control-label">用户名：</label>
									<div class="col-sm-6">
										<input id="b_username" name="b_username" class="form-control"
											type="text" placeholder="请输入用户名" datatype="*"
											errormsg="请输入用户名"
											ajaxurl="<%=path%>/backuser/YanZhengBackUsername.action">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">密码：</label>
									<div class="col-sm-6">
										<input id="b_pwd" name="b_pwd" class="form-control"
											type="password" aria-required="true" aria-invalid="false"
											class="valid" placeholder="请确认密码" datatype="*"
											errormsg="请输入密码">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">确认密码：</label>
									<div class="col-sm-6">
										<input id="b_pwd2" name="b_pwd2" class="form-control"
											type="password" aria-required="true" aria-invalid="false"
											class="valid" recheck="b_pwd" placeholder="请确认密码"
											datatype="*" errormsg="请确认密码">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">手机：</label>
									<div class="col-sm-3">
										<input id="b_tel" name="b_tel" class="form-control"
											type="text" aria-required="true" aria-invalid="false"
											class="valid" placeholder="请输入手机号"
											datatype="/^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/"
											errormsg="请输入手机号">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">性别：</label>
									<div class="col-sm-2">
										<div class="radio">
											<label> <input type="radio" name="b_sex" value="男"
												checked="checked">男
											</label>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="radio">
											<label> <input type="radio" name="b_sex" value="女">女
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">住址：</label>
									<div class="col-sm-6">
										<input id="b_address" name="b_address" class="form-control"
											type="text" class="valid" placeholder="请输入住址" datatype="*"
											errormsg="请输入住址">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">岗位：</label>
									<div class="col-sm-3">
										<select id="b_positionid" class="form-control m-b"
											name="b_positionid">
											<option value="待分配">待分配</option>
											<c:forEach items="${post }" var="pos">
												<option value="${pos.p_id }">${pos.p_name }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">头像：</label>
									<div class="col-sm-6">
										<div class="uploader white">
											<input type="text" class="filename" readonly="readonly">
											<input type="button" class="button" value="上传..."> <input
												type="file" name="files" size="30" accept="image/*">
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-8 col-sm-offset-8">
										<button class="btn btn-primary" type="submit"
											onclick="return checks();">&nbsp;&nbsp;&nbsp;提交&nbsp;&nbsp;&nbsp;</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		function checks() {
			var b_username = $("#b_username").val();
			if (b_username.length > 24) {
				alert("用户名称字符过长");
				return false;
			}
			return true;
		}
	</script>

	<!-- 全局js -->
	<script
		src="${pageContext.request.contextPath}/backgroundSystem/js/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/backgroundSystem/js/bootstrap.min.js?v=3.4.0"></script>

	<!-- 自定义js -->
	<script
		src="${pageContext.request.contextPath}/backgroundSystem/js/content.min.js?v=1.0.0"></script>

	<!-- jQuery Validation plugin javascript-->
	<script
		src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/validate/jquery.validate.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/validate/messages_zh.min.js"></script>
	<!-- 不知道为什么 必须放在后面，好像 把上面的js 放到后面就行了，哦我知道了，这里使用了id而页面还没加载过-->
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/backgroundSystem/js/fileUpload.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/foregroundSystem/script/Validform_v5.3.2_min.js"></script>
	<script>
		$.validator.setDefaults({
			highlight : function(a) {
				$(a).closest(".form-group").removeClass("has-success")
					.addClass("has-error")
			},
			success : function(a) {
				a.closest(".form-group").removeClass("has-error").addClass(
					"has-success")
			},
			errorElement : "span",
			errorPlacement : function(a, b) {
				if (b.is(":radio") || b.is(":checkbox")) {
					a.appendTo(b.parent().parent().parent())
				} else {
					a.appendTo(b.parent())
				}
			},
			errorClass : "help-block m-b-none",
			validClass : "help-block m-b-none"
		});
		$().ready(function() {
			//表单验证功能
			$("#signupForm").Validform({
				tiptype : 2
			});
		});
	</script>


</body>

</html>