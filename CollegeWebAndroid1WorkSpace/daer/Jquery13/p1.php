<?php
	header('context-type:text/html;charset=utf-8');
	echo 'hello world';
	echo '世界你好';
	$a = 1;
	echo $a;
	$str1 = 'hello';
	$str2 = 'world';
	$str3 = $str1.$str2;
	echo $str3;
	$as = "12321";
	echo $as;
	echo '<hr/>';
	// 选择
	$sex = 0;
	if($sex == 1){
		echo '小';
	}else{
		echo '大';
	}
	echo '<hr/>';
	// 循环
	for($i = 0; $i < 10; $i++){
		echo '哈哈';
		echo '<br/>';
	}
?>
