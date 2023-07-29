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
<link
	href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css"
	rel="stylesheet">
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js"></script>
<body class="gray-bg">
	<form action="${pageContext.request.contextPath}/outstorage/addouts.do"
		method="post" id="forms">
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="row">
				<div class="col-sm-4 col-sm-offset-0">
					<button class="btn btn-primary btn-sm"
						onclick="location.href='javascript:history.go(-1);'" type="button">返回</button>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-1 col-sm-offset-0"></div>
				<div class="col-sm-2 col-sm-offset-0">
					<button class="btn btn-primary btn-sm" onclick="showck();"
						type="button">添加多个出库计划</button>
				</div>
				<div class="col-sm-7 col-sm-offset-0"></div>
				<div class="col-sm-1 col-sm-offset-0">
					<button class="btn btn-primary btn-sm " type="button" id="subtn"
						style="display: none" data-toggle="modal" data-target="#myModal">添加</button>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-1">
					<input type="hidden" id="whidid" value="${whidid }">
				</div>
				<div class="col-sm-10">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>货物列表</h5>
						</div>
						<div class="ibox-content">
							<table class="table table-hover" align="center">
								<thead>
									<tr>
										<th></th>
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
									<c:forEach items="${map.list }" var="put" varStatus="var">
										<tr>
											<td>
												<c:if test="${put.ptbln == 1 }">
											<input type="checkbox" class="ck" name="ptid"
												value="${put.ptid}" style="display: none">
											</c:if>
											</td>
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
												</c:if>
												</td>
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


		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">日期选择</h4>
					</div>
					<div class="modal-body">
						<div class="input-group colorpicker-component demo demo-auto">
							<span class="input-group-addon">选择日期</span><input type="text"
								class="form-control " name="dates" onclick="WdatePicker();"/>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-dismiss="modal"
							onclick="formsubmit();">添加</button>
					</div>
				</div>
			</div>
		</div>
	</form>


	<!-- 全局js -->
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script>
	<script
		src="${pageContext.request.contextPath}/js/plugins/sweetalert/sweetalert.min.js"></script>



	<script type="text/javascript">
		function userlist(btn) {

			var id = btn.id;

			var whid = $("#whidid").val();

			var currPage = $
			{
				map.currPage
			}
			;

			if (id == "btn1" || id == "btn4") {
				location.href = "rackgoodall.do?currPage=" + (currPage - 1)
						+ "&whid=" + whid + "&v=0";
			} else if (id == "btn2") {
				location.href = "rackgoodall.do?currPage=" + (currPage - 3)
						+ "&whid=" + whid + "&v=0";
			} else if (id == "btn3") {
				location.href = "rackgoodall.do?currPage=" + (currPage - 2)
						+ "&whid=" + whid + "&v=0";
			} else if (id == "btn5") {
				location.href = "rackgoodall.do?currPage=" + (currPage)
						+ "&whid=" + whid + "&v=0";
			} else if (id == "btn7") {
				location.href = "rackgoodall.do?currPage=" + (currPage + 2)
						+ "&whid=" + whid + "&v=0";
			} else if (id == "btn8") {
				location.href = "rackgoodall.do?currPage=" + (currPage + 3)
						+ "&whid=" + whid + "&v=0";
			} else if (id == "btn9" || id == "btn6") {
				location.href = "rackgoodall.do?currPage=" + (currPage + 1)
						+ "&whid=" + whid + "&v=0";
			}
		}

		function showck() {
			$(".ck").css("display", "block");
			$("#subtn").css("display", "block");
		}

		function formsubmit() {
			$("#forms").submit();
		}
	</script>



</body>

</html>