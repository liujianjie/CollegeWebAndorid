/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
     int t,a,b,c,d,e,n;
    printf("请输入一个数");
    scanf("%d",&t);
    
    a=t/10000;
    b=t/1000%10;
    c=t/100%10;
    d=t/10%10;
    e=t%10;
    //反过来的新数
    n=e*10000+d*1000+c*100+b*10+a;
    printf("出现1为回文数：%d",t==n);
    
}