#include "stdio.h"
void main(){
	int i,sum=0;
	char a[100];
	printf("请输入一句英文句子：");
	gets(a);
	for(i=0;i<strlen(a);i++){
		
		if(a[i]==' '){
			sum=sum+1;
		}
		
	}
	printf("这句英文有%d个单词",sum+1);
	printf("%s",a);
}