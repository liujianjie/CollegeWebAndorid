#include "stdio.h"
void main(){
	char a[30],b[30],c[100];
	int i;
	printf("请输入你的一串数：");
	gets(a);
	printf("请输入你另一串数：");
	gets(b);
	for(i=0;i<strlen(a);i++){
		c[i]=a[i];
	}
	for(i=0;i<strlen(b);i++){
		c[strlen(a)+i]=b[i];
	}
	
	printf("%s",c);
}