<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.ht.vo5.Student"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>

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

				<div id="content" class="col-lg-10 col-sm-10" style="width: 100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="#">学生管理</a>
							</li>
							<li>
								<c:if test="${stu.classid!=null}">
									<a href="stu/list?classid=${stu.classid }">学生信息管理</a>
								</c:if>
								<c:if test="${stu.classid==null}">
									<a href="stu/listsx">学生信息管理</a>
								</c:if>
							</li>
							<li>
								<a href="stu/seldan?intenid=${stu.intenid }">${stu.intenname }的个人信息</a>
							</li>
						</ul>
					</div>
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-user"></i>
										${stu.intenname }的在校记录
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
								<div class="box-content" >
									<!-- 内容开始 -->
									<table width="100%" class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<tr height="60" >
											<th width="20%">
												成绩
											</th>
											<td colspan="2">
												<c:forEach items="${scolist}" var="sco">
													<c:forEach items="${coslist}" var="cos">
														<c:if test="${cos.couid==sco.SCONAME}">
															<b>${cos.couname }:</b>${sco.SCORE }分<br>
															<c:set var="couid2" value="${cos.couid}"></c:set>
														</c:if>
													</c:forEach>
												</c:forEach>
											</td>
											<td width="15%">
												<c:if test="${scosize!=0}">
													<a href="score/scolist?classid=${stu.classid }&couid=${couid2}">详情</a>
												</c:if>
											</td>
										</tr>
										<tr height="60" bgcolor="white">
											<th>
												项目答辩成绩
											</th>
											<td> 
												<c:forEach items="${prjlist}" var="prj">
													<c:forEach items="${coslist}" var="cos">
														<c:if test="${cos.couid==prj.PNAME}">
															<b>${cos.couname }:</b>${prj.DSCORE }分<br>
															<c:set var="couid" value="${cos.couid}"></c:set>
														</c:if>
													</c:forEach>
												</c:forEach>
											</td>
											<td width="35%">
												<c:forEach items="${prjlist}" var="sco">
													<b>备注:</b>${sco.DREMARK }<br>
												</c:forEach>
											</td>
											<td >
												<c:if test="${prjsize!=0}">
													<a href="prj/prjlist?classid=${stu.classid }&couid=${couid }">详情</a>
												</c:if>
											</td>
										</tr>
										<tr height="60" bgcolor="white">
											<th>
												谈心记录
											</th>
											<td >
												<c:forEach items="${sayslist}" var="says">
													<b>谈心内容:</b>${says.SAYSPRO }
												</c:forEach>
											</td>
											<td>
												<c:forEach items="${sayslist}" var="says">
													<b>谈心反馈:</b>${says.SAYBACK }
												</c:forEach>
											</td>
											<td >
												<c:if test="${sayssize!=0}">
													<a href="says/sayslist?ename=${emp.eid }&state=${stu.intenstatus }">详情</a>
												</c:if>
											</td>
										</tr>
										<tr height="60" bgcolor="white">
											<th>
												请假次数
											</th>
											<td colspan="3">
												<b>共  &nbsp;&nbsp;&nbsp;:${levsize }次</b><br>
												<c:forEach items="${levlist}" var="lev">
													<b>时间:</b>${lev.LDATE }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>事因:</b>${lev.LNAME }<br>
												</c:forEach>
											</td>
										</tr>
										<tr height="60" bgcolor="white">
											<th>
												总结
											</th>
											<td colspan="2">
												<c:forEach items="${smylist}" var="smy">
													${smy.SSAY }
												</c:forEach>
											</td>
											<td >
												<c:if test="${smysize!=0}">
													<a href="summary/smylist?classid=${stu.classid }">详情</a>
												</c:if>
											</td>
										</tr>
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
			<!-- content ends -->
		</div>
		<!--/fluid-row-->

		<!-- external javascript -->

	</body>
</html>

