package com.ht.yfbc.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.ht.yfbc.dao.WarehouseDao;
import com.ht.yfbc.pojo.Goodtype;
import com.ht.yfbc.pojo.InStorage;
import com.ht.yfbc.pojo.Salary;
import com.ht.yfbc.pojo.SalaryVo;
import com.ht.yfbc.pojo.Users;
import com.ht.yfbc.pojo.Warehouse2;
import com.ht.yfbc.service.GoodtypeService;
import com.ht.yfbc.service.InStorageService;
import com.ht.yfbc.service.WarehouseService;

/**
 * 入库计划单控制层
 * day 2016-12-28
 * @author 刘建杰
 *
 */

@Controller
@RequestMapping("instorage")
public class InStorageController {
	
	@Resource
	private InStorageService instorageservice;
	
	@Resource
	private GoodtypeService goodservice;
	
	@Resource
	private WarehouseDao wardao;
	
	@RequestMapping("list")
	private String list(Model model,
			@RequestParam(value = "cpage")Integer cpage){
		System.out.println("计划订单数据表");
		Map<String, Object> maps = instorageservice.selInStoragelist(cpage,null,null,null);
		model.addAttribute("maps", maps);
		return "liujianjie/Instoragelist";
	}
	//超级管理员的条件查询
	@RequestMapping("listofwhere")
	private String listofwhere(Model model,
			@RequestParam(value = "cpage")Integer cpage,
			@RequestParam(value = "starttime")String starttime,
			@RequestParam(value = "endtime")String endtime,
			@RequestParam(value = "whid")String whid){
		if(starttime.equals("999")){//没有选的时候
			starttime=null;
		}if(endtime.equals("999")){
			endtime=null;
		}if(whid.equals("999")){
			whid=null;
		}
		Map<String, Object> maps = instorageservice.selInStoragelist(cpage,starttime,endtime,whid);
		model.addAttribute("maps", maps);
		
		return "liujianjie/Instoragelist";
	}
	
	//仓库管理员
	@RequestMapping("list2")
	private String list2(Model model,
			HttpServletRequest request,
			@RequestParam(value = "cpage")Integer cpage){
		HttpSession session  = request.getSession();
		Users user = (Users) session.getAttribute("user");
		Map<String, Object> maps = instorageservice.selInStoragelist2(cpage,user.getWarehouseid(),null,null);
		model.addAttribute("maps", maps);
		return "liujianjie/Instoragelist2";
	}
	@RequestMapping("list2ofwhere")
	private String list2ofwhere(Model model,
			HttpServletRequest request,
			@RequestParam(value = "cpage")Integer cpage,
			@RequestParam(value = "starttime")String starttime,
			@RequestParam(value = "endtime")String endtime){
		if(starttime.equals("999")){//没有选的时候
			starttime=null;
		}if(endtime.equals("999")){
			endtime=null;
		}
		HttpSession session  = request.getSession();
		Users user = (Users) session.getAttribute("user");
		Map<String, Object> maps = instorageservice.selInStoragelist2(cpage,user.getWarehouseid(),starttime,endtime);
		model.addAttribute("maps", maps);
		return "liujianjie/Instoragelist2";
	}
	@RequestMapping("toadd")
	private String toadd(Model model){
		//仓库
		List<Warehouse2> warelist = wardao.selWarehouseAll();
		model.addAttribute("warelist", warelist);
		return "liujianjie/Instorageadd";
	}
	@RequestMapping("add")
	private String add(@RequestParam(value = "files",required = false)MultipartFile file,
			InStorage instorage){
//		String str_temp = cell6.getStringCellValue().trim();//得到值
//		System.out.println(DateUtil.getJavaDate(cell9.getNumericCellValue()));
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
			HSSFSheet sheet = workbook.getSheetAt(0);
			int lastnum = sheet.getLastRowNum();
			for (int i = 1; i <= lastnum; i++) {
				HSSFRow row = sheet.getRow(i);	
				for (int j = 1; j <= 9; j++) {
					HSSFCell cell = row.getCell(j);
						
					switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_STRING:
							if(j==1){//产品名称
								instorage.setProductname(cell.getStringCellValue());
							}else if(j==2){//商品类型
								instorage.setSku(cell.getStringCellValue());
							}else if(j==4){//单位
								//件 单位
								String uint = cell.getStringCellValue();
								if(uint.equals("个")){
									instorage.setUnit(0);
								}else if(uint.equals("件")){
									instorage.setUnit(1);
								}else if(uint.equals("千克")){
									instorage.setUnit(2);
								}
							}else if(j==5){//供应商
								instorage.setSupplier(cell.getStringCellValue());
							}else if(j==7){//收货人
								instorage.setReceivename(cell.getStringCellValue());
							}
						case HSSFCell.CELL_TYPE_NUMERIC:
							if(j==3){//数量
								cell.setCellType(1);
								instorage.setPurchaseqty(Integer.parseInt((cell.getStringCellValue().trim())));
							}else if(j==6){//供应商号码
								cell.setCellType(1);
								instorage.setSupplierno(cell.getStringCellValue().trim());
							}else if(j==8){//收货人号码
								cell.setCellType(1);
								instorage.setReceiveno(cell.getStringCellValue().trim());
							}else if(j==9){//日期
								instorage.setArrivaldate(DateUtil.getJavaDate(cell.getNumericCellValue()));
							}
							
						break;
					}	
				}
				//未收货
				instorage.setInstate(0);
				//订单号
				instorage.setInno((new Random().nextInt(10000000)+100)+"");
				instorageservice.addInStorage(instorage);
			}
			workbook.close();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return "redirect:/instorage/list2.do?cpage=1";
	}
	//导出模板
