/* Note:Your choice is C IDE */
#include "stdio.h"
#define N 50
struct ban{
	char name[20];
	float zhang;
	float mima;
	float money;	
}b[N];
int count=0;//全局变量
void kaihu();
void cunkuan();
void qukuan();
void zhuanzhang();
void chaxun();
void xiugai();
void jian();
void main()
{
		int a;
		do{
		printf("\t*************************************************************\n");                   
		printf("\t*                                                           *\n");
		printf("\t*                     欢迎来到天朝银行                      *\n");
		printf("\t*                                                           *\n");                               
		printf("\t*                                                           *\n");              
		printf("\t*************************************************************\n");
		printf("\n");
		printf("\n");
		printf("\t\t\t   请选择你需要的服务\n");
		printf("\t\t\t   1.开户\n");
		printf("\t\t\t   2.存款\n");
		printf("\t\t\t   3.取款\n");
		printf("\t\t\t   4.转账\n");
		printf("\t\t\t   5.查询余额\n");
		printf("\t\t\t   6.修改密码\n");
		printf("\t\t\t   7.退出\n");
		printf("\t\t\t   请输入你需要的服务：");
	 	scanf("%d",&a);
	 	switch(a){
	 		case 1:
	 			kaihu();	
	 			break;
	 		case 2:
	 			cunkuan();	
	 			break;
			case 3:
				qukuan();
				break;
			case 4:
				zhuanzhang();
				break;
			case 5:
				chaxun();
				break;
			case 6:
				xiugai();
				break;
			case 7:
				printf("\t\t\t   退出成功，欢迎下次再来。\n");
				break;
			default:
				printf("\t\t\t   输入错误，请重新选择。\n");
				break;
	 	}
	 	printf("\t\t\t   按任意键继续");
	 	getch();
	 	system("cls");
	 	}while(a!=7);	
}
//break;return;退出函数
void kaihu(){
	float mima;
	if(count+1>=N){
		printf("\t\t\t   用户已超过系统存储，请等待。\n");
		return;
	}
		printf("\t\t\t   请输入你的用户名:");
		scanf("%s",&b[count].name);
	 	printf("\t\t\t   请设置你的账号:");
	 	scanf("%f",&b[count].zhang);
	 	printf("\t\t\t   请设置你的密码:");
	 	scanf("%f",&b[count].mima);
	 	printf("\t\t\t   请确认你的密码：");
	 	scanf("%f",&mima);
	 	if(b[count].mima==mima){
	 		printf("\t\t\t   开户成功\n");
	 	}else{
	 		printf("\t\t\t   您两次输入的密码不一致，开户失败。\n");
	 		return;
	 	}
	 	printf("\t\t\t   请输入你的开户金额：");
	 	scanf("%f",&b[count].money);
		count++;
}
void cunkuan(){
	float zhang,mima,m;
	int i,j=0;
	printf("\t\t\t   请输入你的账号：");
	scanf("%f",&zhang);
	printf("\t\t\t   请输入你的密码：");
	scanf("%f",&mima);
	for(i=0;i<count;i++){
		if(b[i].zhang!=zhang||b[i].mima!=mima){
			do{
				printf("\t\t\t   你的密码或账号有误，请重新输入\n");//		if(b[i][1]!=zhang||b[i][2]!=mima){printf("\t\t\t   你输入的账户或密码错误\n");return;														
				printf("\t\t\t   你输入了%d次，共有3次。\n",j+1);
				printf("\t\t\t   请输入你的账号：");
				scanf("%f",&zhang);
				printf("\t\t\t   请输入你的密码：");
				scanf("%f",&mima);
				if(b[i].zhang==zhang&&b[i].mima==mima){
					break;
				}
				j++;
			}while(j<2);
		}
	    if(b[i].zhang==zhang&&b[i].mima==mima){
	    	printf("\t\t\t   你的用户名为%s,余额为%.2f",b[i].name,b[i].money);
	    	printf("\n");
	    	printf("\t\t\t   请输入你要存款的金额：");
	  		scanf("%f",&m);
	  		b[i].money=b[i].money+m;
	  		printf("\t\t\t   你的账号为%s,存款为%.2f,余额为%.2f\n",b[i].name,m,b[i].money);
	  		break;
		}
	}
	if(i>=count){
	printf("\t\t\t   您的用户信息有误，存款失败\n");
	}
}
void qukuan(){
	float zhang,mima,m;
	int i;
	printf("\t\t\t   请输入你的账号：");
	scanf("%f",&zhang);
	printf("\t\t\t   请输入你的密码：");
	scanf("%f",&mima);
	for(i=0;i<count;i++){
	    if(b[i].zhang==zhang&&b[i].mima==mima){
	    	printf("\t\t\t   你的用户名为%s,余额为%.2f\n",b[i].name,b[i].money);
	    	printf("\t\t\t   请输入你要取款的金额：");
	  		scanf("%f",&m);
	  		if(m<=b[i].money){
	  			b[i].money=b[i].money-m;
	  			printf("\t\t\t   你的账号为%s,取款为%.2f,余额为%.2f\n",b[i].name,m,b[i].money);
	  		}else{
	  			printf("\t\t\t   你账号余额不足，请存款。\n");
	  			break;
	  		}
	  		
		}
	}
	if(i>=count){
		printf("\t\t\t   您的用户信息有误，存款失败\n");
	}
}	
void zhuanzhang(){
	float zhang,mima,zhang2,m;
	int i,j;
	printf("\t\t\t   请输入你的账号：");
	scanf("%f",&zhang);
	printf("\t\t\t   请输入你的密码：");
	scanf("%f",&mima);
	for(i=0;i<count;i++){
		if(b[i].zhang==zhang&&b[i].mima==mima){
				printf("\t\t\t   请输入对方的账号：");
				scanf("%f",&zhang2);
				for(j=0;j<count;j++){
				if(b[j].zhang==zhang2){
					printf("\t\t\t   请输入你转账的金额：");
					scanf("%f",&m);
					if(m<=b[i].money){
						b[i].mima=b[i].mima-m;
						b[j].mima=b[j].mima-m;
						printf("\t\t\t   转账成功，你的余额为%.2f\n",b[i].mima);
						return;
					}else{
						printf("\t\t\t   你的账户余额不足，请充值\n");
						break;
					}
				}
			}
			if(i>=count){
				printf("\t\t\t   你输入对方的账号有误,转账失败\n");
				return;
			}
		}
	}
	if(i>=count){
		printf("\t\t\t   您的用户信息有误，转账失败\n");
	}
}
void chaxun(){
	float zhang,mima;
	int i;
	printf("\t\t\t   请输入你的账号：");
	scanf("%f",&zhang);
	printf("\t\t\t   请输入你的密码：");
	scanf("%f",&mima);
	for(i=0;i<count;i++){
		if(b[i].zhang==zhang&&b[i].mima==mima){
			printf("\t\t\t   你的用户名为%s，余额为%.2f\n",b[i].name,b[i].money);
			return;
		}else{
			printf("\t\t\t   你输入的账号或密码有误。\n");
			return;
		}
	}
	if(i>=count){
		printf("\t\t\t   您输入的用户信息有误，请重新输入。\n");
	}
}
void xiugai(){
	float zhang,mima,mima2,mima3;
	int i;
	printf("\t\t\t   请输入您的账号：");
	scanf("%f",&zhang);
	printf("\t\t\t   请输入您的密码：");
	scanf("%f",&mima);
	for(i=0;i<count;i++){
		if(b[i].zhang==zhang&&b[i].mima==mima){
			printf("\t\t\t   你当前密码为%.0f\n",b[i].mima);
			printf("\t\t\t   请输入你要修改的密码：");
			scanf("%f",&mima2);
			printf("\t\t\t   请再次确认要修改的密码：");
			scanf("%f",&mima3);
			if(mima2==mima3){
				b[i].mima=mima2;
				printf("\t\t\t   修改成功，当前密码为%.0f：\n",b[i].mima);
				return;
			}else{
				printf("\t\t\t   两次输入的密码不一致，修改失败\n");
				return;
			}
		}else{
			printf("\t\t\t   您的密码或账号有误，修改密码失败\n");
			return;
		}
	}
	if(i>=count){
		printf("\t\t\t   您输入的用户信息有误，请重新输入。\n");
	}
}
