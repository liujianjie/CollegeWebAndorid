<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'deptmans.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

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
								<a href="homepage(tea).jsp">首页</a>
							</li>
							<li>
								<a href="javascript:history.go(-1);">返回上一页</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 部门负责人信息
									</h2>

								</div>
								<div class="box-content">
									<div class="alert alert-info" style="
										    padding-top: 7px;
										    border-bottom-width: 0px;
										    padding-bottom: 7px;
										    width: 1020px;
										    height: 52px;
										    padding-left: 10px;
										    border-top-width: 1px;
										">
										<label >选择部门负责人: </label>
										<div class="controls"  style="height:30px;width:300px;display: inline-block;margin-bottom: 0;vertical-align:middle;margin-left:20px">
											<select name="dept.deptman" data-rel="chosen" style="width:220px;">
												<c:forEach items="${elist}" var="e">
													<option value="${e.eid }">${e.ename }</option>	
												</c:forEach>							
											</select>
										</div>
										<div class="controls" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align:middle;margin-left:405px">
											<a class="btn btn-success" href="liulirong/manlist.action"> <i
															class="glyphicon glyphicon-zoom-in icon-white"></i> 添加部门负责人 </a>
										</div>
									</div>
								
									<table
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th>
													员工ID
												</th>
												<th>
													部门名称
												</th> 
												<th>
													部门负责人
												</th>
												<th width="20%">
													操作
												</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${dmlist}" var="dm">
												<tr>
													<td>
														${dm.dmid }
													</td>
													<td class="center">
														<c:forEach items="${list}" var="e">
															${dm.dmid==e.deptman?e.dname:'' }
														</c:forEach>
													</td>
													<td class="center">
														${dm.dmname }
													</td>
													<td class="center">
														<a class="btn btn-danger"
															href="liulirong/deptmandel?mans.dmid=${dm.dmid }"> <i
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
			</div>
		</div>

	</body>
</html>
