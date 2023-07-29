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
								<a href="#">宿舍管理</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 宿舍信息
									</h2>

								</div>
								<div class="box-content">
									<div class="alert alert-info" style="height: 70px;">
										<div style="float: left; width: 52%; clear: right">
											<a class="btn btn-success" href="student/elelist.jsp"><i
												class="glyphicon glyphicon-pencil"></i> 单元信息管理</a>
										</div>
										<div style="float: left; width: 48%; margin-top: 0px">
											<a class="btn btn-success" href="hourse/hrstoadd"><i
												class="glyphicon glyphicon-pencil"></i> 添加宿舍房间</a>
										</div>
									</div>

									<table id="table"
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th>
													<div style="text-align: center;">
														序号
													</div>
												</th>
												<th>
													<div style="text-align: center;">
														单元
													</div>
												</th>
												<th>
													<div style="text-align: center;">
														房间号
													</div>
												</th>
												<th>
													<div style="text-align: center;">
														宿舍长
													</div>
												</th>
												<th>
													<div style="text-align: center;">
														人数
													</div>
												</th>
												<th>
													<div style="text-align: center;">
														状态
													</div>
												</th>
												<th>
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
											<c:forEach items="${list}" var="hrs">
												<tr>
													<td width="8%">
														<div style="text-align: center;">
															<%=i%>
														</div>
													</td>
													<td class="center" width="15%">
														<div style="text-align: center;">
															${hrs.elements.ename}
														</div>
													</td>
													<td class="center" width="15%">
														<div style="text-align: center;">
															${hrs.hourname}
														</div>

													</td>
													<td class="center" width="15%">
														<div style="text-align: center;">
															<!-- 找出寝室长 -->
															<c:forEach items="${hrs.student}" var="stu">
																<c:if test="${stu.intenid==hrs.hhead }"> ${stu.intenname }
														</c:if>
															</c:forEach>
														</div>
													</td>
													<td class="center" width="15%">
														<div style="text-align: center;">
															<!-- 来找出这个宿舍有多少人住 -->
															<%
																int j = 0;
															%>
															<c:forEach items="${hrs.student}" var="stu">
																<%
																	j++;
																%>
															</c:forEach>
															<%=j%>/${hrs.hnumber}
															<%
																//保存值来得到状态
																	pageContext.setAttribute("ren", j + "");
															%>
														</div>
													</td>
													<td class="center" width="15%">
														<div style="text-align: center;">
															<c:if test="${hrs.hnumber>ren}">
															 <span class="label label-default">
														未满</span>
													</c:if>
															<c:if test="${hrs.hnumber<=ren}">
																<span class="label label-danger">已满</span>
															</c:if>
														</div>
													</td>
													<td class="center" width="25%">
														<div style="text-align: center;">
															<!-- 修改则把这个房间的人都找出来 赋予寝室长位置 -->
															<a class="btn btn-primary"
																href="hourse/hrstoalert?hourid=${hrs.hourid }"> <i
																class="glyphicon glyphicon-edit icon-white"></i> 编辑 </a>
															<a class="btn btn-danger"
																href="hourse/hrsdel?hourid=${hrs.hourid }"> <i
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
