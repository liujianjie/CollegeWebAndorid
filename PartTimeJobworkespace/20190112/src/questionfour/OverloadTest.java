package questionfour;

public class OverloadTest {
	public static void main(String[] args) {
		book(1,"һǧ��һҹ");
		book("����",2);
		book("Java�����ŵ���ͨ");
	}
	public static void book(int id,String name){
		System.out.println("����"+name+",�ҵ�id��"+id);
	}
	public static void book(String name,int id){
		System.out.println("�ҵ�id��"+id+",����"+name);
	}
	public static void book(String name){
		System.out.println("����"+name);
	}
}
