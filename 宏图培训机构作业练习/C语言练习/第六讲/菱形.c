#include "stdio.h"

void main()
{
	int i,j,a;
	printf("������һ����������3��������");
	scanf("%d",&a);
	//�ϰ벿��
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
	//�°벿��
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
