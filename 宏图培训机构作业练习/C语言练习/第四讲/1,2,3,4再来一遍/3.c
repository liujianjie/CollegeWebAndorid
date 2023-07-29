#include "stdio.h"
void main(){
	int a;
	printf("请输入你的分数：");
	scanf("%d",&a);
	if(a>=90&&a<=100){
		printf("考这么好 说是不是抄的");
		
	}else if(60<=a&&a<90){
		printf("能考这样不错了");
	
	}else if(a>=0&&a<60){
		printf("考上这个是需要勇气和才能的");
	}else if(a<0){
		printf("老师都被你打败了吧！");
	}else {
		printf("作弊都没点技术含量");
		}
	
	
	
	
	
	}