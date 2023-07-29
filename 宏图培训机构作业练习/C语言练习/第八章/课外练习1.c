#include "stdio.h"
void main(){
	int a[3][4],i,j,sum=0;
	for(i=0;i<3;i++){
		printf("请输入第%d个同学的4门成绩：",i+1);
		for(j=0;j<4;j++){
			scanf("%d",&a[i][j]);
		}
		
	}
	printf("\n");
	printf("同学\t第一门\t第二门\t第三门\t总分\n");
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