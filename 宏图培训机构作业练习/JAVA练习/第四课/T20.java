public class  T20
{
	public static void main(String[] args) 
	{
		System.out.println("�����򼦵ķ���");
		int a=0,b=0,c=0,d=0;
		for(a=0;a<20;a++){
			for(b=0;b<33;b++){
				c=100-a-b;//Ϊ ʣ���Ǯ
				d=a*5+b*3+c/3;//Ǯ������
				if(c%3==0&a+b+c==100&d==100){//�ۺ϶Ա�
					System.out.println("����"+a+"ֻ��ĸ��"+b+"ֻ��С��"+c+"ֻ\n");
				}
			}
		
		}

	}
}
	/*int a,b,c,d;	
	for(a=0;a<20;a++){
		for(b=0;b<33;b++){
			c=100-a-b;
			d=a*5+b*3+c/3;
			if(c%3==0&&a+b+c==100&&d==100){
			printf("����%dֻ��ĸ��%dֻ��С��%dֻ\n",a,b,c);
			
				
			}
		}
	
		
	}*/