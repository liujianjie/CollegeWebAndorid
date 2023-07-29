package test;

import java.io.FileOutputStream;

import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WriteException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class 模拟 {
	public static void main(String[] args) {
		//创建HSSFWorkbook对象(excel的文档对象)
	    HSSFWorkbook wb = new HSSFWorkbook();

		//建立新的sheet对象（excel的表单）
		HSSFSheet sheet=wb.createSheet("成绩表");
		
		HSSFCellStyle setBorder = wb.createCellStyle();
		setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		setBorder.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//这个应该是设置全局的，你试试吧
		
		HSSFCellStyle cellStyle = wb.createCellStyle();  
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中    
		HSSFFont font = wb.createFont();    
		font.setFontName("黑体");    
		font.setFontHeightInPoints((short) 16);//设置字体大小    
		HSSFFont font2 = wb.createFont();    
		font2.setFontName("仿宋_GB2312");    
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//粗体显示    
		font2.setFontHeightInPoints((short) 12);    
		cellStyle.setFont(font);//选择需要用到的字体格式  
		
		//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1=sheet.createRow(0);
		//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell=row1.createCell(0);
		//设置单元格内容
		cell.setCellValue("电子自动化系-宏图软件教育项目答辩评分表");
		//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,9));
		cell.setCellStyle(cellStyle);
		//在sheet里创建第二行
		HSSFRow row2=sheet.createRow(1); 
		
        //创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("组长");
        row2.createCell(1).setCellValue("成员");    
        row2.createCell(2).setCellValue("功能完善(50)");
        row2.createCell(3).setCellValue("技术难度(10)"); 
        row2.createCell(4).setCellValue("界面美观(10)");
        row2.createCell(5).setCellValue("演示方法(10)");
        row2.createCell(6).setCellValue("语言表达(10)");
        row2.createCell(7).setCellValue("回答问题(10)");
        row2.createCell(8).setCellValue("总分(100)");
        row2.createCell(9).setCellValue("备注");
        //在sheet里创建第三行
        HSSFRow row3=sheet.createRow(2);
        row3.createCell(0).setCellValue("曾慧明");
        row3.createCell(1).setCellValue("曾慧明");    
        row3.createCell(2).setCellValue("50");
        row3.createCell(3).setCellValue("10"); 
        row3.createCell(4).setCellValue("10");
        row3.createCell(5).setCellValue("6");
        row3.createCell(6).setCellValue("6");
        row3.createCell(7).setCellValue("10");
        row3.createCell(8).setCellValue("92");
        row3.createCell(9).setCellValue("改了本地域名绑定，有验证功能");
        
        //在sheet里创建第四行
        HSSFRow row4=sheet.createRow(3);
        row4.createCell(0).setCellValue("曾慧明");
        row4.createCell(1).setCellValue("许才栋");    
        row4.createCell(2).setCellValue("50");
        row4.createCell(3).setCellValue("10"); 
        row4.createCell(4).setCellValue("10");
        row4.createCell(5).setCellValue("6");
        row4.createCell(6).setCellValue("6");
        row4.createCell(7).setCellValue("10");
        row4.createCell(8).setCellValue("92");
        row4.createCell(9).setCellValue("前台页面");
        
		//设置所有列的宽
		sheet.setDefaultColumnWidth(10);
		
	    //1.用来设置备注的宽度 (指定哪个单元格)
		sheet.setColumnWidth(row3.createCell(9).getColumnIndex(),256 * 50);
		
		
		//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(2,3,0,0));
		
		//字体居中
		HSSFCellStyle align_style = wb.createCellStyle();
		align_style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	//	cell.setCellStyle(align_style);
	
		
		//输出Excel文件
		try {
			//可以设置名称 C:\Users\Administrator\Desktop 桌面
			FileOutputStream output=new FileOutputStream("d:\\workboo.xls");
			wb.write(output);
			output.flush();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
