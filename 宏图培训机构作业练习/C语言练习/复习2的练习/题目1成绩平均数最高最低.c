#include "stdio.h"
void main(){
	float a,b,c=0,max=0,min=200000003;
	for(a=1;a<6;a++){
		printf("请输入第%.0f位同学成绩：",a);
		scanf("%f",&b);
		c+=b;
		if(max<=b){
			max=b;
		}
		if(min>=b){
			min=b;
		}
	}
	printf("这个数的最大的是%.0f\n",max);
	printf("这个数的最小的是%.0f\n",min);
	printf("这个数的平均数是：%.2f\n",c/5);
}