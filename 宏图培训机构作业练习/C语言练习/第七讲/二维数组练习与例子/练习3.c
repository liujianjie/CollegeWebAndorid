#include "stdio.h"
void main(){
	int i,j,s,a[100],b=0,c=0;
	printf("请输入一个数：");	
	scanf("%d",&s);
	for(i=0;i<100;i++){
		if(s%2==0){
			a[i]=0;
			s=s/2;
			if(s>0){
				b++;
			}
		}else{
			a[i]=1;
			s=s/2;
			if(s>0){
				c++;
			}
		}
		
	}
	for(i=b+c;i>=0;i--){
		printf("%d",a[i]);
	}
	
	
	
	
}