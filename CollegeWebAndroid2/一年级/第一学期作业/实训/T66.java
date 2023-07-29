package javaone实训;

public class T66 {
	public static void main(String[] args) {
		int curval = 4,last;
		int num[] = new int[6];
		int count = 0;
		for(int i = 0; i < num.length; i++){
			count++;
			if(i == 0){
				curval++;
				num[i] = curval;// 最少，那么只能一个个推断,这个是第5只猴子丢掉的一个 拿走一份剩下的
			}else{
				last = num[i - 1];
				last *= 5;
				if(last % 4 == 0){
					num[i] = last / 4 + 1;
				}else{
					i = -1;
				}
			}
		}
		for(int i = 0; i < 6; i++){
			System.out.println(num[i]);
		}
		System.out.println(count);// 2368
	}
}
/*
 * 
 		while(count < 5){
			if(count == 0){
				for(curval++; curval < 1000000; curval++){
					if(curval % 5 == 0){
						num[count] = curval;
						break;
					}
				}
			}
			count++;
			int last = num[count - 1];
			last = last * 5 ;
			if(last % 4 == 0){
				num[count] = last / 4 + 1;
			}else{
				count = 0;
			}
		}
 */
