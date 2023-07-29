package test.treeset;

public class Emp implements Comparable<Object>{
	int id;
	String name;
	public Emp(int id, String name){
		this.id = id;
		this.name = name;
	}
//	//±ØÐëÖØÐ´
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Emp em = (Emp)o;
		int result = id > em.id ? -1:(id == em.id ? 0:-1);
		return result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
