/* Note:Your choice is C IDE */
#include "stdio.h"
int yue(int x,int y){
	int i,max=0,min;
	min=x>y?y:x;
	for(i=1;i<=min;i++){
		if(x%i==0&&y%i==0){
			if(max<=i){
				max=i;
			}
		}
	}
	return max;
}
void bei(int x,int y){
	int i,max=10001,min;
	min=x>y?y:x;
	for(i=10000;i>=min;i--){
		if(i%x==0&&i%y==0){
			if(max>i){
				max=i;
			}
		}
	}
	printf("��С�������ǣ�%d",max);
}
void main()
{
	int a,b,c;
	printf("��������������(�ÿո����)��");
	scanf("%d %d",&a,&b);
	c=yue(a,b);
	printf("�������������Լ��Ϊ%d",c);
	bei(a,b);
}