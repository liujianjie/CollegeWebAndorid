package com.ht.excel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class DBToExcel {
	public List selectAllUsers() {
		User u1 = new User();
		u1.setId(1);
		u1.setName("李四1");
		u1.setSex("男");
		u1.setAge(18);
		u1.setBirth("2015-12-12");
		u1.setCid("12324234");

		User u2 = new User();
		u2.setId(2);
		u2.setName("李四2");
		u2.setSex("女");
		u2.setAge(19);
		u2.setBirth("2015-12-13");
		u2.setCid("88888888888888");

		List list = new ArrayList();
		list.add(u1);
		list.add(u2);
		return list;
	}

	public void dbtoexcel() {
		try {
			// 创建可写入的Excel工作簿
			String fileName = "D://user.xls";
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			WritableWorkbook wwb = Workbook.createWorkbook(file);

			// 创建工作表 (名称 ，工作表位置)
			WritableSheet ws = wwb.createSheet("Test Shee 1", 0);

			// 获取数据
			DBToExcel db = new DBToExcel();
			List list = db.selectAllUsers();

			
			//设置标题样式和内容样式
			WritableFont headerFont = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK); // 第一行字体
			//标题设置字体
			WritableCellFormat headerFormat1 = new WritableCellFormat(
					headerFont);
			headerFormat1.setAlignment(Alignment.CENTRE);
			headerFormat1.setBorder(Border.ALL, BorderLineStyle.THIN,
					Colour.BLACK);
			
			WritableCellFormat headerFormat2 = new WritableCellFormat();
			headerFormat2.setAlignment(Alignment.CENTRE);
			headerFormat2.setBorder(Border.ALL, BorderLineStyle.THIN,
					Colour.BLACK);
			
			
			//设置列宽
			for (int j = 0; j < 6; j++) {// 设置列宽
				ws.setColumnView(j, 20);
			}
			
			// 要插入到的Excel表格的标题，默认从0开始
			Label labelId = new Label(0, 0, "编号",headerFormat1);// (列 行 名称)
			Label labelName = new Label(1, 0, "姓名",headerFormat1);
			Label labelSex = new Label(2, 0, "性别",headerFormat1);
			Label age = new Label(3, 0, "年龄",headerFormat1);
			Label birth = new Label(4, 0, "生日",headerFormat1);
			Label cid = new Label(5, 0, "身份证号",headerFormat1);

			// 标题列添加到工作表
			ws.addCell(labelId);
			ws.addCell(labelName);
			ws.addCell(labelSex);
			ws.addCell(age);
			ws.addCell(birth);
			ws.addCell(cid);
			
			
			for (int i = 0; i < list.size(); i++) {
				User u = (User) list.get(i);
				Label labelId_i = new Label(0, i + 1, u.getId() + "",headerFormat2);
				Label labelName_i = new Label(1, i + 1, u.getName(),headerFormat2);
				Label labelSex_i = new Label(2, i + 1, u.getSex(),headerFormat2);
				Label labelNum_i = new Label(3, i + 1, u.getAge() + "",headerFormat2);
				Label labelBirth_i = new Label(4, i + 1, u.getBirth(),headerFormat2);
				Label labelCid_i = new Label(5, i + 1, u.getCid(),headerFormat2);
				ws.addCell(labelId_i);
				ws.addCell(labelName_i);
				ws.addCell(labelSex_i);
				ws.addCell(labelNum_i);
				ws.addCell(labelBirth_i);
				ws.addCell(labelCid_i);
			}
			// 写进文档
			wwb.write();
			// 关闭Excel工作簿对象
			wwb.close();
			
			System.out.println("生成Excel完毕");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DBToExcel db=new DBToExcel();
		db.dbtoexcel();
	}
}
