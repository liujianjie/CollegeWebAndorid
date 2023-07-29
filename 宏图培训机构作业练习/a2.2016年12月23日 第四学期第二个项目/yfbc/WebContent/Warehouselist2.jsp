<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>仓库列表</title>
<meta name="keywords" content="">
<meta name="description" content="">

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
			</div>
		</div>
		<br>
		<div class="row">

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



</body>

</html>