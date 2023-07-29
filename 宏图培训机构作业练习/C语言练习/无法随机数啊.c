/* Note:Your choice is C IDE */
#include "stdio.h"
#include "time.h"
#include "stdlib.h"

void main()
{
	int i,j;
	char a;
	randomize();//要调用随机种子
	do{
		for(j=1;j<10;j++){
			
  	  		i=(random(30)+1);
  	  		if(i==1){
  	  			printf("呵呵");
  	  		}
    		getch();
    		
    		printf("按任意键继续，按n结束");
			scanf("%c",&a);
			if(a=='n'){
				break;
			}	
			j=5;
		}
		
	}while(a!='n');
}