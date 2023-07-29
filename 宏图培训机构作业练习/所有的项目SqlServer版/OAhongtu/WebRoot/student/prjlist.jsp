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
								<a href="#">项目答辩管理</a>
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
											所有班级的项目答辩成绩
										</c:if>
										<c:if test="${classes!=null}">
											${classes.classname }的${course.couname }成绩
										</c:if>

									</h2>

								</div>

								<div class="box-content">
									<div class="alert alert-info" style="height: 70px">
										<div style="float: left; width: 52%; clear: right">
											<form action=${addtolist==1?"prj/prjlist?addtolist2=1":"prj/prjlist" } method="post">
												<label for="exampleInputEmail1">
													<b>班级</b>
												</label>
												<select name="classid" id="selectError" data-rel="chosen"
													style="width: 100px;">
													<c:forEach items="${clslist}" var="cls">
														<option value="${cls.CLASSID }"
															${cls.CLASSID==classes.classid?"selected":""}>
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
												<button type="submit" class="btn btn-success">
													<i class="glyphicon glyphicon-zoom-in icon-white"></i>查询
												</button>
											</form>
										</div>
										<div style="float: left; width: 48%; margin-top: 0px">
											<button type="button" id="btn" class="btn btn-success">
												<i class="glyphicon glyphicon-pencil"></i>添加项目答辩成绩
											</button>
										</div>
									</div>
									<a href="prj/prjtoadd" id="link" target="_blank"
										style="display: none"></a>
									<script type="text/javascript">
											document.getElementById("btn").onclick=function(){
　　												document.getElementById("link").click();
											}
										</script>
									<hr>

									<form name="frm" action="prj/prjalert" method="post">
										<!-- 这个是班级id和课程id用来修改后返回这里 -->
										<input type="hidden" name="classid" value="${classid }">
										<input type="hidden" name="couid" value="${couid }">

										<c:if test="${size!=0}">
											<table id="table"
												class="table table-striped table-bordered bootstrap-datatable datatable responsive">
												<thead>
													<tr>
														<th>
															<div style="text-align: center;">
																序号
															</div>
														</th>
														<th>
															<div style="text-align: center;">
																班级
															</div>
														</th>
														<th width="14%">
															<div style="text-align: center;">
																科目
															</div>
														</th>
														<th>
															<div style="text-align: center;">
																指导老师
															</div>
														</th>
														<th>
															<div style="text-align: center;">
																评委老师
															</div>
														</th>
														<th>
															<div style="text-align: center;">
																演示日期
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
													<c:forEach items="${list}" var="prj">

														<tr>
															<td>
																<div style="text-align: center;">
																<%=i%>
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																	<c:forEach items="${clslist}" var="cls">
																		<c:if test="${cls.CLASSID==prj.PCLASSID}">
																			<span id="${prj.PID}">${cls.CLASSNAME }</span>
																		</c:if>
																	</c:forEach>
																	<select id="c${prj.PID}"
																		style="width: 83px; display: none">
																		<c:forEach items="${clslist}" var="cls">
																			<option value="${cls.CLASSID }"
																				${cls.CLASSID==prj.PCLASSID?"selected":""} >
																				${cls.CLASSNAME }
																			</option>
																		</c:forEach>
																	</select>
																</div>
															</td>

															<td class="center">
																<div style="text-align: center;">
																	<c:forEach items="${coslist}" var="cos">
																		<c:if test="${cos.couid==prj.PNAME }">
																			<span id="s2${prj.PID}" ondblclick="ycs2(this);">${cos.couname
																				}</span>
																		</c:if>
																	</c:forEach>
																	<select id="k${prj.PID}" onblur="yck(this)"
																		onchange="updk(this);"
																		style="width: 83px; display: none">
																		<c:forEach items="${coslist}" var="cos">
																			<option value="${cos.couid }" ${cos.couid==prj.PNAME?"selected":""} >
																				${cos.couname }
																			</option>
																		</c:forEach>
																	</select>
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																	<c:forEach items="${emplist}" var="emp">
																		<c:if test="${emp.eid==prj.PTEACHER}">
																			<span id="s3${prj.PID}">${emp.ename }</span>
																		</c:if>
																	</c:forEach>
																	<select id="z${prj.PID}"
																		style="width: 83px; display: none">
																		<c:forEach items="${emplist}" var="emp">
																			<option value="${emp.eid }" ${emp.eid==prj.PTEACHER?"selected":""} >
																				${emp.ename }
																			</option>
																		</c:forEach>
																	</select>
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																	<c:forEach items="${emplist}" var="emp">
																		<c:if test="${emp.eid==prj.PTEACHERS}">
																			<span id="s4${prj.PID}" ondblclick="ycs4(this);">${emp.ename
																				}</span>
																		</c:if>
																	</c:forEach>
																	<select id="p${prj.PID}" onblur="ycp(this)"
																		onchange="updp(this);"
																		style="width: 83px; display: none">
																		<c:forEach items="${emplist}" var="emp">
																			<option value="${emp.eid }" ${emp.eid==prj.PTEACHERS?"selected":""} >
																				${emp.ename }
																			</option>
																		</c:forEach>
																	</select>
																</div>
															</td>
															<td class="center">
																<div style="text-align: center;">
																	<span id="s5${prj.PID}" ondblclick="ycs5(this);">${prj.PDATE
																		}</span>
																	<input onblur="ycd(this);" id="d${prj.PID}" type="text"
																		class="form-control" value="${prj.PDATE }"
																		style="width: 100px; display: none">
																</div>
															</td>
															<td class="center" width="20%">
																<div style="text-align: center;">
																	<a class="btn btn-success"
																		href="prj/dfslist?classid=${prj.PCLASSID }&couid=${prj.PNAME }"
																		target="_blank"> <i
																		class="glyphicon glyphicon-zoom-in icon-white"></i> 成绩
																	</a>

																	<a class="btn btn-primary" onclick="alert('请直接双击修改')">
																		<i class="glyphicon glyphicon-edit icon-white"></i> 编辑
																	</a>
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
											<b>这个班的这门课程答辩成绩不存在，你可以添加</b>
										</c:if>
										<!-- 这里是改变了值就放到这可以直接获取给prj 因为a标签不能穿string -->
										<input type="hidden" id="pclassid" name="prj.pclassid">
										<input type="hidden" id="pname" name="prj.pname">
										<input type="hidden" id="pteacher" name="prj.pteacher">
										<input type="hidden" id="pteachers" name="prj.pteachers">
										<input type="hidden" id="pdate" name="prj.pdate">
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
		<!--/fluid-row-->

		<SCRIPT type="text/javascript">
			
			//双击s2 影藏s2 班级 出现下拉框k 科目
			function ycs2(span){
				var Id=span.id;
				var id=Id.substring(Id.indexOf("s2")+2,Id.length);
				span.style.display="none";
				//科目下拉框出现
				document.getElementById("k"+id).style.display="inline";
				document.getElementById("k"+id).focus();
			}
			//失去焦点kid 失去焦点 影藏c id
			function yck(sel){
				var ID=sel.id;
				var id=ID.substring(ID.indexOf("k")+1,ID.length);
				sel.style.display="none";
				//出现span2
				document.getElementById("s2"+id).style.display="inline";
			}
			
			//双击s4 影藏s4   出现下拉框p 老师
			function ycs4(span){
				var Id=span.id;
				var id=Id.substring(Id.indexOf("s4")+2,Id.length);
				span.style.display="none";
				//老师下拉框出现
				document.getElementById("p"+id).style.display="inline";
				document.getElementById("p"+id).focus();
			}
			//失去焦点pid 失去焦点 影藏p id
			function ycp(sel){
				var ID=sel.id;
				var id=ID.substring(ID.indexOf("p")+1,ID.length);
				sel.style.display="none";
				//出现span4
				document.getElementById("s4"+id).style.display="inline";
			}
			//双击s5 影藏s5   出现文本框
			function ycs5(span){
				var Id=span.id;
				var id=Id.substring(Id.indexOf("s5")+2,Id.length);
				span.style.display="none";
				//文本框出现
				document.getElementById("d"+id).style.display="inline";
				document.getElementById("d"+id).focus();
			}
			//失去焦点did 失去焦点 影藏d id
			function ycd(sel){
				var ID=sel.id;
				var id=ID.substring(ID.indexOf("d")+1,ID.length);
				var pdate=sel.value;
				var val=document.getElementById("s5"+id).innerText;
				//这里判断想不想等 不想等就修改
				if(val!=pdate){//修改
					//获取课程值 是下拉框
					var pname=document.getElementById("c"+id).value;
					document.getElementById("pname").value=pname;//赋值;
				 	
					//获取班级
					var classid=document.getElementById("c"+id).value;
					document.getElementById("pclassid").value=classid;//赋值
			//		alert(classid);
					//获取指导老师
					var pteacher=document.getElementById("z"+id).value;
					document.getElementById("pteacher").value=pteacher;
			//		alert(pteacher);
					//获取评委老师
					var pteachers=document.getElementById("p"+id).value;
					document.getElementById("pteachers").value=pteachers;
					//时间
					document.getElementById("pdate").value=pdate;
			//		alert(pteacher);
					var action="http://localhost:8080/OAhongtu/prj/prjalert?prj.pid="+id;
					document.frm.action=action;
					document.frm.submit();
				}else{
					sel.style.display="none";
					//出现span5
					document.getElementById("s5"+id).style.display="inline";
				}
			}
			//改变了课程
			function updk(sel){
				var ID=sel.id;
				//获取课程值 是下拉框
				var pname=sel.value;
				document.getElementById("pname").value=pname;//赋值
				
				var id=ID.substring(ID.indexOf("k")+1,ID.length);
			 	
				//获取班级
				var classid=document.getElementById("c"+id).value;
				document.getElementById("pclassid").value=classid;//赋值
		//		alert(classid);
				//获取指导老师
				var pteacher=document.getElementById("z"+id).value;
				document.getElementById("pteacher").value=pteacher;
		//		alert(pteacher);
				//获取评委老师
				var pteachers=document.getElementById("p"+id).value;
				document.getElementById("pteachers").value=pteachers;
		//		alert(pteacher);
				//获取时间
				var pdate=document.getElementById("d"+id).value;
		//		alert(pdate);
				document.getElementById("pdate").value=pdate;
		//		alert(pdate);
		
				var action="http://localhost:8080/OAhongtu/prj/prjalert?prj.pid="+id;
				document.frm.action=action;
				document.frm.submit();
			}
			//改变了评委老师
			function updp(sel){
				var ID=sel.id;
				//获取评委老师
				var pteachers=sel.value;
				document.getElementById("pteachers").value=pteachers;
				
				var id=ID.substring(ID.indexOf("p")+1,ID.length);
				
				//获取课程值 是下拉框
				var pname=document.getElementById("k"+id).value;
				document.getElementById("pname").value=pname;//赋值
			 	
				//获取班级
				var classid=document.getElementById("c"+id).value;
				document.getElementById("pclassid").value=classid;//赋值
		//		alert(classid);
				//获取指导老师
				var pteacher=document.getElementById("z"+id).value;
				document.getElementById("pteacher").value=pteacher;
		//		alert(pteacher);
				//获取评委老师
				var pteachers=document.getElementById("p"+id).value;
				document.getElementById("pteachers").value=pteachers;
		//		alert(pteacher);
				//获取时间
				var pdate=document.getElementById("d"+id).value;
		//		alert(pdate);
				document.getElementById("pdate").value=pdate;
		//		alert(pdate);
		
				var action="http://localhost:8080/OAhongtu/prj/prjalert?prj.pid="+id;
				document.frm.action=action;
				document.frm.submit();
			}
		</SCRIPT>

	</body>
</html>

