package pack201914;

/**
题目：
猴子吃桃问题：
猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个    
第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
以后每天早上都吃了前一天剩下的一半零一个。
到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少。
*/
// 一开始是先*2 再加1 导致数据有问题。
public class T2 {
	public static void main(String[] args) {
//		System.out.println(del(1));
		int data[] = new int[10];
		data[9] = 1;
		for(int i = 8; i >= 0; i--){
			data[i] = (data[i+1] + 1) * 2;
		}
		System.out.println(data[0]);
	}
	public static int del(int day){
		if(day == 10)
			return 1;
		return (del(day + 1) +1) * 2;
	}
}
