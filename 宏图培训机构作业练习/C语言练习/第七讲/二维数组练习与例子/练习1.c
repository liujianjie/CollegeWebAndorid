#include "stdio.h"
void main(){
	int i,j,a[3][3];	
	for(i=0;i<3;i++){
		printf("请输入第%d行的数：",i+1);
		for(j=0;j<3;j++){
			scanf("%d",&a[i][j]);
		}
	}
	printf("\n");
	printf("你输入的数的效果是：\n");
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("%d\t",a[i][j]);
		}
		printf("\n");
	}
	printf("\n");
	printf("你输入的数进行行列转换的效果是：\n");
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("%d\t",a[j][i]);
		}
		printf("\n");
	}
	
	
	
	
	
	
}