#include "stdio.h"
void main(){
	int a[10],i;	
	for(i=0;i<10;i++){
		printf("�������%d������",i+1);
		scanf("%d",&a[i]);
	}
	printf("����������ǣ�");
	for(i=0;i<10;i++){
		printf("%d\t ",a[i]);
	}
}