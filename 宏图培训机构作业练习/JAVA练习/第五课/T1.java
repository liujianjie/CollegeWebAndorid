public class T1
{
	public static void main(String dad[]){
		System.out.println("ѧ���ĳɼ�����Ŀγ̶�ӦΪ������   ��ѧ   Ӣ��");
		int a[][];
		a=new int[5][3];
		a[0][0]=45;
		a[0][1]=46;
		a[0][2]=56;
		a[1][0]=57;
		a[1][1]=34;
		a[1][2]=67;
		a[2][0]=56;
		a[2][1]=49;
		a[2][2]=67;
		a[3][0]=35;
		a[3][1]=26;
		a[3][2]=86;
		a[4][0]=27;
		a[4][1]=64;
		a[4][2]=77;
		for(int i=0;i<5;i++){
			System.out.print("��"+(i+1)+"λͬѧ�ĳɼ�Ϊ��\t");
			for(int j=0;j<3;j++){
				System.out.print(a[i][j]+"\t");
			
			}
			System.out.println("");
	
		}
	}
}