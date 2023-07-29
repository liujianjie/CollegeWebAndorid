<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
	<head>
	 <base href="<%=basePath%>">
		<!--
        ===
        This comment should NOT be removed.

        Charisma v2.0.0

        Copyright 2012-2014 Muhammad Usman
        Licensed under the Apache License v2.0
        http://www.apache.org/licenses/LICENSE-2.0

        http://usman.it
        http://twitter.com/halalit_usman
        ===
    -->
		<meta charset="utf-8">
		<title>Free HTML5 Bootstrap Admin Template</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description"
			content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
		<meta name="author" content="Muhammad Usman">

		<!-- The styles -->

	</head>

	<body>
	<jsp:include page="common.jsp"></jsp:include>
	<div class="ch-container">
    <div class="row"> 

				

				<div id="content" class="col-lg-10 col-sm-10" style="width:100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="homepage(tea).jsp">首页</a>
							</li>
							<li>
								<a href="#">招生名单</a>
							</li>
							
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 招生名单
									</h2>

								</div>
								<div class="box-content">
									<div class="alert alert-info" style="height: 70px;">
										<a class="btn btn-success" href="apply/add.jsp" style="float: right;"> <i
											class="glyphicon glyphicon-pencil"></i> 添加学生信息</a>
									</div>
									<table
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
										<tr>
											<th >
												学生ID
											</th>
											<th >
												学生姓名
											</th>
											<th >
												籍贯
											</th>
											<th >
												QQ
											</th>
											
											<th >
												 就读学校
											</th>
											<th >
											    性别
											</th>
											
										     <th >
												 出生年月
											</th>
											<th >
												 家长姓名
											</th>
											<th style="width: 10%">
												 家长联系电话
											</th>
											<th >
												 家庭住址
											</th>
											<th>
												 意向
											</th>
											
											<th >
												 操作
											</th>
									</tr>  
									</thead>
									
									<tbody>
										<c:forEach items="${list}" var="obj">
											<tr>
												<td class="center">
													${obj.intenid }
												</td>
												<td class="center">
													${obj.intenname }
												</td>
													<td class="center">
													${obj.intplace }
												</td>
													<td class="center">
													${obj.intemail}
												</td>
												<td class="center">
													${obj.intensch }
												</td>
												<td class="center">
													${obj.intensex }
												</td>
											    <td class="center">
													${obj.intenbir }
												</td>
												<td class="center">
													${obj.intenfat }
												</td>
												 <td class="center" style="width: 10%">
													${obj.intenfatel }
												</td>
												<td class="center">
													${obj.intenaddr }
												</td>
											
												<td class="center" >
													<c:if test="${obj.intenstatus=='有' }">	<span class="label label-success">${obj.intenstatus }</span></c:if>
														<c:if test="${obj.intenstatus=='无' }">	<span class="label label-danger">${obj.intenstatus }</span></c:if>
															<c:if test="${obj.intenstatus=='未知' }"><span class="label-warning label label-default">	${obj.intenstatus }</span></c:if>
												</td>
												<td>
												<c:if test="${obj.intenstatus=='未知' }">
													<a class="btn btn-success" href="zz/a1.action?id=${obj.intenid }" > <i
														class="glyphicon glyphicon-edit icon-white"></i> 预报 </a>
													<a class="btn btn-danger" href="zz/a2.action?id=${obj.intenid }"> <i
														class="glyphicon glyphicon-trash icon-white"></i> 不预报 </a>
												</c:if>
												
												
												
												</td>
											</tr>
										</c:forEach>
																
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<!--/span-->
					</div>
				
					</div>
					<!--/row-->

					<!-- content ends -->
				</div>
				<!--/#content.col-md-0-->
			
	</body>
</html>
