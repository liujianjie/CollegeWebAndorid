#include "stdio.h"
int he();
void main(){
	int c;
	c=he();
	printf("%d",c);
}
int he(){
	int a,b,sum;
	printf("���������������ո������");	
	scanf("%d %d",&a,&b);
	sum=a+b;
	return sum;
}