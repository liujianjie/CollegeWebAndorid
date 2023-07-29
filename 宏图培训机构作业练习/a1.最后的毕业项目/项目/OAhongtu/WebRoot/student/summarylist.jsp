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
								<a href="homepage(tea).jsp">首页</a>
							</li>
							<li>
								<a href="#">学生毕业总结管理</a>
							</li>

						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> ${classname }学生总结
									</h2>

								</div>

								<div class="box-content">
									<div class="alert alert-info" style="height: 70px">
										<div style="float: left; width: 52%; clear: right">
											<form action="summary/smylist" method="post" name="frms">
												<label for="exampleInputEmail1">
													<b>班级</b>
												</label>
												<select id="selectError" data-rel="chosen" name="classid"
													style="width: 100px;">
													<c:forEach items="${clslist}" var="cls">
														<option value="${cls.CLASSID }" ${cls.CLASSID==classid?"selected":"" }>
															${cls.CLASSNAME }
														</option>
													</c:forEach>
												</select>
												<button type="submit" class="btn btn-success">
													<i class="glyphicon glyphicon-zoom-in icon-white"></i>查询
												</button>
											</form>
										</div>
										<div style="float: left; width: 48%; margin-top: 0px">
											<form action="summary/smytoadd" method="post" name="frm1">
												<label for="exampleInputEmail1">
													<b>班级</b>
												</label>
												<select id="selectError" data-rel="chosen" name="classid"
													style="width: 100px; margin-top: 0px">
													<c:forEach items="${clslist}" var="cls">
														<option value="${cls.CLASSID }" ${cls.CLASSID==classid?"selected":"" }>
															${cls.CLASSNAME }
														</option>
													</c:forEach>
												</select>
												<a class="btn btn-success"
													onclick="javascript:document.frm1.submit();"> <i
													class="glyphicon glyphicon-pencil"></i>添加毕业总结 </a>
											</form>
										</div>
									</div>

									<hr>
									<c:if test="${list!=null}">
										<form name="frm" action="summary/smylist" method="post">
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
																学生姓名
															</div>
														</th>
														<th>
															<div style="text-align: center;">
																总结语
															</div>
														</th>

														<th>
															<div style="text-align: center;">
																总结人
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
													<c:forEach items="${list}" var="smy">

														<tr>
															<td width="7%">
																<div style="text-align: center;">
																	<%=i%>
																</div>
															</td>

															<td class="center" width="10%">
																<div style="text-align: center;">
																	${smy.INTENNAME }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																	${smy.SSAY }
																</div>
															</td>
															<td class="center" width="10%">
																<div style="text-align: center;">
																	${smy.ENAME }
																</div>
															</td>

															<td class="center" width="10%">
																<div style="text-align: center;">
																	<!-- 修改 -->
																	<a class="btn btn-primary"
																		href="summary/smytoalert?sids=${smy.SIDS }&classid=${smy.CLASSID}">
																		<i class="glyphicon glyphicon-edit icon-white"></i> 编辑
																	</a>
																</div>
															</td>
														</tr>
														<%
															i++;
														%>
													</c:forEach>
												</tbody>
											</table>
										</form>
									</c:if>
									<c:if test="${list==null}">
										<b>这个班的学生总结不存在,你可以添加</b>
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

