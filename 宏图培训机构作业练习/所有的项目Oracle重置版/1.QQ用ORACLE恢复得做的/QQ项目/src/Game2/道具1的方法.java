package Game2;

import java.util.Random;

public class 道具1的方法 extends 中心面板{
	public 道具1的方法(){
	/*	if(jiadaoju11){
			if(map[zhasi3][zhasj3]==caodi){
				map[zhasi3][zhasj3]=4;
				
			}else if(map[zhasi3][zhasj3]==xiangzi){
				map[zhasi3][zhasj3]=4;
				daoju111=true;//可以变为道具 箱子。。。
			}
		}
		
		if(jiadaoju11){
			if(map[zhaxi3][zhaxj3]==caodi){
				map[zhaxi3][zhaxj3]=4;
			}else if(map[zhaxi3][zhaxj3]==xiangzi){
				map[zhaxi3][zhaxj3]=4;
				daoju222=true;//可以变为道具 箱子。。。
			}
		}
		
		if(jiadaoju11){
			if(map[zhazi3][zhazj3]==caodi){
				map[zhazi3][zhazj3]=4;
			}else if(map[zhazi3][zhazj3]==xiangzi){
				map[zhazi3][zhazj3]=4;
				daoju333=true;//可以变为道具 箱子。。。
			}
		}
		
		if(jiadaoju11){
			if(map[zhayi3][zhayj3]==caodi){
				map[zhayi3][zhayj3]=4;
			}else if(map[zhayi3][zhayj3]==xiangzi){
				map[zhayi3][zhayj3]=4;
				daoju444=true;//可以变为道具 箱子。。。
			}
		}*/
		
		if(daoju111){
			int a=daoju();//随机数
			map[zhasi3][zhasj3]=a;//箱子的位置为道具了 
		}else{
			map[zhasi3][zhasj3]=yuanshi111;//火焰的位置为原来的物体 草
			
		}

		if(daoju222){
			int a=daoju();
			map[zhaxi3][zhaxj3]=a;//箱子的位置为道具了 
		}else{
			map[zhaxi3][zhaxj3]=yuanshi222;//火焰的位置为原来的物体如果是草就变为 草 
			
		}

		if(daoju333){
			int a=daoju();
			map[zhazi3][zhazj3]=a;//箱子的位置为道具了 
		}else{
			map[zhazi3][zhazj3]=yuanshi333;//火焰的位置为原来的物体如果是草就变为 草 
			
		}

		if(daoju444){
			int a=daoju();
			map[zhayi3][zhayj3]=a;//箱子的位置为道具了 
		}else{
			map[zhayi3][zhayj3]=yuanshi444;//火焰的位置为原来的物体如果是草就变为 草 
			
		}
	}
		//道具方法
		public int daoju(){
			int a=new Random().nextInt(5);
			if(a==1){
				a=caodi;//草地
		}
		else if(a==0){
			a=daojutu2;//道具2
		}else if(a==3){
			a=caodi;//草地
		}
		else if(a==2){
			a=daojutu1;//道具1
		}else if(a==4){
			a=caodi;//草地
			}
			
			return a;
		}
}
