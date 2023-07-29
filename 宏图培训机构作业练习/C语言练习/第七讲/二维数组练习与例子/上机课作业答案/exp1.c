#include "stdio.h"

void main()
{
	int a[3][3]={{1,3,4},{2,5,6},{7,1,9}};
	int i,j;
	int sum1=0,sum2=0;

	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		{
			if(i==j)
			{
				sum1=sum1+a[i][j];
			}
			
			if((i+j)==2)
			{
				sum2=sum2+a[i][j];
			}
		}
	}
	printf("两条对角线上的元素之和分别为：%d，%d\n",sum1,sum2);
	
}