<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript" type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<link href="${path }/resource/css/bootstrap.min.css" rel="stylesheet">
	<script src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<script src="${path }/resource/js/bootstrap.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>
 <style type="text/css">
 body{
 	width:1100px;
 }
	#box{
		width:100%;
		margin:0 auto;
	}
	table{
		margin:0 auto;
		text-align:center;
	}
	th,td{
		text-align:center;
	}
	.input-group{
		width:200px;
		padding:20px;
		float:left;
	}
	.hidden{
		display:none;
	}
</style>
<script type="text/javascript">
function goTo(i){
			$("#form1").attr("action","${path }/roomTotal_checkAndShowtotal.action?nowpage="+i);
			$("#form1").submit();
}
$(document).ready(function(){
	$("#tbody tr").each(function(){
		var onecount=Number($(this).find(".ocount").html());
		var sum=Number($("#totalordercount").val());
		var lv;
		if(sum==0){
			lv=0;
		}else{
		 lv=onecount/sum*100;
		 lv=lv.toFixed(2);
		}
		$(this).find(".lv").html(lv+"%");
	});
});
</script>
   	</head>
  <body>
  <center><h1>翻盘率房间报表</h1></center>
  <div>
  <form action="${path }/roomTotal_checkAndShowtotal.action" method="post" id="form1" class="bs-example bs-example-form" role="form">
   <div class="input-group" >
 		<span class="input-group-addon">房间号</span>
  		<input type="text" name="roomnumber" value="${roomMap.roomnumber}" class="form-control" style="width:200px">
  		<span class="input-group-addon">
  			<input type="radio" name="roomtype" value="包厢" <c:if test="${roomMap.roomtype eq '包厢'}"> checked=checked</c:if>>包厢
  			<input type="radio" name="roomtype" value="桌" <c:if test="${roomMap.roomtype eq '桌'}"> checked=checked</c:if>>桌
  			<input type="radio" name="roomtype" value="" <c:if test="${roomMap.roomtype eq ''}"> checked=checked</c:if>>全部
  		</span>
  </div>
  		<%-- <select name="roomtype" style="height:40px;">
  			<option value="包厢" <c:if test="${roomMap.room_type eq '包厢'}"> selected=selected</c:if>>包厢</option>
  			<option value="桌" <c:if test="${roomMap.room_type eq '桌'}"> selected=selected</c:if>>桌</option>
  		</select> --%>
  	<div class="input-group">
  	   <span class="input-group-addon">开始时间</span>
  	   <input class="Wdate form" type="text" style="height:35px;" name="begintime"value="${roomMap.begintime}"onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="输入开始时间"> 
  	   <span class="input-group-addon">结束时间</span>
  	   <input class="Wdate form" type="text" style="height:35px;" name="endtime" value="${roomMap.endtime}" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})" placeholder="输入结束时间">   
  </div>
  <input type="submit" value="查询" class="btn btn-info" style="width:60px;margin:20px">
  </form>
  </div>
  <div id="box">
   <table  class="table table-bordered table-hover table-striped" >
   <thead>
   		<tr>
   			<th>序号</th>
   			<th>房间名</th>
   			<th>时间</th>
   			<th>时间段</th>
   			<th>菜品数量</th>
   			<th>翻盘次数</th>
   			<th>金额</th>
   			<th>翻盘率</th>
   		</tr>
   	</thead>
   	<tbody id="tbody">
   		 <c:forEach items="${totalroomlist }" var="mapemp" varStatus="var"> 
   			<tr>
   				<td rowspan="2">${var.count }</td>
   				<td rowspan="2">${mapemp.room_number}${mapemp.room_type}</td>
   				<td>上午</td>
   				<td>08:00:00-12:00:00</td>
   				<td>${mapemp.roomorders}</td>
   				<td class="ocount">${mapemp.ordercounts}</td>
   				<td>${mapemp.roommoneys}元</td>
   				<td class="lv"></td>
   			</tr>
   			<tr>
   				<td>下午</td>
   				<td>12:00:00-24:00:00</td>
   				<td>${mapemp.roomorderx}</td>
   				<td class="ocount">${mapemp.ordercountx}</td>
   				<td>${mapemp.roommoneyx}元</td>
   				<td class="lv"></td>
   			</tr>
   				
   	 </c:forEach> 
   	</tbody>
   	<tfoot>
   		<tr>
   			<td></td>
   			<th>翻盘次数：</th>
   			<td>
   				<input type="hidden" id="totalordercount" value="${TotalSum[0].ordercounts+TotalSum[0].ordercountx}">${TotalSum[0].ordercounts+TotalSum[0].ordercountx}
   			</td>
   			<th>菜品总数</th>
   			<td>
   				<input type="hidden" id="totalmealcount" value="${TotalSum[0].allordedetails+TotalSum[0].allordedetailx }">${TotalSum[0].allordedetails+TotalSum[0].allordedetailx }
   			</td>
   			<th>菜品总金额</th>
   			<td>${TotalSum[0].allmoneys+TotalSum[0].allmoneyx }元</td>
   		</tr>
   		<tr>
   			<td colspan="12" id="pagenum">
  				<a href="javascript:goTo(1)">首页</a>
  			 	<c:if test="${page.nowpage!=1 }">
  		   		<a href="javascript:goTo(${page.nowpage-1 })">上一页</a>
  				</c:if>
  				<c:if test="${page.nowpage!=page.sumpage and page.sumpage!=0}">
  		 		<a href="javascript:goTo(${page.nowpage+1 })">下一页</a>
  				</c:if>
  				 <a href="javascript:goTo(${page.sumpage})">尾页</a>
  		 		<span>当前${page.nowpage }页</span>
  				<!-- <a href="javascript:goTo($('#topage').val())">转到</a> -->
  				<%-- <input type="text" id="topage" value="${page.nowpage }" style="width:30px;">页 --%>
  		 		<span>共${page.sumpage }页</sapn>
  	 			<span id="lastspan">共${page.sumcount }条记录</span>
  			</td>
   		</tr>
   	</tfoot>
   </table>
   </div>			
  </body>
</html>
