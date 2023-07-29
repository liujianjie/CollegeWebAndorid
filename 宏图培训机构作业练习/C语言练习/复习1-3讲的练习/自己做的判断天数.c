#include "stdio.h"
void main(){
	int a,b,c,d=30,e=31,f=29;
	printf("请输入月份：");
	scanf("%d",&a);
	printf("请输入日期：");
	scanf("%d",&b);
	if(a<=12&&b<=31){
		switch(a){
			case 1: 
			    printf("这天是2000年的第%d天",b);
				break;
			case 2:
				c=e+b;
				printf("这天是2000年的第%d天",c);
				break;
			case 3:
				c=e+f+b;
				printf("这天是2000年的第%d天",c);
				break;	
			case 4:
				c=e+f+e+b;
				printf("这天是2000年的第%d天",c);
				break;
			case 5:
				c=e+f+e+d+b;
				printf("这天是2000年的第%d天",c);
				break;	
			case 6:
				c=e+f+e+d+f+b;
				printf("这天是2000年的第%d天",c);
				break;	
			case 7:
				c=e+f+e+d+f+d+b;
				printf("这天是2000年的第%d天",c);
				break;
			case 8:
				c=e+f+e+d+f+d+f+b;
				printf("这天是2000年的第%d天",c);
				break;	
			case 9:
				c=e+f+e+d+f+d+f+f+b;
				printf("这天是2000年的第%d天",c);
				break;	
			case 10:
				c=e+f+e+d+f+d+f+f+d+b;
				printf("这天是2000年的第%d天",c);
				break;
			case 11:
				c=e+f+e+d+f+d+f+f+d+f+b;
				printf("这天是2000年的第%d天",c);
				break;
			case 12:
				c=e+f+e+d+f+d+f+f+d+f+d+b;
				printf("这天是2000年的第%d天",c);
				break;		
		}
	}else{
		printf("输入错误，程序无法执行下去");
	}

}