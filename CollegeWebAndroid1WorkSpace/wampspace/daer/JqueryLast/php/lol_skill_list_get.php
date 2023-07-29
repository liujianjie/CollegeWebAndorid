<?php
	// 设置返回的是 json
	header('content-type:application/json;charset=utf-8');
    include '../phpdata/data_lol_skilllist.php';

	echo json_encode(
        array(
        'status'=>'success',
        'info'=>'success',
        'data'=>$skillListArr
        )
    );
	
?>