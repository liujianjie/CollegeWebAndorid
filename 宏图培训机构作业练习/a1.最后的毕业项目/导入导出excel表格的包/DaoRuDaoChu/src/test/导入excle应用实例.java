package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class ����excleӦ��ʵ�� {
	public static void main(String[] args) {
		try {
			FileInputStream filein=new FileInputStream("d:\\workbook.xls");
			Workbook wb0=new HSSFWorkbook(filein);
			Sheet sht0=wb0.getSheetAt(0);
			//��������
			//��Sheet�е�ÿһ�н��е���
			
	       
	        Row r=sht0.createRow(0);
	        for (Row r1 : sht0) {
	        	//�����ǰ�е��кţ���0��ʼ��δ�ﵽ2�������У������ѭ��
	        	if(r1.getRowNum()<1){
	        			continue;
	        	}
	        	//����ʵ����
	        	ScoreInfo info=new ScoreInfo();
	        	//ȡ����ǰ�е�1����Ԫ�����ݣ�����װ��infoʵ��stuName������
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
