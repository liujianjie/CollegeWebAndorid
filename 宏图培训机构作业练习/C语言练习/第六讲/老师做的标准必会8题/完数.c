/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	/*一个数如果刚好与它的所有的因子之和相等，则称该数为完数，如6=1+2+3，
		求出1000以内的所有完数	
		提示：用循环判断1-n之间的数是否为n的因子，是的话累加，要用到双重循环
	*/
	int i,j,sum=0;
	for(i=1;i<=1000;i++){ //控制要找的完数的范围  此时i =6
		sum=0;
		for(j=1;j<i;j++){  //计算因子之和
			if(i%j==0)     //判断j是否为i的因子
				sum+=j;    
		}
		if(i==sum){
			printf("%d\t",i);		
		}
	}
    
}