#include "stdio.h"
void main(){
	int a[30],i,j=0;
	float l,sum=0;
	printf("请输入30个c语言同学的成绩(空格隔开)：\n");
	for(i=0;i<30;i++){
		scanf("%d",&a[i]);
		sum+=a[i];
		if(a[i]>=60){
			j++;
		}
		
	}
	printf("这个班的及格人数为：%d",j);
	l=j/30.0*100;
	printf("这个班的平均成绩为：%.2f,及格率为：%.2f%%",sum/30,l);
	
}