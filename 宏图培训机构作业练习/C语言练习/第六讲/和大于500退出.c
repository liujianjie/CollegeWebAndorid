#include "stdio.h"
void main(){
	int a,sum=0;
	for(a=1;sum<500;a++){
		sum+=a;
		printf("%d\t",sum);	
		if(sum>=496){
			break;
			}
	}printf("sum大于500了退出");

}