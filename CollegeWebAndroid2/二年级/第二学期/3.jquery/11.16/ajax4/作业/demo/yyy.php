<?php
header('content-type:application/json;charset=utf-8');
//读取JSON文件
$jsonString=file_get_contents('data.json');
echo $jsonString;

?>