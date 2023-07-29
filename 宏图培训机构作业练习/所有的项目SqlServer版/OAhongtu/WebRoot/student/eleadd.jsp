<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
										<i class="glyphicon glyphicon-edit"></i>添加单元
									</h2>

								</div>
								<div class="box-content">
									<!-- 内容开始 -->
									<form action="hourse/eleadd" method="post">

										<div class="box-content">
											<div class="control-group">
												<label for="cid">
													单元编号:
												</label>
												<div class="control-group"
													style="height: 40px; width: 300px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 15px;">
													<input type="text" class="form-control" name="ele.eid"
														placeholder="请输入单元编号">
												</div>
											</div>
										</div>

										<div class="box-content">
											<div class="control-group">
												<label for="cname">
													单元名称:
												</label>
												<div class="control-group"
													style="height: 40px; width: 300px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 15px;">
													<input type="text" class="form-control"
														name="ele.ename" placeholder="请输入单元名称">
												</div>
												
											</div>
										</div>

										<!-- submit提交按钮样式 -->
										<div class="box-content">
											<div class="control-group">
												<button type="submit" class="btn btn-default"
													style="width: 100px; margin-left: 150px;">
													添加
												</button>
											</div>
										</div>
									</form>
									<!-- 内容结束 -->
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
