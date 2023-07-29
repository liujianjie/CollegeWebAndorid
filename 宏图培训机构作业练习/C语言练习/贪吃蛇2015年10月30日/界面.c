#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
#include "time.h"
#define ESC 283
#define r_1 561//主菜单的第一个
#define r_2 818//主菜单的第二个
#define r_3 1075//主菜单的第三个
#define r_4	1332//主菜单的第四个
#define r_5	1589//主菜单的第五个
#define r_6	1846//主菜单的第六个
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
	//背景颜色
	setbkcolor(6);
	
}
void mowei(){
	getch();
	closegraph();//结束函数
}
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
		setcolor(3);//选择项的颜色同样
		outtextxy(150,170,"1 . LEVEL 1");//输出的图形
		outtextxy(150,220,"2 . LEVEL 2");
		outtextxy(150,270,"3 . LEVEL 3");
		outtextxy(150,320,"4 . LEVEL 4");
		outtextxy(150,370,"5 . LEVEL 5");
		
	//输入的数来选择
	//key=bioskey(0);
	
}
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
		setcolor(3);//选择项的颜色同样
		outtextxy(150,170,"1 . LEVEL 1");//输出的图形
		outtextxy(150,220,"2 . LEVEL 2");
		outtextxy(150,270,"3 . LEVEL 3");
		outtextxy(150,320,"4 . LEVEL 4");
		outtextxy(150,370,"5 . LEVEL 5");
		
	//输入的数来选择
	//key=bioskey(0);	
}
void rootmenu3(){
		settextstyle(0,0,6);
		setcolor(5);
		outtextxy(200,70,"a");	
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
}
void rootmenu5(){
		settextstyle(0,0,6);
		setcolor(5);
		outtextxy(200,70,"a");	
}
void rootmenu6(){
	return;
}