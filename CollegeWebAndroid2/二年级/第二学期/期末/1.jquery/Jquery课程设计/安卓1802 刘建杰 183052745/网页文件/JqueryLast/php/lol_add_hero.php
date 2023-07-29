<?php
//	$text = ";1231";
// 	$e=mb_detect_encoding($text, array('UTF-8', 'GBK','gb2312'));
// 	echo $e;
	$name = $_POST['heroname'];
	$upfile = $_FILES['heroimg'];
	
	$imgdir = 'upimg/'.iconv("UTF-8","GBK",$upfile['name']);
	// 保存至临时文件
	move_uploaded_file($upfile['tmp_name'], '../'.$imgdir);
	
	// 字符串需要保存到list php文件中
	$fp = fopen("../phpdata/data_lol_list.php", "r+");
	$flag = fseek($fp, -5, SEEK_END);
$flag = fwrite($fp, 
'array("champion_icon"=> "'.$imgdir.'",
"champion_name"=>"'.$name.'",
"type"=>"0"
),
)
?>');

	fclose($fp);
	if ($flag) {
		header("Location: ../hero_list.html");
	} else {
		echo "添加失败";
	}
?>
