<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style>
			p{
				font-size: 16px;
				color:#00a383;
				font-weight: bold;
			}
			font{
				font-size: 15px;
				color: black;
				font-weight: 0;
			}
		</style>
	</head>
	<body>
		<?php
			$upfile = $_FILES['files'];
			// 保存至临时文件
			move_uploaded_file($upfile['tmp_name'], 'uploadfile/'.$upfile['name']);
		?>
		12131 <?php echo $upfile['tmp_name']?>
		<p>你上传图片的名称：<font><?php echo $upfile['name'];?></font></p>
		<p>你上传图片的大小：<font><?php echo $upfile['size'];?>kb</font></p>
		<p>你上传图片的类型: <font><?php echo $upfile['type'];?></font></p>
		<p>你上传的图片</p>
		<img src="uploadfile/<?php echo $upfile['name'];?>" />
	</body>
</html>
