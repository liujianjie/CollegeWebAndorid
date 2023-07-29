package test;
import java.util.List;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
public class 可写入的 {
public static void main(String[] args) {
	 try {
		WritableWorkbook wwb = null;
		 
		 // 创建可写入的Excel工作簿
		 String fileName = "D://book.xls";
		 File file=new File(fileName);
		 if (!file.exists()) {
		     file.createNewFile();
		 }
		 //以fileName为文件名来创建一个Workbook
		 wwb = Workbook.createWorkbook(file);

		 // 创建工作表
		 WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
		 
		 //查询数据库中所有的数据
		 //要插入到的Excel表格的行号，默认从0开始
		 Label labelId= new Label(0, 0, "编号(id)");//表示第一行第一个单元格
		 Label labelName= new Label(1, 0, "姓名(name)");
		 Label labelSex= new Label(2, 0, "性别(sex)");
		 Label labelNum= new Label(3, 0, "薪水(num)2323123十分士大夫士大夫");
		 Label labelNum4= new Label(4, 0, "2");
		 ws.addCell(labelId);
		 ws.addCell(labelName);
		 ws.addCell(labelSex);
		 ws.addCell(labelNum);
		 ws.addCell(labelNum4);
		 Label labelId1= new Label(0, 1, "1");//表示第一行第一个单元格
		 Label labelName1= new Label(1, 1, "刘建杰");
		 Label labelSex1= new Label(2, 1, "男");
		 Label labelNum1= new Label(3, 1, "10000");
		 
		 ws.addCell(labelId1);
		 ws.addCell(labelName1);
		 ws.addCell(labelSex1);
		 ws.addCell(labelNum1);
		 
		//设置字体居中
		WritableCellFormat wcf=new WritableCellFormat();
		try {
			wcf.setAlignment(Alignment.CENTRE);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
		} catch (WriteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Label label = new Label(0,2,"jjjjjj");
		label.setCellFormat(wcf);
		ws.addCell(label);
		 
		//写进文档
		 wwb.write();
		// 关闭Excel工作簿对象
		 wwb.close();
	} catch (RowsExceededException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (WriteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
}
}
