#include "stdio.h"
#include "graphics.h"
#include "stdlib.h"
#include "time.h"
#define ESC 283
#define N 2000//����
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
#define r_1 561//���˵��ĵ�һ��
#define r_2 818//���˵��ĵڶ���
#define r_3 1075//���˵��ĵ�����
#define r_4	1332//���˵��ĵ��ĸ�
#define r_5	1589//���˵��ĵ����
#define r_6	1846//���˵��ĵ�����
#define r_7 2103//���˵��ĵ��߸�
//ȫ�ֱ���
int x;//���ܹؿ���ѡ��ı���
//ѡ��˵�����
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
//���н���
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
}food,food1,food5;
void she();//��
void shiwu();//ʳ��
void shiwu2();//����ʳ��
void wenben();//����
void draw(int type);//Χǽ
void jieshu();//��Ϸʧ��
void tongguan();//��Ϸͨ��
void wuqiong();//����ģʽ
void fengshu();//����ģʽ����
void shiwu5();//����ģʽʳ��
//˫��
struct snake2{
	int x[N];
	int y[N];
	int life;
	int node;
	int direction;
	int score;
	int level;
}snake2;
//ʳ��
struct food2{
	int x;
	int y;
	int yes;
}food3,food4;
void she2();
void shiwu3();
void shiwu4();
void jieshu2();
void shuangfen();
void pass();

