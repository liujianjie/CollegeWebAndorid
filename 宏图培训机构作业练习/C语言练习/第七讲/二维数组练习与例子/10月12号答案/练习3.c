/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int num,a[50],i=0;
    
    printf("请输入一个整数：");
    scanf("%d",&num);
    for(;num>0;i++){
    	a[i]=num%2;
    	num=num/2;
    }
    
    for(i=i-1;i>=0;i--){
    	printf("%d ",a[i]);
    }
}