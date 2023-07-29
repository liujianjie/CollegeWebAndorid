<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - 联系人</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link
	href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.3.0"
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
			<div class="col-sm-8 col-sm-offset-10">
				<button class="btn btn-primary btn-outline"
					onclick="location.href='toadd.do'">&nbsp;&nbsp;&nbsp;新建仓库&nbsp;&nbsp;&nbsp;</button>
			</div>
		</div>
		<br>
		<div class="row">
			<c:forEach items="${list.list }" var="war">
				<div class="col-sm-4">
					<div class="contact-box">
						<a href="torack.do?whid=${war.whid }&v=12">
							<div class="col-sm-4">
								<div class="text-center">
									<img alt="image" class="img-circle m-t-xs img-responsive"
										src="${pageContext.request.contextPath}/img/a2.jpg">
									<div class="m-t-xs font-bold">${war.whiname}</div>
								</div>
							</div>
							<div class="col-sm-8">
								<h3>
									<strong>${war.whiname}</strong>
								</h3>
								<p>
									<i class="fa fa-map-marker"></i>${war.city.name }</p>
								<strong>管理员：</strong>${war.user.username }<br> <strong>状态：</strong>
								<c:if test="${war.whistate == '0' }">
                                    		正在使用
                                    	</c:if>
								<c:if test="${war.whistate == '1' }">
                                    		停用
                                </c:if>

							</div>
							<div class="clearfix"></div>
						</a>
					</div>
				</div>
			</c:forEach>

		</div>
		<div class="row">
			<div class="btn-group col-sm-8"></div>
			<div class="btn-group col-sm-4">
				共${list.totalRow }条记录 ${list.currPage }/${list.totalPage }页

				
				<a><button type="button" id="btn1" onclick="userlist(this);" class="btn btn-white">
					<i class="fa fa-chevron-left"></i>
				</button></a>
				<c:if test="${list.currPage-3>0}">
					<a><button id="btn2" onclick="userlist(this);" class="btn btn-white">${list.currPage-3}</button></a>
				</c:if>
				<c:if test="${list.currPage-2>0}">
					<a><button id="btn3" onclick="userlist(this);" class="btn btn-white">${list.currPage-2}</button></a>
				</c:if>
				<c:if test="${list.currPage-1>0}">
					<a><button id="btn4" onclick="userlist(this);" class="btn btn-white">${list.currPage-1}</button></a>
				</c:if>
				<a><button id="btn5" onclick="userlist(this);" class="btn btn-white  active">${list.currPage}</button></a>
				<c:if test="${list.currPage+1<= list.totalPage}">
					<a><button id="btn6" onclick="userlist(this);" class="btn btn-white">${list.currPage+1}</button></a>
				</c:if>
				<c:if test="${list.currPage+2<= list.totalPage}">
					<a><button id="btn7" onclick="userlist(this);" class="btn btn-white">${list.currPage+2}</button></a>
				</c:if>
				<c:if test="${list.currPage+3<= list.totalPage}">
					<a><button id="btn8" onclick="userlist(this);" class="btn btn-white">${list.currPage+3}</button></a>
				</c:if>
				<a><button type="button" id="btn9" onclick="userlist(this);" class="btn btn-white">
					<i class="fa fa-chevron-right"></i>
				</button></a>
			</div>
			<!-- 		end 页脚	 -->
		</div>
		
	</div>
	

	<!-- 全局js -->
	<script src="${pageContext.request.contextPath}/js/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.4.0"></script>



	<!-- 自定义js -->
	<script
		src="${pageContext.request.contextPath}/js/content.min.js?v=1.0.0"></script>



	<script>
		$(document).ready(function() {
			$('.contact-box').each(function() {
				animationHover(this, 'pulse');
			});
		});
	</script>
	
	
	<script>
	
		function userlist(btn) {
			var id=btn.id;
			
			var currPage=${list.currPage};
			if(id=="btn1"||id=="btn4"){
				location.href="list.do?currPage="+(currPage-1)+"&v=0";
			}else if(id=="btn2"){
				location.href="list.do?currPage="+(currPage-3)+"&v=0";
			}else if(id=="btn3"){
				location.href="list.do?currPage="+(currPage-2)+"&v=0";
			}else if(id=="btn5"){
				location.href="list.do?currPage="+(currPage)+"&v=0";
			}else if(id=="btn7"){
				location.href="list.do?currPage="+(currPage+2)+"&v=0";
			}else if(id=="btn8"){
				location.href="list.do?currPage="+(currPage+3)+"&v=0";
			}else if(id=="btn9"||id=="btn6"){
				location.href="list.do?currPage="+(currPage+1)+"&v=0";
			}
		}
	</script>

</body>

</html>