#include "stdio.h"
void main(){
	int a,b;
	printf("你的性别，1是男，2是女：");
	scanf("%d",&a);
	printf("你的年龄:");
	scanf("%d",&b);
	if(a==2){
		if(18>b>0){
				printf("小");
		}else if(18<=b&&b<50){
				printf("中");
		}else{printf("大");} 	
	}
	if(a==1)	
		{if(18>b>0){
				printf("帅");
		}else if(18<=b&&b<50){
				printf("中帅");
		}else{printf("大帅");} 
		}else{printf("傻逼吧你，说了按照我说的数分别性别，脑子被驴踢了吧");}
	
	
	
	
	
	}