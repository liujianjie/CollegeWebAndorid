<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.ht.vo5.Student"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>

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
								<a href="javascript:history.go(-1);">返回上一页</a>
							</li>
							<li>
								<a href="stu/seldan?intenid=${stu.intenid }">${stu.intenname }的个人信息</a>
							</li>
						</ul>
					</div>
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-user"></i>
										<a href="stu/toalert?intenid=${stu.intenid }">修改${stu.intenname }的个人信息</a>
									</h2>
									
									
								</div>
								<div class="box-content" >
								<form action="stu/alert" name="frm" method="post" enctype="multipart/form-data">
									<table border=0 width="100%">
										<!-- 就读学校和id不用改 -->
										<tr>
											<td rowspan="9">
												<img src="${stu.intenimg }" width="350" height="450">
												<input type="hidden" value="${stu.intenimg }" name="stu.intenimg">
												<input type="hidden" value="${stu.intenid }" name="stu.intenid">
												<br>
												<div class="box-content">
							                      <label for="exampleInputEmail1">选择照片：</label>
													<div class="control-group" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: left;margin-left:10px;margin-top:10px">
							                       		<input type="file" id="tx1" onchange="go()" name="files" >
							                   		</div>
							                    </div>									
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">编号</label>
													<div class="control-group" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:-10px">
							                       		<input type="text" class="form-control" disabled="disabled" value="${stu.intenid }" placeholder="无" style="width:170px;">
							                   		</div>
							                    </div>
												<input type="hidden" value="${stu.intensch}" name="stu.intensch">
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleIn putEmail1">职位&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
													<div class="control-group" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:-10px">
							                       		<input type="text" class="form-control" name="stu.intenjob" value="${stu.intenjob }" placeholder="无" style="width:170px;">
							                   		</div>
							                    </div>
							
											</td>
										</tr>
										<tr>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">姓名</label>
													<div class="control-group" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:-10px">
							                       		<input type="text" class="form-control" name="stu.intenname" value="${stu.intenname }" placeholder="无" style="width:170px;">
							                   		</div>
							                    </div>
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">家庭住址</label>
													<div class="control-group" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:-10px">
							                       		<input type="text" class="form-control" name="stu.intenaddr" value="${stu.intenaddr }" placeholder="无" style="width:170px;">
							                   		</div>
							                    </div>
											</td>
										</tr>
										<tr>
									
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">性别</label>
													<div class="control-group" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:-10px">
							                       		<input type="text" class="form-control" name="stu.intensex" value="${stu.intensex }" placeholder="无" style="width:170px;">
							                   		</div>
							                    </div>
											</td>
											<td>		
												<div class="box-content">
							                      <label for="exampleInputEmail1">家长姓名</label>
													<div class="control-group" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:-10px">
							                       		<input type="text" class="form-control" name="stu.intenfat" value="${stu.intenfat}" placeholder="无" style="width:170px;">
							                   		</div>
							                    </div>
											</td>
	
										</tr>
										<tr>
											
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">年龄</label>
													<div class="control-group" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:-10px">
							                       		<input type="text" class="form-control" name="stu.intenage" value="${stu.intenage }" placeholder="无" style="width:170px;">
							                   		</div>
							                    </div>
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">家长电话</label>
													<div class="control-group" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:-10px">
							                       		<input type="text" class="form-control" name="stu.intenfatel" value="${stu.intenfatel }" placeholder="无" style="width:170px;">
							                   		</div>
							                    </div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">生日</label>
													<div class="control-group" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:-10px">
							                       		<input type="text" class="form-control" name="stu.intenbir" value="${stu.intenbir }" placeholder="请填写生日" style="width:170px;" onclick="WdatePicker({Calendar:true,dateFmt:'yyyy-MM-dd'});" class="Wdate">
							                   		</div>
							                    </div>
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">就读状态</label>
							                      	 <div style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
									                     <select id="selectError" data-rel="chosen" name="stu.intenstatus" style="width:170px;">
															<c:forEach begin="0" end="2" step="1" var="state">
																<option value="${state }" ${state==stu.intenstatus?"selected":""}>
																	<c:if test="${state==0}">意向</c:if>
																	<c:if test="${state==1}">在读</c:if>
																	<c:if test="${state==2}">毕业</c:if>
																</option>
															</c:forEach>								
														</select>
							                   		</div>
							                    </div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">爱好</label>
													<div class="control-group" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:-10px">
							                       		<input type="text" class="form-control" name="stu.intenhob" value="${stu.intenhob }" placeholder="无" style="width:170px;">
							                   		</div>
							                    </div>
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">就读疑问</label>
													<div class="control-group" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:-10px">
							                       		<input type="text" class="form-control" name="stu.intenpeo" value="${stu.intenpeo }" placeholder="无" style="width:170px;">
							                   		</div>
							                    </div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">宿舍</label>
							                      <div style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                        <select id="selectError" data-rel="chosen" name="stu.hourid" style="width:170px;">
							                        	<option>
							                        		无
							                        	</option>
														<c:forEach items="${hrslist}" var="hrs">
															<option value="${hrs.HOURID }" ${hrs.HOURID==stu.hourid?"selected":""}>
																${hrs.HOURNAME }
															</option>
														</c:forEach>								
													</select>
													</div>
							                    </div>
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">联系电话</label>
													<div class="control-group" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:-10px">
							                       		<input type="text" class="form-control" name="stu.intentel" value="${stu.intentel }" placeholder="无" style="width:170px;">
							                   		</div>
							                    </div>
											</td>
										</tr>
										<tr>
											
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">班级</label>
							                      <div style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
								                     <select id="selectError" data-rel="chosen" name="stu.classid" style="width:170px;">
								                     	<option>
							                        		无
							                        	</option>
														<c:forEach items="${clslist}" var="cls">
															<option value="${cls.CLASSID }" ${cls.CLASSID==stu.classid?"selected":""}>
																${cls.CLASSNAME }
															</option>
														</c:forEach>								
													</select>
							                   	</div>
							                    </div>
											</td>
											<td>
												
												<div class="box-content">
							                      <label for="exampleInputEmail1">入学时间</label>
													<div class="control-group" style="height:30px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:-10px">
							                       		<input type="text" class="form-control" name="stu.intentime" value="${stu.intentime }" placeholder="无" style="width:170px;" onclick="WdatePicker({Calendar:true,dateFmt:'yyyy-MM-dd'});" class="Wdate">
							                   		</div>
							                    </div>
											</td>
											<td>
												<button type="submit" class="btn btn-default" style="margin-top:-10px"><b>确认修改</b></button>
											</td>
										</tr>
								
									</table>
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
			<!-- content ends -->
		</div>
		<!--/fluid-row-->

		<!-- external javascript -->

		<SCRIPT type="text/javascript">
			function go(){
				var action="http://localhost:8080/OAhongtu/stu/ylalert";
				document.frm.action=action;
				document.frm.submit();
			}
			
		</SCRIPT>

	</body>
</html>

