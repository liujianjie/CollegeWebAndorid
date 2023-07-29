/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //猜数游戏 
    int a=66,b;
    do{
    	printf("请输入一个数：");
    	scanf("%d",&b);
    	if(b>a){
    		printf("猜大了！\n");
    	}
    	if(b<a){
    		printf("猜小了！\n");
    	}
    }while(b!=66);
    printf("恭喜你，你才中了！！！");
}