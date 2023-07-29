#include "stdio.h"
void main(){
	float a,b,c,d;
	printf("请输入你的工资(精确到两位小数)：");
	scanf("%f",&a);
	
	printf("请输入你当地的个税起点：");
	scanf("%f",&b);
	
	if(a>=b){
		printf("你的工资是：%.2f\n",a);
		c=a*0.043;
		printf("你的个人所得税是：%.2f\n",c);
		d=a-c;
		printf("你扣税后的收入为：%.2f\n",d);
	}else{
		printf("说你涨工资还是不要涨好呢？");
	
	}
	
	
	
	
	
	}