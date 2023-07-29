package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import bean.Userbean;

public class JsonAction {
	
	private String uname;
	
	private List list;
	
	public String execute(){
		System.out.println(uname);
		uname="李四";//就这样就可以传送值到ajax客户端
		
		//不用List list=new ArryaList();
		list=new ArrayList();
		list.add("1111111");
		list.add("2222222");//就这样就可以传送值到ajax客户端
		return "success";
	}
	public String list(){
		System.out.println("进来了list...");
		
		List list=new ArrayList();
		Userbean u1=new Userbean();
		u1.setUname("张三");
		u1.setSex("男");
		u1.setState(1);
		Userbean u2=new Userbean();
		u2.setUname("翠花");
		u2.setSex("女");
		u2.setState(0);
		list.add(u1);
		list.add(u2);
		
		ActionContext.getContext().put("list", list);
		
		return "toindex";
	}
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}

}
