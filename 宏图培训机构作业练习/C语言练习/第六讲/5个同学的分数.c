#include "stdio.h"
void main(){
	int a=1,b,max=0,min=123123,sum=0;
	while(a<6){
		printf("请输入第%d同学的成绩：",a);
		scanf("%d",&b);
		a++;
		sum+=b;
		if(max<=b){
			max=b;
		}
		if(min>=b){
			min=b;	
		}
	}	printf("平均数是%d，最大的分数是%d，最小的分数是%d",sum/5,max,min);
}