package msg.bean;
import java.util.Date;

/**
 * 消息bean，没有对象数据库表，用来评论用的
 * */
public class Message {
	private String name;
	private String message;
	public String title;
	private String pic;
	private String date;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if("".equals(title)||title==null) {
			this.title = "无标题";
			return;
		}
		this.title = title;
	}

	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getDate() {
		return date;
	}
	public void setDate() {
		this.date = new Date().toLocaleString();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		if("".equals(message)||title==null) {
			this.message = "无信息";
			return;
		}
		this.message = message;
	}

}
