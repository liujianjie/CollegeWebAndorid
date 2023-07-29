<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			.ptitle{
				font-size: 24px;
    			color: #338c7a;
    			font-weight: bold;
    			margin-bottom: 10px;
			}
			.hero1{
				height: 100%;
				word-break:break-all;
				font-size: 14px;
				line-height: 24px;
				overflow: hidden;
				
			}
			.hero2{
				font-size: 19px;
				font-weight: bold;
			}
		</style>
	</head>
	<body>
		<div>
			<p class="ptitle">英雄简介</p>
			<?php
				include 'data_lol_detail.php';
				$name = $_GET['heroname'];
				echo 
				'
				<p class="hero2">
					'.$heroArr[$name]['champion_title'].'--'.$heroArr[$name]['champion_name'].'
				</p>
				<img src="'.$heroArr[$name]['champion_icon'].'">
				<p class="hero1">
					'.$heroArr[$name]['champion_info'].'
				</p>
				<p class="hero2">
					'.$heroArr[$name]['champion_tags'].'
				</p>
				<p>
					<a href="hero_dis.php">再考虑一下</a>
				</p>
				'
			?>      
		</div>
		
	</body>
</html>
