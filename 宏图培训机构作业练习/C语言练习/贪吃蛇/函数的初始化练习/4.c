#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
void main(){
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");	
	setbkcolor(4);
	setcolor(3);
	
	getch();
	closegraph;
}