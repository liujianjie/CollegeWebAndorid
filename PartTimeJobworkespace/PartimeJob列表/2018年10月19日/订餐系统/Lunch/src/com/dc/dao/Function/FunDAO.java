package com.dc.dao.Function;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface FunDAO {
	 //分页查询父级功能
	 public List FindParentFunction(PageEntity page);
	 //查询所有功能
	 public List FindALLFunctions();
	//查询所有功能名称和ID
	 public List findFunctions(String functionid);
	 //根据ID查询功能
	 public Map findFunctionsByid(String functionid);
     //新增
     public boolean insertFunction(String functionname,String functiondec,String functionurl,String state,String functionparentid, String userid,String username);
     //修改
     public boolean updateFunction(String functionname,String functiondec,String functionurl,String state,String functionparentid, String userid,String username,String functionid);
     //分页查询父级功能 ,根据父级名称查询子功能
     public List Selfunction(String functionid,PageEntity page);
     //修改功能状态
     public boolean upOrDown(String state,String functionid);
     //校验功能名是否重复
     public boolean checkFunctions(String functionname,String functionid);
     //查询所有功能状态
     public List FindState();
}
