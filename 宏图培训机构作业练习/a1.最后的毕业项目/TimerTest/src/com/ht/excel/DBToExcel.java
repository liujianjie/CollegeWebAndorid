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
		u1.setName("����1");
		u1.setSex("��");
		u1.setAge(18);
		u1.setBirth("2015-12-12");
		u1.setCid("12324234");

		User u2 = new User();
		u2.setId(2);
		u2.setName("����2");
		u2.setSex("Ů");
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
			// ������д���Excel������
			String fileName = "D://user.xls";
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			WritableWorkbook wwb = Workbook.createWorkbook(file);

			// ���������� (���� ��������λ��)
			WritableSheet ws = wwb.createSheet("Test Shee 1", 0);

			// ��ȡ����
			DBToExcel db = new DBToExcel();
			List list = db.selectAllUsers();

			
			//���ñ�����ʽ��������ʽ
			WritableFont headerFont = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					Colour.BLACK); // ��һ������
			//������������
			WritableCellFormat headerFormat1 = new WritableCellFormat(
					headerFont);
			headerFormat1.setAlignment(Alignment.CENTRE);
			headerFormat1.setBorder(Border.ALL, BorderLineStyle.THIN,
					Colour.BLACK);
			
			WritableCellFormat headerFormat2 = new WritableCellFormat();
			headerFormat2.setAlignment(Alignment.CENTRE);
			headerFormat2.setBorder(Border.ALL, BorderLineStyle.THIN,
					Colour.BLACK);
			
			
			//�����п�
			for (int j = 0; j < 6; j++) {// �����п�
				ws.setColumnView(j, 20);
			}
			
			// Ҫ���뵽��Excel���ı��⣬Ĭ�ϴ�0��ʼ
			Label labelId = new Label(0, 0, "���",headerFormat1);// (�� �� ����)
			Label labelName = new Label(1, 0, "����",headerFormat1);
			Label labelSex = new Label(2, 0, "�Ա�",headerFormat1);
			Label age = new Label(3, 0, "����",headerFormat1);
			Label birth = new Label(4, 0, "����",headerFormat1);
			Label cid = new Label(5, 0, "���֤��",headerFormat1);

			// ��������ӵ�������
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
			// д���ĵ�
			wwb.write();
			// �ر�Excel����������
			wwb.close();
			
			System.out.println("����Excel���");

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
