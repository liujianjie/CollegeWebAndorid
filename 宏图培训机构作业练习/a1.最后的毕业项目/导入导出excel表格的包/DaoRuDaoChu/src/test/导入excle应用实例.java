package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class 导入excle应用实例 {
	public static void main(String[] args) {
		try {
			FileInputStream filein=new FileInputStream("d:\\workbook.xls");
			Workbook wb0=new HSSFWorkbook(filein);
			Sheet sht0=wb0.getSheetAt(0);
			//迭代数据
			//对Sheet中的每一行进行迭代
			
	       
	        Row r=sht0.createRow(0);
	        for (Row r1 : sht0) {
	        	//如果当前行的行号（从0开始）未达到2（第三行）则从新循环
	        	if(r1.getRowNum()<1){
	        			continue;
	        	}
	        	//创建实体类
	        	ScoreInfo info=new ScoreInfo();
	        	//取出当前行第1个单元格数据，并封装在info实体stuName属性上
	        	info.setStuName(r1.getCell(0).getStringCellValue());
	        	info.setClassName(r1.getCell(1).getStringCellValue());
	        	info.setRscore(r1.getCell(2).getNumericCellValue());
	        	info.setLscore(r1.getCell(3).getNumericCellValue());
	        	temp.add(info);
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
