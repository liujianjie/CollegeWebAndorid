<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<form action="liulirong/emp!empadd.action" method="post" enctype="multipart/form-data">
		<div class="ch-container">	
		<center><h2 class="animated rubberBand">员工入职信息表</h2></center>
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
								 <input type="text" name="emp.ename" class="form-control" style="width:300px;">
							</td>
							<td class="center" width="8%">
								性别
							</td>
							<td class="center">
							 <label class="radio-inline">
			                    <input type="radio" name="emp.esex" checked value="男"> 男
			                </label>
			                <label class="radio-inline">
			                    <input type="radio" name="emp.esex" value="女"> 女
			                </label>
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
								 <input type="text" name="emp.ephone" class="form-control" style="width:300px;">
							</td>
							<td class="center">
								籍贯
							</td>
							<td class="center">
								<input type="text" name="emp.ecity" class="form-control" style="width:300px;">
							</td>
						</tr>
						<tr>
							<td>
								家庭住址
							</td>
							<td class="center" colspan="3">
								 <input type="text" name="emp.eaddr" class="form-control" style="width:700px;">
							</td>
						</tr>
						<tr>
							<td>
								毕业院校
							</td>
							<td class="center">
								 <input type="text" name="emp.edu" class="form-control" style="width:300px;">
							</td>
							<td class="center">
								专业
							</td>
							<td class="center">
								<input type="text" name="emp.zhuanye" class="form-control" style="width:300px;">
							</td>
						</tr>
						<tr>
							<td>
								身份证号
							</td>
							<td class="center">
								 <input type="text" name="emp.ecertid" class="form-control" style="width:300px;">
							</td>
							<td class="center">
								婚姻状况
							</td>
							<td class="center">
								 <label class="radio-inline">
				                    <input type="radio" name="emp.hunyin" checked value="已婚"> 已婚
				                </label>
				                 <label class="radio-inline">
				                    <input type="radio" name="emp.hunyin" value="未婚"> 未婚
				                </label>
							</td>
						</tr>
						<tr>
							<td>
								QQ
							</td>
							<td class="center">
								 <input type="text" name="emp.myqq" class="form-control" style="width:300px;">
							</td>
							<td class="center">
								入职日期
							</td>
							<td class="center" colspan="2">
								<input type="text" name="emptry" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});" class="form-control" style="width:300px;">
							</td>
						</tr>
						<tr>
							<td>
								入职部门
							</td>
							<td class="center">
								<select name="emp.did" data-rel="chosen" style="width:300px;">
									<c:forEach items="${dlist}" var="d">
										<option value="${d.did }">${d.dname } </option>
									</c:forEach>							
								</select>
							</td>
							<td class="center">
								职位
							</td>
							<td class="center" colspan="2">
								<select name="emp.jwork" data-rel="chosen"  style="width:300px;">
									<option value="学院院长">学院院长</option>
									<option value="学院总监">学院总监</option>
									<option value="副校长">副校长</option>
									<option value="教学部主任">教学部主任</option>	
									<option value="高级讲师">高级讲师</option>	
									<option value="讲师">讲师</option>	
									<option value="学工处主任">学工处主任</option>	
									<option value="班主任">班主任</option>	
									<option value="招生处主任">招生处主任</option>
									<option value="招生老师">招生老师</option>	
									<option value="后勤部主任">后勤部主任</option>
									<option value="行政部主任">行政部主任</option>
									<option value="财务部主任">财务部主任</option>										
								</select>
								
							</td>
						</tr>
						<tr>
							<td>
								性格爱好
							</td>
							<td class="center" colspan="4">
								 <textarea class="autogrow" name="emp.favorite" rows="4" cols="115" id="kind_editor"></textarea>
							</td>
						</tr>
						<tr>
							<td>
								专业特长
							</td>
							<td class="center" colspan="4">
								 <textarea class="autogrow" name="emp.techang" rows="4" cols="115" id="kind_editor1"></textarea>
							</td>
						</tr>
					</tbody>
				</table>
				
				<table id="ttab"
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
							<th>
								操作
							</th>
						</tr>
						<tbody id="tb">
						<tr>
							<td>
								<input type="text" name="comp" class="form-control" style="width:130px;">
							</td>
							<td>
								<input type="text" name="cjob" class="form-control" style="width:130px;">
							</td>
							<td>
								<input type="text" name="cstart" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});" class="form-control" style="width:130px;">
							</td>
							<td>
								<input type="text" name="cend" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});" class="form-control" style="width:130px;">
							</td>
							<td>
								<input type="text" name="cpeople" class="form-control" style="width:130px;">
							</td>
							<td>
								<input type="text" name="cpho" class="form-control" style="width:130px;">
							</td>
							<td>
								<input type="button" value="添加" class="form-control" onclick="add()" style="width:140px;">
							</td>	
						</tr>
						</tbody>
				</table>
				
				<table id="ff"
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
							<th>
								操作
							</th>
						</tr>
						<tbody id="family">
						<tr>
							<td>
								<input type="text" name="famname" class="form-control">
							</td>
							<td>
								<input type="text" name="famjob" class="form-control">
							</td>
							<td>
								<input type="text" name="famfre" class="form-control">
							</td>
							<td>
								<input type="text" name="fampho" class="form-control">
							</td>
							<td>
								<input type="button" value="添加" class="form-control" onclick="addfam()" style="width:150px;">
							</td>
						</tr>
						</tbody>
				</table>
				
				<table id="ee"
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
							<th>
								操作
							</th>
						</tr>
						<tbody id="edu">
						<tr>
							<td>
								<input type="text" name="edustart" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});" class="form-control">
							</td>
							<td>
								<input type="text" name="eduend" onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});" class="form-control">
							</td>
							<td>
								<input type="text" name="edusch" class="form-control">
							</td>
							<td>
								<input type="text" name="edustd" class="form-control">
							</td>
							<td>
								<input type="button" value="添加" class="form-control" onclick="addedu()" style="width:150px;">
							</td>
						</tr>
						</tbody>
				</table>
		</div>
	
				 <!-- submit提交按钮样式 -->                    
                 <div class="box-content">
					<div class="control-group">
					<button type="button" class="btn" style="float:left;width:200px;" onclick="location.href='javascript:history.go(-1)';"><b>返 回</b></button>
                 		<button type="submit" class="btn" style="float:right;width:200px;"><b>提	交</b></button>
                 	</div>
                 </div>
        </form>  
             
		<script type="text/javascript">
		function add() {
			var tab = document.getElementById("ttab");
			var tb = document.getElementById("tb");
			var tr = document.createElement("tr");
			var td1 = document.createElement("td");
			var td2 = document.createElement("td");
			var td3 = document.createElement("td");
			var td4 = document.createElement("td");
			var td5 = document.createElement("td");
			var td6 = document.createElement("td");
			var td7 = document.createElement("td");
			var input = document.createElement("input");
			var input2 = document.createElement("input");
			var input3 = document.createElement("input");
			var input4 = document.createElement("input");
			var input5 = document.createElement("input");
			var input6 = document.createElement("input");
			var button = document.createElement("input");
			
			input.name="comp";
			input.type="text";
			input.className="form-control";
			
			input2.name="cjob";
			input2.type="text";
			input2.className="form-control";
			
			input3.name="cstart";
			input3.type="text";
			input3.className="form-control";
			input3.setAttribute("onclick","WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});");
			
			input4.name="cend";
			input4.type="text";
			input4.className="form-control";
			input4.setAttribute("onclick","WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});");
			
			input5.name="cpeople";
			input5.type="text";
			input5.className="form-control";
			
			input6.name="cpho";
			input6.type="text";
			input6.className="form-control";
			
			button.value="删除";
			button.type="button";
			button.className="form-control";
			
			button.onclick=function() {
				tb.removeChild(tr);
				tr.removeChild(td1);
				td1.removeChild(input);
				tr.removeChild(td2);
				td2.removeChild(input2);
				tr.removeChild(td2);
				td3.removeChild(input3);
				tr.removeChild(td3);
				td4.removeChild(input4);
				tr.removeChild(td4);
				td5.removeChild(input5);
				tr.removeChild(td5);
				td6.removeChild(input6);
				tr.removeChild(td6);
				
				td7.removeChild(button);
			}
			td1.appendChild(input);
			td2.appendChild(input2);
			td3.appendChild(input3);
			td4.appendChild(input4);
			td5.appendChild(input5);
			td6.appendChild(input6);
			td7.appendChild(button);
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
			tr.appendChild(td5);
			tr.appendChild(td6);
			tr.appendChild(td7);
			tb.appendChild(tr);
			tab.appendChild(tb);
			
		}
	</script>
	
		<script type="text/javascript">
		function addfam() {
			var fam = document.getElementById("ff");
			var family = document.getElementById("family");
			var tr = document.createElement("tr")
			var td1 = document.createElement("td")
			var td2 = document.createElement("td")
			var td3 = document.createElement("td")
			var td4 = document.createElement("td")
			var td5 = document.createElement("td")
			var input = document.createElement("input");
			var input2 = document.createElement("input");
			var input3 = document.createElement("input");
			var input4 = document.createElement("input");
			var button = document.createElement("input");
			
			input.name="famname";
			input.type="text";
			input.className="form-control";
			
			input2.name="famjob";
			input2.type="text";
			input2.className="form-control";
			
			input3.name="famfre";
			input3.type="text";
			input3.className="form-control";
			
			input4.name="fampho";
			input4.type="text";
			input4.className="form-control";
			
			button.value="删除";
			button.type="button";
			button.className="form-control";
			
			button.onclick=function() {
				family.removeChild(tr);
				tr.removeChild(td1);
				td1.removeChild(input);
				tr.removeChild(td2);
				td2.removeChild(input2);
				tr.removeChild(td2);
				td3.removeChild(input3);
				tr.removeChild(td3);
				td4.removeChild(input4);
				tr.removeChild(td4);
				
				td5.removeChild(button);
			}
			td1.appendChild(input);
			td2.appendChild(input2);
			td3.appendChild(input3);
			td4.appendChild(input4);
			td5.appendChild(button);
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
			tr.appendChild(td5);
			family.appendChild(tr);
			fam.appendChild(family);
			
		}
	</script>
	
	<script type="text/javascript">
		function addedu() {
			var ee = document.getElementById("ee");
			var edu = document.getElementById("edu");
			var tr = document.createElement("tr")
			var td1 = document.createElement("td")
			var td2 = document.createElement("td")
			var td3 = document.createElement("td")
			var td4 = document.createElement("td")
			var td5 = document.createElement("td")
			var input = document.createElement("input");
			var input2 = document.createElement("input");
			var input3 = document.createElement("input");
			var input4 = document.createElement("input");
			var button = document.createElement("input");
			
			input.name="edustart";
			input.type="text";
			input.className="form-control";
			input.setAttribute("onclick","WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});");
			
			input2.name="eduend";
			input2.type="text";
			input2.className="form-control";
			input2.setAttribute("onclick","WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});");
			
			input3.name="edusch";
			input3.type="text";
			input3.className="form-control";
			
			input4.name="edustd";
			input4.type="text";
			input4.className="form-control";
			
			button.value="删除";
			button.type="button";
			button.className="form-control";
			
			button.onclick=function() {
				edu.removeChild(tr);
				tr.removeChild(td1);
				td1.removeChild(input);
				tr.removeChild(td2);
				td2.removeChild(input2);
				tr.removeChild(td2);
				td3.removeChild(input3);
				tr.removeChild(td3);
				td4.removeChild(input4);
				tr.removeChild(td4);
				
				td5.removeChild(button);
			}
			td1.appendChild(input);
			td2.appendChild(input2);
			td3.appendChild(input3);
			td4.appendChild(input4);
			td5.appendChild(button);
			tr.appendChild(td1);
			tr.appendChild(td2);
			tr.appendChild(td3);
			tr.appendChild(td4);
			tr.appendChild(td5);
			edu.appendChild(tr);
			ee.appendChild(edu);
			
		}
	</script>
	
   <!-- 日期类型 -->
	<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	</body>
</html>
