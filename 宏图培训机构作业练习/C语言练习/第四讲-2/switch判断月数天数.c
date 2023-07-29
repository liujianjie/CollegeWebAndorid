#include "stdio.h"
void main(){
	int a;
	printf("请输入月份：");
	scanf("%d",&a);
	switch(a){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			printf("这个月的天数为31");
			break;
		case 2:
			printf("这个月的天数为28");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			printf("这个月的天数为30");
			break;
		default:
			printf("输入错误");
		
		
		
		
		}


	}