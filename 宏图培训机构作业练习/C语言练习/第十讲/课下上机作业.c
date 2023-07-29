#include "stdio.h"

int he();
void main(){
	int a,b;
	printf("请输入一个整数：");
	scanf("%d",&a);
	b=he(a);
	printf("1~%d的和为：%d",a,b);
}
int he(int a){
	int i,c=0;
	for(i=1;i<=a;i++){
		c+=i;
	}
	return c;
}
/*
#include "stdio.h"
int c=0;
int he();
void main(){
	int a,b;
	printf("请输入一个整数：");
	scanf("%d",&a);
	he(a);
	printf("1~%d的和为：%d",a,c);
}
int he(int a){
	int i,c=0;
	for(i=1;i<=a;i++){
		c+=i;
	}
}
*/