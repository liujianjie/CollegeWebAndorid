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
								<a href="#">值班安排</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 值班安排
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
									</div>
									<table
										class="table table-striped table-bordered">
										<thead>
											<tr>
												<th>
													序号
												</th>
												<th>
													时间
												</th>
												<th>
													值班老师
												</th>
												<th>
													值班范围
												</th>
												<th>
													值班老师
												</th>
												<th>
													值班范围
												</th>
												<th>
													值班班主任
												</th>
												<th>
													总值班
												</th>
												<th>
													操作
												</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${list}" var="z">
												<tr>
													<td>
														${z.zid}
													</td>
													<td>
														${z.zdate}
														
													</td>
													<td class="center">
														${z.zteach1}
													</td>
													<td class="center">
														${z.zfanwei1 }
													</td>
													<td class="center">
														${z.zteach2 }
													</td>
													<td class="center">
														${z.zfanwei2 }
													</td>
													<td class="center">
														${z.teachs }
													</td>
													<td class="center">
														${z.zteachers }
													</td>
													<td class="center">
														<a class="btn btn-primary" href="liulirong/exam!toupd_zhiban.action?id=${z.zid}"> <i
															class="glyphicon glyphicon-edit icon-white"></i> 编辑 </a>
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
