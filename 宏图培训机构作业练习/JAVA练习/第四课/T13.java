import java.util.Scanner;
public class  T13
{
	public static void main(String[] args) 
	{
		//
	/*13�������֣�����һ������num=56�����û�����һ������num���бȽϣ�����ʾ�û��Ǹ���
	���ǵ��ˣ�ֱ������Ϊֹ�����õ�break��
	*/
		System.out.println("��������Ҫ�µ�����10�λ��ᣬ��ʾ��1-100֮�䣩��");
		int a=0,sum=0;//����

		do{
			Scanner sb=new Scanner(System.in);
			a=sb.nextInt();//ѭ�����
			if(a<56){
				System.out.println("�µ���С�ˣ�����������");
			}
			if(a>56){
				System.out.println("�µ������ˣ�����������");
			}
			sum++;
			if(sum==10){
				break;
			}
		}while(a!=56);

		if(a==56){
			System.out.println("��ϲ�㣬����ˣ�����");
		}
		if(sum==10){
			System.out.println("��Ļ���������");
		
		}
	}
}
