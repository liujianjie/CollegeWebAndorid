#include "stdio.h"
void main(){
	int a,b,c,max;
	printf("请输入两个数（空格隔开）：");
	scanf("%d %d",&a,&b);//输入数
	for(c=1;c<=a&&c<=b;c++){//公约数小于2位数才会进入循环，且公约数最小为1
		if(a%c==0&&b%c==0){//两个数同除一个数为0得到的数是公约数
			if(c>max){//比出最大的公约数
				max=c;
			}
		}
	}	printf("最大公约数是：%d",max);
}