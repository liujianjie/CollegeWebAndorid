#include "stdio.h"
void main(){
	int a,b,c,d;	
	for(a=0;a<20;a++){
		for(b=0;b<33;b++){
			c=100-a-b;
			d=a*5+b*3+c/3;
			if(c%3==0&&a+b+c==100&&d==100){
			printf("公鸡%d只，母鸡%d只，小鸡%d只\n",a,b,c);
			
				
			}
		}
	
		
	}
}