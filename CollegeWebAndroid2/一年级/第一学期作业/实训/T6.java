package javaone实训;

public class T6 {
	public static void main(String[] args) {
		int curval = 4,last;
		int num[] = new int[6];
		for(int i = 0; i < num.length; i++){
			if(i == 0){
				curval++;
				num[i] = curval;// 最少，那么只能一个个推断,这个是第5只猴子丢掉的一个，分完5份拿走1份最后剩下的数目，所以length从6开始
			}else{
				last = num[i - 1];
				last *= 5;
				if(last % 4 == 0)
					num[i] = last / 4 + 1;
				else
					i = -1;
			}
		}
		System.out.println(num[5]);
	}
}