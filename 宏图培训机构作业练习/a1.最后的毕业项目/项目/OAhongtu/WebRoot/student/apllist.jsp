<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!-- 未处理 -->

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

				<div id="content" class="col-lg-10 col-sm-10" style="width:100%;">
					<!-- content starts -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="homepage(tea).jsp">首页</a>
							</li>
							<li>
								<a href="#">备用电脑申请审核</a>
							</li>
							
						</ul>
					</div>
					
					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i>
										电脑申请信息
									</h2>

								</div>
								
								<div class="box-content">
									<div class="alert alert-info" style="height: 40px;">
										
									</div>
									<form name="frm" action="apl/aplstatus" method="post">
									<table id="table"
										class="table table-striped table-bordered bootstrap-datatable datatable responsive">
										<thead>
											<tr>
												<th width="8%">
													序号
												</th>
												<th width="8%">
													姓名
												</th>
												<th width="28%">
													申请原因
												</th>
												<th width="10%">
													开始时间
												</th>
												<th width="10%">
													结束时间
												</th>
												<th width="8%">
													天数
												</th>
												<th width="8%">
													状态
												</th>
												<th width="20%">
													操作
												</th>
											</tr>
										</thead>
										<tbody>
										<%int i=1; %>
										<c:forEach items="${list}" var="apl">
											<tr>
												<td >
													<%=i %>
												</td>
												<td class="center" >
													${apl.INTENNAME }
												</td>
											
												<td class="center">
													${apl.ANAME }
												</td>
												<td class="center">
													${apl.ASTARTTIME }
												</td>
												<td class="center">
													${apl.AENDTIME }
												</td>
												<th>
													${apl.ATIME }天
												</th>
												<td class="center">
													<!-- 只有审核中1和不同意存在2 -->
													<c:if test="${apl.ASTATE==1}">
														<span class="label-warning label label-default">审核中</span>
													</c:if>
													<c:if test="${apl.ASTATE==2}">
														<span class="label label-danger">不同意</span>
													</c:if>
												</td>
												<td class="center">
													<c:if test="${apl.ASTATE==1}">
														<a class="btn btn-success" onclick="javascript:xshr(this);" id="${apl.AID }" > <i
															class="glyphicon glyphicon-edit icon-white"></i> 同意 </a>
														<!-- 不同意审核人变回自己 只是状态改变 -->
														<a class="btn btn-danger" onclick="return confirm('确定吗？')" href="apl/aplstatus3?aid=${apl.AID }&astate=2" id="${apl.AID }2"> <i
														class="glyphicon glyphicon-trash icon-white"></i> 不同意 </a>
													</c:if>
													<div id="${apl.AID }d" style="display: none">
														
														<select name="ashr" onchange="tongyi(this);" id="${apl.AID }s" style="width:140px;"	>
															<option value="${apl.ASHR }">选择下一个审核人</option>
															<option value="0">无</option>
															<c:forEach items="${emplist}" var="emp">
																<option value="${emp.eid}">
																	${emp.ename }
																</option>
			
															</c:forEach>
														</select>
														
														<button type="button" id="${apl.AID }b" onclick="quxiao(this);" class="btn btn-success" class="glyphicon glyphicon-zoom-in icon-white">取消</button>
													</div>
												</td>
											</tr>
											<%i++; %>									
										</c:forEach>
										</tbody>
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
				<!--/#content.col-md-0-->
			</div>
			<!--/fluid-row-->
			<SCRIPT type="text/javascript">
			
				//当点击同意 影藏同意和不同意 出现选择下一审核人和取消
				function xshr(a){
					var ID=a.id;
					document.getElementById(ID).style.display="none";
					document.getElementById(ID+"2").style.display="none";
					document.getElementById(ID+"d").style.display="inline";
				}
				//当点击取消 显示同意和不同意 
				function quxiao(a){
					var Id=a.id;
					
					var ID=Id.substring(0,Id.indexOf("b"));
					
					//影藏div
					document.getElementById(ID+"d").style.display="none";
					//出现同意不同意
					
					document.getElementById(ID).style.display="inline";
					document.getElementById(ID+"2").style.display="inline";
				}
				//当点击审核人后 要获取到lid 和 员工id 就是审核人 lshr 并且lstate改为同意3
				function tongyi(a){
					var Id=a.id;
					var ID=Id.substring(0,Id.indexOf("s"));//id
					//发生跳转 修改为同意 
					var ashr=a.value;
					var action="http://localhost:8080/OAhongtu/apl/aplstatus?aid="+ID+"&astate=3&ateashr="+ashr;;
					document.frm.action=action;
					document.frm.submit();
				}
			</SCRIPT>
	</body>
</html>

