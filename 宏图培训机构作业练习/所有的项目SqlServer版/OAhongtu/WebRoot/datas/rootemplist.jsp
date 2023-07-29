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
				margin: 15px;
				padding: 3px 0 0 10px
			}
		</style>
	</head>

	<body>
		<jsp:include page="common.jsp"></jsp:include>
				<%
					List list=(List)request.getAttribute("rlist");
				%>
		<div class="ch-container">
			<div class="row">
				<div id="content" class="col-lg-10 col-sm-10" style="width: 100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							
							<li>
								<a href="#">员工权限管理</a>
							</li>
							<li>
								<a href="javascript:history.go(-1);">返回上一页</a>
							</li>
						</ul>
					</div>
	<form action="liulirong/emp!saverootemp" method="post">
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner roll">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-user"></i> 员工权限管理
									</h2>

								</div>
								<input type="hidden" name="userid" value="${uid }">
								
								
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
												<input type="checkbox" name="mid" checked value="2" <%if(list.contains("2")){%>checked="checked"<%} %>>
												日常办公
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="3" <%if(list.contains("3")){%>checked="checked"<%} %>>
												部门管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="4" <%if(list.contains("4")){%>checked="checked"<%} %>>
												员工管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="5" <%if(list.contains("5")){%>checked="checked"<%} %>>
												工作日志
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="81" <%if(list.contains("81")){%>checked="checked"<%} %>>
												我的工作日志
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="6" <%if(list.contains("6")){%>checked="checked"<%} %>>
												值班管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="7" <%if(list.contains("7")){%>checked="checked"<%} %>>
												我的值班
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="8" <%if(list.contains("8")){%>checked="checked"<%} %>>
												值班安排
											</label>
										</div>
									</li>
<!--									<li>-->
<!--										<div class="checkbox">-->
<!--											<label>-->
<!--												<input type="checkbox" name="mid" value="9" <%if(list.contains("9")){%>checked="checked"<%} %>>-->
<!--												待办事项-->
<!--											</label>-->
<!--										</div>-->
<!--									</li>-->
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" checked value="10" <%if(list.contains("10")){%>checked="checked"<%} %>>
												教务管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="11" <%if(list.contains("11")){%>checked="checked"<%} %>>
												课程管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="12" <%if(list.contains("12")){%>checked="checked"<%} %>>
												教员反馈
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="13" <%if(list.contains("13")){%>checked="checked"<%} %>>
												查看反馈（领导）
											</label>
										</div>
									</li>
									
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="14" <%if(list.contains("14")){%>checked="checked"<%} %>>
												查看反馈（教员）
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="15" <%if(list.contains("15")){%>checked="checked"<%} %>>
												研讨会管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="16" <%if(list.contains("16")){%>checked="checked"<%} %>>
												查看研讨会
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="17" <%if(list.contains("17")){%>checked="checked"<%} %>>
												课程进度管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="18" <%if(list.contains("18")){%>checked="checked"<%} %>>
												查看课程进度
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" checked value="19" <%if(list.contains("19")){%>checked="checked"<%} %>>
												学生管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="20" <%if(list.contains("20")){%>checked="checked"<%} %>>
												班级管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="21" <%if(list.contains("21")){%>checked="checked"<%} %>>
												宿舍管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="22" <%if(list.contains("22")){%>checked="checked"<%} %>>
												学生信息管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="23" <%if(list.contains("23")){%>checked="checked"<%} %>>
												成绩管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="24" <%if(list.contains("24")){%>checked="checked"<%} %>>
												项目答辩管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="25" <%if(list.contains("25")){%>checked="checked"<%} %>>
												谈心记录管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="26" <%if(list.contains("26")){%>checked="checked"<%} %>>
												学生总结管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="27" <%if(list.contains("27")){%>checked="checked"<%} %>>
												就业管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="28" <%if(list.contains("28")){%>checked="checked"<%} %>>
												请假管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="29" <%if(list.contains("29")){%>checked="checked"<%} %>>
												意见反馈
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" checked value="30" <%if(list.contains("30")){%>checked="checked"<%} %>>
												财务管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="31" <%if(list.contains("31")){%>checked="checked"<%} %>>
												收入管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="32" <%if(list.contains("32")){%>checked="checked"<%} %>>
												支出管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="33" <%if(list.contains("33")){%>checked="checked"<%} %>>
												学生收费
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="34" <%if(list.contains("34")){%>checked="checked"<%} %>>
												工资管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" checked value="35" <%if(list.contains("35")){%>checked="checked"<%} %>>
												招生管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="36" <%if(list.contains("36")){%>checked="checked"<%} %>>
												招生名单
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="37" <%if(list.contains("37")){%>checked="checked"<%} %>>
												预定报名学生
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="38" <%if(list.contains("38")){%>checked="checked"<%} %>>
												考情管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" checked value="63" <%if(list.contains("63")){%>checked="checked"<%} %>>
												查看考情
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="62" <%if(list.contains("63")){%>checked="checked"<%} %>>
												我的考情
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="39" <%if(list.contains("39")){%>checked="checked"<%} %>>
												考情异议申报
											</label>
										</div>
									</li>
