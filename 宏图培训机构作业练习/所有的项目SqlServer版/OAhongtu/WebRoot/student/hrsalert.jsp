<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

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
										宿舍${hrs.hourname}的信息
									</h2>


								</div>
								<div class="box-content">
									<form action="hourse/hrsalert?hrs.hourid=${hrs.hourid }"
										method="post">
										<!-- 下拉框样式 -->
										<div class="box-content">
											<b>
												&nbsp;&nbsp;单 元
											</b>
											<div class="controls"
												style="height: 30px; width: 250px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 40px;">
												<select name="hrs.eid" id="selectError" data-rel="chosen"
													style="width: 165px;">
													<c:forEach items="${elelist}" var="ele">
														<option value="${ele.EID }" ${ele.EID==hrs.eid?"selected":"" }>
															${ele.ENAME }
														</option>
													</c:forEach>
												</select>
										</div>
										</div>
										<!-- 普通框样式 -->
										<div class="box-content">
											<label for="exampleInputEmail1">
												<b>宿舍房间号</b>
											</label>
											<div class="control-group"
												style="height: 30px; width: 300px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 7px; margin-top: -10px">
												<input type="text" class="form-control" name="hrs.hourname"
													value="${hrs.hourname }" placeholder="${hrs.hourname }"
													style="width: 170px;">
											</div>
										</div>
										<!-- 下拉框样式 -->
										<div class="box-content">
											<b>
												宿舍长
											</b>
											<div class="controls"
												style="height: 30px; width: 250px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 37px;">
												<select name="hrs.hhead" id="selectError" data-rel="chosen"
													style="width: 165px;">
													<c:forEach items="${hrs.student}" var="stu">
														<option value="${stu.intenid }" ${stu.intenid==hrs.hhead?"selected":"" }>
															${stu.intenname }
														</option>
													</c:forEach>
												</select>
										</div>
										</div>

										<div class="box-content">
											<label for="exampleInputEmail1">
												<b>宿舍人数&nbsp;</b>
											</label>
											<div class="control-group"
												style="height: 30px; width: 300px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 17px; margin-top: -10px">
												<input type="text"  class="form-control" name="hrs.hnumber"
													value="${hrs.hnumber }" id="ename"
													placeholder="${hrs.hnumber }" style="width: 170px;">
											</div>
										</div>
										<!-- 下拉删除框样式 -->
										<div class="box-content">
											<label class="control-label" for="selectError1">
												<b>宿舍人员</b>
											</label>
											<div class="controls">
												<select name="member" id="selectError1" multiple
													class="form-control" data-rel="chosen" style="width:500px">
													<c:forEach items="${hrs.student}" var="stu">
														<option value="${stu.intenid }" selected="selected" >
															${stu.intenname }
														</option>
													</c:forEach>
													<!-- 可以添加其它学生 循环出来 最后按照班级查出来 -->
												</select>
											</div>
										</div>
										
										<div class="box-content">
											<label class="control-label" for="selectError1">
												<b>添加其他宿舍人员</b>
											</label>
											<div class="controls">
											<select name="member2" id="selectError1" multiple class="form-control" data-rel="chosen" style="width:500px">
												<optgroup label="没有给予宿舍的学生">
													<c:forEach items="${stulist}" var="stu">
														<option value="${stu.INTENID }">
															<c:if test="${stu.HOURID==null}">
																${stu.INTENNAME}														
															</c:if>
														</option>
													</c:forEach>
												</optgroup>
												<c:forEach items="${hrslist}" var="hrs">
													<optgroup label="${hrs.HOURNAME }">
														<c:forEach items="${stulist}" var="stu">
															<option value="${stu.INTENID }">
																<c:if test="${stu.HOURID==hrs.HOURID}">
																	${stu.INTENNAME}																
																</c:if>
															</option>
														</c:forEach>
													</optgroup>
												</c:forEach>

											</select>	
											</div>
										</div>
										<!-- submit提交按钮样式 -->

										<div class="box-content">
											<div class="control-group">
												<button type="submit" class="btn btn-default">
													修改
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
			<!-- content ends -->
		</div>
		<!--/fluid-row-->

	</body>
</html>
