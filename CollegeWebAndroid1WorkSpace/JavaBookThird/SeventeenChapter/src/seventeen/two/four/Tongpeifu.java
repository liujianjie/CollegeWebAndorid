package seventeen.two.four;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class Tongpeifu <T extends List>{
	public static void main(String[] args) {
//		Tongpeifu<? extends List> tpf = null;
//		tpf = new Tongpeifu<ArrayList>();
//		tpf = new Tongpeifu<LinkedList>();
		
		List<String> l1 = new ArrayList<String>();
		l1.add("��Ա");
		List<?> l2 = l1;
		List<?> l3 = new LinkedList<Integer>(); // �����Խ���String Ҳ����Integer ������?�Ĳ���setֵ ֻ�ܻ�ȡ��ɾ��
		
//		l2.add("1221");
//		l2.set(0,"///");
//		l3.add("12");
//		l3.set(0, "12321");
		l2.get(0);
		l2.remove(0);
		
		//��������
		Tongpeifu<? super List> a = null;
		a = new Tongpeifu<List>();
//		a = new Tongpeifu<ArrayList>();//���� �����ϲ�
//		a = new Tongpeifu<Collection<List>>(); // ��� object �� ���������
	}
	
	//ͨ�������
	public void doSomething(Tongpeifu<? extends List> a){
		
	}
}
