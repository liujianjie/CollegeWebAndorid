<?php
// 单行注释
/*多行注释*/
//设置编码格式
header('content-type:text/html;charset=utf-8');
//输出英文
  echo 'hello world!';
//输出中文
  echo '世界，你好！';
  echo '<hr>';
  echo 'hello world!';
  echo '<br/>';
  echo '<h1>世界，你好！</h1>';
  echo '<hr>';
  $a=1;
  echo $a;
  echo '<hr>';
  $str1='hello ';
  $str2='world';
  echo $str1.$str2;
  echo '<hr>';
  $sex=1;
  if($sex==0) 
     echo '小姐姐';
  else
      echo '粗汉子';
  echo '<hr>';
  for($i=0;$i<=10;$i++)
  {
  echo '哈哈哈'.$i;
  echo '<br/>';
  }
  echo '<hr/>'  
?>