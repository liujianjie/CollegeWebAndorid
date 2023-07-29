<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	 <!-- js -->
	<jsp:include page="PublicJsp.jsp"></jsp:include>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>H+ 后台主题UI框架 - 基础表格</title>
	<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
	<meta name="description"
		content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">	
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>收货列表</h5>
					</div>
					<div class="ibox-content">
						<div class="col-sm-12">
							<div class="col-sm-2">
								<select class="form-control" id="whid" name="whid">
									<option>仓库</option>
									<c:forEach items="${maps.warelist }" var="ware">
										<option value="${ware.whid}" ${ware.whid==maps.whid?'selected':'' }>${ware.whiname } </option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-2">
								<select class="form-control" id="unit" name="unit">
									<option>单位</option>
									<option value="0" ${maps.unit==0?'selected':'' }>个</option>
									<option value="1" ${maps.unit==1?'selected':'' }>件</option>
									<option value="2" ${maps.unit==2?'selected':'' }>千克</option>
								</select>
							</div>
							<div class="col-sm-2">
								<select class="form-control" id="sku" name="sku">
									<option>货物类型</option>
									<c:forEach items="${maps.goodslist }" var="goods">
										<option value="${goods.tid}" ${goods.tid==maps.sku?'selected':'' }>${goods.tname }</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-2">
								<button class="btn btn-primary" onclick="recelist()">搜索</button>
							</div>
						</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th >入库时间</th>
									<th >仓库</th>
									<th >货物名称</th>
									<th >货物型号</th>
									<th >数量</th>
									<th >单位</th>
									<th >坏货数量</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${maps.relist }" var="rec" varStatus="var">
									<tr height="50">
										<td><fmt:formatDate value="${rec.receivedate }"
												pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>
										<td><c:forEach items="${maps.warelist }" var="ware">
												<c:if test="${ware.whid==rec.whid }">
	                                    			${ware.whiname }
	                                    		</c:if>
											</c:forEach>
											<input id="${var.index+1 }reid" type="text" style="display:none " value="${rec.reid }">
											<input id="${var.index+1 }inid" type="text" style="display:none " value="${rec.inid }">
											<input id="${var.index+1 }whid" type="text" style="display:none " value="${rec.whid }">
										</td>
										<td>
											${rec.productname}
										</td>
										<td><c:forEach items="${maps.goodslist }" var="goods">
												<c:if test="${goods.tid==rec.sku }">
                                    				${goods.tname }
                                    			</c:if>
											</c:forEach>
											<input id="${var.index+1 }sku" type="hidden" value="${rec.sku }">
										</td>
										<td>${rec.purchaseqty }
											<input id="${var.index+1 }size" type="hidden"  value="${rec.purchaseqty }">
										</td>
										<td>
											<c:if test="${rec.unit==0 }">
												个
											</c:if>
											<c:if test="${rec.unit==1 }">
												件
											</c:if>
											<c:if test="${rec.unit==2 }">
												千克
											</c:if>
											<input id="${var.index+1 }unit" type="text" style="display:none " value="${rec.unit }">
										</td>
										<td>${rec.shortqty }</td>
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
	
	<script>
		$(document).ready(function() {
			$('.i-checks').iCheck({
				checkboxClass : 'icheckbox_square-green',
				radioClass : 'iradio_square-green',
			});
		});
	</script>
	<!-- 条件查询 -->
	<script>
		function recelist(){
			var unit = $("#unit").val();
			var sku = $("#sku").val();
			var whid = $("#whid").val();
			if(unit=='单位'){
				unit=999;
			}
			if(sku=='货物类型'){
				sku=999;
			}if(whid=='仓库'){
				whid=999;
			}
			location.href="listofwhere.do?cpage=1&unit="+unit+"&sku="+sku+"&whid="+whid+"";
		}
	</script>
	
	
	<!-- 分页 -->
	<script>
	
		function userlist(btn) {
			var unit = $("#unit").val();
			var sku = $("#sku").val();
			var whid = $("#whid").val();
			if(unit=='单位'){
				unit=999;
			}
			if(sku=='货物类型'){
				sku=999;
			}if(whid=='仓库'){
				whid=999;
			}
			var id=btn.id;
			var currPage='${maps.currPage}';
			if(id=="btn1"||id=="btn4"){
				location.href="listofwhere.do?cpage="+(currPage-1)+"&unit="+unit+"&sku="+sku+"&whid="+whid+"&v=0";
			}else if(id=="btn2"){
				location.href="listofwhere.do?cpage="+(currPage-3)+"&unit="+unit+"&sku="+sku+"&whid="+whid+"&v=0";
			}else if(id=="btn3"){
				location.href="listofwhere.do?cpage="+(currPage-2)+"&unit="+unit+"&sku="+sku+"&whid="+whid+"&v=0";
			}else if(id=="btn5"){
				location.href="listofwhere.do?cpage="+(currPage)+"&unit="+unit+"&sku="+sku+"&whid="+whid+"&v=0";
			}else if(id=="btn7"){
				location.href="listofwhere.do?cpage="+(currPage+2)+"&unit="+unit+"&sku="+sku+"&whid="+whid+"&v=0";
			}else if(id=="btn8"){
				location.href="listofwhere.do?cpage="+(currPage+3)+"&unit="+unit+"&sku="+sku+"&whid="+whid+"&v=0";
			}else if(id=="btn9"||id=="btn6"){
				location.href="listofwhere.do?cpage="+(currPage+1)+"&unit="+unit+"&sku="+sku+"&whid="+whid+"&v=0";
			}
		}
	</script>

</body>

</html>