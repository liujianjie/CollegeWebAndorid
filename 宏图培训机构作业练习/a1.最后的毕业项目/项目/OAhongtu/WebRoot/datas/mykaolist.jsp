<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
								<a href="#">我的考勤</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 考勤信息
									</h2>

								</div>
								<div class="box-content">
									<table
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th width="8%">
													序号
												</th>
												<th>
													时间
												</th>
												<th>
													原因
												</th>
												<th>
													直属领导
												</th>
												<th>
													状态
												</th>
												
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${list}" var="kao">
												<tr>
													<td>
														${kao.KID }
													</td>
													<td class="center">
														<fmt:formatDate value="${kao.KDATE }" pattern="yyyy-MM-dd"/>
													</td>
													<td class="center">
														${kao.KRESION }
													</td>
													<td class="center">
														<c:forEach items="${emplist }" var="e">
															${kao.KSID ==e.DMID?e.DMNAME:'' }
														</c:forEach>
													</td>
													<td class="center">
														${kao.KSTATU ==0?' <span class="label label-warning">反馈中</span>':''}
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
			</div>
		

	</body>
</html>
