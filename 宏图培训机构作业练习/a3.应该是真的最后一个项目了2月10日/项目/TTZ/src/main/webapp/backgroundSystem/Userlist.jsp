<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title></title>
<meta name="keywords" content="">
<meta name="description" content="">
<jsp:include page="PublicJsp.jsp"></jsp:include>

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<c:forEach items="${map.list}" var="user">
				<div class="col-sm-4">
					<div class="contact-box">
						<div class="col-sm-4">
							<div class="text-center">
								<!-- 去infor界面 就是修改 -->
								<a href="toalert.action?id=${user.b_id}"> <img alt="image"
									class="img-circle m-t-xs img-responsive"
									src="${pageContext.request.contextPath }/${user.b_touxiang}">
								</a>
								<div class="m-t-xs font-bold">
									<c:if
										test="${user.b_positionid=='待分配'||user.b_positionid=='' }">暂无岗位</c:if>
									<c:forEach items="${map.post }" var="pos">
										<c:if test="${user.b_positionid==pos.p_id }">${pos.p_name }</c:if>
									</c:forEach>
								</div>
								<button type="button" class="btn btn-xs btn-danger"
									onclick="deletes('${user.b_id }');">删除</button>
							</div>
						</div>
						<div class="col-sm-8">
							<h3>
								<strong>${user.b_username }</strong>
							</h3>
							<p>
								<i class="fa fa-map-marker"></i>${user.b_address }
							</p>
							<address>
								<strong>一个快乐的工作人员</strong><br> <abbr title="Phone">联系方式:</abbr>
								${user.b_tel }
							</address>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</c:forEach>
			<!-- 		start 页脚	 -->
			<div class="col-sm-1"></div>
			<div class="btn-group col-sm-8">
				共${map.totalCount }条记录 ${map.currPage }/${map.totalPage }页

				<div class="col-sm-2">
					<input type="hidden" id="pageCount" value="${map.pageCount }"
						class="form-control" />
				</div>
				<a><button type="button" id="btn1" onclick="userlist(this);"
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
				<c:if test="${map.currPage+1<=map.totalPage}">
					<a><button id="btn6" onclick="userlist(this);"
							class="btn btn-white">${map.currPage+1}</button></a>
				</c:if>
				<c:if test="${map.currPage+2<=map.totalPage}">
					<a><button id="btn7" onclick="userlist(this);"
							class="btn btn-white">${map.currPage+2}</button></a>
				</c:if>
				<c:if test="${map.currPage+3<=map.totalPage}">
					<a><button id="btn8" onclick="userlist(this);"
							class="btn btn-white">${map.currPage+3}</button></a>
				</c:if>
				<a><button type="button" id="btn9" onclick="userlist(this);"
						class="btn btn-white">
						<i class="fa fa-chevron-right"></i>
					</button></a>
			</div>
			<!-- 		end 页脚	 -->
		</div>
	</div>

	<script>
		function deletes(val) {
			if (confirm("确定要删除吗?")) {
				location.href = '${pageContext.request.contextPath }/backuser/del.action?userid=' + val;
			} else {
	
			}
		}
		function userlist(btn) {
			var id = btn.id;
			var pageCount = document.getElementById("pageCount").value;
			var currPage = parseInt('${map.currPage}'); //需要强转 不然为String 1+1=11
			if (id == "btn1" || id == "btn4") {
				location.href = "userlist.action?cpage=" + (currPage - 1) + "&v=0";
			} else if (id == "btn2") {
				location.href = "userlist.action?cpage=" + (currPage - 3) + "&v=0";
			} else if (id == "btn3") {
				location.href = "userlist.action?cpage=" + (currPage - 2) + "&v=0";
			} else if (id == "btn5") {
				location.href = "userlist.action?cpage=" + (currPage) + "&v=0";
			} else if (id == "btn7") {
				location.href = "userlist.action?cpage=" + (currPage + 2) + "&v=0";
			} else if (id == "btn8") {
				location.href = "userlist.action?cpage=" + (currPage + 3) + "&v=0";
			} else if (id == "btn9" || id == "btn6") {
				location.href = "userlist.action?cpage=" + (currPage + 1) + "&v=0";
			}
		}
	</script>

	<script>
		$(document).ready(function() {
			$('.contact-box').each(function() {
				animationHover(this, 'pulse');
			});
		});
	</script>

</body>

</html>