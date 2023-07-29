#include "stdio.h"
void main(){
	int a,b,c=0;
	for(a=1;a<=1000;a++){//控制要找的完数的范围
		c=0;//要初始c 下面计算完后
		for(b=1;b<a;b++){//计算因子之和
			if(a%b==0){ //判断j是否为i的因子
				c+=b;
			}	
		}
		if(a==c){
		printf("%d\n",a);
		}
	}
}