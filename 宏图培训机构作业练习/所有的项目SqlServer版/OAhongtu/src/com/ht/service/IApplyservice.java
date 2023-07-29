package com.ht.service;

import java.util.List;

import com.ht.vo3.Applystudent;
import com.ht.vo3.Applystudent2;


public interface IApplyservice {
	 //意向学生管理 列表
      public List appList();
      public  Applystudent getStuInfoById(Long id);
      public boolean addStuInfo(Applystudent2 stu2);
      public boolean updStatus1(Long id);
      public boolean updStatus2(Long id);
     //预定报名 列表
      public List appList2(); 
      //添加学生信息
      public boolean addStu(Applystudent st);
      public List check(int id);
}
