#include "stdio.h"
void main(){
	int a,b,c,max=0;
	printf("���������������ո��������");
	scanf("%d %d",&a,&b);
	for(c=1;c<=a&&c<=b;c++){
		if(a%c==0&&b%c==0){
			if(c>max){
			max=c;
			}
		}
	}
	printf("���Լ���ǣ�%d",max);
}