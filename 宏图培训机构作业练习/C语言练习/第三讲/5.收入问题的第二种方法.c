#include "stdio.h"
void main(){
		int a=1,b=0,sum=0;
		printf("��˾��%d���µ����룺",a);
		scanf("%d",&b);
		sum+=b;
		a++;
		
		
		printf("��˾��%d���µ����룺",a);
		scanf("%d",&b);
		sum+=b;//sum=sum+b
		a++;
		printf("�����룺%d",sum);
	}