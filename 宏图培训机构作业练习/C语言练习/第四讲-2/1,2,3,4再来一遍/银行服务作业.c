#include "stdio.h"
void main(){
	int a;
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
		printf("                           请输入你需要的服务：");
		scanf("%d",&a);
		switch(a){
			case 1:
				printf("                          你选择了存款业务");
				break;
			case 2:
				printf("                          你选择了取款业务");
				break;
			case 3:
				printf("                          你选择了开户业务");
				break;
			case 4:
				printf("                          查询余额。。。没有");
				break;
			case 5:
				printf("                          转账？对不起没这功能");
				break;
			case 6:
				printf("                          退出成功，欢迎下次再来。");
				break;
			default:
				printf("                          骚年，你按错了，请重新再来。");
			
			
			}
	
	
	

	
	
	
	}