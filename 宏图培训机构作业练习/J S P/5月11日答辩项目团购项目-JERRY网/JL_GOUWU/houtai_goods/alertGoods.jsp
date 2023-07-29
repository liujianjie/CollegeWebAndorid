<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    
    <title>My JSP 'alertemp.jsp' starting page</title>

  </head>
  
  <body>
  <form action="goods?method=alert" enctype="multipart/form-data" method="post" name="frm">
  <input type="hidden" value="${goods.g_id }" name="id"> 
    	<h1 align="center">修改商品</h1>
    	<table width="65%" align="center" bgcolor="#fbfbfb" border="1.5">
    		<tr align="center" >
    			<td colspan="2">
    				<h3>请修改你的商品信息</h3>
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">商品名称:</font>
    			</td>
    			<td align="left">
    				<input type="text" name="uname" size="55" value="${goods.g_name }"style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">地区(地址):</font>
    			</td>
    			<td align="left">
    				<input type="text" name="dress" size="55" value="${goods.g_dress }" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">说明:</font>
    			</td>
    			<td align="left">
    				<input type="text" name="dec" size="55" value="${goods.g_dec }" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center">
    			<td width="250">
    				<font size="4">图片:</font>
    			</td>
    			<td align="left" >
    				<img src="file/${goods.g_img }" height="150" width="165">
    					<br>
    				<input type="file" name="img" size="55" onchange="go()">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">价格:</font>
    			</td>
    			<td align="left">
    				<input type="text" name="price" size="55" value="${goods.g_price }" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">市场价:</font>
    			</td>
    			<td align="left">
    				<input type="text" name="scj" size="55" value="${goods.g_scj }" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">归属分类:</font>
    			</td>
    			<td align="left">
    				<select name="bottom">
    					<c:forEach items="${list}" var="lists">
    						<option value="${lists.bottom_id }" <c:if test="${goods.bottom_id eq lists.bottom_id }">selected</c:if>>
    							${lists.bottom }
    						</option>
    					</c:forEach>
    				
    				</select>
    			</td>
    		</tr>
    		<tr align="center">
    			<td width="250">
    				<font size="4">商品详情:</font>
    			</td>
    			<td align="left">
    				<textarea cols="60" rows="5" name="descrip">${goods.g_descrip }</textarea>
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td colspan="2">
    				<input type="button" value="完成" width="20" onclick="ok()">
    				<input type="button" value="取消" width="20" onclick="location.href='goods?method=list'">
    			</td>
    		</tr>
    	</table>

    </form>
       <script>
  	//去修改
  	function go(){
  		//submit提脚的是去修改 又返回来了
  		document.frm.submit();
  	}
  	//大功告成
  	function ok(){
  		//去list
  		location.href="goods?method=list";
  	}
  </script>
  </body>
</html>
