#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
void main(){
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");
	
	
	getch();
	closegraph();
}