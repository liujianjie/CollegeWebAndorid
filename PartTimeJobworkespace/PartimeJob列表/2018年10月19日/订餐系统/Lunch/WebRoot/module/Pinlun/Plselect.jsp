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
    
    <title>My JSP 'Plselect.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${path}/resource/js/jquery-1.8.3.min.js"></script>
	<link rel="stylesheet" href="${path}/resource/css/bootstrap.min.css" />
	<script type="text/javascript" src="${path}/resource/layer/layer.js"></script>
	<style type="text/css">
	  #ad{
	    line-height:60px;
	   }
	 #dfoot{
           font-size:16px;
          }
	</style>
	<script type="text/javascript">
	  function goTo(nowpage){
	       $("#searchForm").attr("action","${path}/pl_SelectPl.action?nowpage="+nowpage);
          $("#searchForm").submit();
       }
	</script>
	<script type="text/javascript">
	  $(document).ready(function(){
	    
	  });
	  function del(commentid,nowpage){
	  	$.ajax({
	  		url:"${path}/pl_delPl.action",
	  		data:{"commentid":commentid},
	  		type:"post",
		    dataType:"json",
		    success:function(data){
		          if(data.state){
		              layer.alert(data.message, {icon: 6});
		              setTimeout(goTo(nowpage),3000);
		          }
		    }
	  	});
	  }
	  function Huifu(commentid){
	     window.location.href="${path}/pl_findPl.action?commentid="+commentid;
	  }
	</script>
  </head>
  <body>
  <div id="ad" align="center">
     <form id="searchForm" action="${path}/pl_SelectPl.action" method="post">
                         评论内容<input type="text" name="commentcontent" class="form-control" style="width:150px;display:inline;"  value="${usermap.commentcontent }"/>&nbsp;&nbsp;&nbsp;
	                 回复内容<input type="text" name="commentreplay" class="form-control" style="width:150px;display:inline;"  value="${usermap.commentreplay }"/>&nbsp;&nbsp;&nbsp;
	        <input type="submit" class="btn btn-info" value="查询" id="seachBtn"/>
     </form>
    <table class="table table-bordered table-hover table-striped">
       <tr align="center"><td colspan="7"><h3>菜品评论列表</h3></td></tr>
       <tr align="center">
         <td>菜品名称</td>
         <td>评论人</td>
         <td>评论内容</td>
         <td>评论时间</td>
         <td>回复内容</td>
         <td>回复时间</td>
         <td>操作</td>
       </tr>
      <c:if test="${!empty plist }">
          <c:forEach items="${plist }" var="son">
            <tr align="center">
             <td>${son.meal_name}</td>
             <td>${son.customer_name}</td>
             <td>${son.comment_content}</td>
             <td>${son.comment_date}</td>
             <td>${son.comment_replay}</td>
             <td>${son.replay_time}</td>
             <td>
                 <input type="button" onclick="del(${son.comment_id},${page.nowpage })" value="删除" name="delBtn" class="btn btn-danger "/>
                 <input type="button" onclick="Huifu(${son.comment_id})" value="回复"  name="addBtn" class="btn btn-info "/>
              </td>
            </tr>
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
</html>
