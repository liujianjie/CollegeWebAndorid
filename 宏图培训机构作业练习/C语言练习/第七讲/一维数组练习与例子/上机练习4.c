#include "stdio.h"
void main(){
	int a[100],i,b=0,c=0;
	for(i=0;i<100;i++){
		a[i]=i;//���±긳ֵ
		
	}
	printf("ż���У�\n");
	for(i=99;i>=0;i--){
		if(a[i]%2==0){
			b++;
			printf("%d  ",a[i]);
		}
		if(b%13==0){
			printf("\n");	
		}
	}
	printf("\n");
	printf("�����У�\n");
	for(i=99;i>=0;i--){
		if(a[i]%2!=0){
			c++;
			printf("%d  ",a[i]);
		}
		if(c%13==0){
			printf("\n");	
		}
	}
}