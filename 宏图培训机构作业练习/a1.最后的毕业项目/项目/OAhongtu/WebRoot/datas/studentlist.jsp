<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

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
								<a href="#">学生权限管理</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i>
										<c:if test="${classid==null}">
											学生信息
										</c:if>
										<c:if test="${classid!=null}">
											${classes.classname }学生信息
										</c:if>
									</h2>

								</div>
								<div class="box-content">
								<div class="alert alert-info" style="height: 70px;">
										<a class="btn btn-success" href="student/stuadd.jsp" target="_blank" style="float: right;"> <i
															class="glyphicon glyphicon-pencil"></i> 添加学生 </a>
									</div>
									<!-- 筛选字段 -->
									<form action="stu/list" method="post" name="frms">
										<div class="box-content">
											<label for="exampleInputEmail1">
												班级：
											</label>
											<select id="selectError" data-rel="chosen" name="classid" style="width:140px;">
											<option>--请选择班级--</option>
												<c:forEach items="${clslist}" var="cls">
												
													<option value="${cls.classid }"  ${cls.classid==classes.classid?"selected":""}>
														${cls.classname }
													</option>
												</c:forEach>								
											</select>
											<button type="submit" class="btn btn-default"
													style="width: 85px; margin-left: 6px; margin-top: 0px;">
													<b>查 询</b>
												</button>
										</div>
									</form>	
									<hr>
									<c:if test="${size!=0}">
									<table id="table"
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
										<!-- 这里显示除去查找能查到的信息或者简单的信息 外的信息 -->
										<!-- 比如 班级、爱好、家庭住址、就读疑问、头像、状态、入学信息 -->
											<tr>
												<th>
													序号												
												</th>
												<th>
													姓名
												</th>
												<th>
													性别
												</th>
												<th>
													年龄
												</th>
												<th>
													班级 
												</th>
												<th>
													家长姓名
												</th>
												<th>
													联系电话
												</th>
												<th>
													家长联系电话
												</th>
												<th>
													操作
												</th>
											</tr>
										</thead>
										<tbody>
										<%int i=1; %>
										<c:forEach items="${stulist}" var="stu">
											<tr>
											<td width="5%">
													<%=i %>
												</td>
												
												<td width="8%">
													${stu.INTENNAME }
													
												</td>
												<td class="center" width="7%">
													${stu.INTENSEX }
													
												</td>
												<td class="center" width="7%">
													${stu.INTENAGE }
												
												</td>
												<td class="center" width="10%">
													<c:forEach items="${clalist}" var="cla">
														${cla.CLASSID == stu.CLASSID ? cla.CLASSNAME:'' }
													</c:forEach>
													
												</td>
												<td class="center" width="8%">
													${stu.INTENFAT }
													
												</td>
												<td class="center" width="14%"> 
													${stu.INTENTEL }
												
												</td>
												<td class="center" width="14%">
													${stu.INTENFATEL }
												
												</td>
												<td class="center" width="15%">
													<a class="btn btn-success" href="liulirong/emp!sturoot?stuid=${stu.INTENID }"> <i
														class="glyphicon glyphicon-zoom-in icon-white"></i> 权限管理 </a>
												</td>
											</tr>
											<%i++; %>
										</c:forEach>
										</tbody>
									</table>
									</c:if>
									<c:if test="${size==0}">
										<b>这个班没有学生，你可以添加</b>
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
