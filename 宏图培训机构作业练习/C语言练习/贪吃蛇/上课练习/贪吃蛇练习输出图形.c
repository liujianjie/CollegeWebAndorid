#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
void main(){
	char ch[50]="LEVEL:1 SCORE:10";
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");
	settextstyle(0,0,3);
	//������ɫ
	setbkcolor(15);
	//�ı���ɫ
	setcolor(2);
	//�ı���
	sprintf(ch,"LEVEL:%d SCORE:%d",0,0);
	outtextxy(0,0,ch);
	setcolor(6);
	//�������������
	setlinestyle(0,0,3);//���ͺ���
	rectangle(100,100,120,120);//һ������
	setfillstyle(3,4);//���������ʽ
	bar(100,100,120,120);
	
	rectangle(120,100,140,120);//һ������
	setfillstyle(4,5);//���������ʽ
	bar(120,100,140,120);
	//������
	line(140,100,160,110);
	line(160,110,140,120);
	
	//������������μ� Բ��
	setlinestyle(0,0,3);//���ͺ���
	rectangle(200,200,220,220);//һ������
	setfillstyle(3,4);//���������ʽ
	bar(200,200,220,220);
	
	rectangle(220,200,240,220);//һ������
	setfillstyle(4,5);//���������ʽ
	bar(220,200,240,220);
	
	circle(250,210,10);//Բ

	//��ͣ
	getch();
	//��������
	closegraph();
}