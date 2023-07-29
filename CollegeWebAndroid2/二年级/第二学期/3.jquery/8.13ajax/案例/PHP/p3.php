<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>娱乐新闻</title>
<style type="text/css">
h1 { color:red;}
span { font-size:24px; color:#999900;}
</style>
</head>

<body>
<h1>头条娱乐新闻</h1>
<?php
header('content-type:text/html;charset=utf-8');
//二维数据
$starArr=array(
	array('name'=>'肖战','TV'=>'陈情令','padang'=>'王一博'),
	array('name'=>'郑业成','TV'=>'三千鸦杀','padang'=>'赵露思'),
	array('name'=>'李现','TV'=>'亲爱的，热爱的','padang'=>'杨紫')
);
//遍历输出所有数组元素
for($i=0;$i<count($starArr);$i++)
{
   echo '<p>明星<span>'.$starArr[$i]['name'].'</span>与'.$starArr[$i]['padang'].'出演'.$starArr[$i]['TV'].'电视剧</p>';
	}
//写在PHP标签外面的代码不会执行，原封不动的返回给服务器，因此PHP代码编写原则，定下来的写在PHP代码外面，定不下来的写在PHP代码里面
?>
</body>
</html>