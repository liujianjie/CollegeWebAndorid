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

public class �߼����������� {

	public static void main(String []argv) {
		//����HSSFWorkbook����(excel���ĵ�����)
	      HSSFWorkbook wb = new HSSFWorkbook();
	    
	 
		//�����µ�sheet����excel�ı���
		HSSFSheet sheet=wb.createSheet("�ɼ���");

       // cellStyle.setWrapText(true);// ָ����Ԫ���Զ�����  
		//�ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������
		//sheet.addMergedRegion(new CellRangeAddress(1,2,0,1));
		//���ÿ�
		//sheet.setDefaultColumnWidth(20);
		
		//�����������
//		CellFormat cf = wb.getSheet(0).getCell(1, 0).getCellFormat();               
//		WritableCellFormat wc = new WritableCellFormat();
//		// ���þ���                
//		wc.setAlignment(Alignment.CENTRE);
//		// ���ñ߿���                 
//		wc.setBorder(Border.ALL, BorderLineStyle.THIN);           
//		// ���õ�Ԫ��ı�����ɫ             
//		wc.setBackground(jxl.format.Colour.RED); 
//		label = new Label(1,5,"����",wc);   
//		
//		WritableCellFormat wc = new WritableCellFormat();
//		// ���þ���                
//		try {
//			wc.setAlignment(Alignment.CENTRE);
//			// ���ñ߿���                 
//			wc.setBorder(Border.ALL, BorderLineStyle.THIN);           
//			// ���õ�Ԫ��ı�����ɫ             
//			wc.setBackground(jxl.format.Colour.RED);
//		} catch (WriteException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} 
//		Label la= new Label(1,5,"����",wc);   
		

		
		//��sheet�ﴴ����һ�У�����Ϊ������(excel����)��������0��65535֮����κ�һ��
		HSSFRow row1=sheet.createRow(0);
		//������Ԫ��excel�ĵ�Ԫ�񣬲���Ϊ��������������0��255֮����κ�һ��
		HSSFCell cell=row1.createCell(0);
		//���õ�Ԫ������
		cell.setCellValue("          ѧԱ���Գɼ�һ����");
		
		//�ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,8));
		//��sheet�ﴴ���ڶ���
		HSSFRow row2=sheet.createRow(1);    
        //������Ԫ�����õ�Ԫ������
        row2.createCell(0).setCellValue("����");
        row2.createCell(1).setCellValue("�༶");    
        row2.createCell(2).setCellValue("���Գɼ�");
        row2.createCell(3).setCellValue("���Գɼ�"); 
        
        //��sheet�ﴴ��������
        HSSFRow row3=sheet.createRow(2);
        row3.createCell(0).setCellValue("����");
        row3.createCell(1).setCellValue("As178");
        row3.createCell(2).setCellValue(87);    
        row3.createCell(3).setCellValue(78);
        HSSFRow row4=sheet.createRow(3);
        HSSFRow row5=sheet.createRow(4);
        
		//1.�������ñ�ע�Ŀ�� (ָ���ĸ���Ԫ��)
		//sheet.setColumnWidth(cell.getColumnIndex(),256 * 50);
  
        
        //��Ԫ������ϲ�
        HSSFCell cell4=row4.createCell(0);
        
        HSSFCell cell5=row5.createCell(0);
        
      
        //.....ʡ�Բ��ִ���
        //���Excel�ļ�
		try {
			//������������ C:\Users\Administrator\Desktop ����
			FileOutputStream output=new FileOutputStream("d:\\workbook.xls");
			wb.write(output);
			output.flush();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    //���Excel�ļ�
//	    OutputStream output=response.getOutputStream();
//	    response.reset();
//	    response.setHeader("Content-disposition", "attachment; filename=details.xls");
//	    response.setContentType("application/msexcel");        
//	    wkb.write(output);
//	    output.close();
//	    retrun null;
	}

}
