#include "stdio.h"
void main(){
	float a,b,c,d;
	printf("请输入你的工资：");
	scanf("%f",&a);
	printf("请输入你当地的个人起点税：");
	scanf("%f",&b);
	if(a>=b){
		c=a*0.043;
		d=a-c;
		printf("你的工资为：%.2f\n",a);
		printf("你所需缴税：%.2f\n",c);
		printf("缴税后你的总收入为：%.2f\n",d);

		
	}else {

		printf("骚年，努力不要缴费吧");
	
	}	

	
	}