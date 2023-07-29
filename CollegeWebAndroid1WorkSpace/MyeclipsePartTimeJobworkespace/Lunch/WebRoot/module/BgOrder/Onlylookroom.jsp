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
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.min.css">
	<script type="text/javascript" src="${path }/resource/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script language="javascript" src="${path }/resource/js/jquery-1.4.4.min.js"></script>
	<script language="javascript" src="${path }/resource/js/jquery.jqprint-0.3.js"></script>
	<style>
	.box{
		width:800px;
		vertical-align: venter;
		margin:0 auto;
	}
	</style>
	<script type="text/javascript">
	$(document).ready(function(){
	$("#endTo").hide();
		$.ajax({
    			url:"${path}/car_checkEnd.action",
				data:{"orderid":${roomorderlist[0].order_id }},
				type:"post",
				dataType:"text",
				success:function(data){	
					if(data=='true'){
						$("#endTo").show();
					}else{
						$("#endTo").hide();
					}
				}
    		});
	});
		 function preview(oper)
		{
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
	function  a(){
        $(".box").jqprint();
    }
		function onTable(orderdetailid,orderid ){
			window.location.href="${path}/car_OnTable.action?orderdetailid="+orderdetailid+"&orderid="+orderid;
			//<a href="${path}/car_OneroomOrder.action?orderid=${map.order_id }&roomid=${map.room_id }&flag=1">查看</a>
		}
		function reOneTableDe(orderdetailid,orderid ){
			window.location.href="${path}/car_reOneTableDe.action?orderdetailid="+orderdetailid+"&orderid="+orderid;
		}
			 function pushmeal(){
	 alert(1);
				 $.ajax({
				url:"${path}/car_pushfoodcount.action",
				data:{"orderid":$("#orderid").val()},
				type:"post",
				dataType:"text",
				success:function(data){
				//alert(1);
					if(data=='true'){
					window.location.reload();
					}
				}
				})
			}
</script>
  </head>
  
  <body>
  <!--startprint1-->
	<!--打印内容开始-->
  <center><h1>欢迎来到网上订餐系统</h1></center>
  <center><h1></h1></center>
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
		    				<c:if test="${(flag eq 1) and (roomorderlist[0].state!=4) }">
			    				<c:if test="${map.state eq 1}"><input type="button" value="可上桌" class="btn btn-info" ></c:if>
			    				<%-- onclick="onTable('${map.order_detail_id }','${roomorderlist[0].order_id }')" --%>
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
			window.location.href="${path}/car_showRemovecookDe.action?orderid=${roomorderlist[0].order_id }&roomid=${roomorderlist[0].room_id }&flag=1";
	}
	</script>
			<c:if test="${roomorderlist[0].state eq 4}">
	    	<input class="btn btn-danger" type="button"  value="已结账">
	    	</c:if>
    	<%-- <c:choose>
	    	<c:when test="${(flag eq 1) and !(roomorderlist[0].state eq 2)}">
	    	<input class="btn btn-primary" type="button" id="endTo" value="通知结账" onclick="endTo()">
	    	</c:when>
	    	<c:when test="${(flag eq 1) and (roomorderlist[0].state eq 2)}">
	    	<input class="btn btn-danger" type="button"  value="已结账">
	    	</c:when>
	  	
    	</c:choose>
    		<c:if test="${(flag eq 1) and (roomorderlist[0].state!=2)}">
	    		<input type="button" value="催菜" class="btn btn-danger" onclick="pushmeal()"/>
	    		<input type="button" value="热菜详情" class="btn btn-warning" 
	    		onclick="hotMeal()">
	   		</c:if> --%>
    </div>
    <!--打印内容结束-->
<!--endprint1-->
<!-- <input type=button class="btn btn-primary"name='button_export' title='打印1' onclick="a()" value="打印"> -->
<!-- <input type=button class="btn btn-primary"name='button_export' title='打印1' onclick="preview(1)" value="打印"> -->
<a href="javascript:history.go(-1)"style="color:white;font-size: 20px;"><button class="btn btn-info">返回</button></a>
  </body>
</html>
