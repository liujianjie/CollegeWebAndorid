#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
void main(){
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");
	setbkcolor(WHITE);
	setcolor(1);
	//����
	putpixel(300,300,BLUE);
	//��ȡ�����ɫֵ
	printf("%d\n",getpixel(300,300));

	//��Ļ��С
	printf("%d %d",getmaxx(),getmaxy());
	
	//��Բ
	circle(400,200,20);
	//������
	setcolor(4);//���������µ���ɫ
	arc(300,300,0,80,30);
	//��Բ
	setlinestyle(1,0,2);//��ǰ������ã����ͺ���
	ellipse(200,150,0,360,50,20);
	//��άͼ��
	bar3d(150,150,200,200,170,120);
	
	//����
	rectangle(500,120,230,340);
	getch();
	closegraph();
}