<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<style>
			*{
				margin:0px;
				padding: 0px;
			}
			a{
				text-decoration: none;
			}
			ul{
				list-style: none;
			}
			li{
				float:left;
			}
			body{
				background: #F7F8F8;
			}
			.left{
				float:left;
			}
			.right{
				float:right;
			}
			/*底层最小大小*/
			.bottomdiv{
				min-width: 1238px;
				margin-top: 30px;
				margin-bottom: 30px;
			}
			.widthdiv{
				width:1238px;
				margin:0 auto;
				overflow: hidden;
			}
			.herodiv{
				width: 100%;
				border-right: 1px solid #e8e8e8;
				border-left: 1px solid #e8e8e8;
				border-top: 1px solid #D7D7D7;
				box-sizing:content-box;
				background: #FFFFFF;
			}
			.herotitleul{
				width: 100%;
				background: #F0F0F0;
				overflow: hidden;
			}
			.herotitleul li{
				width: 160px;
				height: 53px;
				text-align: center;
			}
			.herotitleul li a{
				display: inline-block;
				line-height: 53px;
				color: #00a383;
			}
			.herotitleul .active{
				background: #ffffff;
				border-top: 3px solid #00a383;
			}
			.herotxdiv{
				width: 100%;
				padding: 30px 37px 0px 30px;;
				box-sizing: border-box;
			}
			.herotxul{
				width: 100%;
				overflow: hidden;
			}
			.herotxul li{
				width: 90px;
				height: 100px;
				text-align: center;
				margin-bottom: 22px;
				cursor: pointer;
			}
			.herotxul li a img{
				width: 66px;
				height: 65px;
				
			}
			.herotxul li .as{
				display: block;
				text-align: center;
				font-size: 12px;
				height: 15px;
				color:black;
			}
			/*英雄介绍*/
			.heroinfodiv{
				margin-top: 30px;
			}
			.ptitle{
				font-size: 24px;
    			color: #338c7a;
    			font-weight: bold;
    			margin-bottom: 10px;
			}
			.heroleft{
				width: 434px;
			}
			.heroright{
				width:780px;
			}
			
			.heroj, .herob{
				background: #FFFFFF;
				height: 150px;
				padding: 30px 30px 30px 30px;
				overflow: hidden;
				box-sizing: border-box;
			}
			
			.spantag{
				background: #00A483;
				font-size: 12px;
				color: white;
				display: inline-block;
				height: 21px;
				line-height: 21px;
				text-align: center;
				border-radius: 5px;
				padding: 0 4px 0 4px;
			}
			.heroj p{
				font-weight: bold;
				font-size: 25px;
				height: 35px;
				line-height: 35px;
			}
			.herob p{
				height: 100%;
				word-break:break-all;
				font-size: 14px;
				line-height: 24px;
				overflow: hidden;
				
			}
		</style>
		<script type="text/javascript" src="js/jquery.js" ></script>
	</head>
	<body>
		<div class="bottomdiv">
			<div class="widthdiv">
				<div class="herodiv">
					<ul class="herotitleul">
						<li class="active"><a>英雄</a></li>
						<li><a>物品</a></li>
						<li><a>召唤师技能</a></li>
						<li><a>符文</a></li>
						<li><a>云顶之弈</a></li>
					</ul>
					<div class="herotxdiv">
						<ul class="herotxul">
							<!--<li>
								<img src="images/1371093644361.png">
								<a>暗裔剑魔</a>
							</li>-->
							<?php
								include 'heroArr.php';
								$dan = "'";
								for($i = 0; $i < count($heroArr); $i++)
								{
									echo '<li class="clickli" onclick="chagnetitle('.$dan.''.$heroArr[$i]['champion_title'].''.$dan.', '.$dan.''.$heroArr[$i]['champion_name'].''.$dan.', '.$dan.''.$heroArr[$i]['champion_info'].''.$dan.', '.$dan.''.$heroArr[$i]['champion_tags'].''.$dan.')">
													<a href="#info"><img src="'.$heroArr[$i]['champion_icon'].'"></a>
													<a href="#info" class="as">'.$heroArr[$i]['champion_title'].'</a>
												</li>';	 
								} 	  
							?>      
						</ul>
					</div>
				</div>
				<div class="heroinfodiv" id="info">
					<div class="heroleft left">
						<p class="ptitle">英雄简介</p>
						<div class="heroj">
							<p class="heronickp"></p>
							<p class="heronamep"></p>
							<p class="herotag"></p>
						</div>
					</div>
					<div class="heroright right">
						<p class="ptitle">背景故事</p>
						<div class="herob">
							<p class="heropb">
								
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
			// 需要做的是 点击头像，获取英雄的信息，更新英雄背景故事和简介
			function chagnetitle(nick,name,bg,tag){
				$('.heronickp').html(nick);
				$('.heronamep').html(name);
				
				$('.heropb').html(bg);
				$('.herotag').html("<span class='spantag'>"+tag+"</span>");
				// 不好分割 太多不同的tag
//				var tag = tag.substring(tag.indexOf(":")+1, tag.length);
//				var tags = tag.split(", ");
//				var tagstr;
//				for(var i = 0; i < tags.length; i++){
//					tagstr += "<span class='spantag'>";
//					tagstr += tags[i];
//					tagstr += "</span>";
//				}
			}
			
		</script>
	</body>
</html>
