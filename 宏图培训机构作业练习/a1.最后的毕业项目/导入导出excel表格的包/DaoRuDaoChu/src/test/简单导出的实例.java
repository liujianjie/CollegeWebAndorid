package test;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class �򵥵�����ʵ�� {
	public static void main(String[] args) {
		//����HSSFWorkbook���� �������򿪻��ߴ��� excel�ļ�����
		HSSFWorkbook wb = new HSSFWorkbook();
		//����HSSFSheet���� 
		HSSFSheet sheet = wb.createSheet("sheet0");
		//����HSSFRow����  ���������ϱ߶��ٸ�
		HSSFRow row = sheet.createRow(0);
		//����HSSFCell���� ����������߶��ٸ�
		HSSFCell cell=row.createCell(0);
		//���õ�Ԫ���ֵ
		cell.setCellValue("��Ԫ���е�����");
		//���Excel�ļ�
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
