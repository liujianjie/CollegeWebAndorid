#include "stdio.h"
void main(){
	int a[20],i,o=0,j=0;
	printf("������20��������\n");
	for(i=0;i<20;i++){
	scanf("%d",&a[i]);
	if(a[i]%2==0){
		o++;
	}
	else{
		j++;
		
	}
	}
	printf("�������ż����%d����������%d��",o,j);
}