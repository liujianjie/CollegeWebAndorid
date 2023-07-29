package p1055ISBN号码;
// 不要复制

/*
题目描述

每一本正式出版的图书都有一个ISBN号码与之对应，ISBN码包括999位数字、111位识别码和333位分隔符，其规定格式如x-xxx-xxxxx-x，其中符号-就是分隔符（键盘上的减号），最后一位是识别码，例如0-670-82162-4就是一个标准的ISBN码。ISBN码的首位数字表示书籍的出版语言，例如000代表英语；第一个分隔符-之后的三位数字代表出版社，例如670670670代表维京出版社；第二个分隔符后的五位数字代表该书在该出版社的编号；最后一位为识别码。

识别码的计算方法如下：

首位数字乘以111加上次位数字乘以222……以此类推，用所得的结果 mod 11 \bmod 11mod11，所得的余数即为识别码，如果余数为101010，则识别码为大写字母XXX。例如ISBN号码0-670-82162-4中的识别码444是这样得到的：对067082162这999个数字，从左至右，分别乘以1,2,...,91,2,...,91,2,...,9再求和，即0×1+6×2+……+2×9=1580×1+6×2+……+2×9=1580×1+6×2+……+2×9=158，然后取158 mod 11158 \bmod 11158mod11的结果444作为识别码。

你的任务是编写程序判断输入的ISBN号码中识别码是否正确，如果正确，则仅输出Right；如果错误，则输出你认为是正确的ISBN号码。
输入格式

一个字符序列，表示一本书的ISBN号码（保证输入符合ISBN号码的格式要求）。
输出格式

一行，假如输入的ISBN号码的识别码正确，那么输出Right，否则，按照规定的格式，输出正确的ISBN号码（包括分隔符-）。

*/
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String isbn = sc.next();
		String isbns = isbn.replaceAll("-", "");
		int num;
		int sum = 0;
		for(int i = 0; i < isbns.length() - 1; i++){
			num = Integer.valueOf(isbns.charAt(i) - '0');
			sum += num * (i + 1);
		}
		
		// 细节：处理10的情况
		if(isbns.charAt(isbns.length() - 1) != 'X'){ // 最后一位不是x
			int mowei = Integer.valueOf(isbns.charAt(isbns.length() - 1) - '0');
			if(sum % 11 == mowei){
				System.out.println("Right");
			}else{
				PrintWrongToRight(isbn, sum);
			}
		}else{
			if(sum % 11 == 10){
				System.out.println("Right");
			}else{
				PrintWrongToRight(isbn, sum);
			}
		}
		sc.close();
	}
	public static void PrintWrongToRight(String isbn, int sum){
		isbn = isbn.substring(0, isbn.length() - 1);
		System.out.println(isbn + (sum % 11 == 10 ? "X" : sum % 11));
	}
}
// 0-679-88162-0
