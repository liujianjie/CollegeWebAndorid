package three.four.six;

/**
 * 移位操作
 **/
public class FiveShiftoperation {
	public static void main(String[] args) {
		// char unicode对应的字符集
		int one = 230465;
		// System.out.println((char) one);

		// 移位操作

		// 左移 左移的两位数值填0即可
		int four = 8 << 2; // 8 * (2*2)
		int five = 4 << 4; // 4 * (2*2*2*2)
		// System.out.println(four);
		// System.out.println(five);

		// 右移 那就是正数补0 负数补1？？ 最高位是什么。。。
		int two = 8 >> 2;// 8 / （2 * 2） 2的2次方
		int three = 16 >> 4; // 16 / (2*2*2*2)
		two = -8 >> 2;// 补了1
		System.out.println(two);

		// 无符号右移 不管最高位是 0 1 都填 0
		two = -8 >>> 2;// 8 / （2 * 2） 2的2次方
		three = 16 >>> 4; // 16 / (2*2*2*2)
		System.out.println(two);
		// -8的二进制 24个1 4个1 1000 操作后
		// -8>>>2 向右移2位 补0 则 两个0 22个1 6个1 10
		System.out.println(Integer.toBinaryString(1073741822));//没错是这样 开头的两个是0

		// 负数的二进制 就像这样
		// System.out.println(Integer.toBinaryString(-8));
		// System.out.println(Integer.toBinaryString(8));
	}
}
