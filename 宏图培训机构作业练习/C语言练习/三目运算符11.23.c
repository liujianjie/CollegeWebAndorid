/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
		int a,b,c,max=0,min=0,mid=0,sum=0;
		printf("������3������");
		scanf("%d %d %d",&a,&b,&c);
		sum=a+b+c;//��Ϊ
		
		max=a>b?a:b;

		max=max>c?max:c;//�Ƚ�����

		min=a<b?a:b;

		min=min<c?min:c;//�Ƚ���С��

		mid=sum-max-min;//�м����
		printf("������Ϊ��%d",max);
		printf("��С����Ϊ��%d",min);
		a=min;
		b=mid;
		c=max;
		printf("\nabc��ֵ�����������%d  %d  %d",a,b,c);
	}


