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
		<style>
		　　.div-a {
			float: left;
			width: 49%;
			border: 1px solid #F00
		}
		
		　　.div-b {
			float: left;
			width: 49%;
			border: 1px solid #000
		}
　　
</style>
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
								<a href="score/scosx">学生就业管理</a>
							</li>

						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 就业情况
									</h2>

								</div>

								<div class="box-content">
									<div class="alert alert-info" style="height: 70px">
										<div style="float: left; width: 52%; clear: right">
											<form action="job/joblist" method="post" name="frms">
												<label for="exampleInputEmail1">
													<b>班级</b>
												</label>
												<select name="classid" id="selectError" data-rel="chosen"
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
											<form action="job/jobtoadd" method="post" name="frm1">
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
													class="glyphicon glyphicon-pencil"></i> 添加学生就业 </a>

											</form>
										</div>
									</div>

									<hr>
									<c:if test="${joblist!=null}">
										<form name="frm" action="score/scoalert" method="post">
											<table id="table"
												class="table table-striped table-bordered bootstrap-datatable datatable responsive">
												<thead>
													<tr>
														<th width="5%">
															<div style="text-align: center;">
																序号
															</div>
														</th>

														<th width="8%">
															<div style="text-align: center;">
																学生姓名
															</div>
														</th>
														<th width="8%">
															<div style="text-align: center;">
																联系电话
															</div>
														</th>
														<th width="8%">
															<div style="text-align: center;">
																职位
															</div>
														</th>
														<th width="8%">
															<div style="text-align: center;">
																薪水
															</div>
														</th>
														<th width="8%">
															<div style="text-align: center;">
																地点
															</div>
														</th>

														<th width="20%">
															<div style="text-align: center;">
																备注
															</div>
														</th>
														<th width="8%">
															<div style="text-align: center;">
																记录人
															</div>
														</th>
														<th width="20%">
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
													<c:forEach items="${joblist}" var="job">
														<tr title="记录时间:${job.JOBDATE }">
															<td width="5%">
																<div style="text-align: center;">
																	<%=i%>
																</div>
															</td>

															<td class="center" width="8%">
																<div style="text-align: center;">
																	${job.INTENNAME }
																</div>
															</td>
															<td class="center" width="10%">
																<div style="text-align: center;">
																	${job.JOBNUM }
																</div>
															</td>
															<td class="center" width="8%">
																<div style="text-align: center;">
																	${job.JOBNAME }
																</div>
															</td>
															<td class="center" width="8%">
																<div style="text-align: center;">
																	${job.JOBSALARY }
																</div>
															</td>
															<td class="center" width="17%">
																<div style="text-align: center;">
																	${job.JOBADDR }
																</div>
															</td>
															<td class="center" width="18%">
																<div style="text-align: center;">
																	${job.JOBDESC }
																</div>
															</td>
															<td class="center" width="8%">
																<div style="text-align: center;">
																	${job.ENAME }
																</div>

															</td>
															<td class="center" width="18%">
																<div style="text-align: center;">
																	<!-- 修改 -->
																	<a class="btn btn-primary"
																		href="job/jobtoalert?jobid=${job.JOBID }&classid=${classid }">
																		<i class="glyphicon glyphicon-edit icon-white"></i> 编辑
																	</a>
																	<a class="btn btn-danger"
																		href="job/jobdel?jobid=${job.JOBID }&classid=${classid }">
																		<i class="glyphicon glyphicon-trash icon-white"></i>
																		删除 </a>
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
									<c:if test="${joblist==null}">
										<b>这个学生的就业记录或这个学生不存在,你可以添加</b>
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

	</body>
</html>

