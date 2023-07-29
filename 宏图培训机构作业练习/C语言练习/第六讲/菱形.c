#include "stdio.h"

void main()
{
	int i,j,a;
	printf("请输入一个数（大于3的数）：");
	scanf("%d",&a);
	//上半部分
	for(i=0;i<a;i++)
	{
		for(j=0;j<a-i;j++)
		{
			printf(" ");
		}

		for(j=0;j<2*i+1;j++)
		{
			printf("*");
		}
		printf("\n");
	}
	//下半部分
	for(i=a-1;i>=0;i--)
	{
		for(j=0;j<a+1-i;j++)
		{
			printf(" ");
		}

		for(j=0;j<2*i-1;j++)
		{
			printf("*");
		}

		printf("\n");

	}
}
