<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>费率列表</title>
<meta name="keywords" content="">
<meta name="description">

<link
	href="${pageContext.request.contextPath }/backgroundSystem/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/backgroundSystem/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<!-- Sweet Alert -->
<link
	href="${pageContext.request.contextPath }/backgroundSystem/css/plugins/sweetalert/sweetalert.css"
	rel="stylesheet">

<link
	href="${pageContext.request.contextPath }/backgroundSystem/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/backgroundSystem/css/style.min.css?v=3.2.0"
	rel="stylesheet">

<!-- check -->
<link
	href="${pageContext.request.contextPath }/backgroundSystem/css/plugins/iCheck/custom.css"
	rel="stylesheet">
<!-- 全局js -->
<script
	src="${pageContext.request.contextPath }/backgroundSystem/js/jquery-2.1.1.min.js"></script>
<script
	src="${pageContext.request.contextPath }/backgroundSystem/js/bootstrap.min.js?v=3.4.0"></script>

<!-- 自定义js -->
<script
	src="${pageContext.request.contextPath }/backgroundSystem/js/content.min.js?v=1.0.0"></script>

<!-- Sweet alert -->
<script
	src="${pageContext.request.contextPath }/backgroundSystem/js/plugins/sweetalert/sweetalert.min.js"></script>

<!-- iCheck -->
<script
	src="${pageContext.request.contextPath }/backgroundSystem/js/plugins/iCheck/icheck.min.js"></script>
<!-- jQuery Validation plugin javascriptform提示-->
<script
	src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/validate/jquery.validate.min.js"></script>
