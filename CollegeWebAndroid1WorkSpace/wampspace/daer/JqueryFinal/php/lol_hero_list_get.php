<?php
	// 设置返回的是 json
	header('content-type:application/json;charset=utf-8');
    include '../phpdata/data_lol_list.php';
    
	$tag = $_GET['tag'];
    // 类型
	$type = $_GET['type'];
	// 英雄名
	$name = $_GET['name'];
	
	if($tag == 0){
		if($type == 0){
			// 当输入英雄名 要筛选英雄名。
			if($name != ''){
				$newarr = array();
				for($i = 0; $i < count($heroListArr); $i++){
					// 方法匹配是否有这个英雄
					if(strpos($heroListArr[$i]['champion_name'], $name) !== false){
						array_push($newarr, $heroListArr[$i]);
					}
				}
				echo json_encode(
		            array(
		            'status'=>'success',
		            'info'=>'success',
		            'data'=>$newarr
		            )
		        );
			}else{
				// 全部返回
				echo json_encode(
		            array(
		            'status'=>'success',
		            'info'=>'success',
		            'data'=>$heroListArr
		            )
		        );
		    }
		}else{
			// 根据不同$type匹配组成新的数组传输
			$newarr = array();
			for($i = 0; $i < count($heroListArr); $i++){
				if(strpos($heroListArr[$i]['type'], $type) !== false){
					if($name != ''){
						if(strpos($heroListArr[$i]['champion_name'], $name) !== false){
							array_push($newarr, $heroListArr[$i]);
						}
					}else{
						array_push($newarr, $heroListArr[$i]);
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
		}
	}else if(tag == 1){
		// 删除
	}else if(tag == 2){
		// 添加
	}
	
	
?>