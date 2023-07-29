<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Rolefun.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path }/resource/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${path}/resource/layer/layer.js"></script>
	<style type="text/css">
		    *{
				list-style: none;
			}
		#all{
		    float:right;
		   }
		span{   
			padding-left:40px;
			display: inline-block;
			} 
		#ddiv{
		    width:520px;
		    height:520px;
		    margin:10px auto;
		}
	</style>
  </head>
  <script type="text/javascript">
     $(document).ready(function(){
	     function checkInfo(id){
				$("input[value='"+id+"']").prop("checked",true);
				}
	     function oncheckInfo(value,id){
			var xuanze=$("input[id='"+id+"']:checked").length;
				if(xuanze<=0){
					$("input[value='"+id+"']").prop("checked",false);
					}
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
             window.location.href="${path}/dc/FindRole";
        });
        $("#btn").click(function(){
            $.ajax({
                url:"${path}/dc/UpdateRolefun",
                data:$("#form").serialize(),
                dataType:"json",
                type:"post",
                success:function(data){
                   if(data.state){
                       layer.alert(data.message, {icon: 6});
                       setTimeout("window.location.href='${path}/dc/FindRole'",900);
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
  	       <input type="hidden" name="roleid" value="${roleid}"/>
  	       <h4>角色名称:${rolename }</h4>
  	       <ul>
  	         <c:forEach items="${list}" var="map">
  	            <li class="father">
  	              <input type="checkbox" name="functionid" 
	  	              <c:if test="${map.xz eq 1}">checked="checked"</c:if>
	  	                 value="${map.function_id }" id="${map.function_parent_id }"/>${map.function_name }<br/>
  	              <c:if test="${!empty map.son}">
  	                <c:forEach items="${map.son }" var="son">
  	                <span>
  	                      <input type="checkbox" name="functionid" 
		  	                <c:if test="${son.xz eq 1}">checked="checked"</c:if>
		  	                    value="${son.function_id }" id="${son.function_parent_id }"/>${son.function_name}
  	                </span>
  	                </c:forEach>
  	              </c:if>
  	            </li>
  	         </c:forEach>
  	       </ul>
  	       <div id="all">
  	       <input class="btn btn-info" type="button" value="保存" id="btn"/>
  	       <input class="btn btn-info" type="button" value="返回" id="btn2"/>
  	       </div>
  	   </form>
  	</div>	
</body>
</html>
