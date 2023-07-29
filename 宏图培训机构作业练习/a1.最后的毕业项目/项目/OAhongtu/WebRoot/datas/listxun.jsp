<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<title>My JSP 'listxun.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<link rel="stylesheet" type="text/css"
			href="TimePick/jquery.datetimepicker.css" />
	</head>
	<body>
		<jsp:include page="common.jsp"></jsp:include>
		<div class="box-content">
			<b>巡查人</b>
			<div class="control-group"
				style="height: 20px; width: 200px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 10px">
				<input type="text" id="xname" class="form-control"
					style="width: 130px; height: 33px" onchange="xcha();">
			</div>
			<b>巡查日期</b>
			<div class="control-group"
				style="height: 20px; width: 300px; display: inline-block; margin-bottom: 0; vertical-align: middle; margin-left: 10px">
				<input type="text" id="dd"
					onclick="WdatePicker({doubleCalendar:false,dateFmt:'yyyy/MM/dd'});"
					class="form-control" style="width: 243px; height: 33px"
					onchange="xcha()">
			</div>
			<b>巡查时间</b>
			<select id="times" data-rel="chosen"
				style="width: 130px; height: 30px;" onchange="xcha()">
				<option value="8:00">
					8:00
				</option>
				<option value="11:00">
					11:00
				</option>
				<option value="14:00">
					14:00
				</option>
				<option value="16:00">
					16:00
				</option>
				<option value="19:00">
					19:00
				</option>
				<option value="20:00">
					20:00
				</option>
			</select>
		</div>
		<div id="xuncha">
		</div>
		<script type="text/javascript">
		function xcha(){
			var xname=$("#xname").val();
			var xdate=$("#dd").val();
			var xtime=$("#times").val();
			$.post("liulirong/xunlist.action",{"xname":xname,"xdate":xdate,"times":xtime},function(data){
				var list=data.listss;
				var table=$("<table>",{
					"class":"table table-bordered bootstrap-datatable"
				});
				var tr=$("<tr>");
				var th1=$("<th>",{
					"text":"时间"
				});
				var th2=$("<th>",{
					"text":"班级"
				});
				var th3=$("<th>",{
					"text":"应到人数"
				});
				var th4=$("<th>",{
					"text":"实到人数"
				});
				var th5=$("<th>",{
					"text":"教室卫生"
				});
				var th6=$("<th>",{
					"text":"任课老师"
				});
				var th7=$("<th>",{
					"text":"任课老师是否到岗"
				});
				var th8=$("<th>",{
					"text":"学生违纪情况"
				});
				var th9=$("<th>",{
					"text":"任课老师是否在做教学相关事情"
				});
				tr.append(th1);
				tr.append(th2);
				tr.append(th3);
				tr.append(th4);
				tr.append(th5);
				tr.append(th6);
				tr.append(th7);
				tr.append(th8);
				tr.append(th9);
				table.append(tr);
				$.each(list,function(index,xun){
					var tr2=$("<tr>");
					var td1=$("<td>",{
						"text":xun.XTIME,
						"class":"center"
					});
					var td2=$("<td>",{
						"text":xun.XCLASS,
						"class":"center"
					});
					var td3=$("<td>",{
						"text":xun.XCOUNT,
						"class":"center"
					});
					var td4=$("<td>",{
						"text":xun.XNUMBER,
						"class":"center"
					});
					var td5=$("<td>",{
						"text":xun.XCLEAN,
						"class":"center"
					});
					var td6=$("<td>",{
						"text":xun.XTEACH,
						"class":"center"
					});
					var td7=$("<td>",{
						"text":xun.ISTEACH,
						"class":"center"
					});
					var td8=$("<td>",{
						"text":xun.XSTUDENT,
						"class":"center"
					});
					var td9=$("<td>",{
						"text":xun.XDOTEACH,
						"class":"center"
					});
					tr2.append(td1);
					tr2.append(td2);
					tr2.append(td3);
					tr2.append(td4);
					tr2.append(td5);
					tr2.append(td6);
					tr2.append(td7);
					tr2.append(td8);
					tr2.append(td9);
					table.append(tr2);
				});
				$("#xuncha").html(table);
			},"json");
		}
	</script>
		<!-- 日期类型 -->
		<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	</body>
</html>