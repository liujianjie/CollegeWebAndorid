#include "stdio.h"
void main(){
	int a=1,b=0,c=0;
	while(a<13){
		printf("第%d个月的公司收入为：",a);
		scanf("%d",&b);
		a++;
		c=c+b;
		
		
		
	}
	printf("公司的总收入为：%d",c);
	
	}