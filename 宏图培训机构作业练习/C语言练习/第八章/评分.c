#include "stdio.h"
void main(){
	int i,j,a[5][5],sum=0,max=0,min=1000,x=0,z,y;
	float b;
	printf("             *                ��������������ϵͳ                 *\n");
	printf("             =====================================================\n");
	printf("             ��ͼ04���������������������ս֮ҹ\n");
	printf("             =====================================================\n");
	for(i=0;i<5;i++){
		printf("             5λ���и���%dλͬѧ�Ĵ�֣�",i+1);
		for(j=0;j<5;j++){
			scanf("%d",&a[i][j]);
		}
	}
	printf("             �����е���������\n");
	printf("ѡ�ֺ�\t��ί1\t��ί2\t��ί3\t��ί4\t��ί5\t�ܷ�\t��߷�\t��ͷ�\tƽ����\n");
	for(i=0;i<5;i++){
		sum=0;
		max=0;
		min=1000;
		printf(" %d",i+1);
		for(j=0;j<5;j++){
			printf("   \t%d",a[i][j]);
			if(j>=0){
				sum=sum+a[i][j];
			}
			if(max<a[i][j]){
				max=a[i][j];
			}
			if(min>a[i][j]){
				min=a[i][j];
			}
			b=(sum-max-min)/3;
			y=sum-max-min;
			if(x<=y){
				x=y;
				z=i+1;
			}
		}
		printf("\t%d",sum);
		printf("\t%d",max);
		printf("\t%d",min);
		printf("\t%.2f",b);
		printf("\n");
	}	
	printf("             �ھ���%dͬѧ��ȥ��һ����߷ֺ���ͷֵ���������%d",z,x);
}