<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'emplist.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
			.roll ul li {
				list-style: none;
				float: left;
				margin: 2px;
				padding: 3px 0 0 10px
			}
		</style>
	</head>

	<body>
		<jsp:include page="common.jsp"></jsp:include>
				<%
					List list=(List)request.getAttribute("stlist");
				%>
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
								<a href="#">学生权限管理</a>
							</li>
						</ul>
					</div>
	<form action="liulirong/emp!saverootstu" method="post">
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner roll">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-user"></i> 学生权限管理
									</h2>

								</div>
								<input type="hidden" name="stuid" value="${studentid }">
								
								<ul>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="1" <%if(list.contains("1")){%>checked="checked"<%} %>>
												首页
											</label>
										</div>
									</li>
									
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="10" <%if(list.contains("10")){%>checked="checked"<%} %>>
												教务管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="70" <%if(list.contains("70")){%>checked="checked"<%} %>>
												教员反馈（学生）
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="19" <%if(list.contains("19")){%>checked="checked"<%} %>>
												学生管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="71" <%if(list.contains("71")){%>checked="checked"<%} %>>
												成绩管理(学生)
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="72" <%if(list.contains("72")){%>checked="checked"<%} %>>
												项目答辩管理(学生)
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="73" <%if(list.contains("73")){%>checked="checked"<%} %>>
												谈心记录管理(学生)
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="74" <%if(list.contains("74")){%>checked="checked"<%} %>>
												学生总结管理(学生)
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="75" <%if(list.contains("75")){%>checked="checked"<%} %>>
												请假管理(学生)
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="76" checked disabled <%if(list.contains("76")){%>checked="checked"<%} %>>
												意见反馈(学生)
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="51" <%if(list.contains("51")){%>checked="checked"<%} %>>
												电脑领用管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="77" <%if(list.contains("77")){%>checked="checked"<%} %>>
												备用电脑领用(学生)
											</label>
										</div>
									</li>
									
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="57" <%if(list.contains("57")){%>checked="checked"<%} %>>
												查看学生公告
											</label>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
					
					<div class="control-group">
                   		<button type="submit" class="btn btn-default">修改</button>
                   	</div>
		</form>
				</div>
			</div>
		</div>
	</body>
</html>
