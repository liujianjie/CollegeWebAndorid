#include "stdio.h"
void tian(int x,int y,int z);
void main()
{
	int a,b,d;
	printf("�������ꡢ�º��գ��ո��������");
	scanf("%d %d %d",&a,&b,&d);
	tian(a,b,d);
}
void tian(int x,int y,int z){
	int c=0;
	if((x%4==0&&x%100!=0)||x%400==0){
		switch(y){
			case 12:
				c+=30;
			case 11:
				c+=31;
			case 10:
				c+=30;
			case 9:
				c+=31;
			case 8:
				c+=31;
			case 7:
				c+=30;		
			case 6:
				c+=31;
			case 5:
				c+=30;
			case 4:
				c+=31;		
			case 3:
				c+=29;
			case 2:
				c+=30;
			case 1:
				c+=z;
				break;
			default:
				printf("�����������������");
				break;
		}
			printf("���������꣬������%d",c);
	}else{
		switch(y){
			case 12:
				c+=30;
			case 11:
				c+=31;
			case 10:
				c+=30;
			case 9:
				c+=31;
			case 8:
				c+=31;
			case 7:
				c+=30;		
			case 6:
				c+=31;
			case 5:
				c+=30;
			case 4:
				c+=31;		
			case 3:
				c+=28;
			case 2:
				c+=30;
			case 1:
				c+=z;
				break;
			default:
				printf("�����������������");
				break;
		}
			printf("������ƽ�꣬������%d",c);
	}
}