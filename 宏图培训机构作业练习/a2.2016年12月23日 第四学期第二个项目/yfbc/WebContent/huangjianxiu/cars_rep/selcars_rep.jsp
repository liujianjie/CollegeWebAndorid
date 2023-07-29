<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>车辆报修</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link
	href="${pageContext.request.contextPath }/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/plugins/iCheck/custom.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/css/style.min.css?v=3.2.0"
	rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<!-- <button type="button" class="btn btn-primary dim" onclick="location.href='${pageContext.request.contextPath}/hjx/toaddcars_rep.do'">填写申请报修单</button> -->
		<div class="row">
			<br>
	<% Object user=session.getAttribute("user");%>
	<!-- 我的仓库 -->
	<input id="userid" type="hidden" value="${user.id }">
	<div class="wrapper wrapper-content animated fadeInRight">
	    <div class="row">
			<div class="col-sm-1"></div>
			<div class="col-sm-10">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>申请报修列表</h5>
					</div>
					<div class="ibox-content">
						<table class="table table-hover" align="center">
							<thead>
								<tr>
									<th>申请人</th>
									<th>报修车辆</th>
									<th>报修原因</th>
									<th>报修金额</th>
									<th>报修时间</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody id = "tbody">
								<c:forEach items="${cars_repsVolist }" var="cars_repvo" >
									<tr height="50">
										<td>
											${cars_repvo.username }
										</td>
										<td>
											${cars_repvo.carsname }
										</td>
										<td>
											${cars_repvo.cars_repairs.repairsreason }
										</td>
										<td>
											${cars_repvo.cars_repairs.repairsmoney }
										</td>
										<td>
											<fmt:formatDate value="${cars_repvo.cars_repairs.repairsdate }" pattern="yyyy-MM-dd hh:mm:ss"/>
											
										</td>
										<td>
											<c:if test="${cars_repvo.cars_repairs.state==0}">
												<span class="label label-primary">未提交</span>
											</c:if>
                                        	<c:if test="${cars_repvo.cars_repairs.state==1}">
                                        		<span class="label label-primary">审核中</span>
                                        	</c:if>
                                       		<c:if test="${cars_repvo.cars_repairs.state==2}">
                                       			<span class="label label-primary">审核通过</span>
                                       		</c:if>
                                       		<c:if test="${cars_repvo.cars_repairs.state==3}">
                                       			<span class="label label-primary">审核未通过</span>
                                       		</c:if>
									
										<td>
											<c:if test="${cars_repvo.cars_repairs.state==0 }">
												<a onclick="getrack(this.id);" data-toggle="modal"
													class="btn btn-white btn-sm" href="#modal-form">
													<i class="fa fa-folder"></i>
													提交
												</a>
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
	</div>
			 <!-- 		start 页脚	 -->
			<div class="col-sm-1"></div>
				<div class="btn-group col-sm-8">
				共${totalRow }条记录 ${currPage }/${totalPage }页
				<div class="col-sm-2">
					<input type="text" id="pageCount" value="${pageCount }" class="form-control" />
				</div>
				<a><button type="button" id="btn1" onclick="cars_infolist(this);" class="btn btn-white">
				<i class="fa fa-chevron-left"></i>
				</button></a>
				<c:if test="${currPage-3>0}">
					<a><button id="btn2" onclick="cars_infolist(this);" class="btn btn-white">${currPage-3}</button></a>
				</c:if>
				<c:if test="${currPage-2>0}">
					<a><button id="btn3" onclick="cars_infolist(this);" class="btn btn-white">${currPage-2}</button></a>
				</c:if>
				<c:if test="${currPage-1>0}">
					<a><button id="btn4" onclick="cars_infolist(this);" class="btn btn-white">${currPage-1}</button></a>
				</c:if>
					<a><button id="btn5" onclick="cars_infolist(this);" class="btn btn-white  active">${currPage}</button></a>
				<c:if test="${currPage+1<=totalPage}">
					<a><button id="btn6" onclick="cars_infolist(this);" class="btn btn-white">${currPage+1}</button></a>
				</c:if>
				<c:if test="${currPage+2<=totalPage}">
					<a><button id="btn7" onclick="cars_infolist(this);" class="btn btn-white">${currPage+2}</button></a>
				</c:if>
				<c:if test="${currPage+3<=totalPage}">
					<a><button id="btn8" onclick="cars_infolist(this);" class="btn btn-white">${currPage+3}</button></a>
				</c:if>
					<a><button type="button" id="btn9" onclick="cars_infolist(this);" class="btn btn-white">
				<i class="fa fa-chevron-right"></i>
					</button></a>
			</div>
			<!-- 		end 页脚	 -->
		</div>
	</div>

	<script>
	
	function cars_infolist(btn) {
		var id=btn.id;
		var pageCount=document.getElementById("pageCount").value;
		var currPage=${currPage};
		if(id=="btn1"||id=="btn4"){
			location.href="selcars.do?pageCount="+pageCount+"&currPage="+(currPage-1)+"&v=0";
		}else if(id=="btn2"){
			location.href="selcars.do?pageCount="+pageCount+"&currPage="+(currPage-3)+"&v=0";
		}else if(id=="btn3"){
			location.href="selcars.do?pageCount="+pageCount+"&currPage="+(currPage-2)+"&v=0";
		}else if(id=="btn5"){
			location.href="selcars.do?pageCount="+pageCount+"&currPage="+(currPage)+"&v=0";
		}else if(id=="btn7"){
			location.href="selcars.do?pageCount="+pageCount+"&currPage="+(currPage+2)+"&v=0";
		}else if(id=="btn8"){
			location.href="selcars.do?pageCount="+pageCount+"&currPage="+(currPage+3)+"&v=0";
		}else if(id=="btn9"||id=="btn6"){
			location.href="selcars.do?pageCount="+pageCount+"&currPage="+(currPage+1)+"&v=0";
		}
	}
	</script>

	<!-- 全局js -->
	<script
		src="${pageContext.request.contextPath }/js/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/js/bootstrap.min.js?v=3.4.0"></script>




	<!-- Peity -->
	<script
		src="${pageContext.request.contextPath }/js/plugins/peity/jquery.peity.min.js"></script>

	<!-- 自定义js -->
	<script
		src="${pageContext.request.contextPath }/js/content.min.js?v=1.0.0"></script>


	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath }/js/plugins/iCheck/icheck.min.js"></script>

	<!-- Peity -->
	<script
		src="${pageContext.request.contextPath }/js/demo/peity-demo.min.js"></script>

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