#include "stdio.h"
void tian(int x,int y,int z);
void main()
{
	int a,b,d;
	printf("请输入年、月和日（空格隔开）：");
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
				printf("输入错误，请重新输入");
				break;
		}
			printf("这年是闰年，天数是%d",c);
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
				printf("输入错误，请重新输入");
				break;
		}
			printf("这年是平年，天数是%d",c);
	}
}