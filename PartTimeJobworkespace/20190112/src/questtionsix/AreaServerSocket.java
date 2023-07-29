package questtionsix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class AreaServerSocket {
	public static void main(String[] args) {
		try {
			ServerSocket s_socket = new ServerSocket(3344); // 建立服务器，监听 3344 端口
			// 先将实例设为空，以免放在while中造成重复不美观
			Socket sockets = null;
			PrintWriter out = null;
			BufferedReader line = null;
			System.out.println("等待客户端连接...");
			while (true) {
				// 当socket为空时才建立连接，以及实例printfwriter 和 bufferreader对象，以免重复new 
				if (sockets == null) {
					sockets = s_socket.accept();
					System.out.println("Client " + sockets.getRemoteSocketAddress() + " connected.");
					// 通过 Socket 对象建立与服务器发送数据的通道，构造 PrintWriter 对象
					out = new PrintWriter(sockets.getOutputStream(), true);
					// 通过 Socket 对象建立从服务器接收数据的通道，构造相应的 BufferedReader 对象
					line = new BufferedReader(new InputStreamReader(sockets.getInputStream()));
				}
				// 这里开始每次读取客户端的输入才会进行 下面的代码，这里相当于一个断点 ，会等待客户端的输入才会继续运行
				String s_data = line.readLine();
				// 判断客户端是不是输入bye字符串，如果是则退出整个循环 不用计算三角形面积了，并且结束链接
				if (s_data.equals("bye")) {
					break;// break跳出while
				} else {
					// 用字符串内置方法通过空格分割客户端输入的一行数据的每个数值到字符串数组中，因为输入三个数是用空格隔开的
					String s_dtarry[] = s_data.split(" ");
					// 当这个字符串数组长度没有3个 三个数 自然不能构成三角形即客户端没有输入三个用空格隔开的数，则小提示输入有误并且不执行下面代码 用else分离
					if (s_dtarry.length != 3) {
						out.println("Client 输入有误，请重新输入");
					} else {
						// 客户端输入3个数后，接下来判断这3个数是否符合要求
						// 1.先建立存储客户端输入3个数的数组，因为读取是string类型，需要转换为float才能计算
						float f_num[] = new float[s_dtarry.length + 1];// 开辟4个空间，最后一个放面积，更简洁
						int flag = 1;// 控制变量，这3个数是否符合要求，默认为符合
						String s_tr;// 临时变量，用来获取数组中每一个String字符串
						// 2.将这3个数从数组中依次取出来依次判断是否为数值，即有没有输入什么 字符 a，b·什么符号
						for (int i = 0; i < s_dtarry.length; i++) {
							s_tr = s_dtarry[i];
							// 自定义的方法处理是否数值，是就返回true ，不是就false，提示客户端输入有误，并且flag = 0标识不符合要求
							if (isNumeric(s_tr)) {
								f_num[i] = Integer.valueOf(s_tr);// 如果符合要求，则把数组从string转为float类型 才能计算
							} else {
								out.println("Client 输入有误，请重新输入");
								flag = 0;// 有一个数不符合就标识为0
								break;// 一旦有一个数不符合要求就直接退出当前循环
							}
						}
						// 3.通过上面的判断flag是否符合要求，如果是则进行计算面积，如果不符合要求不执行
						if (flag == 1) {
							// 4.计算三角形面积封装在方法中，传入数值数组，返回flag 标识，是1则代表这3个数可以构成三角形并且将面积返回在数组的第三个下标中
							flag = calcuTrigArea(f_num);
							if(flag == 1){// 通过返回的值判断是否构成三角形 若构成得到值
								out.println("三角形面积为：" + f_num[3]);// 向客户端发送消息
							}else{
								out.println("Client 输入有误，请重新输入");// 表示有误，不能构成三角形
							}
						}
					}
				}
			}
			System.out.println("Client 输入 bye， 断开连接");
			out.println("结束对话，断开连接");
			out.flush();
			sockets.close();
			s_socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	// 计算面积方法
	public static int calcuTrigArea(float f_num[]) {
		// 1.判断是否构成3角形，只需三角形的定义，两个数加起来是否大于第三个数，需要处理三次，不同数加起来
		float sum1 = f_num[0] + f_num[1];
		float sum2 = f_num[0] + f_num[2];
		float sum3 = f_num[1] + f_num[2];
		// 每个数都需要判断一次，才能决定是否能构成三角形
		if (sum1 > f_num[2] && sum2 > f_num[1] && sum3 > f_num[0]) {
			// 通过海伦公式，三角形面积可以通过，三角形一半周长再进行公式 area = sqrt(s*(s-a)*(s-b)*(s-c)); sqrt是java内置的开平方方法
			float sf = (f_num[0] + f_num[1] + f_num[2]) / 2;// 一半周长
			f_num[3] = (float) Math.sqrt(sf * (sf - f_num[0]) * (sf - f_num[1]) * (sf - f_num[2]));// 保存在数组下标为3中
			return 1;// 表示可以计算面积 能构成是三角形
		}
		return 0;//表示不能构成三角形
	}
	// 判断字符串是否为数值，不能有 其它字母和符号 只能0~9的数字
	public static boolean isNumeric(String str) {
		// 依次循环每个字符 用java自带的函数判断
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}
