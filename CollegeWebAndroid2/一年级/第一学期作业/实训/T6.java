package javaoneʵѵ;

public class T6 {
	public static void main(String[] args) {
		int curval = 4,last;
		int num[] = new int[6];
		for(int i = 0; i < num.length; i++){
			if(i == 0){
				curval++;
				num[i] = curval;// ���٣���ôֻ��һ�����ƶ�,����ǵ�5ֻ���Ӷ�����һ��������5������1�����ʣ�µ���Ŀ������length��6��ʼ
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