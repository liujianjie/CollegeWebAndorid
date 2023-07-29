#include "stdio.h"
int sum(int a,int b);
void main(){
	int c;
	int a=4,b=5;
	c=sum(a,b);
	printf("%d",c);
}
int sum(int a,int b){
	int c;
	a++;
	b++;
	c=a+b;
	return c;
}