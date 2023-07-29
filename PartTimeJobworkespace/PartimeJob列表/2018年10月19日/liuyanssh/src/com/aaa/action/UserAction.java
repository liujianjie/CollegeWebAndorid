package com.aaa.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.beans.factory.annotation.Autowired;

import com.aaa.biz.UserBiz;
import com.aaa.entity.Staff;
import com.aaa.entity.User;

public class UserAction extends BaseAction {
	private User tabUser;
	private Staff BkloginUser;
	@Autowired
	private UserBiz userBiz;

	@Action("login")
	public String login() throws IOException {
		System.out.println(tabUser.getUserName());
		List user = userBiz.login(tabUser);

		if (user != null) {
			// ���û���Ϣ�ŵ�session��

			getSession().put("user", user);
			getWrite().print("true");
			System.out.println("true");
			return null;

		} else {
			getWrite().print("false");
			return "false";

		}

	}

	public User getTabUser() {
		return tabUser;
	}

	public void setTabUser(User tabUser) {
		this.tabUser = tabUser;
	}

	public Staff getBkloginUser() {
		return BkloginUser;
	}

	public void setBkloginUser(Staff bkloginUser) {
		BkloginUser = bkloginUser;
	}

}
