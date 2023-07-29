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
	href="${pageContext.request.contextPath}/backgroundSystem/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/backgroundSystem/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/style.min.css?v=3.2.0"
	rel="stylesheet">

<!-- 文件 -->
	<link href="${pageContext.request.contextPath}/backgroundSystem/css/fileUpload.css?v=3.2.0" rel="stylesheet">
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
							<form class="form-horizontal m-t" id="signupForm" action="alert.action" method="post" enctype="multipart/form-data">
								<input type="hidden" name="b_id" value = "${user.b_id }">
								<div class="form-group">
									<label class="col-sm-3 control-label">用户名：</label>
									<div class="col-sm-6">
										<input name="b_username" id="b_username" class="form-control" type="text" value="${user.b_username}">
										<span class="help-block m-b-none"></span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">密码：</label>
									<div class="col-sm-6">
										<input  name="b_pwd" id="b_pwd" class="form-control" value="${user.b_pwd}"
											type="text" aria-required="true" aria-invalid="false"
											class="valid">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">手机：</label>
									<div class="col-sm-3">
										<input name="b_tel" id="b_tel" class="form-control" type="text" aria-required="true" aria-invalid="false"
											class="valid" value="${user.b_tel}">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">性别：</label>
									<div class="col-sm-2">
										<div class="radio">
											<label> <input type="radio" name="b_sex" value="男" ${user.b_sex== '男'?'checked':''}>男
											</label>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="radio">
											<label> <input type="radio" name="b_sex" value="女" ${user.b_sex== '女'?'checked':''}>女
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">住址：</label>
									<div class="col-sm-6">
										<input name="b_address" class="form-control" type="text" aria-required="true" aria-invalid="false"
											class="valid" value="${user.b_address }">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">岗位：</label>
									<div class="col-sm-3">
										<select class="form-control m-b"  name = "b_positionid">
											<option>待分配</option>
											<c:forEach items="${post }" var="pos">
												<option value="${pos.p_id }" ${user.b_positionid==pos.p_id?'selected':'' }>${pos.p_name }</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">头像：</label>
									<div class="col-sm-6">
										<a data-toggle="modal" href="Useralert.jsp#updateFace">
											<img alt="image" id="touxiang" class="img-circle m-t-xs img-responsive" title="点击可换头像" 
											src="${pageContext.request.contextPath }/${user.b_touxiang }">
										</a>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-8 col-sm-offset-8">
										<button class="btn btn-primary" type="submit" onclick="return checks();">&nbsp;&nbsp;&nbsp;修改&nbsp;&nbsp;&nbsp;</button>
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
		function checks(){
			var b_username = $("#b_username").val();
			var b_tel = $("#b_tel").val();
			if(b_username.length>24){
				alert("用户名称字符过长");
				return false;		
			}else if(b_tel.length>11){
				alert("手机电话格式错误");
				return false;		
			}
			return true;
		}
	</script>
	
	<!-- 弹出form表单 开始 -->
	<div id="updateFace" class="modal fade" aria-hidden="false">
        <div class="modal-dialog">
            <div class="modal-content">
            	<div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">选择照片</h4>
                </div>
                <div class="modal-body">
                	<!-- 自动增长 -->
                	<form id="form2" class="form-horizontal m-t" action="${pageContext.request.contextPath }/backuser/updateFace.action"
                		method="post" enctype="multipart/form-data">
						<input type="hidden" id="id" name="id" value = "${user.b_id }">
						<div class="form-group"> 
							<div class="col-sm-7 control-label">
								<div class="uploader white">
									<input type="text" class="filename" readonly="readonly">
									<input type="button" class="button" value="上传..."> <input
											type="file" name="files" id="files" size="30"
											accept="image/*">
								</div>
							</div>
							<div class="col-sm-2 control-label">
                    			<button id="sbt"  class="btn btn-primary" type="submit">修改</button>
                			</div>
						</div>
					</form>
				</div>
				
            </div>
        </div>
    </div>

	<!-- 全局js -->
	<script src="${pageContext.request.contextPath}/backgroundSystem/js/jquery-2.1.1.min.js"></script>
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/backgroundSystem/js/fileUpload.js"></script>
	
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
			$("#commentForm").validate();
			var a = "<i class='fa fa-times-circle'></i> ";

			$("#signupForm").validate({
				rules : {
					b_username : "required",
					b_tel	: "required",
					b_pwd   : "required",
					b_address : "required",
					b_positionid : "required"
				},
				messages : {
					b_username : "用户名不能为空",
					b_tel	: a + "电话不能为空",
					b_pwd	: a+ "密码不能为空",
					b_address : a + "地址不能为空",
					b_positionid : a + "请选择岗位"
				}
			});
			
			$("#form2").validate({
				rules : {
					files : "required"
				},
				messages : {
					files : "头像文件不能为空"
				}
			});
		});
	</script>
	
	
</body>
	
</html>