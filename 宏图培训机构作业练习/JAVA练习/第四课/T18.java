public class T18 
{
	public static void main(String[] args) 
	{
		System.out.println("8�ı�����1λ��+2λ�����ڵ�2λ���ӵ�3λ����4λ����");
		int a=0,b=0,c=0,d=0;
		for(int i=1000;i<=9999;i++){
			a=i/1000%10;//ǧ
			b=i/100%10;//��
			c=i/10%10;//ʮ
			d=i/1%10;//��
			if(i%8==0){
				if(a+b==b+c){
					System.out.print(i+"\t");
				}else{}
			
			}else{}
			
		}
	}
}
