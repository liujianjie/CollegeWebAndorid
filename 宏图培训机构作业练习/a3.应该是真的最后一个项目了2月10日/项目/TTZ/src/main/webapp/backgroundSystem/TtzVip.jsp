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
	href="${pageContext.request.contextPath}/backgroundSystem/css/plugins/iCheck/custom.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/plugins/summernote/summernote.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/plugins/summernote/summernote-bs3.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/style.min.css?v=3.2.0"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/foregroundSystem/css/style2.css">
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>发布vip团</h5>
						</div>
						<div class="ibox-content">
							<form class="form-horizontal m-t" id="demoform1"
								action="${pageContext.request.contextPath }/Borrow/addVIPTuan.action"
								method="post" enctype="multipart/form-data">
								<div class="form-group">
									<label class="col-sm-3 control-label">标题：</label>
									<div class="col-sm-6">
										<input name="borrow_bt" class="form-control" type="text"
											placeholder="请输入标题" datatype="*" errormsg="请输入标题"> <span
											class="help-block m-b-none"></span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">说明：</label>
									<div class="mail-text h-200"
										style="width: 550px;margin-left: 100px;">
										<div class="summernote"></div>
										<div class="clearfix" id="texts"></div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">满标额度：</label>
									<div class="col-sm-6">
										<input name="b_money" class="form-control" type="text"
											aria-required="true" aria-invalid="false" class="valid"
											placeholder="请输入满标额度" datatype="n" errormsg="请输入数字">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">VIp标关闭时间：</label>
									<div class="col-sm-6">
										<input class="form-control" name="yx_time" type="text"
											aria-required="true" aria-invalid="false" class="valid"
											onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"
											placeholder="请输入VIp标关闭时间" datatype="*" errormsg="请输入VIp标关闭时间">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">起投金额：</label>
									<div class="col-sm-6">
										<input name="tb_minmoney" class="form-control" type="text"
											class="valid" placeholder="请输入起投金额" datatype="n1-10"
											errormsg="请输入1-10位数字">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">年利率(例:0.12)：</label>
									<div class="col-sm-6">
										<input name="rate" class="form-control" type="text"
											class="valid" placeholder="请输入年利率" datatype="/0.\d{0,3}$/"
											errormsg="请输入数字">
									</div>
								</div>
								<input name="borrow_sm" id="borrow_sm" class="form-control"
									type="hidden">
								<div class="form-group">
									<div class="mail-body text-right tooltip-demo">
										<a onclick="sends();" class="btn btn-sm btn-primary"
											data-toggle="tooltip" data-placement="top" title="Send"><i
											class="fa fa-reply"></i> 公布</a> <a
											href="javascript:history.go(-1)" class="btn btn-white btn-sm"
											data-toggle="tooltip" data-placement="top"
											title="Discard email"><i class="fa fa-times"></i> 取消</a>
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
	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/iCheck/icheck.min.js"></script>
	<!-- SUMMERNOTE -->
	<script
		src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/summernote/summernote.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/summernote/summernote-zh-CN.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/foregroundSystem/script/Validform_v5.3.2_min.js"></script>
	<script>
		$(document).ready(function() {
			$(".i-checks").iCheck({
				checkboxClass : "icheckbox_square-green",
				radioClass : "iradio_square-green",
			});$(".summernote").summernote({
				lang : "zh-CN"
			})
			//表单验证功能
			$("#demoform1").Validform({
				tiptype : 2
			});
		});
		var edit = function() {
			$(".click2edit").summernote({
				focus : true
			})
		};
		var save = function() {
			var a = $(".click2edit").code();
			$(".click2edit").destroy()
		};
	
		function sends() {
			var s = $(".note-editable").html();
			$("#borrow_sm").val(s);
			$("#demoform1").submit();
		}
	</script>

	<script
		type="${pageContext.request.contextPath}/backgroundSystem/text/javascript"
		src="../../../tajs.qq.com/stats@sId=9051096.jsp" charset="UTF-8"></script>

	<!-- layerDate plugin javascript -->
	<script
		src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/layer/laydate/laydate.js"></script>
	<script>
		laydate({
			elem : "#hello",
			event : "focus"
		});
		var start = {
			elem : "#start",
			format : "YYYY/MM/DD hh:mm:ss",
			min : laydate.now(),
			max : "2099-06-16 23:59:59",
			istime : true,
			istoday : false,
			choose : function(a) {
				end.min = a;
				end.start = a
			}
		};
		var end = {
			elem : "#end",
			format : "YYYY/MM/DD hh:mm:ss",
			min : laydate.now(),
			max : "2099-06-16 23:59:59",
			istime : true,
			istoday : false,
			choose : function(a) {
				start.max = a
			}
		};
		laydate(start);laydate(end);
	</script>


</body>

</html>