package demo;

public class Shopping {
	public static void main(String[] args) {
		Product p1 = new Product("ϴ��ˮ");
		Product p2 = new Product("ϴ��Һ");
		Product p3 = new Product("ϴ�ྫ");
		Product p4 = new Product("ϴ�·�");
		Product p5 = new Product("ϴ�»�");
		Product p6 = new Product("ϴ����");
		
		
//		p1.setProName("ϴ��ˮ");
//		p2.setProName("ϴ��Һ");
//		p3.setProName("ϴ�ྫ");
//		p4.setProName("ϴ�·�");
//		p5.setProName("ϴ�»�");
//		p6.setProName("ϴ����");
		
		Market m = new Market();
		m.setMarketName("���ֶ�");
		m.setProArr(new Product[]{p1,p2,p3,p4,p5,p6});
		
		Person per = new Person();
		per.setName("С��");
		Product result = per.shopping(m,"ϴ��ˮ");
		
		//�ж�
		if(result!=null){
			System.out.println(per.getName()+"��"+m.getMarketName()+"����"+result.getProName());
		}else{
			System.out.println(per.getName()+"������һ�ˣ���"+m.getMarketName()+"ʲô��û��");
		}
			
		
	}

}
