package com.ht.action;

import java.io.File;

import com.ht.vo.Record;

import sun.org.mozilla.javascript.internal.regexp.SubString;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelToDB {
	//从excel导入java
	public static void main(String[] args) {
		Record record=new Record();
		String FileName="E:\\bb.xls";
		 try {
	            Workbook rwb=Workbook.getWorkbook(new File(FileName));
	            Sheet rs=rwb.getSheet(0);//或者rwb.getSheet(0)
	            int clos=rs.getColumns();//得到所有的列
	            int rows=rs.getRows();//得到所有的行
	            System.out.println(clos+" rows:"+rows);
	            int count=2;
	            
	            String date=rs.getCell(0, 1).getContents();
	            System.out.println(date+"日期");
	            String year=date.substring(5, 9);
	            String mouse=date.substring(10, 12);
	            System.out.println(year+"年");
	            System.out.println(mouse+"月");
	            String eid=null;
	            for (int i = 1; i < rows; i++) {
	            	if(i==count-1&&count<rows-3&&i>2){
	            		 String str=rs.getCell(0, i).getContents();
	            		 eid= str.substring(3,6);
	            		 System.out.println("工号："+eid);
	            	}
	            	
	               if(i==count&&count<rows-2){
	            	   for (int j = 0; j < clos; j++) {
		                    //第一个是列数，第二个是行数
//		                    String id=rs.getCell(j++, i).getContents();//默认最左边编号也算一列 所以这里得j++
//		                    String name=rs.getCell(j++, i).getContents();
//		                    String sex=rs.getCell(j++, i).getContents();
//		                    String age=rs.getCell(j++, i).getContents();
//		                    String cid=rs.getCell(j++, i).getContents();
	            		   	
	            		   	if(i>2){
	            		   		String day=rs.getCell(j,2).getContents();
		            		 	//System.out.println(day+"222222222222222222");
	            		   		String time=rs.getCell(j,i).getContents();
	            		   		//System.out.println(time+"11111111111");
	            		   		//record.setEmpid(Long.parseLong(eid));
	            		   		record.setYear(year);
		            		   	record.setMouse(mouse);
		            		   	record.setDay(day);
		            		   	record.setTimes(time);
		            		   	
		            		   	System.out.println(eid);
		            		   	System.out.println(year);
		            		   	System.out.println(mouse);
		            		   	System.out.println(day);
		            		   	System.out.println(time);
		            		   	
	            		   	}
	            		   	
		                }
	            	   count+=2;
	               }
	            	
	            }
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } 
	}
}
