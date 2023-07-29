package demo;

public class Shopping {
	public static void main(String[] args) {
		Product p1 = new Product("洗发水");
		Product p2 = new Product("洗衣液");
		Product p3 = new Product("洗洁精");
		Product p4 = new Product("洗衣粉");
		Product p5 = new Product("洗衣机");
		Product p6 = new Product("洗面奶");
		
		
//		p1.setProName("洗发水");
//		p2.setProName("洗衣液");
//		p3.setProName("洗洁精");
//		p4.setProName("洗衣粉");
//		p5.setProName("洗衣机");
//		p6.setProName("洗面奶");
		
		Market m = new Market();
		m.setMarketName("好又多");
		m.setProArr(new Product[]{p1,p2,p3,p4,p5,p6});
		
		Person per = new Person();
		per.setName("小李");
		Product result = per.shopping(m,"洗发水");
		
		//判断
		if(result!=null){
			System.out.println(per.getName()+"在"+m.getMarketName()+"买到了"+result.getProName());
		}else{
			System.out.println(per.getName()+"白跑了一趟，在"+m.getMarketName()+"什么都没买到");
		}
			
		
	}

}
