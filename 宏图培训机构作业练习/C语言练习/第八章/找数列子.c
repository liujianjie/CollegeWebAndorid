#include "stdio.h"
void main(){
	int a[5],i,b;
	printf("������5�����ո������");
	for(i=0;i<5;i++){
		scanf("%d",&a[i]);
	}
	printf("��������Ҫ�ҵ�����");
	scanf("%d",&b);
	for(i=0;i<5;i++){
		if(a[i]==b){
			printf("��ϲ�㣡�ڵ�%d�������ҵ���",i+1);
			break;	
		}
	}
	if(i>=5){
		printf("���ź���û���ҵ�");
	}
	
}