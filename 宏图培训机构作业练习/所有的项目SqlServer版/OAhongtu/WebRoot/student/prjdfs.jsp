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
								<a href="#">项目答辩管理</a>
							</li>

						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-user"></i>
										<c:forEach items="${clslist}" var="cls">
											<c:if test="${cls.CLASSID==classid}">
												${cls.CLASSNAME }的
											</c:if>
										</c:forEach>
										<c:forEach items="${coslist}" var="cos">
											<c:if test="${cos.couid==pname }">
												${cos.couname }答辩成绩
											</c:if>
										</c:forEach>
									</h2>

								</div>

								<div class="box-content">
									<div class="alert alert-info">
										<a href="prj/prjlist?classid=${classid }&couid=${pname }&addtolist2=1">返回</a>
									</div>

									<div class="box-content">
										<table width="100%" align="center">
											<tr>
												<td>
													<b>班级:</b> <c:forEach items="${clslist}" var="cls">
															<c:if test="${cls.CLASSID==classid}">
													${cls.CLASSNAME }
												</c:if>
														</c:forEach> 

												</td>
												<td>
													<b>项目名称:</b> <c:forEach items="${coslist}" var="cos">
															<c:if test="${cos.couid==pname }">
														${cos.couname }
															<c:set var="couname" value="${cos.couname}" scope="page"></c:set>
													</c:if>
														</c:forEach> 

												</td>
												<td>
													<b>指导老师: </b> <c:forEach items="${emplist}" var="emp">
															<c:if test="${emp.eid==pteacher}">
													${emp.ename }
												</c:if>
														</c:forEach>

												</td>
												<td>
													<b>演示时间:</b>${pdate }

												</td>
												<td>
													<b>评委老师: </b> <c:forEach items="${emplist}" var="emp">
															<c:if test="${emp.eid==pteachers}">
													${emp.ename }
												</c:if>
														</c:forEach>

												</td>
											</tr>
										</table>
										<hr>
										<s:if test="course.couname=='JSP'">
											<!-- 这里去打印报表 -->
											<form name="frm" action="prj/scbbjsp" method="post">
												<!-- 这个是班级id和课程id用来修改后返回这里 -->
												<input type="hidden" name="classid" value="${classid }">
												<input type="hidden" name="couid" value="${pname }">
												<table id="table"
													class="table table-striped table-bordered bootstrap-datatable datatable responsive">
														<tr>
															<th width="8%">
																<div style="text-align: center;" >
																	组长
																</div>
															</th>	
															<th width="10%">
																<div style="text-align: center;">
																	成员
																</div>
															</th>
															<th width="9%">
																<div style="text-align: center;">
																	功能完善(50)
																</div>
															</th>
															<th width="9%">
																<div style="text-align: center;">
																	技术难度(10)
																</div>
															</th>
															<th width="9%">
																<div style="text-align: center;">
																	界面美观(10)
																</div>
															</th>
															<th width="9%">
																<div style="text-align: center;">
																	演示方法(10)
																</div>
															</th>
															<th width="9%">
																<div style="text-align: center;">
																	语言表达(10)
																</div>
															</th>
															<th width="9%">
																<div style="text-align: center;">
																	回答问题(10)
																</div>
															</th>
															<th width="10%">
																<div style="text-align: center;">
																	总分(100)
																</div>
															</th>
															<th>
																<div style="text-align: center;">
																	备注
																</div>
															</th>
														</tr>
													<tbody>
													<c:forEach items="${list}" var="dfs" varStatus="d">
														<tr>
															<!-- 判断是不是最后一行 -->
															<c:if test="${d.index+1!=size}">
																<!-- 判断合并 -->
																<c:if test="${dfs.DCOUNT!=NULL}" >
																	<td class="center" rowspan="${dfs.DCOUNT }"  width="8%">
																		<div style="text-align: center;">
																			<c:forEach items="${student}" var="stu">
																				<c:if test="${stu.INTENID==dfs.DHEAD}">
																					${stu.INTENNAME }
																				</c:if>
																			</c:forEach>
																		</div>
																	</td>
																</c:if>
															</c:if>
															<c:if test="${d.index+1==size}">
																<!-- 判断合并 -->
																<c:if test="${dfs.DCOUNT!=NULL}" >
																	<td class="center"  width="8%">
																		<div style="text-align: center;">
																			<c:forEach items="${student}" var="stu">
																				<c:if test="${stu.INTENID==dfs.DHEAD}">
																					${stu.INTENNAME }
																				</c:if>
																			</c:forEach>
																		</div>
																	</td>
																</c:if>
															</c:if>
															<td class="center" width="10%">
																<div style="text-align: center;" >
																	<c:forEach items="${student}" var="stu">
																		<c:if test="${stu.INTENID==dfs.DMEMBER}">
																			${stu.INTENNAME }
																		</c:if>
																	</c:forEach>
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DFUNCTION }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DDIFFICULTY }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DBEANUTIFUL }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DDEMO }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DEXPRESS }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DANSWER }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DSCORE }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																	${dfs.DREMARK }
																</div>
															</td>
														</tr>
	
													</c:forEach>
													
													<tr>
														<td colspan="10">
															<button type="submit" onclick="alert('文件将生成在桌面');" class="btn btn-info" class="glyphicon glyphicon-edit icon-white">
																生成报表
															</button>
														</td>
													</tr>
													</tbody>
												</table>
											</form>
										</s:if>
										<s:elseif test="course.couname=='WEB'">
											<!-- 这里去打印报表 -->
											<form name="frm" action="prj/scbbjsp" method="post">
												<!-- 这个是班级id和课程id用来修改后返回这里 -->
												<input type="hidden" name="classid" value="${classid }">
												<input type="hidden" name="couid" value="${pname }">
												<table id="table"
													class="table table-striped table-bordered bootstrap-datatable datatable responsive">
														<tr>
															<th width="8%">
																<div style="text-align: center;">
																组长
																</div>
															</th>	
															<th width="10%">
																<div style="text-align: center;">
																成员
																</div>
															</th>
															<th width="9%">
																<div style="text-align: center;">
																功能完善(50)
																</div>
															</th>
															<th width="9%">
																<div style="text-align: center;">
																技术难度(10)
																</div>
															</th>
															<th width="9%">
																<div style="text-align: center;">
																界面美观(10)
																</div>
															</th>
															<th width="9%">
																<div style="text-align: center;">
																演示方法(10)
																</div>
															</th>
															<th width="9%">
																<div style="text-align: center;">
																语言表达(10)
																</div>
															</th>
															<th width="9%">
																<div style="text-align: center;">
																回答问题(10)
																</div>
															</th>
															<th width="10%">
																<div style="text-align: center;">
																总分(100)
																</div>
															</th>
															<th >
																<div style="text-align: center;">
																备注
																</div>
															</th>
														</tr>
													<tbody>
													<c:forEach items="${list}" var="dfs" varStatus="d">
														<tr>
															<!-- 判断是不是最后一行 -->
															<c:if test="${d.index+1!=size}">
																<!-- 判断合并 -->
																<c:if test="${dfs.DCOUNT!=NULL}">
																	<td class="center" rowspan="${dfs.DCOUNT }"  width="8%">
																		<div style="text-align: center;">
																			<c:forEach items="${student}" var="stu">
																				<c:if test="${stu.INTENID==dfs.DHEAD}">
																					${stu.INTENNAME }
																				</c:if>
																			</c:forEach>
																		</div>
																	</td>
																</c:if>
															</c:if>
															<c:if test="${d.index+1==size}">
																<!-- 判断合并 -->
																<c:if test="${dfs.DCOUNT!=NULL}" >
																	<td class="center"  width="8%">
																		<div style="text-align: center;">
																			<c:forEach items="${student}" var="stu">
																				<c:if test="${stu.INTENID==dfs.DHEAD}">
																					${stu.INTENNAME }
																				</c:if>
																			</c:forEach>
																		</div>
																	</td>
																</c:if>
															</c:if>
															<td class="center"  width="10%">
																<div style="text-align: center;">
																<c:forEach items="${student}" var="stu">
																	<c:if test="${stu.INTENID==dfs.DMEMBER}">
																		${stu.INTENNAME }
																	</c:if>
																</c:forEach>
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DFUNCTION }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DDIFFICULTY }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DBEANUTIFUL }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DDEMO }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DEXPRESS }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DANSWER }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DSCORE }
																</div>
															</td>
															<td class="center" width="20%">
																<div style="text-align: center;">
																	${dfs.DREMARK }
																</div>
															</td>
														</tr>
	
													</c:forEach>
													
													<tr>
														<td colspan="10">
															<button type="submit" onclick="alert('文件将生成在桌面');" class="btn btn-primary" class="glyphicon glyphicon-edit icon-white">
																生成报表
															</button>
														</td>
													</tr>
													</tbody>
												</table>
											</form>
										</s:elseif>
										<s:else>
											<!-- 这里去打印报表 -->
											<form name="frm" action="prj/scbb" method="post">
												<!-- 这个是班级id和课程id用来修改后返回这里 -->
												<input type="hidden" name="classid" value="${classid }">
												<input type="hidden" name="couid" value="${pname }">
												<table id="table"
													class="table table-striped table-bordered bootstrap-datatable datatable responsive">
														<tr>
															<th width="8%">
																<div style="text-align: center;">
																成员
																</div>
															</th>
															<th width="8%">
																<div style="text-align: center;">
																功能完善(50)
																</div>
															</th>
															<th width="8%">
																<div style="text-align: center;">
																技术难度(10)
																</div>
															</th>
															<th width="8%">
																<div style="text-align: center;">
																界面美观(10)
																</div>
															</th>
															<th width="8%">
																<div style="text-align: center;">
																演示方法(10)
																</div>
															</th>
															<th width="8%">
																<div style="text-align: center;">
																语言表达(10)
																</div>
															</th>
															<th width="8%">
																<div style="text-align: center;">
																回答问题(10)
																</div>
															</th>
															<th width="10%">
																<div style="text-align: center;">
																总分(100)
																</div>
															</th>
															<th>
																<div style="text-align: center;">
																备注
																</div>
															</th>
														</tr>
													<tbody>
													<c:forEach items="${list}" var="dfs">
														<tr>
															<td class="center"  width="8%">
																<div style="text-align: center;">
																<c:forEach items="${student}" var="stu">
																	<c:if test="${stu.INTENID==dfs.DMEMBER}">
																		${stu.INTENNAME }
																	</c:if>
																</c:forEach>
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DFUNCTION }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DDIFFICULTY }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DBEANUTIFUL }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DDEMO }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DEXPRESS }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DANSWER }
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																${dfs.DSCORE }
																</div>
															</td>
															<td class="center" width="20%">
																<div style="text-align: center;">
																	${dfs.DREMARK }
																</div>
															</td>
														</tr>
	
													</c:forEach>
													
													<tr>
														<td colspan="9">
															<button type="submit" onclick="alert('文件将生成在桌面');" class="btn btn-primary" class="glyphicon glyphicon-edit icon-white">
																生成报表
															</button>
														</td>
													</tr>
													</tbody>
												</table>
											</form>
										</s:else>
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

