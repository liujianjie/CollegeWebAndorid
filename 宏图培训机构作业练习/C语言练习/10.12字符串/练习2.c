#include "stdio.h"
void main(){
	int i,sum=0;
	char a[100];
	printf("������һ��Ӣ�ľ��ӣ�");
	gets(a);
	for(i=0;i<strlen(a);i++){
		
		if(a[i]==' '){
			sum=sum+1;
		}
		
	}
	printf("���Ӣ����%d������",sum+1);
	printf("%s",a);
}