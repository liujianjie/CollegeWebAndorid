<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

				<div id="content" class="col-lg-10 col-sm-10" style="width: 100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="homepage(tea).jsp">首页</a>
							</li>
							<li>
								<a href="#">宿舍巡查</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 宿舍巡查
									</h2>

								</div>
								<div class="box-content">
									<table
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th>
													巡查编号
												</th>
												<th>
													巡查时间
												</th>
												<th>
													寝室编号
												</th>
												<th width="8%">
													巡查人
												</th>
												<th>
													卫生情况
												</th>
												<th>
													寝室情况
												</th>
											</tr>
										</thead> 
										<tbody>
											<c:forEach items="${rlist}" var="sr">
												<tr>
													<td>
														${sr.srid }
													</td>
													<td class="center">
														<fmt:formatDate value="${sr.srdate }" pattern="yyyy-MM-dd"/>
														
													</td>
													<td class="center">
														<c:forEach items="${room}" var="r">
															${sr.rooms == r.hourid?r.hourname:'' }
														</c:forEach>
													</td>
													<td class="center">
														<c:forEach items="${elist}" var="e">
															${sr.empid==e.eid?e.ename:'' }
														</c:forEach>
														
													</td>
													<td class="center">
														${sr.srclean }
													</td>
													<td class="center">
														${sr.srdesc }
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
