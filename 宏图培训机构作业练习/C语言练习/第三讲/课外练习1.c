#include "stdio.h"
void main(){
	int a,b,c,n,max,max1,max2;
	printf("������һ����ͬ����λ����");
	scanf("%d",&n);
	a=n/100;
	b=n/10%10;
	c=n/1%10;
	max=a>b?a:b;
	max=max>c?max:c;//���
	max1=a<b?a:b;
	max1=max1<c?max1:c;//��С
	max2=a+b+c-(max1+max);//�м�
	printf("%d%d%d",max,max2,max1);
	//int a,b,c,d,n;
	//printf("������һ��ֵ��λ����");
	//scanf("%d",&n);
	//a=n/100;
	//b=n/10%10;
	//c=n/1%10;
	//if(a<b);
	//{d=a;a=b;b=d;}
	//if(a<c)
	//{d=a,a=c;c=d;}
	//if(b<c)
	//{d=b;b=c;c=d;}
	//printf("%d%d%d",a,b,c);
	}