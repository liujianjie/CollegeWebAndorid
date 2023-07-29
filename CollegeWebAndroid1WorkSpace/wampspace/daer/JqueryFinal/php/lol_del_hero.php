<?php	
	// 设置返回的是 json
	header('content-type:application/json;charset=utf-8');
	$filedir = "../phpdata/data_lol_list.php";
	//1.获取到传入的name
	$name = $_GET['name'];
	//2.获取文件字符串
	$st = file_get_contents($filedir);
	//3.进行截取
	// 得到前半部分
	$qst = substr($st, 0, strpos($st, $name));
	// 得到后半部分
	$hst = substr($st, strpos($st, $name));
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
	//4.输入到回文件中
	$fp = fopen($filedir, "w+");
	fwrite($fp, $newst);
	//5.关闭
	fclose($fp);
	sleep(1);
	//6.结束 返回
	echo json_encode(
        array(
        'status'=>'success',
        'info'=>'success'
        )
    );
?>
