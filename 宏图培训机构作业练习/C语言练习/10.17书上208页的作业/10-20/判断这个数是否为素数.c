/* Note:Your choice is C IDE */
#include "stdio.h"
//函数原型申明
void sushu(int );
void main()
{
	int a;
    printf("请输入一个数：");
    scanf("%d",&a);
    sushu(a);
}
//判断该数是否为素数
void sushu(int a){
	int i,flag=0;
	for(i=2;i<a;i++){
		if(a%i==0){
			flag=1;
			break;	
		}	
	}
	if(flag==0){
		printf("%d是素数",a);
	}else{
		printf("%d不是素数",a);
	}
}