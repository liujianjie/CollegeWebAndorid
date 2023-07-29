<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>H+ 后台主题UI框架 - 基础表格</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">
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
<script
	src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>

</head>

<body class="gray-bg">
	<!-- 还有时间要选择 -->
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>新建出库计划单</h5>
						</div>
						<div class="ibox-content">
							<!-- 日期注意点 -->
							<form id="signupForm"
								action="${pageContext.request.contextPath}/outstorage/addout.do"
								method="post" enctype="multipart/form-data"
								class="form-horizontal m-t">
								<!-- 运货单 -->
								<input type="hidden" name="ptid" value="${put.ptid }">
								<div class="form-group" id="data_2">
									<label class="col-sm-3 control-label">出库时间：</label>
									<div class="col-sm-3">
										<div class="input-group date">
											<span class="input-group-addon"><i
												class="fa fa-calendar"></i></span> <input type="text" id="dates"
												name="date" class="form-control" onclick="WdatePicker();">

										</div>
										<span id="dates2"></span>
									</div>
									<div class="col-sm-3">
										<div class="input-group clockpicker" data-autoclose="true">
											<input type="text" id="time" name="time" class="form-control"
												onclick="WdatePicker({lang:'zh-cn',dateFmt:'HH:mm:ss'});">
											<span class="input-group-addon"> <span
												class="fa fa-clock-o"></span>
											</span>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label">货物名称：</label>
									<div class="col-sm-6">
										<input type="text" name="productname" id="productname"
											value="${put.ins.productname}" disabled="disabled" class="form-control">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">仓库名称：</label>
									<div class="col-sm-6">
										<input type="text" name="productname" id="productname"
											value="${put.war.whiname}" disabled="disabled" class="form-control">
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label">是否为越库：</label>
									<div class="col-sm-2">
										<div class="radio">
											<label> <input type="radio" id="instate"
												name="yueku" value="0">是
											</label>
										</div>
									</div>
									<div class="col-sm-2">
										<div class="radio">
											<label> <input type="radio" checked="checked"
												id="instate" name="yueku" value="1">否
											</label>
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

	<!-- 点击是否全部到货 -->
	<script type="text/javascript">
		function yes() {
			var a = $("#partflag:checked").val();
			if (a == 0) {//没有全部
				$("#shortqty").show();
			} else if (a == 1) {//全部到货
				$("#shortqty").hide();
			}
		}
	</script>

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
					dates : "required",
					time  : "required",
					productname : "required",
					sku	: "required",
					whid : "required",
					purchaseqty : "required",
					shortqty : "required"
				},
				messages : {
					dates : " ",
					time  : " ",
					productname : a + "请填写物品名称",
					sku	: a + "请选择商品类型",
					whid : a + "请选择仓库",
					purchaseqty : a + "请填写商品数量",
					shortqty : a + "请填写缺货数量"
				}
			});
		});
	</script>


</body>
</html>