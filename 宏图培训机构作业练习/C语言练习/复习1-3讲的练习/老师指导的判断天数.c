#include "stdio.h"
void main(){
	int a,b,c=0;
	printf("请输入月份和日期（空格隔开）：");
	scanf("%d %d",&a,&b);
	switch(a){
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
			c+=b;
			break;
		default:
			printf("输入错误，请重新输入");
			break;
	}
		printf("天数是%d",c);
}