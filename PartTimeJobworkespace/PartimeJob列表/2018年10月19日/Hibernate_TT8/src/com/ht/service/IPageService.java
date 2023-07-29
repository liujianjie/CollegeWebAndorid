package com.ht.service;

import java.util.List;

public interface IPageService {
	public int totalRow();
	public List pagelist(int startRow,int pageCount);
	
	public List pagelistbysql(int startRow,int pageCount);
}
