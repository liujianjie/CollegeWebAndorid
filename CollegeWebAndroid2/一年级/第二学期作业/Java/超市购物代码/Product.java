package demo;

public class Product {   //��Ʒ��
	private String proName;   //��Ʒ����
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
