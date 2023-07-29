#include "stdio.h"
void main(){
	int a[3],i;
	float sum=0;
	for(i=0;i<12;i++){
		printf("请输入公司第%d个月的收入：",i+1);
		scanf("%d",&a[i]);
		sum+=a[i];	
	}
	printf("公司三个月的总收入为：%.2f",sum);
	
	
}