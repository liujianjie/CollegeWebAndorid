package test;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class 简单导出的实例 {
	public static void main(String[] args) {
		//创建HSSFWorkbook对象 用来”打开或者创建 excel文件对象“
		HSSFWorkbook wb = new HSSFWorkbook();
		//创建HSSFSheet对象 
		HSSFSheet sheet = wb.createSheet("sheet0");
		//创建HSSFRow对象  参数，离上边多少格
		HSSFRow row = sheet.createRow(0);
		//创建HSSFCell对象 参数，离左边多少格
		HSSFCell cell=row.createCell(0);
		//设置单元格的值
		cell.setCellValue("单元格中的中文");
		//输出Excel文件
		try {
			FileOutputStream output=new FileOutputStream("d:\\workbook.xls");
			wb.write(output);
			output.flush();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
