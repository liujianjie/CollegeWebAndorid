public class  T14
{
	public static void main(String[] args) 
	{
		System.out.println("1000数内的所有完数有：");
		int sum=0,i=1;
		while(i<=1000){
			i++;
			sum=0;//初始化 不会影响下一个运算
			for(int j=1;j<i;j++){//j不能小于等于i是因为j/i为1 会影响运算结果
				if(i%j==0){//判断j是否为i的因子
					sum+=j;	//判断好了就算
				}
			
			}
			if(sum==i){
				System.out.println(""+i);
			}
		}
	}
}
