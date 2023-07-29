#include "stdio.h"
int sum(int x,int y){
	return x+y;
}
int cha(int x,int y){
	return x-y;
}
int cheng(int x,int y){
	return x*y;
}
int chu(int x,int y){
	return x/y;
}
void main(){
	int d,e,a,b,c,f,g;	
	printf("请输入第一个数：");
	scanf("%d",&d);
	printf("请输入第二个数：");
	scanf("%d",&e);
	printf("这两个数的加减乘除分别是：\n");
	a=sum(d,e);
	b=cha(d,e);
	c=cheng(d,e);
	f=chu(d,e);
	printf("%d\t%d\t%d\t%.2f",a,b,c,(float)f);
}