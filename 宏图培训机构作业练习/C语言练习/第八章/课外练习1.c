#include "stdio.h"
void main(){
	int a[3][4],i,j,sum=0;
	for(i=0;i<3;i++){
		printf("�������%d��ͬѧ��4�ųɼ���",i+1);
		for(j=0;j<4;j++){
			scanf("%d",&a[i][j]);
		}
		
	}
	printf("\n");
	printf("ͬѧ\t��һ��\t�ڶ���\t������\t�ܷ�\n");
	for(i=0;i<3;i++){
		sum=0;
		printf(" %d",i+1);
		for(j=0;j<4;j++){
			printf("\t3%d",a[i][j]);
			if(j>=0){
				sum=sum+a[i][j];
			}
		}
		printf("\t%d",sum);
		printf("\n");
	}	
}