//��ʼ
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
		//������ɫ
	setbkcolor(6);
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
	
}
void mowei(){
	
	closegraph();//��������
}
//�Ӳ˵�1
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
		setcolor(9);//ѡ�������ɫͬ��
		outtextxy(150,150,"1 . LEVEL 1");//�����ͼ��
		outtextxy(150,200,"2 . LEVEL 2");
		outtextxy(150,250,"3 . LEVEL 3");
		outtextxy(150,300,"4 . LEVEL 4");
		outtextxy(150,350,"5 . LEVEL 5");
		outtextxy(150,400,"6 . LEVEL 6");
		outtextxy(150,450,"7 . RETURN");
		
	//���������ѡ��ؿ�
	key=bioskey(0);
	switch(key){
		case r_1:
			x=1;
			system("cls");//����
			//������ı�����ɫ
			setbkcolor(15);
			//Χǽ
			draw(0);
			she();
			break;
		case r_2:
			x=2;
			system("cls");//����
			//������ı�����ɫ
			setbkcolor(15);
			//Χǽ ���� �ڵȼ���д��
			//draw(0);
			she();
			break;
		case r_3:
		    x=3;
			system("cls");//����
			//������ı�����ɫ
			setbkcolor(15);
			//Χǽ ���� �ٵȼ���д��
			//draw(0);
			she();
			break;
		case r_4:
			x=4;
			system("cls");//����
			//������ı�����ɫ
			setbkcolor(15);
			//Χǽ ��Ҫ �ٵȼ���ûд �����û��Χǽ
			//draw(0);
			she();
			break;
		case r_5:
			x=5;
			system("cls");//����
			//������ı�����ɫ
			setbkcolor(15);
			//Χǽ ��Ҫ �ٵȼ���ûд �����û��Χǽ
			//draw(0);
			she();
			break;
		case r_6:
			x=6;
			system("cls");//����
			//������ı�����ɫ
			setbkcolor(15);
			//Χǽ ��Ҫ �ٵȼ���ûд �����û��Χǽ
			//draw(0);
			she();
			break;
		case r_7:
			//�������ٴδ����˵�
			system("cls");
			rootmenu();
			break;
		case ESC:
			//ֱ���˳�
			break;
	}	
	
}
//�Ӳ˵�2
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
		setcolor(9);//ѡ�������ɫͬ��
		outtextxy(150,150,"1 . LEVEL 1");//�����ͼ��
		outtextxy(150,200,"2 . LEVEL 2");
		outtextxy(150,250,"3 . LEVEL 3");
		outtextxy(150,300,"4 . LEVEL 4");
		outtextxy(150,350,"5 . LEVEL 5");
		outtextxy(150,400,"6 . LEVEL 6");
		outtextxy(150,450,"7 . RETURN");
		getch();
	//���������ѡ��
	key=bioskey(0);	
	switch(key){
		case r_1:
			x=1;
			system("cls");//����
			//������ı�����ɫ
			setbkcolor(15);
			//Χǽ
			draw(0);
			she2();
			break;
		case r_2:
			x=2;
			system("cls");//����
			//������ı�����ɫ
			setbkcolor(15);
			//Χǽ ���� �ڵȼ���д��
			//draw(0);
			she2();
			break;
		case r_3:
		    x=3;
			system("cls");//����
			//������ı�����ɫ
			setbkcolor(15);
			//Χǽ ���� �ٵȼ���д��
			//draw(0);
			she2();
			break;
		case r_4:
			x=4;
			system("cls");//����
			//������ı�����ɫ
			setbkcolor(15);
			//Χǽ ��Ҫ �ٵȼ���ûд �����û��Χǽ
			//draw(0);
			she2();
			break;
		case r_5:
			x=5;
			system("cls");//����
			//������ı�����ɫ
			setbkcolor(15);
			//Χǽ ��Ҫ �ٵȼ���ûд �����û��Χǽ
			//draw(0);
			she2();
			break;
		case r_6:
			x=6;
			system("cls");//����
			//������ı�����ɫ
			setbkcolor(15);
			//Χǽ ��Ҫ �ٵȼ���ûд �����û��Χǽ
			//draw(0);
			she2();
			break;
		case r_7:
			//�������ٴδ����˵�
			system("cls");
			rootmenu();
			break;
		case ESC:
			//ֱ���˳�
			break;
	}
}
//ֱ������ �ȼ�Ϊ2 ��ģʽ
void rootmenu3(){
		system("cls");
		wuqiong();
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
	key=bioskey(0);
	if(key==ESC){
		system("cls");
		rootmenu();
	}
}
void rootmenu5(){
	int key;
	system("cls");
	setbkcolor(8);
	setcolor(10);
	settextstyle(0,0,2);
	outtextxy(100,80,"GAMENAME: Gluttonous Snake");
	outtextxy(100,110,"developer: Jian-Jie Liu");
	outtextxy(100,140,"date: On October 30, 2015");
	outtextxy(100,170,"E-mial: 1219277604@qq.com");
	outtextxy(100,200,"QQ: 121927604");
	outtextxy(100,230,"telephone: 18070367115");
	outtextxy(100,280,"PS: Please contact me if ");
	outtextxy(100,310,"you have any questions,");
	outtextxy(100,340,"I would be happy to assist");
	outtextxy(100,370,"in any way I can.");
	key=bioskey(0);
	if(key==ESC){
		system("cls");
		rootmenu();
	}
}
void rootmenu6(){
	return;
}
void she(){
	//��ʼ��
	int i;
	int key;//�����������Ҫ�Ĵ���
	int count=0;//��ʳ��ļ���
	int state=0;//����ǽ��һ��
	int state2=0;
	int state3=0;
	int state4=0;
	int speed=24000;//�ٶȿ����� 
	//��ʼ��
	snake.x[0]=60;	
	snake.y[0]=70;
	snake.x[1]=50;	
	snake.y[1]=60;
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
			//����ʳ��ҲҪ ������Ҫ�װ����ߵ����������ڵľ���
			//������
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
		//���Ĺ�����ʳ��������ϰ���������ˢ�²�ȥ��
		if(food1.x>0 &&food1.x<639 &&food1.y>244 &&food1.y<254){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>314 &&food1.x<324 &&food1.y>46 &&food1.y<479){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		//��5������ʳ�ﲻ�ܳ������ϰ��� ���� ��ȥ���ð�ǽ
		if(food1.x>209 &&food1.x<219 &&food1.y>46 &&food1.y<219 ){//�����ϰ�
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>409 &&food1.x<419 &&food1.y>46 &&food1.y<219 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>209 &&food1.x<219 &&food1.y>309 &&food1.y<469 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>409 &&food1.x<309 &&food1.y>419 &&food1.y<469 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>0 &&food1.x<219 &&food1.y>209 &&food1.y<219 ){//����ϰ�
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>409 &&food1.x<639 &&food1.y>209 &&food1.y<319 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>0 &&food1.x<219 &&food1.y>309 &&food1.y<319 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>409 &&food1.x<639 &&food1.y>309 &&food1.y<249 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		}
		//������Ҫ�õ� ���ʳ������������� �����³���ʳ�� ���ߵķ�Χ���ƹ������в�����Ҫ�װ����ߵ����������ڵľ���
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
		//���Ĺ�ʳ��������ϰ���������ˢ�²�ȥ��
		if(food.x>314 &&food.x<324 &&food.y>46 &&food.y<479){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>0 &&food.x<639 &&food.y>244 &&food.y<254){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		//��5��ʳ�ﲻ�ܳ������ϰ��� ���� ��ȥ���ð�ǽ
		if(food.x>209 &&food.x<219 &&food.y>46 &&food.y<219 ){//�����ϰ�
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>409 &&food.x<419 &&food.y>46 &&food.y<219 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>209 &&food.x<219 &&food.y>309 &&food.y<469 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>409 &&food.x<309 &&food.y>419 &&food.y<469 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>0 &&food.x<219 &&food.y>209 &&food.y<219 ){//����ϰ�
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>409 &&food.x<639 &&food.y>209 &&food.y<319 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>0 &&food.x<219 &&food.y>309 &&food.y<319 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>409 &&food.x<639 &&food.y>309 &&food.y<249 ){
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
		if(snake.y[0]<57){//����
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
		
		//���ߵ�����//����Ҫ����ɫ
		setlinestyle(0,0,3);//���
		setcolor(4);
		for(i=0;i<snake.node;i++){
			rectangle(snake.x[i],snake.y[i],snake.x[i]+10,snake.y[i]+10);	
		}
		
		//�߶�����
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
			//�ӳ���Сֵ
			if(speed==8000){
				speed=8000;
			}else{
				speed-=8000;//���ٶ�
			}
			//ȥ��������ʳ�����������ǽ�
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
				//�ڶ��صĳ�ʼ�ٶ� 1�����
				speed=24000;
				delay(24000);//�ӳ�1��
			 }
			 
		}
		else if(snake.level==3){//�ȼ�3
			
			//��һ��֮ǰ��ǽˢ����ǽ
			if(state2==0){
				draw(2);
				state2=1;
				//��ʼ�ٶ� 1�����
				speed=24000;
				delay(50000);//�ӳ�1��
			}
			//ײǽ�� ��Ϊ������ǽ ����Ҫ�ж�
			if(snake.x[0]<30||snake.x[0]>600||snake.y[0]<60||snake.y[0]>440){
			snake.life=0;
			}
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
		else if(snake.level==4){
			if(state3==0){
				system("cls");
				state3=1;
				wenben();
				//��ʼ�ٶ� 1�����
				speed=24000;
				delay(50000);//�ӳ�1��
			}
			setbkcolor(15);
			
			//�ϰ���
			setfillstyle(7,8);
			bar(315,47,325,480);
			setfillstyle(7,8);
			bar(0,245,640,255);
			//��ͷ���ϰ�����
			if(snake.x[0]>314 &&snake.x[0]<324 &&snake.y[0]>46 &&snake.y[0]<479){
				snake.life=0;
			}
			if(snake.x[0]>0 &&snake.x[0]<639 &&snake.y[0]>244 &&snake.y[0]<254){
				snake.life=0;
			}
			
		}
		else if(snake.level==5){
			if(state4==0){
				system("cls");
				state4=1;
				wenben();
				//��ʼ�ٶ� 1�����
				speed=24000;
				delay(50000);//�ӳ�1��
			}
			setbkcolor(15);
			//�ϰ���
			setfillstyle(7,8);
			bar(210,47,220,220);//�����ϰ�
			bar(410,47,420,220);
			bar(210,310,220,470);
			bar(410,310,420,470);
			
			bar(0,210,220,220);//����ϰ�
			bar(410,210,640,220);
			bar(0,310,220,320);
			bar(410,310,640,320);
			//�ж� ��ͷ����ײ��
			if(snake.x[0]>209 &&snake.x[0]<219 &&snake.y[0]>46 &&snake.y[0]<219 ){//�����ϰ�
				snake.life=0;
			}
			if(snake.x[0]>409 &&snake.x[0]<419 &&snake.y[0]>46 &&snake.y[0]<219 ){
				snake.life=0;
				
			}
			if(snake.x[0]>209 &&snake.x[0]<219 &&snake.y[0]>309 &&snake.y[0]<469 ){
				snake.life=0;
				
			}
			if(snake.x[0]>409 &&snake.x[0]<309 &&snake.y[0]>419 &&snake.y[0]<469 ){
				snake.life=0;
				
			}
			if(snake.x[0]>0 &&snake.x[0]<219 &&snake.y[0]>209 &&snake.y[0]<219 ){//����ϰ�
				snake.life=0;
				
			}
			if(snake.x[0]>409 &&snake.x[0]<639 &&snake.y[0]>209 &&snake.y[0]<319 ){
				snake.life=0;
				
			}
			if(snake.x[0]>0 &&snake.x[0]<219 &&snake.y[0]>309 &&snake.y[0]<319 ){
				snake.life=0;
				
			}
			if(snake.x[0]>409 &&snake.x[0]<639 &&snake.y[0]>309 &&snake.y[0]<249 ){
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
		//�����Ĵ��Ӳ˵� ����Ҫ�˳�
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
	//���������˵� ��������
	rootmenu1();
	snake.score=0;
}

void shiwu(){
	//�ж��Ƿ���Ҫ����ʳ��
	if(food.yes==0){
		//���������
		randomize();
		//0-639
		food.x=random(540)+30;
		//���ɵ�������Ҫ��10 �ı���(Ϊ�����߸�ʳ����һ������)
		while(food.x%10!=0){
			food.x++;
		}
		
		food.y=random(340)+70;
		while(food.y%10!=0){
			food.y++;
		}
		
		food.yes=1;//1��ʾ�Ѿ���ʳ����
	}
	setcolor(GREEN);
	rectangle(food.x,food.y,food.x+10,food.y+10);
}
void shiwu2(){
	//�ж��Ƿ���Ҫ����ʳ��
	if(food1.yes==0){
		//���������
		randomize();
		//0-639
		food1.x=random(510)+60;
		//���ɵ�������Ҫ��10 �ı���(Ϊ�����߸�ʳ����һ������)
		while(food1.x%10!=0){
			food1.x++;
		}
		
		food1.y=random(310)+100;
		while(food1.y%10!=0){
			food1.y++;
		}
		
		food1.yes=1;//1��ʾ�Ѿ���ʳ����
	}
	setcolor(random(13)+1);
	rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
}
void wenben(){
	//�ı�
	char a[50];
	int fen;//���Ʒ�����ȼ�����
	if(x==1){
		fen=40;
	}
	if(x==2){
		fen=80;
	}
	if(x==3){
		fen=120;
	}
	if(x==4){
		fen=160;
	}
	if(x==5){
		fen=200;
	}
	if(x==6){
		fen=240;
	}
	//�������
	setfillstyle(3,7);
	bar(110,20,510,43);
	//�ı���С
	settextstyle(0,0,3);
	setcolor(12);
	snake.level=snake.score/fen+x;//�Ѽ�������ķ�������Է�ֹһ��ʼ�ȼ�Ϊ0
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
		//��ǽ
		if(type==2){
			setcolor(8);
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
		//��ǽ
		if(type==2){
			setcolor(8);
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
	setbkcolor(0);
	setcolor(YELLOW);
	//ͼ�δ�С
	settextstyle(0,0,3);
	//����
	outtextxy(150,150,a);
	settextstyle(0,0,3);
	sprintf(b,"LEVEL:%d SCORE:%d",snake.level,snake.score);
	outtextxy(150,270,b);
}
//����ģʽ�ķ���

void tongguan(){
	//����
	system("cls");
	//������ɫ	
	setbkcolor(0);
	//ͼ����ɫ
	setcolor(YELLOW);
	//ͼ�δ�С
	settextstyle(0,0,4);
	//����
	outtextxy(190,160,"VITORY!!");
	settextstyle(0,0,2);
	outtextxy(170,215,"Congratulations on ");
	outtextxy(135,245,"your customs clearance!!");
}
//����
void wuqiong(){
	//��ʼ��
	int i;
	int key;//�����������Ҫ�Ĵ���
	int count=0;//��ʳ��ļ���
	int state=0;//����ǽ��һ��
	int speed=24000;//�ٶȿ����� 
	int o;//�����
	//��ʼ��
	snake.x[0]=260;	
	snake.y[0]=180;
	snake.x[1]=250;	
	snake.y[1]=180;
	snake.life=1;
	snake.node=2;
	snake.direction=1;
	snake.level=2;
	//ʳ������Ȳ���
	food.yes=0;
	food5.yes=0;
	fengshu();
	while(snake.life){
	   while(!kbhit()){//ʵ��ÿ��������Ҳ������
		shiwu();
		//����������Է�ֹ�Ա�����ˢ����ʳ��
		if(count==2){
			//��������ʳ��
			shiwu5();
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
		if(snake.y[0]<57){//����
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
		
		//���ߵ�����//����Ҫ����ɫ
		setlinestyle(0,0,3);//���
		setcolor(random(13)+1);
		for(i=0;i<snake.node;i++){
			rectangle(snake.x[i],snake.y[i],snake.x[i]+10,snake.y[i]+10);	
		}
		
		//�߶�����
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
			fengshu();
			count++;//�ۼ�
			if(count>2){//�����Ե����������� count���ǵ���2
				count=2;
			}
		}
		//������ʳ�� ��Ϊ������ʳ���߽�-1 Ҫ���������Ľ�ȥ�� ������Ӱ���߶���ȥ�����һ�� ����ֻ��������
		if(snake.x[0]>food5.x-20&&snake.y[0]>food5.y-20&&snake.x[0]<food5.x+20&&snake.y[0]<food5.y+20){
			o=random(3)+1;
			if(o==1){
				snake.score+=200;
				setfillstyle(1,15);
				bar(food5.x,food5.y,food5.x+20,food5.y+20);
				
			}
			else if(o==2){
				snake.node+=50;
				if(snake.node>=350){
					snake.node-=50;	
				}
				setfillstyle(1,15);
				bar(food5.x,food5.y,food5.x+20,food5.y+20);
			}
			else if(o==3){
				if(speed==8000){
					speed=8000;
				}else{
					speed-=8000;//���ٶ�
				}
				setfillstyle(1,15);
				bar(food5.x,food5.y,food5.x+20,food5.y+20);
			}
			else if(o==4){
				if(speed==8000){
					speed+=8000;
					
				}
				setfillstyle(1,15);
				bar(food5.x,food5.y,food5.x+20,food5.y+20);
			}
			food5.yes=0;//���¸�ʳ�����
			fengshu();//������ӡ
			count=0;//��ʼֵ
			//�ӳ���Сֵ
			
			//ȥ��������ʳ�����������ǽ�
			setcolor(15);
			rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		}
		
		//�ؿ�
		 if(snake.level==2){//�ȼ�2
		
			//��һ���ǽ
			 if(state==0){
			 	setbkcolor(15);
				draw(1);
				state=1;
				//�ڶ��صĳ�ʼ�ٶ� 1�����
				speed=24000;
				delay(50000);//�ӳ�1��
			 }
			 
		}
	}
	key=bioskey(0);
	if(key==ESC){
		//�����Ĵ��Ӳ˵� ����Ҫ�˳�
		
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
	//���������˵� Ҫ����
	system("cls");
	rootmenu();
	
}
//�������
void fengshu(){
	//�ı�
	char a[50];
	//�������
	setfillstyle(3,7);
	bar(0,20,640,43);
	//�ı���С
	settextstyle(0,0,3);
	setcolor(12);
	sprintf(a,"SCORE:%d",snake.score);
	outtextxy(225,20,a);
}
//����ʳ��
void shiwu5(){
	int i;
	if(food5.yes==0){
	randomize();	
	food5.x=random(520)+50;
	while(food5.x%10!=0){
		food5.x++;
	}
	food5.y=random(350)+80;
	while(food5.y%10!=0){
		food5.y++;	//��ֹ���ֲ���Ϊ10�ı���������
	}
	food5.yes=1;//����ʳ��Ϊ1 �Ļ��Ͳ�������µ�ʳ��
	}
	setfillstyle(1,random(14)+1);
	bar(food5.x,food5.y,food5.x+20,food5.y+20);//����߻�ĥʳ��ı�	
	
	
}
//˫��
void she2(){
	//��ʼ��
	int i;
	int key;//�����������Ҫ�Ĵ���
	int count=0;//��ʳ��ļ���
	int count2=0;//��
	int state=0;//����ǽ��һ��
	int state2=0;
	int state3=0;
	int state4=0;
	int speed=24000;//�ٶȿ����� 
	int speed2=24000;//��
	//��ʼ��
	snake.x[0]=60;//��һ����	
	snake.y[0]=70;
	snake.x[1]=50;	
	snake.y[1]=60;
	snake.life=1;
	snake.node=2;
	snake.direction=1;//Ĭ������
	snake2.x[0]=450;//�ڶ�����
	snake2.y[0]=430;
	snake2.x[1]=460;
	snake2.y[1]=440;
	snake2.direction=2;//Ĭ������
	snake2.node=2;
	snake2.life=1;
	//ʳ������Ȳ���
	food.yes=0;
	food1.yes=0;
	food3.yes=0;
	food4.yes=0;
	shuangfen();
	while(snake.life&&snake2.life){
	   while(!kbhit()){//ʵ��ÿ��������Ҳ������
		shiwu();
		shiwu3();
		//����������Է�ֹ�Ա�����ˢ����ʳ��
		if(count==2){
			//��������ʳ��
			shiwu2();
			//����ʳ��ҲҪ ������Ҫ�װ����ߵ����������ڵľ���
			//������
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
		//���Ĺ�����ʳ��������ϰ���������ˢ�²�ȥ��
		if(food1.x>0 &&food1.x<639 &&food1.y>244 &&food1.y<254){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>314 &&food1.x<324 &&food1.y>46 &&food1.y<479){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		//��5������ʳ�ﲻ�ܳ������ϰ��� ���� ��ȥ���ð�ǽ
		if(food1.x>209 &&food1.x<219 &&food1.y>46 &&food1.y<219 ){//�����ϰ�
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
		}
		if(food1.x>409 &&food1.x<419 &&food1.y>46 &&food1.y<219 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>209 &&food1.x<219 &&food1.y>309 &&food1.y<469 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>409 &&food1.x<309 &&food1.y>419 &&food1.y<469 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>0 &&food1.x<219 &&food1.y>209 &&food1.y<219 ){//����ϰ�
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>409 &&food1.x<639 &&food1.y>209 &&food1.y<319 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>0 &&food1.x<219 &&food1.y>309 &&food1.y<319 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		if(food1.x>409 &&food1.x<639 &&food1.y>309 &&food1.y<249 ){
			setcolor(15);
			rectangle(food1.x,food1.y,food1.x+10,food1.y+10);
			food1.yes=0;
			
		}
		}
		if(count2==2){
			shiwu4();
			//��
		//������Ҫ�õ� ���ʳ������������� �����³���ʳ�� ���ߵķ�Χ���ƹ������в�����Ҫ�װ����ߵ����������ڵľ���
		if(food4.x>139 &&food4.x<269 &&food4.y>56 &&food4.y<229 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		if(food4.x>379 &&food4.x<509 &&food4.y>56 &&food4.y<229 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		if(food4.x>29 &&food4.x<129 &&food4.y>259 &&food4.y<452 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		if(food4.x>259 &&food4.x<389 &&food4.y>259 &&food4.y<452 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		if(food4.x>509 &&food4.x<609 &&food4.y>259 &&food4.y<452 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		//���Ĺ�ʳ��������ϰ���������ˢ�²�ȥ��
		if(food4.x>314 &&food4.x<324 &&food4.y>46 &&food4.y<479){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		if(food4.x>0 &&food4.x<639 &&food4.y>244 &&food4.y<254){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		//��5��ʳ�ﲻ�ܳ������ϰ��� ���� ��ȥ���ð�ǽ
		if(food4.x>209 &&food4.x<219 &&food4.y>46 &&food4.y<219 ){//�����ϰ�
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
		}
		if(food4.x>409 &&food4.x<419 &&food4.y>46 &&food4.y<219 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
			
		}
		if(food4.x>209 &&food4.x<219 &&food4.y>309 &&food4.y<469 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
			
		}
		if(food4.x>409 &&food4.x<309 &&food4.y>419 &&food4.y<469 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
			
		}
		if(food4.x>0 &&food4.x<219 &&food4.y>209 &&food4.y<219 ){//����ϰ�
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
			
		}
		if(food.x>409 &&food.x<639 &&food.y>209 &&food.y<319 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food4.x>0 &&food4.x<219 &&food4.y>309 &&food4.y<319 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
			
		}
		if(food4.x>409 &&food4.x<639 &&food4.y>309 &&food4.y<249 ){
			setcolor(15);
			rectangle(food4.x,food4.y,food4.x+10,food4.y+10);
			food4.yes=0;
			
		}
		}
		//������Ҫ�õ� ���ʳ������������� �����³���ʳ�� ���ߵķ�Χ���ƹ������в�����Ҫ�װ����ߵ����������ڵľ���
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
		//���Ĺ�ʳ��������ϰ���������ˢ�²�ȥ��
		if(food.x>314 &&food.x<324 &&food.y>46 &&food.y<479){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>0 &&food.x<639 &&food.y>244 &&food.y<254){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		//��5��ʳ�ﲻ�ܳ������ϰ��� ���� ��ȥ���ð�ǽ
		if(food.x>209 &&food.x<219 &&food.y>46 &&food.y<219 ){//�����ϰ�
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
		}
		if(food.x>409 &&food.x<419 &&food.y>46 &&food.y<219 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>209 &&food.x<219 &&food.y>309 &&food.y<469 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>409 &&food.x<309 &&food.y>419 &&food.y<469 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>0 &&food.x<219 &&food.y>209 &&food.y<219 ){//����ϰ�
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>409 &&food.x<639 &&food.y>209 &&food.y<319 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>0 &&food.x<219 &&food.y>309 &&food.y<319 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		if(food.x>409 &&food.x<639 &&food.y>309 &&food.y<249 ){
			setcolor(15);
			rectangle(food.x,food.y,food.x+10,food.y+10);
			food.yes=0;
			
		}
		//��
		//������Ҫ�õ� ���ʳ������������� �����³���ʳ�� ���ߵķ�Χ���ƹ������в�����Ҫ�װ����ߵ����������ڵľ���
		if(food3.x>139 &&food3.x<269 &&food3.y>56 &&food3.y<229 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		if(food3.x>379 &&food3.x<509 &&food3.y>56 &&food3.y<229 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		if(food3.x>29 &&food3.x<129 &&food3.y>259 &&food3.y<452 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		if(food3.x>259 &&food3.x<389 &&food3.y>259 &&food3.y<452 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		if(food3.x>509 &&food3.x<609 &&food3.y>259 &&food3.y<452 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		//���Ĺ�ʳ��������ϰ���������ˢ�²�ȥ��
		if(food3.x>314 &&food3.x<324 &&food3.y>46 &&food3.y<479){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		if(food3.x>0 &&food3.x<639 &&food3.y>244 &&food3.y<254){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		//��5��ʳ�ﲻ�ܳ������ϰ��� ���� ��ȥ���ð�ǽ
		if(food3.x>209 &&food3.x<219 &&food3.y>46 &&food3.y<219 ){//�����ϰ�
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
		}
		if(food3.x>409 &&food3.x<419 &&food3.y>46 &&food3.y<219 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
			
		}
		if(food3.x>209 &&food3.x<219 &&food3.y>309 &&food3.y<469 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
			
		}
		if(food3.x>409 &&food3.x<309 &&food3.y>419 &&food3.y<469 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
			
		}
		if(food3.x>0 &&food3.x<219 &&food3.y>209 &&food3.y<219 ){//����ϰ�
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
			
		}
		if(food3.x>409 &&food3.x<639 &&food3.y>209 &&food3.y<319 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
			
		}
		if(food3.x>0 &&food3.x<219 &&food3.y>309 &&food3.y<319 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
			
		}
		if(food3.x>409 &&food3.x<639 &&food3.y>309 &&food3.y<249 ){
			setcolor(15);
			rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
			food3.yes=0;
			
		}
		//��Ҫ����
		setlinestyle(0,0,3);//�ߺ�ʳ���Ⱥ�������ʽ
		for(i=snake.node-1;i>0;i--){
			snake.x[i]=snake.x[i-1];
			snake.y[i]=snake.y[i-1];//�ߵ����긳����һ��
		}
		//����
		setlinestyle(0,0,3);//�ߺ�ʳ���Ⱥ�������ʽ
		for(i=snake2.node-1;i>0;i--){
			snake2.x[i]=snake2.x[i-1];
			snake2.y[i]=snake2.y[i-1];//�ߵ����긳����һ��
		}
		//��Խ�߽� ����ͷ������任����
		if(snake.x[0]<10){//����
			snake.x[0]=630;
		}
		if(snake.x[0]>630){
			snake.x[0]=10;
		}
		if(snake.y[0]<57){//����
			snake.y[0]=470;
		}
		if(snake.y[0]>470){
			snake.y[0]=47;
		}
		//����
		if(snake2.x[0]<10){//����
			snake2.x[0]=630;
		}
		if(snake2.x[0]>630){
			snake2.x[0]=10;
		}
		if(snake2.y[0]<57){//����
			snake2.y[0]=470;
		}
		if(snake2.y[0]>470){
			snake2.y[0]=47;
		}
		//��һ���ߵĿ���
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
		//�ڶ����ߵĿ���
		switch(snake2.direction){
			case 1:
				snake2.x[0]+=10;//����
				break;
			case 2:
				snake2.x[0]-=10;//����
				break;
			case 3:
				snake2.y[0]-=10;//����
				break;
			case 4:
				snake2.y[0]+=10;//����
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
			jieshu2();
			break;
		}
		//ҧ�Լ� �ڶ�����
		for(i=3;i<snake2.node;i++){
				if(snake2.x[0]==snake2.x[i]&&snake2.y[0]==snake2.y[i]){
					snake2.life=0;
				}
		}
		if(snake2.life==0){
			jieshu2();
			break;
		}
		
		//���ߵ�����//����Ҫ����ɫ
		setlinestyle(0,0,3);//���
		setcolor(4);
		for(i=0;i<snake.node;i++){
			rectangle(snake.x[i],snake.y[i],snake.x[i]+10,snake.y[i]+10);	
		}
		//����
		setlinestyle(0,0,3);//���
		setcolor(3);
		for(i=0;i<snake2.node;i++){
			rectangle(snake2.x[i],snake2.y[i],snake2.x[i]+10,snake2.y[i]+10);	
		}
		//�߶�����
		//ѭ����ǽ�����ǽ�����ӳٻ���Ӱ��ֻ�����԰�Χǽ��С�㵫����ǽ�ķ�Χ����
		delay(speed);//�����ӳ�
		setlinestyle(0,0,3);//����ĩβ��Ⱥ�������ʽ
		setcolor(15);//�����ɫ
		//ȥ��β���Ľ���
		rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		//����
		//һ���ӳپ���delay(speed2);�����ӳ�
		setlinestyle(0,0,3);//����ĩβ��Ⱥ�������ʽ
		setcolor(15);//�����ɫ
		//ȥ��β���Ľ���
		rectangle(snake2.x[snake2.node-1],snake2.y[snake2.node-1],snake2.x[snake2.node-1]+10,snake2.y[snake2.node-1]+10);		
		
		//��һ���߳���ͨʳ��
		if(snake.x[0]==food.x&&snake.y[0]==food.y){
			snake.node++;
			food.yes=0;//���¸�ʳ�����
			snake.score+=10;
			shuangfen();
			count++;//�ۼ�
			if(count>2){//�����Ե����������� count���ǵ���2
				count=2;
			}
		}
		//��һ���߳���ͨʳ��2
		if(snake.x[0]==food3.x&&snake.y[0]==food3.y){
			snake.node++;
			food3.yes=0;//���¸�ʳ�����
			snake.score+=10;
			shuangfen();
			count++;//�ۼ�
			if(count2>2){//�����Ե����������� count���ǵ���2
				count2=2;
			}
		}
		//�ڶ����߳���ͨʳ��
		if(snake2.x[0]==food.x&&snake2.y[0]==food.y){
			snake2.node++;
			food.yes=0;//���¸�ʳ�����
			snake2.score+=10;
			shuangfen();
			count++;//�ۼ�
			if(count>2){//�����Ե����������� count���ǵ���2
				count=2;
			}
		}
		//�ڶ����߳���ͨʳ��2
		if(snake2.x[0]==food3.x&&snake2.y[0]==food3.y){
			snake2.node++;
			food3.yes=0;//���¸�ʳ�����
			snake2.score+=10;
			shuangfen();
			count++;//�ۼ�
			if(count2>2){//�����Ե����������� count���ǵ���2
				count2=2;
			}
		}
		//��һ���߳�����ʳ�� ��Ϊ������ʳ���߽�-1 Ҫ���������Ľ�ȥ�� ������Ӱ���߶���ȥ�����һ�� ����ֻ��������
		if(snake.x[0]==food1.x&&snake.y[0]==food1.y){
			snake.node--;
			food1.yes=0;//���¸�ʳ�����
			snake.score+=20;
			shuangfen();//������ӡ
			count=0;//��ʼֵ
			//�ӳ���Сֵ
			if(speed==8000){
				speed=8000;
			}else{
				speed-=8000;//���ٶ�
			}
			//ȥ��������ʳ�����������ǽ�
			setcolor(15);
			rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		}
		//��һ���߳�����ʳ��2 ��Ϊ������ʳ���߽�-1 Ҫ���������Ľ�ȥ�� ������Ӱ���߶���ȥ�����һ�� ����ֻ��������
		if(snake.x[0]==food4.x&&snake.y[0]==food4.y){
			snake.node--;
			food4.yes=0;//���¸�ʳ�����
			snake.score+=20;
			shuangfen();//������ӡ
			count=0;//��ʼֵ
			//�ӳ���Сֵ
			if(speed==8000){
				speed=8000;
			}else{
				speed-=8000;//���ٶ�
			}
			//ȥ��������ʳ�����������ǽ�
			setcolor(15);
			rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		}
		//�ڶ����߳�����ʳ�� ��Ϊ������ʳ���߽�-1 Ҫ���������Ľ�ȥ�� ������Ӱ���߶���ȥ�����һ�� ����ֻ��������
		if(snake2.x[0]==food1.x&&snake2.y[0]==food1.y){
			snake2.node--;
			food1.yes=0;//���¸�ʳ�����
			snake2.score+=20;
			shuangfen();//������ӡ
			count=0;//��ʼֵ
			//�ӳ���Сֵ
			if(speed==8000){
				speed=8000;
			}else{
				speed-=8000;//���ٶ�
			}
			//ȥ��������ʳ�����������ǽ�
			setcolor(15);
			rectangle(snake2.x[snake2.node-1],snake2.y[snake2.node-1],snake2.x[snake2.node-1]+10,snake2.y[snake2.node-1]+10);
		}
		//�ڶ����߳�����ʳ��2 ��Ϊ������ʳ���߽�-1 Ҫ���������Ľ�ȥ�� ������Ӱ���߶���ȥ�����һ�� ����ֻ��������
		if(snake2.x[0]==food4.x&&snake2.y[0]==food4.y){
			snake2.node--;
			food4.yes=0;//���¸�ʳ�����
			snake2.score+=20;
			shuangfen();//������ӡ
			count=0;//��ʼֵ
			//�ӳ���Сֵ
			if(speed==8000){
				speed=8000;
			}else{
				speed-=8000;//���ٶ�
			}
			//ȥ��������ʳ�����������ǽ�
			setcolor(15);
			rectangle(snake2.x[snake2.node-1],snake2.y[snake2.node-1],snake2.x[snake2.node-1]+10,snake2.y[snake2.node-1]+10);
		}
		
		//�ؿ�
		if(snake.level==1||snake2.level==1){//�ȼ�1
			//ײǽ
			if(snake.x[0]<30||snake.x[0]>600||snake.y[0]<60||snake.y[0]>440){
			snake.life=0;
			//���ߵ�����Ϊ0�Ͳ���ѭ����һ��ֱ������
			//�����ȵ������ڶ���whileѭ��ֱ������,�������жϾͲ�����
			}
			//��
			if(snake2.x[0]<30||snake2.x[0]>600||snake2.y[0]<60||snake2.y[0]>440){
			snake2.life=0;
			}
		}
		else if(snake.level==2||snake2.level==2){//�ȼ�2
		
			//��һ���ǽ
			 if(state==0){
				draw(1);
				state=1;
				//�ڶ��صĳ�ʼ�ٶ� 1�����
				speed=24000;
				delay(100000);//�ӳ�1��
			 }
		}
		else if(snake.level==3||snake2.level==3){//�ȼ�3
			
			//��һ��֮ǰ��ǽˢ����ǽ
			if(state2==0){
				draw(2);
				state2=1;
				//��ʼ�ٶ� 1�����
				speed=24000;
				delay(100000);//�ӳ�1��
			}
			//ײǽ�� ��Ϊ������ǽ ����Ҫ�ж�
			if(snake.x[0]<30||snake.x[0]>600||snake.y[0]<60||snake.y[0]>440){
				snake.life=0;
			}
			//��
			if(snake2.x[0]<30||snake2.x[0]>600||snake2.y[0]<60||snake2.y[0]>440){
			snake2.life=0;
			}
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
			//��
			if(snake2.x[0]>139 &&snake2.x[0]<269 &&snake2.y[0]>56 &&snake2.y[0]<229 ){
				snake2.life=0;
			}
			if(snake2.x[0]>379 &&snake2.x[0]<509 &&snake2.y[0]>56 &&snake2.y[0]<229 ){
				snake2.life=0;
			}
			if(snake2.x[0]>29 &&snake2.x[0]<129 &&snake2.y[0]>259 &&snake2.y[0]<452 ){
				snake2.life=0;
			}
			if(snake2.x[0]>259 &&snake2.x[0]<389 &&snake2.y[0]>259 &&snake2.y[0]<452 ){
				snake2.life=0;
			}
			if(snake2.x[0]>509 &&snake2.x[0]<609 &&snake2.y[0]>259 &&snake2.y[0]<452 ){
				snake2.life=0;
			}
		}
		else if(snake.level==4||snake2.level==4){
			if(state3==0){
				system("cls");
				state3=1;
				shuangfen();
				//��ʼ�ٶ� 1�����
				speed=24000;
				delay(50000);//�ӳ�1��
			}
			setbkcolor(15);
			
			//�ϰ���
			setfillstyle(7,8);
			bar(315,47,325,480);
			setfillstyle(7,8);
			bar(0,245,640,255);
			//��ͷ���ϰ�����
			if(snake.x[0]>314 &&snake.x[0]<324 &&snake.y[0]>46 &&snake.y[0]<479){
				snake.life=0;
			}
			if(snake.x[0]>0 &&snake.x[0]<639 &&snake.y[0]>244 &&snake.y[0]<254){
				snake.life=0;
			}
			//��
			if(snake2.x[0]>314 &&snake2.x[0]<324 &&snake2.y[0]>46 &&snake2.y[0]<479){
				snake.life=0;
			}
			if(snake2.x[0]>0 &&snake2.x[0]<639 &&snake2.y[0]>244 &&snake2.y[0]<254){
				snake2.life=0;
			}
			
		}
		else if(snake.level==5||snake2.level==5){
			if(state4==0){
				system("cls");
				state4=1;
				shuangfen();
				//��ʼ�ٶ� 1�����
				speed=24000;
				delay(50000);//�ӳ�1��
			}
			setbkcolor(15);
			//�ϰ���
			setfillstyle(7,8);
			bar(210,47,220,220);//�����ϰ�
			bar(410,47,420,220);
			bar(210,310,220,470);
			bar(410,310,420,470);
			
			bar(0,210,220,220);//����ϰ�
			bar(410,210,640,220);
			bar(0,310,220,320);
			bar(410,310,640,320);
			//�ж� ��ͷ����ײ��
			if(snake.x[0]>209 &&snake.x[0]<219 &&snake.y[0]>46 &&snake.y[0]<219 ){//�����ϰ�
				snake.life=0;
			}
			if(snake.x[0]>409 &&snake.x[0]<419 &&snake.y[0]>46 &&snake.y[0]<219 ){
				snake.life=0;
				
			}
			if(snake.x[0]>209 &&snake.x[0]<219 &&snake.y[0]>309 &&snake.y[0]<469 ){
				snake.life=0;
				
			}
			if(snake.x[0]>409 &&snake.x[0]<309 &&snake.y[0]>419 &&snake.y[0]<469 ){
				snake.life=0;
				
			}
			if(snake.x[0]>0 &&snake.x[0]<219 &&snake.y[0]>209 &&snake.y[0]<219 ){//����ϰ�
				snake.life=0;
				
			}
			if(snake.x[0]>409 &&snake.x[0]<639 &&snake.y[0]>209 &&snake.y[0]<319 ){
				snake.life=0;
				
			}
			if(snake.x[0]>0 &&snake.x[0]<219 &&snake.y[0]>309 &&snake.y[0]<319 ){
				snake.life=0;
				
			}
			if(snake.x[0]>409 &&snake.x[0]<639 &&snake.y[0]>309 &&snake.y[0]<249 ){
				snake.life=0;
				
			}
			//��
			if(snake2.x[0]>209 &&snake2.x[0]<219 &&snake2.y[0]>46 &&snake2.y[0]<219 ){//�����ϰ�
				snake2.life=0;
			}
			if(snake2.x[0]>409 &&snake2.x[0]<419 &&snake2.y[0]>46 &&snake2.y[0]<219 ){
				snake2.life=0;
				
			}
			if(snake2.x[0]>209 &&snake2.x[0]<219 &&snake2.y[0]>309 &&snake2.y[0]<469 ){
				snake2.life=0;
				
			}
			if(snake2.x[0]>409 &&snake2.x[0]<309 &&snake2.y[0]>419 &&snake2.y[0]<469 ){
				snake2.life=0;
				
			}
			if(snake2.x[0]>0 &&snake2.x[0]<219 &&snake2.y[0]>209 &&snake2.y[0]<219 ){//����ϰ�
				snake2.life=0;
				
			}
			if(snake2.x[0]>409 &&snake2.x[0]<639 &&snake2.y[0]>209 &&snake2.y[0]<319 ){
				snake2.life=0;
				
			}
			if(snake2.x[0]>0 &&snake2.x[0]<219 &&snake2.y[0]>309 &&snake2.y[0]<319 ){
				snake2.life=0;
				
			}
			if(snake.x[0]>409 &&snake.x[0]<639 &&snake.y[0]>309 &&snake.y[0]<249 ){
				snake.life=0;
				
			}
		}
		else{//ͨ��
			pass();
			snake.life=0;
			break;
			
		}
	}
	key=bioskey(0);
	if(key==ESC){
		//�����Ĵ��Ӳ˵� ����Ҫ�˳�
		break;	

	}
	else if(key==KONGGE){
		//�ٻ�һ���߸���ԭ������
		setcolor(RED);
		for(i=0;i<snake.node;i++){
		rectangle(snake.x[i],snake.y[i],snake.x[i]+10,snake.y[i]+10);	
		//����
		setcolor(3);
		for(i=0;i<snake2.node;i++){
		rectangle(snake2.x[i],snake2.y[i],snake2.x[i]+10,snake2.y[i]+10);
		}
		getch();//��ͣ���м� ��˼�� ��ͣ �ͻ���һ���� ��ʼ�Ϳ�ʼ��β
		//ȥ��β���Ľ���
		setcolor(15);
		rectangle(snake.x[snake.node-1],snake.y[snake.node-1],snake.x[snake.node-1]+10,snake.y[snake.node-1]+10);
		//����
		setcolor(15);
		rectangle(snake2.x[snake2.node-1],snake2.y[snake2.node-1],snake2.x[snake2.node-1]+10,snake2.y[snake2.node-1]+10);
		}
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
	//����
	else if(key==D&&snake2.direction!=2){
		snake2.direction=1;
	}else if(key==A&&snake2.direction!=1){
		snake2.direction=2;
	}else if(key==W&&snake2.direction!=4){
		snake2.direction=3;
	}else if(key==S&&snake2.direction!=3){
		snake2.direction=4;
	}
	}
	//���������˵�2 ��������
	rootmenu2();
	//���ҷ�������
	snake.score=0;
	snake2.score=0;
}
void shiwu3(){
	//�ж��Ƿ���Ҫ����ʳ��
	if(food3.yes==0){
		//���������
		randomize();
		//0-639
		food3.x=random(540)+30;
		//���ɵ�������Ҫ��10 �ı���(Ϊ�����߸�ʳ����һ������)
		while(food3.x%10!=0){
			food3.x++;
		}
		
		food3.y=random(340)+70;
		while(food3.y%10!=0){
			food3.y++;
		}
		
		food3.yes=1;//1��ʾ�Ѿ���ʳ����
	}
	setcolor(GREEN);
	rectangle(food3.x,food3.y,food3.x+10,food3.y+10);
}
void shiwu4(){
	int i;
	if(food4.yes==0){
	randomize();	
	food4.x=random(510)+50;
	while(food4.x%10!=0){
		food4.x++;
	}
	food4.y=random(340)+80;
	while(food4.y%10!=0){
		food4.y++;	//��ֹ���ֲ���Ϊ10�ı���������
	}
	food4.yes=1;//����ʳ��Ϊ1 �Ļ��Ͳ�������µ�ʳ��
	}
	setcolor(random(13)+1);
	rectangle(food4.x,food4.y,food4.x+10,food4.y+10);//����߻�ĥʳ��ı�
}	

//����
void shuangfen(){
	//�ı�
	char a[50];
	char b[50];
	int fen;//���Ʒ�����ȼ�����
	if(x==1){
		fen=40;
	}
	if(x==2){
		fen=80;
	}
	if(x==3){
		fen=120;
	}
	if(x==4){
		fen=160;
	}
	if(x==5){
		fen=200;
	}
	if(x==6){
		fen=240;
	}
	//�������
	setfillstyle(3,7);
	bar(0,20,640,43);
	//�ı���С
	settextstyle(0,0,3);
	setcolor(12);
	snake.level=snake.score/fen+x;
	snake2.level=snake2.score/fen+x;
	sprintf(a,"SCORE:%d",snake.score);
	outtextxy(100,20,a);
	sprintf(b,"SCORE:%d",snake2.score);
	outtextxy(360,20,b);	
}
//����
void jieshu2(){
	//����
	char a[50]="GAME OVER!!";
	char b[50];
	char c[50];
	//����
	system("cls");
	//������ɫ ��ͼ����ɫ
	setbkcolor(0);
	setcolor(YELLOW);
	//ͼ�δ�С
	settextstyle(0,0,3);
	//����
	outtextxy(150,100,a);
	settextstyle(0,0,3);
	setcolor(12);
	if(snake.score>snake2.score){
		sprintf(c,"WINNER:PLAYER2");
		outtextxy(150,185,c);
		sprintf(b,"LEVEL:%d SCORE:%d",snake.level,snake.score);
		outtextxy(150,270,b);
	}else if(snake2.score>snake.score){
		sprintf(c,"WINNER:PLAYER1");
		outtextxy(150,185,c);
		sprintf(b,"LEVEL:%d SCORE:%d",snake2.level,snake2.score);
		outtextxy(150,270,b);
	}else{
		sprintf(c,"A DEAD HEAT");
		outtextxy(150,185,c);
	}
	
}
//ͨ��
void pass(){
	//����
	system("cls");
	//������ɫ	
	setbkcolor(0);
	//ͼ����ɫ
	setcolor(YELLOW);
	//ͼ�δ�С
	settextstyle(0,0,4);
	//����
	outtextxy(190,160,"VITORY!!");
	settextstyle(0,0,2);
	outtextxy(170,215,"Congratulations on ");
	outtextxy(135,245,"yours customs clearance!!");	
}
