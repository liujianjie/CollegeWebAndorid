/* Note:Your choice is C IDE */
#include "stdio.h"
//����ԭ������
void sushu(int );
void main()
{
	int a;
    printf("������һ������");
    scanf("%d",&a);
    sushu(a);
}
//�жϸ����Ƿ�Ϊ����
void sushu(int a){
	int i,flag=0;
	for(i=2;i<a;i++){
		if(a%i==0){
			flag=1;
			break;	
		}	
	}
	if(flag==0){
		printf("%d������",a);
	}else{
		printf("%d��������",a);
	}
}