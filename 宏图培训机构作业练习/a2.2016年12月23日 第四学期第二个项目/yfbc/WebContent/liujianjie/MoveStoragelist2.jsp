<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<jsp:include page="PublicJsp.jsp"></jsp:include>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>H+ 后台主题UI框架 - 基础表格</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

</head>

<body class="gray-bg">
	<br>
	<% Object user=session.getAttribute("user");%>
	<input type="hidden" value="${user.id }" id="userid">
	<div class="wrapper wrapper-content animated fadeInRight">
	    <div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>移货列表</h5>
					</div>
					<div class="ibox-content">
						<div class="col-sm-12">
							<div class="col-sm-2">
								<select class="form-control" id="mowhiname" name="mowhiname">
									<option>源仓库</option>
									<c:forEach items="${maps.warelist }" var="ware">
										<option value="${ware.whid}" ${ware.whiname==maps.mowhiname?'selected':'' }>${ware.whiname } </option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-2">
								<select class="form-control" id="towhiname" name="towhiname">
									<option>目标仓库</option>
									<c:forEach items="${maps.warelist }" var="ware">
										<option value="${ware.whid}" ${ware.whiname==maps.towhiname?'selected':'' }>${ware.whiname } </option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-2">
								<button class="btn btn-primary" onclick="molist()">搜索</button>
							</div>
						</div>
						<table class="table table-hover" align="center">
							<thead>
								<tr>
									<th>源仓库</th>
									<th>目标仓库</th>
									<th>货物名称</th>
									<th>货物型号</th>
									<th>数量</th>
									<th>单位</th>
									<th>车辆</th>
									<th>状态</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${maps.movelist }" var="move" varStatus="var">
									<tr height="50">
										<td>${move.mowhiname}</td>
										<td>${move.towhiname}</td>
										<td>${move.ptay3.rece.productname}
										</td>
										<td>
											<c:forEach items="${maps.goodslist }" var="goods">
												<c:if test="${goods.tid==move.ptay3.rece.sku}">
                                    				${goods.tname }
                                    			</c:if>
											</c:forEach>
										</td>
										<td>${move.ptay3.rece.purchaseqty}</td>
										<td><c:if test="${move.ptay3.rece.unit==0 }">
											个
										</c:if> <c:if test="${move.ptay3.rece.unit==1 }">
											件
										</c:if> <c:if test="${move.ptay3.rece.unit==2 }">
											千克
										</c:if></td>
										<td>
											<c:forEach items="${maps.carsinfoslist }" var="cars">
												<c:if test="${cars.id==move.carsid }">
													${cars.carsname }
												</c:if>
											</c:forEach>
										</td>
										<td>
											<c:if test="${move.mostate==0 }">
											 	<span class="label label-default">未开始</span>
											</c:if>
											<c:if test="${move.mostate==1 }">
											 	<span class="label label-primary">移货中</span>
											</c:if>
											<c:if test="${move.mostate==2 }">
											 	<span class="btn btn-xs btn-danger"><i class="heart"></i>移货成功</span>
											</c:if>
											<c:if test="${move.mostate==3 }">
											 	<span class="label label-default">移货失败</span>
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
				共${maps.totalcount }条记录 ${maps.currPage }/${maps.totalPage }页
				
				<a><button type="button" id="btn1" onclick="userlist(this);" class="btn btn-white">
					<i class="fa fa-chevron-left"></i>
				</button></a>
				<c:if test="${maps.currPage-3>0}">
					<a><button id="btn2" onclick="userlist(this);" class="btn btn-white">${maps.currPage-3}</button></a>
				</c:if>
				<c:if test="${maps.currPage-2>0}">
					<a><button id="btn3" onclick="userlist(this);" class="btn btn-white">${maps.currPage-2}</button></a>
				</c:if>
				<c:if test="${maps.currPage-1>0}">
					<a><button id="btn4" onclick="userlist(this);" class="btn btn-white">${maps.currPage-1}</button></a>
				</c:if>
				<a><button id="btn5" onclick="userlist(this);" class="btn btn-white  active">${maps.currPage}</button></a>
				<c:if test="${maps.currPage+1<= maps.totalPage}">
					<a><button id="btn6" onclick="userlist(this);" class="btn btn-white">${maps.currPage+1}</button></a>
				</c:if>
				<c:if test="${maps.currPage+2<= maps.totalPage}">
					<a><button id="btn7" onclick="userlist(this);" class="btn btn-white">${maps.currPage+2}</button></a>
				</c:if>
				<c:if test="${maps.currPage+3<= maps.totalPage}">
					<a><button id="btn8" onclick="userlist(this);" class="btn btn-white">${maps.currPage+3}</button></a>
				</c:if>
				<a><button type="button" id="btn9" onclick="userlist(this);" class="btn btn-white">
					<i class="fa fa-chevron-right"></i>
				</button></a>
			</div>
			<!-- 		end 页脚	 -->
		</div>
	</div>
    
    <!-- 条件 -->
    <script type="text/javascript">
    function molist(){
		var mowhiname = $("#mowhiname").val();
		var towhiname = $("#towhiname").val();
		if(mowhiname=='源仓库'){
			mowhiname='999';
		}
		if(towhiname=='目标仓库'){
			towhiname='999';
		}
		location.href="list2ofwhere.do?cpage=1&mowhiname="+mowhiname+"&towhiname="+towhiname+"";
	}
    </script>
    
    <!-- 分页 -->
	<script>
		var userid = $("#userid").val();
		function userlist(btn) {
			var mowhiname = $("#mowhiname").val();
			var towhiname = $("#towhiname").val();
			if(mowhiname=='源仓库'){
				mowhiname='999';
			}
			if(towhiname=='目标仓库'){
				towhiname='999';
			}
			var id=btn.id;
			var currPage='${maps.currPage}';
			if(id=="btn1"||id=="btn4"){
				location.href="list2ofwhere.do?cpage="+(currPage-1)+"&mowhiname="+mowhiname+"&towhiname="+towhiname+"&v=0";
			}else if(id=="btn2"){
				location.href="list2ofwhere.do?cpage="+(currPage-3)+"&mowhiname="+mowhiname+"&towhiname="+towhiname+"&v=0";
			}else if(id=="btn3"){
				location.href="list2ofwhere.do?cpage="+(currPage-2)+"&mowhiname="+mowhiname+"&towhiname="+towhiname+"&v=0";
			}else if(id=="btn5"){
				location.href="list2ofwhere.do?cpage="+(currPage)+"&mowhiname="+mowhiname+"&towhiname="+towhiname+"&v=0";
			}else if(id=="btn7"){
				location.href="list2ofwhere.do?cpage="+(currPage+2)+"&mowhiname="+mowhiname+"&towhiname="+towhiname+"&v=0";
			}else if(id=="btn8"){
				location.href="list2ofwhere.do?cpage="+(currPage+3)+"&mowhiname="+mowhiname+"&towhiname="+towhiname+"&v=0";
			}else if(id=="btn9"||id=="btn6"){
				location.href="list2ofwhere.do?cpage="+(currPage+1)+"&mowhiname="+mowhiname+"&towhiname="+towhiname+"&v=0";
			}
		}
	</script>

</body>

</html>