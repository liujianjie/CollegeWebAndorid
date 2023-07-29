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
    
    <title>My JSP 'SelectOrderd.jsp' starting page</title>
    
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
<script type="text/javascript"src="${path}/resource/layer/layer.js"></script>
<style type="text/css">
	#content{
		width:70%;
		 vertical-align: venter;
		margin:0 auto;
	}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#qr").click(function(){
				
				if($("#empname").val()==""||$("#empname").val()=="null"||$("#empname").val()==null){
					//alert("请录入员工数据");
					layer.alert("请录入员工数据", {icon: 5});
				}else{
					$.ajax({
		               url:"${path }/d_qryg.action",
		               data:{"empname":$("#empname").val(),"orderid":$("#orderid").val()},
		               type:"post",
		               dataType:"json",
		               success:function(data){
		                  if(data.state=='true'){
		                     /* alert(data.message);
		                     window.location.href="${path}/order/SelectOrder?state=${state}"; */
		                     layer.alert(data.message, {icon: 6});
	                     	 setTimeout("window.location.href='${path}/order/SelectOrder?state=${state}'",900);
		                  }
		               }
		            });
				}
				
			});
			$("#jd").click(function(){
				$.ajax({
	               url:"${path }/d_jiedan.action",
	               data:{"orderid":$("#orderid").val()},
	               type:"post",
	               dataType:"json",
	               success:function(data){
	                  if(data.state=='true'){
	                     layer.alert(data.message, {icon: 6});
	                     setTimeout("window.location.href='${path}/order/SelectOrder?state=${state}'",900);
	                  }
	               }
	            });
			});
			$("#cancel").click(function(){
				$.ajax({
	               url:"${path }/d_qxdd.action",
	               data:{"orderid":$("#orderid").val()},
	               type:"post",
	               dataType:"json",
	               success:function(data){
	                  if(data.state=='true'){
	                     layer.alert(data.message, {icon: 6});
	                     setTimeout("window.location.href='${path}/order/SelectOrder?state=${state}'",900);
	                  }
	               }
	            });
			})
			$("#finish").click(function(){
				$.ajax({
	               url:"${path }/d_qrsh.action",
	               data:{"orderid":$("#orderid").val()},
	               type:"post",
	               dataType:"json",
	               success:function(data){
	                  if(data.state=='true'){
	                     layer.alert(data.message, {icon: 6});
	                     setTimeout("window.location.href='${path}/order/SelectOrder?state=${state}'",900);
	                  }
	               }
	            });
			})
			$("#pack").click(function(){
				if(${!empty list}){
					//alert("未完成，请稍后");
					layer.alert("未完成，请稍后", {icon: 5});
					$(this).attr("disabled","disabled");
				}else{
					$.ajax({
		               url:"${path }/d_pack.action",
		               data:{"orderid":$("#orderid").val()},
		               type:"post",
		               dataType:"json",
		               success:function(data){
		                  if(data.state=='true'){
		                     layer.alert(data.message, {icon: 6});
	                     	 setTimeout("window.location.href='${path}/order/SelectOrder?state=${state}'",900);
		                  }
		               }
		            });	
				}
				
			})
			/* $("#back").click(function(){
				window.location.href="${path}/order/SelectOrder?state=${state}";
			}) */
			
			
		})
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
	</script>
  </head>
  
  <body>
  	<div align="center">
  		<c:if test="${orderlist[0].state<4 }">
  			<input type="button" value="取消订单" id="cancel" class="btn btn-danger">
  		</c:if>
  		<c:if test="${orderlist[0].state==3 }">
  			<input type="button" value="完成订单" id="finish" class="btn btn-success">
  		</c:if>  		
  	</div>
  <!--startprint1-->
	<!--打印内容开始-->
  	<div id="content">
  	<h3 align="center">订单详情</h3>
  	<hr style=" height:2px;border:none;border-top:2px dotted #185598;" />
  	<div>订单编号 ${orderlist[0].order_id }&nbsp;&nbsp;下单时间：${orderlist[0].order_date } </div>
  	 
    <div>
    	<table class="table">
    		<tr>
	    		<td>商品</td><td>单价</td><td>数量</td>
	    		<c:if test="${orderlist[0].state==1 }"> <td>状态</td></c:if>
    		</tr>
    		<c:if test="${!empty orderdlist }">
    			<c:forEach items="${orderdlist}" var="map">
    				<tr>
	    				<td>${map.meal_name }</td>
	    				<td>${map.price }</td>
	    				<td>${map.count }</td>
	    				<c:if test="${orderlist[0].state==1 }"> 
		    				<td>
		    					<c:if test="${map.state==0 }">未完成</c:if>
		    					<c:if test="${map.state==1 }">已完成</c:if>	    				
		    				</td>
		    			</c:if>
    				</tr>
    			</c:forEach>
    		</c:if>
    	</table>
    </div>
    <hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
    配送人：&nbsp;${orderlist[0].emp_name }&nbsp;&nbsp;${orderlist[0].phone }
    <div>    
    	<table class="table">
    		<tr><td>合计：</td><td>￥${orderlist[0].money }</td></tr>
    		<tr><td>姓名：</td><td>${orderlist[0].customer_name }</td></tr>
    		<tr><td>电话：</td><td>${orderlist[0].customer_phone }</td></tr>
    		<tr><td>地址：</td><td>${orderlist[0].customer_add }</td></tr>
    		<tr><td>备注：</td><td><c:if test="${empty orderlist[0].order_content}">无</c:if> ${orderlist[0].order_content}</td></tr>
    	</table>
    	<div align="center"></div>
    </div>
    <hr style="height:1px;border:none;border-top:1px dashed #0066CC;" />
    </div>
     <!--打印内容结束-->
<!--endprint1-->
    <div align="center">
    <c:if test="${orderlist[0].state==0 }">
    	<input type="button" id="jd" value="接单" class="btn btn-success"/>
    </c:if>
    <c:if test="${orderlist[0].state==1 }">   	
    	<input type="button" id="pack" value="打包" class="btn btn-success"/>
    </c:if>
    <c:if test="${orderlist[0].state==3 }">
    	<input type="button" id="print" value="打印" title='打印1' onclick="preview(1)"class="btn btn-primary"/>
    </c:if>
    <c:if test="${orderlist[0].state==2||orderlist[0].state==3 }">
	  	  配送人：
	    <select name="empname" id="empname" class="form-control" style="width:200px;display:inline;">
	    	<c:if test="${!empty emplist }">
	    		<c:forEach items="${emplist }" var="map">
	    			<option value="${map.emp_name }" <c:if test="${map.emp_id==orderlist[0].emp_id }">selected='selected'</c:if> >
	    				${map.emp_name }&nbsp;&nbsp;${map.phone}
	    			</option>
	    		</c:forEach>
	    	</c:if>
	    </select>
    	<input type="button"  id="qr" class="btn btn-success" <c:if test="${orderlist[0].state==2 }">value="开始配送"</c:if><c:if test="${orderlist[0].state==3 }">value="更换"</c:if> />
    </c:if>
    <a href="${path}/order/SelectOrder?state=${state}"><input type="button" id="back" value="返回" class="btn btn-success"></a>
    <input type="hidden" id="orderid" value="${orderlist[0].order_id }">  	
    </div>
  </body>
</html>
