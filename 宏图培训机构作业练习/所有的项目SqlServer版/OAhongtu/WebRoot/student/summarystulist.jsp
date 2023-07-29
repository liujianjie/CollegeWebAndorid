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

				<div id="content" class="col-lg-10 col-sm-10" style="width: 100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a>学生管理</a>
							</li>
							<li>
								<a href="smy/smysx">学生毕业总结管理</a>
							</li>

						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12" >
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-user""></i> 你的毕业总结
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i> </a>
										<a href="#" class="btn btn-close btn-round btn-default"><i
											class="glyphicon glyphicon-remove"></i> </a>
									</div>
								</div>

								<div class="box-content">
									<div class="alert alert-info" style="height:50px">

									</div>

									<hr>
									<c:if test="${list!=null}">

										<table id="table"
											class="table table-striped table-bordered bootstrap-datatable datatable responsive">
											<thead>
												<tr>
													<th>
														序号
													</th>

													<th>
														学生姓名
													</th>
													<th>
														总结语
													</th>

													<th>
														总结人
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
															<%=i%>
														</td>

														<td class="center" width="12%">
															${smy.INTENNAME }
														</td>
														<td class="center">
															${smy.SSAY }
														</td>
														<td class="center" width="17%">
															${smy.ENAME }
														</td>

													</tr>
													<%
														i++;
													%>
												</c:forEach>
											</tbody>
										</table>
										
									</c:if>
									<c:if test="${list==null}">
										<b>你的学生总结不存在</b>
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

