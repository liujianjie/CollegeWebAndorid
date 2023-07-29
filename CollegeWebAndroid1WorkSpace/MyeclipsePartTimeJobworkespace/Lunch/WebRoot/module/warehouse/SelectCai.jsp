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
    
    <title>My JSP 'SelectCai.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path }/resource/js/bootstrap.js"></script>
	<link rel="stylesheet"  href="${path }/resource/css/bootstrap.min.css"></link>
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${path}/resource/layer/layer.js"></script>
	<style type="text/css">
		    *{
				list-style: none;
			}
		#all{
		    float:right;
		    position:relative;
		    top:175px;
		}
		#ddiv{
		    width:500px;
		    height:400px;
		    margin:10px auto;
		    background:#FFFFFF;
		}
		body{
			background:#8A8A8A;
		}
		#form{
			background:#FFFFFF;
			
		}
		ul li{
			float:left;
			position:relative;
			top:20px;
		} 
		h3{
			text-align:center;
		}
	</style>
  </head>
   <script type="text/javascript">
    	 $(document).ready(function(){
	     function checkInfo(id){
				$("input[value='"+id+"']").prop("checked",true);
				}
	     function oncheckInfo(value,id){
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
             window.location.href="${path}/dc/Cai?mealid=${mealid}";
        });
        $("#btn").click(function(){
            $.ajax({
                url:"${path}/dc/UpdateFindCaterial",
                data:$("#form").serialize(),
                dataType:"json",
                type:"post",
                success:function(data){
                   if(data.state){
                       layer.alert(data.message, {icon: 6});
                       setTimeout("window.location.href='${path}/dc/Cai?mealid=${mealid}'",900);
                   }else{
                       layer.alert(data.message, {icon: 6});
                   }
                }
            });
        });
     });
  </script>
  <body>
      <div id="ddiv">
      	
  	   <form id="form">
		<input type="hidden" name="mealid" value="${mealid}">
  	       <h3>材料名称:${caterialname}</h3>
  	       <ul>
  	       		<li>
		  	         <c:forEach items="${list}" var="map">
		  	              <input type="checkbox" name="caterialid"
			  	              <c:if test="${map.xz eq 0}">checked="checked"</c:if>
			  	                 value="${map.caterial_id }" id="${map.caterial_id }"/>${map.caterial_name }
			  	           
		  	         </c:forEach>
  	         	</li>
  	       </ul>
  	       <div id="all">
  	       <input class="btn btn-info" type="button" value="保存" id="btn"/>
  	       <input class="btn btn-info" type="button" value="返回" id="btn2"/>
  	       </div>
  	   </form>
  	</div>
  </body>
</html>
