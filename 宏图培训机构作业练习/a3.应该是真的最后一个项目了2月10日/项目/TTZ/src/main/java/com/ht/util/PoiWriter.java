package com.ht.util;

import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;
import com.ht.pojo.MoneyRecord;

public class PoiWriter {

	public static void savegood(String fileName,String path,List<MoneyRecord> mr_list) {
		try {
		
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet(fileName);

			// 设置标题格式
			HSSFCellStyle style = workbook.createCellStyle();
			// 设置对齐方式
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			
			//设置字体
			Font font = workbook.createFont();
			//设置字号
			font.setBold(true);
			font.setFontHeightInPoints((short)10);
			style.setFont(font);
			
			for (int i = 0; i < mr_list.size(); i++) {
				HSSFRow row = sheet.createRow(0);
				HSSFCell cell1 = row.createCell(0);
				cell1.setCellValue("交易时间");
				HSSFCell cell2 = row.createCell(1);
				cell2.setCellValue("交易类型");
				HSSFCell cell3 = row.createCell(2);
				cell3.setCellValue("交易金额");
				HSSFCell cell4 = row.createCell(3);
				cell4.setCellValue("余额");
				HSSFCell cell5 = row.createCell(4);
				cell5.setCellValue("备注");

				cell1.setCellStyle(style);
				cell2.setCellStyle(style);
				cell3.setCellStyle(style);
				cell4.setCellStyle(style);
				cell5.setCellStyle(style);
				
				HSSFRow row2 = sheet.createRow(i + 1);
				MoneyRecord mr = mr_list.get(i);

				HSSFCell goodid = row2.createCell(0);
				goodid.setCellValue(mr.getM_happentime());

				HSSFCell goodname = row2.createCell(1);
				goodname.setCellValue(mr.getM_jytype());

				HSSFCell goodsort = row2.createCell(2);
				goodsort.setCellValue(mr.getM_dsmoney());

				HSSFCell goodvender = row2.createCell(3);
				goodvender.setCellValue(mr.getM_kymoney());

				HSSFCell goodprice = row2.createCell(4);
				goodprice.setCellValue(mr.getM_remark());

			}
			String savePath=path+"\\"+fileName+".xls";
			FileOutputStream fos = new FileOutputStream(savePath);
			workbook.write(fos);
			fos.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
