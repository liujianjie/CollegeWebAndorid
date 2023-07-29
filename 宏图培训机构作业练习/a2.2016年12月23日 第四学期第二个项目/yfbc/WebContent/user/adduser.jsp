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
<style type="text/css">
.uploader {
	position: relative;
	display: inline-block;
	overflow: hidden;
	cursor: default;
	padding: 0;
	margin: 10px 0px;
	-moz-box-shadow: 0px 0px 5px #ddd;
	-webkit-box-shadow: 0px 0px 5px #ddd;
	box-shadow: 0px 0px 5px #ddd;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
}

.filename {
	float: left;
	display: inline-block;
	outline: 0 none;
	height: 32px;
	width: 180px;
	margin: 0;
	padding: 8px 10px;
	overflow: hidden;
	cursor: default;
	border: 1px solid;
	border-right: 0;
	font: 9pt/100% Arial, Helvetica, sans-serif;
	color: #777;
	text-shadow: 1px 1px 0px #fff;
	text-overflow: ellipsis;
	white-space: nowrap;
	-moz-border-radius: 5px 0px 0px 5px;
	-webkit-border-radius: 5px 0px 0px 5px;
	border-radius: 5px 0px 0px 5px;
	background: #f5f5f5;
	background: -moz-linear-gradient(top, #fafafa 0%, #eee 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #fafafa),
		color-stop(100%, #f5f5f5));
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#fafafa',
		endColorstr='#f5f5f5', GradientType=0);
	border-color: #ccc;
	-moz-box-shadow: 0px 0px 1px #fff inset;
	-webkit-box-shadow: 0px 0px 1px #fff inset;
	box-shadow: 0px 0px 1px #fff inset;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}

.button {
	float: left;
	height: 32px;
	display: inline-block;
	outline: 0 none;
	padding: 8px 12px;
	margin: 0;
	cursor: pointer;
	border: 1px solid;
	font: bold 9pt/100% Arial, Helvetica, sans-serif;
	-moz-border-radius: 0px 5px 5px 0px;
	-webkit-border-radius: 0px 5px 5px 0px;
	border-radius: 0px 5px 5px 0px;
	-moz-box-shadow: 0px 0px 1px #fff inset;
	-webkit-box-shadow: 0px 0px 1px #fff inset;
	box-shadow: 0px 0px 1px #fff inset;
}

.uploader input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	border: 0;
	padding: 0;
	margin: 0;
	height: 30px;
	cursor: pointer;
	filter: alpha(opacity = 0);
	-moz-opacity: 0;
	-khtml-opacity: 0;
	opacity: 0;
}

input[type=button]::-moz-focus-inner {
	padding: 0;
	border: 0 none;
	-moz-box-sizing: content-box;
}

input[type=button]::-webkit-focus-inner {
	padding: 0;
	border: 0 none;
	-webkit-box-sizing: content-box;
}

input[type=text]::-moz-focus-inner {
	padding: 0;
	border: 0 none;
	-moz-box-sizing: content-box;
}

input[type=text]::-webkit-focus-inner {
	padding: 0;
	border: 0 none;
	-webkit-box-sizing: content-box;
}
/* White Color Scheme ------------------------ */
.white .button {
	color: #555;
	text-shadow: 1px 1px 0px #fff;
	background: #ddd;
	background: -moz-linear-gradient(top, #eeeeee 0%, #dddddd 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #eeeeee),
		color-stop(100%, #dddddd));
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#eeeeee',
		endColorstr='#dddddd', GradientType=0);
	border-color: #ccc;
}

.white:hover .button {
	background: #eee;
	background: -moz-linear-gradient(top, #dddddd 0%, #eeeeee 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #dddddd),
		color-stop(100%, #eeeeee));
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#dddddd',
		endColorstr='#eeeeee', GradientType=0);
}
</style>
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
							<form class="form-horizontal m-t" id="signupForm" action="add.do" method="post" enctype="multipart/form-data">
								<div class="form-group">
									<label class="col-sm-3 control-label">用户名：</label>
									<div class="col-sm-6">
										<input name="username" class="form-control" type="text">
										<span class="help-block m-b-none"></span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">密码：</label>
									<div class="col-sm-6">
										<input name="password" class="form-control"
											type="password" aria-required="true" aria-invalid="false"
											class="valid">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">确认密码：</label>
									<div class="col-sm-6">
										<input class="form-control"
											type="password" aria-required="true" aria-invalid="false"
											class="valid">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">手机：</label>
									<div class="col-sm-6">
										<input name="mobile" class="form-control" type="text" aria-required="true" aria-invalid="false"
											class="valid">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">性别：</label>
									<div class="col-sm-2">
										<div class="radio">
											<label> <input type="radio" name="sex" value="男" checked="checked">男
											</label>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="radio">
											<label> <input type="radio" name="sex" value="女">女
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">住址：</label>
									<div class="col-sm-3">
										<select class="form-control m-b" name = "province" id = "provinceid" onchange="showcity();">
											<option>选择省市</option>
											<c:forEach items="${province }" var="pro">
												<option value="${pro.provinceid }">${pro.name }</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-sm-5" id="city">
									
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">岗位：</label>
									<div class="col-sm-3">
										<select class="form-control m-b"  name = "positionid">
											<option value="待分配">待分配</option>
											<c:forEach items="${position }" var="pos">
												<option value="${pos.id }">${pos.pname }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">所属仓库：</label>
									<div class="col-sm-3">
										<select class="form-control m-b"  name = "warehouseid">
											<option value="待分配">待分配</option>
											<c:forEach items="${warehouseList }" var="warehouse">
												<option value="${warehouse.whid }">${warehouse.whiname }</option>
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
												type="file" name="file" size="30"
												accept="image/*">
										</div>
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
		/* 文件选择框  start */
		$(function() {

			$("input[type=file]").change(
					function() {
						$(this).parents(".uploader").find(".filename").val(
								$(this).val());
					});

			$("input[type=file]").each(
					function() {
						if ($(this).val() == "") {
							$(this).parents(".uploader").find(".filename").val(
									"请选择文件...");
						}
					});

		});
		/* 文件选择框  end*/
		function showcity() {
			
			var provinceid  = $("#provinceid").val();
			var str="<select id='city' class='form-control m-b' name='city' ><option value='0'>请选择省份</option>";
			
			
			$.post("city.do",{provinceid:provinceid},function(result){
				var list = result.citys;
				$.each(list,function(index,city){
					str+="<option value="+city.cityid+">"+city.name+"</option>";
				});
				str+="</select>";
				$("#city").html(str);
			},"json");
		}
		
	</script>
</html>