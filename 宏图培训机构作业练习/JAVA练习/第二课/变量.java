public class ����{
	public static void main(String a[]){
		System.out.println("��ʼ��ϰ����");
	//�������� boolean
	boolean b=false;
		System.out.println("���Ϊ:"+b);
	//byte���� 
	byte c=122;//-128~127
		System.out.println("byte��"+c);
	//int����
	int d=46548;
		System.out.println("int:"+d);
	//long���� ��Ҫת�� �븡����һ�� Ĭ��Ϊint���� ��Ȼ��Ӱ�� �����ݵķ�Χ��	Ӱ��
	long i=23L;
		System.out.println("long:"+i);
	//������float
	float e=10.0f;
	double f=10.0;
		System.out.println("e="+e);
		System.out.println("f="+f);
		System.out.println("e+f="+e+f);//��ϵ��������� ���������͸߼��� ��� ���������Զ�ת��
	//�ַ�����
	char g='c';
		System.out.println("g="+g);
	//�ַ�������
	String h="�ּ���������뿪";
		System.out.println("�ַ��������"+h);
	//��������ת�� long����i ת�� int���͵�d 
	i=d;
	i=(int)d;
		System.out.println("ǿ��ת����"+i);
	//����ת�� ����ת�� �� �ַ���ƴ��
	char z='x';
		System.out.println(z+1);//����ת��
		System.out.println(""+z+1);//�ַ���ƴ��
	}	
}