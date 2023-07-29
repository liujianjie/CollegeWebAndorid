/* Note:Your choice is C IDE */
#include "stdio.h"
int age(int a);
void main()
{
    /*
    	函数的递归调用：
    		在调用一个函数的过程当中又出现了直接或间接地调用该函数本身，称之为函数的递归调用
     	五个同学坐一起，问第五个同学几岁了，他说比第4个同学大两岁，又问第4个，说比第3个大两岁
     	问第3个，说比第2个大两岁，问第2个，然后比第一个大2岁，最后第一个说他10岁，问第5个同学几岁	
    */
    printf("%d",age(5));
}

int age(int n){
	int c;//返回值
	//age(1)=10
	//age2=age(1)+2=12
	
	if(n==1){
		c=10;
	}else{
		// c=age(4)+2
		c=age(n-1)+2;
	}	
	return c;
}