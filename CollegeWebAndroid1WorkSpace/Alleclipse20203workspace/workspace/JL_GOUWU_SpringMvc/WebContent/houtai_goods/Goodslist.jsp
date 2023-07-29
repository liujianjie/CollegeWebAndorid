<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Moldlist.jsp' starting page</title>
    <style>
  		a{text-decoration: none}
  	</style>

  </head>
  
  <body>
  	<h1 align="center">商品信息</h1>
  	<form action="goods/list" method="post">
    <table width="100%" align="center" bgcolor="black" cellspacing="1.5">
    	<tr bgcolor="white" height="50">
    		<th width="5%">
    			编号
    		</th>
    		<th width="10%">
    			图片
    		</th>
    		<th width="10%">
    			名称
    		</th>
    		<th width="10%">
    			地点（区）
    		</th>
    		<th width="20%">
    			说明
    		</th>
    		<th width="10%">
    			价格
    		</th>
    		<th width="10%">
    			市场价
    		</th>
    		<th width="5%">
    			已售
    		</th>
    		<th width="10%">
    			归属分类
    		</th>
    		<th width="10%">
    			操作
    		</th>
    	</tr>
    	<c:forEach items="${list}" var="list">
    		<tr align="center" bgcolor="white"> 
					<td>${list.g_id }</td>
					<td><img src="file/${list.g_img }" width="130" height="150"/></td>
					<td>${list.g_name }</td>
					<td>${list.g_dress }</td>
					<td>${list.g_dec }</td>
					
					<td>${list.g_price }</td>
					<td>${list.g_scj }</td>
					<td>${list.g_sale }</td>
					<td>${list.bottom }</td>
					<td>
						<a href="goods/goalert?id=${list.g_id }">修改</a>
						<a href="goods/del?id=${list.g_id }" onclick="return confirm('确定吗？')">删除</a>
					</td>
			</tr>
    	</c:forEach>
    	<tr bgcolor="white" height="30">
    		<td colspan="10">
				<font color="#008080">
    			<a href="goods/list?currp=1">首页</a>		    			
    			<a href="goods/list?currp=${currPage-1 }">上一页</a>
				<c:forEach begin="${currPage}" end="${currPage+2}" var="i" step="1">
					<c:if test="${i<=totalPage}">
    					<a href="goods/list?currp=${i }">${i }</a>				    		
    				</c:if>
				</c:forEach>
		    	<a href="goods/list?currp=${currPage+1}">下一页</a>	
		   		<a href="goods/list?currp=${totalPage}">尾页</a>
		    	跳转到<input type="text" size=3 id="tx1" value="${currPage}"><input type="button" value="GO" onclick="fangfa();"> 
    			当前页为 <font color="red">${currPage}</font>/<font color="red">${totalPage }</font>
    			</font>	
		    </td>
    	</tr>
    </table>
    </form>
	<script>
	    	function fangfa(){
	    		var page=document.getElementById("tx1").value;
	    		if(isNaN(page)){
	    			alert("请输入正确的数字");
	    			document.getElementById("tx1").value="";
	    			document.getElementById("tx1").focus();
	    		}else{
	    			location.href="goods/list?currp="+page;
	    		}
	    	}
   	</script>
  </body>
</html>
