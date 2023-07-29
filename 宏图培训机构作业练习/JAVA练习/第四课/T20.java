public class  T20
{
	public static void main(String[] args) 
	{
		System.out.println("合理买鸡的方法");
		int a=0,b=0,c=0,d=0;
		for(a=0;a<20;a++){
			for(b=0;b<33;b++){
				c=100-a-b;//为 剩余的钱
				d=a*5+b*3+c/3;//钱数多少
				if(c%3==0&a+b+c==100&d==100){//综合对比
					System.out.println("公鸡"+a+"只，母鸡"+b+"只，小鸡"+c+"只\n");
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
			printf("公鸡%d只，母鸡%d只，小鸡%d只\n",a,b,c);
			
				
			}
		}
	
		
	}*/