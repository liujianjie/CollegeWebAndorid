<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
request.setAttribute("path", path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'CaiLiao.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path }/resource/js/bootstrap.js"></script>
	<link rel="stylesheet"  href="${path }/resource/css/bootstrap.min.css"></link>
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${path}/resource/layer/layer.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		    *{
			list-style: none;
			}
		#all{
		    float:right;
		    position:relative;
			top:300px;
		   }
		
		#ddiv{
		    width:450px;
		    height:400px;
		    margin:10px auto;
		    background:white;
		}
		body{
			background:#8A8A8A;
		}
		#form{
			background:#FFFFFF;
			
		}
		#xin{
			float:left;
			position:relative;
		}
		 ul li{
			float:left;
			position:relative;
			top:40px;
			right:20px;
		} 
		h3{
			text-align:center;
		}
	</style>
	<script type="text/javascript">
	$(document).ready(function(){
			function checkInfo(id){
    			$("input[value='"+id+"']").prop("checked",true);
    		}
		
		
			function oncheckInfo(value,id){
    			/* var xuanze=$("input[id='"+id+"']:checked").length;
    			if(xuanze<=0){
    				$("input[value='"+id+"']").prop("checked",false);
    			} */
    			$("input[value='"+id+"']").prop("checked",false);
    		}
    		
    		$(":checkbox").click(function(){
    			var check=$(this).prop("checked");
    			var value=$(this).val();
    			var id=this.id;
    			if(check){
    				$("input[id='"+value+"']").prop("checked",check);
    				checkInfo(id);
    			}else{
    				$("input[id='"+value+"']").prop("checked",check);
    				oncheckInfo(value,id);
    			}
    		});
    		
    	
    		$("#btn2").click(function(){
    			window.location.href="${path}/dc/Goods";
    		});
    		
    		
    		  $("#btn").click(function(){
    			$.ajax({
    				url:"${path}/dc/UpdateCai",
    				data:$("#form").serialize(),
    				dataType:"json",
    				type:"post",
    				success:function(data){
    					if(data.state){
    						layer.alert(data.message,{icon:6});
    						setTimeout("window.location.href='${path}/dc/Goods'",900);
    					}else{
    						layer.alert(data.message,{icon:6});
    					}
    				}
    			});
    		});
		  
		});
		
	
	</script>
  </head>
  
  <body>
    <div id="ddiv">
  		<form id="form">
  			<input type="hidden" name="mealid" value="${mealid}">
  			<h3>材料名称</h3>
  			<div>
  			<a href="${path}/dc/SelectCai?mealid=${mealid }" class="btn btn-success" id="xin">新增</a>
  			</div>
  			<div>
  			<ul>
  				<c:forEach items="${list}" var="map">
  						<li><input type="checkbox" name="caterialid" id="${map.caterial_id}"
  							<c:if test="${map.xz eq  1 }">checked="checked"</c:if>
  						value="${map.caterial_id}"/>${map.caterial_name}
  						</li>
  				</c:forEach>
  			</ul>
  			</div>	
  			<div id="all">
  				<input type="button" value="保存" id="btn" class="btn btn-info"/>
  				<input type="button" value="返回" id="btn2" class="btn btn-info"/>
  			</div>
  		</form>
  	</div>
  </body>
</html>
