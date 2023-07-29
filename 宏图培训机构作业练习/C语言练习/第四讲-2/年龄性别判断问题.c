#include "stdio.h"
void main(){
	int a,b;
	printf("请输入你的性别 0是女，1是男：");
	scanf("%d",&a);
	printf("请俗人你的年龄：");
	scanf("%d",&b);
	if(a==0){
		if(18>b>0){
			printf("小美女");
		}else if(18<=b&&b<40){
			printf("亲爱的姑娘，请给我一支兰洲");
		}else{printf("女人");}
	}else{if(18>b>0){
			printf("小帅哥");
		}else if(18<=b&&b<40){
			printf("先生");
		}else{printf("男人");}
	}
	}