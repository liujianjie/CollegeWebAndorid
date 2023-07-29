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
						<h5>借贷信息查询</h5>
						<form action="<%=path%>/borrow_list.action">
							<select name="status" style="margin-left: 30px;">
								<option value="">全部</option>
								<option value="0">审核失败</option>
								<option value="1">审核中</option>
								<option value="2">发布中</option>
								<option value="3">满标</option>
								<option value="4">还款中</option>
								<option value="5">投标结束未满标</option>
								<option value="6">已还款</option>
								<option value="10">vip标已开启</option>
								<option value="11">vip标已关闭</option>
								<option value="12">债权转让中</option>
								<option value="13">债权转让完成</option>
							</select> <input type="submit" value="查找" />
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
							data-page-size="10">
							<thead>
								<tr>
									<th>真实姓名</th>
									<th>借款金额</th>
									<th>应还款总额</th>
									<th>年利率</th>
									<th>还款方式</th>
									<th>有效时间</th>
									<th>借贷期限</th>
									<th>状态</th>
									<th>借款时间</th>
									<th>借贷用途</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${borr_list }" var="borr_list">
									<tr>
										<td>${borr_list.tname }</td>
										<td>${borr_list.b_money }</td>
										<td>${borr_list.should_money }</td>
										<td>${borr_list.rate }</td>
										<td>${borr_list.repayment }</td>
										<td><fmt:formatDate value="${borr_list.yx_time }"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td>${borr_list.borrowqx }</td>
										<td><c:if test="${borr_list.statu==0 }">审核失败</c:if> <c:if
												test="${borr_list.statu==1 }">审核中</c:if> <c:if
												test="${borr_list.statu==2 }">发布中</c:if> <c:if
												test="${borr_list.statu==3 }">满标</c:if> <c:if
												test="${borr_list.statu==4 }">还款中</c:if> <c:if
												test="${borr_list.statu==5 }">投标结束未满标</c:if> <c:if
												test="${borr_list.statu==6 }">已还款</c:if> <c:if
												test="${borr_list.statu==10 }">vip标已开启</c:if> <c:if
												test="${borr_list.statu==11 }">vip标已关闭</c:if> <c:if
												test="${borr_list.statu==12 }">债权转让中</c:if> <c:if
												test="${borr_list.statu==13 }">债权转让完成</c:if></td>
										<td><fmt:formatDate value="${borr_list.borrow_time }"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td>${borr_list.borrow_yt }</td>
										<td><c:if test="${borr_list.statu!=1 }">
												<a
													href="<%=path %>/Borrow/backSelTZ.action?id=${borr_list.b_id}">查看投资</a>
											</c:if></td>
									</tr>
								</c:forEach>

							</tbody>
							<tfoot>
								<tr>
									<td colspan="10">
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