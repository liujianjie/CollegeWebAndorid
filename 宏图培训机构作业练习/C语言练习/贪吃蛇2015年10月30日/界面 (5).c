#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
#include "time.h"
#define ESC 283
#define N 2000//常量
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
#define r_1 561//主菜单的第一个
#define r_2 818//主菜单的第二个
#define r_3 1075//主菜单的第三个
#define r_4	1332//主菜单的第四个
#define r_5	1589//主菜单的第五个
#define r_6	1846//主菜单的第六个
#define r_7 2103//主菜单的第七个
//全局变量
int x;//接受关卡的选择的变量
//选择菜单界面
void kaitou();
void rootmenu();
void mowei();
void sonmenu();
void rootmenu1();
void rootmenu2();
void rootmenu3();
void rootmenu4();
void rootmenu5();
void rootmenu6();
//运行界面
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
}food,food1,food5;
void she();//蛇
void shiwu();//食物
void shiwu2();//特殊食物
void wenben();//分数
void draw(int type);//围墙
void jieshu();//游戏失败
void tongguan();//游戏通关
void wuqiong();//无穷模式
void fengshu();//无穷模式分数
void shiwu5();//无穷模式食物
//双蛇
struct snake2{
	int x[N];
	int y[N];
	int life;
	int node;
	int direction;
	int score;
	int level;
}snake2;
//食物
struct food2{
	int x;
	int y;
	int yes;
}food3,food4;
void she2();
void shiwu3();
void shiwu4();
void jieshu2();
void shuangfen();
void pass();

//开始
void main(){
	kaitou();
	rootmenu();
	mowei();
}
void rootmenu(){
	int key;
	int i;
	char a[50]="SNAKE";
	char b[50]="1 . Single Mode";
	char c[50]="2 . Double Mode";
	char d[50]="3 . WUQIONG";
	char e[50]="4 . HELP";
	char f[50]="5 . GUANGYU";
	char g[50]="6 . EXIT";
		//背景颜色
	setbkcolor(6);
	for(i=1;i<14;i++){
		while(!kbhit()){//防止没键盘的键值输入不动
			if(i=13){
				i=1;
			}
			//用随机数来做头部颜色
			setcolor(random(14)+1);
			//延迟
			delay(40000);
			//头部
			settextstyle(0,0,6);
			outtextxy(200,70,a);
			//内容
			setcolor(1);
			settextstyle(0,0,3);
			outtextxy(150,170,b);
			outtextxy(150,220,c);
			outtextxy(150,270,d);
			outtextxy(150,320,e);
			outtextxy(150,370,f);
			outtextxy(150,420,g);
			//while循环到这
			}
			//退出循环 但是这是等待键值输入 所以要个!kbhit();没有输入也会默认循环 一但输入就退出
			key=bioskey(0);
			if(key>0){
				break;
			}
	}
	switch(key){
		case r_1:
			rootmenu1();
			break;
		case r_2:
			rootmenu2();
			break;
		case r_3:
			rootmenu3();
			break;
		case r_4:
			rootmenu4();
			break;
		case r_5:
			rootmenu5();
		case r_6:
			rootmenu6();
	}
}

