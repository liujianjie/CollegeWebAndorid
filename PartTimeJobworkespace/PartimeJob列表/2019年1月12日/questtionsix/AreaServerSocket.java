package questtionsix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����
 */
public class AreaServerSocket {
	public static void main(String[] args) {
		try {
			ServerSocket s_socket = new ServerSocket(3344); // ���������������� 3344 �˿�
			// �Ƚ�ʵ����Ϊ�գ��������while������ظ�������
			Socket sockets = null;
			PrintWriter out = null;
			BufferedReader line = null;
			System.out.println("�ȴ��ͻ�������...");
			while (true) {
				// ��socketΪ��ʱ�Ž������ӣ��Լ�ʵ��printfwriter �� bufferreader���������ظ�new 
				if (sockets == null) {
					sockets = s_socket.accept();
					System.out.println("Client " + sockets.getRemoteSocketAddress() + " connected.");
					// ͨ�� Socket ��������������������ݵ�ͨ�������� PrintWriter ����
					out = new PrintWriter(sockets.getOutputStream(), true);
					// ͨ�� Socket �������ӷ������������ݵ�ͨ����������Ӧ�� BufferedReader ����
					line = new BufferedReader(new InputStreamReader(sockets.getInputStream()));
				}
				// ���￪ʼÿ�ζ�ȡ�ͻ��˵�����Ż���� ����Ĵ��룬�����൱��һ���ϵ� ����ȴ��ͻ��˵�����Ż��������
				String s_data = line.readLine();
				// �жϿͻ����ǲ�������bye�ַ�������������˳�����ѭ�� ���ü�������������ˣ����ҽ�������
				if (s_data.equals("bye")) {
					break;// break����while
				} else {
					// ���ַ������÷���ͨ���ո�ָ�ͻ��������һ�����ݵ�ÿ����ֵ���ַ��������У���Ϊ�������������ÿո������
					String s_dtarry[] = s_data.split(" ");
					// ������ַ������鳤��û��3�� ������ ��Ȼ���ܹ��������μ��ͻ���û�����������ÿո������������С��ʾ���������Ҳ�ִ��������� ��else����
					if (s_dtarry.length != 3) {
						out.println("Client ������������������");
					} else {
						// �ͻ�������3�����󣬽������ж���3�����Ƿ����Ҫ��
						// 1.�Ƚ����洢�ͻ�������3���������飬��Ϊ��ȡ��string���ͣ���Ҫת��Ϊfloat���ܼ���
						float f_num[] = new float[s_dtarry.length + 1];// ����4���ռ䣬���һ��������������
						int flag = 1;// ���Ʊ�������3�����Ƿ����Ҫ��Ĭ��Ϊ����
						String s_tr;// ��ʱ������������ȡ������ÿһ��String�ַ���
						// 2.����3����������������ȡ���������ж��Ƿ�Ϊ��ֵ������û������ʲô �ַ� a��b��ʲô����
						for (int i = 0; i < s_dtarry.length; i++) {
							s_tr = s_dtarry[i];
							// �Զ���ķ��������Ƿ���ֵ���Ǿͷ���true �����Ǿ�false����ʾ�ͻ����������󣬲���flag = 0��ʶ������Ҫ��
							if (isNumeric(s_tr)) {
								f_num[i] = Integer.valueOf(s_tr);// �������Ҫ����������stringתΪfloat���� ���ܼ���
							} else {
								out.println("Client ������������������");
								flag = 0;// ��һ���������Ͼͱ�ʶΪ0
								break;// һ����һ����������Ҫ���ֱ���˳���ǰѭ��
							}
						}
						// 3.ͨ��������ж�flag�Ƿ����Ҫ�����������м�����������������Ҫ��ִ��
						if (flag == 1) {
							// 4.���������������װ�ڷ����У�������ֵ���飬����flag ��ʶ����1�������3�������Թ��������β��ҽ��������������ĵ������±���
							flag = calcuTrigArea(f_num);
							if(flag == 1){// ͨ�����ص�ֵ�ж��Ƿ񹹳������� �����ɵõ�ֵ
								out.println("���������Ϊ��" + f_num[3]);// ��ͻ��˷�����Ϣ
							}else{
								out.println("Client ������������������");// ��ʾ���󣬲��ܹ���������
							}
						}
					}
				}
			}
			System.out.println("Client ���� bye�� �Ͽ�����");
			out.println("�����Ի����Ͽ�����");
			out.flush();
			sockets.close();
			s_socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	// �����������
	public static int calcuTrigArea(float f_num[]) {
		// 1.�ж��Ƿ񹹳�3���Σ�ֻ�������εĶ��壬�������������Ƿ���ڵ�����������Ҫ�������Σ���ͬ��������
		float sum1 = f_num[0] + f_num[1];
		float sum2 = f_num[0] + f_num[2];
		float sum3 = f_num[1] + f_num[2];
		// ÿ��������Ҫ�ж�һ�Σ����ܾ����Ƿ��ܹ���������
		if (sum1 > f_num[2] && sum2 > f_num[1] && sum3 > f_num[0]) {
			// ͨ�����׹�ʽ���������������ͨ����������һ���ܳ��ٽ��й�ʽ area = sqrt(s*(s-a)*(s-b)*(s-c)); sqrt��java���õĿ�ƽ������
			float sf = (f_num[0] + f_num[1] + f_num[2]) / 2;// һ���ܳ�
			f_num[3] = (float) Math.sqrt(sf * (sf - f_num[0]) * (sf - f_num[1]) * (sf - f_num[2]));// �����������±�Ϊ3��
			return 1;// ��ʾ���Լ������ �ܹ�����������
		}
		return 0;//��ʾ���ܹ���������
	}
	// �ж��ַ����Ƿ�Ϊ��ֵ�������� ������ĸ�ͷ��� ֻ��0~9������
	public static boolean isNumeric(String str) {
		// ����ѭ��ÿ���ַ� ��java�Դ��ĺ����ж�
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
