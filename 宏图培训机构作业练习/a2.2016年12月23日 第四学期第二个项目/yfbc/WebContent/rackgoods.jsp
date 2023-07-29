<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link
	href="${pageContext.request.contextPath}/css/plugins/iCheck/custom.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/style.min.css?v=3.2.0"
	rel="stylesheet">

</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<body class="gray-bg">

	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-0">
				<button class="btn btn-primary btn-sm"
					onclick="location.href='javascript:history.go(-1);'">返回</button>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>货物列表</h5>
					</div>
					<div class="ibox-content">
						<table class="table table-hover" align="center">
							<thead>
								<tr>
									<th>货物名称</th>
									<th>货物类型</th>
									<th>数量</th>
									<th>单位</th>
									<th>仓库</th>
									<th>货架</th>
									<th>入库时间</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list }" var="put" varStatus="var">
									<tr>
										<td>${put.ins.productname}</td>
										<td>${put.ins.sku}</td>
										<td>${put.ins.purchaseqty}</td>
										<td><c:if test="${put.ins.unit==0 }">
											个
										</c:if> <c:if test="${put.ins.unit==1 }">
											件
										</c:if> <c:if test="${put.ins.unit==2 }">
											千克
										</c:if></td>
										<td>${put.war.whiname}</td>
										<td>${put.rack.rname}</td>
										<td><fmt:formatDate value="${put.ins.arrivaldate }"
												pattern="yyyy-MM-dd"></fmt:formatDate></td>

										<td class="project-actions"><c:if
													test="${put.ptbln == 1}">
													<a
														href="${pageContext.request.contextPath}/putaway/toaddputaway.do?pid=${put.ptid }&v=whm"
														class="btn btn-primary btn-sm"><i class="fa fa-folder"></i>
														计划出库</a>
												</c:if>
												<c:if
													test="${put.ptbln == 0}">
													<a
														href="${pageContext.request.contextPath}/putaway/toaddputaway.do?pid=${put.ptid }&v=whm"
														class="btn btn-white btn-sm"><i class="fa fa-folder"></i>
														已生成计划出库</a>
												</c:if></td>
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



	<!-- 全局js -->
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script>


	<script>
		$(document).ready(function() {
			$('.i-checks').iCheck({
				checkboxClass : 'icheckbox_square-green',
				radioClass : 'iradio_square-green',
			});

		});
	</script>



</body>

</html>