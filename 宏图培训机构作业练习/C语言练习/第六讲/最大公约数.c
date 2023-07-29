#include "stdio.h"
void main(){
	int a,b,c,max=0;
	printf("请输入两个数（空格隔开）：");
	scanf("%d %d",&a,&b);
	for(c=1;c<=a&&c<=b;c++){
		if(a%c==0&&b%c==0){
			if(c>max){
			max=c;
			}
		}
	}
	printf("最大公约数是：%d",max);
}