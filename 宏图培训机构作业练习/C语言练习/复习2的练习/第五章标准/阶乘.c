/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //求任意数的阶乘
    int i,a;
    long sum=1;
    printf("请输入一个要求阶乘的数");
    scanf("%d",&a);
    for(i=a;i>0;i--){  //
    	sum*=i;
    }
    printf("%ld",sum);
}