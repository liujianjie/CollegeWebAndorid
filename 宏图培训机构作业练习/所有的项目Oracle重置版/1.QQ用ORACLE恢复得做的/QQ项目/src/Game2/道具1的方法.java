package Game2;

import java.util.Random;

public class ����1�ķ��� extends �������{
	public ����1�ķ���(){
	/*	if(jiadaoju11){
			if(map[zhasi3][zhasj3]==caodi){
				map[zhasi3][zhasj3]=4;
				
			}else if(map[zhasi3][zhasj3]==xiangzi){
				map[zhasi3][zhasj3]=4;
				daoju111=true;//���Ա�Ϊ���� ���ӡ�����
			}
		}
		
		if(jiadaoju11){
			if(map[zhaxi3][zhaxj3]==caodi){
				map[zhaxi3][zhaxj3]=4;
			}else if(map[zhaxi3][zhaxj3]==xiangzi){
				map[zhaxi3][zhaxj3]=4;
				daoju222=true;//���Ա�Ϊ���� ���ӡ�����
			}
		}
		
		if(jiadaoju11){
			if(map[zhazi3][zhazj3]==caodi){
				map[zhazi3][zhazj3]=4;
			}else if(map[zhazi3][zhazj3]==xiangzi){
				map[zhazi3][zhazj3]=4;
				daoju333=true;//���Ա�Ϊ���� ���ӡ�����
			}
		}
		
		if(jiadaoju11){
			if(map[zhayi3][zhayj3]==caodi){
				map[zhayi3][zhayj3]=4;
			}else if(map[zhayi3][zhayj3]==xiangzi){
				map[zhayi3][zhayj3]=4;
				daoju444=true;//���Ա�Ϊ���� ���ӡ�����
			}
		}*/
		
		if(daoju111){
			int a=daoju();//�����
			map[zhasi3][zhasj3]=a;//���ӵ�λ��Ϊ������ 
		}else{
			map[zhasi3][zhasj3]=yuanshi111;//�����λ��Ϊԭ�������� ��
			
		}

		if(daoju222){
			int a=daoju();
			map[zhaxi3][zhaxj3]=a;//���ӵ�λ��Ϊ������ 
		}else{
			map[zhaxi3][zhaxj3]=yuanshi222;//�����λ��Ϊԭ������������ǲݾͱ�Ϊ �� 
			
		}

		if(daoju333){
			int a=daoju();
			map[zhazi3][zhazj3]=a;//���ӵ�λ��Ϊ������ 
		}else{
			map[zhazi3][zhazj3]=yuanshi333;//�����λ��Ϊԭ������������ǲݾͱ�Ϊ �� 
			
		}

		if(daoju444){
			int a=daoju();
			map[zhayi3][zhayj3]=a;//���ӵ�λ��Ϊ������ 
		}else{
			map[zhayi3][zhayj3]=yuanshi444;//�����λ��Ϊԭ������������ǲݾͱ�Ϊ �� 
			
		}
	}
		//���߷���
		public int daoju(){
			int a=new Random().nextInt(5);
			if(a==1){
				a=caodi;//�ݵ�
		}
		else if(a==0){
			a=daojutu2;//����2
		}else if(a==3){
			a=caodi;//�ݵ�
		}
		else if(a==2){
			a=daojutu1;//����1
		}else if(a==4){
			a=caodi;//�ݵ�
			}
			
			return a;
		}
}
