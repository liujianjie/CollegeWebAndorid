/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	//10����������ִ�ŵ�1ά�����У����۰���ҷ�����һ�������ж�������Ƿ���������
    /*
    	a[10]={10,9,8,7,6,5,4,3,2,1}
    	�۰���ҷ����������������
    		��ּ���Ƚ�����ֳ����룬Ȼ���ж�Ҫ���ҵ��������м�������߻����ұ�
    	��2���Ȱ�����ֳ����� mid=(left+right)/2=a[4]=6
    		 2<6,left=mid+1,right=9,mid=(left+right)/2=5 a[mid]=a[7]=3
    		 2<3 ,left=mid+1,right=9,mid=(left+right)/2=a[8]=2
    	��8���Ȱ�����ֳ����� mid=(left+right)/2=a[4]=6
    	 6<8,left=0;right=mid-1,mid=(left+right)/2=a[1]=9
    	 9>8,left=mid+1 right=3 mid=(2+3)/2=2  a[mid]=a[2]=8;
    */
    int a[10]={10,9,8,7,6,5,4,3,2,1};
    int mid,left=0,right=9,i,num,flag=0;
    printf("��������Ҫ���ҵ�����");
    scanf("%d",&num);
    while(left<right){
    	mid=(left+right)/2;
    	if(a[mid]<num){
    		right=mid-1;
    	}	
    	if(a[mid]>num){
    		left=mid+1;
    	}
    	if(a[mid]==num){
    		flag=1;
    		printf("��ϲ�������ڵ�%d��λ���ҵ��������",mid+1);	
    		break;
    	}
    }
    if(flag==0){
    	printf("��Ҫ���ҵ���������");
    }
}