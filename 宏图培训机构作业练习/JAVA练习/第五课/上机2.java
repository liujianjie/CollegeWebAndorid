public class �ϻ�2
{
	//5.2.	��д����ʵ������Ķ��弰ʹ��
	/*	����һ�����ж��е����飬ͨ��ѭ������������ֵ��Ȼ���ڷֱ��ӡ�������е�ÿ��ֵ
*/
	public static void main(String []ddf){
		int a[][]=new int[2][5];
		//��ֵ
		for(int i=0;i<2;i++){
			for(int j=0;j<5;j++){
				a[i][j]=i+j+2;
			}
		
		}
		//���
		for(int i=0;i<2;i++){
			for(int j=0;j<5;j++){
				System.out.print("a["+i+"]["+j+"]="+(a[i][j])+"\t");
			
			}
		}
	}
}