/* Note:Your choice is C IDE */
#include "stdio.h"
#define n 2
struct student{
	int num;
	char name[20];	
	char sex[10];
	int age;
}a[n];
void main()
{
    int i;
    for(i=0;i<n;i++){
    	printf("请输入第%d个的学号：",i+1);
    	scanf("%d",&a[i].num);
    	printf("请输入第%d个的姓名：",i+1);
    	scanf("%s",&a[i].name);
    	printf("请输入第%d个的性别：",i+1);
    	scanf("%s",&a[i].sex);
    	printf("请输入第%d个的年龄：",i+1);
    	scanf("%d",&a[i].age);    	
    }
    printf("学号\t姓名\t性别\t年龄\n");
    for(i=0;i<n;i++){
    	printf("%d\t",a[i].num);
    	printf("%s\t",a[i].name);
    	printf("%s\t",a[i].sex);
    	printf("%d\t",a[i].age);
    	printf("\n");
    }
}