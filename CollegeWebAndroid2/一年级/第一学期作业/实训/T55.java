package javaoneʵѵ;
// Ǳ�ڴ��󣬿�������д�ò��ã����г���
/*
 * 
a z
b y
c z

��Ϊ��ĩβ�жϲ����ˣ�z�ᱻѡ�У�break���ˡ�

2.�����ˣ�������ȥ�������ַ��������һ����������ѡ����ô��������ѡ�ڶ������ѡ�
����sb���ң�����3��������ѡ3������ö�����У�������������ɸѡ������������ͻ�Ϳ����ˣ���ô�򵥶������ˡ�����3��ѭ��ѽ�����ǲ���
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
			// ���ڶ���ѡ���ˣ��ٿ��Ƿ���ǰ������ͬ�ģ��о�����ѡ
			for(m = 0; m < i; m++){
				if(out[m][1] == out[i][1]){
					ok = 2;
					i = m - 1;
					for(n = m + 1; n < 3; n++){ // �������j���Ϊ0
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
