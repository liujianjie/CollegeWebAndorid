package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class 导入excle应用实例2 {
	public static void main(String[] args) {
		try {
			//得到表格中所有的数据
	        List listExcel=StuService.getAllByExcel("d://book.xls");
	        /*//得到数据库表中所有的数据
	        List<StuEntity> listDb=StuService.getAllByDb();*/
	        
	        DBhepler db=new DBhepler();
	        
	        for (StuEntity stuEntity : listExcel) {
	            int id=stuEntity.getId();
	            if (!StuService.isExist(id)) {
	                //不存在就添加
	                String sql="insert into stu (name,sex,num) values(?,?,?)";
	                String[] str=new String[]{stuEntity.getName(),stuEntity.getSex(),stuEntity.getNum()+""};
	                db.AddU(sql, str);
	            }else {
	                //存在就更新
	                String sql="update stu set name=?,sex=?,num=? where id=?";
	                String[] str=new String[]{stuEntity.getName(),stuEntity.getSex(),stuEntity.getNum()+"",id+""};
	                db.AddU(sql, str);
	            }
	        }
	}
}
