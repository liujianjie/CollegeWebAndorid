/* Note:Your choice is C IDE */
#include "stdio.h"
void shoushui(){
	float a,b,c,d;
	printf("请输入你的工资(精确到两位小数)：");
	scanf("%f",&a);
	
	printf("请输入你当地的个税起点：");
	scanf("%f",&b);
	
	if(a>=b){
		printf("你的工资是：%.2f\n",a);
		c=a*0.043;
		printf("你的个人所得税是：%.2f\n",c);
		d=a-c;
		printf("你扣税后的收入为：%.2f\n",d);
	}else{
		printf("说你涨工资还是不要涨好呢？");
	
	}
}
void gongsi(){
	int a=1,b=0,c=0;
	while(a<13){
		printf("第%d个月的公司收入为：",a);
		scanf("%d",&b);
		a++;
		c=c+b;
	}
	printf("公司的总收入为：%d",c);
}
void pingfeng(){
	float a[5][9],max,temp;
    int i,j,c=0,k;
    for(i=0;i<5;i++){
    	a[i][6]=0;
     	a[i][7]=10086;
     	a[i][8]=0;
    	printf("选手已经演唱完毕，请裁判编号并且打分\n");
    	for(j=0;j<6;j++){
    		scanf("%f",&a[i][j]);
    		if(j>0){
    			if(a[i][6]<a[i][j]){
    				a[i][6]=a[i][j];
    			}
    			if(a[i][7]>a[i][j]){
    				a[i][7]=a[i][j];
    			}
    			a[i][8]+=a[i][j];
    		}
    	}
    	a[i][8]=(a[i][8]-a[i][6]-a[i][7])/3;
    }
    printf("选手号\t评委1\t评委2\t评委3\t评委4\t评委5\t最高分\t最低分\t平均分\n");
     for(i=0;i<5;i++){
     	printf("%.0f\t",a[i][0]);
     	for(j=1;j<9;j++){
     		printf("%.1f\t",a[i][j]);
     	}
     	printf("\n");
     }
     max=a[0][8];
     for(i=1;i<5;i++){
     	if(max<a[i][8]){
     		max=a[i][8];
     		c=i;	
     	}
     }
     printf("%.0f号选手是冠军，最后得分为%.1f\n",a[c][0],max);
     printf("排序前：\n");
     for(i=0;i<5;i++){
        printf("%.1f\t",a[i][8]);
     }
     printf("\n");
     for(i=0;i<5;i++){
     	for(j=i+1;j<5;j++){ 
     		if(a[i][8]<a[j][8]){
     			for(k=0;k<9;k++){
     				temp=a[i][k];
     				a[i][k]=a[j][k];
     				a[j][k]=temp;
     			}
     		}
     	}
     }
     printf("排序后：\n");
     for(i=0;i<5;i++){
        printf("%.1f\t",a[i][8]);
     }
     printf("\n");
     printf("选手号\t评委1\t评委2\t评委3\t评委4\t评委5\t最高分\t最低分\t平均分\n");
     for(i=0;i<5;i++){
     	printf("%.0f\t",a[i][0]);
     	for(j=1;j<9;j++){
     		printf("%.1f\t",a[i][j]);
     	}
     	printf("\n");
     }
}
void main()
{
	int z;
    printf("\t\t**********************⊙*************************\n");
	printf("\t\t*                                               *\n");
	printf("\t\t*              ◎   系统软件大全                *\n");
	printf("\t\t*                                               *\n");
	printf("\t\t**********************⊙*************************\n");
	printf("\n\n");
	do{
		printf("\n");
		printf("\t\t\t请输入你想要进入的系统：\n");
		printf("\t\t\t1.个人所得税系统\n");
		printf("\t\t\t2.公司收入系统\n");
		printf("\t\t\t3.卡拉OK评分系统\n");
		printf("\t\t\t4.退出\n");
		printf("\t\t\t请选择：");
		scanf("%d",&z);
	switch(z){
		case 1:
			system("cls");
			shoushui();
			break;
			
		case 2:
			system("cls");
			gongsi();
			break;
		case 3:		
			system("cls");
			pingfeng();
			break;
		case 4:
			printf("\t\t\t退出成功。");
			break;
		default:
			printf("\t\t\t输入错误，请重新输入。\n");
			
	}
	}while(z!=4);
	
}