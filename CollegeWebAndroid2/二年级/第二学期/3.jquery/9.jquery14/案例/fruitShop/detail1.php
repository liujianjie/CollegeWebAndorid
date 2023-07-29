<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <title>苹果</title>
  <style type="text/css">
    html,
    body,
    div,
    ul,
    img {
      padding: 0;
      margin: 0;
    }
    
    header {
      background: lightgreen;
      height: 50px;
      text-align: center;
      line-height: 50px;
      font: bold 24px/50px Arial;
    }
    
    nav {
      background: lightblue;
      height: 30px;
      line-height: 30px;
      padding-left: 180px;
    }
    
    section {
      background: lightyellow;
    }
    
    footer {
      background: lightgray;
      height: 50px;
      text-align: center;
      line-height: 50px;
    }
    
    #container {
      width: 1010px;
      height: auto;
      margin: auto;
      background: #E2F9AA;
      padding-bottom: 10px;
    }
    
    #container img {
      margin: auto;
      display: block;
      padding-top: 10px;
    }
    
    #container p {
      margin: 10px;
    }
  </style>
</head>

<body>
  <header>蔬菜水果网上超市</header>
  <nav>
    <a href="index.php">水果</a>
    <a href="index.php">蔬菜</a>
    <a href="index.php">干果</a>
  </nav>
  <section>
     <div id="container">
      <?php
	     include 'data/datafruit2.php';
		 $flag=$_GET['flag'];
		// echo $flag;
         echo ' <img src="'.$arr[$flag]['path'].'">';
         echo ' <p>'.$arr[$flag]['content1'].'</p>';
         echo' <p>'.$arr[$flag]['content2'].'</p>';
		  ?>
        </div>


  </section>
  <footer>※版权所有<a href="http://www.baidu.com">百度</a></footer>
</body>

</html>