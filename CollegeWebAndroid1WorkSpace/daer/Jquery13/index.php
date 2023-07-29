<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>动态网站</title>
 <link rel="stylesheet" type="text/css" href="css/css1.css"/>
</head>
<body>
  <header>蔬菜水果网上超市</header>
  <nav>
    <a href="./index.php">水果</a>
    <a href="./index.php">蔬菜</a>
    <a href="./index.php">干果</a>
  </nav>
  <section>
  	  <ul>           
      <!--<li>
            <a href="detail/detail1.php?flag=banana">
              <img src="img/banana1.jpg">
              <div>香蕉</div>
            </a>
                  </li>
      $arr[0] = array('href' => 'detail/detail1.php?flag=banana','path' => 'img/banana1.jpg','name' => '香蕉');
      -->
      <?php
	  //1.引入数据
	  include 'datafruit.php';
	 //2.解析数据
	 for($i=0;$i<count($arr);$i++)
	 {
	 //3.生成动态代码	
		 echo '<li>
            <a href="'.$arr[$i]['name'].'">
              <img src="'.$arr[$i]['path'].'">
              <div>'.$arr[$i]['name'].'</div>
            </a>
      </li>';		 
		 } 	  
	  ?>      
        </ul>
        <div style="clear: both;"></div>
      </div>
  </section>
  <footer>版权所有</footer>
</body>

</html>