<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.ht.vo.Emp"%>
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
		<!-- 获取登录信息 -->
   		<jsp:include page="tou.jsp"></jsp:include>
		<jsp:include page="common.jsp"></jsp:include>
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
								<a href="score/scosx">项目答辩成绩管理</a>
							</li>
							
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-edit"></i> 添加项目答辩成绩
									</h2>

									<div class="box-icon">
										<a href="#" class="btn btn-setting btn-round btn-default"><i
											class="glyphicon glyphicon-cog"></i> </a>
										<a href="#" class="btn btn-minimize btn-round btn-default"><i
											class="glyphicon glyphicon-chevron-up"></i> </a>
										<a href="#" class="btn btn-close btn-round btn-default"><i
											class="glyphicon glyphicon-remove"></i> </a>
									</div>
								</div>

								<div class="box-content">
									<div class="alert alert-info">
										<a href="prj/prjsx?addtolist2=1">返回</a>
									</div>
									<form action="prj/prjtoadd2" method="post">
										<table width="95%">
											<tr>
												<td>
													<b>班级:</b>
													<select name="classid" id="selectError"
															data-rel="chosen" style="width: 100px;">
														<c:forEach items="${clslist}" var="cls">
															<option value="${cls.CLASSID }" ${cls.CLASSID==classes.classid?"selected":""}> 
																${cls.CLASSNAME }
															</option>
		
														</c:forEach>
													</select>
												</td>
												<td>
													<b>项目名称:</b>
													<select name="couid" id="selectError" data-rel="chosen"
														style="width: 100px;">
														<c:forEach items="${coslist}" var="cos">
															<option value="${cos.couid }" ${cos.couid==course.couid?"selected":""}>
																${cos.couname }
															</option>
		
														</c:forEach>
													</select>

												</td>
												<td>
													<b>指导老师:</b>
													<select id="selectError" data-rel="chosen"
														style="width: 100px;">
														<c:if test="${sizes==0}">
															<option>
																请先选择班级
															</option>
														</c:if>
														<c:if test="${sizes!=0}">
															<c:forEach items="${emplist}" var="emp">
																<c:if test="${emp.eid==teacherr.eid}">
																	<option value="${emp.eid }">
																		${emp.ename }
																	</option>
																</c:if>
															</c:forEach>
														</c:if>
													</select>
												</td>
												<td>
													<b>演示时间:</b>
													<%Date date=new Date();
													DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
													String datea=df.format(date);
													%>
													<c:if test="${time==null}">
														<input type="text" name="time" 
														value="<%=datea %>" style="width:90px" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});">
													</c:if>
													<c:if test="${time!=null}">
														<input type="text" name="time" 
														value="${time }" style="width:90px" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});">
													</c:if>
												</td>
												<td>
													<b>评委老师:</b>
													<select name="teaches" id="selectError" data-rel="chosen"
														style="width: 100px;">
														<c:forEach items="${emplist}" var="emp">
															<c:if test="${emp.eid==emplogin.eid}">
																<option value="${emp.eid }">
																	${emp.ename }
																</option>
															</c:if>
														</c:forEach>
														<c:if test="${emplogin==null}">
															<option>
																请先登录
															</option>
														</c:if>
													</select>
												</td>
												<td>
													
													<button type="submit" ${emplogin==null?"disabled":""} class="btn btn-success" class="glyphicon glyphicon-zoom-in icon-white">开始添加</button>
												</td>
											</tr>
										</table>
									</form>
									<hr>
									<c:if test="${size==0}">
									
									<form name="frm" action="prj/prjadd" method="post">
										<!-- 父表班级和科目id可以单独分开 因为是一样的 还有时间 知道老师 评委老师 班级-->
										<input type="hidden" name="classid" value="${classid }">
										<input type="hidden" name="couid" value="${couid }">
										<input type="hidden" name="prj.pname" value="${course.couid }">
										<input type="hidden" name="prj.pteacher" value="${teacherr.eid }">
										<input type="hidden" name="prj.pteachers" value="${teachers.eid }">
										<input type="hidden" name="prj.pdate" value="${time }">
										<input type="hidden" name="prj.pclassid" value="${classid }">
											<!-- 判断是不是有组长的项目 -->
											<s:if test="course.couname=='JSP'">
											<table id="table"
											class="table table-striped table-bordered bootstrap-datatable datatable responsive">
												<tr>
													<TH>
														组长
													</TH>
													<th>
														学生
													</th>
													<th>
														功能完善(50)
													</th>
													<th>
														技术难度(10)
													</th>
													<th>
														界面美观(10)
													</th>
													<th>
														演示方法(10)
													</th>
													<th>
														语言表达(10)
													</th>
													<th>
														回答问题(10)
													</th>
													<th>
														总分(100)
													</th>
													<th>
														备注
													</th>
												</tr>
												<%int i=0; %><!-- 行数 -->
												<%int j=0; %><!-- 列数 -->
												<tbody>
												<c:forEach items="${cslist}" var="cs">
													<input type="hidden" name="dmembers" value="${cs.INTENID }">
													<tr>
														<!-- 用来控制合并的数 -->
														<%if(i==0||i%2==0){ %>
														<td rowspan="2">
															<select name="dheads" 
																data-rel="chosen" style="width: 90px;">
																<c:forEach items="${cslist}" var="cstu" >
																	<option value="${cstu.INTENID }">
																		${cstu.INTENNAME }
																	</option>
																</c:forEach>
															</select>
														</td>
														<%} %>
														<td>
															${cs.INTENNAME }
														</td>
														<td>
															<select name="dfunctions" onchange="zongfen(this);" id="<%=i %>,<%=j %>"
																data-rel="chosen" style="width: 80px;">
																<option value="0" selected="selected">0</option>
																<c:forEach begin="1" end="50" var="xs" step="1">
																	<option value="${xs }">
																		${xs }
																	</option>
																</c:forEach>
															</select>
															<%j++; %>
														</td>
														<td>
															<select name="ddifficultys" onchange="zongfen(this);" id="<%=i %>,<%=j %>"
																data-rel="chosen" style="width: 80px;">
																<option value="0" selected="selected">0</option>
																<c:forEach begin="1" end="10" var="xs" step="1">
																	<option value="${xs }">
																		${xs }
																	</option>
																</c:forEach>
															</select>
															<%j++; %>
														</td>
														<td>
															<select name="dbeanutifuls" onchange="zongfen(this);" id="<%=i %>,<%=j %>"
																data-rel="chosen" style="width: 80px;">
																<option  value="0" selected="selected">0</option>
																<c:forEach begin="1" end="10" var="xs" step="1">
																	<option value="${xs }">
																		${xs }
																	</option>
																</c:forEach>
															</select>
															<%j++; %>
														</td>
														<td>
															<select name="ddemos" onchange="zongfen(this);" id="<%=i %>,<%=j %>"
																data-rel="chosen" style="width: 80px;">
																<option value="0" selected="selected">0</option>
																<c:forEach begin="1" end="10" var="xs" step="1">
																	<option value="${xs }">
																		${xs }
																	</option>
																</c:forEach>
															</select>
															<%j++; %>
														</td>
														<td>
															<select name="dexpresss" onchange="zongfen(this);" id="<%=i %>,<%=j %>"
																data-rel="chosen" style="width: 80px;">
																<option value="0" selected="selected">0</option>
																<c:forEach begin="1" end="10" var="xs" step="1">
																	<option value="${xs }">
																		${xs }
																	</option>
																</c:forEach>
															</select>
															<%j++; %>
														</td>
														<td>
															<select name="danswers" onchange="zongfen(this);" id="<%=i %>,<%=j %>"
																data-rel="chosen" style="width: 80px;">
																<option value="0" selected="selected">0</option>
																<c:forEach begin="1" end="10" var="xs" step="1">
																	<option value="${xs }">
																		${xs }
																	</option>
																</c:forEach>
															</select>
															<%j++; %>
														<td>
															<input type="text" name="dscores" id="<%=i %>,<%=j %>"
																class="form-control" value="0"
																style="width: 80px;display: none" >
															<%j++; %>
															<input type="text" id="<%=i %>,<%=j %>"
																class="form-control" disabled="disabled" value="0"
																style="width: 80px" >
															<%j=0; %>
														</td>
														<td width="15%">
															<input type="text" name="dremarks"
																class="form-control" 
																style="width: 190px">
														</td>
													</tr>
													<%i++; %>
												</c:forEach>
												</tbody>
												<tr>
													<td colspan="9" align="right">
														<!-- submit提交按钮样式 -->
														<button type="submit" ${sizes==0?"disabled":"" } class="btn btn-success"
															class="glyphicon glyphicon-zoom-in icon-white">
															录入
														</button>
													</td>
												</tr>
											</table>
											</s:if>
											<s:elseif test="course.couname=='JAVA'">
											<table id="table"
											class="table table-striped table-bordered bootstrap-datatable datatable responsive">
												<tr>
													<TH>
														组长
													</TH>
													<th>
														学生
													</th>
													<th>
														功能完善(50)
													</th>
													<th>
														技术难度(10)
													</th>
													<th>
														界面美观(10)
													</th>
													<th>
														演示方法(10)
													</th>
													<th>
														语言表达(10)
													</th>
													<th>
														回答问题(10)
													</th>
													<th>
														总分(100)
													</th>
													<th>
														备注
													</th>
												</tr>
												<%int i=0; %><!-- 行数 -->
												<%int j=0; %><!-- 列数 -->
												<tbody>
												<c:forEach items="${cslist}" var="cs">
													<input type="hidden" name="dmembers" value="${cs.INTENID }">
													<tr>
														<!-- 用来控制合并的数 -->
														<%if(i==0||i%5==0){ %>
														<td rowspan="5">
															<select name="dheads" 
																data-rel="chosen" style="width: 90px;">
																<c:forEach items="${cslist}" var="cstu" >
																	<option value="${cstu.INTENID }">
																		${cstu.INTENNAME }
																	</option>
																</c:forEach>
															</select>
														</td>
														<%} %>
														<td>
															${cs.INTENNAME }
														</td>
														<td>
															<select name="dfunctions" onchange="zongfen(this);" id="<%=i %>,<%=j %>"
																data-rel="chosen" style="width: 80px;">
																<option value="0" selected="selected">0</option>
																<c:forEach begin="1" end="50" var="xs" step="1">
																	<option value="${xs }">
																		${xs }
																	</option>
																</c:forEach>
															</select>
															<%j++; %>
														</td>
														<td>
															<select name="ddifficultys" onchange="zongfen(this);" id="<%=i %>,<%=j %>"
																data-rel="chosen" style="width: 80px;">
																<option value="0" selected="selected">0</option>
																<c:forEach begin="1" end="10" var="xs" step="1">
																	<option value="${xs }">
																		${xs }
																	</option>
																</c:forEach>
															</select>
															<%j++; %>
														</td>
														<td>
															<select name="dbeanutifuls" onchange="zongfen(this);" id="<%=i %>,<%=j %>"
																data-rel="chosen" style="width: 80px;">
																<option  value="0" selected="selected">0</option>
																<c:forEach begin="1" end="10" var="xs" step="1">
																	<option value="${xs }">
																		${xs }
																	</option>
																</c:forEach>
															</select>
															<%j++; %>
														</td>
														<td>
															<select name="ddemos" onchange="zongfen(this);" id="<%=i %>,<%=j %>"
																data-rel="chosen" style="width: 80px;">
																<option value="0" selected="selected">0</option>
																<c:forEach begin="1" end="10" var="xs" step="1">
																	<option value="${xs }">
																		${xs }
																	</option>
																</c:forEach>
															</select>
															<%j++; %>
														</td>
														<td>
															<select name="dexpresss" onchange="zongfen(this);" id="<%=i %>,<%=j %>"
																data-rel="chosen" style="width: 80px;">
																<option value="0" selected="selected">0</option>
																<c:forEach begin="1" end="10" var="xs" step="1">
																	<option value="${xs }">
																		${xs }
																	</option>
																</c:forEach>
															</select>
															<%j++; %>
														</td>
														<td>
															<select name="danswers" onchange="zongfen(this);" id="<%=i %>,<%=j %>"
																data-rel="chosen" style="width: 80px;">
																<option value="0" selected="selected">0</option>
																<c:forEach begin="1" end="10" var="xs" step="1">
																	<option value="${xs }">
																		${xs }
																	</option>
																</c:forEach>
															</select>
															<%j++; %>
														<td>
															<input type="text" name="dscores" id="<%=i %>,<%=j %>"
																class="form-control" value="0"
																style="width: 80px;display: none" >
															<%j++; %>
															<input type="text" id="<%=i %>,<%=j %>"
																class="form-control" disabled="disabled" value="0"
																style="width: 80px" >
															<%j=0; %>
														</td>
														<td width="15%">
															<input type="text" name="dremarks"
																class="form-control" 
																style="width: 190px">
														</td>
													</tr>
													<%i++; %>
												</c:forEach>
												</tbody>
												<tr>
													<td colspan="9" align="right">
														<!-- submit提交按钮样式 -->
														<button type="submit" ${sizes==0?"disabled":"" } class="btn btn-success"
															class="glyphicon glyphicon-zoom-in icon-white">
															录入
														</button>
													</td>
												</tr>
											</table>
											
											</s:elseif>
										</form>
									</c:if>
									<c:if test="${size!=0}">
										<b>这个班已经有这门答辩的成绩了，修改即可</b>
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
		<!-- 总分书获取值 -->
		<SCRIPT type="text/javascript">
		
			function zongfen(sel){
				//首先获取这个下拉框所在的 i 和 j 获取id就能找出了 
				var ID=sel.id;
				var i=ID.substring(ID,ID.indexOf(","));
				//alert(i); 有了i就能获取这一行所有的分数 赋予 文本框 id=i,7
				var zf=0;
				for(var j=0;j<6;j++){
					var zhi=document.getElementById(i+","+j).value;
					//转为int
					var zhi=parseInt(zhi);
					zf+=zhi;	
				}
				//赋给i,7
				document.getElementById(i+","+j).value=zf;
				//赋给i,8显示的
				document.getElementById(i+","+(j+1)).value=zf;
			}
		</SCRIPT>
	</body>
</html>


