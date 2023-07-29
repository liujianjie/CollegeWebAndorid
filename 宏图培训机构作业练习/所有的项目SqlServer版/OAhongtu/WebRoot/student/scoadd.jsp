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
		<jsp:include page="tou.jsp"></jsp:include>
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
								<a href="#">学生管理</a>
							</li>
							<li>
								<a href="score/scosx">成绩管理</a>
							</li>
							
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-edit"></i> 添加成绩
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i> </a>
										<a href="#" class="btn btn-close btn-round btn-default"><i
											class="glyphicon glyphicon-remove"></i> </a>
									</div>
								</div>

								<div class="box-content">
									<div class="alert alert-info">
										<a href="score/scosx?addtolist=1">返回</a>
									</div>
									<form action="score/scotoadd2" method="post">
										<div class="box-content">
											<label for="exampleInputEmail1">
												<b>班级</b>
											</label>
											<select name="classid" id="selectError"
															data-rel="chosen" style="width: 100px;">
												<c:forEach items="${clslist}" var="cls">
													<option value="${cls.CLASSID }" ${cls.CLASSID==classes.classid?"selected":""}> 
														${cls.CLASSNAME }
													</option>

												</c:forEach>
											</select>
											<label for="exampleInputEmail1">
												<b>科目</b>
											</label>
											<select name="couid" id="selectError" data-rel="chosen"
												style="width: 100px;">
												<c:forEach items="${coslist}" var="cos">
													<option value="${cos.couid }" ${cos.couid==course.couid?"selected":""}>
														${cos.couname }
													</option>

												</c:forEach>
											</select>
											
											<button type="submit" class="btn btn-success" class="glyphicon glyphicon-zoom-in icon-white">开始添加</button>
										</div>
									</form>
									<hr>
									<c:if test="${size==0}">
									<form name="frm" action="score/scoadd?addtolist=1" method="post">
										<!-- 班级和科目id可以单独分开 因为是一样的 -->
										<input type="hidden" name="classid" value="${classes.classid }">
										<input type="hidden" name="couid" value="${course.couid }">
										<table id="table"
											class="table table-striped table-bordered bootstrap-datatable datatable responsive">
											
											<tr>
												<th>
													序号
												</th>
												<th>
													班级
												</th>
												
												<th>
													姓名
												</th>
												<th>
													科目
												</th>
												<th>
													分数
												</th>
											</tr>
											<tbody>
											<%
												int i = 1;
											%>
											<c:forEach items="${cslist}" var="cs">
												<!-- 学生id -->
												<input type="hidden" name="stuid" value="${cs.INTENID }">
												<tr>
													<td width="10%">
														<%=i%>
													</td>
													<td  width="20%">
														${cs.CLASSNAME }

													</td>
													<td width="20%">
														${cs.INTENNAME }

													</td>
													<td width="20%">
														${course.couname }
													</td>
													<td width="30%">
														<!-- 分数 -->
														<div class="control-group"
															style="height: 35px; width: 0px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: -5px; margin-top: 0px">
															<input type="text" name="score"
																class="form-control" placeholder="请输入学生成绩"
																style="width: 150px">
														</div>
													</td>
												</tr>
												<%
													i++;
												%>
											</c:forEach>
											</tbody>
											<tr>
												<td colspan="5">
													<button type="submit" class="btn btn-success"
														${sizes==0?"disabled":"" } class="glyphicon glyphicon-zoom-in icon-white">
															录入
													</button>
												</td>
											</tr>
										</table>
									</form>
									</c:if>
									<c:if test="${size!=0}">
										
											<b>这个班已经有这门成绩了，修改即可</b>
										
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
		<!-- external javascript -->

	</body>
</html>


