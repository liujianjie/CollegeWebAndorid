package demo;

public class Person {
	private String name;
	public void setName(String n){
		name = n;
	}
	public String getName(){
		return name;
	}
	
	//shopping ��ȥָ���������ض���Ʒ
	public Product shopping(Market market,String name){
		//����sell(),�������Ľ������
		return market.sell(name);
	}

}
