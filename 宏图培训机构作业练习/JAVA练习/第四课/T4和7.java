public class T4��7
{
	public static void main(String[] args) 
	{
		int a=0,b=0,c=0,sum=0;
		System.out.println("��Ϊˮ�ɻ����̶���100��1000�������е�ˮ�ɻ���Ϊ��");
		for(int i=100;i<=1000;i++){
			sum=0;
			a=i/100%10;
			b=i/10%10;
			c=i/1%10;
			sum=a*a*a+b*b*b+c*c*c;
			if(i==sum){
			System.out.println(sum+"\t");
			}
		}
	}
}
