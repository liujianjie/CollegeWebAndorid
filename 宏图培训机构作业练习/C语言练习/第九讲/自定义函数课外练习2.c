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
	printf("�������һ������");
	scanf("%d",&d);
	printf("������ڶ�������");
	scanf("%d",&e);
	printf("���������ļӼ��˳��ֱ��ǣ�\n");
	a=sum(d,e);
	b=cha(d,e);
	c=cheng(d,e);
	f=chu(d,e);
	printf("%d\t%d\t%d\t%.2f",a,b,c,(float)f);
}