#include "stdio.h"
void huan(){
	int a[3][3],i,j;
	for(i=0;i<3;i++){
		printf("请输入第%d行的3个数:",i+1);
		for(j=0;j<3;j++){
			scanf("%d",&a[i][j]);	
		}
	}
	printf("你输入的数位置为：\n");
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			printf("%d\t",a[i][j]);	
		}
		printf("\n");
	}
	printf("你换行的位置为：\n");
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