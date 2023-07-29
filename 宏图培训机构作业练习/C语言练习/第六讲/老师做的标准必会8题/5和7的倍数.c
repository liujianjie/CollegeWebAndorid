/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //输入一个数，判断是否为5和7的倍数，用户可以循环输入，直到按n退出
    int num;
    char c;
    do{
    	printf("请输入您要判断的数：");
    	scanf("%d",&num);
    	if(num%5==0 && num%7==0){//判断这个数是5的倍数且也是7的倍数
    		printf("%d这个数是5和7的倍数！\n",num);
    	}else{
    		printf("%d这个数不是5和7的倍数！\n",num);
    	}
    	printf("按任意键继续，按n退出");
    	fflush(stdin);
    	scanf("%c",&c);
    }while(c!='n');
}