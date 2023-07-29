#include "stdio.h"
void main(){
	int a=1,b=0;
	while(a<101){
		b=a+b;
		a++;
		}
	printf("1+2+3....+100=%d",b);
	
	}