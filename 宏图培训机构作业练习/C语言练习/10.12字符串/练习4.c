/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  	int i,c=0,d=0,e=0,f=0,g=0;
  	char a[100];
  	printf("������һ�λ���");
  	gets(a);
  	for(i=0;i<strlen(a);i++){
  		if(a[i]>=65&&a[i]<=90){
  			c=c+1;
  		}
  		else if(a[i]>=97&&a[i]<=122){
  			d=d+1;
  		}
  		else if(a[i]>='0'&&a[i]<'10'){// 49 57
  			e=e+1;
  		}
  		else if(a[i]==32){
  			f=f+1;
  		}else
  		g=g++;  		
  	}
  	printf("��д��ĸ��%d\n",c);
  	printf("Сд��ĸ��%d\n",d);
  	printf("�ո���%d\n",f);
  	printf("������%d\n",e);
  	printf("������%d\n",g);
  	
}