public class T17 
{
	public static void main(String[] args) 
	{
		System.out.println("1-8000֮���ܱ�5���������ɸ�ż��֮��:");
		int i=1,sum=0;
		while(sum<750){
		for(i=1;i<=8000;i++){
			if(i%5==0){
				sum+=i;
				System.out.print(i+"\t");
			}
			if(sum>750){
				System.out.println("ֵΪ��"+sum);
				break;
			}
		}
		}
	}
}
