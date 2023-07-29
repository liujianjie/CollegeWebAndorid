<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - 项目</title>
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
<link
	href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css"
	rel="stylesheet">

</head>

<body class="gray-bg">

	<div class="wrapper wrapper-content animated fadeInUp">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-0">
				<button class="btn btn-primary btn-sm"
					onclick="location.href='javascript:history.go(-1);'">返回</button>
			</div>
		</div>

		<div class="row">
			<div class="col-sm-1 "></div>
			<div class="col-sm-7 ">
				<button class="btn btn-primary btn-sm"
					onclick="location.href='rackgoodall.do?whid=${whid}&currPage=1&v=whm'">查看仓库所以物品</button>
			</div>
			<div class="col-sm-1 ">
			<c:if test="${ pname == '超级管理员'}">
				<button class="btn btn-danger btn-sm demo4">删除此仓库</button>
			</c:if>
			</div>
			<div class="col-sm-1 ">
			<c:if test="${ pname == '超级管理员'}">
				<button class="btn btn-primary btn-sm"
					onclick="location.href='toupdwar.do?whid=${whid}&v=whm'">修改此仓库</button>
			</c:if>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">

				<div class="ibox">
					<div class="ibox-title">
						<h5>所有货架</h5>
						<div class="ibox-tools">
							<a href="toaddrack.do?whid=${whid }&v=whm"
								class="btn btn-primary btn-xs">创建新货架</a>
						</div>
					</div>
					<div class="ibox-content">
						<div class="project-list">

							<table class="table table-hover">
								<tbody>
									<c:forEach items="${list }" var="rack">
										<tr>
											<td class="project-status"><c:if
													test="${rack.statu == '0' }">
													<span class="label label-primary">使用中 </span>
												</c:if> <c:if test="${rack.statu == '1' }">
													<span class="label label-default">已停用 </span>
												</c:if></td>
											<td class="project-title"><a href="project_detail.jsp">${rack.rname }&nbsp;(${rack.type.tname })</a>
												<br /> <small>创建于 <fmt:formatDate
														value="${rack.rdate }" pattern="yyyy-MM-dd" />
											</small></td>
											<td class="project-completion"><small>已使用：${((rack.rsize-rack.rsurplus)/rack.rsize)*100 }%</small>
												<div class="progress progress-mini">
													<div
														style="width: ${((rack.rsize-rack.rsurplus)/rack.rsize)*100 }%;"
														class="progress-bar"></div>
												</div></td>

											<td class="project-actions"><a
												href="rackgoods.do?pid=${rack.rid }&v=whm"
												class="btn btn-white btn-sm"><i class="fa fa-folder"></i>
													查看货架物品</a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="col-sm-1"></div>
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

	<script
		src="${pageContext.request.contextPath}/js/plugins/sweetalert/sweetalert.min.js"></script>

	<script>
		$(document).ready(function() {
			$("#loading-example-btn").click(function() {
				btn = $(this);
				simpleLoad(btn, true);
				simpleLoad(btn, false)
			})

			$(".demo4").click(function() {
				swal({
					title : "您确定要删除这条信息吗",
					text : "删除后将无法恢复，请谨慎操作！",
					type : "warning",
					showCancelButton : true,
					confirmButtonColor : "#DD6B55",
					confirmButtonText : "是的，我要删除！",
					cancelButtonText : "让我再考虑一下…",
					closeOnConfirm : false,
					closeOnCancel : false
				}, function(a) {
					if (a) {

						swal("删除成功！", "您已经永久删除了这条信息。", "success")
						location.href = 'delwar.do?whid=${whid}&v=whm'
					} else {
						swal("已取消", "您取消了删除操作！", "error")
					}
				})
			})
		});
		function simpleLoad(a, b) {
			if (b) {
				a.children().addClass("fa-spin");
				a.contents().last().replaceWith(" Loading")
			} else {
				setTimeout(function() {
					a.children().removeClass("fa-spin");
					a.contents().last().replaceWith(" Refresh")
				}, 2000)
			}
		};
	</script>



</body>
</html>