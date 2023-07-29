#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
#include "time.h"
#define N 200//����
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
//ʳ��
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
	//ͼ�κ�����ʼ��
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");
	setbkcolor(15);

	draw();
	she();
	//��������
	closegraph();
}
void wenben(){
	//�ı�
	char a[50];
	//�������
	setfillstyle(3,7);
	bar(130,20,490,43);
	//�ı���С
	settextstyle(0,0,3);
	setcolor(12);
	sprintf(a,"LEVEL:%d SCORE:%d",snake.level,snake.score);
	outtextxy(130,20,a);
}
void weiqiang(){
	int i;
	setlinestyle(0,0,3);//���
	//Χǽ��ɫ
	setcolor(8);
	//ѭ�����Χǽ
	for(i=20;i<620;i+=10){
		rectangle(i,50,i+10,60);//����ҵ�Χǽ
		rectangle(i,450,i+10,460);
	}
	for(i=50;i<460;i+=10){
		rectangle(20,i,30,i+10);//�Ϻ��µ�Χǽ
		rectangle(610,i,620,i+10);
	}
}
void draw(){
	int i;
	setlinestyle(0,0,3);//���
	//Χǽ��ɫ
	setcolor(8);
	//ѭ�����Χǽ
	delay(5000);
	for(i=20;i<620;i+=10){
		rectangle(i,50,i+10,60);//����ҵ�Χǽ
		rectangle(i,450,i+10,460);
	}
	for(i=50;i<460;i+=10){
		delay(5000);
		rectangle(20,i,30,i+10);//�Ϻ��µ�Χǽ
		rectangle(610,i,620,i+10);
	}	
	
}
void she(){
	//��ʼ��
	int i;
	int key;
	//��ʼ��
	snake.x[0]=260;	
	snake.y[0]=180;
	snake.x[1]=250;	
	snake.y[1]=180;
	snake.life=1;
	snake.node=2;
	snake.direction=1;
	//ʳ������Ȳ���
	food.yes=0;
	wenben();
	while(snake.life){
		while(!kbhit()){//ʵ��ÿ��������Ҳ������
		shiwu();
		
		for(i=snake.node-1;i>0;i--){
			snake.x[i]=snake.x[i-1];
			snake.y[i]=snake.y[i-1];
		}
			//snake.x[0]=snake.x[0]+10;�ߵ�ͷ��ǰ��
		switch(snake.direction){
			case 1:
				snake.x[0]+=10;//����
				break;
			case 2:
				snake.x[0]-=10;//����
				break;
			case 3:
				snake.y[0]-=10;//����
				break;
			case 4:
				snake.y[0]+=10;//����
				break;
		}
		//ײǽ
		if(snake.x[0]<30||snake.x[0]>600||snake.y[0]<60||snake.y[0]>440){
			snake.life=0;
			//���ߵ�����Ϊ0�Ͳ���ѭ����һ��ֱ������
			//�����ȵ������ڶ���whileѭ��ֱ������,���滹��forѭ���������ж�
		}
		//ҧ�Լ�
		for(i=3;i<snake.node;i++){
				if(snake.x[0]==snake.x[i]&&snake.y[0]==snake.y[i]){
					snake.life=0;
				}
		}
		if(snake.life==0){
			jieshu();
			break;
		}
			//�ߵ�����//����Ҫ����ɫ
			setlinestyle(0,0,3);//���
			setcolor(4);
		for(i=0;i<snake.node;i++){
			rectangle(snake.x[i],snake.y[i],snake.x[i]+10,snake.y[i]+10);	
		}
		//��ʳ��
		if(snake.x[0]==food.x&&snake.y[0]==food.y){
			snake.node++;
			food.yes=0;//���¸�ʳ�����
			snake.score+=10;
			snake.level=snake.score/100+1;
			wenben();
		}
			weiqiang();//ѭ����ǽ�����ǽ
			delay(1000);//�����ӳ�
			setcolor(15);//�����ɫ
			//ȥ��β���Ľ���
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
	food.yes=1;//����ʳ��Ϊ1 �Ļ��Ͳ�������µ�ʳ��
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