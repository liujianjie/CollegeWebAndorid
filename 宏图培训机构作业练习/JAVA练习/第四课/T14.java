public class  T14
{
	public static void main(String[] args) 
	{
		System.out.println("1000���ڵ����������У�");
		int sum=0,i=1;
		while(i<=1000){
			i++;
			sum=0;//��ʼ�� ����Ӱ����һ������
			for(int j=1;j<i;j++){//j����С�ڵ���i����Ϊj/iΪ1 ��Ӱ��������
				if(i%j==0){//�ж�j�Ƿ�Ϊi������
					sum+=j;	//�жϺ��˾���
				}
			
			}
			if(sum==i){
				System.out.println(""+i);
			}
		}
	}
}