//	@RequestMapping("outs")
//	private void outs(HttpServletRequest request,
//			HttpServletResponse res,Model model) throws IOException{
//	String filename="入库计划单.xls";
//	if(filename != null && !filename.equals(" ")){
//		String path = request.getSession().getServletContext().getRealPath("xlsFiles");
//		File file = new File(path, filename);
//		filename = new String(filename.getBytes(), "ISO-8859-1");
//		OutputStream os = res.getOutputStream();
//		try {
//			res.reset();
//			res.setContentType("application/octet-stream; charset=utf-8");
//			res.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
//			os.write(FileUtils.readFileToByteArray(file));
//			os.flush();
//		} finally {
//			if (os != null) {
//				os.close();
//			}
//		}
//		}
//	}
	@RequestMapping("outs")
	private ResponseEntity<byte[]> outs(HttpServletRequest request,
			HttpServletResponse response,Model model) {
		try {
			// 新建一个xls文件，并完成数据初始化，将新建的xls文件存到服务器
			String path = request.getSession().getServletContext().getRealPath("xlsFiles");// 获得上传的路径
			String filePath = saveAsExcl(path);
			System.out.println(filePath);

			// 从服务器下载该文件
			String fileName ="入库计划单表.xls";
			// 如果文件名有中文，需要对其进行url编码
//			File file=new File("D:\\tomcat7.0\\apache-tomcat-7.0.73\\webapps\\yfbc\\xlsFiles\\工资表.xls");
			File file=new File(filePath);  
			System.out.println(file.exists());
	        HttpHeaders headers = new HttpHeaders();    
	        String newfileName=new String(fileName.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
	        headers.setContentDispositionFormData("attachment", newfileName);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
		                                          headers, HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String saveAsExcl(String path) {
		String filePath = path + "\\入库计划单.xls";
		try {
			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFSheet sheet1 = workBook.createSheet("入库表");
			// 设置标题
			HSSFRow row1 = sheet1.createRow(0);
			HSSFCell cell1 = row1.createCell(0);
			cell1.setCellValue("编号");
			HSSFCell cell2 = row1.createCell(1);
			cell2.setCellValue("产品名称");
			HSSFCell cell3 = row1.createCell(2);
			cell3.setCellValue("商品类型");
			HSSFCell cell4 = row1.createCell(3);
			cell4.setCellValue("数量");
			HSSFCell cell5 = row1.createCell(4);
			cell5.setCellValue("单位（个、件、千克）");
			HSSFCell cell6 = row1.createCell(5);
			cell6.setCellValue("供应商");
			HSSFCell cell7 = row1.createCell(6);
			cell7.setCellValue("供应商号码");
			HSSFCell cell8 = row1.createCell(7);
			cell8.setCellValue("收货人");
			HSSFCell cell9 = row1.createCell(8);
			cell9.setCellValue("收货人号码");
			HSSFCell cell10 = row1.createCell(9);
			cell10.setCellValue("计划入库时间");

			FileOutputStream fos = new FileOutputStream(filePath);
			workBook.write(fos);
			workBook.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}
}
