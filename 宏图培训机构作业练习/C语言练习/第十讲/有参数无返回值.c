#include "stdio.h"
void he(int x,int y);
void main(){
	int a,b;
	printf("请输入两个数（空格隔开）");
	scanf("%d %d",&a,&b);
	he(a,b);
}
void he(int x,int y){
	int c;
	c=x+y;
	printf("和为%d",c);
}