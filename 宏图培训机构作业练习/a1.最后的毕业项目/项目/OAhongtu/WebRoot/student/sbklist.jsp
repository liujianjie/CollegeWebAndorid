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
								<a href="homepage(tea).jsp">首页</a>
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
										未处理的学生意见反馈
									</h2>

								</div>
								
								<div class="box-content">
									<div class="alert alert-info"  style="height:70px">
										<!-- 给老师看的 -->
										<a class="btn btn-success" href="sbk/sbklist2"> <i
											class="glyphicon glyphicon-zoom-in icon-white"></i> 已回复的反馈列表 </a>
										<a class="btn btn-success" href="sbk/sbklist3"> <i
											class="glyphicon glyphicon-zoom-in icon-white"></i> 不显示的反馈列表 </a>
									</div>
									<form name="frm" action="score/scoalert" method="post">
									<table id="table"
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th>
													序号
												</th>
												<th>
													姓名
												</th>
												<th>
													意见标题
												</th>
												<th>
													意见内容
												</th>
												<th>
													操作
												</th>
											</tr>
										</thead>
										<tbody>
										<%int i=1; %>
										<c:forEach items="${list}" var="sbk">
											<tr title="反馈时间:${sbk.SDATE }">
												<td width="10%">
													<%=i %>
												</td>
												<td class="center" width="10%">
													${sbk.INTENNAME }
												</td>
											
												<td class="center" width="25%">
													${sbk.SBACKTITLE }
												</td>
												<td class="center" width="35%">
													${sbk.SBACKCON }
												</td>
												<td class="center" width="20%">
													<a class="btn btn-primary"  href="sbk/toreply?sbackid=${sbk.SBACKID }"> <i
														class="glyphicon glyphicon-edit icon-white"></i> 回复 </a>
													
													<a class="btn btn-success" href="sbk/nodisplay?sbackid=${sbk.SBACKID }"> <i
														class="glyphicon glyphicon-zoom-in icon-white"></i>不显示 </a>
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

