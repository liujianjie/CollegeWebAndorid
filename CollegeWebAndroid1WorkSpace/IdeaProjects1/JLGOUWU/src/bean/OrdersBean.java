package bean;

public class OrdersBean {
	private int orders_id;
	private int jruser_id;
	private String xfm;
	private int statu;
	private String gtime;
	private int g_id;
	private String gname;
	private String gdec;
	private float gprice;
	private int gwccount;
	private float total;
	private String gimg;

	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public int getJruser_id() {
		return jruser_id;
	}
	public void setJruser_id(int jruser_id) {
		this.jruser_id = jruser_id;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public String getXfm() {
		return xfm;
	}
	public void setXfm(String xfm) {
		this.xfm = xfm;
	}
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public int getGwccount() {
		return gwccount;
	}
	public void setGwccount(int gwccount) {
		this.gwccount = gwccount;
	}
	public String getGimg() {
		return gimg;
	}
	public void setGimg(String gimg) {
		this.gimg = gimg;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public float getGprice() {
		return gprice;
	}
	public void setGprice(float gprice) {
		this.gprice = gprice;
	}
	public String getGtime() {
		return gtime;
	}
	public void setGtime(String gtime) {
		this.gtime = gtime;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getGdec() {
		return gdec;
	}
	public void setGdec(String gdec) {
		this.gdec = gdec;
	}
}
