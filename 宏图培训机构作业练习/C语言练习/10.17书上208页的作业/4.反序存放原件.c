#include "stdio.h"
void main(){
	char a[100];
	int i;
	printf("������һ��Ӣ����ĸ��");
	scanf("%s",&a);
	for(i=strlen(a);i>=0;i--){
		printf("%c",a[i]);
	}
}