public class T12
{
	public static void main(String[] args) 
	{
		//��forѭ������sum=1+2+3+4+....+n,
		//ֱ��sum>500ʱ�˳�,���nֵ��sumֵ(�ֱ��õ�break��continue)
		int n=0,sum=0;
		System.out.println("1+2+3+4+....+n");
		for(int a=1;a<=500;a++){
			sum+=a;	
			n++;
			if(sum<=500){
				continue;
			}
			System.out.println("��nֵΪ��"+n+" ,sumֵΪ��"+sum);
			break;
		}
		
	}
}
