/* Note:Your choice is C IDE */
#include "stdio.h"
//对函数进行原型申明
int gys(int ,int );
void gbs(int ,int );
void main()
{
	int max,a,b;
    //写两个函数，分别求两个数的最大公约数和最小公倍数
    printf("请输入两个数");
    scanf("%d %d",&a,&b);
    max=gys(a,b);
    printf("%d和%d这两个数的最大公约数是:%d\n",a,b,max);
    gbs(a,b);
}
//求最大公约数
int gys(int a,int b){
	int max=0,i,min;
	min=a>b?b:a;//减少循环次数
	for(i=1;i<=min;i++){
		if(a%i==0 && b%i==0){ //求a,b两个数的公约数
			if(max<i){
				max=i;
			}
		}
	}
	return max;
}
//求最小公倍数
void gbs(int x,int y){
	int min=10086,max,i;
	max=x>y?x:y; //最小公倍数一定是大于等于x,y任意一个数
	for(i=max;;i++){
		if(i%x==0 && i%y==0){
			min=i;
			break;
		}
	}
	printf("%d和%d这两个数的最小公倍数是:%d",x,y,min);
}