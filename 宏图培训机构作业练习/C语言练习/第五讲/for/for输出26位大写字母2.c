#include "stdio.h"
void main(){
	int i;
	char a;	
	for(i=65;i<=90;i++){
		a=i;
		printf("%c\t",a);
		a=i+32;
		printf("%c\t",a);
	}

	
}