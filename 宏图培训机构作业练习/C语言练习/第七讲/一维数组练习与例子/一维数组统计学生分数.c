#include "stdio.h"
void main(){
	int a[5],c=0,b=0,i;
	printf("请输入5个学生的成绩（空格隔开）：");
	for(i=0;i<5;i++){
		scanf("%d",&a[i]);
		if(a[i]<60){
			c++;
		}
		if(a[i]>=80){
			b++;
		}
	}
	printf("\n");
	printf("这5个学生的成绩为：\n");
	for(i=0;i<5;i++){
		printf("%d\t",a[i]);
	}
	printf("\n");
	printf("小于60分的有：%d个\n",c);
	printf("大于80分的有：%d个\n",b);
	
	
}