<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - FooTable</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

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
							<h5>期限设置</h5>
							<div class="ibox-tools">
								<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
								</a> <a class="close-link"> <i class="fa fa-times"></i>
								</a>
							</div>
						</div>
						<div class="ibox-content">
							<div class="col-sm-4">
								<input type="text" class="form-control input-sm m-b-xs"
									id="filter" placeholder="搜索表格...">
							</div>
<!-- 							<div class="col-sm-2"> -->
<%-- 								<a href="<%=path%>/FundraisingDeadlinelist.jsp#add" --%>
<!-- 									data-toggle="modal" class="btn btn-primary ">设置新的投资期限</a> -->
<!-- 							</div> -->
							<table class="footable table table-stripped" data-page-size="8"
								data-filter=#filter>
								<thead>
									<tr>
										<th width="20%">序号</th>
										<th width="30%">借款期限</th>
										<th width="30%">筹款期限(月)</th>
										<th width="30%">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${flist}" var="li" varStatus="index">
										<tr>
											<td>${index.index+1 }</td>
											<td>${li.jiekuantime }</td>
											<td>${li.choukuantime }</td>
											<td><a
												onclick="fz('${li.fid}','${li.jiekuantime}','${li.choukuantime}');"
												href="<%=path%>/FundraisingDeadlinelist.jsp#alert"
												data-toggle="modal"><i class="fa fa-check text-navy"></i>修改</a>
												<!-- 												<a --> <%-- 												href="${pageContext.request.contextPath}/delFun.action?fid=${li.fid }"><i --%>
												<!-- 													class="fa fa-check text-navy"></i>删除</a> -->

											</td>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot>
									<tr>
										<td colspan="5">
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


	<!-- 修改弹出框 -->
	<div id="alert" class="modal fade" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改期限</h4>
				</div>
				<div class="modal-body">
					<!-- 自动增长 -->
					<form id="updform"
						action="${pageContext.request.contextPath}/updFun.action"
						method="post" enctype="multipart/form-data"
						class="form-horizontal m-t">
						<input type="hidden" id="fid" name="fid">
						<div class="form-group">
							<label class="col-sm-4 control-label">借款期限：</label>
							<div class="col-sm-6">
								<input type="text" name="jiekuantime" id="jiekuantime"
									class="form-control" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">筹款期限：</label>
							<div class="col-sm-6">
								<input type="text" name="choukuantime" id="choukuantime"
									class="form-control">
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



	<!-- 添加弹出框 -->
	<div id="add" class="modal fade" aria-hidden="false">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加期限</h4>
				</div>
				<div class="modal-body">
					<!-- 自动增长 -->
					<form id="addform"
						action="${pageContext.request.contextPath}/addFun.action"
						method="post" enctype="multipart/form-data"
						class="form-horizontal m-t">
						<div class="form-group">
							<label class="col-sm-4 control-label">借款期限：</label>
							<div class="col-sm-6">
								<input type="text" name="jiekuantime" id="jiekuantime"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label">筹款期限：</label>
							<div class="col-sm-6">
								<input type="text" name="choukuantime" id="choukuantime"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-8 col-sm-offset-8">
								<button class="btn btn-primary" type="submit"
									onclick="return addcheckzhi();">&nbsp;&nbsp;&nbsp;添加&nbsp;&nbsp;&nbsp;</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('.footable').footable();
			$('.footable2').footable();
		});
		function addcheckzhi() {
			var zhi = $("#choukuantime").val();
			if (!isNaN(zhi)) { //是
				return true;
			} else {
				alert("请输入正确的值");
				return false;
			}
			return true;
		}
		function fz(fid, jiekuantime, choukuantime) {
			$("#fid").val(fid);
			$("#jiekuantime").val(jiekuantime);
			$("#choukuantime").val(choukuantime);
		}
		$().ready(function() {
			$("#updform").validate({
				rules : {
					jiekuantime : "required",
					choukuantime : "required"
				},
				messages : {
					jiekuantime : "借款期限不能为空",
					choukuantime : "筹款期限不能为空"
				}
			});
			$("#addform").validate({
				rules : {
					jiekuantime : "required",
					choukuantime : "required"
				},
				messages : {
					jiekuantime : "借款期限不能为空",
					choukuantime : "筹款期限不能为空"
				}
			});
		});
		function alertcheckzhi() {
			var zhi = $("#choukuantime").val();
			if (!isNaN(zhi)) { //是
				return true;
			} else {
				alert("请输入正确的值");
				return false;
			}
			return true;
		}
	</script>

	<script type="text/javascript"
		src="../../../tajs.qq.com/stats@sId=9051096.jsp" charset="UTF-8"></script>
	<!--统计代码，可删除-->
</body>

</html>