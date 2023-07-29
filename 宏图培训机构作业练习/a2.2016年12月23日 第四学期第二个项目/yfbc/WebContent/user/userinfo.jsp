<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
							<h5>用户详细资料</h5>
						</div>
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="signupForm" action="upd.do" method="post" enctype="multipart/form-data">
								
								<div class="form-group">
									<label class="col-sm-3 control-label">用户名：</label>
									<div class="col-sm-6">
									<input type="hidden" name="id" value = "${user.id }">
										<input name="username" class="form-control" type="text" value="${user.username}">
										<span class="help-block m-b-none"></span>
									</div>
								</div>
						
								<div class="form-group">
									<label class="col-sm-3 control-label">手机：</label>
									<div class="col-sm-6">
										<input name="mobile" class="form-control" type="text" aria-required="true" aria-invalid="false"
											class="valid" value="${user.mobile}">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">性别：</label>
									<div class="col-sm-2">
										<div class="radio">
											<label> <input type="radio" name="sex" value="男" ${user.sex== '男'?'checked':''}>男
											</label>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="radio">
											<label> <input type="radio" name="sex" value="女" ${user.sex== '女'?'checked':''}>女
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">住址：</label>
									<div class="col-sm-3">
										<input name="mobile" class="form-control" type="text" aria-required="true" aria-invalid="false"
											class="valid" value="${user.address }">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">岗位：</label>
									<div class="col-sm-3">
										<select class="form-control m-b"  name = "positionid">
											<option value="待分配">待分配</option>
											<c:forEach items="${position }" var="pos">
												<option value="${pos.id }" ${pos.id == user.positionid ?'selected':''}>${pos.pname }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">头像：</label>
									<div class="col-sm-6">
										<img alt="image" class="img-circle m-t-xs img-responsive"
										src="${pageContext.request.contextPath }/${user.picpath }">
									</div>
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
	
</body>
<script type="text/javascript">
		function showcity() {
			
			var provinceid  = $("#provinceid").val();
			$.post("city.do",{provinceid:provinceid},function(result){
				var list = result.citys;
				$.each(list,function(index,city){
					var option=$("<option>",{
						"val":city.cityid,
						"text":city.name
					});
					$("#city").append(option);
				});
			},"json");
		}
	</script>
</html>