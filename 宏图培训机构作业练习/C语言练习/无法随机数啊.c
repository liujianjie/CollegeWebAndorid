/* Note:Your choice is C IDE */
#include "stdio.h"
#include "time.h"
#include "stdlib.h"

void main()
{
	int i,j;
	char a;
	randomize();//Ҫ�����������
	do{
		for(j=1;j<10;j++){
			
  	  		i=(random(30)+1);
  	  		if(i==1){
  	  			printf("�Ǻ�");
  	  		}
    		getch();
    		
    		printf("���������������n����");
			scanf("%c",&a);
			if(a=='n'){
				break;
			}	
			j=5;
		}
		
	}while(a!='n');
}