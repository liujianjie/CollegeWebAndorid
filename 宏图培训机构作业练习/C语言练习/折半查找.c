/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	//10个有序的数字存放到1维数组中，用折半查找法查找一个数，判断这个数是否在数组中
    /*
    	a[10]={10,9,8,7,6,5,4,3,2,1}
    	折半查找法：（数组必须有序）
    		宗旨：先将数组分成两半，然后判断要查找的数是在中间数的左边还是右边
    	找2：先把数组分成两半 mid=(left+right)/2=a[4]=6
    		 2<6,left=mid+1,right=9,mid=(left+right)/2=5 a[mid]=a[7]=3
    		 2<3 ,left=mid+1,right=9,mid=(left+right)/2=a[8]=2
    	找8：先把数组分成两半 mid=(left+right)/2=a[4]=6
    	 6<8,left=0;right=mid-1,mid=(left+right)/2=a[1]=9
    	 9>8,left=mid+1 right=3 mid=(2+3)/2=2  a[mid]=a[2]=8;
    */
    int a[10]={10,9,8,7,6,5,4,3,2,1};
    int mid,left=0,right=9,i,num,flag=0;
    printf("请输入您要查找的数：");
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
    		printf("恭喜您，您在第%d个位置找到了这个数",mid+1);	
    		break;
    	}
    }
    if(flag==0){
    	printf("您要查找的数不存在");
    }
}