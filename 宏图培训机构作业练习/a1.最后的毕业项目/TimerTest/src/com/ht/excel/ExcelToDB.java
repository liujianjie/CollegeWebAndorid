package com.ht.excel;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelToDB {
	//��excel����java
	public static void main(String[] args) {
		String FileName="D:\\test.xls";
		 try {
	            Workbook rwb=Workbook.getWorkbook(new File(FileName));
	            Sheet rs=rwb.getSheet(0);//����rwb.getSheet(0)
	            int clos=rs.getColumns();//�õ����е���
	            int rows=rs.getRows();//�õ����е���
	            System.out.println(clos+" rows:"+rows);
	            for (int i = 1; i < rows; i++) {
	                for (int j = 0; j < clos; j++) {
	                    //��һ�����������ڶ���������
	                    String id=rs.getCell(j++, i).getContents();//Ĭ������߱��Ҳ��һ�� ���������j++
	                    String name=rs.getCell(j++, i).getContents();
	                    String sex=rs.getCell(j++, i).getContents();
	                    String age=rs.getCell(j++, i).getContents();
	                    String cid=rs.getCell(j++, i).getContents();
	                    
	                    System.out.println("id:"+id+" name:"+name+" sex:"+sex+" age:"+age+"cid  :"+cid);
	                    //
	                }
	            }
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	}
}
