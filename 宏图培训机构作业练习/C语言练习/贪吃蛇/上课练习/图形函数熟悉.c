#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
void main(){
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");
	setbkcolor(WHITE);
	setcolor(1);
	//画点
	putpixel(300,300,BLUE);
	//获取点的颜色值
	printf("%d\n",getpixel(300,300));

	//屏幕大小
	printf("%d %d",getmaxx(),getmaxy());
	
	//画圆
	circle(400,200,20);
	//画弧形
	setcolor(4);//可以设置新的颜色
	arc(300,300,0,80,30);
	//椭圆
	setlinestyle(1,0,2);//放前面才有用，线型函数
	ellipse(200,150,0,360,50,20);
	//三维图形
	bar3d(150,150,200,200,170,120);
	
	//矩形
	rectangle(500,120,230,340);
	getch();
	closegraph();
}