#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
#include "time.h"
#define ESC 283
#define r_1 561//���˵��ĵ�һ��
#define r_2 818//���˵��ĵڶ���
#define r_3 1075//���˵��ĵ�����
#define r_4	1332//���˵��ĵ��ĸ�
#define r_5	1589//���˵��ĵ����
#define r_6	1846//���˵��ĵ�����
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
		while(!kbhit()){//��ֹû���̵ļ�ֵ���벻��
			if(i=13){
				i=1;
			}
			//�����������ͷ����ɫ
			setcolor(random(14)+1);
			//�ӳ�
			delay(40000);
			//ͷ��
			settextstyle(0,0,6);
			outtextxy(200,70,a);
			//����
			setcolor(1);
			settextstyle(0,0,3);
			outtextxy(150,170,b);
			outtextxy(150,220,c);
			outtextxy(150,270,d);
			outtextxy(150,320,e);
			outtextxy(150,370,f);
			outtextxy(150,420,g);
			//whileѭ������
			}
			//�˳�ѭ�� �������ǵȴ���ֵ���� ����Ҫ��!kbhit();û������Ҳ��Ĭ��ѭ�� һ��������˳�
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
	//�������
	randomize();
	//������ɫ
	setbkcolor(6);
	
}
void mowei(){
	getch();
	closegraph();//��������
}
void rootmenu1(){
	int key;
		//����
		system("cls");
		//ͼ�δ�С
		settextstyle(0,0,6);
		//������ɫ
		setbkcolor(7);
		//ͼ����ɫ
		setcolor(12);
		//ͷ��
		outtextxy(100,70,"LET'S GO!!");
		//��һ��ѡ��
		settextstyle(0,0,3);//ѡ�����ͼ�δ�С	
		setcolor(3);//ѡ�������ɫͬ��
		outtextxy(150,170,"1 . LEVEL 1");//�����ͼ��
		outtextxy(150,220,"2 . LEVEL 2");
		outtextxy(150,270,"3 . LEVEL 3");
		outtextxy(150,320,"4 . LEVEL 4");
		outtextxy(150,370,"5 . LEVEL 5");
		
	//���������ѡ��
	//key=bioskey(0);
	
}
void rootmenu2(){
	int key;
		//����
		system("cls");
		//ͼ�δ�С
		settextstyle(0,0,6);
		//������ɫ
		setbkcolor(7);
		//ͼ����ɫ
		setcolor(12);
		//ͷ��
		outtextxy(100,70,"LET'S GO!!");
		//��һ��ѡ��
		settextstyle(0,0,3);//ѡ�����ͼ�δ�С	
		setcolor(3);//ѡ�������ɫͬ��
		outtextxy(150,170,"1 . LEVEL 1");//�����ͼ��
		outtextxy(150,220,"2 . LEVEL 2");
		outtextxy(150,270,"3 . LEVEL 3");
		outtextxy(150,320,"4 . LEVEL 4");
		outtextxy(150,370,"5 . LEVEL 5");
		
	//���������ѡ��
	//key=bioskey(0);	
}
void rootmenu3(){
		settextstyle(0,0,6);
		setcolor(5);
		outtextxy(200,70,"a");	
}
void rootmenu4(){
	int key;
	//����
	system("cls");
	//ͼ�δ�С ������ɫ ͼ����ɫ
	setbkcolor(1);
	setcolor(15);
	//��Ҫ����
	settextstyle(0,0,3);
	outtextxy(150,30," ESC    Exit");
	outtextxy(150,80," SPACE  Pause");
	outtextxy(150,130," PLAY 1:");
	settextstyle(0,0,2);
	outtextxy(200,160,"��     Up");
	outtextxy(200,190,"��     Down");
	outtextxy(200,220,"��     Left");
	outtextxy(200,250,"��     Right");
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