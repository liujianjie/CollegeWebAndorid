#include "stdio.h"
void main(){
	int a;
	printf("请输入月数：");
	scanf("%d",&a);
	switch(a){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
		    printf("这个月的天数是31天。");
			break;
		case 2:
		    printf("这个月的的天数是28天。");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			printf("这个月的天数是30天。");
			break;
		default:
			printf("不存在 骚年请重新再来。");
	}
	
	}