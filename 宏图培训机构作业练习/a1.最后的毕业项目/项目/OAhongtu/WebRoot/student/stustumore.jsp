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
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-user"></i>
										<a href="stu/seldan2?intenid=${stu.intenid }">${stu.intenname }的个人信息</a>
									</h2>
									
									
								</div>
								<div class="box-content">
									<table border=0 width="100%">
										<!-- 就读学校和id不用改 -->
										<tr>
											<td rowspan="8">
												<img src="${stu.intenimg }" width="350" height="450">
												<br>
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">编号</label>
													<div class="control-group" style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                       		${stu.intenid }
							                   		</div>
							                    </div>
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">职位&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
													<div class="control-group" style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                       		${stu.intenjob }
							                   		</div>
							                    </div>
							
											</td>
										</tr>
										<tr>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">姓名</label>
													<div class="control-group" style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                       		${stu.intenname }
							                   		</div>
							                    </div>
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">家庭住址</label>
													<div class="control-group" style="height:20px;width:170px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                       		${stu.intenaddr }
							                   		</div>
							                    </div>
											</td>
										</tr>
										<tr>
									
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">性别</label>
													<div class="control-group" style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                       		${stu.intensex }
							                   		</div>
							                    </div>
											</td>
											<td>		
												<div class="box-content">
							                      <label for="exampleInputEmail1">家长姓名</label>
													<div class="control-group" style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                       		${stu.intenfat}
							                   		</div>
							                    </div>
											</td>
	
										</tr>
										<tr>
											
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">年龄</label>
													<div class="control-group" style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                       		${stu.intenage }
							                   		</div>
							                    </div>
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">家长电话</label>
													<div class="control-group" style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                       		${stu.intenfatel }
							                   		</div>
							                    </div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">生日</label>
													<div class="control-group" style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                       		${stu.intenbir }
							                   		</div>
							                    </div>
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">就读状态</label>
							                      	 <div style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
									                     <c:if test="${stu.intenstatus==0 }">意向</c:if><c:if test="${stu.intenstatus==1 }">在读</c:if><c:if test="${stu.intenstatus==2 }">毕业</c:if>
							                   		</div>
							                    </div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">爱好</label>
													<div class="control-group" style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                       		${stu.intenhob }
							                   		</div>
							                    </div>
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">就读疑问</label>
													<div class="control-group" style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                       		${stu.intenpeo }
							                   		</div>
							                    </div>
											</td>
										</tr>
										<tr>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">宿舍</label>
							                      <div style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                        ${stu.hourse.hourname }
													</div>
							                    </div>
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">联系电话</label>
													<div class="control-group" style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                       		${stu.intentel }
							                   		</div>
							                    </div>
											</td>
										</tr>
										<tr>
											
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">班级</label>
							                      <div style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
								                    ${stu.classes.classname }
							                   	</div>
							                    </div>
											</td>
											<td>
												<div class="box-content">
							                      <label for="exampleInputEmail1">入学时间</label>
													<div class="control-group" style="height:20px;width:150px;display: inline-block;margin-bottom: 0;vertical-align: middle;margin-left:10px;margin-top:0px">
							                       		${stu.intentime }
							                   		</div>
							                    </div>
											</td>
											<td>
												<button type="button" class="btn btn-default" style="width:90px;" onclick="history.go(-1)"><b>返 回 </b></button>
											</td>
										</tr>
								
									</table>
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

	</body>
</html>

