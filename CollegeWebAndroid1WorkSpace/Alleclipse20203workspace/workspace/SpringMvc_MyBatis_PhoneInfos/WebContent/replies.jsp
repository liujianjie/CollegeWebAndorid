<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${infor.inTitle }</title>
	<!-- 重点 -->
	<script type="text/javascript" src="http://localhost:8080/JiShi1/js/jquery-1.7.2.min.js"></script>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<%DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	%>
	<c:set var="att1" value="${infor.inReporttime }" ></c:set>
	<!-- 时间 -->
	<%Date pdate = (Date)pageContext.getAttribute("att1"); 
		  String pdates = df.format(pdate);
		%>
	<div>
		<h1 align="left">${infor.inTitle }</h1>
	</div>
	<div>
		<h4>发表于:<%=pdates %></h4>
	</div>
	<div>
		<h4>内容:${infor.inContent }</h4>
	</div>
	<div>
		<h3>读者回应</h3>
	</div>
<!-- 用ajax创建表 -->
	<table width="100%" >
	<c:forEach items="${infor.replieses }"  var="rep">
		<c:set var="att2" value="${rep.reReplytime }" ></c:set>
		<!-- 时间 -->
		<%Date rdate = (Date)pageContext.getAttribute("att2"); 
		  String rdates = df.format(rdate);
		%>
		<tr>
			<td>发表时间:<%=rdates %></td>
		</tr>
		<tr>
			<td>${rep.reContent }</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<h3>快速回复(字数200字以内):</h3>
	</div>
	<form name="frm" action="${pageContext.request.contextPath }/adds.do" method="post">
		<!-- onkeypress键盘松开 onkeydown键盘按下 -->
		<textarea id="text"  name="reContent"  rows="5" cols="30" onkeypress="change(this)">
		
		</textarea>
		<br>
		字数:<span id="zishu">0</span>/200
		<input type="hidden" name="inInforid" value="${infor.inInforid}">
		<input type="submit" value="提交" width="60" height="30"><a href="${pageContext.request.contextPath }/infor/selinfor">返回首页</a>
	</form>
	<script type="text/javascript">
		function tijiao(){
			//var text = document.getElementById("text").value;
			var text = $("#text").val();
			if(text==""){
				alert("亲输入内容");
			}
			else{
				var inforid = $("#inforid").val();
// 				$.post("rep/add",{"text":text,"inforid":inforid},function(date){
// 					//回复列表
// 					var replist = date.list;
// 					$.each(replist,function(index,rep){
// 						var tr1=$("<tr>",{
// 						});
						
// 						var td1=$("<td>",{
// 							"text":"发表于"+rep.reReplytime
// 						});
// 						var tr2=$("<tr>",{
// 						});
// 						var td2=$("<td>",{
// 							"text":rep.reContent
// 						});
						
// 						tr1.append(td1);
// 						tr2.append(td2);
// 						table.append(tr1);
// 						table.append(tr2);
// 					},"json");
				}
		}
		function change(tex){
			var values = tex.value;
			document.getElementById("zishu").innerHTML=values.length;
		}
		//创建表
// 		$.post("rep/list",{},function(date){
// 			var replist = date.list;
// 			var table=$("<table>",{
// 				"width":"70%",
// 				"align":"left",
// 			});
// 			$.each(replist,function(index,rep){
// 				var tr1=$("<tr>",{
// 				});
				
// 				var td1=$("<td>",{
// 					"text":"发表于"+rep.reReplytime
// 				});
// 				var tr2=$("<tr>",{
// 				});
// 				var td2=$("<td>",{
// 					"text":rep.reContent
// 				});
				
// 				tr1.append(td1);
// 				tr2.append(td2);
// 				table.append(tr1);
// 				table.append(tr2);
// 			});
// 			$("#showdiv").append(table);
// 		},"json");
	</script>
</body>
</html>