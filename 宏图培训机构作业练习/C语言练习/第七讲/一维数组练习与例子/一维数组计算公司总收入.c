#include "stdio.h"
void main(){
	int a[3],i;
	float sum=0;
	for(i=0;i<12;i++){
		printf("�����빫˾��%d���µ����룺",i+1);
		scanf("%d",&a[i]);
		sum+=a[i];	
	}
	printf("��˾�����µ�������Ϊ��%.2f",sum);
	
	
}