#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
void main(){
	char a[50]="LEVEL:1 SCORE:10";//��������
	int i;
	//������ʼ��
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");
	//�ı������С
	settextstyle(0,0,3);//����ǰ��
	//������ɫ
	setbkcolor(BLACK);
	//ͼ����ɫ
	setcolor(12);
	//�ı����  
	setfillstyle(3,7);  
	bar(0,0,380,20);//�������Ĵ�С          
	outtextxy(0,0,a);
	//Χǽ 3��ɫ
	setcolor(3);
	//���ͺ�����С
	setlinestyle(0,0,3);
	//ѭ�������Χǽ	
	for(i=0;i<=625;i+=15){
		rectangle(0+i,25,15+i,40);	
	}
	for(i=0;i<=440;i+=15){
		rectangle(0,25+i,15,40+i);//���
	}
	for(i=0;i<625;i+=15){
		rectangle(0+i,460,15+i,475);//����	
	}
	for(i=0;i<=440;i+=15){
		rectangle(616,25+i,631,40+i);//�ұ�
	}
	getch();
	closegraph();
}