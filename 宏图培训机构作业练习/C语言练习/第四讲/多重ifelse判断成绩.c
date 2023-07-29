#include "stdio.h"
void main(){
	int x;
	printf("请输入你的数：");
	scanf("%d",&x);
	if(x>=90){
		printf("优");
	}else if(x>=70&&x<90){
	    printf("良");
	}else if(x>=60&&x<70){
		printf("中");	
	}else if(x>0&&x<60){
		printf("差");
}else{printf("你太牛了");}
	
	
	
	
	
	
	
	
	
	
	
	
	
	}