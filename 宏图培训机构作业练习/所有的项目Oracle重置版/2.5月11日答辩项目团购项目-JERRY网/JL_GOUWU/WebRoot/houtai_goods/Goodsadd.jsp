<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    
    <title>My JSP 'Bottomadd.jsp' starting page</title>
    

  </head>
  
  <body>
	<form action="goods?method=add" enctype="multipart/form-data" method="post" > 
    	<h1 align="center">添加商品</h1>
    	<table width="65%" align="center" bgcolor="#fbfbfb" border="1.5">
    		<tr align="center">
    			<td colspan="2">
    				<h3>请填写你添加的商品信息</h3>
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">商品名称:</font>
    			</td>
    			<td align="left">
    				<input type="text" name="uname" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">地区(地址):</font>
    			</td>
    			<td align="left">
    				<input type="text" name="dress" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">说明:</font>
    			</td>
    			<td align="left" height="30">
    				<input type="text" name="dec" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">图片:</font>
    			</td>
    			<td align="left" >
    				<input type="file" name="img" size="55">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">价格:</font>
    			</td>
    			<td align="left" >
    				<input type="text" name="price" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">市场价:</font>
    			</td>
    			<td align="left">
    				<input type="text" name="scj" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">归属分类:</font>
    			</td>
    			<td align="left">
    				<select name="bottom">
    					<c:forEach items="${list}" var="lists">
    						<option value="${lists.bottom_id }">
    							${lists.bottom }
    						</option>
    					</c:forEach>
    				
    				</select>
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">商品详情:</font>
    			</td>
    			<td align="left">
    				<textarea cols="60" rows="5" name="descrip"></textarea>
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td colspan="2">
    				<input type="submit" value="上传商品" width="20">
    			</td>
    		</tr>
    	</table>
    </form>
  </body>
</html>
