#include "stdio.h"
void main(){
	int a,b;
	printf("����������Ա� 0��Ů��1���У�");
	scanf("%d",&a);
	printf("������������䣺");
	scanf("%d",&b);
	if(a==0){
		if(18>b>0){
			printf("С��Ů");
		}else if(18<=b&&b<40){
			printf("�װ��Ĺ�������һ֧����");
		}else{printf("Ů��");}
	}else{if(18>b>0){
			printf("С˧��");
		}else if(18<=b&&b<40){
			printf("����");
		}else{printf("����");}
	}
	}