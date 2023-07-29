#include "stdio.h"
void main(){
	int i,a[3];	
	
	for(i=0;i<3;i++){
		printf("请输入第%d本书的价格：",i+1);
		scanf("%d",&a[i]);
	}
	printf("三本书的价格为\n");
	for(i=0;i<3;i++){
		printf("%d\t",a[i]);
		
	}
	
	
	
	
}