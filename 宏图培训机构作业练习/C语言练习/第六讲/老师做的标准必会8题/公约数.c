/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //输入两个数，计算最大公约数
    int a,b,max=0,min,i;
    printf("请输入要计算的两个数（空格隔开）");
    scanf("%d %d",&a,&b);
    //比较获得a b两个数，得到a b中更小的数，以便于减小循环次数
    min=a>b?b:a;
    for(i=1;i<=min;i++){
    	if(a%i==0 && b%i==0){ //判断i是否为a b的公约数
    		if(max<=i){
    			max=i;
    		}
    	}
    }
    printf("%d和%d最大的公约数为：%d",a,b,max);
}