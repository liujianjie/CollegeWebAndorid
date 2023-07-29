package demo;

public class Market {    //超市类
	private String marketName;
	private Product[] proArr;      //仓库
	
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
	
	public Product sell(String name){   //卖货，指定商品名称，返回商品
		
		for(int i = 0;i<proArr.length;i++){
			if(proArr[i].getProName() == name)
				return proArr[i];
		}
		return null;
	}
	

}
