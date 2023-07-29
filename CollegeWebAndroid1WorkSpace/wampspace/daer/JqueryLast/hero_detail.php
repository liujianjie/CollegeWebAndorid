<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>英雄详情</title>
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/bottom.css" />
		<link rel="stylesheet" href="css/hero_detail.css" />
		<script type="text/javascript" src="js/jquery-3.4.1.min.js" ></script>
		<script type="text/javascript" src="js/herodetail.js" ></script>
		
	</head>
	<body>
		<?php include 'phpdata/data_lol_detailofmy.php';
			$name = $_GET['heroname'];
		?>
		<!-- 头部图片 -->
		<div class="headdiv">
			<img src="img/head.png"/>
		</div>
		<div class="herodeatilbottomdiv">
			<div class="widthdiv">
				<!--
                	作者：offline
                	时间：2020-06-15
                	描述：路径div
                -->
				<div class="pathdiv">
					<a>英雄联盟首页</a>
					<span>></span>
					<a>游戏资料</a>
					<span>></span>
					<a href="hero_list.html">全部英雄</a>
					<span>></span>
					<a>
						<?php 
							echo $heroArr[$name]['title'];
							echo ' '; 
							echo $heroArr[$name]['name'];
						?>
					</a>
				</div>
				<div class="heroimgdiv">
					<!-- 名称+属性层 -->
					<div class="heroprodiv">
						<div class="detaildiv">
							<h1 class="heroname">
								<?php 
									echo $heroArr[$name]['title']
								?>
							</h1>
							<h2 class="herotitle">
								<?php 
									echo $heroArr[$name]['name']
								?>
							</h2>
							<div class="herotagdiv">
								<?php 
									for($i = 0; $i < count($heroArr[$name]['tags']); $i++){
										echo 
										'
											<span class="spantag">'.$heroArr[$name]['tags'][$i].'</span>
										';
									}
								?>
							</div>
							<dl class="herodl">
								<dt>物理攻击</dt>
								<dd>
									<?php 
										echo 
										'
											<i class="up up1" style="width:'.$heroArr[$name]['physical'].'%"></i>
										';
									?>
								</dd>
								<dt>魔法攻击</dt>
								<dd>
									<?php 
										echo 
										'
											<i class="up up2" style="width:'.$heroArr[$name]['magic'].'%"></i>
										';
									?>
								<dt>防御能力</dt>
								<dd>
									<?php 
										echo 
										'
											<i class="up up3" style="width:'.$heroArr[$name]['life'].'%"></i>
										';
									?>
								</dd>
								<dt>上手难度</dt>
								<dd>
									<?php 
										echo 
										'
											<i class="up up4" style="width:'.$heroArr[$name]['difficulty'].'%"></i>
										';
									?>
								</dd>
							</dl>
							<div class="buyimg">
								<img src="img/buyimg.png" />
							</div>
						</div>
						<!--背景-->
						<span class="sbg"></span>
					</div>
					<!-- 皮肤层 -->
					<div class="heroskindiv">
						<ul class="heroskinul">
							<?php 
								for($i = 0; $i < count($heroArr[$name]['skin']); $i++){
									echo 
									'
										<li>
											<img src="'.$heroArr[$name]['skin'][$i].'">
										</li>
									';
								}
							?>
						</ul>
					</div>
					<!-- 皮肤头像层 -->
					<div class="heroskinheaddiv">
						<ul class="heroskinheadul">
							<?php 
								for($i = 0; $i < count($heroArr[$name]['skin']); $i++){
									echo '<li ';
									if($i == 0){
										echo 'class="current">';
									}else{
										echo '>';
									}
									echo
									'
										<img src="'.$heroArr[$name]['skinhead'][$i].'">
										<span class="sbor"></span>
									</li>
									';
								}
							?>
						</ul>
					</div>
					<!--
                    	作者：liujianjie
                    	时间：2020-06-15
                    	描述：英雄简介
                    -->
					<div class="heroinfodiv" id="info">
						<div class="heroleft left">
							<p class="ptitle">背景故事</p>
							<div class="herob">
								<p class="heropb">
									<?php 
										echo $heroArr[$name]['story']
									?>
								</p>
								<a>查看更多...</a>
							</div>
						</div>
						<div class="heroright right">
							<p class="ptitle">我的记录</p>
							<div class="heroj">
								<p class="heroinfo">
									您无法查看使用该英雄的记录，请<font class="heroinfoft">[登陆]</font>，并绑定所在大区。
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 尾部图片 -->
		<div class="headdiv">
			<img src="img/tail.png"/>
		</div>
	</body>
</html>
