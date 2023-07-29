/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    	int a,b[5],c[5],i,d=1,e=1;
    	b[2]=0;
    	b[3]=0;
    	b[4]=0;
		printf("\t*************************************************************\n");
		                   
		printf("\t*                                                           *\n");
		                                                       
		printf("\t*                                                           *\n");
		printf("\t*                     欢迎来到天朝银行                      *\n");
		printf("\t*                                                           *\n");
		                                  
		printf("\t*                                                           *\n");
		                 
		printf("\t*                                                           *\n");
		
		printf("\t*************************************************************\n");
		printf("\n");
		printf("\n");
		printf("\n");
		do{
		printf("\t\t\t   请选择你需要的服务\n");
		printf("\t\t\t   1.开户注册\n");
		printf("\t\t\t   2.登入\n");
		printf("\t\t\t   3.存款\n");
		printf("\t\t\t   4.取款\n");
		printf("\t\t\t   5.转账\n");
		printf("\t\t\t   6.查询余额\n");
		printf("\t\t\t   7.退出\n");
		printf("\t\t\t   请输入你需要的服务：");
	 	scanf("%d",&a);
	 	switch(a){
	 		case 1:
	 			system("cls");
	 			printf("\t\t\t   你选择了开户注册业务。\n");
	 			printf("\t\t\t   请设置你的账号:");
	 			scanf("\t\t\t   %d",&b[0]);
	 			printf("\t\t\t   请设置你的密码:");
	 			scanf("\t\t\t   %d",&b[1]);
				printf("\t\t\t   开户成功,请选择登入界面。\n");	
	 			break;
	 		case 2:
				system("cls");
				printf("\t\t\t   你选择了登入界面。\n");
				for(i=1;i<=3;i++){
	 				printf("\t\t\t   请输入你的账号：");
	 				scanf("\t\t\t   %d",&c[0]);
	 				if(b[0]!=c[0]){
	 				printf("\t\t\t   账号错误，请重新输入(您已经输了了%d次，总共能输3次)。\n",i);
	 				d=0;
	 				}
	 				if(c[0]==b[0]){
	 				printf("\t\t\t   账号正确。\n");
	 				d=1;
	 				break;
	 				}
				}
				if(d==1){
				for(i=1;i<=3;i++){
	 				printf("\t\t\t   请输入你的密码：");
	 				scanf("\t\t\t   %d",&c[1]);
	 				if(b[1]!=c[1]){
	 				printf("\t\t\t   密码错误，请重新输入(您已经输入了%d次，总共能输3次)。\n",i);
	 				}
	 				if(c[1]==b[1]){
	 				printf("\t\t\t   密码正确。\n");
	 				break;
	 				}
				}
				printf("\t\t\t   登入成功，请选择其它业务。\n");
				e=0;
				}	
	 			break;
			case 3:
				system("cls");
				if(e==0){
					printf("\t\t\t   你选择了存款业务。\n");
					printf("\t\t\t   请输入你存款的金额：");
					scanf("\t\t\t   %d",&b[2]);
					printf("\t\t\t   存款成功，请选择其它业务。\n");
					
				}
				if(e==1){
					printf("\n");
					printf("\n");
					printf("\t\t\t   请注册并且登入，谢谢合作。\n\n");
				}
				break;
			case 4:
				system("cls");
				if(e==0){
					printf("\t\t\t   你选择了取款业务。\n");
					printf("\t\t\t   请输入你的取款金额：");
					scanf("\t\t\t   %d",&b[3]);
					if(b[2]>=b[3]){
					printf("\t\t\t   取款成功，请选择其它业务。\n");
					}
				if(b[2]<=b[3]){
					printf("\t\t\t   对不起，余额不足，请重新输入。");
				}
				}
				if(e==1){
					printf("\n");
					printf("\n");
					printf("\t\t\t   请注册并且登入，谢谢合作。\n\n");
				}
				break;
			case 5:
				system("cls");
				if(e==0){
					printf("\t\t\t   欢迎来到转账界面\n");
					printf("\t\t\t   请输入对方账号:");
					scanf("%d",&c[4]);
					printf("\t\t\t   请输入金额:");
					scanf("%d",&b[4]);
				}
				
				if(e==1){
					printf("\n");
					printf("\n");
					printf("\t\t\t   请注册并且登入，谢谢合作。\n\n");
				}
				break;
			case 6:
				system("cls");
				if(e==0){
					printf("\t\t\t   你选择了查询余额\n");
					printf("\t\t\t   你的余额为：%d\n",b[2]-b[3]-b[4]);
				}
				if(e==1){
					printf("\n");
					printf("\n");
					printf("\t\t\t   请注册并且登入，谢谢合作。\n\n");
				}
				break;
			case 7:
				printf("\t\t\t   退出成功，欢迎下次再来。\n");
				break;
			default:
				printf("\t\t\t   输入错误，请重新选择。\n");
	 	}
	 	}while(a!=7);
		
}