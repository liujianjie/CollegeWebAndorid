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
	printf("最小公倍数是：%d",max);
}
void main()
{
	int a,b,c;
	printf("请输入两个整数(用空格隔开)：");
	scanf("%d %d",&a,&b);
	c=yue(a,b);
	printf("这两个数的最大公约数为%d",c);
	bei(a,b);
}