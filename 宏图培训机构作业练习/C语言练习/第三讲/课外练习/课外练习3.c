/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
     int t,a,b,c,d,e,n;
    printf("������һ����");
    scanf("%d",&t);
    
    a=t/10000;
    b=t/1000%10;
    c=t/100%10;
    d=t/10%10;
    e=t%10;
    //������������
    n=e*10000+d*1000+c*100+b*10+a;
    printf("����1Ϊ��������%d",t==n);
    
}