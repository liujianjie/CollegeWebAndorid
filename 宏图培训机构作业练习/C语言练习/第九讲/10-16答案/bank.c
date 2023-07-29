/* Note:Your choice is C IDE */
#include "stdio.h"
#define N 50  //定义一个常量
float bank[N][4];
int count=0;
//申明函数
//开户
void kaihu();
//存款
void cunkuan();
//取款
void qukuan();
//转账
void zhuanzhang();
//查询余额
void chaxun();
//修改密码
void xiugai();
void main()
{
	int n;
	do{
		printf("\t\t**********************⊙*************************\n");
		printf("\t\t*                                               *\n");
		printf("\t\t*                                               *\n");
		printf("\t\t*          ◎   欢迎进入中国银行                *\n");
		printf("\t\t*                                               *\n");
		printf("\t\t*                                               *\n");
		printf("\t\t**********************⊙*************************\n");
	 	printf("\t\t请选择您要办理的业务：\n"); 
		printf("\t\t\t1、开户\n"); 
		printf("\t\t\t2、存款\n"); 
		printf("\t\t\t3、取款\n"); 
		printf("\t\t\t4、转账\n"); 
		printf("\t\t\t5、查询余额\n");
		printf("\t\t\t6、修改密码\n");
		printf("\t\t\t7、退出\n");
		scanf("%d",&n);
		if(n==7){
			break;
		}
		switch(n){
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
			default:
				printf("输入有误，请输入1-7之间的数！");
				break;
		}
		printf("\t\t按任意键继续");
		getch();//暂停
		system("cls");
	}while(n!=7);
}
//开户
void kaihu(){
	float psw;
	if(count+1>=N){
		printf("\t\t开户人数已经达到系统上限，请等待...");
		return ;
	}
	printf("\t\t\t请输入开户名称：");
	scanf("%f",&bank[count][0]);
	printf("\t\t\t请输入帐号：");
	scanf("%f",&bank[count][1]);
	printf("\t\t\t请输入密码：");
	scanf("%f",&bank[count][2]);
	printf("\t\t\t请确认密码：");
	scanf("%f",&psw);
	if(psw!=bank[count][2]){
		printf("\t\t\t两次输入密码不一致，开户失败！\n");	
		return ;
	}
	printf("\t\t\t请输入开户金额：");
	scanf("%f",&bank[count][3]);
	count++;
}
//存款
void cunkuan(){
	float zh,psw,money;
	int i;
	printf("\t\t请输入您的帐号:");
	scanf("%f",&zh);
	printf("\t\t请输入密码:");
	scanf("%f",&psw);
	for(i=0;i<count;i++){
		if(bank[i][1]==zh && bank[i][2]==psw){
			printf("\t\t开户名称为:%.0f,余额为:%.2f\n",bank[i][0],bank[i][3]);	
			printf("\t\t请输入存款金额：");
			scanf("%f",&money);			
			bank[i][3]=bank[i][3]+money;
			printf("\t\t存款成功，您的存款金额为：%.2f,余额为：%.2f\n",money,bank[i][3]);
			break;
		}	
	}
	if(i>=count){
		printf("\t\t您的用户信息有误，请确认您的账户信息!\n");	
	}
}
//取款
void qukuan(){
	float zh,psw,money;
	int i;
	printf("\t\t请输入您的帐号:");
	scanf("%f",&zh);
	printf("\t\t请输入密码:");
	scanf("%f",&psw);
	for(i=0;i<count;i++){
		if(bank[i][1]==zh && bank[i][2]==psw){
			printf("\t\t开户名称为:%.0f,余额为:%.2f\n",bank[i][0],bank[i][3]);	
			printf("\t\t请输入取款金额：");
			scanf("%f",&money);
			if(bank[i][3]<money){
				printf("\t\t账户余额不足！");	
			}else{
				bank[i][3]=bank[i][3]-money;
				printf("\t\t取款成功，您的取款金额为：%.2f,余额为：%.2f\n",money,bank[i][3]);
			}
			break;
		}	
	}
	if(i>=count){
		printf("\t\t您的用户信息有误，请确认您的账户信息!\n");	
	}
}
//转账
void zhuanzhang(){
	float zh,psw,money,zh2;
	int i,j;
	printf("\t\t请输入您的帐号:");
	scanf("%f",&zh);
	printf("\t\t请输入密码:");
	scanf("%f",&psw);
	for(i=0;i<count;i++){
		if(bank[i][1]==zh && bank[i][2]==psw){
			printf("\t\t用户名称为:%.0f,余额为:%.2f\n",bank[i][0],bank[i][3]);	
			printf("\t\t请输入您要转出的帐号：");
			scanf("%f",&zh2);
			for(j=0;j<count;j++){
				if(bank[j][1]==zh2){
					printf("\t\t请输入转账金额:");
					scanf("%f",&money);	
					if(bank[i][3]<money){
						printf("\t\t余额不足，转账失败！");
					}else{
						//自己帐号扣钱
						bank[i][3]=bank[i][3]-money;
						//转出帐号加钱
						bank[j][3]+=money;
						printf("\t\t转账成功，您的转账金额为：%.2f,余额为：%.2f \n",money,bank[i][3]);
					}
					break;
				}
			}
			if(j>=count){
				printf("\t\t转出帐号不存在!\n");	
			}
			break;
		}	
	}
	if(i>=count){
		printf("\t\t您的用户信息有误，请确认您的账户信息!\n");	
	}
}
//查询余额
void chaxun(){
	float zh,psw;
	int i;
	printf("\t\t请输入您要查找的帐号:");
	scanf("%f",&zh);
	printf("\t\t请输入密码:");
	scanf("%f",&psw);
	for(i=0;i<count;i++){
		if(bank[i][1]==zh && bank[i][2]==psw){
			printf("\t\t开户名称为:%.0f,余额为:%.2f\n",bank[i][0],bank[i][3]);	
			break;
		}	
	}
	if(i>=count){
		printf("\t\t您要查找的用户不存在，请确认您的账户信息!\n");	
	}
}
//修改密码
void xiugai(){
	float zh,psw,psw2,psw3;
	int i;
	printf("\t\t请输入您的帐号:");
	scanf("%f",&zh);
	printf("\t\t请输入密码:");
	scanf("%f",&psw);
	for(i=0;i<count;i++){
		if(bank[i][1]==zh && bank[i][2]==psw){
			printf("\t\t请输入新密码：");
			scanf("%f",&psw2);
			printf("\t\t请确认密码：");
			scanf("%f",&psw3);
			if(psw2==psw3){
				bank[i][2]=psw2;
				printf("\t\t密码修改成功,修改后的密码为%.0f,请妥善保管!\n",bank[i][2]);
			}else{
				printf("\t\t您两次输入的密码不一致！\n");
			}
			break;
		}	
	}
	if(i>=count){
		printf("\t\t您的用户信息有误，请确认您的账户信息!\n");	
	}
}