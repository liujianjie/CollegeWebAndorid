public class T12
{
	public static void main(String[] args) 
	{
		//用for循环计算sum=1+2+3+4+....+n,
		//直到sum>500时退出,输出n值和sum值(分别用到break和continue)
		int n=0,sum=0;
		System.out.println("1+2+3+4+....+n");
		for(int a=1;a<=500;a++){
			sum+=a;	
			n++;
			if(sum<=500){
				continue;
			}
			System.out.println("中n值为："+n+" ,sum值为："+sum);
			break;
		}
		
	}
}
