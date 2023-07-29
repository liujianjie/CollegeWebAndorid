#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
void main(){
	char ch[50]="LEVEL:1 SCORE:10";
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");
	settextstyle(0,0,3);
	//背景颜色
	setbkcolor(15);
	//文本颜色
	setcolor(2);
	//文本域
	sprintf(ch,"LEVEL:%d SCORE:%d",0,0);
	outtextxy(0,0,ch);
	setcolor(6);
	//封闭区域做矩形
	setlinestyle(0,0,3);//线型函数
	rectangle(100,100,120,120);//一个矩形
	setfillstyle(3,4);//封闭区域样式
	bar(100,100,120,120);
	
	rectangle(120,100,140,120);//一个矩形
	setfillstyle(4,5);//封闭区域样式
	bar(120,100,140,120);
	//三角形
	line(140,100,160,110);
	line(160,110,140,120);
	
	//封闭区域做矩形加 圆形
	setlinestyle(0,0,3);//线型函数
	rectangle(200,200,220,220);//一个矩形
	setfillstyle(3,4);//封闭区域样式
	bar(200,200,220,220);
	
	rectangle(220,200,240,220);//一个矩形
	setfillstyle(4,5);//封闭区域样式
	bar(220,200,240,220);
	
	circle(250,210,10);//圆

	//暂停
	getch();
	//结束函数
	closegraph();
}