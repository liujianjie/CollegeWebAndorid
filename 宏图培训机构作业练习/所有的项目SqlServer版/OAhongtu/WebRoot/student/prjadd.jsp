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
														style="width: 130px;">
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
									
									<!-- 判断是不是有组长的项目 -->
									<s:if test="course.couname=='JSP'">
									<form name="frm" action="prj/prjaddjsp" method="post" onsubmit="return fuzhi()">
										<!-- 父表班级和科目id可以单独分开 因为是一样的 还有时间 知道老师 评委老师 班级-->
										<input type="hidden" name="classid" value="${classid }">
										<input type="hidden" name="couid" value="${couid }">
										<input type="hidden" name="prj.pname" value="${course.couid }">
										<input type="hidden" name="prj.pteacher" value="${teacherr.eid }">
										<input type="hidden" name="prj.pteachers" value="${teachers.eid }">
										<input type="hidden" name="prj.pdate" value="${time }">
										<input type="hidden" name="prj.pclassid" value="${classid }">
										<table id="table1"
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
											<tr>
												<TH>
													组长
												</TH>
												<th>
													成员
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
											<c:set var="m" value="0"></c:set> <!-- 控制每个学生不同 -->
											<tbody>
											<c:forEach items="${cslist}" var="cs" varStatus="n">
												<tr>
													<td rowspan="2" id="<%=i %>t" ondblclick="changer(this)" style="display:none ">
														<select id="<%=i %>r" style="width: 90px;">
															<c:forEach items="${cslist}" var="cstu" >
																<option value="${cstu.INTENID }">
																	${cstu.INTENNAME }
																</option>
															</c:forEach>
														</select>
														<!-- value 为td的合并行数 -->
														<input type="hidden" id="<%=i %>b"/>
													</td>
													<!-- 用来控制合并的数 -->
													<%if(i==0||i%2==0){ %>
													<td rowspan="2" id="<%=i %>" ondblclick="changer(this)">
														<select name="dheads"  id="<%=i %>z" style="width: 90px;">
															<c:forEach items="${cslist}" var="cstu" >
																<option value="${cstu.INTENID }">
																	${cstu.INTENNAME }
																</option>
															</c:forEach>
														</select>
														<!-- 保存他有多少行 用js -->
														<input name="count" type="hidden" id="<%=i %>c" value="2"/>
													</td>
													
													<%} %>
													<td>
														<select name="dmembers" id="<%=i %>" style="width: 90px;">
															<c:forEach items="${cslist}" var="cstu" varStatus="o">
																<option value="${cstu.INTENID }" ${m==o.index?"selected":"" }>
																	${cstu.INTENNAME }
																</option>
															</c:forEach>
														</select>
														<!-- 让m加1 -->
														<c:set var="m" value="${n.index+1}"></c:set>
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
												<td colspan="10" align="right">
													<!-- submit提交按钮样式 -->
													<button type="submit" ${sizes==0?"disabled":"" } class="btn btn-success"
														class="glyphicon glyphicon-zoom-in icon-white">
														录入
													</button>
												</td>
											</tr>
										</table>
										</form>
									</s:if>
									<s:elseif test="course.couname=='WEB'" >
										<form name="frm" action="prj/prjaddjsp" method="post" onsubmit="return fuzhis()">
										<!-- 父表班级和科目id可以单独分开 因为是一样的 还有时间 知道老师 评委老师 班级-->
										<input type="hidden" name="classid" value="${classid }">
										<input type="hidden" name="couid" value="${couid }">
										<input type="hidden" name="prj.pname" value="${course.couid }">
										<input type="hidden" name="prj.pteacher" value="${teacherr.eid }">
										<input type="hidden" name="prj.pteachers" value="${teachers.eid }">
										<input type="hidden" name="prj.pdate" value="${time }">
										<input type="hidden" name="prj.pclassid" value="${classid }">
										<table id="table2"
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
											<tr>
												<TH>
													组长
												</TH>
												<th>
													成员
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
											<c:set var="m" value="0"></c:set> <!-- 控制每个学生不同 -->
											<tbody>
											<c:forEach items="${cslist}" var="cs" varStatus="n">
												<tr>
													<!-- 用来备胎的。。 -->
													<td rowspan="5" id="<%=i %>t" ondblclick="changers(this)" style="display:none ">
														<select id="<%=i %>r" style="width: 90px;">
															<c:forEach items="${cslist}" var="cstu" >
																<option value="${cstu.INTENID }">
																	${cstu.INTENNAME }
																</option>
															</c:forEach>
														</select>
														<!-- value 为td的合并行数 -->
														<input type="hidden" id="<%=i %>b"/>
													</td>
													<!-- 用来控制合并的数 -->
													<%if(i==0||i%5==0){ %>
													<td rowspan="5" id="<%=i %>" ondblclick="changers(this)">
														<select id="<%=i %>z" name="dheads" style="width: 90px;">
															<c:forEach items="${cslist}" var="cstu" >
																<option value="${cstu.INTENID }">
																	${cstu.INTENNAME }
																</option>
															</c:forEach>
														</select>
														<!-- value 为td的合并行数 -->
														<input type="hidden" name="count" id="<%=i %>c" value="5"/>
													</td>
													<%} %>
													<td>
														<select name="dmembers" id="<%=i %>" style="width: 90px;" >
															<c:forEach items="${cslist}" var="cstu" varStatus="o">
																<option value="${cstu.INTENID }" ${m==o.index?"selected":"" }>
																	${cstu.INTENNAME }
																</option>
															</c:forEach>
														</select>
														<!-- 让m加1 -->
														<c:set var="m" value="${n.index+1}"></c:set>
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
												<td colspan="10" align="right">
													<!-- submit提交按钮样式 -->
													<button type="submit" ${sizes==0?"disabled":"" } class="btn btn-success"
														class="glyphicon glyphicon-zoom-in icon-white">
														录入
													</button>
												</td>
											</tr>
										</table>
										</form>
									</s:elseif>
									<s:else>
										<form name="frm" action="prj/prjadd" method="post">
										<!-- 父表班级和科目id可以单独分开 因为是一样的 还有时间 知道老师 评委老师 班级-->
										<input type="hidden" name="classid" value="${classid }">
										<input type="hidden" name="couid" value="${couid }">
										<input type="hidden" name="prj.pname" value="${course.couid }">
										<input type="hidden" name="prj.pteacher" value="${teacherr.eid }">
										<input type="hidden" name="prj.pteachers" value="${teachers.eid }">
										<input type="hidden" name="prj.pdate" value="${time }">
										<input type="hidden" name="prj.pclassid" value="${classid }">
										<table id="table"
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
											<tr>
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
										</form>
									</s:else>
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
			//改变合并行数 jsp
			function changer(td){
				
<!--				var id=td.id;-->
<!--				-->
<!--				//自己先变长-->
<!--				var row=td.rowSpan;-->
<!--				td.rowSpan=row+1;-->
<!--				document.getElementById("2").style.display="none";//把那个增长的那个组长去掉-->
<!--				document.getElementById("3t").style.display="";//让那个偷天换日的备胎换上 id为去掉的组长后一个-->
<!--				-->
<!--				//后面的相继把原来的去掉 t的上去-->
<!--				document.getElementById("4").style.display="none";-->
<!--				document.getElementById("5t").style.display="";-->
<!--				document.getElementById("6").style.display="none";-->
<!--				document.getElementById("7t").style.display="";-->
<!--				document.getElementById("8").style.display="none";-->
<!--				document.getElementById("9t").style.display="";-->
<!--				document.getElementById("10").style.display="none";-->
<!--				document.getElementById("11t").style.display="";-->
<!--				document.getElementById("12").style.display="none";-->
<!--				document.getElementById("13t").style.display="";-->
<!--				document.getElementById("14").style.display="none";-->
<!--				document.getElementById("15t").style.display="";-->
				
				//增加格子开始
				var Id=td.id;	//Id用来判断是备胎还是正室 和增加多少单元格的
				//重新排过版
				var table=document.getElementById("table1");
				var trs=table.getElementsByTagName("tr");
				var Idlength=trs.length;
				if(Id.indexOf("t")<0){//正室
					var row=td.rowSpan;	
					if(row==2){//2 当单元格rowspan为2时
						//判断如果当点了下面还点上面就 不要在执行这段代码了
						for(var i=parseInt(Id);i<Idlength-2;i++){
							//正室
							var tds=document.getElementById(i);
							//备胎
							var tdss=document.getElementById(i+"t");
							if(tds.rowSpan==3||tdss.rowSpan==3||tds.rowSpan==4||tdss.rowSpan==4){
								return;
							}
							i=i+1;
						}
						td.rowSpan=row+1;//增长
						for(var i=parseInt(Id);i<50;i++){
							//获取
							if(i==parseInt(Id)){
								i=i+2;
							}
							//第一次 为2  第二次 为4了
							document.getElementById(i).style.display="none";//把那个增长的那个组长去掉
							document.getElementById(i+"z").name="hehe";//真
							//count
							document.getElementById(i+"c").name="haha";
							i=i+1;//3
							document.getElementById(i+"t").style.display="";//让那个偷天换日的备胎换上 id为去掉的组长后一个
							document.getElementById(i+"r").name="dheads";//备
							//count
							document.getElementById(i+"b").name="count";
						}
					}
					if(row==3){//3 当单元格rowspan为3
						td.rowSpan=row+1;
						for(var i=parseInt(Id);i<50;i++){
							if(i==parseInt(Id)){
								i=i+3;
							}
							//第一次为3 不是第一的话就为5了
							document.getElementById(i+"t").style.display="none";
							document.getElementById(i+"r").name="hehe";
							//count
							document.getElementById(i+"b").name="haha";
							i=i+1;//4
							document.getElementById(i).style.display="";
							document.getElementById(i+"z").name="dheads";
							//count
							document.getElementById(i+"c").name="count";
						}
					}
				}
				if(Id.indexOf("t")>0){//是备胎
					//强转
					var id=Id.substring(0,Id.indexOf("t"));
					var row=td.rowSpan;
					if(row==2){
						td.rowSpan=row+1;
						for(var i=parseInt(id);i<50;i++){
							//第一次加2
							if(i==parseInt(id)){
								i=i+2;
							}
							//不是第一次的话 那就为4了
							document.getElementById(i+"t").style.display="none";//备胎走人
							document.getElementById(i+"r").name="hehe";
							//count
							document.getElementById(i+"b").name="haha";
							i=i+1;//6
							document.getElementById(i).style.display="";//正室回复
							document.getElementById(i+"z").name="dheads";
							//count
							document.getElementById(i+"c").name="count";
						}
					}
					if(row==3){
						//判断如果上面有3的 下面就别要4
						for(var i=0;i<Idlength-2;i++){
							//正室
							var tds=document.getElementById(i);
							if(tds.rowSpan==3){
								return;
							}
							i=i+1;
						}
						td.rowSpan=row+1;
						for(var i=parseInt(id);i<50;i++){
							//第一次加3
							if(i==parseInt(id)){
								i=i+3;
							}
							//不是第一次的话 那就为4了
							document.getElementById(i).style.display="none";
							document.getElementById(i+"z").name="hehe";
							//count
							document.getElementById(i+"b").name="haha";
							i=i+1;//6
							document.getElementById(i+"t").style.display="";
							document.getElementById(i+"r").name="dheads";
							//count
							document.getElementById(i+"c").name="count";
						}
						
					}
				}
			}
			//增加格子结束
			//给count加上值
			function fuzhi(){
				var sel=document.getElementsByName("dheads");
				var cou=document.getElementsByName("count");
				//获取id
				var rows=new Array();//用来接收rowSpan的合并数赋给count
				for(var i=0;i<sel.length;i++){
					var id=0;
					if((sel[i].id).indexOf("z")>0){//正式
						var Id=sel[i].id;
						id=Id.substring(0,Id.indexOf("z"));
						//获取td的rowSpan
						var row=document.getElementById(id).rowSpan;
						rows[i]=row;
					}
					if((sel[i].id).indexOf("r")>0){//备胎
						var Id=sel[i].id;
						id=Id.substring(0,Id.indexOf("r"));
						//获取备胎td的rowSpan
						var row=document.getElementById(id+"t").rowSpan;
						rows[i]=row;
					}
				}
				//开始赋值
				for(var i=0;i<cou.length;i++){
					var id=0;
					if((cou[i].id).indexOf("c")>0){//正式
						var Id=cou[i].id;
						id=Id.substring(0,Id.indexOf("c"));
						//赋值
						document.getElementById(id+"c").value=rows[i];
					}
					if((cou[i].id).indexOf("b")>0){//备胎
						var Id=cou[i].id;
						id=Id.substring(0,Id.indexOf("b"));
						//赋值
						document.getElementById(id+"b").value=rows[i];
					}
				}
				return true;
			}
			
			//WEB开始
			function changers(td){
<!--				document.getElementById("5").style.display="none";-->
<!--				document.getElementById("6t").style.display="";-->
<!--				document.getElementById("10").style.display="none";-->
<!--				document.getElementById("11t").style.display="";-->
				var Id=td.id;	//Id用来判断是备胎还是正室 和增加多少单元格的
				//重新排过版
				var table=document.getElementById("table2");
				var trs=table.getElementsByTagName("tr");
				var Idlength=trs.length;//防止回按
				if(Id.indexOf("t")<0){//正室 -1
					var row=td.rowSpan;
					if(row==5){//2 当单元格rowspan为2时
						//判断如果当点了下面还点上面就 不要在执行这段代码了
						for(var i=parseInt(Id);i<Idlength-3;i++){
							//正室
							var tds=document.getElementById(i);
							//备胎
							var tdss=document.getElementById(i+"t");
							if(tds.rowSpan==6||tds.rowSpan==7||tdss.rowSpan==6||tdss.rowSpan==7){
								return;
							}
							i=i+4;//本来是+5的 但是上面又加了
						}
						td.rowSpan=row+1;//增长
						for(var i=parseInt(Id);i<50;i++){
							//获取
							if(i==parseInt(Id)){
								i=i+5;
							}
							//第一次 为5  第二次 为10了
							document.getElementById(i).style.display="none";//把那个增长的那个组长去掉
							document.getElementById(i+"z").name="hehe";
							//count
							document.getElementById(i+"c").name="haha";
							i=i+1;//6
							document.getElementById(i+"t").style.display="";//让那个偷天换日的备胎换上 id为去掉的组长后一个
							document.getElementById(i+"r").name="dheads";//备
							//count
							document.getElementById(i+"b").name="count";
							i=i+3;//9
						}
					}
					if(row==6){//6 当单元格rowspan为6
						td.rowSpan=row+1;
						for(var i=parseInt(Id);i<50;i++){
							if(i==parseInt(Id)){
								i=i+6;
							}
							//第一次为6 第二次为 11了 
							document.getElementById(i+"t").style.display="none";
							document.getElementById(i+"r").name="hehe";
							//count
							document.getElementById(i+"b").name="haha";
							i=i+1;//7
							document.getElementById(i+"t").style.display="";//两个都是备胎上
							document.getElementById(i+"r").name="dheads";//备
							//count
							document.getElementById(i+"b").name="count";
							i=i+3;//10
						}
					}
				}
				if(Id.indexOf("t")>0){//是备胎
					//截取
					var id=Id.substring(0,Id.indexOf("t"));
					var row=td.rowSpan;
					if(row==5){
						td.rowSpan=row+1;
						for(var i=parseInt(id);i<50;i++){
							//第一次加5
							if(i==parseInt(id)){
								i=i+5;
							}
							//不是第一次的话 那就为10了
							document.getElementById(i+"t").style.display="none";//备胎
							document.getElementById(i+"r").name="hehe";//备
							//count
							document.getElementById(i+"b").name="haha";
							i=i+1;//6
							document.getElementById(i+"t").style.display="";//备胎
							document.getElementById(i+"r").name="dheads";//备
							//count
							document.getElementById(i+"b").name="count";
							i=i+3;//9
						}
					}
					if(row==6){
						td.rowSpan=row+1;
						for(var i=parseInt(id);i<50;i++){
							//第一次加6
							if(i==parseInt(id)){
								i=i+6;
							}
							//不是第一次的话 那就为4了
							document.getElementById(i+"t").style.display="none";
							document.getElementById(i+"r").name="hehe";//备
							//count
							document.getElementById(i+"b").name="haha";
							i=i+1;//7
							document.getElementById(i+"t").style.display="";
							document.getElementById(i+"r").name="dheads";//备
							//count
							document.getElementById(i+"b").name="count";
							i=i+3;//10
						}
					}
				}
			}
			//给count加上值
			function fuzhis(){
				var sel=document.getElementsByName("dheads");
				var cou=document.getElementsByName("count");
				//获取id
				var rows=new Array();//用来接收rowSpan的合并数赋给count
				for(var i=0;i<sel.length;i++){
					var id=0;
					if((sel[i].id).indexOf("z")>0){//正式
						var Id=sel[i].id;
						id=Id.substring(0,Id.indexOf("z"));
						//获取td的rowSpan
						var row=document.getElementById(id).rowSpan;
						rows[i]=row;
					}
					if((sel[i].id).indexOf("r")>0){//备胎
						var Id=sel[i].id;
						id=Id.substring(0,Id.indexOf("r"));
						//获取备胎td的rowSpan
						var row=document.getElementById(id+"t").rowSpan;
						rows[i]=row;
					}
				}
				//开始赋值
				for(var i=0;i<cou.length;i++){
					var id=0;
					if((cou[i].id).indexOf("c")>0){//正式
						var Id=cou[i].id;
						id=Id.substring(0,Id.indexOf("c"));
						//赋值
						document.getElementById(id+"c").value=rows[i];
					}
					if((cou[i].id).indexOf("b")>0){//备胎
						var Id=cou[i].id;
						id=Id.substring(0,Id.indexOf("b"));
						//赋值
						document.getElementById(id+"b").value=rows[i];
					}
				}
				return true;
			}
		</SCRIPT>
	</body>
</html>


