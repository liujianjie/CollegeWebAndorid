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
											学生成绩
										</c:if>
										<c:if test="${classes!=null}">
											${classes.classname }的${course.couname }成绩
										</c:if>

									</h2>

								</div>

								<div class="box-content">
									<div class="alert alert-info" style="height: 70px">
										<div style="float: left; width: 52%; clear: right">
											<form action=${addtolist==1?"score/scolist?addtolist=1":"score/scolist" } method="post">
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
												<i class="glyphicon glyphicon-pencil"></i>添加成绩
											</button>
										</div>
									</div>
									<a href="score/scotoadd" id="link" target="_blank"
										style="display: none"></a>
									<script type="text/javascript">
											document.getElementById("btn").onclick=function(){
　　												document.getElementById("link").click();
											}
										</script>
									<hr>

									<form name="frm" action="score/scoalert" method="post">
										<input type="hidden" name="classid"
											value="${classes.classid }">
										<input type="hidden" name="couid" value="${course.couid }">
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
																所属班级
															</div>
														</th>
														<th>
															<div style="text-align: center;">
																姓名
															</div>
														</th>
														<th>
															<div style="text-align: center;">
																科目
															</div>
														</th>
														<th>
															<div style="text-align: center;">
																分数
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
													<c:forEach items="${list}" var="sco">
														<!-- 这个是学生id -->
														<span style="display: none" id="d${sco.SCOID}">${sco.STUID}</span>

														<tr>
															<td width="10%">
																<div style="text-align: center;">
																	<%=i%>
																</div>
															</td>
															<td class="center" width="17%">
																<div style="text-align: center;">
																	${sco.CLASSNAME }
																</div>

															</td>
															<td class="center" width="17%">
																<div style="text-align: center;">
																	${sco.INTENNAME }
																</div>
															</td>
															<td class="center" width="17%">
																<div style="text-align: center;">
																	<span id="${sco.SCOID}" ondblclick="chuselect(this);">${sco.COUNAME
																		}</span>
																	<!-- 下拉框样式 -->

																	<select id="s${sco.SCOID}" onblur="yc(this)"
																		onchange="updselect(this);"
																		style="width: 83px; display: none">
																		<c:forEach items="${coslist}" var="cos">
																			<option value="${cos.couid }"
																				${cos.couid==sco.SCONAME?"selected":""} >
																				${cos.couname }
																			</option>
																		</c:forEach>
																	</select>
																</div>
															</td>
															<td class="center" width="15%">
																<div style="text-align: center;">
																	<div>
																	<span id="c${sco.SCOID}" ondblclick="chustext(this);">${sco.SCORE
																		}</span>
																	</div>
																	<!-- 文本框 -->
																	<!-- 普通框样式 -->
																	<div class="control-group"
																		style="height: 0px; width: 0px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: -70px; margin-top: -20px">
																		<input onblur="updtext(this);" id="t${sco.SCOID}"
																			type="text" class="form-control"
																			value="${sco.SCORE }"
																			style="width: 80px; display: none">
																	</div>
																</div>
															</td>

															<td class="center">
																<div style="text-align: center;">
																	<!-- 修改 -->
																	<a class="btn btn-primary" id="b${sco.SCOID}"
																		onclick="alerts(this);"> <i
																		class="glyphicon glyphicon-edit icon-white"></i> 编辑 </a>
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
											<b>这个班的这门课程成绩不存在，你可以添加</b>
										</c:if>
										<input type="hidden" id="sconame" name="sco.sconame">
										<input type="hidden" id="score" name="sco.score">
										<input type="hidden" id="stuid" name="sco.stuid">
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
			//点击编辑
			function alerts(a){
				var id=a.id;
				
				var id=id.substring(id.indexOf("b")+1,id.length)
				
				//影藏span分数
				document.getElementById("c"+id).style.display="none";
				//出来
				document.getElementById("t"+id).style.display="inline";
				//获取焦点
				document.getElementById("t"+id).select();
			}
			function chuselect(span){ 	//下拉框出来
				span.style.display="none";
				var ID=span.id;
				
				document.getElementById("s"+ID).style.display="inline";
				document.getElementById("s"+ID).focus();
			}
			function yc(sel){		//下拉框影藏 sapn数来
				sel.style.display="none";
				var ID=sel.id;
				var id=ID.substring(ID.indexOf("s")+1,ID.length);
				
				document.getElementById(id).style.display="inline";
			}
			function chustext(span){
				span.style.display="none";
				
				var ID=span.id;
				//截取
				var id=ID.substring(ID.indexOf("c")+1,ID.length);

				document.getElementById("t"+id).style.display="inline";
				//获取焦点
				document.getElementById("t"+id).select();
			}
			
			function updselect(sel){
				var ID=sel.id;
				//获取课程值 是下拉框
				var sconames=document.getElementById(ID).value;
				document.getElementById("sconame").value=sconames;//赋值
		
				var id=ID.substring(ID.indexOf("s")+1,ID.length);

				//获取分数
				var scores=document.getElementById("t"+id).value;
				document.getElementById("score").value=scores;//赋值
					
				//差个姓名id
				var stuids=document.getElementById("d"+id).innerText;
				document.getElementById("stuid").value=stuids;
		//		alert(id);
				var action="http://localhost:8080/OAhongtu/score/scoalert?sco.scoid="+id;
				document.frm.action=action;
				document.frm.submit();
			}
			function updtext(txt){
				var ID=txt.id;
				var id=ID.substring(ID.indexOf("t")+1,ID.length);
				
				//当失去焦点后 对比是修改还是影藏
				var spant=document.getElementById("c"+id).innerText;
				//去修改
				if(spant!=txt.value){
					//获取课程值 是下拉框
					var sconames=document.getElementById("s"+id).value;
					document.getElementById("sconame").value=sconames;//赋值
					
					//获取分数
					document.getElementById("score").value=txt.value;//赋值 因为txt就是分数的text
						
					//差个姓名id 		span用innerText获值
					var stuids=document.getElementById("d"+id).innerText;
					document.getElementById("stuid").value=stuids;
		
					var action="http://localhost:8080/OAhongtu/score/scoalert?sco.scoid="+id;
					document.frm.action=action;
					document.frm.submit();
				}
				//回来 隐藏自己
				txt.style.display="none";
				//span出来
				document.getElementById("c"+id).style.display="inline";
			}
		</SCRIPT>

	</body>
</html>

