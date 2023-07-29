package QQcloudlet;

public class QQweiyun {
	public String getQqnum() {
		return qqnum;
	}
	public void setQqnum(String qqnum) {
		this.qqnum = qqnum;
	}
	public String getQqname() {
		return qqname;
	}
	public void setQqname(String qqname) {
		this.qqname = qqname;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFilenames() {
		return filenames;
	}
	public void setFilenames(String filenames) {
		this.filenames = filenames;
	}

	private String qqnum;
	private String qqname;
	private String filepath;
	private String filenames;
	private String date;
	private String filelayout;
	public String getFilelayout() {
		return filelayout;
	}
	public void setFilelayout(String filelayout) {
		this.filelayout = filelayout;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
