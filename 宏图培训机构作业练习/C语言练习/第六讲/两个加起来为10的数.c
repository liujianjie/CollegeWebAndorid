#include "stdio.h"
void main(){
	int a,b;
	for(a=1;a<10;a++){
		for(b=1;b<10;b++){	
			if(a+b==10){
			printf("%d+%d=%d\n",a,b,a+b);	
			}
		}
		
	}

}