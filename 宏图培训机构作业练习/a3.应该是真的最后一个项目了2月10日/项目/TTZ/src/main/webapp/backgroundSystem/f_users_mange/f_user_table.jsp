<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - FooTable</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link href="../backgroundSystem/css/bootstrap.min.css?v=3.4.0"
	rel="stylesheet">
<link href="../backgroundSystem/css/font-awesome.min.css?v=4.3.0"
	rel="stylesheet">
<link href="../backgroundSystem/css/plugins/footable/footable.core.css"
	rel="stylesheet">
<link href="../backgroundSystem/css/animate.min.css" rel="stylesheet">
<link href="../backgroundSystem/css/style.min.css?v=3.2.0"
	rel="stylesheet">
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<br>
				<form
					action="${pageContext.request.contextPath}/user/seluserbyname.action"
					method="post">
					用户名：<input type="text" value="${yonghuming }" name="yonghuming">
					<input type="submit" value="查找"> <br> <br>
				</form>
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>前台用户基本信息表</h5>
					</div>
					<div class="ibox-content">
						<table class="footable table table-stripped toggle-arrow-tiny"
							data-page-size="8">
							<thead>
								<tr>
									<th data-toggle="true">编号</th>
									<th>用户ID</th>
									<th>用户名</th>
									<th>信用等级</th>
									<th>信用额度</th>
									<th>vip等级</th>
									<th data-hide="all">真实姓名</th>
									<th data-hide="all">身份证号</th>
									<th data-hide="all">电话</th>
									<th data-hide="all">email</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach items="${ttzAlllist}" var="ttz" varStatus="index">
									<tr>
										<td>${index.index+1 }</td>
										<td>${ttz.userid }</td>
										<td>${ttz.username}</td>
										<td>${ttz.xylevel }</td>
										<td>${ttz.syed}</td>
										<td>${ttz.vip }</td>
										<c:if test="${ttz.idcard == '' || ttz.idcard == null}">
											<td>未认证</td>
											<td>未认证</td>
										</c:if>
										<c:if test="${ttz.idcard != '' && ttz.idcard != null}">
											<td>${ttz.zsname }</td>
											<td>${ttz.idcard }</td>
										</c:if>
										<td>${ttz.tel }</td>
										<td>${ttz.email }</td>
									</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr>
									<td colspan="7">
										<ul class="pagination pull-left">
											<c:if test="${fn:length(ttzAlllist)<=0 }">
												<font size="4" color="red">没有该用户哟!</font>
											</c:if>
										</ul>
									</td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 全局js -->
	<script src="../backgroundSystem/js/jquery-2.1.1.min.js"></script>
	<script src="../backgroundSystem/js/bootstrap.min.js?v=3.4.0"></script>
	<script
		src="../backgroundSystem/js/plugins/footable/footable.all.min.js"></script>

	<!-- 自定义js -->
	<script src="../backgroundSystem/js/content.min.js?v=1.0.0"></script>
	<script>
		$(document).ready(function() {
	
			$('.footable').footable();
			$('.footable2').footable();
	
		});
	</script>

	<script type="text/javascript"
		src="../../../tajs.qq.com/stats@sId=9051096.jsp" charset="UTF-8"></script>
	<!--统计代码，可删除-->
</body>

</html>