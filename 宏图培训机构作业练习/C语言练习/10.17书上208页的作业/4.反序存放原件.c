#include "stdio.h"
void main(){
	char a[100];
	int i;
	printf("ÇëÊäÈëÒ»¶ÎÓ¢ÎÄ×ÖÄ¸£º");
	scanf("%s",&a);
	for(i=strlen(a);i>=0;i--){
		printf("%c",a[i]);
	}
}