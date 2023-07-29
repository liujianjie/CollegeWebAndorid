#include "stdio.h"
void main(){
	float c,k,h,s;
	printf("请输入长 宽 和高(用逗号隔开)");
	scanf("%f,%f,%f", &c,&k,&h,&s);
	s=(c*k+k*h+c*h)*2;
	printf("长方体的表面积为%0.2f",s);
	}