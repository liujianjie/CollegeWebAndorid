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

public class ģ�� {
	public static void main(String[] args) {
		//����HSSFWorkbook����(excel���ĵ�����)
	    HSSFWorkbook wb = new HSSFWorkbook();

		//�����µ�sheet����excel�ı���
		HSSFSheet sheet=wb.createSheet("�ɼ���");
		
		HSSFCellStyle setBorder = wb.createCellStyle();
		setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		setBorder.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		//���Ӧ��������ȫ�ֵģ������԰�
		
		HSSFCellStyle cellStyle = wb.createCellStyle();  
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // ����    
		HSSFFont font = wb.createFont();    
		font.setFontName("����");    
		font.setFontHeightInPoints((short) 16);//���������С    
		HSSFFont font2 = wb.createFont();    
		font2.setFontName("����_GB2312");    
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//������ʾ    
		font2.setFontHeightInPoints((short) 12);    
		cellStyle.setFont(font);//ѡ����Ҫ�õ��������ʽ  
		
		//��sheet�ﴴ����һ�У�����Ϊ������(excel����)��������0��65535֮����κ�һ��
		HSSFRow row1=sheet.createRow(0);
		//������Ԫ��excel�ĵ�Ԫ�񣬲���Ϊ��������������0��255֮����κ�һ��
		HSSFCell cell=row1.createCell(0);
		//���õ�Ԫ������
		cell.setCellValue("�����Զ���ϵ-��ͼ���������Ŀ������ֱ�");
		//�ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,9));
		cell.setCellStyle(cellStyle);
		//��sheet�ﴴ���ڶ���
		HSSFRow row2=sheet.createRow(1); 
		
        //������Ԫ�����õ�Ԫ������
        row2.createCell(0).setCellValue("�鳤");
        row2.createCell(1).setCellValue("��Ա");    
        row2.createCell(2).setCellValue("��������(50)");
        row2.createCell(3).setCellValue("�����Ѷ�(10)"); 
        row2.createCell(4).setCellValue("��������(10)");
        row2.createCell(5).setCellValue("��ʾ����(10)");
        row2.createCell(6).setCellValue("���Ա��(10)");
        row2.createCell(7).setCellValue("�ش�����(10)");
        row2.createCell(8).setCellValue("�ܷ�(100)");
        row2.createCell(9).setCellValue("��ע");
        //��sheet�ﴴ��������
        HSSFRow row3=sheet.createRow(2);
        row3.createCell(0).setCellValue("������");
        row3.createCell(1).setCellValue("������");    
        row3.createCell(2).setCellValue("50");
        row3.createCell(3).setCellValue("10"); 
        row3.createCell(4).setCellValue("10");
        row3.createCell(5).setCellValue("6");
        row3.createCell(6).setCellValue("6");
        row3.createCell(7).setCellValue("10");
        row3.createCell(8).setCellValue("92");
        row3.createCell(9).setCellValue("���˱��������󶨣�����֤����");
        
        //��sheet�ﴴ��������
        HSSFRow row4=sheet.createRow(3);
        row4.createCell(0).setCellValue("������");
        row4.createCell(1).setCellValue("��Ŷ�");    
        row4.createCell(2).setCellValue("50");
        row4.createCell(3).setCellValue("10"); 
        row4.createCell(4).setCellValue("10");
        row4.createCell(5).setCellValue("6");
        row4.createCell(6).setCellValue("6");
        row4.createCell(7).setCellValue("10");
        row4.createCell(8).setCellValue("92");
        row4.createCell(9).setCellValue("ǰ̨ҳ��");
        
		//���������еĿ�
		sheet.setDefaultColumnWidth(10);
		
	    //1.�������ñ�ע�Ŀ�� (ָ���ĸ���Ԫ��)
		sheet.setColumnWidth(row3.createCell(9).getColumnIndex(),256 * 50);
		
		
		//�ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������
		sheet.addMergedRegion(new CellRangeAddress(2,3,0,0));
		
		//�������
		HSSFCellStyle align_style = wb.createCellStyle();
		align_style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	//	cell.setCellStyle(align_style);
	
		
		//���Excel�ļ�
		try {
			//������������ C:\Users\Administrator\Desktop ����
			FileOutputStream output=new FileOutputStream("d:\\workboo.xls");
			wb.write(output);
			output.flush();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
