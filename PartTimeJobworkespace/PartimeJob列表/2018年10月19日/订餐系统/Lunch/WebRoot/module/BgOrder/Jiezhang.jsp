<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'OneroomOrder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.css" type="text/css"></link>
	<link href="${path }/resource/css/bootstrap.min.css" rel="stylesheet">
	<script src="${path }/resource/js/jquery-2.1.4.min.js"></script>
	<script src="${path }/resource/js/bootstrap.min.js"></script>

	<style>
	.box{
		width:800px;
		vertical-align: venter;
		margin:0 auto;
	}
	</style>
	<script type="text/javascript">
function preview(oper){
		if (oper < 10){
			bdhtml=window.document.body.innerHTML;//获取当前页的html代码
			sprnstr="<!--startprint"+oper+"-->";//设置打印开始区域
			eprnstr="<!--endprint"+oper+"-->";//设置打印结束区域
			prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+18); //从开始代码向后取html
			prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html
			window.document.body.innerHTML=prnhtml;
			window.print();
			window.document.body.innerHTML=bdhtml;
		} else {
			window.print();
		}
		} 

function onTable(orderdetailid,orderid){
			window.location.href="${path}/car_OnTable.action?orderdetailid="+orderdetailid+"&orderid="+orderid;
			//<a href="${path}/car_OneroomOrder.action?orderid=${map.order_id }&roomid=${map.room_id }&flag=1">查看</a>
}
function reOneTableDe(orderdetailid,orderid){
			window.location.href="${path}/car_reOneTableDe.action?orderdetailid="+orderdetailid+"&orderid="+orderid;
}
</script>
  </head>
  <body>
  <!--startprint1-->
	<!--打印内容开始-->
  <center><h1>欢迎来到您的光临</h1></center>
  <center><h1>结账界面</h1></center>
    <div class="box">
    	<table class="table">
    		<tr>
    			<th>订单编号：</th><td> <input type="hidden" id="orderid" value="${roomorderlist[0].order_id }">${roomorderlist[0].order_id }</td>
    			<th>订单时间</th><td>${roomorderlist[0].order_date }</td>
    			<th >总价金额</th><td>￥${roomorderlist[0].money }元</td>
    		</tr>
    		<tr>
    			<th>操作人</th><td>${roomorderlist[0].emp_name }</td>
    			<th>桌位：</th><td> ${roomorderlist[0].room_number }${roomorderlist[0].room_type }</td>
    			<th>大小</th><td>${roomorderlist[0].peo_count }人</td>
    		</tr>
    	</table>
    	<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
    	<hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
    	<table class="table">
    		<tr>
    			<th>序号</th><th>详情编号</th><th>菜名</th><th>单价</th><th>数量</th><th>状态</th><th>操作</th>
    		</tr>
    		<c:if test="${!empty orderdetilist }">
    			<c:forEach items="${orderdetilist}" var="map" varStatus="i">
    				<tr>
    					<td>${i.count }</td>
	    				<td>${map.order_detail_id }</td>
	    				<td>${map.meal_name }</td>
	    				<td>${map.meal_price }</td>
	    				<td>${map.count }</td>
	    				<td>
		    			<c:choose>
			 				<c:when test="${map.state eq 0 }">未做</c:when>
			 				<c:when test="${map.state eq 1 }">完成</c:when>
			 				<c:when test="${map.state eq 2 }">正在做</c:when>
			 				<c:when test="${map.state eq 3 }">已上桌</c:when>
	 					</c:choose>
		    			</td>
		    			<td>
		    				<c:if test="${roomorderlist[0].state!=4 }">
			    				<c:if test="${(map.state eq 0)  and !(map.meal_type eq '热菜')}">
			    					<input type="button" value="退菜" class="btn btn-danger" onclick="reOneTableDe('${map.order_detail_id }','${roomorderlist[0].order_id }')">
			    				</c:if>
			    				<%-- <c:if test="${map.state eq 1}"><input type="button" value="上桌" class="btn btn-info" onclick="onTable('${map.order_detail_id }','${roomorderlist[0].order_id }')"></c:if> --%>
		    				</c:if>
		    			</td>
    				</tr>
    			</c:forEach>
    		</c:if>
    	</table>
    	
    	<script>
    		function endTo(){
    		window.location.href="${path}/bgO_changeOrState.action?orderid=${roomorderlist[0].order_id }&empid=${userinfo.emp_id }";	
    		}

	function hotMeal(){
			window.location.href="${path}/car_showRemovecookDe.action?orderid=${roomorderlist[0].order_id }&roomid=${roomorderlist[0].room_id }&flag=2";
	}
	</script>
    	<c:choose>
	    	<c:when test="${(flag eq 1) and (roomorderlist[0].state eq 4)}">
	    		<input class="btn btn-danger" type="button"  value="已结账">
	    	</c:when>
    	</c:choose>
    		
	    		 <input class="btn btn-primary" type="button" id="endTo"
	    			<c:if test="${roomorderlist[0].state!=2}">disabled="disabled"</c:if>
	    		 	value="结账" data-toggle="modal" data-target="#myModal">
	    		<!-- <input type="button" value="催菜" class="btn btn-danger" onclick="pushmeal()"/>-->
	    		<input type="button" value="退菜"  
	    			 <c:if test="${(flag eq 1) and (roomorderlist[0].state>2)}">disabled="disabled"</c:if>
	    			class="btn btn-warning" onclick="hotMeal()"> 
    </div>

<!-- <input type=button class="btn btn-primary"name='button_export' title='打印1' onclick="a()" value="打印"> -->
<input type=button class="btn btn-primary"name='button_export' title='打印1' onclick="preview(1)" value="打印">
<a href="${path}/open_openSeeTable.action"style="color:white;font-size: 20px;"><button class="btn btn-info">返回</button></a>
<!-- 模态框 -->
<!-- 按钮触发模态框 -->
<!--  <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button> -->
<!-- 模态框（Modal） -->
<script type="text/javascript">
$(document).ready(function(){
//
	
//
	$("#really").change(function(){
		var money=parseFloat($("#mustneed").attr("zhi"))
		var really=parseFloat($("#really").val());
		var result=really-money;
		if(result<0){
			alert("输入金额不足");
			$("#Resultjiao").attr("disabled","disabled");
		}else{
			$("#change").val(result);
			$("#Resultjiao").removeAttr("disabled","disabled");
		}
	});
});
</script>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">${roomorderlist[0].room_number }${roomorderlist[0].room_type }</h4>
            </div>
            <div class="modal-body">
            	<span id="mustneed" zhi="${roomorderlist[0].money }">须收金额：￥${roomorderlist[0].money }元</span>
            	实收金额：<input type="text" id="really" placeholder="请输入金额">
            	找零：<input type="text" id="change"disabled="disabled" placeholder="">
            </div>
                <!--打印内容结束-->
				<!--endprint1-->
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" id="Resultjiao"disabled="disabled" class="btn btn-primary" onclick="endTo()">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
  </body>
</html>
