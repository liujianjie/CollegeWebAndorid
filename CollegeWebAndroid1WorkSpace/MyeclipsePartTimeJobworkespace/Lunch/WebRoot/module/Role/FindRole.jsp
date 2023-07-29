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
    
    <title>My JSP 'FindRole.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="${path}/resource/css/bootstrap.min.css" />
    <script type="text/javascript" src="${path }/resource/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="${path }/resource/js/bootstrap.min.js"></script>
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
	   function goTo(page){
          $("#searchForm").attr("action","${path}/dc/FindRole?nowpage="+page);
          $("#searchForm").submit();
       }
        function del(roleid,page,state){
				$.ajax({
					url:"${path}/dc/UpdateState",
					data:{"roleid":roleid,"state":state},
					dataType:"json",
					type:"post",
					success:function(data){
						if(data.result){
						     layer.alert(data.message, {icon: 6});
		                      setTimeout("goTo("+page+")",900);
						}else{
						    layer.alert(data.message, {icon: 6});
		                     setTimeout("goTo("+page+")",900);
						}
					}
				});
		}
	  	function add(){
	  	   window.location.href="${path}/dc/FindRoleByid";
	  	}
	  	function update(roleid){
	  	   window.location.href="${path}/dc/FindRoleByid?roleid="+roleid;
	  	}
	</script>
  </head>
  <body>
   <div id="dhead" align="center">
        <form id="searchForm" action="${path}/dc/FindRole" method="post">
                         角色名称<input type="text" name="rolename" class="form-control" style="width:125px;display:inline;" placeholder="请输入查询角色"  value="${usermap.rolename }"/>&nbsp;&nbsp;&nbsp;
	                 角色等级<input type="text" name="rolelevel" class="form-control" style="width:125px;display:inline;" placeholder="请输入查询角色等级"   value="${usermap.rolelevel }"/>&nbsp;&nbsp;&nbsp;
	        <input type="submit" class="btn btn-info" value="查询" id="seachBtn"/>
            <input type="button" onclick="add()" id="alter" value="新增" class="btn btn-primary"/>
        </form>
     <caption><h4>角色列表</h4></caption>
    <table  class="table table-bordered table-hover table-striped">
     <thead>
        <tr align="center">
           <td>序号</td>
           <td>角色名称</td>
           <td>角色等级</td>
           <td>操作</td>
           <td>权限管理</td>
        </tr>
       </thead>
	        <c:if test="${!empty userlist }">
	             <c:forEach items="${userlist }" var="map" varStatus="aa">
	                <tbody>
	                 <tr align="center">
	                    <td>${aa.count+(page.nowpage-1)*(page.pagecount) }</td>
	                    <td>${map.role_name }</td>
	                    <td>${map.role_level }</td>
	                    <td>
	                      
	                       <c:if test="${map.state eq 1 }">
									<input type="button" onclick="del(${map.role_id},${page.nowpage },0)" name="change" id="change" value="启用" class="btn btn-danger"/>
								</c:if>
								<c:if test="${map.state eq 0 }">
								<input type="button"  onclick="update('${map.role_id}')"
							   			value="修改" class="btn  btn btn-info " >
								<input type="button" onclick="del(${map.role_id},${page.nowpage },1)" name="change" id="change" value="禁用" class="btn btn-danger"/>
								</c:if>
	                    </td>
	                    <td>
	                       <a class="btn btn-primary" data-toggle="modal" data-target="#myModal" href="${path }/dc/FunctionsRoleSel?roleid=${map.role_id}&rolename=${map.role_name}">功能授权</a>
	                    </td>
	                 </tr>
	                 </tbody>
	             </c:forEach>
	        </c:if>
	      </table>
     </div>
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
     <div class="modal fade" id="myModal" data-backdrop="false" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"aria-hidden="true">
		 <div class="modal-dialog">
			 <div class="modal-content">
			 </div>
		 </div>
	 </div>					 
  </body>
</html>
