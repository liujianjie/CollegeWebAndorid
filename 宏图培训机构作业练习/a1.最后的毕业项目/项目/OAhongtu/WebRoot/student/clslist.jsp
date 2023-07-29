<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
								<a href="#">班级管理</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 班级信息
									</h2>

								</div>
								<div class="box-content">
									<div class="alert alert-info" style="height: 70px;">
										<a class="btn btn-success" href="classes/clstoadd"> <i
											class="glyphicon glyphicon-pencil"></i> 添加班级信息 </a>
									</div>
									<table id="table"
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th width="10%">
													<div style="text-align: center;">
														序号
													</div>
												</th>
												<th width="10%">
													<div style="text-align: center;">
														班级名
													</div>
												</th>
												<th width="10%">
													<div style="text-align: center;">
														班级人数
													</div>
												</th>
												<th  width="10%">
													<div style="text-align: center;">
														任课老师
													</div>
												</th>
												<th  width="10%">
													<div style="text-align: center;">
														辅导老师
													</div>
												</th>
												<th width="10%">
													<div style="text-align: center;">
														班主任
													</div>
												</th>
												<th width="20%">
													<div style="text-align: center;">
														班级位置
													</div>
												</th>
												<th width="20%">
													<div style="text-align: center;">
														操作
													</div>
												</th>
											</tr>
										</thead>
										<tbody>
											<%
												int i = 1;
											%>
											<c:forEach items="${list}" var="cls">
												<tr>
													<td>
														<div style="text-align: center;">
															<%=i%>
														</div>
													</td>
													<td class="center">
														<div style="text-align: center;">
															${cls.classname}
														</div>
													</td>
													<td class="center">
														<div style="text-align: center;">
															<%
																int j = 0;
															%>
															<c:forEach items="${cls.student}" var="stu">
																<%
																	j++;
																%>
															</c:forEach>
															<%=j%>/${cls.classcount }
														</div>
													</td>
													<td class="center" width="10%">
														<div style="text-align: center;">
															<!-- 任课老师 -->
															<c:forEach items="${emplist}" var="emp">
																<c:if test="${emp.eid==cls.empteach}">
															${emp.ename }
														</c:if>
															</c:forEach>
														</div>
													</td>
													<td class="center">
														<div style="text-align: center;">
															<!-- 辅导老师 -->
															<c:forEach items="${emplist}" var="emp">
																<c:if test="${emp.eid==cls.empteachs}">
															${emp.ename }
														</c:if>
															</c:forEach>
														</div>
													</td>
													<td class="center">
														<div style="text-align: center;">
															<!-- 班主任老师 -->
															<c:forEach items="${emplist}" var="emp">
																<c:if test="${emp.eid==cls.empteaches}">
															${emp.ename }
														</c:if>
															</c:forEach>
														</div>
													</td>
													<td class="center">
														<div style="text-align: center;">
															<!--位置 -->
															${cls.classaddr }
														</div>
													</td>
													<td class="center">
														<div style="text-align: center;">
															<!-- 修改 -->
															<a class="btn btn-primary"
																href="classes/clstoalert?classid=${cls.classid }"> <i
																class="glyphicon glyphicon-edit icon-white"></i> 编辑 </a>
															<a class="btn btn-danger"
																href="classes/clsdel?classid=${cls.classid }"> <i
																class="glyphicon glyphicon-trash icon-white"></i> 删除 </a>
														</div>
													</td>
												</tr>
												<%
													i++;
												%>
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
		<!--/fluid-row-->

	</body>
</html>
