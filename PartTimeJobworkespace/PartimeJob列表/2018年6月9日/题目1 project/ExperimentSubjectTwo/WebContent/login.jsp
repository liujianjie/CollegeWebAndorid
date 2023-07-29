<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生-登录界面</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

	function submitData(){
		var user = $("#username").val();
		var psd = $("#password").val();
		if(user==''){
			alert("用户名不能为空");
			return;
		}else if(psd==''){
			alert("密码不能为空");
			return;
		}
		 $("#fm").submit();
	}

	function resetValue(){
		$("#username").val("");
		$("#password").val("");
	}

</script>
</head>
<body>
<div style="position: absolute;width: 100%;height: 100%;z-index: -1;left: 0;top: 0">
	<img src="${pageContext.request.contextPath}/static/images/login_bg.jpg" width="100%" height="100%" style="left: 0;top: 0;">
</div>
<div class="easyui-window" title="学生登录" data-options="modal:true,closable:false,collapsible:false,minimizable:false,maximizable:false" style="width: 400px;height: 280px;padding: 10px">
	<form id="fm" action="student?method=login" method="post">
		<table cellpadding="6px" align="center">
			<tr align="center">
				<th colspan="2" style="padding-bottom: 10px"><big>学生登录</big></th>
			</tr>
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" id="username" name="username" class="easyui-validatebox" required="true" style="width: 200px"/>
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>
					<input type="password" id="password" name="password" class="easyui-validatebox" required="true" style="width: 200px"/>
				</td>
			</tr>
			<c:if test="${msg != null}">
				<tr >
					<td colspan="2" align="center">
						<font color="red">${msg }</font>
					</td>
				</tr>
			
			</c:if>
			<tr>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td></td>
				<td>
<!-- 					<button type="submit">登录</button> -->
					<a href="javascript:submitData()" class="easyui-linkbutton" iconCls="icon-submit">登录</a>&nbsp;
					<a href="javascript:resetValue()" class="easyui-linkbutton" iconCls="icon-reset">重置</a>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>