<?php
header('content-type:text/html;charset=utf-8');
// echo '提交成功';
//echo $_GET;
//print_r($_GET);
//print_r($_POST);
//echo $_GET['fruit'];
//echo '<br/>';
//echo $_GET['foot'];
//echo '<p>原来你喜欢吃的水果是：'.$_GET['fruit'].'</p><p>原来你喜欢吃的食物是：'.$_GET['foot'].'</p>'
print_r($_FILES);
//Array ( [fruitimage] => Array ( 
//				[name] => pitaya.jpg 
//				[type] => image/jpeg 
//				[tmp_name] => C:\wamp64\tmp\php7675.tmp 
//				[error] => 0 [size] => 25318 
//				) )
//sleep(10);
//移出临时文件
move_uploaded_file($_FILES['fruitimage']['tmp_name'],'files/'.$_FILES['fruitimage']['name']) ;

 

?>