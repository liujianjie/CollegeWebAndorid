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
    
    <title>My JSP 'Selectfunction.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path}/resource/js/jquery-1.8.3.min.js"></script>
    <link rel="stylesheet" href="${path}/resource/css/bootstrap.min.css" />
    <script type="text/javascript" src="${path}/resource/layer/layer.js"></script>
    <style type="text/css">
       #dhead{
           margin:150px 0px 0px 0px;
          }
       #dhead td{
            width:20%;
       		}
          #dfoot{
           font-size:16px;
          }
    </style>
	<script type="text/javascript">
       function del(functionid,functionparentid,state){
				$.ajax({
					url:"${path}/fun_UpdateState.action",
					data:{"functionid":functionid,"state":state},
					dataType:"json",
					type:"post",
					success:function(data){
						if(data.state){
						    layer.alert(data.message, {icon: 6});
		                    setTimeout("window.location.href='${path}/fun_SelFunction.action?functionid="+functionparentid+"'",900);
						}
					}
				});
		}
		//修改
	  	function updateall(functionid,parentid){
	  	   window.location.href="${path}/fun_FindFunctionByid.action?functionid="+functionid+"&parentid="+parentid;
	  	}
	  	//新增
	  	function addRole(){
	  	   window.location.href="${path}/fun_FindFunctionByid.action?parentid="+${functionid };
	  	}
	</script>
	<script type="text/javascript">
	  function goTo(nowpage){
	        window.location.href="${path}/fun_SelFunction.action?functionid="+functionparentid+"&nowpage="+nowpage;
       }
	</script>
  </head>
  <body>
   <div id="dhead">
      	<div>
          <input type="button" class="btn  btn btn-info " value="新增" onclick="addRole()"/>
        </div>
	    <table  border="1" class="table table-bordered table-hover table-striped">
	     <thead>
	        <tr align="center">
	           <td>功能名称</td>
	           <td>功能介绍</td>
	           <td>链接地址</td>
	           <td>父级功能名称</td>
	           <td>操作</td>
	        </tr>
	       </thead>
	        <c:if test="${!empty list2 }">
	             <c:forEach items="${list2 }" var="map" varStatus="">
	                <tbody>
	                 <tr align="center">
	                    <td>${map.function_name }</td>
	                    <td>${map.function_dec }</td>
	                    <td>${map.function_url }</td>
	                    <td>${map.parent_name }</td>
	                    <td>
	                       <c:if test="${map.state eq 1}">
									<input type="button" onclick="del(${map.function_id},${map.function_parent_id},0)" name="change" id="change" value="启用" class="btn btn-danger"/>
								</c:if>
								<c:if test="${map.state eq 0}">
								  	<input type="button"  onclick="updateall('${map.function_id}','${functionid }')"
							   				value="修改" class="btn  btn btn-info " >
									<input type="button" onclick="del(${map.function_id},${map.function_parent_id},1)" name="change" id="change" value="禁用" class="btn btn-danger"/>
								</c:if>
	                    </td>
	                 </tr>
	                 </tbody>
	             </c:forEach>
	        </c:if>
		    </table>
		    <div id="dfoot" align="center">
		         <ul class="pagination pagination-lg">
	  			<li><a>当前第${page.nowpage }页</a></li>
				<li><a href="javascript:goTo(1)">首页</a></li>
				
		    	<c:if test="${page.nowpage!=1&&page.sumpage!=0 }">
		  			<li><a href="javascript:goTo(${page.nowpage-1 })">上一页</a></li>
		  		</c:if>
		  		
		    	<c:if test="${page.nowpage!=page.sumpage&&page.sumpage!=0 }">
		  			<li><a href="javascript:goTo(${page.nowpage+1 })">下一页</a></li>
		  		</c:if>
		    	<c:if test="${page.sumpage!=0 }">
		  			<li><a href="javascript:goTo(${page.sumpage })">尾页</a></li>
		  			<li><a>总共${page.sumpage }页</a></li>
		  		</c:if>
		  		<c:if test="${page.sumpage==0 }">
		  			<li><a href="javascript:goTo(1)">尾页</a></li>
		  			<li><a>总共1页</a></li>
		  		</c:if>
		  		<li><a>共${page.sumcount }条记录</a></li>
			</ul><br>
      </div>
     </div>
  </body>