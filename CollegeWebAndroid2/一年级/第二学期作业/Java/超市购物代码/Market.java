package demo;

public class Market {    //������
	private String marketName;
	private Product[] proArr;      //�ֿ�
	
	public void setMarketName(String name){
		marketName = name;
	}
	public String getMarketName(){
		return marketName;
	}
	
	public void setProArr(Product[] productArr){
		proArr = productArr;
	}
	public Product[] getProArr(){
		return proArr;
	}
	
	public Product sell(String name){   //������ָ����Ʒ���ƣ�������Ʒ
		
		for(int i = 0;i<proArr.length;i++){
			if(proArr[i].getProName() == name)
				return proArr[i];
		}
		return null;
	}
	

}
