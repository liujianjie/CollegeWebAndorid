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
								<a href="homepage2.jsp">首页</a>
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
										修改请假信息
									</h2>

								</div>

								<div class="box-content">
									<form name="frm" action="lev/levalert" method="post">
										<input type="hidden" name="lev.lstate" value="${lev.lstate }">
										<input type="hidden" name="lev.lid" value="${lev.lid }">
										<input type="hidden" name="lev.lstuid" value="${lev.lstuid }"/>
										<input type="hidden" name="lev.lshr" value="${lev.lshr }">
									
										<h2 class="animated rubberBand" style="margin-left: 240px">
											修改请假信息表
										</h2>
										<br />
										
										<div class="box-content">
											<label for="exampleInputEmail1">
												申请人：
											</label>
											<div class="control-group"
												style="height: 30px; width: 210px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 50px">
												<input type="text" class="form-control" disabled="disabled"
													value="${student.intenname }" style="width: 150px;">
											</div>
											<label for="exampleInputEmail1">
												审核人：&nbsp;&nbsp;
											</label>
											<div class="control-group"
												style="height: 30px; width: 140px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-top: 0px">
												<input type="text" class="form-control" disabled="disabled"
													value="${emp.ename }" style="width: 150px;">
											</div>
										</div>

										<div class="box-content">
											<label for="exampleInputEmail1">
												时 &nbsp;&nbsp;间：&nbsp;
											</label>
											<div class="control-group"
												style="height: 30px; width: 193px; display: inline-block; margin-bottom: 0; vertical-align: middle;margin-left: 50px">
												<input type="text" class="form-control" value="${lev.lstarttime }"
													name="lev.lstarttime"  placeholder="请选择开始时间"
													style="width: 184px;"
													onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});">
											</div>
											-----
											<div class="control-group"
												style="height: 30px; width: 200px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 10px">
												<input type="text" class="form-control" name="lev.lendtime" value="${lev.lendtime }"
												 	placeholder="请选择结束时间" style="width: 200px;"
													onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});">
											</div>
										</div>

										<div class="box-content">
											<label for="exampleInputEmail1">
												预计请假时间：
											</label>
											<div class="control-group"
												style="height: 30px; width: 190px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-top: 0px;margin-left: 5px">
												<input type="text" name="lev.ltime" value="${lev.ltime }" class="form-control"
													placeholder="请填写大概需要时间" style="width: 185px;">
											</div>
											<label for="exampleInputEmail1">
												填写时间：&nbsp;&nbsp;
											</label>
											<div class="control-group"
												style="height: 30px; width: 140px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-top: 0px">
												<input type="text" class="form-control" name="lev.ldate" value="${lev.ldate }"
												 	placeholder="请选择时间" style="width: 156px;"
													onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});">
											</div>
										</div>

										<div class="box-content">
											<label for="exampleInputEmail1">
												申请请假事由：&nbsp;&nbsp;
											</label>
											<div class="control-group"
												style="height: 30px; width: 140px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-top: 0px">
												<textarea rows="10" cols="100" name="lev.lname" placeholder="请说明原因" id="kind_editor">
												${lev.lname} 
                        						</textarea>
											</div>
										</div>
										<br />
										<br />
										<br />
										<br />
										<br />
										<br />
										<br />
										<br />
										<br />
										<div class="box-content">
											<label for="exampleInputEmail1"
												style="color: red; font-size: 12px;">
												备注：一天以上的请假要校主管领导同意
											</label>
										</div>

										<div class="box-content">
											<div class="control-group">
												<button type="submit" class="btn btn-default"
													style="width: 100px; margin-left: 260px;">
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
		<!--/fluid-row-->

	</body>
</html>

