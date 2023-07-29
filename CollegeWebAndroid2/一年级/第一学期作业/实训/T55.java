package javaone实训;
// 潜在错误，可能哪里写得不好，会有出现
/*
 * 
a z
b y
c z

因为在末尾判断不了了，z会被选中，break不了。

2.放弃了，做不下去，用这种方法，最后一个有两个可选，怎么让他可以选第二个很难。
唉，sb啊我，就是3个数里面选3个构成枚举排列，所有排列中再筛选不能与条件冲突就可以了，这么简单都不会了。唉，3层循环呀，还是不精
*/
public class T55 {
	public static void main(String[] args) {
		char ateam[] = {'a','b','c'};
		char bteam[] = {'x','y','z'};
		char out[][] = new char[3][2];
		int index[] = new int[3];
		int ok,i,j,m,n;
		for(i = 0; i < 3; i++){
			out[i][0] = ateam[i];
			for(j = index[i]; j < 3; j++){
				ok = 1;
				index[i] = j + 1;
				out[i][1] = bteam[j];
				if(out[i][0] == 'b'){
					if(out[i][1] == 'x'||out[i][1] == 'z'){
						ok = 0;
					}
				}
				if(out[i][0] == 'c'){
					if(out[i][1] == 'x'){
						ok = 2;
					}
				}
				if(ok == 2){
					for(m = 0; m < i; m++){
						if(out[m][1] == out[i][1]){
							ok = 2;
							break;
						}
					}
				}
				if(ok == 1){
					break;
				}
			}
			// 当第二个选完了，再看是否与前面有相同的，有就重新选
			for(m = 0; m < i; m++){
				if(out[m][1] == out[i][1]){
					ok = 2;
					i = m - 1;
					for(n = m + 1; n < 3; n++){ // 让下面的j清空为0
						index[n] = 0;
					}
					break;
				}
			}
		}
		for(i = 0; i < 3; i++){
			System.out.println(out[i][0]+" "+out[i][1]);
		}
	}
}
