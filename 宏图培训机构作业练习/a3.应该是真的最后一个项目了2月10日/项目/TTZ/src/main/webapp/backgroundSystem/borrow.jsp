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
						<h5>借款审核</h5>
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
									<th data-toggle="true">标题</th>
									<th>名字</th>
									<th>状态</th>
									<th>借款金额</th>
									<th data-hide="all">借款用途</th>
									<th data-hide="all">借款类型</th>
									<th data-hide="all">担保物</th>
									<th data-hide="all">价值</th>
									<th data-hide="all">还款方式</th>
									<th data-hide="all">日期</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${allborrow }" var="bor">
									<tr>
										<td>${bor.borrow_bt }</td>
										<td>${bor.tname }</td>
										<td><c:choose>
												<c:when test="${bor.statu==2 }">
													<font color="#0bfb16">通过</font>
												</c:when>
												<c:when test="${bor.statu==1 }">
													<font color="#777888">审核中</font>
												</c:when>
												<c:when test="${bor.statu==0 }">
													<font color="#f93952">不通过</font>
												</c:when>
											</c:choose></td>
										<td>${bor.b_money }</td>
										<td>${bor.borrow_yt }</td>
										<td><span class="pie">${bor.borrow_type }</span></td>

										<c:choose>
											<c:when test="${bor.borrow_type=='房产抵押' }">
												<td>房屋数量: ${bor.dbw }</td>
												<td>${bor.dbx }</td>
											</c:when>
											<c:when test="${bor.borrow_type=='车辆抵押' }">
												<td>车辆型号: ${bor.dbw }</td>
												<td>${bor.dbx }</td>
											</c:when>
											<c:when test="${bor.borrow_type=='信用贷款' }">
												<td>每月收入:</td>
												<td>工作单位:</td>
											</c:when>
											<c:when test="${bor.borrow_type=='零首付车贷' }">
												<td>每月收入:</td>
												<td>工作单位:</td>
											</c:when>
										</c:choose>
										<td>${bor.repayment }</td>
										<td><fmt:formatDate value="${bor.borrow_time }"
												pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td><a
											href="${pageContext.request.contextPath}/rengzheng/toziliaorengzheng.action?tid=${bor.ttz_tid}"><i></i>查看认证</a>&nbsp;&nbsp;
											<c:choose>
												<c:when test="${bor.statu==1 }">
													<a
														href="<%=path %>/Borrow/updBorrowstatu.action?statu=2&id=${bor.b_id}"
														onclick="return confirm('您确定要通过吗？');"><i
														class="fa fa-check text-navy"></i> 通过</a>
	                                   				 	&nbsp;&nbsp;
	                                  			 	<a
														href="<%=path %>/Borrow/updBorrowstatu.action?statu=0&id=${bor.b_id}"
														onclick="return confirm('您确定不通过吗？');"> <font
														color="red"><i class="fa fa-check fa-times"></i>
															不通过</font></a>
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