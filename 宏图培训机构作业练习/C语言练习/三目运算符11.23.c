/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
		int a,b,c,max=0,min=0,mid=0,sum=0;
		printf("请输入3个数：");
		scanf("%d %d %d",&a,&b,&c);
		sum=a+b+c;//和为
		
		max=a>b?a:b;

		max=max>c?max:c;//比较最大的

		min=a<b?a:b;

		min=min<c?min:c;//比较最小的

		mid=sum-max-min;//中间的数
		printf("最大的数为：%d",max);
		printf("最小的数为：%d",min);
		a=min;
		b=mid;
		c=max;
		printf("\nabc赋值后的依次排序：%d  %d  %d",a,b,c);
	}


