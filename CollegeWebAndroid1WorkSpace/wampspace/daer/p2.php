<?php
	header('context-type:text/html;charset=utf-8');
	$fruit = array('西瓜','苹果','香蕉','西红柿');
	echo $fruit[2];
	echo '<hr/>';
	// 输出一组元素
	print_r ($fruit);
	// 遍历输出数据元素
	for($i = 0; $i < count($fruit); $i++){
		echo $fruit[$i];
		echo '<br/>';
	}
	echo count($fruit);
	echo '<br/>';
	// 索引数组
	$person = array("name" => "肖战", 'TV' => '陈情令', 'friend' => '王一博');
	echo $person["name"];
	foreach($person as $key => $value){
		echo $key.'__________'.$value;
		echo "<br/>";
	}
	
	$starArr = array(array("name" => "肖战1", 'TV' => '陈情令1', 'friend' => '王一博'),
	array("name" => "肖战2", 'TV' => '陈情令2', 'friend' => '王一博'),
	array("name" => "肖战3", 'TV' => '陈情令3', 'friend' => '王一博'),
	array("name" => "肖战4", 'TV' => '陈情令4', 'friend' => '王一博'),
	array("name" => "肖战5", 'TV' => '陈情令5', 'friend' => '王一博'));
	echo $starArr[2]['name'];
	echo '<br>';
	for($i = 0; $i < count($starArr); $i++){
		echo '明星'.$starArr[$i]['name'];
		echo '出演'.$starArr[$i]['TV'];
		echo '好朋友'.$starArr[$i]['friend'];
		echo "<br/>";
	}
?>