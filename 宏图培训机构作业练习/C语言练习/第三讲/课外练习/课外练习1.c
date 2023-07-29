/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
     int a,x,y,z,max,min,mid;
    printf("请输入一个三位数");
    scanf("%d",&a);
    x=a/100;
    y=a/10%10;
    z=a%10;
    
    //求出最大值
    max=x>y?x:y;
    max=max>z?max:z;
    
    //求出最小值
    min=x<y?x:y;
    min=min<z?min:z;
    
    //中间数
    mid=x+y+z-(max+min);
    
    printf("%d",max*100+mid*10+min);
}