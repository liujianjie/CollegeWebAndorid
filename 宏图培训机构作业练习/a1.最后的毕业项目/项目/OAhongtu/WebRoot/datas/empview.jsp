<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
		<link rel="stylesheet" type="text/css"
			href="TimePick/jquery.datetimepicker.css" />

		<!-- The styles -->
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		
		<!-- 文本域样式 -->		
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
					
			editor=k.create("#kind_editor1", {
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
		<center><h2 class="animated rubberBand">员工详情信息表</h2></center>
				<table
					class="table table-striped table-bordered bootstrap-datatable datatable responsive">
					<thead>
						<tr>
							<th colspan="4" width="78%">
								基本信息
							</th>
							<th>
								<input type="file" name="fil" style="width:200px;"/>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td width="8%">
								姓名
							</td>
							<td class="center">
								 <input type="text" name="emp.ename" value="${emps.ename }" class="form-control" style="width:300px;">
							</td>
							<td class="center" width="8%">
								性别
							</td>
							<td class="center">
								<input type="text" name="emp.esex" value="${emps.esex }" class="form-control" style="width:300px;">
							</td>
							<td rowspan="5">
								头像
							</td>
						</tr>
						<tr>
							<td>
								联系电话
							</td>
							<td class="center">
								 <input type="text" name="emp.ephone" value="${emps.ephone }" class="form-control" style="width:300px;">
							</td>
							<td class="center">
								籍贯
							</td>
							<td class="center">
								<input type="text" name="emp.ecity" value="${emps.ecity }" class="form-control" style="width:300px;">
							</td>
						</tr>
						<tr>
							<td>
								家庭住址
							</td>
							<td class="center" colspan="3">
								 <input type="text" name="emp.eaddr" value="${emps.eaddr }" class="form-control" style="width:700px;">
							</td>
						</tr>
						<tr>
							<td>
								毕业院校
							</td>
							<td class="center">
								 <input type="text" name="emp.edu" value="${emps.edu }" class="form-control" style="width:300px;">
							</td>
							<td class="center">
								专业
							</td>
							<td class="center">
								<input type="text" name="emp.zhuanye" value="${emps.zhuanye }" class="form-control" style="width:300px;">
							</td>
						</tr>
						<tr>
							<td>
								身份证号
							</td>
							<td class="center">
								 <input type="text" name="emp.ecertid" value="${emps.ecertid }" class="form-control" style="width:300px;">
							</td>
							<td class="center">
								婚姻状况
							</td>
							<td class="center">
								<input type="text" name="emp.hunyin" value="${emps.hunyin }" class="form-control" style="width:300px;">
							</td>
						</tr>
						<tr>
							<td>
								QQ
							</td>
							<td class="center">
								 <input type="text" name="emp.myqq" value="${emps.myqq }" class="form-control" style="width:300px;">
							</td>
							<td class="center">
								入职日期
							</td>
							<td class="center" colspan="2">
								<input type="text" name="emptry" value="${emps.etry }" id="datetimepicker" class="form-control" style="width:300px;">
							</td>
						</tr>
						<tr>
							<td>
								入职部门
							</td>
							<td class="center">
								 <input type="text" name="emp.did" value="${emps.did }" class="form-control" style="width:300px;">
							</td>
							<td class="center">
								职位
							</td>
							<td class="center" colspan="2">
								<input type="text" name="emp.jwork" value="${emps.jwork }" class="form-control" style="width:300px;">
							</td>
						</tr>
						<tr>
							<td>
								性格爱好
							</td>
							<td class="center" colspan="4">
								 <textarea class="autogrow" name="emp.favorite" rows="4" cols="115" id="kind_editor">${emps.favorite }</textarea>
							</td>
						</tr>
						<tr>
							<td>
								专业特长
							</td>
							<td class="center" colspan="4">
								 <textarea class="autogrow" name="emp.techang" rows="4" cols="115" id="kind_editor1">${emps.techang }</textarea>
							</td>
						</tr>
					</tbody>
				</table>
				</div>
		
		<div>
			<table
					class="table table-striped table-bordered bootstrap-datatable datatable responsive">
						<tr>
							<th colspan="7">
								工作经历
							</th>
						</tr>
						<tr>
							<th>
								公司名称
							</th>
							<th>
								公司职务
							</th>
							<th>
								开始时间
							</th>
							<th>
								结束时间
							</th>
							<th>
								证明人
							</th>
							<th>
								证明人电话
							</th>
							
						</tr>
						<tbody id="tb">
						<c:forEach items="${joblist}" var="job">
						<tr>
							<td>
								<input type="text" name="comp" value="${job.JCOMPANY }" class="form-control">
							</td>
							<td>
								<input type="text" name="cjob" value="${job.JEDU }" class="form-control">
							</td>
							<td>
								<input type="text" name="cstart" value="${job.JSTART }" class="form-control">
							</td>
							<td>
								<input type="text" name="cend" value="${job.JEND }" class="form-control">
							</td>
							<td>
								<input type="text" name="cpeople" value="${job.JPEOPLE }" class="form-control">
							</td>
							<td>
								<input type="text" name="cpho" value="${job.JTEL }" class="form-control">
							</td>
						</tr>
						</c:forEach>
						</tbody>
				</table>
		</div>
		
		<div>
			<table
					class="table table-striped table-bordered bootstrap-datatable datatable responsive">
						<tr>
							<th colspan="7">
								紧急联系人
							</th>
						</tr>
						<tr>
							<th>
								姓名
							</th>
							<th>
								职务
							</th>
							<th>
								与本人关系
							</th>
							<th>
								联系电话
							</th>		
							
						</tr>
						<tbody id="family">
						<c:forEach items="${famlist}" var="f">
						<tr>
							<td>
								<input type="text" name="famname" value="${f.FNAME }" class="form-control">
							</td>
							<td>
								<input type="text" name="famjob" value="${f.FJOB }" class="form-control">
							</td>
							<td>
								<input type="text" name="famfre" value="${f.FRELATION }" class="form-control">
							</td>
							<td>
								<input type="text" name="fampho" value="${f.FTEL }" class="form-control">
							</td>
						</tr>
						</c:forEach>
						</tbody>
				</table>
		</div>
		
		<div>
			<table
					class="table table-striped table-bordered bootstrap-datatable datatable responsive" width="80%">
						<tr>
							<th colspan="7">
								教育经历
							</th>
						</tr>
						<tr>
							<th>
								开始时间
							</th>
							<th>
								结束时间
							</th>
							<th>
								学校
							</th>
							<th>
								学历
							</th>		
							
						</tr>
						<tbody id="edu">
						<c:forEach items="${edulist}" var="e">
						<tr>
							<td>
								<input type="text" name="edustart" value="${e.EDSTART }" class="form-control">
							</td>
							<td>
								<input type="text" name="eduend" value="${e.EDEND }" class="form-control">
							</td>
							<td>
								<input type="text" name="edusch" value="${e.EDSCHOOL }" class="form-control">
							</td>
							<td>
								<input type="text" name="edustd" value="${e.EDU }" class="form-control">
							</td>
						</tr>
						</c:forEach>
						</tbody>
				</table>
		</div>
		<div class="box-content">
					<div class="control-group">
					<button type="button" class="btn" style="float:right;width:200px;" onclick="location.href='javascript:history.go(-1)';"><b>返 回</b></button>
                 	</div>
                 </div>
	</body>
</html>
