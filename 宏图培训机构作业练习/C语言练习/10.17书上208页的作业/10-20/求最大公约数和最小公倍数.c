/* Note:Your choice is C IDE */
#include "stdio.h"
//�Ժ�������ԭ������
int gys(int ,int );
void gbs(int ,int );
void main()
{
	int max,a,b;
    //д�����������ֱ��������������Լ������С������
    printf("������������");
    scanf("%d %d",&a,&b);
    max=gys(a,b);
    printf("%d��%d�������������Լ����:%d\n",a,b,max);
    gbs(a,b);
}
//�����Լ��
int gys(int a,int b){
	int max=0,i,min;
	min=a>b?b:a;//����ѭ������
	for(i=1;i<=min;i++){
		if(a%i==0 && b%i==0){ //��a,b�������Ĺ�Լ��
			if(max<i){
				max=i;
			}
		}
	}
	return max;
}
//����С������
void gbs(int x,int y){
	int min=10086,max,i;
	max=x>y?x:y; //��С������һ���Ǵ��ڵ���x,y����һ����
	for(i=max;;i++){
		if(i%x==0 && i%y==0){
			min=i;
			break;
		}
	}
	printf("%d��%d������������С��������:%d",x,y,min);
}