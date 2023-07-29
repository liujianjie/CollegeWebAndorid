/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    	int a,b[5];
    
		printf("       *************************************************************\n");
		                   
		printf("       *                                                           *\n");
		                                                       
		printf("       *                                                           *\n");
		printf("       *                     欢迎来到天朝银行                      *\n");
		printf("       *                                                           *\n");
		                                  
		printf("       *                                                           *\n");
		                 
		printf("       *                                                           *\n");
		
		printf("       *************************************************************\n");
		printf("\n");
		printf("\n");
		printf("\n");
		printf("                           请选择你需要的服务\n");
		printf("                             1.存款\n");
		printf("                             2.取款\n");
		printf("                             3.开户\n");
		printf("                             4.查询余额\n");
		printf("                             5.转账\n");
		printf("                             6.退出\n");
		do{
		printf("                           请输入你需要的服务：");
	 	scanf("%d",&a);
	 	
	 	switch(a){
	 		case 1:
	 			printf("                           你选择了存款业务。\n");
	 			break;
			case 2:
				printf("                           你选择了取款业务。\n");
				break;
			case 3:
				printf("                           你选择了开户业务。\n");
				break;
			case 4:
				printf("                           你的余额为...对不起系统错误。\n");
				break;
			case 5:
				printf("                           转账...此时无法实现此操作。\n");
				break;
			case 6:
				printf("                           退出成功，欢迎下次再来。\n");
				break;
			default:
				printf("                           输入错误，请重新选择。\n");
	 	}
    	}while(a!=6);
}