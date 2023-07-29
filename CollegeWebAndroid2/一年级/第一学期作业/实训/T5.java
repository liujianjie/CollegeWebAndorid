package javaone实训;
/*
a说他不和x比，c说他不和x,z比，请编程序找出三队赛手的名单。
*/
public class T5 {
	public static void main(String[] args) {
		char ateam[] = {'a','b','c'},bteam[] = {'x','y','z'};
		char C[] = new char[3];
		int i,j,k,m;
		for(i = 0; i < 3; i++){
			C[0] = bteam[i];
			if(C[0] != 'x'){
				for(j = 0; j < 3; j++){
					C[1] = bteam[j];
					if(C[0] != C[1]){
						for(k = 0; k < 3; k++){
							C[2] = bteam[k];
							if(C[2] != 'x' && C[2] != 'z'){
								if(C[2] != C[0] && C[2] != C[1])
									for(m = 0; m < 3; m++)
										System.out.println(ateam[m]+" "+C[m]);
							}
						}	
					}
				}
			}
		}
	}
}