<!--									<li>-->
<!--										<div class="checkbox">-->
<!--											<label>-->
<!--												<input type="checkbox" name="mid" value="40" <%if(list.contains("40")){%>checked="checked"<%} %>>-->
<!--												办公用品管理-->
<!--											</label>-->
<!--										</div>-->
<!--									</li>-->
<!--									<li>-->
<!--										<div class="checkbox">-->
<!--											<label>-->
<!--												<input type="checkbox" name="mid" value="41" <%if(list.contains("41")){%>checked="checked"<%} %>>-->
<!--												办公用品申购-->
<!--											</label>-->
<!--										</div>-->
<!--									</li>-->
<!--									<li>-->
<!--										<div class="checkbox">-->
<!--											<label>-->
<!--												<input type="checkbox" name="mid" value="42" <%if(list.contains("42")){%>checked="checked"<%} %>>-->
<!--												办公用品申领-->
<!--											</label>-->
<!--										</div>-->
<!--									</li>-->
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="43" checked <%if(list.contains("43")){%>checked="checked"<%} %>>
												请假/加班管理
											</label>
										</div>
									</li>
									
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="44" <%if(list.contains("44")){%>checked="checked"<%} %>>
												请/休假申请
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="80" <%if(list.contains("80")){%>checked="checked"<%} %>>
												我的请/休假申请
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="45" <%if(list.contains("45")){%>checked="checked"<%} %>>
												加班申请
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="61" <%if(list.contains("61")){%>checked="checked"<%} %>>
												我的加班申请
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" checked value="46" <%if(list.contains("46")){%>checked="checked"<%} %>>
												巡查管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="47" <%if(list.contains("47")){%>checked="checked"<%} %>>
												班级巡查
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="48" <%if(list.contains("48")){%>checked="checked"<%} %>>
												我的班级巡查
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="49" <%if(list.contains("49")){%>checked="checked"<%} %>>
												宿舍巡查
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="50" <%if(list.contains("50")){%>checked="checked"<%} %>>
												我的宿舍巡查
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
												<input type="checkbox" name="mid" value="52" <%if(list.contains("52")){%>checked="checked"<%} %>>
												备用电脑领用
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="53" <%if(list.contains("53")){%>checked="checked"<%} %>>
												通知/公告
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" checked value="54" <%if(list.contains("54")){%>checked="checked"<%} %>>
												发布员工公告
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="55" <%if(list.contains("55")){%>checked="checked"<%} %>>
												查看员工公告
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="56" <%if(list.contains("56")){%>checked="checked"<%} %>>
												发布学生公告
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
<!--									<li>-->
<!--										<div class="checkbox">-->
<!--											<label>-->
<!--												<input type="checkbox" name="mid" value="61" <%if(list.contains("61")){%>checked="checked"<%} %>>-->
<!--												学生收费管理-->
<!--											</label>-->
<!--										</div>-->
<!--									</li>-->
<!--									<li>-->
<!--										<div class="checkbox">-->
<!--											<label>-->
<!--												<input type="checkbox" name="mid" value="62" <%if(list.contains("62")){%>checked="checked"<%} %>>-->
<!--												收费标准管理-->
<!--											</label>-->
<!--										</div>-->
<!--									</li>-->
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="58" <%if(list.contains("58")){%>checked="checked"<%} %>>
												权限管理
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="59" <%if(list.contains("59")){%>checked="checked"<%} %>>
												员工权限
											</label>
										</div>
									</li>
									<li>
										<div class="checkbox">
											<label>
												<input type="checkbox" name="mid" value="60" <%if(list.contains("60")){%>checked="checked"<%} %>>
												学生权限
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
