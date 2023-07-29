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
		
		<link rel="stylesheet"
			href="kindeditor-4.1.10/themes/default/default.css" />
		<script charset="utf-8" src="kindeditor-4.1.10/kindeditor-min.js"></script>
		<script type="text/javascript">
			var editor;
			KindEditor.ready(function(k){
				 editor=k.create("#kind_editor", {
					items : [
								'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
								'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
								'insertunorderedlist', '|', 'emoticons']
						});
			});
		</script>
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
										修改学生就业情况
									</h2>

								</div>

								<div class="box-content" style="height:670px">
									
									<form name="frm" action="job/jobalert" method="post">
										<input type="hidden" name="job.jobid" value="${job.jobid }">
										<!-- 普通框样式 -->
										<div class="box-content">
											<label for="exampleInputEmail1">
												学生姓名
											</label>
											<div style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left: 20px;margin-top:0px">
											<select name="job.jobstu" id="selectError" data-rel="chosen"  style="width:100px;">
												<c:forEach items="${student}" var="stu">
													<option value="${stu.INTENID }" ${stu.INTENID==job.jobstu?"selected":"" }>
														${stu.INTENNAME }
													</option>
												</c:forEach>						
											</select>
											</div>
										</div>
										<div class="box-content">
											<label for="exampleInputEmail1">
												记录人
											</label>
											<div style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left: 35px;margin-top:0px">
												<select name="job.jobtea" id="selectError" data-rel="chosen"  style="width:100px;">
													<c:forEach items="${teaches}" var="tes">
														<option value="${tes.EID }" ${tes.EID==job.jobtea?"selected":"" }>
															${tes.ENAME }
														</option>
													</c:forEach>								
												</select>
											</div>
										</div>
										<div class="box-content">
											<label for="exampleInputEmail1">
												记录时间
											</label>
											<div class="control-group"
												style="display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 20px; margin-top: 0px">
												<input type="text" name="job.jobdate" class="form-control" value="${job.jobdate }"  
														placeholder="请输入记录时间" style="width:200px;" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});">											
											</div>
										</div>
										<div class="box-content">
											<label for="exampleInputEmail1">
												联系电话
											</label>
											<div class="control-group"
												style="display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 20px; margin-top: 0px">
												<input type="text" name="job.jobnum" value="${job.jobnum }" class="form-control" placeholder="请输入联系电话" style="width:200px;">											
											</div>
										</div>
										<div class="box-content">
											<label for="exampleInputEmail1">
												职位
											</label>
											<div class="control-group"
												style="display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 50px; margin-top: 0px">

												<input type="text" name="job.jobname" value="${job.jobname }" class="form-control" placeholder="请输入职位" style="width:200px;">											

												
											</div>
										</div>

										<div class="box-content">
											<label for="exampleInputEmail1">
												薪水
											</label>
											<div class="control-group"
												style="display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 50px; margin-top: 0px">

												<select name="job.jobsalary" id="selectError" data-rel="chosen"  style="width:100px;">
													<c:forEach begin="3000" end="15000" var="xs" step="500">
														<option value="${xs }" ${xs==job.jobsalary?"selected":"" }>
															${xs }
														</option>
													</c:forEach>								
												</select>		 
												
											</div>
										</div>
										<div class="box-content">
											<label for="exampleInputEmail1">
												位置
											</label>
											<div class="control-group"
												style="display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 50px; margin-top: 0px">

												<input type="text" name="job.jobaddr" value="${job.jobaddr }" class="form-control" placeholder="请输入地理位置" style="width:200px;">											

												
											</div>
										</div>
										<div class="box-content">
											<label for="exampleInputEmail1">
												备注&nbsp;&nbsp;
											</label>
											<div class="control-group"
												style="height: 30px; width: 140px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-top: 0px;margin-left: 44px">
												<textarea rows="10" cols="100" name="job.jobdesc"  id="kind_editor"> 
												${job.jobdesc }
                        						</textarea>
											</div>
										</div>
										<div class="box-content" style="margin-top:170px;">
											<div class="control-group">
												<button type="submit" class="btn btn-default"
													style="width: 100px; margin-left: 83px;">
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

