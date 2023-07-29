<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
								<a href="score/scosx">谈心记录管理</a>
							</li>

						</ul>
					</div>

					<div class="row">
						<div class="box col-md-12">
							<div class="box-inner">
								<div class="box-header well" data-original-title="">
									<h2>
										<i class="glyphicon glyphicon-th-list"></i> 谈心记录
									</h2>

								</div>

								<div class="box-content">
									<div class="alert alert-info" style="height: 70px">
										<div style="float: left; width: 52%; clear: right">
											<form action="says/sayslist" method="post" name="frms">
												<label for="exampleInputEmail1">
													<b>班主任</b>
												</label>
												<select id="selectError" data-rel="chosen" name="ename"
													style="width: 80px;">
													<c:forEach items="${teaches}" var="tes">
														<option value="${tes.EID }" ${tes.EID==emp.eid?"selected":""}>
															${tes.ENAME }
														</option>
													</c:forEach>
												</select>
												<label for="exampleInputEmail1">
													学生状态
												</label>
												<select id="selectError" name="state" data-rel="chosen"
													style="width: 80px;">
													<c:forEach begin="0" end="2" step="1" var="states">
														<option value="${states }" ${states==state?"selected":"" }>
															<c:if test="${states==1}">在读</c:if>
															<c:if test="${states==2}">毕业</c:if>
														</option>
													</c:forEach>
												</select>
												<button type="submit" class="btn btn-success">
													<i class="glyphicon glyphicon-zoom-in icon-white"></i>查询
												</button>
											</form>
										</div>
										<div style="float: left; width: 48%; margin-top: 0px">
											<form action="says/saystoadd" method="post" name="frm1">
												<label for="exampleInputEmail1">
													<b>班级</b>
												</label>
												<select id="selectError" data-rel="chosen" name="classid"
													style="width: 100px; margin-top: -5px">
													<c:forEach items="${clslist}" var="cls">
														<option value="${cls.CLASSID }" ${cls.CLASSID==classid?"selected":"" }>
															${cls.CLASSNAME }
														</option>
													</c:forEach>
												</select>

												<a class="btn btn-success"
													onclick="javascript:document.frm1.submit();"> <i
													class="glyphicon glyphicon-pencil"></i>添加谈心记录 </a>
											</form>
										</div>
									</div>

									<hr>
									<c:if test="${size!=0}">
										<table id="table"
											class="table table-striped table-bordered bootstrap-datatable datatable responsive">
											<thead>
												<tr>
													<th width="16%">
														<div style="text-align: center;">
															序号
														</div>
													</th>
													<th width="16%">
														<div style="text-align: center;">
															班级
														</div>
													</th>
													<th width="16%">
														<div style="text-align: center;">
															谈心对象
														</div>
													</th>
													<th width="16%">
														<div style="text-align: center;">
															谈心标题
														</div>
													</th>

													<th width="16%">
														<div style="text-align: center;">
															时间
														</div>
													</th>
													<th width="20%">
														<div style="text-align: center;">
															操作
														</div>
													</th>
												</tr>
											</thead>
											
												<%
													int i = 1;
												%>
											<c:forEach items="${sayslist}" var="says">
												<tbody>
													<tr onmousemove="jin(this);" id="${says.SAYID }"
														onmouseout="chu(this);">
														<td>
															<div style="text-align: center;">
																<%=i%>
															</div>
														</td>
														<td>
															<div style="text-align: center;">
																<c:forEach items="${clslist}" var="cls">
																	<c:if test="${cls.CLASSID==says.CLASSID}">
																${cls.CLASSNAME }
															</c:if>
																</c:forEach>
															</div>
														</td>
														<td class="center">
															<div style="text-align: center;">
																${says.INTENNAME }
															</div>
	
														</td>
														<td class="center">
															<div style="text-align: center;">
																${says.SAYSCON }
															</div>
														</td>
	
														<td class="center">
															<div style="text-align: center;">
																${says.SAYDATE }
															</div>
														</td>
														<td class="center" width="20%">
															<div style="text-align: center;">
															<!-- 修改 -->
															<a class="btn btn-primary"
																href="says/saystoalert?sayid=${says.SAYID }"> <i
																class="glyphicon glyphicon-edit icon-white"></i> 编辑 </a>
															<a class="btn btn-danger"
																href="says/saysdel?sayid=${says.SAYID }"> <i
																class="glyphicon glyphicon-trash icon-white"></i> 删除 </a>
															</div>
														</td>
													</tr>
												</tody>
<!--												<tbody>-->
													<!-- 谈心内容 和 反馈 -->
													<tr style="display:none " id="d${says.SAYID }">
														<td width="50%" colspan="3">
															<div style="height: 50px">
																<b>谈心内容:</b>${says.SAYSPRO }
															</div>
														</td>
														<td width="50%" colspan="3">
															<b>谈心反馈:</b>${says.SAYBACK }
														</td>
													</tr>
<!--												</tbody>-->
<!--												<tbody>-->
													<tr style="display: none">
														<td rowspan="6">
															&nbsp;
														</td>
													</tr>
<!--												</tbody>-->
												<%
													i++;
												%>
											</c:forEach>
										</table>

									</c:if>
									<c:if test="${size==0}">
										<b>这个班主任的谈心记录不存在，你可以添加</b>
									</c:if>
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
		<!-- 显示谈心内容与反馈 -->
		<SCRIPT type="text/javascript">
			function jin(trs){
				//获取id
				var id=trs.id;
				document.getElementById("d"+id).style.display="";
			}
			
			function chu(trs){
				var id=trs.id;
				document.getElementById("d"+id).style.display="none";
			}
		
		</SCRIPT>
	</body>
</html>

