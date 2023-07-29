<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>岗位列表</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link
	href="${pageContext.request.contextPath }/backgroundSystem/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/backgroundSystem/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/backgroundSystem/css/plugins/iCheck/custom.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/backgroundSystem/css/animate.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/backgroundSystem/css/style.min.css?v=3.2.0"
	rel="stylesheet">

</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<button type="button" class="btn btn-primary dim" onclick="location.href='${pageContext.request.contextPath}/backgroundSystem/postadd.jsp'">添加岗位</button>
		<div class="row">
			<c:forEach items="${plist}" var="pos">
				<div class="col-sm-4">
					<div class="contact-box">
						<div class="col-sm-4">
							<div class="text-center">
								<!-- 去infor界面 就是修改 -->
								<a href="toalert.action?id=${pos.p_id}">
									<img alt="image" class="img-circle m-t-xs img-responsive"
										src="${pageContext.request.contextPath }/backgroundSystem/img/position.png">
								</a>
								<button type="button" class="btn btn-xs btn-danger" 
								onclick="location.href='${pageContext.request.contextPath }/post/delpost.action?id=${pos.p_id }'">删除</button>
							</div>
						</div>
						<div class="col-sm-8">
							<h3>
								<strong>岗位名称：${pos.p_name }</strong>
							</h3>
							<address>
								<strong>岗位简介：</strong>
								<br>
                            		${pos.p_jianjie }
                            	<br>
							</address>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<!-- 全局js -->
	<script
		src="${pageContext.request.contextPath }/backgroundSystem/js/jquery-2.1.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/backgroundSystem/js/bootstrap.min.js?v=3.4.0"></script>

	<!-- Peity -->
	<script
		src="${pageContext.request.contextPath }/backgroundSystem/js/plugins/peity/jquery.peity.min.js"></script>

	<!-- 自定义js -->
	<script
		src="${pageContext.request.contextPath }/backgroundSystem/js/content.min.js?v=1.0.0"></script>


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