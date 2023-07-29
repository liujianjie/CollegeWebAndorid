#include "stdio.h"
void main(){
		int a=1,b=0,sum=0;
		printf("公司第%d个月的收入：",a);
		scanf("%d",&b);
		sum+=b;
		a++;
		
		
		printf("公司第%d个月的收入：",a);
		scanf("%d",&b);
		sum+=b;//sum=sum+b
		a++;
		printf("总收入：%d",sum);
	}