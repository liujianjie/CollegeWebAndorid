/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int a[10],i;
    printf("请输入10个数整数 用空格隔开：");
    for(i=0;i<10;i++){
    	scanf("%d",&a[i]);
    }
    
    printf("您输入的数字是:");
    for(i=0;i<10;i++){
    	printf("%d ",a[i]);
    }
}