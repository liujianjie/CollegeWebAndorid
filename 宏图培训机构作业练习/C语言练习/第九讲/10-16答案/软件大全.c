/* Note:Your choice is C IDE */
#include "stdio.h"
//函数的申明
//折半查找
void find();
//卡拉ok评分系统
void ok();
//打印菱形
void prt();
void main()
{
    /*
    	软件大全  1、折半查找
    			  2、卡拉ok评分系统
    			  3、打印菱形
    			  4、退出
 	*/
 	int n;
	do{
		printf("\t\t**************************************\n"); 
 		printf("\t\t		系统软件大全\n"); 
 		printf("\t\t**************************************\n"); 
	 	printf("\t\t**************************************\n"); 
	 	printf("\t\t请选择您要进入的系统：\n"); 
		printf("\t\t\t1、折半查找\n"); 
		printf("\t\t\t2、打印菱形\n"); 
		printf("\t\t\t3、宏图四班好声音大赛评分系统\n"); 
		printf("\t\t\t4、退出\n"); 
		scanf("%d",&n);
		if(n==4){
			break;
		}
		switch(n){
			case 1:
				find();
				break;
			case 2:
				prt();
				break; 
			case 3:
				ok();
				break;
			case 4:
				break;
			default:
				printf("输入有误，请输入1-4之间的数！");
				break;
		}
		printf("\t\t按任意键继续");
		getch();//暂停
		system("cls");
	}while(n!=4);
 	//find();
 	//prt();
 	//ok();
}
void find(){
	/*
		折半查找：
			1、数组有多少个元素（数组的长度）
			2、数组有序（升序和降序）
	*/
	int a[10]={10,9,8,7,6,5,4,3,2,1};
	int left=0,right=9,mid,num,c=0;
	printf("请输入您要查找的数：");
	scanf("%d",&num);
	while(left<=right){
		mid=(left+right)/2;//把数组拆分成两部分
		//如果中间量比要查找的数小，右边坐标往左边移
		if(a[mid]<num){
			right=mid-1;
		}	
		//如果中间量比要查找的数大，左边的坐标往右移
		if(a[mid]>num){
			left=mid+1;
		}
		//找到该数，就输出
		if(a[mid]==num){
			printf("您在第%d个位置找到了%d\n",mid+1,num);	 
			c=1;
			break;	
		}	
	}
	if(c==0){
		printf("很遗憾，您要查找的数不存在！\n");
	}
}

void prt(){
/*
	*
   ***	
  *****
 *******
  *****
   ***
    *
	1、行数就等于字符数
	2、每一行的*号=行号*2-1
	3、空格数=（字符数-星号数）/2
*/	
	int line,star,space,i,j,mid;
	printf("请输入您要打印菱形的行数：");
	scanf("%d",&line);
	mid=line/2+1;
	//上半部分
	for(i=1;i<=mid;i++){  //循环行
		star=i*2-1;
		//打印空格
		space=(line-star)/2;
		for(j=1;j<=space;j++){
			printf(" ");
		}
		//打印星号
		for(j=1;j<=star;j++){
			printf("*");
		}
		printf("\n");
	}
	//打印下半部分
	for(i=mid-1;i>0;i--){  //循环行
		star=i*2-1;
		//打印空格
		space=(line-star)/2;
		for(j=1;j<=space;j++){
			printf(" ");
		}
		//打印星号
		for(j=1;j<=star;j++){
			printf("*");
		}
		printf("\n");
	}
}
//宏图4班好声音大赛评分系统
void ok(){
	/*
		5个选手，5个裁判，去掉最高分，去掉最低分，求平均分
		1、找冠军
		2、排序
	*/
	float a[5][9],temp,max;
	int i,j,k,c=0;
	//输入
	for(i=0;i<5;i++){ //循环选手 
		a[i][6]=0; 	    //最高分
		a[i][7]=100;	//最低分
		a[i][8]=0;	    //平均分
		printf("请评委输入选手号和分数：");
		for(j=0;j<6;j++){ //循环裁判（裁判输入）
			scanf("%f",&a[i][j]);
			if(j>0){
				//每一位裁判给的最高分
				if(a[i][6]<a[i][j]){
					a[i][6]=a[i][j];
				}
				//每一位裁判给的最低分
				if(a[i][7]>a[i][j]){
					a[i][7]=a[i][j];
				}
				a[i][8]+=a[i][j];
			}
		}
		//求选手的平均分
		a[i][8]=(a[i][8]-a[i][6]-a[i][7])/3;
	}
	//输出
	printf("选手号\t评委1\t评委2\t评委3\t评委4\t评委5\t最高分\t最低分\t平均分\n");
	for(i=0;i<5;i++){
		printf("%.0f\t",a[i][0]);
		for(j=1;j<9;j++){
			printf("%.1f\t",a[i][j]);
		}
		printf("\n");
	}
	//找冠军
	max=a[0][8];
	for(i=1;i<5;i++){
		if(max<a[i][8]){
			max=a[i][8];
			c=i;	
		}	
	}
	printf("冠军是第%.0f号选手，最后得分是%.1lf\n",a[c][0],max);
	//排序(冒泡排序)
	for(i=0;i<4;i++){
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
	printf("选手号\t评委1\t评委2\t评委3\t评委4\t评委5\t最高分\t最低分\t平均分\n");
	for(i=0;i<5;i++){
		printf("%.0f\t",a[i][0]);
		for(j=1;j<9;j++){
			printf("%.1f\t",a[i][j]);
		}
		printf("\n");
	}
}