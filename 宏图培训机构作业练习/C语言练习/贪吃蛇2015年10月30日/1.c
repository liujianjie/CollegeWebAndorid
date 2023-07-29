#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
#include "time.h"
#define N 200//常量
#define UP 18432
#define DOWN 20480
#define LEFT 19200
#define RIGHT 19712
#define ESC 283
#define	W 4471
#define	S 8051
#define	A 7777
#define D 8292
#define KONGGE 14624
struct snake{
	int x[N];
	int y[N];
	int life;
	int node;
	int direction;
	int score;
	int level;
}snake;
//食物
struct food{
	int x;
	int y;
	int yes;
}food;
void wenben();
void weiqiang();
void she();
void shiwu();
void jieshu();
void draw();
void main(){
	//图形函数初始化
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");
	setbkcolor(15);

	draw();
	she();
	//结束函数
	closegraph();
}
void wenben(){
	//文本
	char a[50];
	//封闭区域
	setfillstyle(3,7);
	bar(130,20,490,43);
	//文本大小
	settextstyle(0,0,3);
	setcolor(12);
	sprintf(a,"LEVEL:%d SCORE:%d",snake.level,snake.score);
	outtextxy(130,20,a);
}
void weiqiang(){
	int i;
	setlinestyle(0,0,3);//宽度
	//围墙颜色
	setcolor(8);
	//循环输出围墙
	for(i=20;i<620;i+=10){
		rectangle(i,50,i+10,60);//左和右的围墙
		rectangle(i,450,i+10,460);
	}
	for(i=50;i<460;i+=10){
		rectangle(20,i,30,i+10);//上和下的围墙
		rectangle(610,i,620,i+10);
	}
}
void draw(){
	int i;
	setlinestyle(0,0,3);//宽度
	//围墙颜色
	setcolor(8);
	//循环输出围墙
	delay(5000);
	for(i=20;i<620;i+=10){
		rectangle(i,50,i+10,60);//左和右的围墙
		rectangle(i,450,i+10,460);
	}
	for(i=50;i<460;i+=10){
		delay(5000);
		rectangle(20,i,30,i+10);//上和下的围墙
		rectangle(610,i,620,i+10);
	}	
	
}
void she(){
	//初始化
	int i;
	int key;
	//初始化
	snake.x[0]=260;	
	snake.y[0]=180;
	snake.x[1]=250;	
	snake.y[1]=180;
	snake.life=1;
	snake.node=2;
	snake.direction=1;
	//食物必须先产生
	food.yes=0;
	wenben();
	while(snake.life){
		while(!kbhit()){//实现每按键输入也会运行
		shiwu();
		
		for(i=snake.node-1;i>0;i--){
			snake.x[i]=snake.x[i-1];
			snake.y[i]=snake.y[i-1];
		}
			//snake.x[0]=snake.x[0]+10;蛇的头向前进
		switch(snake.direction){
			case 1:
				snake.x[0]+=10;//向右
				break;
			case 2:
				snake.x[0]-=10;//向左
				break;
			case 3:
				snake.y[0]-=10;//向上
				break;
			case 4:
				snake.y[0]+=10;//向下
				break;
		}
		//撞墙
		if(snake.x[0]<30||snake.x[0]>600||snake.y[0]<60||snake.y[0]>440){
			snake.life=0;
			//把蛇的生命为0就不会循环第一层直接跳出
			//不过先得跳出第二层while循环直接跳出,下面还有for循环就重新判断
		}
		//咬自己
		for(i=3;i<snake.node;i++){
				if(snake.x[0]==snake.x[i]&&snake.y[0]==snake.y[i]){
					snake.life=0;
				}
		}
		if(snake.life==0){
			jieshu();
			break;
		}
			//蛇的两节//必须要有颜色
			setlinestyle(0,0,3);//宽度
			setcolor(4);
		for(i=0;i<snake.node;i++){
			rectangle(snake.x[i],snake.y[i],snake.x[i]+10,snake.y[i]+10);	
		}
		//吃食物
		if(snake.x[0]==food.x&&snake.y[0]==food.y){
			snake.node++;
			food.yes=0;//以下个食物出现
			snake.score+=10;
			snake.level=snake.score/100+1;
			wenben();
		}
			weiqiang();//循环画墙避免吃墙
			delay(1000);//步伐延迟
			setcolor(15);//填充颜色
			//去掉尾部的节数
			rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		
	}
	key=bioskey(0);
	if(key==ESC){
		break;
	}
	else if(key==KONGGE){
		getch();
	}
	else if(key==RIGHT&&snake.direction!=2){
		snake.direction=1;
	}else if(key==LEFT&&snake.direction!=1){
		snake.direction=2;
	}else if(key==UP&&snake.direction!=4){
		snake.direction=3;
	}else if(key==DOWN&&snake.direction!=3){
		snake.direction=4;
	}
	}
}
void shiwu(){
	if(food.yes==0){
	randomize();	
	food.x=random(570)+30;
	while(food.x%10!=0){
		food.x++;
	}
	food.y=random(380)+60;
	while(food.y%10!=0){
		food.y++;	
	}
	food.yes=1;//这样食物为1 的话就不会产生新的食物
	}
	setcolor(GREEN);
	rectangle(food.x,food.y,food.x+10,food.y+10);
}
void jieshu(){
	char a[50]="GAME OVER!!";
	char b[50];
	system("cls");
	setbkcolor(0);
	setcolor(4);
	settextstyle(0,0,3);
	outtextxy(150,150,a);
	settextstyle(0,0,3);
	sprintf(b,"LEVEL:%d SCORE:%d",snake.level,snake.score);
	outtextxy(150,270,b);
}