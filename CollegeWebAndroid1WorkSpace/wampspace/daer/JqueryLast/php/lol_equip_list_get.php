<?php
	// 设置返回的是 json
	header('content-type:application/json;charset=utf-8');
   	// 读取json数据
    $jsonString = file_get_contents('../json/lol_equip.json');
	// 转化为 数组
    $jsonArr = json_decode($jsonString,true);
	
	// 获取装备的信息
	if(array_key_exists('tag',$_GET)){
		$tag = $_GET['tag'];
		// 获取所有
		if($tag == 0){
			// 所有
			echo json_encode(
		        array(
		        'status'=>'success',
		        'info'=>'success',
		        'data'=>array($jsonArr['items'])
		        )
		    );
		}else if($tag == 1){
			// 获取单个
			$name = $_GET['name'];
			$itemarr = $jsonArr['items'];
			for($i = 0; $i < count($itemarr); $i++){
				if($name == $itemarr[$i]['name']){
					echo json_encode(
				        array(
				        'status'=>'success',
				        'info'=>'success',
				        'data'=>array($itemarr[$i])
				        )
				    );
					break;
				}
			}
		}else if($tag == 2){
			// 获取type和name
			$type = $_GET['type'];
			$name = $_GET['name'];
			$newarr = array();
			$itemarr = $jsonArr['items'];
			
			// 先循环到type匹配 若name不空则放入name相同
			for($i = 0; $i < count($itemarr); $i++){
				for($j = 0; $j < count($itemarr[$i]['types']); $j++){
					if(strpos($itemarr[$i]['types'][$j], $type) !== false){
						if($name != ''){
							if(strpos($itemarr[$i]['name'], $name) !== false){
								array_push($newarr, $itemarr[$i]);
								break;
							}
						}else{
							array_push($newarr, $itemarr[$i]);
							break;
						}
					}
				}
			}
			echo json_encode(
		        array(
		        'status'=>'success',
		        'info'=>'success',
		        'data'=>$newarr
		        )
		    );
//			echo json_encode(
//		        array(
//		        'status'=>'success',
//		        'info'=>'success',
//		        'data'=>array($itemarr[2],$itemarr[3])
//		        )
//		    );
		}
	}
    
?>