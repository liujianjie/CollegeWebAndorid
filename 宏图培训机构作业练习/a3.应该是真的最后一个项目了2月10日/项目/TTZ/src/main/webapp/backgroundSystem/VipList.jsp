<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
	href="${pageContext.request.contextPath}/backgroundSystem/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/plugins/footable/footable.core.css"
	rel="stylesheet">

<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/backgroundSystem/css/style.min.css?v=3.2.0"
	rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">

		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>vip团管理列表</h5>
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

						<table class="footable table table-stripped toggle-arrow-tiny"
							data-page-size="8">
							<thead>
								<tr>
									<th data-toggle="true">序号</th>
									<th>标题</th>
									<th>满标额度</th>
									<th>VIp标关闭时间</th>
									<th>起投金额</th>
									<th>年利率</th>
									<th>状态</th>
									<th data-hide="all">说明</th>
									<th data-hide="all">日期</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${vip }" var="vip" varStatus="index">
									<tr>
										<td>${index.index+1 }</td>
										<td>${vip.borrow_bt }</td>
										<td>${vip.b_money}</td>
										<td><fmt:formatDate value="${vip.yx_time }"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td>${vip.tb_minmoney }</td>
										<td><span class="pie">${vip.rate }</span></td>
										<td><c:choose>
												<c:when test="${vip.statu==11 }">未开启</c:when>
												<c:when test="${vip.statu==10 }">已开启</c:when>
											</c:choose></td>
										<td>${vip.borrow_sm}</td>
										<td><fmt:formatDate value="${vip.borrow_time }"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td><c:choose>
												<c:when test="${vip.statu==11 }">
													<a
														href="<%=path%>/Borrow/updateVipBorrowmoney.action?b_id=${vip.b_id}&statu=10">
														开启 </a>
												</c:when>
											</c:choose></td>
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
	<!-- 全局js -->
	<script
		src="${pageContext.request.contextPath}/backgroundSystem/js/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/backgroundSystem/js/bootstrap.min.js?v=3.4.0"></script>
	<script
		src="${pageContext.request.contextPath}/backgroundSystem/js/plugins/footable/footable.all.min.js"></script>

	<!-- 自定义js -->
	<script
		src="${pageContext.request.contextPath}/backgroundSystem/js/content.min.js?v=1.0.0"></script>
	<script>
		$(document).ready(function() {
	
			$('.footable').footable();
			$('.footable2').footable();
	
		});
	</script>

	<script type="text/javascript"
		src="../../../tajs.qq.com/stats@sId=9051096.jsp" charset="UTF-8"></script>
	<!--统计代码，可删除-->

</body>

</html>