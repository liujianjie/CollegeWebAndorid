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
public class ��д��� {
public static void main(String[] args) {
	 try {
		WritableWorkbook wwb = null;
		 
		 // ������д���Excel������
		 String fileName = "D://book.xls";
		 File file=new File(fileName);
		 if (!file.exists()) {
		     file.createNewFile();
		 }
		 //��fileNameΪ�ļ���������һ��Workbook
		 wwb = Workbook.createWorkbook(file);

		 // ����������
		 WritableSheet ws = wwb.createSheet("Test Shee 1", 0);
		 
		 //��ѯ���ݿ������е�����
		 //Ҫ���뵽��Excel�����кţ�Ĭ�ϴ�0��ʼ
		 Label labelId= new Label(0, 0, "���(id)");//��ʾ��һ�е�һ����Ԫ��
		 Label labelName= new Label(1, 0, "����(name)");
		 Label labelSex= new Label(2, 0, "�Ա�(sex)");
		 Label labelNum= new Label(3, 0, "нˮ(num)2323123ʮ��ʿ���ʿ���");
		 Label labelNum4= new Label(4, 0, "2");
		 ws.addCell(labelId);
		 ws.addCell(labelName);
		 ws.addCell(labelSex);
		 ws.addCell(labelNum);
		 ws.addCell(labelNum4);
		 Label labelId1= new Label(0, 1, "1");//��ʾ��һ�е�һ����Ԫ��
		 Label labelName1= new Label(1, 1, "������");
		 Label labelSex1= new Label(2, 1, "��");
		 Label labelNum1= new Label(3, 1, "10000");
		 
		 ws.addCell(labelId1);
		 ws.addCell(labelName1);
		 ws.addCell(labelSex1);
		 ws.addCell(labelNum1);
		 
		//�����������
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
		 
		//д���ĵ�
		 wwb.write();
		// �ر�Excel����������
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
