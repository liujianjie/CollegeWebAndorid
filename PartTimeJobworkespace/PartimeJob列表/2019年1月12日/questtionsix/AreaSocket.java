package questtionsix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * �ͻ���
 */
public class AreaSocket {
	public static void main(String[] args) {
		try {
			// �����ͻ��� Socket������ָ��������(127.0.0.1)�Ͷ˿�(3344)
			Socket socket = new Socket("127.0.0.1", 3344);
			System.out.println("Connected to server " + socket.getRemoteSocketAddress() + "\n �������������������ÿո����");
			// ��ϵͳ��׼�����豸���� BufferedReader ���󣬴������ж�ȡ��������
			BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
			
			// ͨ�� Socket ��������������������ݵ�ͨ�������� PrintWriter ����
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			// ͨ�� Socket �������ӷ������������ݵ�ͨ����������Ӧ�� BufferedReader ����
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String keyInput;
			while (true) {
				keyInput = keyboardInput.readLine(); // ��ϵͳ��׼�����û�����
				// ���û����뷢�͵���������
				out.println(keyInput);
				out.flush();//ˢ�»���
				System.out.println("Client input: " + keyInput);
				// ���շ���˷��ص���Ϣ���� �����   ���� ��ʾ������ֵ����
				System.out.println("Server return: " + input.readLine());
				// ���ͻ�������Լ�˵bye���ʾ���� �Ͽ�����
				if (keyInput.equals("bye")) { // ���ӱ�׼���������ַ���Ϊ "end"��ֹͣѭ��
					break;
				}
			}
			out.close();
			input.close();
			socket.close();
		} catch (Exception e) {
			
		}
	}
}
