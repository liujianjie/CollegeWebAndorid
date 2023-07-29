<?php
	// 设置返回的是 json
	header('content-type:application/json;charset=utf-8');
    include '../phpdata/data_lol_skilldetail.php';
    
	// 名
	$name = $_GET['name'];
	
	echo json_encode(
        array(
        'status'=>'success',
        'info'=>'success',
        'data'=>$skillListArr[$name]
        )
    );
?>