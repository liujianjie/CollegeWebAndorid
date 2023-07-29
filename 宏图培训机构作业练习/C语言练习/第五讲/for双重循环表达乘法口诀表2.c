#include "stdio.h"
void main(){
	int i,j;
	for(i=1;i<10;i++){
		for(j=1;j<=10;j++){
			printf("%d*%d=%d\t",j,i,j*i);
			if(i==j){
				break;
			}
		}
		printf("\n");
	}	
}