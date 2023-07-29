<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!-- 回复 -->

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

				<div id="content" class="col-lg-10 col-sm-10" style="width:100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="#">学生管理</a>
							</li>
							<li>
								<a href="#">意见反馈管理</a>
							</li>
							
						</ul>
					</div>
					
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i>
										你的意见列表
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i>
										</a>
										<a href="#" class="btn btn-close btn-round btn-default"><i
											class="glyphicon glyphicon-remove"></i>
										</a>
									</div>
								</div>
								
								<div class="box-content">
									<div class="alert alert-info" style="height: 70px;">
										<!-- 添加是给学生看的 -->
										<a class="btn btn-success" href="sbk/sbktoadd"> <i
												class="glyphicon glyphicon-pencil"></i>添加意见反馈</a>				
									</div>
									<form name="frm" action="score/scoalert" method="post">
									<table id="table"
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th width="10%">
													序号
												</th>
												<th width="13%">
													查看人
												</th>
												<th width="17%"> 
													意见标题
												</th>
												<th width="30%">
													意见内容
												</th>
												
												<th width="30%">
													回复内容
												</th>
											</tr>
										</thead>
										<tbody>
										<%int i=1; %>
										<c:forEach items="${list}" var="sbk">
											<tr title="${sbk.SDATE  }">
												<td >
													<%=i %>
												</td>
												<td class="center">
													<!-- 判断有没有回复 -->
													<c:forEach items="${emplist}" var="emp">
														<c:if test="${emp.eid==sbk.SEMPID}">
															${emp.ename }
														</c:if>
													</c:forEach>
													<c:if test="${sbk.SEMPID==null}">对方已拒绝查看</c:if>
												</td>
											
												<td class="center">
													${sbk.SBACKTITLE }
												</td>
												<td class="center">
													${sbk.SBACKCON }
												</td>
												<td>
													<!-- 判断有没有回复 -->
													<c:forEach items="${rlylist}" var="rly">
														<c:if test="${rly.sbackid==sbk.SBACKID}">
															${rly.rcon }
														</c:if>
													</c:forEach>
													<c:if test="${sbk.SEMPID==null}">
														<a class="btn btn-danger"
																href="sbk/sbkdel?sbackid=${sbk.SBACKID }"> <i
																class="glyphicon glyphicon-trash icon-white"></i> 删除 </a>
													</c:if>
												</td>
											</tr>
											<%i++; %>									
										</c:forEach>
										</tbody>
									</table>
									
									</form>
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

