<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<c:if test="${addtolist==1}">
			<jsp:include page="tou.jsp"></jsp:include>
		</c:if>
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
								<a>学生信息管理</a>
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
									<div class="alert alert-info" style="height: 70px">
										<div style="float: left; width: 52%; clear: right">
											<form action=${addtolist==1?"stu/list?addtolist=1":"stu/list"} method="post" name="frms">
												<label for="exampleInputEmail1">
													班级
												</label>
												<select id="selectError" data-rel="chosen" name="classid"
													style="width: 100px;">
													<c:forEach items="${clslist}" var="cls">
														<option value="${cls.CLASSID }"
															${cls.CLASSID==classes.classid?"selected":""}>
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
											<button type="button" id="btn" class="btn btn-success">
												<i class="glyphicon glyphicon-pencil"></i>添加学生
											</button>
										</div>
									</div>
									<a href="stu/toadd1" id="link" target="_blank"
										style="display: none">添加学生</a>
									<script type="text/javascript">
											document.getElementById("btn").onclick=function(){
　　												document.getElementById("link").click();
											}
										</script>
									<hr>

									<c:if test="${size!=0}">
										<table id="table"
											class="table table-striped table-bordered bootstrap-datatable datatable responsive">
											<thead>
												<!-- 这里显示除去查找能查到的信息或者简单的信息 外的信息 -->
												<!-- 比如 班级、爱好、家庭住址、就读疑问、头像、状态、入学信息 -->
												<tr>
													<th>
														<div style="text-align: center;">
															序号
														</div>
													</th>
													<th>
														<div style="text-align: center;">
															姓名
														</div>
													</th>
													<th>
														<div style="text-align: center;">
															性别
														</div>
													</th>
													<th>
														<div style="text-align: center;">
															年龄
														</div>
													</th>
													<th>
														<div style="text-align: center;">
															生日
														</div>
													</th>
													<th>
														<div style="text-align: center;">
															家长姓名
														</div>
													</th>
													<th>
														<div style="text-align: center;">
															联系电话
														</div>
													</th>
													<th>
														<div style="text-align: center;">
															家长联系电话
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
												<c:forEach items="${list}" var="stu">
													<tr>
														<td width="5%">
															<div style="text-align: center;">
																<%=i%>
															</div>
														</td>
														<td width="8%">
															<div style="text-align: center;">
																${stu.INTENNAME }
															</div>

														</td>
														<td class="center" width="5%">
															<div style="text-align: center;">
																${stu.INTENSEX }
															</div>
														</td>
														<td class="center" width="5%">
															<div style="text-align: center;">
																${stu.INTENAGE }
															</div>
														</td>
														<td class="center" width="12%">
															<div style="text-align: center;">
																${stu.INTENBIR }
															</div>
														</td>
														<td class="center" width="8%">
															<div style="text-align: center;">
																${stu.INTENFAT }
															</div>
														</td>
														<td class="center" width="14%">
															<div style="text-align: center;">
																${stu.INTENTEL }
															</div>
														</td>
														<td class="center" width="14%">
															<div style="text-align: center;">
																${stu.INTENFATEL }
															</div>
														</td>
														<td class="center" width="25%">
															<div style="text-align: center;">
																<a class="btn btn-success"
																	href="stu/seldan?intenid=${stu.INTENID }"> <i
																	class="glyphicon glyphicon-zoom-in icon-white"></i> 详情
																</a>
																<a class="btn btn-primary"
																	href="stu/toalert?intenid=${stu.INTENID }"> <i
																	class="glyphicon glyphicon-edit icon-white"></i> 编辑 </a>
																<a class="btn btn-danger"
																	href="stu/del?intenid=${stu.INTENID }&classid=${stu.CLASSID }"> <i
																	class="glyphicon glyphicon-trash icon-white"></i> 删除 </a>
															</div>
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
