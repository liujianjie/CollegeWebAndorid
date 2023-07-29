<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!-- 未处理 -->

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


				<div id="content" class="col-lg-10 col-sm-10" style="width:100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
						<li>
								<a href="homepage2.jsp">首页</a>
							</li>
							<li>
								<a href="#">请假管理</a>
							</li>
							
						</ul>
					</div>
					
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i>
										你的请假列表
									</h2>

								</div>
								
								<div class="box-content">
									<div class="alert alert-info" style="height: 70px;">
										<a class="btn btn-success" href="lev/levtoadd?intenid=${student.intenid }"> <i
											class="glyphicon glyphicon-pencil"></i> 申请请假 </a>
									</div>
									<hr>
									<table id="table"
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th>
													序号
												</th>
												
												<th>
													请假理由
												</th>
												<th>
													开始时间
												</th>
												<th>
													结束时间
												</th>
												<th>
													天数
												</th>
												
												<th>
													状态
												</th>
												<th>
													操作
												</th>
											</tr>
										</thead>
										<tbody>
										<%int i=1; %>
										<c:forEach items="${list}" var="lev">
											<tr title="申请时间:${lev.LDATE }">
												<td width="5%">
													<%=i %>
												</td>
												
												<td class="center" width="30%">
													${lev.LNAME }
												</td>
												<td class="center" width="10%">
													${lev.LSTARTTIME }
												</td>
												<td class="center" width="10%">
													${lev.LENDTIME }
												</td>
												<td class="center" width="5%">
													${lev.LTIME }
												</td>
												<td class="center" width="7%">
													<c:if test="${lev.LSTATE==0}">
														<span class="label-default label">未提交</span>
													</c:if>
													<c:if test="${lev.LSTATE==1}">
														<span class="label-warning label label-default">审核中</span>
													</c:if>
													<c:if test="${lev.LSTATE==2}">
														<span class="label label-danger">不同意</span>
													</c:if>
													<c:if test="${lev.LSTATE==3}">
														<span class="label label-success">同意</span>
													</c:if>
												</td>
												<td class="center" width="23%">
													<!-- 为提交 -->
													<c:if test="${lev.LSTATE==0}">
														<a class="btn btn-success" href="lev/levstatus2?lid=${lev.LID }&lstate=1&lstushr=${lev.LSHR }"> <i
														 class="glyphicon glyphicon-zoom-in icon-white"></i> 提交 </a>
														<a class="btn btn-primary" href="lev/levtoalert?lid=${lev.LID }"" > <i
															class="glyphicon glyphicon-edit icon-white"></i> 修改 </a>
														<a class="btn btn-danger" href="lev/levdel?lid=${lev.LID }"> <i
														class="glyphicon glyphicon-trash icon-white"></i> 删除 </a>
														
													</c:if>
													
												</td>
											</tr>
											<%i++; %>									
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

