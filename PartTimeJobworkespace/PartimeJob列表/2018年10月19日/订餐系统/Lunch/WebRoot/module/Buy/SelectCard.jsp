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
    
    <title>购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="${path }/resource/css/bootstrap.min.css">	
	<style type="text/css">
		body{
			width:100%;
			height:100%;
			background:url(${path }/resource/img/gwcbg.jpeg);
			background-size:100% 100%;
		}
		.datediv{
 			float:left;
 		}
 		#div{
 			width:50%;
 			margin:5% auto;
 		}
	</style>
    <script src="${path }/resource/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="${path }/resource/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript"src="${path}/resource/layer/layer.js"></script>
	<script src="${path }/resource/js/distpicker.data.js"></script>	
	<script src="${path }/resource/js/distpicker.js"></script>
<script type="text/javascript">
	 $().ready(function(){
	 	var sum=sumprice();
	 	$("#sum").html(sum);
	      $("#card").on("click",".minus",function(){
	         var obj=$(this).next();
	         var value=obj.val();
	         if(Number(value>1))
	           obj.val(Number(value)-1);
	         else{
	           obj.val(1);
	         }
	         var price=$(this).parent().parent().find(".price").html();
	         $(this).parent().parent().find("span[name='zong']").html(price*obj.val());
	         var sum=sumprice();
	 		 $("#sum").html(sum);
	      });
	      $("#card").on("click",".add",function(){
	         var obj=$(this).prev();
	         var value=obj.val();
	         obj.val(Number(value)+1);
	         var price=$(this).parent().parent().find(".price").html();
	         $(this).parent().parent().find("span[name='zong']").html(price*obj.val());
	         var sum=sumprice();
	 		 $("#sum").html(sum);
	      });
	      $("#card").on("blur",".val",function(){
	      	var value=$(this).val();
	      	var reg=/^([1-9]\d{0,1}|100)$/;
	      	if(reg.test(value)){
	      		var price=$(this).parent().parent().find(".price").html();
		      	$(this).parent().parent().find("span[name='zong']").html(price*value);
		      	var sum=sumprice();
		 		$("#sum").html(sum);
		 		$("#btn").removeAttr("disabled");
	      	}else{
	      		$("#btn").attr("disabled","disabled");
	      		//alert("格式错误，请重新输入");
	      		layer.alert("格式错误，请重新输入", {icon: 5});
	      	}
	      	
	      })
	      
	      $("#clear").click(function(){
	      	window.location.href="${path }/o_clearcard.action?customerid=${customerid}";
	      });
	      
	      $("#cont").click(function(){
	      	$.ajax({
	      		url:"${path}/u_updatecard.action",
	      		type:"post",
	      		data:{card:JSON.stringify(getjson1())},
	      		dataType:"json",
	      		success:function(data){
	      			window.location.href="${path}/module/Login/Menu.jsp";
	      		}		
	      	})
	      	
	      });
	      $("#btn").click(function(){
	      	var money=$("#sum").html();
	      	$("#sum1").html(money);
	      })
	      $("#btn1").click(function(){
	      	var reg = /^[ ]+$/;
	      	var add=$("#add").val();
	      	var phone=$("#phone").val();
	      	if($("#pwd").val()==""||add==""||phone==""||reg.test(add)||reg.test(phone)){
					//alert("输入框不能为空");
					layer.alert("输入框不能为空", {icon: 5});
				}else{
					$.ajax({
			  			url:"${path }/o_insertorderd.action",
			  			type:"post",
			  			dataType:"json",
			  			data:{info:JSON.stringify(getjson()),"customerid":$("#customerid").val(),"money":$("#sum").html(),"add":$("#add").val(),"phone":$("#phone").val(),"content":$("#content").val()
			  				,"province":$("#province1").val(),"city":$("#city1").val(),"district":$("#district1").val()},
			  			success:function(data){
			  				/* alert(data.state);
			  				window.location.href="${path }/o_findMyOrder.action?customerid="+$("#customerid").val(); */
			  				layer.alert(data.state, {icon: 6});
	                     	setTimeout("window.location.href='${path }/o_findMyOrder.action?customerid='+$('#customerid').val()",900);
			  			} 
			  			
			  		 });
				}
	  	 	
  		  });
  		  $("#pwd").blur(function(){
				if($(this).val()!='123456'){
					//alert("密码错误，请重新输入");
					layer.alert("密码错误，请重新输入", {icon: 5});
				}
			})
		
		$("select[dizhi='toaddress']").change(function(){
	   		var province=$("#province1").val();
	   		var city=$("#city1").val();
	   		var district=$("#district1").val();
	   		$("#add").val(province+city+district);
	   });	  
	 });
	 function getjson(){
	  var orderdlist=new Array();
	  	$("#tbody tr").each(function(){
	  		var orderid=$(this).find(".orderid").html();	
	  		var meal=$(this).find(".meal").html();
	  		var count=$(this).find("input[name='count']").val();
	  		var price=$(this).find(".price").html();
	  		var customerid=$(this).find("input[name='customerid']").val();
	  		var orderd={"orderid":orderid,"meal":meal,"count":count,"price":price,"customerid":customerid};	  		
	  		orderdlist.push(orderd);		
	  	});	
	  	return orderdlist;	
	  }
	  function getjson1(){
		  var cardlist=new Array();
		  $("#tbody tr").each(function(){	
		  		var meal=$(this).find(".meal").html();
		  		var count=$(this).find("input[name='count']").val();
		  		var price=$(this).find(".price").html();
		  		var customerid=$(this).find("input[name='customerid']").val();
		  		var card={"meal":meal,"count":count,"price":price,"customerid":customerid};	  		
		  		cardlist.push(card);		
		  	});	
		  	return cardlist;	
	  }
	 
	  function sumprice(){
	  	var sum=0;
	  	$("#tbody tr").each(function(){
	  		var num=$(this).find("span[name='zong']").html();
	  		sum=Number(sum);
	  		num=Number(num);
	  		sum=sum+num
	  		
	  	})
	  	return sum;
	  }
	  function del(cardid,cus){
	  	window.location.href="${path }/o_deletecard.action?cardid="+cardid+"&customerid="+cus;
	  }
	  
	
