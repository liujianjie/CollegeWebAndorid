package goods.entity;
 
import java.io.Serializable;
 
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double price;
	private String pic;
	private String intro;
	private String catalog;



	public Book() {
	}

	public Book(int id, String name, String pic, double price) {
		this.id = id;
		this.name = name;
		this.pic = pic;
		this.price = price;
	}

	//
	// getter/setter
	// ------------------------------------------------------------------------------

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


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return name + "   " + price + "   ";
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getCatalog() {
		return catalog;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}	
	
 
}