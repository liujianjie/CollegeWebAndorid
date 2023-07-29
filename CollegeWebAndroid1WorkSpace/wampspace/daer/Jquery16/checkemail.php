<?php
	$requestemail = $_POST['email'];
	$emailArr = array('1219277604@qq.com', '123456@163.com', '110@qq.com');
	if(in_array($requestemail, $emailArr)){
		echo '该邮箱地址已被注册';
	}else{
		echo '这个邮箱可以注册';
	}
?>
