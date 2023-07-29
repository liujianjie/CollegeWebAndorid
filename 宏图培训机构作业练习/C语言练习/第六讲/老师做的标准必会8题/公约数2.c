/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //输入两个数，计算最大公约数
    int a,b,i,min;
    printf("请输入要计算的两个数（空格隔开）");
    scanf("%d %d",&a,&b);
    min=a>b?b:a;
    for(i=min;i>0;i--){
    	if(a%i==0 && b%i==0){
    		printf("%d和%d最大的公约数为：%d",a,b,i);
    		break;	
    	}
    }
}