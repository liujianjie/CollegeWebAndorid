import java.util.Scanner;
public class T2
{
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
		System.out.println("");
		//)���ÿ��ѧ����ѧ�ż��ܷ�
		System.out.println("ѧ��\t�ܷ�");
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j+=4){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println("");//���
		}
		//�Ƚ�
		int max=0,b=0,c=0;
		for(b=0;b<5;b++){
			if(max<a[b][4]){
				max=a[b][4];
				c=a[b][0];
			}
		}

		System.out.println("");
		System.out.println("�ܷ���ߵ�Ϊ:"+max+" ѧ��Ϊ��"+c);

		System.out.println("");
		System.out.println("ѧ��\t����\t��ѧ\tӢ��\t�ܷ�\tƽ����");
		for(int i=0;i<5;i++){
			for(int j=0;j<6;j++){//5��5��
				System.out.print(a[i][j]+"\t");
			}
			System.out.println("");//���
		
		}
		//���� ���������������� �����ķ���ֵ������������ �ٲٲ� ����֮�ذ�
		int m[][]=new int[5][7];
		for(int i=1;i<4;i++){
			for(int j=0;j<5;j++){
				m[i][j]=a[j][i];
				m[i][5]+=m[i][j];
				m[i][6]=m[i][5]/5;
			}
		
		}
		//ѭ����ֵ

		//4)�ֱ�������ġ���ѧ��Ӣ���ƽ����
		System.out.println("");
		System.out.println("����\t��ѧ\tӢ��");
		//ѭ�����
		for(int i=1;i<4;i++){
			System.out.print((float)m[i][6]+"\t");
		
		}
		System.out.println("");
		int t=0;
		System.out.println("ð����������");
		for(int i=0;i<5;i++){
			for(int j=i+1;j<5;j++){
				if(a[i][5]<a[j][5]){
					for(int k=0;k<6;k++){
						t=a[i][k];
						a[i][k]=a[j][k];
						a[j][k]=t;
					}
				}
			}
		
		}
		System.out.println("ѧ��\t����\t��ѧ\tӢ��\t�ܷ�\tƽ����");
		for(int i=0;i<5;i++){
			for(int j=0;j<6;j++){//5��5��
				System.out.print(a[i][j]+"\t");
			}
			System.out.println("");//���
		
		}
	}
}