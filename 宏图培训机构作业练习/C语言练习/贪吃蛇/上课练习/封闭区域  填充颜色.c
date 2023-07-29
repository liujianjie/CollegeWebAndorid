#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
#include "time.h"
void main(){
	int x,y;
	char a[50]="LEVEL:1 SCORE:10";
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");
	
	setbkcolor(15);
	setcolor(2);
	
	settextstyle(0,0,3);
	setfillstyle(3,4);
	bar(1,1,640,80);
	outtextxy(0,0,a);
	
	randomize();
	x=random(630);
	y=random(390)+80;
	rectangle(x,y,x+10,y+10);
	
	getch();
	
	closegraph();
}