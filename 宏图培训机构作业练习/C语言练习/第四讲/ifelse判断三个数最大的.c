#include "stdio.h"
void main(){
	int a,b,c,max;
	printf("���������������Ÿ�����");
	scanf("%d,%d,%d",&a,&b,&c);
	if(a>b){
		max=a;
		
	}else{
		max=b;
	}
	if(max>c){
			printf("�������������ǣ�%d",max);
	}else{
			printf("�������������ǣ�%d",c);
	}
	}