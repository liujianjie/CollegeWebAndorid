package demo;

public class Product {   //商品类
	private String proName;   //商品名称
	public void setProName(String name){  
		proName = name;
	}
	
	public String getProName(){
		return proName;
	}
	
	public Product(String n){
		setProName(n);
		
	}

}
