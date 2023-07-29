<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

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

		<!-- The styles -->
		
	</head>

	<body>
	<jsp:include page="common.jsp"></jsp:include>
	<div class="ch-container">
    <div class="row"> 


				<div id="content" class="col-lg-10 col-sm-10" style="width:100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="homepage(tea).jsp">首页</a>
							</li>
							<li>
								<a href="#">请/休假申请</a>
							</li>
						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 请/休假信息
									</h2>

								</div>
								<div class="box-content">
									<div class="alert alert-info" style="height: 70px;">
										<a class="btn btn-success" href="liulirong/exam!toholadd.action" style="float: right;"> <i
															class="glyphicon glyphicon-pencil"></i> 请/休假申请 </a>
									</div>
									<table
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th width="7%">
													序号
												</th>
												<th width="7%">
													姓名
												</th>
												<th width="10%">
													开始时间
												</th>
												<th width="5%">
													天数
												</th>
												<th width="10%">
													直属领导
												</th>
												<th>
													申请事由
												</th>
												<th width="8%">
													休假天数
												</th>
												<th width="7%">
													类型
												</th>
												<th>
													状态
												</th>
												<th width="24%">
													操作
												</th>
												
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${hlist}" var="h">
												<tr>
													<td>
														
														${h.HID }
													</td>
													<td class="center">
														<c:forEach items="${elist}" var="ee">
															${h.EID == ee.eid?ee.ename:'' }
														</c:forEach>
													</td>
													<td class="center">
														${h.HSTART }
													</td>  
													<td class="center"> 
														${h.HDAY } 
													</td>
													<td class="center">
														<c:forEach items="${emplist }" var="e">
															${h.HOLMAN==e.DMID?e.DMNAME:'' }
														</c:forEach>
													</td>
													<td class="center">
														${h.HOLDESC }
													</td> 
													<td class="center">    
														<c:forEach items="${elist}" var="ee">
															${h.EID == ee.eid?ee.eday:'' }
														</c:forEach>
														天
													</td> 
													<td class="center">
														${h.HKIND }
													</td>  
													<td class="center">
														<c:choose>
															<c:when test="${h.HSTATU==0 }">
																<span class="label label-default">未提交</span>
															</c:when>
															<c:when test="${h.HSTATU==1 }">
																<span class="label label-warning">审核中</span>
															</c:when>
															<c:when test="${h.HSTATU==2 }">
																<span class="label label-success">同意</span>
															</c:when>
															<c:when test="${h.HSTATU==3 }">
																<span class="label label-danger">不同意</span>
															</c:when>
														</c:choose>
													</td>
													<td class="center">
														<c:choose>
															<c:when test="${h.HSTATU==0 }">
																<a class="btn btn-success" href="liulirong/exam!toupload?hol.hid=${h.HID }"> <i
																	class="glyphicon glyphicon-zoom-in icon-white"></i>提交 </a>
																<a class="btn btn-primary" href="liulirong/exam!gethol?hol.hid=${h.HID }"> <i
																	class="glyphicon glyphicon-edit icon-white"></i> 编辑 </a>
																<a class="btn btn-danger" href="liulirong/exam!holdel?hol.hid=${h.HID }"> <i
																	class="glyphicon glyphicon-trash icon-white"></i> 删除 </a>			
															</c:when>  
															 <c:when test="${h.HOLMAN==teacher.eid and h.HSTATU==1 }">
															 	<input type="hidden" id="hid" value="${h.HID }">
															 	<input type="hidden" id="eid" value="${h.EID }">
															 	<input type="hidden" id="hday" value="${h.HDAY }">
															 	<input type="hidden" id="hkind" value="${h.HKIND }">
															 <div style="display:inline;" id="ds">
																<a class="btn btn-success" id="agree"> <i
																	class="glyphicon glyphicon-zoom-in icon-white"></i>同意 </a>
																<a class="btn btn-danger" href="liulirong/exam!toupdNO?hol.hid=${h.HID }"> <i
																	class="glyphicon glyphicon-trash icon-white"></i> 不同意 </a>
															</div> 
														
															 <div style="display:none;" id="sdiv">
															 	<select id="hman" name="status">
															 	<option value="1">选择下一个审核人</option>
																<option value="0">无</option>
															 		<c:forEach items="${emplist}" var="emp">
															 			<option value="${emp.DMID }">${emp.DMNAME }</option>
															 		</c:forEach>
															 	</select>
															 	<a class="btn btn-success" onclick="dcommit();"> <i
																class="glyphicon glyphicon-zoom-in icon-white"></i>确定 </a>
															 </div>
														</c:when>
														</c:choose>
													
													</td>
												</tr>
											</c:forEach>
										</tbody>
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
				<!--/#content.col-md-0-->
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
			<script type="text/javascript">
				$("#agree").click(function(){
					$("#ds").slideUp();
					$("#sdiv").slideDown();
				});
				
			</script>
			
			<script type="text/javascript">
				function dcommit(){
					var hman=$("#hman").val();
					var hid=$("#hid").val();
					var eid=$("#eid").val();
					var hday=$("#hday").val();
					var hkind=$("#hkind").val();
					alert(hkind);
					if(hkind=="休假"){
						hkind=5;
					}
					alert(hkind);
					location.href="liulirong/exam!toupdholman?status="+hman+"&hid="+hid+"&eid="+eid+"&hday="+hday+"&hkind="+hkind;
				}
				
		</script>

	</body>
</html>
