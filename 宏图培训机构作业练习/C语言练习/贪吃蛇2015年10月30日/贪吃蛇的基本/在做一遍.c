#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
#define N 50
#define N 50//常量
#define UP 18432
#define DOWN 20480
#define LEFT 19200
#define RIGHT 19712
#define ESC 283
struct snake{
	int x[N];
	int y[N];
	int node;
	int life;
	int direction;
}snake;
void weiqiang();
void she();
void main(){
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");
	setbkcolor(15);
	weiqiang();
	she();
	
	
	getch();
	closegraph();
}
void weiqiang(){
	int i;

	setcolor(3);
	setlinestyle(0,0,3);
	for(i=20;i<620;i+=10){
		rectangle(i,60,i+10,70);
		rectangle(i,450,i+10,460);
	}
	for(i=60;i<460;i+=10){
		rectangle(20,i,30,i+10);
		rectangle(610,i,620,i+10);	
	}
}
void she(){
	int i;
	int key;
	snake.x[0]=260;	
	snake.y[0]=200;
	snake.x[1]=250;
	snake.y[1]=200;
	snake.life=1;
	snake.node=2;
	snake.direction=1;
	while(1){
		while(!kbhit()){
			for(i=snake.node-1;i>0;i--){
			snake.x[i]=snake.x[i-1];
			snake.y[i]=snake.y[i-1];
			}
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
			//snake.x[0]=snake.x[0]+10;蛇头
			//必须要有颜色
			setlinestyle(0,0,3);
			setcolor(RED);
			for(i=0;i<snake.node;i++){
				rectangle(snake.x[i],snake.y[0],snake.x[i]+10,snake.y[i]+10);
			}
			delay(10000);
			setcolor(15);
			rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		}
		key=bioskey(0);
			if(key==ESC){
				break;
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