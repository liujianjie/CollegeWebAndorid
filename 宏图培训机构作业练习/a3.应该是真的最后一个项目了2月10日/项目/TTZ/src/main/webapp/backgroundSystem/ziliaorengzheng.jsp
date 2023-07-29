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

</head>

<body class="gray-bg" onload="ziliaorengzheng();">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<br>
					选择证件类型：<select id="rtype" onchange="ziliaorengzheng();">
						<option value="身份证">身份证</option>
						<option value="工作证">工作证</option>
						<option value="收入证明">收入证明</option>
						<option value="居住证">居住证</option>
						<option value="信用证明">信用证明</option>
					</select>
					<br><br>
					<div class="ibox float-e-margins" >
						<div class="ibox-title">
							<h5>图片资料</h5>
							<input type="hidden" id="path"
								value="${pageContext.request.contextPath }"> <input
								type="hidden" id="tid" value="${userid }">

						</div>
						<div class="ibox-content" id="showdiv">
							<form class="form-horizontal m-t" id="signupForm"
								action="${pageContext.request.contextPath }/backuser/add.action"
								method="post" enctype="multipart/form-data">
								<div class="form-group">
									<label class="col-sm-3 control-label">用户名：</label>
									<div class="col-sm-6">
										<input name="b_username" class="form-control" type="text">
										<span class="help-block m-b-none"></span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">真实姓名：</label>
									<div class="col-sm-6">
										<input name="b_pwd" class="form-control" type="text"
											aria-required="true" aria-invalid="false" class="valid">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">证件种类：</label>
									<div class="col-sm-6">
										<input class="form-control" type="password"
											aria-required="true" aria-invalid="false" class="valid">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">上传时间：</label>
									<div class="col-sm-3">
										<input name="b_tel" class="form-control" type="text"
											aria-required="true" aria-invalid="false" class="valid">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">信用分：</label>
									<div class="col-sm-6">
										<input name="b_address" class="form-control" type="text"
											class="valid" value="0" >
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label">认证图片：</label>
									<div class="col-sm-6">
										<div class="uploader white"></div>
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
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/backgroundSystem/js/fileUpload.js"></script>
	<script type="text/javascript">
		function ziliaorengzheng() {
			var path = $("#path").val();
			var userid = $("#tid").val();
			var rtype = $("#rtype").val();
			var rimage = "null.jpg";
			var xyed = 0;
			
			$.post(path+"/rengzheng/ziliaorengzheng.action", {tids:userid,rtype:rtype}, function(data) {
			var ttzuser = data.ttzuser;
			var ren = data.ren;
			if(ren != null){
			rimage = ren.rimage;
			xyed = ren.xyed;
			}
				var str = "<form class='form-horizontal m-t' id='signupForm' >"
					+ "		<div class='form-group'>"
					+ "		<label class='col-sm-3 control-label'>用户名：</label>"
					+ "		<div class='col-sm-6'>"
					+ "		<input name='b_username' disabled='disabled' class='form-control' type='text' value='"+ttzuser.username+"'>"
					+ "	<span class='help-block m-b-none'></span>"
					+ "</div>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "	<label class='col-sm-3 control-label'>真实姓名：</label>"
					+ "	<div class='col-sm-6'>"
					+ "		<input name='b_pwd' disabled='disabled' class='form-control' type='text' aria-required='true' aria-invalid='false' class='valid' value='"+ttzuser.zsname+"'>"
					+ "	</div>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "	<label class='col-sm-3 control-label'>证件种类：</label>"
					+ "	<div class='col-sm-6'>"
					+ "		<input class='form-control' disabled='disabled' type='text' aria-required='true' aria-invalid='false' class='valid' value='"+rtype+"'>"
					+ "	</div>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "	<label class='col-sm-3 control-label'>认证图片：</label>"
					+ "	<div class='col-sm-6'>"
					+ "	<div class='uploader white'>"
					+ " <img src = '"+path+"/upload/"+rimage+"' style='width:220px;height:250px'></img> "
					+ "	</div>"
					+ "	</div>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "	<label class='col-sm-3 control-label'>信用分：</label>"
					+ "	<div class='col-sm-6'>"
					+ "		<input name='b_address' class='form-control' type='text' class='valid' value='"+xyed+"' id='xinyong'>"
					+ "	</div>"
					+ "</div>"
					+ "<div class='form-group'>"
					+ "	<div class='col-sm-5 col-sm-offset-5'>"
					+ "		<button class='btn btn-primary' type='button' onclick='yes("+ttzuser.userid+");'>&nbsp;&nbsp;&nbsp;审核通过&nbsp;&nbsp;&nbsp;</button>"
					+ "		<button class='btn btn-primary' type='button' onclick='no("+ttzuser.userid+");'>&nbsp;&nbsp;&nbsp;审核失败&nbsp;&nbsp;&nbsp;</button>"
					+ "	</div>"
					+ "</div>"
					+ "</form>";
	
				$("#showdiv").html(str);
			}, "json");
		}
		
		function yes(userid){
		var xinyong = $("#xinyong").val();
		var rtype = $("#rtype").val();
		var tid = $("#tid").val();
		var path = $("#path").val();
			$.post(path+"/rengzheng/shenghe.action",{userid:userid,rtype:rtype,xinyong:xinyong,tid:tid},function(data){
				location.href=path+"/rengzheng/selzilaio.action";
			},"json");
		}
		
		function no(userid){
		var xinyong = $("#xinyong").val();
		var rtype = $("#rtype").val();
		var path = $("#path").val();
			$.post(path+"/rengzheng/shenghe2.action",{userid:userid,rtype:rtype,xinyong:xinyong},function(data){
				location.href=path+"/rengzheng/selzilaio.action";
			},"json");
		}
	</script>
</body>

</html>