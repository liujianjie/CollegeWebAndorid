/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
     int a,x,y,z,max,min,mid;
    printf("������һ����λ��");
    scanf("%d",&a);
    x=a/100;
    y=a/10%10;
    z=a%10;
    
    //������ֵ
    max=x>y?x:y;
    max=max>z?max:z;
    
    //�����Сֵ
    min=x<y?x:y;
    min=min<z?min:z;
    
    //�м���
    mid=x+y+z-(max+min);
    
    printf("%d",max*100+mid*10+min);
}