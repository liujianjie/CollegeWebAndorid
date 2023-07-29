package com.ht.excel;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelToDB {
	//从excel导入java
	public static void main(String[] args) {
		String FileName="D:\\test.xls";
		 try {
	            Workbook rwb=Workbook.getWorkbook(new File(FileName));
	            Sheet rs=rwb.getSheet(0);//或者rwb.getSheet(0)
	            int clos=rs.getColumns();//得到所有的列
	            int rows=rs.getRows();//得到所有的行
	            System.out.println(clos+" rows:"+rows);
	            for (int i = 1; i < rows; i++) {
	                for (int j = 0; j < clos; j++) {
	                    //第一个是列数，第二个是行数
	                    String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
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
