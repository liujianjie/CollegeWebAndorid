<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'Bottomadd.jsp' starting page</title>
    

  </head>
  
  <body>
	<form action="goods/add" enctype="multipart/form-data" method="post" onsubmit="return submit_form();" > 
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
    				<input type="text" id="uname" name="uname" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">地区(地址):</font>
    			</td>
    			<td align="left">
    				<input type="text" id="dress" name="dress" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">说明:</font>
    			</td>
    			<td align="left" height="30">
    				<input type="text" id="dec" name="dec" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">图片:</font>
    			</td>
    			<td align="left" >
    				<input type="hidden" id="photo_hidden" name="photo" />
    				<input type="file" id="photo_file" name="img" size="55" onchange="chooseFile(this);" multiple="multiple">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">价格:</font>
    			</td>
    			<td align="left" >
    				<input type="text" id="price" name="price" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">市场价:</font>
    			</td>
    			<td align="left">
    				<input type="text" id="scj" name="scj" style="width:320px;height:30px">
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
    <script type="text/javascript">
	function chooseFile(fileInput){
		var fileName = fileInput.value;
		var index = fileName.lastIndexOf('.');
		
		var suffix = ["jpg","png","gif","bmp"];
		var file_suffix = fileName.substring(index+1);
		for(var s in suffix){
			if(file_suffix == suffix[s]){
				document.getElementById("photo_hidden").value=fileName;
				return;
			}
		}
		alert("请选择图片文件(*.gif,*.png,*.bmp,*.jpg)！");
		document.getElementById("photo_hidden").value="";
	}
	
	function submit_form(){
		// 验证
  		var uname = document.getElementById("uname").value;
  		var dress = document.getElementById("dress").value;
  		var dec = document.getElementById("dec").value;
  		var price = document.getElementById("price").value;
  		var scj = document.getElementById("scj").value;
  		var photo = document.getElementById("photo_hidden").value;
  		if("" == uname){
  			alert("请输入商品名称");
  			document.getElementById("uname").focus();
  			return false;
  		}else if("" == dress){
  			alert("请选择地址！");
  			document.getElementById("dress").focus();
  			return false;
  		}else if("" == dec){
  			alert("请输入描述！");
  			document.getElementById("dec").focus();
  			return false;
  		}else if("" == price){
  			alert("请输入价格！");
  			document.getElementById("price").focus();
  			return false;
  		}else if("" == scj){
  			alert("请输入市场价格！");
  			document.getElementById("scj").focus();
  			return false;
  		}else if("" == photo){
  			alert("请选择商品图片！");
  			document.getElementById("photo_file").focus();
  			return false;
  		}
		return true;
	}
	</script>
  </body>
</html>
