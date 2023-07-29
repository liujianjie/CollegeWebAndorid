<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>发布通知界面</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link href="css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
<link href="css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/plugins/summernote/summernote.css" rel="stylesheet">
<link href="css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
<link href="css/style.min.css?v=3.2.0" rel="stylesheet">

<style>
.droppable-active {
	background-color: #ffe !important;
}

.tools a {
	cursor: pointer;
	font-size: 80%;
}

.form-body .col-md-6, .form-body .col-md-12 {
	min-height: 400px;
}

.draggable {
	cursor: move;
}
</style>

</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js">
	
</script>
<body class="gray-bg">
	<div class="wrapper wrapper-content">

		<div class="row">
		<div class="col-sm-2"></div>
			<div class="col-sm-8">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>通知发布界面</h5>
					
					<div class="ibox-content">
						<div class="alert alert-info">请认真填写发布消息！！！！！</div>
						<form action="addmsg.do"   method="post" role="form" class="form-horizontal m-t">
							<div class="form-group draggable">
								<label class="col-sm-3 control-label">消息主题：</label>
								<div class="col-sm-9">
									<input type="text" name="msgtitle" class="form-control"
										placeholder="请输入消息主题">

								</div>
							</div>
							
							<div class="form-group draggable">
								<label class="col-sm-3 control-label">消息内容：</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="msgcon"
										placeholder="请输入消息内容">
								</div>
							</div>
							
							<div class="form-group draggable">
								<label class="col-sm-3 control-label">发布状态：</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="msgstatu"
								>
								</div>
							</div>
							
							<div class="form-group draggable">
								<label class="col-sm-3 control-label">查看对象：</label>
								<div class="col-sm-9">
									<select class="form-control" name="msgtopeople">
										<option>超级管理员</option>
										<option>所有人</option>
											<option>仓管</option>
									</select>
								</div>
							</div>

							<div class="form-group draggable">
								<label class="col-sm-3 control-label">发布时间：</label>
								<div class="col-sm-9">
									<input onclick="WdatePicker();" type="text" class="form-control" name="msgtime"
										 readonly="readonly"
										placeholder="请选择发布时间">
								</div>
							</div>
							
							<div class="form-group draggable">
								<label class="col-sm-3 control-label">发布人：</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" name="msgpeople">
								</div>
							</div>
								<div class="col-sm-12 col-sm-offset-3">
									<button class="btn btn-primary" type="submit">发布通知</button>
									<button class="btn btn-white" type="reset">重置</button>
								</div>
							</div>
						</form>
				</div>
			</div>
</html>