<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="kindeditor-4.1.10/themes/default/default.css" />
	<script charset="utf-8" src="kindeditor-4.1.10/kindeditor-min.js"></script>
<script type="text/javascript">
		var editor;
		KindEditor.ready(function(k){
			 editor=k.create("#kind_editor", {
				items : [
							'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
							'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
							'insertunorderedlist', '|', 'emoticons']
					});
		});
		
		function checkform(){
// 			var  txt =document.getElementById("kind_editor").value;
			var  txt= editor.text();
			alert(txt);
			
		}
</script>
</head>
<body>
<form action="#" onsubmit="return checkform();">
<textarea rows="5"  id="kind_editor" name=""></textarea>
<input type="submit" value="提交">
</form>
</body>
</html>