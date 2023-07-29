<?php
$fp = fopen("data_lol_list.php", "r+");
$flag = fseek($fp, -5, SEEK_END);
if (!$flag) {
	echo "Offset success\r\n";
} else {
	echo "Offset failed\n";
}
$flag = fwrite($fp, 
'array("champion_icon"=> "images/1405934761751.png",
"champion_name"=>"厄运小姐",
"type"=>"5"
),
)
?>');

if ($flag) {
	echo "Have written";
} else {
	echo "Write Failed";
}
?>