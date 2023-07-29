<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>出库单列表</title>
<meta name="keywords" content="">
<meta name="description"
	content="">

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

<body class="gray-bg">

	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<!-- 				<button type="button" onclick="javascript:window.location='list.do?currPage=1'"></button> -->
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>出库单列表</h5>
					</div>
					<div class="ibox-content">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>货物名称</th>
									<th>货物型号</th>
									<th>数量</th>
									<th>单位</th>
									<th>收货人</th>
									<th>收货人电话</th>
									<th>单价</th>
									<th>总价</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${map.list }" var="put" varStatus="var">
									<tr>
										<td>${put.productname}</td>
										<td>${put.sku}</td>
										<td>${put.purchaseqty}</td>
										<td><c:if test="${put.unit==0 }">
											个
										</c:if> <c:if test="${put.unit==1 }">
											件
										</c:if> <c:if test="${put.unit==2 }">
											千克
										</c:if></td>
										<td>${put.receivename}</td>
										<td>${put.receiveno}</td>
										<td>${put.univalent}</td>
										<td>${put.price}</td>

										<td class="project-actions"><c:if
												test="${put.statu == '1' }">
												<a
													href="${pageContext.request.contextPath}/hjx/toaddcars_att.do?deid=${put.deid}&v=whm"
													class="btn btn-primary btn-sm"><i class="fa fa-folder"></i>
													出库</a>
											</c:if> <c:if test="${put.statu == '0' }">
												<a class="btn btn-white btn-sm"><i class="fa fa-folder"></i>
													已出库</a>
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

		<div class="row">
			<div class="btn-group col-sm-8"></div>
			<div class="btn-group col-sm-4">
			<input type="hidden" value="${map.currPage }" id="curr">
				共${map.totalRow }条记录 ${map.currPage }/${map.totalPage }页 <a><button
						type="button" id="btn1" onclick="userlist(this);"
						class="btn btn-white">
						<i class="fa fa-chevron-left"></i>
					</button></a>
				<c:if test="${map.currPage-3>0}">
					<a><button id="btn2" onclick="userlist(this);"
							class="btn btn-white">${map.currPage-3}</button></a>
				</c:if>
				<c:if test="${map.currPage-2>0}">
					<a><button id="btn3" onclick="userlist(this);"
							class="btn btn-white">${map.currPage-2}</button></a>
				</c:if>
				<c:if test="${map.currPage-1>0}">
					<a><button id="btn4" onclick="userlist(this);"
							class="btn btn-white">${map.currPage-1}</button></a>
				</c:if>
				<a><button id="btn5" onclick="userlist(this);"
						class="btn btn-white  active">${map.currPage}</button></a>
				<c:if test="${map.currPage+1<= map.totalPage}">
					<a><button id="btn6" onclick="userlist(this);"
							class="btn btn-white">${map.currPage+1}</button></a>
				</c:if>
				<c:if test="${map.currPage+2<= map.totalPage}">
					<a><button id="btn7" onclick="userlist(this);"
							class="btn btn-white">${map.currPage+2}</button></a>
				</c:if>
				<c:if test="${map.currPage+3<= map.totalPage}">
					<a><button id="btn8" onclick="userlist(this);"
							class="btn btn-white">${map.currPage+3}</button></a>
				</c:if>
				<a><button type="button" id="btn9" onclick="userlist(this);"
						class="btn btn-white">
						<i class="fa fa-chevron-right"></i>
					</button></a>
			</div>
		</div>
	</div>


	<!-- 全局js -->
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script>

	<script>
		function userlist(btn) {
			var id = btn.id;

			var currPage = $('#curr').val();
			if (id == "btn1" || id == "btn4") {
				location.href = "list2.do?currPage=" + (currPage - 1) + "&v=0";
			} else if (id == "btn2") {
				location.href = "list2.do?currPage=" + (currPage - 3) + "&v=0";
			} else if (id == "btn3") {
				location.href = "list2.do?currPage=" + (currPage - 2) + "&v=0";
			} else if (id == "btn5") {
				location.href = "list2.do?currPage=" + (currPage) + "&v=0";
			} else if (id == "btn7") {
				location.href = "list2.do?currPage=" + (currPage + 2) + "&v=0";
			} else if (id == "btn8") {
				location.href = "list2.do?currPage=" + (currPage + 3) + "&v=0";
			} else if (id == "btn9" || id == "btn6") {
				location.href = "list2.do?currPage=" + (currPage + 1) + "&v=0";
			}
		}
	</script>
</body>
</html>