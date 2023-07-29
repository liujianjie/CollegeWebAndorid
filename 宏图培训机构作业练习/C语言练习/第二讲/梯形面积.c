#include "stdio.h"
void main(){
		float s1, s2, h,s;
		printf("请输入上底，下底和高（用逗号隔开）");
		scanf("%f,%f,%f" ,&s1,&s2,&h);
		s=(s1+s2)*h/2;
		printf("T形的表面积为%0.1f",s);
	
	
}