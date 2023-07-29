#include "stdio.h"
void lianjie(){
	char a[100],b[100];	
	printf("请输入第一段话：");
	gets(a);
	printf("请输入第二段话:");
	gets(b);
	printf("连接起来为：%s",strcat(a,b));
}
void main(){
	
	lianjie();
		
	
}