</script>
  </head>
	  
  
  <body>
  	<div>
    <table id="card" class="table table-bordered table-hover ">
    	<thead>
    	<tr align="center">
    		<td><input type="button" value="清空" id="clear" class="btn btn-success"/></td>
    		<td colspan="5"><h4>购物车</h4></td>
    	</tr>
    	<tr align="center"><td>序号</td><td>商品名</td><td>单价</td><td>数量</td><td>总价</td><td>编辑</td></tr>
    	</thead>
    	<tbody id="tbody">
    	<c:if test="${!empty list }">
    		<c:forEach items="${list }" var="map" varStatus="vas">
    			<tr align="center">
    				<td>${vas.count }</td>
    				<td class="meal">${map.meal }</td>
    				<td class="price">${map.price }</td>
    				<td>
    					<input type="button" class="minus" value="-" style="background:#e4e4e4;border:none"/>
			            <input type="text" class="val" value="${map.count }" name="count" style="width:30px" />
			            <input type="button" class="add" value="+" style="background:#e4e4e4;border:none"/>
			            <input type="hidden" value="${map.customer_id }" name="customerid"/> 
    				</td>
    				<td><span name="zong">${map.count*map.price }</span></td>
    				<td><input type="button" value="删除" onclick="del('${map.card_id }','${map.customer_id }')" class="btn btn-danger"/></td>
    			</tr>
    		</c:forEach>
    	</c:if>
    	</tbody>
    	<tfoot>
    	<tr align="center">
	    	<td colspan="6">
	    		<input type="button" id="cont" value="继续选购" class="btn btn-info "/>
	    		<c:if test="${!empty list }">
		    		<input type="button" id="btn" value="确认购买" class="btn btn-warning" data-toggle="modal" data-target="#myModal"/>
	    			<input type="hidden" value="${customerid}" name="customerid" id="customerid"/> 
		    		合计：￥<span id="sum"></span>
	    		</c:if>
	    	</td>
    	</tr>
    	</tfoot>
    </table>
    </div>
    <!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" id="div" >
			<div class="modal-content"  style="background:#fdf4d9">
				<div class="modal-header"  align="center" >
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h3 class="modal-title" id="myModalLabel">
						应付金额￥：<span id="sum1"></span>
					</h3>
				</div>
				<div class="modal-body"  align="center" style="background:#e4e4e4">
					<table  align="center">
						<tr>
							<td width="20%"> <h4>收货住址</h4></td>
							<td colspan="2" width="80%">
								<div data-toggle="distpicker">
									<div class="datediv">
									<div class="input-group">
										<div class="form-group">
											<label class="sr-only" for="province1">Province</label>
											 <select class="form-control" dizhi='toaddress' name="province" id="province1" data-province="${cuslist[0].customer_province }"></select>
										</div>
										<span class="input-group-addon">省</span>
									</div>
									</div>
									<div class="datediv">
										<div class="input-group">
											<div class="form-group">
												 <label class="sr-only" for="city1">City</label>
												  <select class="form-control" dizhi='toaddress' name="city" id="city1" data-city="${cuslist[0].customer_city }"></select>
											</div>
											 <span class="input-group-addon">市</span>
										</div>
									</div>
									<div class="datediv">
										<div class="input-group">
											<div class="form-group">
												  <label class="sr-only" for="district1">District</label>
												  <select class="form-control" dizhi='toaddress' name="district" id="district1" data-district="${cuslist[0].customer_district }"></select>
											</div>
											<span class="input-group-addon">县</span>
										</div>
									</div>
								</div>
							</td>
						</tr>
						<tr><td width="20%"><h4>详细地址</h4></td><td width="60%"><input type="text" value="${cuslist[0].customer_add }"class="form-control" style="display:inline;" id="add"/></td><td width="20%"></td></tr>
						
						<tr><td width="20%"><h4>联系方式</h4></td><td width="60%"><input type="text" value="${cuslist[0].customer_phone }"class="form-control" style="display:inline;" id="phone"/></td><td width="20%"></td></tr>
						<tr><td width="20%"><h4>备注</h4></td><td width="60%"><textarea class="form-control" id="content" style="display:inline;"></textarea></td><td width="20%"></td></tr>
						<tr>
							<td width="20%"><h4>付款方式</h4></td>
							<td width="60%">
								<select class="form-control" style="display:inline;">
									<option selected="selected">货到付款</option>
								</select>
							</td>
							<td width="20%"></td>
						</tr>
						<!-- <tr >
							<td colspan="3">
								<h4>支付方式：快捷支付</h4>
								<input type="password" class="form-control" style="width:200px;display:inline;" id="pwd" 
								   placeholder="请输入密码">
							</td>
						</tr> -->
					</table> 
				</div>
				<div class="modal-footer" style="background:#fdf4d9">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" class="btn btn-primary" id="btn1">
						立即下单
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
  </body>
</html>
