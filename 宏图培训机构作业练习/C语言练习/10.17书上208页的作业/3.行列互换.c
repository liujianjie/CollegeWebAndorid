#include "stdio.h"
void huan(){
	int a[3][3],i,j;
	for(i=0;i<3;i++){
		printf("�������%d�е�3����:",i+1);
		for(j=0;j<3;j++){
			scanf("%d",&a[i][j]);	
		}
	}
	printf("���������λ��Ϊ��\n");
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("%d\t",a[i][j]);	
		}
		printf("\n");
	}
	printf("�㻻�е�λ��Ϊ��\n");
		for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("%d\t",a[j][i]);	
		}
		printf("\n");
	}
}
void main(){
	huan();
}