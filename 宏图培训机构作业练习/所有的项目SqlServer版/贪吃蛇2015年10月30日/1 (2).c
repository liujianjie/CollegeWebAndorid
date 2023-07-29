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
}food,food1;
void she();//蛇
void shiwu();//食物
void shiwu2();//特殊食物
void wenben();//分数
void draw(int type);//围墙
void jieshu();//游戏失败
void tongguan();//游戏通关
void main(){
	//图形函数初始化
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");
	setbkcolor(15);

	draw(0);
	she();
	//结束函数
	closegraph();
}
void she(){
	//初始化
	int i;
	int key;//输入键盘所需要的代码
	int count=0;//吃食物的计数
	int state=0;//控制墙画一遍
	int state2=0;
	int speed=25000;//速度控制量 
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
	food1.yes=0;
	wenben();
	while(snake.life){
	   while(!kbhit()){//实现每按键输入也会运行
		shiwu();
		//放在这里可以防止吃边无限刷特殊食物
		if(count==2){
			//生成特殊食物
			shiwu2();
			//特殊食物也要
		if(food1.x>139 &&food1.x<269 &&food1.y>56 &&food1.y<229 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>379 &&food1.x<509 &&food1.y>56 &&food1.y<229 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>29 &&food1.x<129 &&food1.y>259 &&food1.y<452 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>259 &&food1.x<389 &&food1.y>259 &&food1.y<452 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>509 &&food1.x<609 &&food1.y>259 &&food1.y<452 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		}
		//第三关要用的 如果食物出现在区域内 得重新出现食物 把蛇的范围复制过来就行
		if(food.x>139 &&food.x<269 &&food.y>56 &&food.y<229 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>379 &&food.x<509 &&food.y>56 &&food.y<229 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>29 &&food.x<129 &&food.y>259 &&food.y<452 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>259 &&food.x<389 &&food.y>259 &&food.y<452 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>509 &&food.x<609 &&food.y>259 &&food.y<452 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		//主要内容
		setlinestyle(0,0,3);//蛇和食物宽度和线性样式
		for(i=snake.node-1;i>0;i--){
			snake.x[i]=snake.x[i-1];
			snake.y[i]=snake.y[i-1];//蛇的坐标赋给下一节
		}
		//穿越边界 让蛇头的坐标变换就行
 		
		if(snake.x[0]<10){//左右
			snake.x[0]=630;
		}
		if(snake.x[0]>630){
			snake.x[0]=10;
		}
		if(snake.y[0]<47){//上下
			snake.y[0]=470;
		}
		if(snake.y[0]>470){
			snake.y[0]=47;
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
		//撞墙的移到下面等级关卡中
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

			//循环画墙避免吃墙但是延迟会受影响只能试试把围墙变小点但蛇碰墙的范围不变
			delay(speed);//步伐延迟
			setlinestyle(0,0,3);//擦掉末尾宽度和线性样式
			setcolor(15);//填充颜色
			//去掉尾部的节数
			rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		//吃食物
		if(snake.x[0]==food.x&&snake.y[0]==food.y){
			snake.node++;
			food.yes=0;//以下个食物出现
			snake.score+=10;
			wenben();
			count++;//累加
			if(count>2){//让它吃到第三个以上 count都是等于2
				count=2;
			}
		}
		//吃特殊食物 因为吃特殊食物蛇节-1 要把脱下来的节去掉 而不能影响蛇动的去掉最后一节 所以只能移下来
		if(snake.x[0]==food1.x&&snake.y[0]==food1.y){
			snake.node--;
			food1.yes=0;//以下个食物出现
			snake.score+=20;
			snake.level=snake.score/100+1;
			wenben();//分数打印
			count=0;//初始值
			speed-=8000;//减速度
			setcolor(15);
			rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		}
		
		//关卡
		if(snake.level==1){//等级1
			//撞墙
			if(snake.x[0]<30||snake.x[0]>600||snake.y[0]<60||snake.y[0]>440){
			snake.life=0;
			//把蛇的生命为0就不会循环第一层直接跳出
			//不过先得跳出第二层while循环直接跳出,上面有判断就不用了
			}
		}
		else if(snake.level==2){//等级2
			//画一遍白墙
			 if(state==0){
				draw(1);
				state=1;
			 }
			 speed=25000;
		}
		else if(snake.level==3){//等级3
			if(state2==0){
				draw(0);
				state2=1;
			}
			//撞墙死 因为画的是一遍墙 所以要判断
			if(snake.x[0]<30||snake.x[0]>600||snake.y[0]<60||snake.y[0]>440){
			snake.life=0;
			}
			//画墙 不用了 因为在main函数中已经有了 在等级2中没有主要是画了白墙
			//障碍物
			setfillstyle(1,7);
			bar(140,57,270,230);//第一个障碍
			bar(380,57,510,230);//第二个障碍
			bar(30,260,130,453);//第三个障碍
			bar(260,260,390,453);//第四个障碍
			bar(510,260,610,453);//第五个障碍
			//撞障碍物 死 范围都得自己慢慢试 加一或减一
			/*例子：很重要 都-1 if(snake.x[0]>191 &&snake.x[0]<349 &&snake.y[0]>191 &&snake.y[0]<249 ){bar(200,200,350,250);
				snake.life=0;
				
			}*/
			if(snake.x[0]>139 &&snake.x[0]<269 &&snake.y[0]>56 &&snake.y[0]<229 ){
			snake.life=0;
			}
			if(snake.x[0]>379 &&snake.x[0]<509 &&snake.y[0]>56 &&snake.y[0]<229 ){
			snake.life=0;
			}
			if(snake.x[0]>29 &&snake.x[0]<129 &&snake.y[0]>259 &&snake.y[0]<452 ){
			snake.life=0;
			}
			if(snake.x[0]>259 &&snake.x[0]<389 &&snake.y[0]>259 &&snake.y[0]<452 ){
			snake.life=0;
			}
			if(snake.x[0]>509 &&snake.x[0]<609 &&snake.y[0]>259 &&snake.y[0]<452 ){
			snake.life=0;
			}
		}
		else{//通关
			tongguan();
			snake.life=0;
			break;
			
		}
	}
	key=bioskey(0);
	if(key==ESC){
		break;
	}
	else if(key==KONGGE){
		//再画一条蛇覆盖原来的蛇
		setcolor(RED);
		for(i=0;i<snake.node;i++){
		rectangle(snake.x[i],snake.y[i],snake.x[i]+10,snake.y[i]+10);	
		}
		getch();//暂停放中间 意思是 暂停 就画完一条蛇 开始就开始擦尾
		//去掉尾部的节数
		setcolor(15);
		rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
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
		food.y++;	//防止出现不是为10的倍数的坐标
	}
	food.yes=1;//这样食物为1 的话就不会产生新的食物
	}
	setcolor(GREEN);
	rectangle(food.x,food.y,food.x+10,food.y+10);//解决蛇会磨食物的边
}
void shiwu2(){
	int i;
	if(food1.yes==0){
	randomize();	
	food1.x=random(520)+50;
	while(food1.x%10!=0){
		food1.x++;
	}
	food1.y=random(350)+80;
	while(food1.y%10!=0){
		food1.y++;	//防止出现不是为10的倍数的坐标
	}
	food1.yes=1;//这样食物为1 的话就不会产生新的食物
	}
	setcolor(random(14)+1);
	rectangle(food1.x,food1.y,food1.x+10,food1.y+10);//解决蛇会磨食物的边
}

void wenben(){
	//文本
	char a[50];
	//封闭区域
	setfillstyle(3,7);
	bar(110,20,510,43);
	//文本大小
	settextstyle(0,0,3);
	setcolor(12);
	snake.level=snake.score/20+2;//把计算分数的放这里可以防止一开始等级为0
	sprintf(a,"LEVEL:%d SCORE:%d",snake.level,snake.score);
	outtextxy(130,20,a);
}
void draw(int type){
	int i,j=1;
	setlinestyle(1,0,3);//宽度和线性样式
	//循环输出围墙
	for(i=20;i<620;i+=10){
		//围墙颜色(彩色)
		if(j>13){
		j=1;
		}
		setcolor(j);
		j++;
		if(type==0){
			delay(2500);	
		}
		rectangle(i,47,i+10,57);//上和下的围墙 为了避免吃墙 只能变范围
		rectangle(i,453,i+10,463);
		//等级为2的关卡 把原来的墙覆盖
		if(type==1){
			setcolor(15);
			rectangle(i,47,i+10,57);//上下
			rectangle(i,453,i+10,463);
		}
		
	}
	for(i=50;i<460;i+=10){
		//围墙颜色(彩色)
		if(j>13){
		j=1;
		}
		setcolor(j);
		j++;
		if(type==0){
			delay(2000);	
		}
		rectangle(17,i,27,i+10);//左和右的围墙
		rectangle(613,i,623,i+10);
		//等级为2的关卡 把原来的墙覆盖
		if(type==1){
			setcolor(15);
			rectangle(17,i,27,i+10);//左和右的围墙
			rectangle(613,i,623,i+10);
		}
	}
}

void jieshu(){
	//定义
	char a[50]="GAME OVER!!";
	char b[50];
	//清屏
	system("cls");
	//背景颜色 和图形颜色
	setbkcolor(1);
	setcolor(YELLOW);
	//图形大小
	settextstyle(0,0,3);
	//内容
	outtextxy(150,150,a);
	settextstyle(0,0,3);
	sprintf(b,"LEVEL:%d SCORE:%d",snake.level,snake.score);
	outtextxy(150,270,b);
}

void tongguan(){
	//清屏
	system("cls");
	//背景颜色	
	setbkcolor(15);
	//图形颜色
	setcolor(4);
	//图形大小
	settextstyle(0,0,4);
	//内容
	outtextxy(200,180,"VITORY!!");
	settextstyle(0,0,2);
	outtextxy(10,230,"Congratulations on your customs clearance");
}