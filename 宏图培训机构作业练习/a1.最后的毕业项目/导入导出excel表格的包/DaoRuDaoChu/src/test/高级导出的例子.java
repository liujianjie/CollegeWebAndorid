package test;

import java.awt.FileDialog;
import java.io.FileOutputStream;
import java.io.OutputStream;

import jxl.CellFormat;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WriteException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.Region;

public class 高级导出的例子 {

	public static void main(String []argv) {
		//创建HSSFWorkbook对象(excel的文档对象)
	      HSSFWorkbook wb = new HSSFWorkbook();
	    
	 
		//建立新的sheet对象（excel的表单）
		HSSFSheet sheet=wb.createSheet("成绩表");

       // cellStyle.setWrapText(true);// 指定单元格自动换行  
		//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		//sheet.addMergedRegion(new CellRangeAddress(1,2,0,1));
		//设置宽
		//sheet.setDefaultColumnWidth(20);
		
		//设置字体居中
//		CellFormat cf = wb.getSheet(0).getCell(1, 0).getCellFormat();               
//		WritableCellFormat wc = new WritableCellFormat();
//		// 设置居中                
//		wc.setAlignment(Alignment.CENTRE);
//		// 设置边框线                 
//		wc.setBorder(Border.ALL, BorderLineStyle.THIN);           
//		// 设置单元格的背景颜色             
//		wc.setBackground(jxl.format.Colour.RED); 
//		label = new Label(1,5,"字体",wc);   
//		
//		WritableCellFormat wc = new WritableCellFormat();
//		// 设置居中                
//		try {
//			wc.setAlignment(Alignment.CENTRE);
//			// 设置边框线                 
//			wc.setBorder(Border.ALL, BorderLineStyle.THIN);           
//			// 设置单元格的背景颜色             
//			wc.setBackground(jxl.format.Colour.RED);
//		} catch (WriteException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} 
//		Label la= new Label(1,5,"字体",wc);   
		

		
		//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1=sheet.createRow(0);
		//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell=row1.createCell(0);
		//设置单元格内容
		cell.setCellValue("          学员考试成绩一览表");
		
		//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,8));
		//在sheet里创建第二行
		HSSFRow row2=sheet.createRow(1);    
        //创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("姓名");
        row2.createCell(1).setCellValue("班级");    
        row2.createCell(2).setCellValue("笔试成绩");
        row2.createCell(3).setCellValue("机试成绩"); 
        
        //在sheet里创建第三行
        HSSFRow row3=sheet.createRow(2);
        row3.createCell(0).setCellValue("李明");
        row3.createCell(1).setCellValue("As178");
        row3.createCell(2).setCellValue(87);    
        row3.createCell(3).setCellValue(78);
        HSSFRow row4=sheet.createRow(3);
        HSSFRow row5=sheet.createRow(4);
        
		//1.用来设置备注的宽度 (指定哪个单元格)
		//sheet.setColumnWidth(cell.getColumnIndex(),256 * 50);
  
        
        //单元格纵向合并
        HSSFCell cell4=row4.createCell(0);
        
        HSSFCell cell5=row5.createCell(0);
        
      
        //.....省略部分代码
        //输出Excel文件
		try {
			//可以设置名称 C:\Users\Administrator\Desktop 桌面
			FileOutputStream output=new FileOutputStream("d:\\workbook.xls");
			wb.write(output);
			output.flush();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    //输出Excel文件
//	    OutputStream output=response.getOutputStream();
//	    response.reset();
//	    response.setHeader("Content-disposition", "attachment; filename=details.xls");
//	    response.setContentType("application/msexcel");        
//	    wkb.write(output);
//	    output.close();
//	    retrun null;
	}

}
