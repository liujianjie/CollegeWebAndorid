<?php
//	$fp = fopen("data_lol_list.php", "r+");
	$st = file_get_contents("data_lol_list.php");
//	echo $st;
	$name = "厄运小姐";
	// 截取
//	echo strpos($st, $name);
	// 
//	echo '\n';
//	echo substr($st, strpos($st, $name));
//	echo '\n';
	// 删除厄加特
	// 得到前办法
	$qst = substr($st, 0, strpos($st, $name));
	// 得到后半部分
	$hst = substr($st, strpos($st, $name));
//	echo $qst;
	// 前半部分找最后一个array位置
	$qst = substr($qst, 0, strrpos($qst, 'array'));
	// 后半部分找第一个array位置
	// 最后一个没有array
	if(strpos($hst, 'array')){
		$hst = substr($hst, strpos($hst, 'array'));
	}else{
		$hst = substr($hst, strrpos($hst, ',') + 1);
	}
	// 组成新string 加上前缀
	$qianzhui = '<?php
$heroListArr =';
	$newst = $qst.$hst;
	
	// 输出到文件
	$fp = fopen("data_lol_list.php", "w+");
	fwrite($fp, $newst);
	fclose($fp);
?>