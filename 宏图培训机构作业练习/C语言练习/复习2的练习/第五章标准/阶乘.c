/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //���������Ľ׳�
    int i,a;
    long sum=1;
    printf("������һ��Ҫ��׳˵���");
    scanf("%d",&a);
    for(i=a;i>0;i--){  //
    	sum*=i;
    }
    printf("%ld",sum);
}