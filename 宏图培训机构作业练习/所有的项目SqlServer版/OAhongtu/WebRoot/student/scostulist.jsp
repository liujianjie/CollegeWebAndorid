<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
								<a href="homepage2.jsp">首页</a>
							</li>
							<li>
								<a href="#">成绩管理</a>
							</li>
							
						</ul>
					</div>
					
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i>
										<c:if test="${classes==null}">
											所有学生的所有成绩
										</c:if>
										<c:if test="${classes!=null}">
											${classes.classname }的${course.couname }成绩
										</c:if>
										
									</h2>

								</div>
								
								<div class="box-content">
									<div class="alert alert-info" style="height:70px">
										<div style="float:left;width:52%;clear:right">
											<form action="score/scolist2" method="post">
												<label for="exampleInputEmail1">
													<b>班级</b>
												</label>
												<select disabled="disabled" id="selectError"
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
												<button type="submit"class="btn btn-success"><i class="glyphicon glyphicon-zoom-in icon-white"></i>查询</button>
											</form>
										</div>
									</div>
											
									<hr>
									<c:if test="${size!=0}">
									<table id="table"
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th>
													序号
												</th>
												<th>
													所属班级
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
										</thead>
										<tbody>
										<%int i=1; %>
										<c:forEach items="${list}" var="sco">
											
											<tr>
												<td width="10%">
													<%=i %>
												</td>
												<td class="center" width="17%">
													${sco.CLASSNAME }
													
												</td>
												<td class="center" width="17%">
													${sco.INTENNAME }
												</td>
												<td class="center" width="17%">
													<span id="${sco.SCOID}"  ondblclick="chuselect(this);">${sco.COUNAME }</span>
													<!-- 下拉框样式 -->
											
													<select id="s${sco.SCOID}"  onblur="yc(this)" onchange="updselect(this);"  
														style="width: 83px;display:none">
														<c:forEach items="${coslist}" var="cos">
															<option value="${cos.couid }" ${cos.couid==sco.SCONAME?"selected":""} >
																${cos.couname }
															</option>
														</c:forEach>
													</select>
												
												</td>
												<td class="center" width="15%">
													<span id="c${sco.SCOID}" ondblclick="chustext(this);">${sco.SCORE }</span>
													<!-- 文本框 -->
													<!-- 普通框样式 -->
													<div class="control-group"
														style="height: 30px; width: 0px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 0px; margin-top: -10px">
														<input onblur="updtext(this);" id="t${sco.SCOID}" type="text" class="form-control" 
															value="${sco.SCORE }"
															style="width: 80px;display: none" >
													</div>
												</td>
												
											</tr>
											<%i++; %>										
										</c:forEach>
										</tbody>
									</table>
									</c:if>
									<c:if test="${size==0}">
										<b>这个班的这门课程成绩不存在,请选择其它科目</b>
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

