package com.ht.service;

import java.util.List;

import com.ht.vo3.Applystudent;
import com.ht.vo3.Applystudent2;


public interface IApplyservice {
	 //����ѧ������ �б�
      public List appList();
      public  Applystudent getStuInfoById(Long id);
      public boolean addStuInfo(Applystudent2 stu2);
      public boolean updStatus1(Long id);
      public boolean updStatus2(Long id);
     //Ԥ������ �б�
      public List appList2(); 
      //���ѧ����Ϣ
      public boolean addStu(Applystudent st);
      public List check(int id);
}
