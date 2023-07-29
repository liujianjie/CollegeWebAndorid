#include "stdio.h"
#include "math.h"
void main(){
	double num,a,c;	
	int b;
	printf("请输入一个数：");
	scanf("%lf",&num);
	a=sqrt(num);
	printf("%.2lf\n",a);
	b=floor(3.14);
	printf("%d\n",b);
	c=sin(3.14/6);
	printf("%.2lf",c);
	
}