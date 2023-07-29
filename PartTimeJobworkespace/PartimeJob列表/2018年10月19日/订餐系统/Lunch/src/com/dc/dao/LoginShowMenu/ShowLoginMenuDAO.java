package com.dc.dao.LoginShowMenu;

import java.util.HashMap;
import java.util.List;

public interface ShowLoginMenuDAO {
	public List<HashMap> selectallMenu(String mealid);
	public List<HashMap> selectallMenu();
	public List selectallRoom();
}
