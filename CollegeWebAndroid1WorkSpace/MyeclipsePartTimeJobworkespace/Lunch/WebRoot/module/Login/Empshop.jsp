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
    
    <title>My JSP 'Empshop.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
   <link rel="stylesheet" type="text/css" href="${path }/resource/css/bootstrap.min.css"/>
  <script type="text/javascript">
  	var allsum=0;
  $(document).ready(function(){
  	$("#tbody tr").each(function(){
  			var price=$(this).find(".price").val();
  			var count=$(this).find(".count").val();
  			var sum=price*count;
  			$(this).find("span").html(sum);
  			allsum+=sum;
  		});
  		$("#allsum").removeAttr("value");
  		$("#allsum").attr("value",allsum);
   });	
  	function removeThisTr(obj,mealid,roomid){
  	 	$.ajax({
  			url:"${path}/emp_TbEmpshopdele.action",
  			data:{"mealid":mealid,"roomid":roomid},
  			type:"post",
  			dataType:"text",
  			success:function(data){ 
  				var sum=parseInt($(obj).parent().parent().find("span[class='sum']").html());
  				//console.log(data);
				//console.log(sum);
				allsum-=sum;
				$("#getSum input").remove();
				$("#getSum").append("<input type=\"button\" id=\"allsum\" name=\"allsum\" value=\""+allsum+"\">");
  				$(obj).parent().parent().remove();	
  		 	}
  		}); 
  	}
  	function GetJson(){
  		var JsonList=new Array;
  		$("#tbody tr").each(function(){
  			//var roomid=$(this).find("input[name='roomid']").val();
  			var mealcount=$(this).find("input[name='mealcount']").val();
  			var mealid=$(this).find("input[name='mealid']").val();
  			//var mealtype=$(this).find("input[name='mealtype']").val();
  			var Json={"mealcount":mealcount,"mealid":mealid};
  			JsonList.push(Json);
  		});
  		return JsonList;
  	}
/* 	function  buyAll(){
	var addorderid=$("#addorderid").val();
		$.ajax({
			url:"${path}/car_addToTable.action",
  			data:{"money":$("#allsum").val(),"roomid":$("#roomid").val(),"Jsonlist": JSON.stringify(GetJson()),"Addorderid":$("#addorderid").val()},
  			type:"post",
  			dataType:"text",
  			success:function(data){ 
  				alert(data);
  				if(addorderid!=''&&addorderid!="null"){
  					window.location.href="${path}/car_OneroomOrder.action?orderid="+addorderid+"&roomid="+$("#roomid").val()+"&flag=1";
  				}else{
  					window.location.href="${path}/car_showRoomdetail.action?orderid="+data+"&money="+$("#allsum").val()+"&roomid="+$("#roomid").val();
  				}
  		 	}
		});
	} */
function  buyAll(){
	var addorderid=$("#addorderid").val();
	//alert(1);
		$.ajax({
			url:"${path}/car_addToTbTable.action",
  			data:{"roomid":$("#roomid").val(),"Addorderid":$("#addorderid").val()},
  			type:"post",
  			dataType:"text",
  			success:function(data){ 
  				//alert(data);
  				alert("订单已提交，请耐心等待");
  				 if(addorderid!=''&&addorderid!="null"){
  					window.location.href="${path}/car_OneroomOrder.action?orderid="+addorderid+"&roomid="+$("#roomid").val()+"&flag=1";
  				}else{
  					window.location.href="${path}/car_showRoomdetail.action?orderid="+data+"&money="+$("#allsum").val()+"&roomid="+$("#roomid").val();
  				} 
  		 	}
		})
	}
	function add(item,mealid,roomid,obj){
		if(item=='+'){
			var count=parseInt($(obj).parent().find("input[name='mealcount']").val())+1;
			$.ajax({
  			url:"${path}/emp_TbEmpshopaddcount.action",
  			data:{"mealid":mealid,"roomid":roomid,"mealcount":count},
  			type:"post",
  			dataType:"text",
  			success:function(data){ 
  				if(data=='true'){
  					$(obj).parent().find("input[name='mealcount']").val(count);
  					window.location.reload();
  				}
  		 	}
  			}); 
		}
		if(item=='-'){
			var count=parseInt($(obj).parent().find("input[name='mealcount']").val());
			if(count>0){
				count--;
			}else{
				count=0;
			}
			$.ajax({
  			url:"${path}/emp_TbEmpshopaddcount.action",
  			data:{"mealid":mealid,"roomid":roomid,"mealcount":count},
  			type:"post",
  			dataType:"text",
  			success:function(data){ 
  				if(data=='true'){
  					$(obj).parent().find("input[name='mealcount']").val(count);
  					window.location.reload();
  					}
  		 		}
  			}); 
		}
	}
  </script>
  </head>
  <body>
  		<input type="hidden" value="${Addorderid }" id="addorderid">
  		<input type="hidden" value="${roomid }" id="roomid">
  房间编号：<input type="button" class="btn" value="${roominfo[0].room_number}${roominfo[0].room_type}" >
  <span id="getSum">总金额：<input type="button" id="allsum" class="btn" name="allsum"></span>
  <table class="table">
  <caption><center><h2>桌位订餐</h2></center></caption>
  <thead>
  	<tr>
  		<th>序号</th>
  		<th>订餐数量</th>
  		<th>菜单单价</th>
  		<th>菜名</th>
  		<th>总价</th>
  		<th>操作</th>
  	</tr>
  </thead>
  <tbody id="tbody">
    <c:forEach items="${empshopList }" var="shop" varStatus="i">
    	<tr>
    	<td>${i.count }</td>
    	<td>
    		<input type="button" value="-" onclick="add('-','${shop.meal_id }','${roomid }',this)">
    		<input type="button" name="mealcount" class="count" value="${shop.count }">
    		<input type="button" value="+" onclick="add('+','${shop.meal_id }','${roomid }',this)">
    	</td>
    	<td>
    		<input type="button" value="${shop.meal_price }" class="price"> <input type="hidden" name="mealid" value="${shop.meal_id }">
    		
    	</td>
    	<td>${shop.meal_name }</td>
    	<td><span class="sum"></span></td>
    	<td><input type="button" value="删除" onclick="removeThisTr(this,'${shop.meal_id }','${roomid }')" class="btn btn-danger"></td>
    </tr>
  </c:forEach>
     </tbody>
     <script>
     function backToMenu(){
     	window.location.href="${path}/module/BgMenu/BgMenu.jsp?roomid=${roomid}&orderid=${Addorderid }";
     	//window.location.href="${path}/dc/ShowMenu?mealid=${menu.meal_id}&roomid=${roomid}&orderid=${Addorderid }";
     }
     </script>
     <tfoot>
     	<tr>
     		<td colspan="5"><input type="button" value="继续购买" onclick="backToMenu()" class="btn btn-danger"></td>
     		<td><input type="button" value="提交" onclick="buyAll()" class="btn btn-primary"></td>
     	</tr>
     </tfoot>
    </table>
  </body>
</html>
