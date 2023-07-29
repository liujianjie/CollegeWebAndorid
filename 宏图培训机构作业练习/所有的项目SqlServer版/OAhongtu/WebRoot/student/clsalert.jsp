<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
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
								<a href="javascript:history.go(-1);">返回上一页</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-edit"></i>
										修改${classes.classname }
									</h2>

								</div>

								<div class="box-content">
									
									<form name="frm" action="classes/clsalert" method="post">
										<Input type="hidden" name="classes.classid" value="${classes.classid }">
										
										<div class="box-content">
											<label for="exampleInputEmail1">
												班级名称：
												
											</label>
											<div class="control-group"
												style="display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 0px; margin-top: 0px">
												<input type="text" name="classes.classname" value="${classes.classname }" placeholder="请输入班级名称" class="form-control" style="width:160px;">											
											</div>
											
											<label for="exampleInputEmail1" style="margin-left:20px;">
												班级人数：
											</label>
											<div class="control-group"
												style="display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 0px; margin-top: 0px">
												<input type="text" name="classes.classcount"  value="${classes.classcount }"  placeholder="请输入班级人数" class="form-control" style="width:160px;">											
											</div>
											
										</div>
										<div class="box-content">
											<label for="exampleInputEmail1">
												班级位置：
											</label>
											<div class="control-group"
												style="display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 0px; margin-top: 0px">
												<input type="text" name="classes.classaddr" value="${classes.classaddr }" placeholder="请输入班级具体位置" class="form-control"  style="width:380px;">											
											</div>
										</div>
										<div class="box-content">
											<label for="exampleInputEmail1">
												任课老师：
											</label>
											<select name="classes.empteach" id="selectError" data-rel="chosen"  style="width:160px;">
												<option>--请选择任课老师--</option>
												<c:forEach items="${emplist}" var="emp">
													
													<option value="${emp.eid }" ${emp.eid==classes.empteach?"selected":"" }>
														${emp.ename }
													</option>
												</c:forEach>							
											</select>
										</div>
										<div class="box-content">
											<label for="exampleInputEmail1">
												辅导老师：
											</label>
											<select name="classes.empteachs" id="selectError" data-rel="chosen"  style="width:160px;">
												<option>--请选择辅导老师--</option>
												<c:forEach items="${emplist}" var="emp">
													<option value="${emp.eid }"  ${emp.eid==classes.empteachs?"selected":"" }>
														${emp.ename }
													</option>
												</c:forEach>							
											</select>
										</div>
										<div class="box-content">
											<label for="exampleInputEmail1">
												班 主 任：&nbsp;&nbsp;
												
											</label>
											<select name="classes.empteaches" id="selectError" data-rel="chosen"  style="width:160px;">
												<option>--请选择班主任老师--</option>
												<c:forEach items="${emplist}" var="emp">
													<option value="${emp.eid }" ${emp.eid==classes.empteaches?"selected":"" }>
														${emp.ename }
													</option>
												</c:forEach>							
											</select>
										</div>
										
										<!-- 下拉删除框样式 -->
										<div class="box-content">
											<label class="control-label" for="selectError1">
												班级人员
											</label>
											<div class="controls">
												<select name="member" id="selectError1" multiple style="width:500px"
													class="form-control" data-rel="chosen">
													<c:forEach items="${classes.student}" var="stu">
														<option value="${stu.intenid }" selected="selected">
															${stu.intenname }
														</option>
													</c:forEach>
													<!-- 可以添加其它学生 循环出来 最后按照班级查出来 -->
												</select>
											</div>
										</div>
										<div class="box-content">
											<label class="control-label" for="selectError1">
												添加班级人员
											</label>
											<div class="controls">
												<select name="member" onchange="ge(this);" id="selectError1" multiple style="width:500px"
														class="form-control" data-rel="chosen">
													<c:forEach items="${clslist}" var="cls">
														<optgroup label="${cls.classname }">
															<c:forEach items="${stulist}" var="stu">
																<option value="${stu.INTENID }">
																	<c:if test="${stu.CLASSID==cls.classid}">
																		${stu.INTENNAME}														
																	</c:if>
																</option>
															</c:forEach>
														</optgroup>
													</c:forEach>
													<optgroup label="没有给予班级的学生">
														<c:forEach items="${stulist}" var="stu">
															<option value="${stu.INTENID }">
																<c:if test="${stu.CLASSID==null}">
																	${stu.INTENNAME}														
																</c:if>
															</option>
														</c:forEach>
													</optgroup>
												</select>
											</div>
											
										</div>
										<div class="box-content">
											<div class="control-group">
												<button type="submit" class="btn btn-default"
													style="width: 100px; margin-left: 180px;margin-top:8px;">
													<b>修 改</b>
												</button>
											</div>
										</div>
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

	</body>
</html>

