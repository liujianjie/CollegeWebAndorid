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
    	printf("�������%d����ѧ�ţ�",i+1);
    	scanf("%d",&a[i].num);
    	printf("�������%d����������",i+1);
    	scanf("%s",&a[i].name);
    	printf("�������%d�����Ա�",i+1);
    	scanf("%s",&a[i].sex);
    	printf("�������%d�������䣺",i+1);
    	scanf("%d",&a[i].age);    	
    }
    printf("ѧ��\t����\t�Ա�\t����\n");
    for(i=0;i<n;i++){
    	printf("%d\t",a[i].num);
    	printf("%s\t",a[i].name);
    	printf("%s\t",a[i].sex);
    	printf("%d\t",a[i].age);
    	printf("\n");
    }
}