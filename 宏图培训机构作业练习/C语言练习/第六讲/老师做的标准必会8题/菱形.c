/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
/*
		*
	   ***
	  *****
	 *******
	  *****
	   ***
	    *
	1、行号等于字符数
	2、星号的个数：行数*2-1
	3、空格个数：（字符数-星号数）/2
*/
	//输出菱形 
    int line,start,space,i,j,mid;
    printf("请输入行号：（奇数）");
    scanf("%d",&line);
    mid=line/2+1;
    for(i=1;i<=mid;i++){ //控制菱形的行数
    	//计算星号个数
    	start=i*2-1;
    	//打印空格
    	space=(line-start)/2;
    	for(j=1;j<=space;j++){
    		printf(" ");	
    	}
    	//打印星号
    	for(j=1;j<=start;j++){
    		printf("*");	
    	}
    	printf("\n");
    }
    //
    for(i=mid-1;i>0;i--){ //控制菱形的行数
    	//计算星号个数
    	start=i*2-1;
    	//打印空格
    	space=(line-start)/2;
    	for(j=1;j<=space;j++){
    		printf(" ");	
    	}
    	//打印星号
    	for(j=1;j<=start;j++){
    		printf("*");	
    	}
    	printf("\n");
    }
}