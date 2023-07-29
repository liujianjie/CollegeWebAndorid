package questtionsix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * 客户端
 */
public class AreaSocket {
	public static void main(String[] args) {
		try {
			// 创建客户端 Socket，连接指定服务器(127.0.0.1)和端口(3344)
			Socket socket = new Socket("127.0.0.1", 3344);
			System.out.println("Connected to server " + socket.getRemoteSocketAddress() + "\n 请输入三个正整数，用空格隔开");
			// 由系统标准输入设备构造 BufferedReader 对象，从命令行读取输入内容
			BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
			
			// 通过 Socket 对象建立与服务器发送数据的通道，构造 PrintWriter 对象
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			// 通过 Socket 对象建立从服务器接收数据的通道，构造相应的 BufferedReader 对象
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String keyInput;
			while (true) {
				keyInput = keyboardInput.readLine(); // 从系统标准输入用户输入
				// 将用户输入发送到服务器端
				out.println(keyInput);
				out.flush();//刷新缓存
				System.out.println("Client input: " + keyInput);
				// 接收服务端返回的信息，即 是面积   还是 提示输入数值有误
				System.out.println("Server return: " + input.readLine());
				// 当客户端这边自己说bye则表示结束 断开链接
				if (keyInput.equals("bye")) { // 若从标准输入读入的字符串为 "end"则停止循环
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
