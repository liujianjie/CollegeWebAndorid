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
						<h5>投资信息查询</h5>
						<form action="<%=path %>/touzhi.action">
							<select name="statu" style="margin-left: 30px;">
								<option value="">全部</option>
								<option value="0">投标中</option>
								<option value="1">收益中</option>
								<option value="2">已完成</option>
								<option value="3">回款中</option>
								<option value="4">已回款</option>
							</select>
							<input type="submit" value="查找"/>
						</form>
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
									<th data-toggle="true">投标人</th>
									<th>投标金额</th>
									<th>投标时间</th>
									<th>投标类型</th>
									<th>状态</th>
									<th>标的状态</th>
									<th>总利息</th>
									<th>总手续费</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${tr_list }" var="tr_list">
									<tr>
										<td>
											<c:forEach items="${user_list }" var="user_list">
												<c:if test="${tr_list.tender_name==user_list.userid }">
													${user_list.username }
												</c:if>
											</c:forEach>
										</td>
										<td>${tr_list.tender_money }</td>
										<td>
											<fmt:formatDate value="${tr_list.tender_time }"
												pattern="yyyy-MM-dd HH:mm:ss" />
										</td>
										<td>${tr_list.tender_type }</td>
										<td>
											<c:if test="${tr_list.tender_statu==0 }">投标中</c:if>
											<c:if test="${tr_list.tender_statu==1 }">收益中</c:if>
											<c:if test="${tr_list.tender_statu==2 }">已完成</c:if>
											<c:if test="${tr_list.tender_statu==3 }">回款中</c:if>
											<c:if test="${tr_list.tender_statu==4 }">已回款</c:if>
										</td>
										<td>${tr_list.sign_statu }</td>
										<td>${tr_list.tender_interest }</td>
										<td>${tr_list.tender_fee }</td>
									</tr>
								</c:forEach>

							</tbody>
							<tfoot>
								<tr>
									<td colspan="8">
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