<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
								<a href="homepage2.jsp">首页</a>
							</li>
							<li>
								<a href="#">谈心记录管理</a>
							</li>

						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i>
										你的谈心记录
									</h2>

								</div>

								<div class="box-content">
									<div class="alert alert-info" style="height:50px">

									</div>

									<hr>
									<c:if test="${size!=0}">

										<table id="table"
											class="table table-striped table-bordered bootstrap-datatable datatable responsive">
											<thead>
												<tr>
													<th width="7%">
														序号
													</th>

													<th width="7%">
														策划人
													</th>
													<th width="15%">
														谈心标题
													</th>
													<th width="30%">
														谈心内容
													</th>
													<th width="30%">
														反馈
													</th>
													<th width="10%">
														操作
													</th>
												</tr>
											</thead>
											<tbody>
												<%
													int i = 1;
												%>
												<c:forEach items="${sayslist}" var="says">

													<tr title="谈心时间:${says.SAYDATE }">
														<td width="7%">
															<%=i%>
														</td>

														<td class="center" width="10%">
															<c:forEach items="${teaches}" var="tea">
																<c:if test="${tea.eid==says.SAYEMPID}">
																	${tea.ename }
																</c:if>
															
															</c:forEach>
														</td>
														<td class="center">
															${says.SAYSCON }
														</td>
														<td class="center">
															${says.SAYSPRO }
														</td>
														<td class="center">
															${says.SAYBACK }
														</td>
<!--														<td class="center">-->
<!--															${says.SAYDATE }-->
<!--														</td>-->
														<td class="center" width="10%">
															<!-- 一个修改一个反馈 -->
															<c:if test="${says.SAYBACK==null}">
																<a class="btn btn-primary"
																href="says/saystofankui?sayid=${says.SAYID }"> <i
																class="glyphicon glyphicon-edit icon-white"></i> 反馈 </a>
															</c:if>
															<!-- 一个修改一个反馈 -->
															<c:if test="${says.SAYBACK!=null}">
																<a class="btn btn-primary"
																href="says/saystoalert2?sayid=${says.SAYID }"> <i
																class="glyphicon glyphicon-edit icon-white"></i> 修改 </a>
															</c:if>
														</td>

													</tr>
													<%
														i++;
													%>
												</c:forEach>
											</tbody>
										</table>

									</c:if>
									<c:if test="${size==0}">
										<b>你还暂时还没有谈心记录</b>
									</c:if>
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

