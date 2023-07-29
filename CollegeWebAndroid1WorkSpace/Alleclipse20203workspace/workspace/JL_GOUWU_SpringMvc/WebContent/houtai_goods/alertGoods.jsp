<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'alertemp.jsp' starting page</title>

  </head>
  
  <body>
  <form id="form1" action="goods/alertnoimg" method="post" name="frm" onsubmit="return submit_form();" >
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
    				<input type="text" id="uname" name="uname" size="55" value="${goods.g_name }"style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">地区(地址):</font>
    			</td>
    			<td align="left">
    				<input type="text" id="dress" name="dress" size="55" value="${goods.g_dress }" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">说明:</font>
    			</td>
    			<td align="left">
    				<input type="text" id="dec" name="dec" size="55" value="${goods.g_dec }" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center">
    			<td width="250">
    				<font size="4">图片:</font>
    			</td>
    			<td align="left" >
    				<input type="hidden" id="photo_hidden" name="photo" value="${goods.g_img }">
    				<img src="file/${goods.g_img }" id="showimg"  height="150" width="165">
    					<br>
    				<input type="file" id="photo_file" name="img" size="55" onchange="chooseFile(this);" multiple="multiple">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">价格:</font>
    			</td>
    			<td align="left">
    				<input type="text" id="price" name="price" size="55" value="${goods.g_price }" style="width:320px;height:30px">
    			</td>
    		</tr>
    		<tr align="center" height="30">
    			<td width="250">
    				<font size="4">市场价:</font>
    			</td>
    			<td align="left">
    				<input type="text" id="scj" name="scj" size="55" value="${goods.g_scj }" style="width:320px;height:30px">
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
    				<input type="submit" value="修改" width="20">
    				<input type="button" value="取消" width="20" onclick="location.href='goods/list'">
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
  				// img指定不要显式把。
  				document.getElementById("showimg").style.display= "none";
  				return;
  			}
  		}
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
  		}
  		// 根据是否上传新文件 指定不同action
  		var choicefile = document.getElementById("photo_file");
  		// 1.若没有上传新文件
  		if(choicefile.value == ""){
  			document.getElementById("form1").encoding = "";
  			document.getElementById("form1").action = "goods/alertnoimg"
  		}
  		// 2.若上传了新文件
  		if(choicefile.value != ""){
  			document.getElementById("form1").encoding = "multipart/form-data";
  			document.getElementById("form1").action = "goods/alertwithimg";
  		}
  		return true;
  	}
  	</script>
  </body>
</html>
