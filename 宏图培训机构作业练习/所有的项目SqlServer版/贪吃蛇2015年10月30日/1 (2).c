#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
#include "time.h"
#define N 200//����
#define UP 18432
#define DOWN 20480
#define LEFT 19200
#define RIGHT 19712
#define ESC 283
#define	W 4471
#define	S 8051
#define	A 7777
#define D 8292
#define KONGGE 14624
struct snake{
	int x[N];
	int y[N];
	int life;
	int node;
	int direction;
	int score;
	int level;
}snake;
//ʳ��
struct food{
	int x;
	int y;
	int yes;
}food,food1;
void she();//��
void shiwu();//ʳ��
void shiwu2();//����ʳ��
void wenben();//����
void draw(int type);//Χǽ
void jieshu();//��Ϸʧ��
void tongguan();//��Ϸͨ��
void main(){
	//ͼ�κ�����ʼ��
	int gdriver=DETECT,gmode;
	initgraph(&gdriver,&gmode,"");
	setbkcolor(15);

	draw(0);
	she();
	//��������
	closegraph();
}
void she(){
	//��ʼ��
	int i;
	int key;//�����������Ҫ�Ĵ���
	int count=0;//��ʳ��ļ���
	int state=0;//����ǽ��һ��
	int state2=0;
	int speed=25000;//�ٶȿ����� 
	//��ʼ��
	snake.x[0]=260;	
	snake.y[0]=180;
	snake.x[1]=250;	
	snake.y[1]=180;
	snake.life=1;
	snake.node=2;
	snake.direction=1;
	//ʳ������Ȳ���
	food.yes=0;
	food1.yes=0;
	wenben();
	while(snake.life){
	   while(!kbhit()){//ʵ��ÿ��������Ҳ������
		shiwu();
		//����������Է�ֹ�Ա�����ˢ����ʳ��
		if(count==2){
			//��������ʳ��
			shiwu2();
			//����ʳ��ҲҪ
		if(food1.x>139 &&food1.x<269 &&food1.y>56 &&food1.y<229 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>379 &&food1.x<509 &&food1.y>56 &&food1.y<229 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>29 &&food1.x<129 &&food1.y>259 &&food1.y<452 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>259 &&food1.x<389 &&food1.y>259 &&food1.y<452 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>509 &&food1.x<609 &&food1.y>259 &&food1.y<452 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		}
		//������Ҫ�õ� ���ʳ������������� �����³���ʳ�� ���ߵķ�Χ���ƹ�������
		if(food.x>139 &&food.x<269 &&food.y>56 &&food.y<229 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>379 &&food.x<509 &&food.y>56 &&food.y<229 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>29 &&food.x<129 &&food.y>259 &&food.y<452 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>259 &&food.x<389 &&food.y>259 &&food.y<452 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>509 &&food.x<609 &&food.y>259 &&food.y<452 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		//��Ҫ����
		setlinestyle(0,0,3);//�ߺ�ʳ���Ⱥ�������ʽ
		for(i=snake.node-1;i>0;i--){
			snake.x[i]=snake.x[i-1];
			snake.y[i]=snake.y[i-1];//�ߵ����긳����һ��
		}
		//��Խ�߽� ����ͷ������任����
 		
		if(snake.x[0]<10){//����
			snake.x[0]=630;
		}
		if(snake.x[0]>630){
			snake.x[0]=10;
		}
		if(snake.y[0]<47){//����
			snake.y[0]=470;
		}
		if(snake.y[0]>470){
			snake.y[0]=47;
		}
			//snake.x[0]=snake.x[0]+10;�ߵ�ͷ��ǰ��
		switch(snake.direction){
			case 1:
				snake.x[0]+=10;//����
				break;
			case 2:
				snake.x[0]-=10;//����
				break;
			case 3:
				snake.y[0]-=10;//����
				break;
			case 4:
				snake.y[0]+=10;//����
				break;
		}
		//ײǽ���Ƶ�����ȼ��ؿ���
		//ҧ�Լ�
		for(i=3;i<snake.node;i++){
				if(snake.x[0]==snake.x[i]&&snake.y[0]==snake.y[i]){
					snake.life=0;
				}
		}
		if(snake.life==0){
			jieshu();
			break;
		}
			//�ߵ�����//����Ҫ����ɫ
			setlinestyle(0,0,3);//���
			setcolor(4);
		for(i=0;i<snake.node;i++){
			rectangle(snake.x[i],snake.y[i],snake.x[i]+10,snake.y[i]+10);	
		}

			//ѭ����ǽ�����ǽ�����ӳٻ���Ӱ��ֻ�����԰�Χǽ��С�㵫����ǽ�ķ�Χ����
			delay(speed);//�����ӳ�
			setlinestyle(0,0,3);//����ĩβ��Ⱥ�������ʽ
			setcolor(15);//�����ɫ
			//ȥ��β���Ľ���
			rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		//��ʳ��
		if(snake.x[0]==food.x&&snake.y[0]==food.y){
			snake.node++;
			food.yes=0;//���¸�ʳ�����
			snake.score+=10;
			wenben();
			count++;//�ۼ�
			if(count>2){//�����Ե����������� count���ǵ���2
				count=2;
			}
		}
		//������ʳ�� ��Ϊ������ʳ���߽�-1 Ҫ���������Ľ�ȥ�� ������Ӱ���߶���ȥ�����һ�� ����ֻ��������
		if(snake.x[0]==food1.x&&snake.y[0]==food1.y){
			snake.node--;
			food1.yes=0;//���¸�ʳ�����
			snake.score+=20;
			snake.level=snake.score/100+1;
			wenben();//������ӡ
			count=0;//��ʼֵ
			speed-=8000;//���ٶ�
			setcolor(15);
			rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		}
		
		//�ؿ�
		if(snake.level==1){//�ȼ�1
			//ײǽ
			if(snake.x[0]<30||snake.x[0]>600||snake.y[0]<60||snake.y[0]>440){
			snake.life=0;
			//���ߵ�����Ϊ0�Ͳ���ѭ����һ��ֱ������
			//�����ȵ������ڶ���whileѭ��ֱ������,�������жϾͲ�����
			}
		}
		else if(snake.level==2){//�ȼ�2
			//��һ���ǽ
			 if(state==0){
				draw(1);
				state=1;
			 }
			 speed=25000;
		}
		else if(snake.level==3){//�ȼ�3
			if(state2==0){
				draw(0);
				state2=1;
			}
			//ײǽ�� ��Ϊ������һ��ǽ ����Ҫ�ж�
			if(snake.x[0]<30||snake.x[0]>600||snake.y[0]<60||snake.y[0]>440){
			snake.life=0;
			}
			//��ǽ ������ ��Ϊ��main�������Ѿ����� �ڵȼ�2��û����Ҫ�ǻ��˰�ǽ
			//�ϰ���
			setfillstyle(1,7);
			bar(140,57,270,230);//��һ���ϰ�
			bar(380,57,510,230);//�ڶ����ϰ�
			bar(30,260,130,453);//�������ϰ�
			bar(260,260,390,453);//���ĸ��ϰ�
			bar(510,260,610,453);//������ϰ�
			//ײ�ϰ��� �� ��Χ�����Լ������� ��һ���һ
			/*���ӣ�����Ҫ ��-1 if(snake.x[0]>191 &&snake.x[0]<349 &&snake.y[0]>191 &&snake.y[0]<249 ){bar(200,200,350,250);
				snake.life=0;
				
			}*/
			if(snake.x[0]>139 &&snake.x[0]<269 &&snake.y[0]>56 &&snake.y[0]<229 ){
			snake.life=0;
			}
			if(snake.x[0]>379 &&snake.x[0]<509 &&snake.y[0]>56 &&snake.y[0]<229 ){
			snake.life=0;
			}
			if(snake.x[0]>29 &&snake.x[0]<129 &&snake.y[0]>259 &&snake.y[0]<452 ){
			snake.life=0;
			}
			if(snake.x[0]>259 &&snake.x[0]<389 &&snake.y[0]>259 &&snake.y[0]<452 ){
			snake.life=0;
			}
			if(snake.x[0]>509 &&snake.x[0]<609 &&snake.y[0]>259 &&snake.y[0]<452 ){
			snake.life=0;
			}
		}
		else{//ͨ��
			tongguan();
			snake.life=0;
			break;
			
		}
	}
	key=bioskey(0);
	if(key==ESC){
		break;
	}
	else if(key==KONGGE){
		//�ٻ�һ���߸���ԭ������
		setcolor(RED);
		for(i=0;i<snake.node;i++){
		rectangle(snake.x[i],snake.y[i],snake.x[i]+10,snake.y[i]+10);	
		}
		getch();//��ͣ���м� ��˼�� ��ͣ �ͻ���һ���� ��ʼ�Ϳ�ʼ��β
		//ȥ��β���Ľ���
		setcolor(15);
		rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
	}
	else if(key==RIGHT&&snake.direction!=2){
		snake.direction=1;
	}else if(key==LEFT&&snake.direction!=1){
		snake.direction=2;
	}else if(key==UP&&snake.direction!=4){
		snake.direction=3;
	}else if(key==DOWN&&snake.direction!=3){
		snake.direction=4;
	}
	}
}

void shiwu(){
	if(food.yes==0){
	randomize();	
	food.x=random(570)+30;
	while(food.x%10!=0){
		food.x++;
	}
	food.y=random(380)+60;
	while(food.y%10!=0){
		food.y++;	//��ֹ���ֲ���Ϊ10�ı���������
	}
	food.yes=1;//����ʳ��Ϊ1 �Ļ��Ͳ�������µ�ʳ��
	}
	setcolor(GREEN);
	rectangle(food.x,food.y,food.x+10,food.y+10);//����߻�ĥʳ��ı�
}
void shiwu2(){
	int i;
	if(food1.yes==0){
	randomize();	
	food1.x=random(520)+50;
	while(food1.x%10!=0){
		food1.x++;
	}
	food1.y=random(350)+80;
	while(food1.y%10!=0){
		food1.y++;	//��ֹ���ֲ���Ϊ10�ı���������
	}
	food1.yes=1;//����ʳ��Ϊ1 �Ļ��Ͳ�������µ�ʳ��
	}
	setcolor(random(14)+1);
	rectangle(food1.x,food1.y,food1.x+10,food1.y+10);//����߻�ĥʳ��ı�
}

void wenben(){
	//�ı�
	char a[50];
	//�������
	setfillstyle(3,7);
	bar(110,20,510,43);
	//�ı���С
	settextstyle(0,0,3);
	setcolor(12);
	snake.level=snake.score/20+2;//�Ѽ�������ķ�������Է�ֹһ��ʼ�ȼ�Ϊ0
	sprintf(a,"LEVEL:%d SCORE:%d",snake.level,snake.score);
	outtextxy(130,20,a);
}
void draw(int type){
	int i,j=1;
	setlinestyle(1,0,3);//��Ⱥ�������ʽ
	//ѭ�����Χǽ
	for(i=20;i<620;i+=10){
		//Χǽ��ɫ(��ɫ)
		if(j>13){
		j=1;
		}
		setcolor(j);
		j++;
		if(type==0){
			delay(2500);	
		}
		rectangle(i,47,i+10,57);//�Ϻ��µ�Χǽ Ϊ�˱����ǽ ֻ�ܱ䷶Χ
		rectangle(i,453,i+10,463);
		//�ȼ�Ϊ2�Ĺؿ� ��ԭ����ǽ����
		if(type==1){
			setcolor(15);
			rectangle(i,47,i+10,57);//����
			rectangle(i,453,i+10,463);
		}
		
	}
	for(i=50;i<460;i+=10){
		//Χǽ��ɫ(��ɫ)
		if(j>13){
		j=1;
		}
		setcolor(j);
		j++;
		if(type==0){
			delay(2000);	
		}
		rectangle(17,i,27,i+10);//����ҵ�Χǽ
		rectangle(613,i,623,i+10);
		//�ȼ�Ϊ2�Ĺؿ� ��ԭ����ǽ����
		if(type==1){
			setcolor(15);
			rectangle(17,i,27,i+10);//����ҵ�Χǽ
			rectangle(613,i,623,i+10);
		}
	}
}

void jieshu(){
	//����
	char a[50]="GAME OVER!!";
	char b[50];
	//����
	system("cls");
	//������ɫ ��ͼ����ɫ
	setbkcolor(1);
	setcolor(YELLOW);
	//ͼ�δ�С
	settextstyle(0,0,3);
	//����
	outtextxy(150,150,a);
	settextstyle(0,0,3);
	sprintf(b,"LEVEL:%d SCORE:%d",snake.level,snake.score);
	outtextxy(150,270,b);
}

void tongguan(){
	//����
	system("cls");
	//������ɫ	
	setbkcolor(15);
	//ͼ����ɫ
	setcolor(4);
	//ͼ�δ�С
	settextstyle(0,0,4);
	//����
	outtextxy(200,180,"VITORY!!");
	settextstyle(0,0,2);
	outtextxy(10,230,"Congratulations on your customs clearance");
}