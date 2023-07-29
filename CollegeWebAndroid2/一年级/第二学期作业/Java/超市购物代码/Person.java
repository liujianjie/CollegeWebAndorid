package demo;

public class Person {
	private String name;
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
	
	//shopping 买，去指定超市买特定商品
	public Product shopping(Market market,String name){
		//调用sell(),把卖出的结果返回
		return market.sell(name);
	}

}
