#include "stdio.h"
void main(){
	int n,a,b,c,d,e;
	printf("������һ��5λ����");
	scanf("%d",&n);
	a=n/10000;
	b=n/1000%10;
	c=n/100%10;
	d=n/10%10;
	e=n/1%10;
	printf("���������ǻ���������Ϊ1\n�����������ǻ��������Ϊ0\n���Ϊ��%d",a==e&&b==d);
	
	}