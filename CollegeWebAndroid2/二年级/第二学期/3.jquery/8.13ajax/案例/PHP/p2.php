<?php
//设置编码格式
header('content-type:text/html;charset=utf-8');
//定义数组
// var num=[1,2,,3];
$fruit=array('西瓜','苹果','香蕉','西红柿');
//输出数组元素 
echo $fruit[3];
echo '<hr>';
//输出所有数组元素
//echo $fruit; 
print_r ($fruit);
echo '<hr>';
//遍历输出所有数组元素
//for($i=0;$i<$fruit.length;$i++)  错误
for($i=0;$i<count($fruit);$i++)
{   echo $fruit[$i];	
    echo '<br/>';	
	}
echo '<hr/>';
//索引数组
$person=array('name'=>'肖战','TV'=>'陈情令','friend'=>'王一博');
//输出数组元素
echo $person['name'];
echo '<hr>';
//完整输出所有数组元素
print_r($person);
echo '<hr>';
//遍历输出所有数组元素   $key 循环的键 $value循环的值
foreach($person as $key => $value)
{
	echo $key .'----'.$value.'<br>';
	}
echo '<hr>';
//二维数据
$starArr=array(
	array('name'=>'肖战','TV'=>'陈情令','padang'=>'王一博'),
	array('name'=>'郑业成','TV'=>'三千鸦杀','padang'=>'赵露思'),
	array('name'=>'李现','TV'=>'亲爱的，热爱的','padang'=>'杨紫')
);
//输出数组元素
echo $starArr[2]['name'];
echo '<hr>';
//遍历输出所有数组元素
for($i=0;$i<count($starArr);$i++)
{
   echo '明星'.$starArr[$i]['name'].'与'.$starArr[$i]['padang'].'出演'.$starArr[$i]['TV'].'电视剧'.'<br>';
	}


?>