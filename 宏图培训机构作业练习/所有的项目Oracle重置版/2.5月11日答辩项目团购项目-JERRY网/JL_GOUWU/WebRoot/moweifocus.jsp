<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'moweifocus.jsp' starting page</title>
 
  </head>
  
  <body>
<input type="text" id="test1" name="test1" value="test123" onfocus="moveEnd(this);" onclick="moveEnd(this);" />
<script>
document.getElementById("test1").focus();
function moveEnd(obj) {
obj.focus();
var len = obj.value.length;
if (document.selection) {
var sel = obj.createTextRange();
sel.moveStart('character', len);
sel.collapse();
sel.select();
} else if (typeof obj.selectionStart == 'number'
&& typeof obj.selectionEnd == 'number') {
obj.selectionStart = obj.selectionEnd = len;
}
}
</script>
  </body>
</html>
