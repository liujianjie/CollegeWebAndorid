package three.four.six;

/**
 * ��λ����
 **/
public class FiveShiftoperation {
	public static void main(String[] args) {
		// char unicode��Ӧ���ַ���
		int one = 230465;
		// System.out.println((char) one);

		// ��λ����

		// ���� ���Ƶ���λ��ֵ��0����
		int four = 8 << 2; // 8 * (2*2)
		int five = 4 << 4; // 4 * (2*2*2*2)
		// System.out.println(four);
		// System.out.println(five);

		// ���� �Ǿ���������0 ������1���� ���λ��ʲô������
		int two = 8 >> 2;// 8 / ��2 * 2�� 2��2�η�
		int three = 16 >> 4; // 16 / (2*2*2*2)
		two = -8 >> 2;// ����1
		System.out.println(two);

		// �޷������� �������λ�� 0 1 ���� 0
		two = -8 >>> 2;// 8 / ��2 * 2�� 2��2�η�
		three = 16 >>> 4; // 16 / (2*2*2*2)
		System.out.println(two);
		// -8�Ķ����� 24��1 4��1 1000 ������
		// -8>>>2 ������2λ ��0 �� ����0 22��1 6��1 10
		System.out.println(Integer.toBinaryString(1073741822));//û�������� ��ͷ��������0

		// �����Ķ����� ��������
		// System.out.println(Integer.toBinaryString(-8));
		// System.out.println(Integer.toBinaryString(8));
	}
}
