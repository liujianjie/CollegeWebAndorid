<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

				<noscript>
					<div class="alert alert-block col-md-12">
						<h4 class="alert-heading">
							Warning!
						</h4>

						<p>
							You need to have
							<a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
							enabled to use this site.
						</p>
					</div>
				</noscript>

				<div id="content" class="col-lg-10 col-sm-10" style="width:100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
								<li>
								<a href="homepage(tea).jsp">首页</a>
							</li>
							<li>
								<a href="#">部门信息</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 部门信息
									</h2>

								</div>
								<div class="box-content">
									<div class="alert alert-info" style="
										    padding-top: 7px;
										    border-bottom-width: 0px;
										    padding-bottom: 7px;
										    width: 1020px;
										    height: 52px;
										    padding-left: 905px;
										    border-top-width: 1px;
										">
										<a class="btn btn-success" href="liulirong/manlist.action"> <i
											class="glyphicon glyphicon-pencil"></i> 添加部门 </a>
									</div>
									<table
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th>
													序号
												</th>
												<th>
													部门名称
												</th>
												<th>
													创建时间
												</th>
												<th>
													部门负责人
												</th>
												<th>
													校主管
												</th>
												<th width="20%">
													操作
												</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${list}" var="dept">
												<tr>
													<td>
														${dept.did }
													</td>
													<td class="center">
														${dept.dname }
													</td>
													<td class="center">
														<fmt:formatDate value="${dept.createtime }" pattern="yyyy-MM-dd"/>
														
													</td>
													<td class="center">
														<c:forEach items="${mlist}" var="m">
														${dept.deptman==m.dmid?m.dmname:'' }
														</c:forEach>
													</td>
													<td class="center">
														<c:forEach items="${mlist}" var="m">
														${dept.king==m.dmid?m.dmname:'' }
														</c:forEach>
													</td>
													<td class="center">
														<a class="btn btn-primary" href="liulirong/getdept?dept.did=${dept.did }"> <i
															class="glyphicon glyphicon-edit icon-white"></i> 编辑 </a>
														<a class="btn btn-danger" href="liulirong/deptdel?dept.did=${dept.did }"> <i
															class="glyphicon glyphicon-trash icon-white"></i> 删除 </a>
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
