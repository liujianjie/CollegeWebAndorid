<?php
//	$a = $_GET['name'];
//	if(!isset($a)){
//		echo '1';
//	}
	// 读取json数据
    $jsonString = file_get_contents('json/lol_equip.json');
	// 转化为 数组
    $jsonArr = json_decode($jsonString,true);
	
//	$fruit = array('西瓜','苹果','香蕉','西红柿');
//	$newarr = $jsonArr['items'];
//	$name = "速度之靴";
//	print_r ($fruit);
//	print_r ($newarr[0]);
//	print_r ($newarr[0]['types'][0]);
//	for($i = 0; $i < count($newarr); $i++){
//		if($name == $newarr[$i]['name']){
//				echo '12';
//			}
//		break;
//	}
	$type = 'Boots';
	$name = '';
	$newarr = array();
	$itemarr = $jsonArr['items'];
	
	// 先循环到type匹配 若name不空则放入name相同
	for($i = 0; $i < count($itemarr); $i++){
		for($j = 0; $j < count($itemarr[$i]['types']); $j++){
			echo $itemarr[$i]['types'][$j];
			if(strpos($itemarr[$i]['types'][$j], $type) !== false){
//						if($name != ''){
//							if(strpos($itemarr[$i]['name'], $name) !== false){
//								array_push($newarr, $itemarr[$i]);
//							}
//						}else{
					array_push($newarr, $itemarr[$i]);
//						}
			}
			
		}
	}
	print_r ($newarr);
?>