void kaitou(){
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");
	//随机种子
	randomize();
	
}
void mowei(){
	
	closegraph();//结束函数
}
//子菜单1
void rootmenu1(){
	int key;
		//清屏
		system("cls");
		//图形大小
		settextstyle(0,0,6);
		//背景颜色
		setbkcolor(7);
		//图形颜色
		setcolor(12);
		//头部
		outtextxy(100,70,"LET'S GO!!");
		//第一个选择
		settextstyle(0,0,3);//选择项的图形大小	
		setcolor(9);//选择项的颜色同样
		outtextxy(150,150,"1 . LEVEL 1");//输出的图形
		outtextxy(150,200,"2 . LEVEL 2");
		outtextxy(150,250,"3 . LEVEL 3");
		outtextxy(150,300,"4 . LEVEL 4");
		outtextxy(150,350,"5 . LEVEL 5");
		outtextxy(150,400,"6 . LEVEL 6");
		outtextxy(150,450,"7 . RETURN");
		
	//输入的数来选择关卡
	key=bioskey(0);
	switch(key){
		case r_1:
			x=1;
			system("cls");//清屏
			//清屏后的背景颜色
			setbkcolor(15);
			//围墙
			draw(0);
			she();
			break;
		case r_2:
			x=2;
			system("cls");//清屏
			//清屏后的背景颜色
			setbkcolor(15);
			//围墙 不用 在等级中写了
			//draw(0);
			she();
			break;
		case r_3:
		    x=3;
			system("cls");//清屏
			//清屏后的背景颜色
			setbkcolor(15);
			//围墙 不用 再等级中写了
			//draw(0);
			she();
			break;
		case r_4:
			x=4;
			system("cls");//清屏
			//清屏后的背景颜色
			setbkcolor(15);
			//围墙 需要 再等级中没写 但这关没有围墙
			//draw(0);
			she();
			break;
		case r_5:
			x=5;
			system("cls");//清屏
			//清屏后的背景颜色
			setbkcolor(15);
			//围墙 需要 再等级中没写 但这关没有围墙
			//draw(0);
			she();
			break;
		case r_6:
			x=6;
			system("cls");//清屏
			//清屏后的背景颜色
			setbkcolor(15);
			//围墙 需要 再等级中没写 但这关没有围墙
			//draw(0);
			she();
			break;
		case r_7:
			//清屏的再次打开主菜单
			system("cls");
			rootmenu();
			break;
		case ESC:
			//直接退出
			break;
	}	
	
}
//子菜单2
void rootmenu2(){
	int key;
		//清屏
		system("cls");
		//图形大小
		settextstyle(0,0,6);
		//背景颜色
		setbkcolor(7);
		//图形颜色
		setcolor(12);
		//头部
		outtextxy(100,70,"LET'S GO!!");
		//第一个选择
		settextstyle(0,0,3);//选择项的图形大小	
		setcolor(9);//选择项的颜色同样
		outtextxy(150,150,"1 . LEVEL 1");//输出的图形
		outtextxy(150,200,"2 . LEVEL 2");
		outtextxy(150,250,"3 . LEVEL 3");
		outtextxy(150,300,"4 . LEVEL 4");
		outtextxy(150,350,"5 . LEVEL 5");
		outtextxy(150,400,"6 . LEVEL 6");
		outtextxy(150,450,"7 . RETURN");
		getch();
	//输入的数来选择
	key=bioskey(0);	
	switch(key){
		case r_1:
			x=1;
			system("cls");//清屏
			//清屏后的背景颜色
			setbkcolor(15);
			//围墙
			draw(0);
			she2();
			break;
		case r_2:
			x=2;
			system("cls");//清屏
			//清屏后的背景颜色
			setbkcolor(15);
			//围墙 不用 在等级中写了
			//draw(0);
			she2();
			break;
		case r_3:
		    x=3;
			system("cls");//清屏
			//清屏后的背景颜色
			setbkcolor(15);
			//围墙 不用 再等级中写了
			//draw(0);
			she2();
			break;
		case r_4:
			x=4;
			system("cls");//清屏
			//清屏后的背景颜色
			setbkcolor(15);
			//围墙 需要 再等级中没写 但这关没有围墙
			//draw(0);
			she2();
			break;
		case r_5:
			x=5;
			system("cls");//清屏
			//清屏后的背景颜色
			setbkcolor(15);
			//围墙 需要 再等级中没写 但这关没有围墙
			//draw(0);
			she2();
			break;
		case r_6:
			x=6;
			system("cls");//清屏
			//清屏后的背景颜色
			setbkcolor(15);
			//围墙 需要 再等级中没写 但这关没有围墙
			//draw(0);
			she2();
			break;
		case r_7:
			//清屏的再次打开主菜单
			system("cls");
			rootmenu();
			break;
		case ESC:
			//直接退出
			break;
	}
}
//直接运行 等级为2 的模式
void rootmenu3(){
		system("cls");
		wuqiong();
}
void rootmenu4(){
	int key;
	//清屏
	system("cls");
	//图形大小 背景颜色 图形颜色
	setbkcolor(1);
	setcolor(15);
	//主要内容
	settextstyle(0,0,3);
	outtextxy(150,30," ESC    Exit");
	outtextxy(150,80," SPACE  Pause");
	outtextxy(150,130," PLAY 1:");
	settextstyle(0,0,2);
	outtextxy(200,160,"↑     Up");
	outtextxy(200,190,"↓     Down");
	outtextxy(200,220,"←     Left");
	outtextxy(200,250,"→     Right");
	settextstyle(0,0,3);
	outtextxy(150,300," PLAY 2:");
	settextstyle(0,0,2);
	outtextxy(200,330,"W     UP");
	outtextxy(200,360,"S     DOWN");
	outtextxy(200,390,"A     LET");
	outtextxy(200,420,"D     RIGHT");
	key=bioskey(0);
	if(key==ESC){
		system("cls");
		rootmenu();
	}
}
void rootmenu5(){
	int key;
	system("cls");
	setbkcolor(8);
	setcolor(10);
	settextstyle(0,0,2);
	outtextxy(100,80,"GAMENAME: Gluttonous Snake");
	outtextxy(100,110,"developer: Jian-Jie Liu");
	outtextxy(100,140,"date: On October 30, 2015");
	outtextxy(100,170,"E-mial: 1219277604@qq.com");
	outtextxy(100,200,"QQ: 121927604");
	outtextxy(100,230,"telephone: 18070367115");
	outtextxy(100,280,"PS: Please contact me if ");
	outtextxy(100,310,"you have any questions,");
	outtextxy(100,340,"I would be happy to assist");
	outtextxy(100,370,"in any way I can.");
	key=bioskey(0);
	if(key==ESC){
		system("cls");
		rootmenu();
	}
}
void rootmenu6(){
	return;
}
void she(){
	//初始化
	int i;
	int key;//输入键盘所需要的代码
	int count=0;//吃食物的计数
	int state=0;//控制墙画一遍
	int state2=0;
	int state3=0;
	int state4=0;
	int speed=24000;//速度控制量 
	//初始化
	snake.x[0]=60;	
	snake.y[0]=70;
	snake.x[1]=50;	
	snake.y[1]=60;
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
			//特殊食物也要 并且需要白板来檫掉留在区域内的矩形
			//第三关
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
		//第四关特殊食物出现在障碍物则重新刷新并去掉
		if(food1.x>0 &&food1.x<639 &&food1.y>244 &&food1.y<254){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>314 &&food1.x<324 &&food1.y>46 &&food1.y<479){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		//第5关特殊食物不能出现在障碍物 如有 则去掉用白墙
		if(food1.x>209 &&food1.x<219 &&food1.y>46 &&food1.y<219 ){//竖的障碍
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>409 &&food1.x<419 &&food1.y>46 &&food1.y<219 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>209 &&food1.x<219 &&food1.y>309 &&food1.y<469 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>409 &&food1.x<309 &&food1.y>419 &&food1.y<469 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>0 &&food1.x<219 &&food1.y>209 &&food1.y<219 ){//横的障碍
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>409 &&food1.x<639 &&food1.y>209 &&food1.y<319 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>0 &&food1.x<219 &&food1.y>309 &&food1.y<319 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>409 &&food1.x<639 &&food1.y>309 &&food1.y<249 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		}
		//第三关要用的 如果食物出现在区域内 得重新出现食物 把蛇的范围复制过来就行并且需要白板来檫掉留在区域内的矩形
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
		//第四关食物出现在障碍物则重新刷新并去掉
		if(food.x>314 &&food.x<324 &&food.y>46 &&food.y<479){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>0 &&food.x<639 &&food.y>244 &&food.y<254){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		//第5关食物不能出现在障碍物 如有 则去掉用白墙
		if(food.x>209 &&food.x<219 &&food.y>46 &&food.y<219 ){//竖的障碍
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>409 &&food.x<419 &&food.y>46 &&food.y<219 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>209 &&food.x<219 &&food.y>309 &&food.y<469 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>409 &&food.x<309 &&food.y>419 &&food.y<469 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>0 &&food.x<219 &&food.y>209 &&food.y<219 ){//横的障碍
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>409 &&food.x<639 &&food.y>209 &&food.y<319 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>0 &&food.x<219 &&food.y>309 &&food.y<319 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>409 &&food.x<639 &&food.y>309 &&food.y<249 ){
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
		if(snake.y[0]<57){//上下
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
		
		//画蛇的两节//必须要有颜色
		setlinestyle(0,0,3);//宽度
		setcolor(4);
		for(i=0;i<snake.node;i++){
			rectangle(snake.x[i],snake.y[i],snake.x[i]+10,snake.y[i]+10);	
		}
		
		//蛇动起来
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
			//延迟最小值
			if(speed==8000){
				speed=8000;
			}else{
				speed-=8000;//减速度
			}
			//去掉吃特殊食物脱下来的那节
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
				//第二关的初始速度 1遍就行
				speed=24000;
				delay(24000);//延迟1遍
			 }
			 
		}
		else if(snake.level==3){//等级3
			
			//画一层之前白墙刷掉的墙
			if(state2==0){
				draw(2);
				state2=1;
				//初始速度 1遍就行
				speed=24000;
				delay(50000);//延迟1遍
			}
			//撞墙死 因为画的是墙 所以要判断
			if(snake.x[0]<30||snake.x[0]>600||snake.y[0]<60||snake.y[0]>440){
			snake.life=0;
			}
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
		else if(snake.level==4){
			if(state3==0){
				system("cls");
				state3=1;
				wenben();
				//初始速度 1遍就行
				speed=24000;
				delay(50000);//延迟1遍
			}
			setbkcolor(15);
			
			//障碍物
			setfillstyle(7,8);
			bar(315,47,325,480);
			setfillstyle(7,8);
			bar(0,245,640,255);
			//蛇头在障碍物死
			if(snake.x[0]>314 &&snake.x[0]<324 &&snake.y[0]>46 &&snake.y[0]<479){
				snake.life=0;
			}
			if(snake.x[0]>0 &&snake.x[0]<639 &&snake.y[0]>244 &&snake.y[0]<254){
				snake.life=0;
			}
			
		}
		else if(snake.level==5){
			if(state4==0){
				system("cls");
				state4=1;
				wenben();
				//初始速度 1遍就行
				speed=24000;
				delay(50000);//延迟1遍
			}
			setbkcolor(15);
			//障碍物
			setfillstyle(7,8);
			bar(210,47,220,220);//竖的障碍
			bar(410,47,420,220);
			bar(210,310,220,470);
			bar(410,310,420,470);
			
			bar(0,210,220,220);//横的障碍
			bar(410,210,640,220);
			bar(0,310,220,320);
			bar(410,310,640,320);
			//判断 蛇头不能撞到
			if(snake.x[0]>209 &&snake.x[0]<219 &&snake.y[0]>46 &&snake.y[0]<219 ){//竖的障碍
				snake.life=0;
			}
			if(snake.x[0]>409 &&snake.x[0]<419 &&snake.y[0]>46 &&snake.y[0]<219 ){
				snake.life=0;
				
			}
			if(snake.x[0]>209 &&snake.x[0]<219 &&snake.y[0]>309 &&snake.y[0]<469 ){
				snake.life=0;
				
			}
			if(snake.x[0]>409 &&snake.x[0]<309 &&snake.y[0]>419 &&snake.y[0]<469 ){
				snake.life=0;
				
			}
			if(snake.x[0]>0 &&snake.x[0]<219 &&snake.y[0]>209 &&snake.y[0]<219 ){//横的障碍
				snake.life=0;
				
			}
			if(snake.x[0]>409 &&snake.x[0]<639 &&snake.y[0]>209 &&snake.y[0]<319 ){
				snake.life=0;
				
			}
			if(snake.x[0]>0 &&snake.x[0]<219 &&snake.y[0]>309 &&snake.y[0]<319 ){
				snake.life=0;
				
			}
			if(snake.x[0]>409 &&snake.x[0]<639 &&snake.y[0]>309 &&snake.y[0]<249 ){
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
		//清屏的打开子菜单 不需要退出
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
	//跳出后进入菜单 不用清屏
	rootmenu1();
	snake.score=0;
}

void shiwu(){
	//判断是否需要生产食物
	if(food.yes==0){
		//随机数种子
		randomize();
		//0-639
		food.x=random(540)+30;
		//生成的坐标需要是10 的倍数(为了让蛇跟食物在一条线上)
		while(food.x%10!=0){
			food.x++;
		}
		
		food.y=random(340)+70;
		while(food.y%10!=0){
			food.y++;
		}
		
		food.yes=1;//1表示已经有食物了
	}
	setcolor(GREEN);
	rectangle(food.x,food.y,food.x+10,food.y+10);
}
void shiwu2(){
	//判断是否需要生产食物
	if(food1.yes==0){
		//随机数种子
		randomize();
		//0-639
		food1.x=random(510)+60;
		//生成的坐标需要是10 的倍数(为了让蛇跟食物在一条线上)
		while(food1.x%10!=0){
			food1.x++;
		}
		
		food1.y=random(310)+100;
		while(food1.y%10!=0){
			food1.y++;
		}
		
		food1.yes=1;//1表示已经有食物了
	}
	setcolor(random(13)+1);
	rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
}
void wenben(){
	//文本
	char a[50];
	int fen;//控制分数随等级增长
	if(x==1){
		fen=40;
	}
	if(x==2){
		fen=80;
	}
	if(x==3){
		fen=120;
	}
	if(x==4){
		fen=160;
	}
	if(x==5){
		fen=200;
	}
	if(x==6){
		fen=240;
	}
	//封闭区域
	setfillstyle(3,7);
	bar(110,20,510,43);
	//文本大小
	settextstyle(0,0,3);
	setcolor(12);
	snake.level=snake.score/fen+x;//把计算分数的放这里可以防止一开始等级为0
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
		//灰墙
		if(type==2){
			setcolor(8);
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
		//灰墙
		if(type==2){
			setcolor(8);
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
	setbkcolor(0);
	setcolor(YELLOW);
	//图形大小
	settextstyle(0,0,3);
	//内容
	outtextxy(150,150,a);
	settextstyle(0,0,3);
	sprintf(b,"LEVEL:%d SCORE:%d",snake.level,snake.score);
	outtextxy(150,270,b);
}
//无穷模式的分数

void tongguan(){
	//清屏
	system("cls");
	//背景颜色	
	setbkcolor(0);
	//图形颜色
	setcolor(YELLOW);
	//图形大小
	settextstyle(0,0,4);
	//内容
	outtextxy(190,160,"VITORY!!");
	settextstyle(0,0,2);
	outtextxy(170,215,"Congratulations on ");
	outtextxy(135,245,"your customs clearance!!");
}
//无穷
void wuqiong(){
	//初始化
	int i;
	int key;//输入键盘所需要的代码
	int count=0;//吃食物的计数
	int state=0;//控制墙画一遍
	int speed=24000;//速度控制量 
	int o;//随机数
	//初始化
	snake.x[0]=260;	
	snake.y[0]=180;
	snake.x[1]=250;	
	snake.y[1]=180;
	snake.life=1;
	snake.node=2;
	snake.direction=1;
	snake.level=2;
	//食物必须先产生
	food.yes=0;
	food5.yes=0;
	fengshu();
	while(snake.life){
	   while(!kbhit()){//实现每按键输入也会运行
		shiwu();
		//放在这里可以防止吃边无限刷特殊食物
		if(count==2){
			//生成特殊食物
			shiwu5();
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
		if(snake.y[0]<57){//上下
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
		
		//画蛇的两节//必须要有颜色
		setlinestyle(0,0,3);//宽度
		setcolor(random(13)+1);
		for(i=0;i<snake.node;i++){
			rectangle(snake.x[i],snake.y[i],snake.x[i]+10,snake.y[i]+10);	
		}
		
		//蛇动起来
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
			fengshu();
			count++;//累加
			if(count>2){//让它吃到第三个以上 count都是等于2
				count=2;
			}
		}
		//吃特殊食物 因为吃特殊食物蛇节-1 要把脱下来的节去掉 而不能影响蛇动的去掉最后一节 所以只能移下来
		if(snake.x[0]>food5.x-20&&snake.y[0]>food5.y-20&&snake.x[0]<food5.x+20&&snake.y[0]<food5.y+20){
			o=random(3)+1;
			if(o==1){
				snake.score+=200;
				setfillstyle(1,15);
				bar(food5.x,food5.y,food5.x+20,food5.y+20);
				
			}
			else if(o==2){
				snake.node+=50;
				if(snake.node>=350){
					snake.node-=50;	
				}
				setfillstyle(1,15);
				bar(food5.x,food5.y,food5.x+20,food5.y+20);
			}
			else if(o==3){
				if(speed==8000){
					speed=8000;
				}else{
					speed-=8000;//减速度
				}
				setfillstyle(1,15);
				bar(food5.x,food5.y,food5.x+20,food5.y+20);
			}
			else if(o==4){
				if(speed==8000){
					speed+=8000;
					
				}
				setfillstyle(1,15);
				bar(food5.x,food5.y,food5.x+20,food5.y+20);
			}
			food5.yes=0;//以下个食物出现
			fengshu();//分数打印
			count=0;//初始值
			//延迟最小值
			
			//去掉吃特殊食物脱下来的那节
			setcolor(15);
			rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		}
		
		//关卡
		 if(snake.level==2){//等级2
		
			//画一遍白墙
			 if(state==0){
			 	setbkcolor(15);
				draw(1);
				state=1;
				//第二关的初始速度 1遍就行
				speed=24000;
				delay(50000);//延迟1遍
			 }
			 
		}
	}
	key=bioskey(0);
	if(key==ESC){
		//清屏的打开子菜单 不需要退出
		
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
	//跳出后进入菜单 要清屏
	system("cls");
	rootmenu();
	
}
//无穷分数
void fengshu(){
	//文本
	char a[50];
	//封闭区域
	setfillstyle(3,7);
	bar(0,20,640,43);
	//文本大小
	settextstyle(0,0,3);
	setcolor(12);
	sprintf(a,"SCORE:%d",snake.score);
	outtextxy(225,20,a);
}
//无穷食物
void shiwu5(){
	int i;
	if(food5.yes==0){
	randomize();	
	food5.x=random(520)+50;
	while(food5.x%10!=0){
		food5.x++;
	}
	food5.y=random(350)+80;
	while(food5.y%10!=0){
		food5.y++;	//防止出现不是为10的倍数的坐标
	}
	food5.yes=1;//这样食物为1 的话就不会产生新的食物
	}
	setfillstyle(1,random(14)+1);
	bar(food5.x,food5.y,food5.x+20,food5.y+20);//解决蛇会磨食物的边	
	
	
}
//双蛇
void she2(){
	//初始化
	int i;
	int key;//输入键盘所需要的代码
	int count=0;//吃食物的计数
	int count2=0;//二
	int state=0;//控制墙画一遍
	int state2=0;
	int state3=0;
	int state4=0;
	int speed=24000;//速度控制量 
	int speed2=24000;//二
	//初始化
	snake.x[0]=60;//第一条蛇	
	snake.y[0]=70;
	snake.x[1]=50;	
	snake.y[1]=60;
	snake.life=1;
	snake.node=2;
	snake.direction=1;//默认向右
	snake2.x[0]=450;//第二条蛇
	snake2.y[0]=430;
	snake2.x[1]=460;
	snake2.y[1]=440;
	snake2.direction=2;//默认向左
	snake2.node=2;
	snake2.life=1;
	//食物必须先产生
	food.yes=0;
	food1.yes=0;
	food3.yes=0;
	food4.yes=0;
	shuangfen();
	while(snake.life&&snake2.life){
	   while(!kbhit()){//实现每按键输入也会运行
		shiwu();
		shiwu3();
		//放在这里可以防止吃边无限刷特殊食物
		if(count==2){
			//生成特殊食物
			shiwu2();
			//特殊食物也要 并且需要白板来檫掉留在区域内的矩形
			//第三关
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
		//第四关特殊食物出现在障碍物则重新刷新并去掉
		if(food1.x>0 &&food1.x<639 &&food1.y>244 &&food1.y<254){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>314 &&food1.x<324 &&food1.y>46 &&food1.y<479){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		//第5关特殊食物不能出现在障碍物 如有 则去掉用白墙
		if(food1.x>209 &&food1.x<219 &&food1.y>46 &&food1.y<219 ){//竖的障碍
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>409 &&food1.x<419 &&food1.y>46 &&food1.y<219 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>209 &&food1.x<219 &&food1.y>309 &&food1.y<469 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>409 &&food1.x<309 &&food1.y>419 &&food1.y<469 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>0 &&food1.x<219 &&food1.y>209 &&food1.y<219 ){//横的障碍
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>409 &&food1.x<639 &&food1.y>209 &&food1.y<319 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>0 &&food1.x<219 &&food1.y>309 &&food1.y<319 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>409 &&food1.x<639 &&food1.y>309 &&food1.y<249 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		}
		if(count2==2){
			shiwu4();
			//二
		//第三关要用的 如果食物出现在区域内 得重新出现食物 把蛇的范围复制过来就行并且需要白板来檫掉留在区域内的矩形
		if(food4.x>139 &&food4.x<269 &&food4.y>56 &&food4.y<229 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		if(food4.x>379 &&food4.x<509 &&food4.y>56 &&food4.y<229 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		if(food4.x>29 &&food4.x<129 &&food4.y>259 &&food4.y<452 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		if(food4.x>259 &&food4.x<389 &&food4.y>259 &&food4.y<452 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		if(food4.x>509 &&food4.x<609 &&food4.y>259 &&food4.y<452 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		//第四关食物出现在障碍物则重新刷新并去掉
		if(food4.x>314 &&food4.x<324 &&food4.y>46 &&food4.y<479){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		if(food4.x>0 &&food4.x<639 &&food4.y>244 &&food4.y<254){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		//第5关食物不能出现在障碍物 如有 则去掉用白墙
		if(food4.x>209 &&food4.x<219 &&food4.y>46 &&food4.y<219 ){//竖的障碍
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		if(food4.x>409 &&food4.x<419 &&food4.y>46 &&food4.y<219 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
			
		}
		if(food4.x>209 &&food4.x<219 &&food4.y>309 &&food4.y<469 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
			
		}
		if(food4.x>409 &&food4.x<309 &&food4.y>419 &&food4.y<469 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
			
		}
		if(food4.x>0 &&food4.x<219 &&food4.y>209 &&food4.y<219 ){//横的障碍
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
			
		}
		if(food.x>409 &&food.x<639 &&food.y>209 &&food.y<319 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food4.x>0 &&food4.x<219 &&food4.y>309 &&food4.y<319 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
			
		}
		if(food4.x>409 &&food4.x<639 &&food4.y>309 &&food4.y<249 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
			
		}
		}
		//第三关要用的 如果食物出现在区域内 得重新出现食物 把蛇的范围复制过来就行并且需要白板来檫掉留在区域内的矩形
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
		//第四关食物出现在障碍物则重新刷新并去掉
		if(food.x>314 &&food.x<324 &&food.y>46 &&food.y<479){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>0 &&food.x<639 &&food.y>244 &&food.y<254){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		//第5关食物不能出现在障碍物 如有 则去掉用白墙
		if(food.x>209 &&food.x<219 &&food.y>46 &&food.y<219 ){//竖的障碍
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>409 &&food.x<419 &&food.y>46 &&food.y<219 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>209 &&food.x<219 &&food.y>309 &&food.y<469 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>409 &&food.x<309 &&food.y>419 &&food.y<469 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>0 &&food.x<219 &&food.y>209 &&food.y<219 ){//横的障碍
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>409 &&food.x<639 &&food.y>209 &&food.y<319 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>0 &&food.x<219 &&food.y>309 &&food.y<319 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>409 &&food.x<639 &&food.y>309 &&food.y<249 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		//二
		//第三关要用的 如果食物出现在区域内 得重新出现食物 把蛇的范围复制过来就行并且需要白板来檫掉留在区域内的矩形
		if(food3.x>139 &&food3.x<269 &&food3.y>56 &&food3.y<229 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		if(food3.x>379 &&food3.x<509 &&food3.y>56 &&food3.y<229 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		if(food3.x>29 &&food3.x<129 &&food3.y>259 &&food3.y<452 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		if(food3.x>259 &&food3.x<389 &&food3.y>259 &&food3.y<452 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		if(food3.x>509 &&food3.x<609 &&food3.y>259 &&food3.y<452 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		//第四关食物出现在障碍物则重新刷新并去掉
		if(food3.x>314 &&food3.x<324 &&food3.y>46 &&food3.y<479){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		if(food3.x>0 &&food3.x<639 &&food3.y>244 &&food3.y<254){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		//第5关食物不能出现在障碍物 如有 则去掉用白墙
		if(food3.x>209 &&food3.x<219 &&food3.y>46 &&food3.y<219 ){//竖的障碍
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		if(food3.x>409 &&food3.x<419 &&food3.y>46 &&food3.y<219 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
			
		}
		if(food3.x>209 &&food3.x<219 &&food3.y>309 &&food3.y<469 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
			
		}
		if(food3.x>409 &&food3.x<309 &&food3.y>419 &&food3.y<469 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
			
		}
		if(food3.x>0 &&food3.x<219 &&food3.y>209 &&food3.y<219 ){//横的障碍
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
			
		}
		if(food3.x>409 &&food3.x<639 &&food3.y>209 &&food3.y<319 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
			
		}
		if(food3.x>0 &&food3.x<219 &&food3.y>309 &&food3.y<319 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
			
		}
		if(food3.x>409 &&food3.x<639 &&food3.y>309 &&food3.y<249 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
			
		}
		//主要内容
		setlinestyle(0,0,3);//蛇和食物宽度和线性样式
		for(i=snake.node-1;i>0;i--){
			snake.x[i]=snake.x[i-1];
			snake.y[i]=snake.y[i-1];//蛇的坐标赋给下一节
		}
		//二蛇
		setlinestyle(0,0,3);//蛇和食物宽度和线性样式
		for(i=snake2.node-1;i>0;i--){
			snake2.x[i]=snake2.x[i-1];
			snake2.y[i]=snake2.y[i-1];//蛇的坐标赋给下一节
		}
		//穿越边界 让蛇头的坐标变换就行
		if(snake.x[0]<10){//左右
			snake.x[0]=630;
		}
		if(snake.x[0]>630){
			snake.x[0]=10;
		}
		if(snake.y[0]<57){//上下
			snake.y[0]=470;
		}
		if(snake.y[0]>470){
			snake.y[0]=47;
		}
		//二蛇
		if(snake2.x[0]<10){//左右
			snake2.x[0]=630;
		}
		if(snake2.x[0]>630){
			snake2.x[0]=10;
		}
		if(snake2.y[0]<57){//上下
			snake2.y[0]=470;
		}
		if(snake2.y[0]>470){
			snake2.y[0]=47;
		}
		//第一条蛇的控制
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
		//第二条蛇的控制
		switch(snake2.direction){
			case 1:
				snake2.x[0]+=10;//向右
				break;
			case 2:
				snake2.x[0]-=10;//向左
				break;
			case 3:
				snake2.y[0]-=10;//向上
				break;
			case 4:
				snake2.y[0]+=10;//向下
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
			jieshu2();
			break;
		}
		//咬自己 第二条蛇
		for(i=3;i<snake2.node;i++){
				if(snake2.x[0]==snake2.x[i]&&snake2.y[0]==snake2.y[i]){
					snake2.life=0;
				}
		}
		if(snake2.life==0){
			jieshu2();
			break;
		}
		
		//画蛇的两节//必须要有颜色
		setlinestyle(0,0,3);//宽度
		setcolor(4);
		for(i=0;i<snake.node;i++){
			rectangle(snake.x[i],snake.y[i],snake.x[i]+10,snake.y[i]+10);	
		}
		//二蛇
		setlinestyle(0,0,3);//宽度
		setcolor(3);
		for(i=0;i<snake2.node;i++){
			rectangle(snake2.x[i],snake2.y[i],snake2.x[i]+10,snake2.y[i]+10);	
		}
		//蛇动起来
		//循环画墙避免吃墙但是延迟会受影响只能试试把围墙变小点但蛇碰墙的范围不变
		delay(speed);//步伐延迟
		setlinestyle(0,0,3);//擦掉末尾宽度和线性样式
		setcolor(15);//填充颜色
		//去掉尾部的节数
		rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		//二蛇
		//一个延迟就行delay(speed2);步伐延迟
		setlinestyle(0,0,3);//擦掉末尾宽度和线性样式
		setcolor(15);//填充颜色
		//去掉尾部的节数
		rectangle(snake2.x[snake2.node-1],snake2.y[snake2.node-1],snake2.x[snake2.node-1]+10,snake2.y[snake2.node-1]+10);		
		
		//第一条蛇吃普通食物
		if(snake.x[0]==food.x&&snake.y[0]==food.y){
			snake.node++;
			food.yes=0;//以下个食物出现
			snake.score+=10;
			shuangfen();
			count++;//累加
			if(count>2){//让它吃到第三个以上 count都是等于2
				count=2;
			}
		}
		//第一条蛇吃普通食物2
		if(snake.x[0]==food3.x&&snake.y[0]==food3.y){
			snake.node++;
			food3.yes=0;//以下个食物出现
			snake.score+=10;
			shuangfen();
			count++;//累加
			if(count2>2){//让它吃到第三个以上 count都是等于2
				count2=2;
			}
		}
		//第二条蛇吃普通食物
		if(snake2.x[0]==food.x&&snake2.y[0]==food.y){
			snake2.node++;
			food.yes=0;//以下个食物出现
			snake2.score+=10;
			shuangfen();
			count++;//累加
			if(count>2){//让它吃到第三个以上 count都是等于2
				count=2;
			}
		}
		//第二条蛇吃普通食物2
		if(snake2.x[0]==food3.x&&snake2.y[0]==food3.y){
			snake2.node++;
			food3.yes=0;//以下个食物出现
			snake2.score+=10;
			shuangfen();
			count++;//累加
			if(count2>2){//让它吃到第三个以上 count都是等于2
				count2=2;
			}
		}
		//第一条蛇吃特殊食物 因为吃特殊食物蛇节-1 要把脱下来的节去掉 而不能影响蛇动的去掉最后一节 所以只能移下来
		if(snake.x[0]==food1.x&&snake.y[0]==food1.y){
			snake.node--;
			food1.yes=0;//以下个食物出现
			snake.score+=20;
			shuangfen();//分数打印
			count=0;//初始值
			//延迟最小值
			if(speed==8000){
				speed=8000;
			}else{
				speed-=8000;//减速度
			}
			//去掉吃特殊食物脱下来的那节
			setcolor(15);
			rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		}
		//第一条蛇吃特殊食物2 因为吃特殊食物蛇节-1 要把脱下来的节去掉 而不能影响蛇动的去掉最后一节 所以只能移下来
		if(snake.x[0]==food4.x&&snake.y[0]==food4.y){
			snake.node--;
			food4.yes=0;//以下个食物出现
			snake.score+=20;
			shuangfen();//分数打印
			count=0;//初始值
			//延迟最小值
			if(speed==8000){
				speed=8000;
			}else{
				speed-=8000;//减速度
			}
			//去掉吃特殊食物脱下来的那节
			setcolor(15);
			rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		}
		//第二条蛇吃特殊食物 因为吃特殊食物蛇节-1 要把脱下来的节去掉 而不能影响蛇动的去掉最后一节 所以只能移下来
		if(snake2.x[0]==food1.x&&snake2.y[0]==food1.y){
			snake2.node--;
			food1.yes=0;//以下个食物出现
			snake2.score+=20;
			shuangfen();//分数打印
			count=0;//初始值
			//延迟最小值
			if(speed==8000){
				speed=8000;
			}else{
				speed-=8000;//减速度
			}
			//去掉吃特殊食物脱下来的那节
			setcolor(15);
			rectangle(snake2.x[snake2.node-1],snake2.y[snake2.node-1],snake2.x[snake2.node-1]+10,snake2.y[snake2.node-1]+10);
		}
		//第二条蛇吃特殊食物2 因为吃特殊食物蛇节-1 要把脱下来的节去掉 而不能影响蛇动的去掉最后一节 所以只能移下来
		if(snake2.x[0]==food4.x&&snake2.y[0]==food4.y){
			snake2.node--;
			food4.yes=0;//以下个食物出现
			snake2.score+=20;
			shuangfen();//分数打印
			count=0;//初始值
			//延迟最小值
			if(speed==8000){
				speed=8000;
			}else{
				speed-=8000;//减速度
			}
			//去掉吃特殊食物脱下来的那节
			setcolor(15);
			rectangle(snake2.x[snake2.node-1],snake2.y[snake2.node-1],snake2.x[snake2.node-1]+10,snake2.y[snake2.node-1]+10);
		}
		
		//关卡
		if(snake.level==1||snake2.level==1){//等级1
			//撞墙
			if(snake.x[0]<30||snake.x[0]>600||snake.y[0]<60||snake.y[0]>440){
			snake.life=0;
			//把蛇的生命为0就不会循环第一层直接跳出
			//不过先得跳出第二层while循环直接跳出,上面有判断就不用了
			}
			//二
			if(snake2.x[0]<30||snake2.x[0]>600||snake2.y[0]<60||snake2.y[0]>440){
			snake2.life=0;
			}
		}
		else if(snake.level==2||snake2.level==2){//等级2
		
			//画一遍白墙
			 if(state==0){
				draw(1);
				state=1;
				//第二关的初始速度 1遍就行
				speed=24000;
				delay(100000);//延迟1遍
			 }
		}
		else if(snake.level==3||snake2.level==3){//等级3
			
			//画一层之前白墙刷掉的墙
			if(state2==0){
				draw(2);
				state2=1;
				//初始速度 1遍就行
				speed=24000;
				delay(100000);//延迟1遍
			}
			//撞墙死 因为画的是墙 所以要判断
			if(snake.x[0]<30||snake.x[0]>600||snake.y[0]<60||snake.y[0]>440){
				snake.life=0;
			}
			//二
			if(snake2.x[0]<30||snake2.x[0]>600||snake2.y[0]<60||snake2.y[0]>440){
			snake2.life=0;
			}
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
			//二
			if(snake2.x[0]>139 &&snake2.x[0]<269 &&snake2.y[0]>56 &&snake2.y[0]<229 ){
				snake2.life=0;
			}
			if(snake2.x[0]>379 &&snake2.x[0]<509 &&snake2.y[0]>56 &&snake2.y[0]<229 ){
				snake2.life=0;
			}
			if(snake2.x[0]>29 &&snake2.x[0]<129 &&snake2.y[0]>259 &&snake2.y[0]<452 ){
				snake2.life=0;
			}
			if(snake2.x[0]>259 &&snake2.x[0]<389 &&snake2.y[0]>259 &&snake2.y[0]<452 ){
				snake2.life=0;
			}
			if(snake2.x[0]>509 &&snake2.x[0]<609 &&snake2.y[0]>259 &&snake2.y[0]<452 ){
				snake2.life=0;
			}
		}
		else if(snake.level==4||snake2.level==4){
			if(state3==0){
				system("cls");
				state3=1;
				shuangfen();
				//初始速度 1遍就行
				speed=24000;
				delay(50000);//延迟1遍
			}
			setbkcolor(15);
			
			//障碍物
			setfillstyle(7,8);
			bar(315,47,325,480);
			setfillstyle(7,8);
			bar(0,245,640,255);
			//蛇头在障碍物死
			if(snake.x[0]>314 &&snake.x[0]<324 &&snake.y[0]>46 &&snake.y[0]<479){
				snake.life=0;
			}
			if(snake.x[0]>0 &&snake.x[0]<639 &&snake.y[0]>244 &&snake.y[0]<254){
				snake.life=0;
			}
			//二
			if(snake2.x[0]>314 &&snake2.x[0]<324 &&snake2.y[0]>46 &&snake2.y[0]<479){
				snake.life=0;
			}
			if(snake2.x[0]>0 &&snake2.x[0]<639 &&snake2.y[0]>244 &&snake2.y[0]<254){
				snake2.life=0;
			}
			
		}
		else if(snake.level==5||snake2.level==5){
			if(state4==0){
				system("cls");
				state4=1;
				shuangfen();
				//初始速度 1遍就行
				speed=24000;
				delay(50000);//延迟1遍
			}
			setbkcolor(15);
			//障碍物
			setfillstyle(7,8);
			bar(210,47,220,220);//竖的障碍
			bar(410,47,420,220);
			bar(210,310,220,470);
			bar(410,310,420,470);
			
			bar(0,210,220,220);//横的障碍
			bar(410,210,640,220);
			bar(0,310,220,320);
			bar(410,310,640,320);
			//判断 蛇头不能撞到
			if(snake.x[0]>209 &&snake.x[0]<219 &&snake.y[0]>46 &&snake.y[0]<219 ){//竖的障碍
				snake.life=0;
			}
			if(snake.x[0]>409 &&snake.x[0]<419 &&snake.y[0]>46 &&snake.y[0]<219 ){
				snake.life=0;
				
			}
			if(snake.x[0]>209 &&snake.x[0]<219 &&snake.y[0]>309 &&snake.y[0]<469 ){
				snake.life=0;
				
			}
			if(snake.x[0]>409 &&snake.x[0]<309 &&snake.y[0]>419 &&snake.y[0]<469 ){
				snake.life=0;
				
			}
			if(snake.x[0]>0 &&snake.x[0]<219 &&snake.y[0]>209 &&snake.y[0]<219 ){//横的障碍
				snake.life=0;
				
			}
			if(snake.x[0]>409 &&snake.x[0]<639 &&snake.y[0]>209 &&snake.y[0]<319 ){
				snake.life=0;
				
			}
			if(snake.x[0]>0 &&snake.x[0]<219 &&snake.y[0]>309 &&snake.y[0]<319 ){
				snake.life=0;
				
			}
			if(snake.x[0]>409 &&snake.x[0]<639 &&snake.y[0]>309 &&snake.y[0]<249 ){
				snake.life=0;
				
			}
			//二
			if(snake2.x[0]>209 &&snake2.x[0]<219 &&snake2.y[0]>46 &&snake2.y[0]<219 ){//竖的障碍
				snake2.life=0;
			}
			if(snake2.x[0]>409 &&snake2.x[0]<419 &&snake2.y[0]>46 &&snake2.y[0]<219 ){
				snake2.life=0;
				
			}
			if(snake2.x[0]>209 &&snake2.x[0]<219 &&snake2.y[0]>309 &&snake2.y[0]<469 ){
				snake2.life=0;
				
			}
			if(snake2.x[0]>409 &&snake2.x[0]<309 &&snake2.y[0]>419 &&snake2.y[0]<469 ){
				snake2.life=0;
				
			}
			if(snake2.x[0]>0 &&snake2.x[0]<219 &&snake2.y[0]>209 &&snake2.y[0]<219 ){//横的障碍
				snake2.life=0;
				
			}
			if(snake2.x[0]>409 &&snake2.x[0]<639 &&snake2.y[0]>209 &&snake2.y[0]<319 ){
				snake2.life=0;
				
			}
			if(snake2.x[0]>0 &&snake2.x[0]<219 &&snake2.y[0]>309 &&snake2.y[0]<319 ){
				snake2.life=0;
				
			}
			if(snake.x[0]>409 &&snake.x[0]<639 &&snake.y[0]>309 &&snake.y[0]<249 ){
				snake.life=0;
				
			}
		}
		else{//通关
			pass();
			snake.life=0;
			break;
			
		}
	}
	key=bioskey(0);
	if(key==ESC){
		//清屏的打开子菜单 不需要退出
		break;	

	}
	else if(key==KONGGE){
		//再画一条蛇覆盖原来的蛇
		setcolor(RED);
		for(i=0;i<snake.node;i++){
		rectangle(snake.x[i],snake.y[i],snake.x[i]+10,snake.y[i]+10);	
		//二蛇
		setcolor(3);
		for(i=0;i<snake2.node;i++){
		rectangle(snake2.x[i],snake2.y[i],snake2.x[i]+10,snake2.y[i]+10);
		}
		getch();//暂停放中间 意思是 暂停 就画完一条蛇 开始就开始擦尾
		//去掉尾部的节数
		setcolor(15);
		rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		//二蛇
		setcolor(15);
		rectangle(snake2.x[snake2.node-1],snake2.y[snake2.node-1],snake2.x[snake2.node-1]+10,snake2.y[snake2.node-1]+10);
		}
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
	//二蛇
	else if(key==D&&snake2.direction!=2){
		snake2.direction=1;
	}else if(key==A&&snake2.direction!=1){
		snake2.direction=2;
	}else if(key==W&&snake2.direction!=4){
		snake2.direction=3;
	}else if(key==S&&snake2.direction!=3){
		snake2.direction=4;
	}
	}
	//跳出后进入菜单2 不用清屏
	rootmenu2();
	//并且分数重置
	snake.score=0;
	snake2.score=0;
}
void shiwu3(){
	//判断是否需要生产食物
	if(food3.yes==0){
		//随机数种子
		randomize();
		//0-639
		food3.x=random(540)+30;
		//生成的坐标需要是10 的倍数(为了让蛇跟食物在一条线上)
		while(food3.x%10!=0){
			food3.x++;
		}
		
		food3.y=random(340)+70;
		while(food3.y%10!=0){
			food3.y++;
		}
		
		food3.yes=1;//1表示已经有食物了
	}
	setcolor(GREEN);
	rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
}
void shiwu4(){
	int i;
	if(food4.yes==0){
	randomize();	
	food4.x=random(510)+50;
	while(food4.x%10!=0){
		food4.x++;
	}
	food4.y=random(340)+80;
	while(food4.y%10!=0){
		food4.y++;	//防止出现不是为10的倍数的坐标
	}
	food4.yes=1;//这样食物为1 的话就不会产生新的食物
	}
	setcolor(random(13)+1);
	rectangle(food4.x,food4.y,food4.x+10,food4.y+10);//解决蛇会磨食物的边
}	

//分数
void shuangfen(){
	//文本
	char a[50];
	char b[50];
	int fen;//控制分数随等级增长
	if(x==1){
		fen=40;
	}
	if(x==2){
		fen=80;
	}
	if(x==3){
		fen=120;
	}
	if(x==4){
		fen=160;
	}
	if(x==5){
		fen=200;
	}
	if(x==6){
		fen=240;
	}
	//封闭区域
	setfillstyle(3,7);
	bar(0,20,640,43);
	//文本大小
	settextstyle(0,0,3);
	setcolor(12);
	snake.level=snake.score/fen+x;
	snake2.level=snake2.score/fen+x;
	sprintf(a,"SCORE:%d",snake.score);
	outtextxy(100,20,a);
	sprintf(b,"SCORE:%d",snake2.score);
	outtextxy(360,20,b);	
}
//死亡
void jieshu2(){
	//定义
	char a[50]="GAME OVER!!";
	char b[50];
	char c[50];
	//清屏
	system("cls");
	//背景颜色 和图形颜色
	setbkcolor(0);
	setcolor(YELLOW);
	//图形大小
	settextstyle(0,0,3);
	//内容
	outtextxy(150,100,a);
	settextstyle(0,0,3);
	setcolor(12);
	if(snake.score>snake2.score){
		sprintf(c,"WINNER:PLAYER2");
		outtextxy(150,185,c);
		sprintf(b,"LEVEL:%d SCORE:%d",snake.level,snake.score);
		outtextxy(150,270,b);
	}else if(snake2.score>snake.score){
		sprintf(c,"WINNER:PLAYER1");
		outtextxy(150,185,c);
		sprintf(b,"LEVEL:%d SCORE:%d",snake2.level,snake2.score);
		outtextxy(150,270,b);
	}else{
		sprintf(c,"A DEAD HEAT");
		outtextxy(150,185,c);
	}
	
}
//通关
void pass(){
	//清屏
	system("cls");
	//背景颜色	
	setbkcolor(0);
	//图形颜色
	setcolor(YELLOW);
	//图形大小
	settextstyle(0,0,4);
	//内容
	outtextxy(190,160,"VITORY!!");
	settextstyle(0,0,2);
	outtextxy(170,215,"Congratulations on ");
	outtextxy(135,245,"yours customs clearance!!");	
}
