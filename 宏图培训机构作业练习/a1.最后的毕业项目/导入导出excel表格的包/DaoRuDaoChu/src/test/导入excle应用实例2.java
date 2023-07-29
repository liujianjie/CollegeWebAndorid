package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class ����excleӦ��ʵ��2 {
	public static void main(String[] args) {
		try {
			//�õ���������е�����
	        List listExcel=StuService.getAllByExcel("d://book.xls");
	        /*//�õ����ݿ�������е�����
	        List<StuEntity> listDb=StuService.getAllByDb();*/
	        
	        DBhepler db=new DBhepler();
	        
	        for (StuEntity stuEntity : listExcel) {
	            int id=stuEntity.getId();
	            if (!StuService.isExist(id)) {
	                //�����ھ����
	                String sql="insert into stu (name,sex,num) values(?,?,?)";
	                String[] str=new String[]{stuEntity.getName(),stuEntity.getSex(),stuEntity.getNum()+""};
	                db.AddU(sql, str);
	            }else {
	                //���ھ͸���
	                String sql="update stu set name=?,sex=?,num=? where id=?";
	                String[] str=new String[]{stuEntity.getName(),stuEntity.getSex(),stuEntity.getNum()+"",id+""};
	                db.AddU(sql, str);
	            }
	        }
	}
}
