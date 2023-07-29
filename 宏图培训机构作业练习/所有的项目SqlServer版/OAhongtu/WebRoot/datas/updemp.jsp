<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		<form action="liulirong/emp!empupd.action" method="post"
			enctype="multipart/form-data">
			<div class="ch-container">
				<center>
					<span class="animated rubberBand"
						style="font-size: 36px; Color: #48c9d7;">员工详情信息</span>
					<div
						style="height: 30px; width: 50px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 10px;">
						<select data-rel="chosen" name="emp.estatus" style="width: 85px;">
							<option value="0" ${emps.estatus==0?'selected':'' }>
								试用期
							</option>
							<option value="1" ${emps.estatus==1?'selected':'' } >
								转正
							</option>
							<option value="2" ${emps.estatus==2?'selected':'' }>
								离职
							</option>
						</select>
					</div>




				</center>
				<table
					class="table table-striped table-bordered bootstrap-datatable datatable responsive">
					<thead>
						<tr>
							<th colspan="4" width="78%">
								基本信息
								<input type="hidden" name="emp.eid" value="${emps.eid }" />
							</th>
							<th>
								<input type="file" name="fil" value="${emps.face }"
									style="width: 200px;" />
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td width="8%">
								姓名
							</td>
							<td class="center">
								<input type="text" name="emp.ename" value="${emps.ename }"
									class="form-control" style="width: 300px;">
							</td>
							<td class="center" width="8%">
								性别
							</td>
							<td class="center">
								<label class="radio-inline">
									<input type="radio" name="emp.esex" ${emps.esex==
										'男'?'checked':'' } value="男">
									男
								</label>
								<label class="radio-inline">
									<input type="radio" name="emp.esex" ${emps.esex==
										'女'?'checked':'' } value="女">
									女
								</label>
							</td>
							<td rowspan="5">
								<img src="imgs/${emps.face }" width="210px" height="250px" />
							</td>
						</tr>
						<tr>
							<td>
								联系电话
							</td>
							<td class="center">
								<input type="text" name="emp.ephone" value="${emps.ephone }"
									class="form-control" style="width: 300px;">
							</td>
							<td class="center">
								籍贯
							</td>
							<td class="center">
								<input type="text" name="emp.ecity" value="${emps.ecity }"
									class="form-control" style="width: 300px;">
							</td>
						</tr>
						<tr>
							<td>
								家庭住址
							</td>
							<td class="center" colspan="3">
								<input type="text" name="emp.eaddr" value="${emps.eaddr }"
									class="form-control" style="width: 700px;">
							</td>
						</tr>
						<tr>
							<td>
								毕业院校
							</td>
							<td class="center">
								<input type="text" name="emp.edu" value="${emps.edu }"
									class="form-control" style="width: 300px;">
							</td>
							<td class="center">
								专业
							</td>
							<td class="center">
								<input type="text" name="emp.zhuanye" value="${emps.zhuanye }"
									class="form-control" style="width: 300px;">
							</td>
						</tr>
						<tr>
							<td>
								身份证号
							</td>
							<td class="center">
								<input type="text" name="emp.ecertid" value="${emps.ecertid }"
									class="form-control" style="width: 300px;">
							</td>
							<td class="center">
								婚姻状况
							</td>
							<td class="center">
								<input type="text" name="emp.hunyin" value="${emps.hunyin }"
									class="form-control" style="width: 300px;">
							</td>
						</tr>
						<tr>
							<td>
								QQ
							</td>
							<td class="center">
								<input type="text" name="emp.myqq" value="${emps.myqq }"
									class="form-control" style="width: 300px;">
							</td>
							<td class="center">
								入职日期
							</td>
							<td class="center" colspan="2">
								<input type="text" name="emptry"
									value="<fmt:formatDate value="${emps.etry }" pattern="yyyy/MM/dd"/>"
									onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});"
									class="form-control" style="width: 300px;">
							</td>
						</tr>
						<tr>
							<td>
								入职部门
							</td>
							<td class="center">
								<select name="emp.did" data-rel="chosen" style="width: 300px;">
									<c:forEach items="${dlist}" var="d">
										<option value="${d.did }" ${d.did==emps.did?'selected':'' }>
											${d.dname }
										</option>
									</c:forEach>
								</select>
							</td>
							<td class="center">
								职位
							</td>
							<td class="center" colspan="2">
								<select name="emp.jwork" data-rel="chosen" style="width: 300px;">
									<option value="学院院长" ${emps.jwork=='学院院长'?'selected':'' }>
										学院院长
									</option>
									<option value="学院总监" ${emps.jwork=='学院总监'?'selected':'' }>
										学院总监
									</option>
									<option value="副校长" ${emps.jwork=='副校长'?'selected':'' }>
										副校长
									</option>
									<option value="教学部主任" ${emps.jwork=='教学部主任'?'selected':'' }>
										教学部主任
									</option>
									<option value="高级讲师" ${emps.jwork=='高级讲师'?'selected':'' }>
										高级讲师
									</option>
									<option value="讲师" ${emps.jwork=='讲师'?'selected':'' }>
										讲师
									</option>
									<option value="学工处主任" ${emps.jwork=='学工处主任'?'selected':'' }>
										学工处主任
									</option>
									<option value="班主任" ${emps.jwork=='班主任'?'selected':'' }>
										班主任
									</option>
									<option value="招生处主任" ${emps.jwork=='招生处主任'?'selected':'' }>
										招生处主任
									</option>
									<option value="招生老师" ${emps.jwork=='招生老师'?'selected':'' }>
										招生老师
									</option>
									<option value="后勤部主任" ${emps.jwork=='后勤部主任'?'selected':'' }>
										后勤部主任
									</option>
									<option value="行政部主任" ${emps.jwork=='行政部主任'?'selected':'' }>
										行政部主任
									</option>
									<option value="财务部主任" ${emps.jwork=='财务部主任'?'selected':'' }>
										财务部主任
									</option>
								</select>

							</td>
						</tr>
						<tr>
							<td>
								性格爱好
							</td>
							<td class="center" colspan="4">
								<textarea class="autogrow" name="emp.favorite" rows="4"
									cols="115" id="kind_editor">${emps.favorite }</textarea>
							</td>
						</tr>
						<tr>
							<td>
								专业特长
							</td>
							<td class="center" colspan="4">
								<textarea class="autogrow" name="emp.techang" rows="4"
									cols="115" id="kind_editor1">${emps.techang }</textarea>
							</td>
						</tr>
					</tbody>
				</table>
				<!--				<div class="box-content">-->
				<!--					<div class="control-group" style="margin-left:920px">-->
				<!--						<button type="submit" class="btn" style="width:120px"><b>修&nbsp;&nbsp;&nbsp;&nbsp;改</b></button>-->
				<!--						<button type="button" class="btn" style="float:left;width:120px;" onclick="location.href='javascript:history.go(-1)';"><b>返&nbsp;&nbsp;&nbsp;&nbsp;回</b></button>-->
				<!--                    </div>-->
				<!--                    </div>-->
				<div class="box-content">
					<div class="control-group">
						<button type="submit" class="btn"
							style="float: right; width: 120px;">
							<b>修&nbsp;&nbsp;&nbsp;&nbsp;改</b>
						</button>
						<button type="button" class="btn"
							style="float: left; width: 120px;"
							onclick="location.href='javascript:history.go(-1)';">
							<b>返&nbsp;&nbsp;&nbsp;&nbsp;回</b>
						</button>
					</div>
				</div>
			</div>
		</form>
		<br />
		<hr>
		<a class="btn btn-success" id="job"> <i
			class="glyphicon glyphicon-zoom-in icon-white"></i> 工作经历 </a>
		<a class="btn btn-success" id="fam"> <i
			class="glyphicon glyphicon-zoom-in icon-white"></i> 家庭联系人 </a>
		<a class="btn btn-success" id="edu"> <i
			class="glyphicon glyphicon-zoom-in icon-white"></i> 教育经历 </a>

		<div id="tjob" style="display: none; margin-top: 10px">
			<form action="liulirong/emp!updjob" method="post">
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
								<input type="hidden" name="jid" value="${job.JID }">
								<input type="hidden" name="eid" value="${job.EID }">
								<td>
									<input type="text" name="comp" value="${job.JCOMPANY }"
										class="form-control">
								</td>
								<td>
									<input type="text" name="cjob" value="${job.JEDU }"
										class="form-control">
								</td>
								<td>
									<input type="text" name="cstart" value="${job.JSTART }"
										onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});"
										class="form-control">
								</td>
								<td>
									<input type="text" name="cend" value="${job.JEND }"
										onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});"
										class="form-control">
								</td>
								<td>
									<input type="text" name="cpeople" value="${job.JPEOPLE }"
										class="form-control">
								</td>
								<td>
									<input type="text" name="cpho" value="${job.JTEL }"
										class="form-control">
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="box-content">
					<div class="control-group">
						<button type="submit" class="btn"
							style="float: right; width: 120px;">
							<b>修&nbsp;&nbsp;&nbsp;&nbsp;改</b>
						</button>
						<button type="button" class="btn"
							style="float: left; width: 120px;"
							onclick="location.href='javascript:history.go(-1)';">
							<b>返&nbsp;&nbsp;&nbsp;&nbsp;回</b>
						</button>
					</div>
				</div>
				<br />
		<hr>
			</form>
		</div>

		<div id="tfam" style="display: none; margin-top: 10px">
			<form action="liulirong/emp!updfam" method="post">
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
								<input type="hidden" name="fid" value="${f.FID }" />
								<input type="hidden" name="eid" value="${f.EID }" />
								<td>
									<input type="text" name="famname" value="${f.FNAME }"
										class="form-control">
								</td>
								<td>
									<input type="text" name="famjob" value="${f.FJOB }"
										class="form-control">
								</td>
								<td>
									<input type="text" name="famfre" value="${f.FRELATION }"
										class="form-control">
								</td>
								<td>
									<input type="text" name="fampho" value="${f.FTEL }"
										class="form-control">
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="box-content">
					<div class="control-group">
						<button type="submit" class="btn"
							style="float: right; width: 120px;">
							<b>修&nbsp;&nbsp;&nbsp;&nbsp;改</b>
						</button>
						<button type="button" class="btn"
							style="float: left; width: 120px;"
							onclick="location.href='javascript:history.go(-1)';">
							<b>返&nbsp;&nbsp;&nbsp;&nbsp;回</b>
						</button>
					</div>
				</div>
				<br />
		<hr>
			</form>
		</div>

		<div id="tedu" style="display: none; margin-top: 10px">
			<form action="liulirong/emp!updedu" method="post">
				<table
					class="table table-striped table-bordered bootstrap-datatable datatable responsive"
					width="80%">
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
								<input type="hidden" name="edid" value="${e.EDID }" />
								<input type="hidden" name="eid" value="${e.EID }" />
								<td>
									<input type="text" name="edustart" value="${e.EDSTART }"
										onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});"
										class="form-control">
								</td>
								<td>
									<input type="text" name="eduend" value="${e.EDEND }"
										onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});"
										class="form-control">
								</td>
								<td>
									<input type="text" name="edusch" value="${e.EDSCHOOL }"
										class="form-control">
								</td>
								<td>
									<input type="text" name="edustd" value="${e.EDU }"
										class="form-control">
								</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			<div class="box-content">
					<div class="control-group">
						<button type="submit" class="btn"
							style="float: right; width: 120px;">
							<b>修&nbsp;&nbsp;&nbsp;&nbsp;改</b>
						</button>
						<button type="button" class="btn"
							style="float: left; width: 120px;"
							onclick="location.href='javascript:history.go(-1)';">
							<b>返&nbsp;&nbsp;&nbsp;&nbsp;回</b>
						</button>
					</div>
				</div>
			</form>
		</div>

		<!-- 日期类型 -->
		<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>

		<script type="text/javascript">
			$("#job").click(function(){
				$("#tjob").slideToggle(2000);
			});
			$("#fam").click(function(){
				$("#tfam").slideToggle(2000);
			});
			$("#edu").click(function(){
				$("#tedu").slideToggle(2000);
			});
		</script>
	</body>
</html>
