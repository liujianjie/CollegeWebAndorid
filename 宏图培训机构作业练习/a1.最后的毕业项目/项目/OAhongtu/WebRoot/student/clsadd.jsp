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
								<a href="#">学生管理</a>
							</li>
							<li>
								<a href="javascript:history.go(-1);">班级管理</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-edit"></i>
										添加班级
									</h2>

								</div>

								<div class="box-content">
									
									<form name="frm" action="classes/clsadd" method="post">
										<!-- 普通框样式 -->
										<div class="box-content">
											<label for="exampleInputEmail1">
												班级名称：
												
											</label>
											<div class="control-group"
												style="display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 0px; margin-top: 0px">
												<input type="text" name="classes.classname" placeholder="请输入班级名称" class="form-control" style="width:160px;">											
											</div>
											
											<label for="exampleInputEmail1" style="margin-left:20px;">
												班级人数：
											</label>
											<div class="control-group"
												style="display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 0px; margin-top: 0px">
												<input type="text" name="classes.classcount" placeholder="请输入班级人数" class="form-control" style="width:160px;">											
											</div>
											
										</div>
										<div class="box-content">
											<label for="exampleInputEmail1">
												班级位置：
											</label>
											<div class="control-group"
												style="display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 0px; margin-top: 0px">
												<input type="text" name="classes.classaddr" placeholder="请输入班级具体位置" class="form-control"  style="width:380px;">											
											</div>
										</div>
										
										<div class="box-content">
											<label for="exampleInputEmail1">
												任课老师：
											</label>
											<select name="classes.empteach" id="selectError" data-rel="chosen"  style="width:160px;">
												<option>--请选择任课老师--</option>
												<c:forEach items="${emplist}" var="emp">
													
													<option value="${emp.eid }">
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
													<option value="${emp.eid }">
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
													<option value="${emp.eid }">
														${emp.ename }
													</option>
												</c:forEach>							
											</select>
										</div>
										
										<div class="box-content">
											<div class="control-group">
												<button type="submit" class="btn btn-default"
													style="width: 100px; margin-left: 180px;margin-top:8px;">
													<b>添 加</b>
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

		<!-- external javascript -->

		<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

		<!-- library for cookie management -->
		<script src="js/jquery.cookie.js"></script>
		<!-- calender plugin -->
		<script src='bower_components/moment/min/moment.min.js'></script>
		<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
		<!-- data table plugin -->
		<script src='js/jquery.dataTables.min.js'></script>

		<!-- select or dropdown enhancer -->
		<script src="bower_components/chosen/chosen.jquery.min.js"></script>
		<!-- plugin for gallery image view -->
		<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
		<!-- notification plugin -->
		<script src="js/jquery.noty.js"></script>
		<!-- library for making tables responsive -->
		<script src="bower_components/responsive-tables/responsive-tables.js"></script>
		<!-- tour plugin -->
		<script
			src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
		<!-- star rating plugin -->
		<script src="js/jquery.raty.min.js"></script>
		<!-- for iOS style toggle switch -->
		<script src="js/jquery.iphone.toggle.js"></script>
		<!-- autogrowing textarea plugin -->
		<script src="js/jquery.autogrow-textarea.js"></script>
		<!-- multiple file upload plugin -->
		<script src="js/jquery.uploadify-3.1.min.js"></script>
		<!-- history.js for cross-browser state change on ajax -->
		<script src="js/jquery.history.js"></script>
		<!-- application script for Charisma demo -->
		<script src="js/charisma.js"></script>
	</body>
</html>

