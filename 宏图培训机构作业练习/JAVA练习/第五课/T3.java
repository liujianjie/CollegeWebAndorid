import java.util.Scanner;
public class T3
{
	//���Ի���λ��
	public static void main(String dsfa[]){
		int a[][]=new int[5][6];
		Scanner sb=new Scanner(System.in);//�������뺯��
		
		for(int i=0;i<5;i++){
			System.out.print("�������"+(i+1)+"��ͬѧ��ѧ�����ųɼ���");
			for(int j=0;j<4;j++){
				a[i][j]=sb.nextInt();//���뺯��
				if(j>0){
					a[i][4]+=a[i][j];
				}
				a[i][5]=a[i][4]/3;
	
			}
		
		}
		System.out.println("ͬѧ�ǵĳɼ��Ա������Ľ��Ϊ��");
		System.out.println("ѧ��\t����\t��ѧ\tӢ��\t�ܷ�");
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){//5��5��
				System.out.print(a[i][j]+"\t");
			}
			System.out.println("");//���
		
		}
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){//5��5��
				System.out.print(a[j][i]+"\t");
			}
			System.out.println("");//���
		
		}
	}
}
