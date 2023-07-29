#include "stdio.h"
void main(){
	//int a[5]={34,4523,435,343,5432};
	//printf("%d %d %d %d %d",a[4],a[3],a[2],a[1],a[0]);
	//int a[4];
	//a[0]='a';
	//printf("%c",a[0]);
	int a[5],i;
	printf("请输入3位数(请用空格空开)：");
	for(i=0;i<3;i++){
		scanf("%d",&a[i]);
	}
	printf("这3个数到过来为：\n");
	for(i=2;i>=0;i--){
		printf("%d\t",a[i]);
	}
}