<script
	src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/validate/messages_zh.min.js"></script>
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-10">
				<div class="col-sm-2"></div>
				<div class="col-sm-10">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>费率设置</h5>
							<div class="ibox-tools">
								<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
								</a> <a class="dropdown-toggle" data-toggle="dropdown"
									href="table_foo_table.jsp#"> <i class="fa fa-wrench"></i>
								</a>
								<ul class="dropdown-menu dropdown-user">
									<li><a href="table_foo_table.jsp#">选项 01</a></li>
									<li><a href="table_foo_table.jsp#">选项 02</a></li>
								</ul>
								<a class="close-link"> <i class="fa fa-times"></i>
								</a>
							</div>
						</div>
						<div class="ibox-content">
							<div class="form-group">
								<div class="col-sm-4">
									<input type="text" class="form-control input-sm m-b-xs"
										id="filter" placeholder="搜索表格...">
								</div>
								<!-- 								<div class="col-sm-2"> -->
								<!-- 									<a href="rateslist.jsp#add" data-toggle="modal" -->
								<!-- 										class="btn btn-primary ">新增费率</a> -->
								<!-- 								</div> -->
							</div>
							<table class="footable table table-stripped" data-page-size="8"
								data-filter=#filter>
								<thead>
									<tr>
										<th width="10%">序号</th>
										<th width="30%">费率名称</th>
										<th width="20%">条件</th>
										<th width="20%">费率</th>
										<th width="30%">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${rlist }" var="rate" varStatus="i">
										<tr>
											<td>${i.index+1 }</td>
											<td>${rate.r_name }</td>
											<td>${rate.r_tiao }</td>
											<td>${rate.r_zhi }</td>
											<td><input id="${i.index+1 }i" type="hidden"
												value="${rate.r_id }"> <a id="${i.index+1 }"
												onclick="selfuzhi(this);" data-toggle="modal"
												href="rateslist.jsp#alert"><i
													class="fa fa-check text-navy"></i> 编辑</a> <!-- 													<a -->
												<%-- 												href="${pageContext.request.contextPath}/rates/del.action?id=${rate.r_id}" --%>
												<!-- 												onclick="return confirm('你确定删除吗？');"><i -->
												<!-- 													class="fa fa-check text-navy"></i> 删除</a> -->
											</td>
										</tr>

									</c:forEach>

								</tbody>
								<tfoot>
									<tr>
										<td colspan="4">
											<ul class="pagination pull-right"></ul>
										</td>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 弹出框 -->
	<div id="add" class="modal fade" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">新增费率</h4>
				</div>
				<div class="modal-body">
					<!-- 自动增长 -->
					<form id="addform"
						action="${pageContext.request.contextPath}/rates/add.action"
						method="post" enctype="multipart/form-data"
						class="form-horizontal m-t">
						<div class="form-group">
							<label class="col-sm-4 control-label">填写名称：</label>
							<div class="col-sm-6">
								<input type="text" name="r_name" id="r_name"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">填写条件：</label>
							<div class="col-sm-6">
								<input type="text" name="r_tiao" id="r_tiao"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">填写费率：</label>
							<div class="col-sm-6">
								<input type="text" name="r_zhi" id="r_zhi" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-8 col-sm-offset-8">
								<button class="btn btn-primary" type="submit"
									onclick="return addcheckzhi();">&nbsp;&nbsp;&nbsp;提交&nbsp;&nbsp;&nbsp;</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 弹出框 -->
	<div id="alert" class="modal fade" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改费率</h4>
				</div>
				<div class="modal-body">
					<!-- 自动增长 -->
					<form id="updform"
						action="${pageContext.request.contextPath}/rates/alert.action"
						method="post" enctype="multipart/form-data"
						class="form-horizontal m-t">
						<input type="hidden" id="r_id" name="r_id">
						<div class="form-group">
							<label class="col-sm-4 control-label">填写名称：</label>
							<div class="col-sm-6">
								<input type="text" name="r_name" id="r_name2"
									class="form-control" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">填写条件：</label>
							<div class="col-sm-6">
								<input type="text" name="r_tiao" id="r_tiao2"
									class="form-control" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">填写费率：</label>
							<div class="col-sm-6">
								<input type="text" name="r_zhi" id="r_zhi2" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-8 col-sm-offset-8">
								<button class="btn btn-primary" type="submit"
									onclick="return alertcheckzhi();">&nbsp;&nbsp;&nbsp;修改&nbsp;&nbsp;&nbsp;</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	
		function addcheckzhi() {
			var zhi = $("#r_zhi").val();
			if (!isNaN(zhi)) { //是
				return true;
			} else {
				alert("请输入正确的值");
				return false;
			}
			return true;
		}
		function alertcheckzhi() {
			var zhi = $("#r_zhi2").val();
			if (!isNaN(zhi)) { //是
				return true;
			} else {
				alert("请输入正确的值");
				return false;
			}
			return true;
		}
		function selfuzhi(a) {
			var ins = a.id + "i";
			var vl = $("#" + ins).val();
	
			$.post("${pageContext.request.contextPath }/rates/toalert.action", {
				id : vl
			}, function(results) {
				var i = results.result;
				if (i == 1) { //成功
					var ra = results.rates;
					$("#r_id").val(ra.r_id);
					$("#r_name2").val(ra.r_name);
					$("#r_zhi2").val(ra.r_zhi);
					$("#r_tiao2").val(ra.r_tiao);
				}
				if (i == 0) { //失败
					alert("请检查网络连接");
				}
			}, "json");
		}
	</script>

	<!-- 多选宽 -->
	<script>
		$(document).ready(function() {
			$('.i-checks').iCheck({
				checkboxClass : 'icheckbox_square-green',
				radioClass : 'iradio_square-green',
			});
		});
	</script>
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
	
			$("#addform").validate({
				rules : {
					r_name : "required",
					r_zhi : "required"
				},
				messages : {
					r_name : "费率名称不能为空",
					r_zhi : "费率值不能为空"
				}
			});
			$("#updform").validate({
				rules : {
					r_name : "required",
					r_zhi : "required"
				},
				messages : {
					r_name : "费率名称不能为空",
					r_zhi : "费率值不能为空"
				}
			});
		});
	</script>


</body>

</html>