#include "stdio.h"
void he(int x,int y);
void main(){
	int a,b;
	printf("���������������ո������");
	scanf("%d %d",&a,&b);
	he(a,b);
}
void he(int x,int y){
	int c;
	c=x+y;
	printf("��Ϊ%d",c);
}