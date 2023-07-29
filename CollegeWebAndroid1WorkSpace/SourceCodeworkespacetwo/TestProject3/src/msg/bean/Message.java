package msg.bean;
import java.util.Date;

/**
 * ��Ϣbean��û�ж������ݿ�����������õ�
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
			this.title = "�ޱ���";
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
			this.message = "����Ϣ";
			return;
		}
		this.message = message;
	}

}
