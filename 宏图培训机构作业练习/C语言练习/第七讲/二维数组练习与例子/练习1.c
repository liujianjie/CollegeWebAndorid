#include "stdio.h"
void main(){
	int i,j,a[3][3];	
	for(i=0;i<3;i++){
		printf("�������%d�е�����",i+1);
		for(j=0;j<3;j++){
			scanf("%d",&a[i][j]);
		}
	}
	printf("\n");
	printf("�����������Ч���ǣ�\n");
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("%d\t",a[i][j]);
		}
		printf("\n");
	}
	printf("\n");
	printf("�����������������ת����Ч���ǣ�\n");
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("%d\t",a[j][i]);
		}
		printf("\n");
	}
	
	
	
	
	
	
}