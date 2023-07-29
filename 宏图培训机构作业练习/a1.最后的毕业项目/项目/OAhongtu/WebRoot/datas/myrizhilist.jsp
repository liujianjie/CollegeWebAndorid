<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rizhilist.jsp' starting page</title>
    
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


				<div id="content" class="col-lg-10 col-sm-10" style="width:100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
								<li>
								<a href="homepage(tea).jsp">首页</a>
							</li>
							<li>
								<a href="#">日志管理</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 日志管理
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
										<a class="btn btn-success" href="datas/rizhi.jsp"> <i
															class="glyphicon glyphicon-pencil"></i> 添加日志 </a>
									</div>
									<table
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th width="7%">
													序号
												</th>
												<th>
													日志时间
												</th>
												<th>
													填写人
												</th>
												<th>
													日志内容
												</th>
												<th>
													今日问题
												</th>
												
												<th width="19%">
													操作
												</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${Elist}" var="r">
												<tr>
													<td>
														${r.RID }
													</td>
													<td class="center">
														${r.RDATE}
													</td>
													<td class="center">
														<c:forEach items="${list}" var="e">
															${r.EID==e.eid?e.ename:'' }
														</c:forEach>
														
													</td>
													<td class="center">
														${r.RDESC }
													</td>
													<td class="center">
														${r.RQUES }
													</td>
													<td class="center">
														<a class="btn btn-primary" href="liulirong/fromrizhi?rizhi.rid=${r.rid }"> <i
															class="glyphicon glyphicon-edit icon-white"></i> 编辑 </a>
														<a class="btn btn-danger" href="liulirong/rizhidel?rizhi.rid=${r.rid }"> <i
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
