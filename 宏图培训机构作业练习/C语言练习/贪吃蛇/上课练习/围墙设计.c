#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
void main(){
	char a[50]="LEVEL:1 SCORE:10";//文字内容
	int i;
	//函数初始化
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");
	//文本字体大小
	settextstyle(0,0,3);//必须前面
	//背景颜色
	setbkcolor(BLACK);
	//图形颜色
	setcolor(12);
	//文本输出  
	setfillstyle(3,7);  
	bar(0,0,380,20);//封闭区域的大小          
	outtextxy(0,0,a);
	//围墙 3青色
	setcolor(3);
	//线型函数大小
	setlinestyle(0,0,3);
	//循环上面的围墙	
	for(i=0;i<=625;i+=15){
		rectangle(0+i,25,15+i,40);	
	}
	for(i=0;i<=440;i+=15){
		rectangle(0,25+i,15,40+i);//左边
	}
	for(i=0;i<625;i+=15){
		rectangle(0+i,460,15+i,475);//下面	
	}
	for(i=0;i<=440;i+=15){
		rectangle(616,25+i,631,40+i);//右边
	}
	getch();
	closegraph();
}