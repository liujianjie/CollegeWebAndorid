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
										添加谈心记录
									</h2>

								</div>

								<div class="box-content" style="height:470px">
									
									<form name="frm" action="says/saysadd" method="post">
										<!-- 普通框样式 -->
										<div class="box-content">
											<label for="exampleInputEmail1">
												谈心对象
											</label>
											<div style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:40px;margin-top:0px">
												<select name="says.sayface" id="selectError" data-rel="chosen"  style="width:100px;">
													<c:forEach items="${student}" var="stu">
														<option value="${stu.INTENID }">
															${stu.INTENNAME }
														</option>
													</c:forEach>							
												</select>
											</div>
										</div>
										
										<div class="box-content">
											<label for="exampleInputEmail1">
												谈心时间
												<%Date date=new Date();
												DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
												String datea=df.format(date);
												%>
											</label>
											<div class="control-group"
												style="display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 40px; margin-top: 0px">
												<input type="text" name="says.saydate" class="form-control" value="<%=datea %>" 
													style="width:200px;" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy-MM-dd'});">											
											</div>
										</div>
										<div class="box-content">
											<label for="exampleInputEmail1">
												谈心标题
											</label>
											<div class="control-group"
												style="display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 40px; margin-top: 0px">

												<input type="text" name="says.sayscon" class="form-control" placeholder="请输入谈心标题" style="width:200px;">

											
											</div>
										</div>

										<div class="box-content" style="margin-top: 10px">
											<label for="exampleInputEmail1">
												谈心内容
											</label>
											<div class="control-group"
												style="height: 30px; width: 140px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-top: 0px; margin-left: 40px">
												<textarea rows="10" cols="100" name="says.sayspro"  id="kind_editor"> 
                        						</textarea>
											</div>
										</div>

										<div class="box-content" style="margin-top:180px;">
											<div class="control-group">
												<button type="submit" class="btn btn-default"
													style="width: 100px; margin-left: 100px;">
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
		
	</body>
</html>

