#include "stdio.h"
void main(){
	int i,j,sum=0;
	for(i=1;i<=1000;i++){
		sum=0;
		for(j=1;j<i;j++){
			if(i%j==0){
			sum+=j;}
		}
		if(i==sum){
		printf("%d\t",i);	
		}
	}
}