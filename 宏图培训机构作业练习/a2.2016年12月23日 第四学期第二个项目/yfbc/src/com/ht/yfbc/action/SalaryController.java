package com.ht.yfbc.action;

import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ht.yfbc.pojo.Basesalary;
import com.ht.yfbc.pojo.Expend;
import com.ht.yfbc.pojo.Rewards_penalties;
import com.ht.yfbc.pojo.Salary;
import com.ht.yfbc.pojo.SalaryVo;
import com.ht.yfbc.pojo.ShowIndex;
import com.ht.yfbc.pojo.Users;
import com.ht.yfbc.service.BasesalaryService;
import com.ht.yfbc.service.ExpendService;
import com.ht.yfbc.service.IncomeService;
import com.ht.yfbc.service.PositionService;
import com.ht.yfbc.service.Rewards_penaltiesService;
import com.ht.yfbc.service.SalaryService;
import com.ht.yfbc.service.UsersService;

@Controller
@RequestMapping("salary")
public class SalaryController {
	/**
	 * 用户相关的service
	 */
	@Resource
	private UsersService usersService;
	/**
	 * 岗位相关的service
	 */
	@Resource
	private PositionService posService;
	/**
	 * 基本工资相关的service
	 */
	@Resource
	private BasesalaryService basesalService;
	/**
	 * 工资相关的service
	 */
	@Resource
	private SalaryService salaryService;
	/**
	 * 奖惩表相关的service
	 */
	@Resource
	private Rewards_penaltiesService rpService;
	/**
	 * 支出表相关的service
	 */
	@Resource
	private ExpendService expendService;
	
	/**
	 * 支出表相关的service
	 */
	@Resource
	private IncomeService incomeService;

	@ResponseBody
	@RequestMapping("showindex")
	public Map<String, Object> showindex(){
		Map<String, Object> map=new HashMap<String,Object>();
		String time="";
		List<ShowIndex> showindexlist=new ArrayList<ShowIndex>();
		
		
		for (int i = 0; i < 3; i++) {
			String year=getYear();
			String month=getMonth();
			if(i==0){
				if(Integer.parseInt(month)<10){
					month="0"+month;
				}
				time=year+"-"+month;
			}else if(i==1){
				if(Integer.parseInt(month)==1){
					year=(Integer.parseInt(year)-1)+"";
					month="12";
				}else{
					month=(Integer.parseInt(month)-1)+"";
				}
				if(Integer.parseInt(month)<10){
					month="0"+month;
				}
				time=year+"-"+month;
			}else if(i==2){
				if(Integer.parseInt(month)==1){
					year=(Integer.parseInt(year)-1)+"";
					month="11";
				}else if(Integer.parseInt(month)==2){
					year=(Integer.parseInt(year)-1)+"";
					month="12";
				}
				if(Integer.parseInt(month)<10){
					month="0"+month;
				}
				time=year+"-"+month;
			}
			
			ShowIndex show1=new ShowIndex();
			Double expend_money=expendService.selexpend(time);
			if(expend_money==null){
				show1.setExpend(0.00);
			}else{
				show1.setExpend(expend_money);
			}
			Double income_money=incomeService.selincome(time);
			System.out.println(income_money);
			if(income_money==null){
				show1.setIncome(0.00);
			}else{
				show1.setIncome(income_money);
			}
			show1.setTime(time);
			showindexlist.add(show1);
		}
		System.out.println("showindex"+showindexlist.size());
		map.put("showindexlist", showindexlist);
		return map;
	}
	@ResponseBody
	@RequestMapping("alluser")
	public Map<String, Object> selAllUsers() {

		List<Users> list = usersService.selUserList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("users", list);
		return map;
	}

	@ResponseBody
	@RequestMapping("userinfo")
	public Map<String, Object> selUserInfo(@RequestParam(value = "userid") String userid) {
		Users user = usersService.selUsersById(userid);
		String positionname = posService.selPositionNameById(user.getPositionid());
		Basesalary basesalary = basesalService.selBasesalaryByPositionId(user.getPositionid());
		Map<String, Object> map = new HashMap<String, Object>();
		Salary salary = new Salary();
		salary.setUserid(userid);
		salary.setPositionid(user.getPositionid());
		salary.setBasesal(basesalary.getBasesal());
		map.put("positionname", positionname);
		map.put("salary", salary);
		return map;
	}
	/**
	 * 根据年查询本年工资发放情况，
	 * @param year
	 * @param month
	 * @return
	 */
	@ResponseBody
	@RequestMapping("selchart")
	public Map<String, Object> selchart(@RequestParam(value = "year", required = false) String year) {
		Map<String, Object> map = new HashMap<String, Object>();
		for(int i=1;i<=12;i++){
			String month=i+"";
			if(i<10){
				month="0"+i;
			}
			String time=year+"-"+month;
			Double sum_sal=salaryService.selSfgzByMap(time);
			System.out.println(sum_sal);
			map.put("month"+i, sum_sal);
		}
		return map;
	}
	/**
	 * 
	 * @param year
	 * @param month
	 * @param model
	 * @return
	 */
	@RequestMapping("toaddsalary")
	public String toaddSalary(@RequestParam(value = "year", required = false) String year,
			@RequestParam(value = "month", required = false) String month, Model model) {
		year=getYear();
		month=getMonth();
		List<SalaryVo> salaryVoList=getsalaryVoList(year, month);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("salaryVoList", salaryVoList);
		return "addSalary";
	}

	@RequestMapping("addsalary")
	public String addSalary(Salary salary) {
		Double sfgz = salary.getBasesal() + salary.getDeduction_wage() + salary.getBonus() - salary.getFine();
		salary.setSfgz(sfgz);
		salaryService.addSalary(salary);
		return "redirect:/addSalary.jsp";
	}
/**
 * 导入表格数据并存到数据库中
 * @param file
 * @param model
 * @param request
 * @return
 */
	@RequestMapping("addsalaryExcel")
	public String addSalaryExcel(@RequestParam(value = "fileSelect", required = false) MultipartFile file, Model model,
			HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			HSSFWorkbook work = new HSSFWorkbook(file.getInputStream());
			HSSFSheet sheet = work.getSheetAt(0);
			int lastnum = sheet.getLastRowNum();
			List<SalaryVo> salaryvolist = new ArrayList<SalaryVo>(lastnum);
			for (int i = 1; i <= lastnum; i++) {
				Salary salary = new Salary();
				SalaryVo salaryvo = new SalaryVo();// 将表格的每一行用salaryvo对象保存起来
				HSSFRow dataRow = sheet.getRow(i);
				for (int j = 0; j < 10; j++) {
					HSSFCell cell = dataRow.getCell(j);
					if (j == 8) {// 实发工资
						Double sfgz = salary.getBasesal() + salary.getBonus() + salary.getDeduction_wage()
								- salary.getFine();
						salary.setSfgz(sfgz);
						continue;
					}

					switch (cell.getCellType()) {// 获得单元格数据格式
					case HSSFCell.CELL_TYPE_STRING:// 字符串类型
						if (j == 0) {// 用户id
							salary.setUserid(cell.getStringCellValue());
							break;
						} else if (j == 1) {// 用户姓名
							salaryvo.setUsername(cell.getStringCellValue());
							break;
						} else if (j == 2) {// 职位id
							salary.setPositionid(cell.getStringCellValue());
							break;
						} else if (j == 3) {// 职位名称
							salaryvo.setPositionname(cell.getStringCellValue());
							break;
						}
						break;
					case HSSFCell.CELL_TYPE_NUMERIC:// 数值和日期类型
						// System.out.println(cell.getCellStyle().getDataFormatString());
						String style = cell.getCellStyle().getDataFormatString();
						if (j==9||"yyyy-MM-dd".equals(style) || "m/d/yy".equals(style)) {// 时间
							salary.setTime(DateUtil.getJavaDate(cell.getNumericCellValue()));
							break;
						} else {
							if (j == 4) {// 基本工资
								salary.setBasesal(cell.getNumericCellValue());
								break;
							} else if (j == 5) {// 提成工资
								salary.setDeduction_wage(cell.getNumericCellValue());
								break;
							} else if (j == 6) {// 奖励金额
								salary.setBonus(cell.getNumericCellValue());
								break;
							} else if (j == 7) {// 处罚金额
								salary.setFine(cell.getNumericCellValue());
								break;
							}
						}
						break;
					default:
						break;
					}
				}
				salaryvo.setSalary(salary);
				salaryvolist.add(salaryvo);
			}
			work.close();
			//将数据保存到数据库
			//先根据时间判断数据库是否存在
			session.removeAttribute("issuccess");
			boolean isExist=false;
			String time="";
			for (SalaryVo salaryVo2 : salaryvolist) {
				Salary salary =salaryVo2.getSalary();
				time=salary.getTime().toLocaleString();
				String year=time.substring(0,time.indexOf("-"));
				String month=time.substring(time.indexOf("-")+1,time.lastIndexOf("-"));
				if(Integer.parseInt(month)<10){
					month="0"+month;
				}
				time=year+"-"+month;
				System.out.println(year+"-"+month);
				Salary salary2=salaryService.isExist(salary.getUserid(),time );
				
				if(salary2==null){//判断时间不是本月，才添加到数据库
					session.setAttribute("issuccess",1);
				}else{
					session.setAttribute("issuccess",2);
					isExist=true;
					break;
				}
				
			}
			//根据时间判断，没有添加过，则添加，添加完成后，查询总工资，添加支出表数据
			if(!isExist){
				Date exptime=new Date();
				for (SalaryVo salaryVo2 : salaryvolist) {
					Salary salary =salaryVo2.getSalary();
					exptime=salary.getTime();
					salaryService.addSalary(salary);
				}
				System.out.println(time);
				Double sfgz=salaryService.selSfgzByMap(time);
				System.out.println(sfgz);
				Expend expend=new Expend();
				expend.setExptime(exptime);
				expend.setMoney(sfgz);
				expend.setExptypes("工资发放");
				expendService.addExpend(expend);
				
			}
			session.setAttribute("year", getYear());
			session.setAttribute("month", getMonth());
			session.setAttribute("salaryVoList", salaryvolist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/addSalary.jsp";
	}

	
	// 导出
	@RequestMapping("expSalaryExcel")
	public ResponseEntity<byte[]> expSalaryExcel2(@RequestParam(value = "list", required = false) String tableValue,
			@RequestParam(value = "listsize", required = false) Integer listsize,
			@RequestParam(value = "year", required = false) String year,
			@RequestParam(value = "month", required = false) String month, HttpServletRequest request,
			HttpServletResponse response,Model model) {
			
		try {
			// 从页面获得table中的数据,将其转成list:tableValueTosalaryVoList
			List<SalaryVo> sallist = getsalaryVoList(year,month);
			// 新建一个xls文件，并完成数据初始化，将新建的xls文件存到服务器
			String path = request.getSession().getServletContext().getRealPath("xlsFiles");// 获得上传的路径
			String filePath = saveAsExcl(sallist, path);
			System.out.println(filePath);

			// 从服务器下载该文件
			String fileName ="工资表"  
	                + Calendar.getInstance().getTimeInMillis()+".xls";
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
	public List<SalaryVo> getsalaryVoList(String year,String month){
		// 1.当前时间：年-月，查询是否已发工资。查出已发工资的用户id
				if (year == null) {
					year = getYear();
				}
				if (month == null) {
					month = getMonth();
				}
				if (Integer.parseInt(month) < 10) {
					month = "0" + month;
				}
				Map<String, Object> map = new HashMap<String, Object>();
				String time = year + "-" + month;
				map.put("time", time);
				// 已发工资的用户
				List<Salary> salarylist = salaryService.selSalaryList(map);
				// 2.查出未发工资的用户信息（姓名，岗位，基本工资，奖惩金额，提成金额等。。。）
				int total = salarylist.size();
				if (total > 0) {

					String useridstr = "";
					for (int j = 0; j < total; j++) {
						useridstr += "'" + salarylist.get(j).getUserid() + "',";
					}

					useridstr = useridstr.substring(0, useridstr.length() - 1);// 得到已发工资的用户id
					map.put("useridstr", useridstr);// 根据已发工资的用户id查出not in useridstr的用户
				} else {
					map.put("useridstr", "1");
				}
				List<Users> userlist = usersService.selUserListByMap(map);
				total = userlist.size();
				List<SalaryVo> salaryVoList = new ArrayList<SalaryVo>(total);
				for (Users users : userlist) {
					Salary salary = new Salary();
					SalaryVo salaryVo = new SalaryVo();
					// System.out.println(users.toString());
					// 查出岗位名称、用户名，基本工资
					String positionname = posService.selPositionNameById(users.getPositionid());
					String username = usersService.selUsernameById(users.getId());
					Basesalary basesalary = basesalService.selBasesalaryByPositionId(users.getPositionid());
					Double basesal = basesalary.getBasesal();
					salary.setPositionid(users.getPositionid());
					salary.setBasesal(basesal);
					salary.setUserid(users.getId());

					Map<String, Object> map2 = new HashMap<String, Object>();
					map2.put("userid", salary.getUserid());
					map2.put("recordtime", time);
					List<Rewards_penalties> rplist = rpService.selRewards_penaltiesList(map2);
					Double bonus = 0.00;
					Double fine = 0.00;
					Double deduction_wage=0.00;
					if (rplist.size() > 0) {
						for (Rewards_penalties rewards_penalties : rplist) {
							bonus += rewards_penalties.getBonus();
							fine += rewards_penalties.getFine();
						}
						salary.setBonus(bonus);
						salary.setFine(fine);
						salary.setDeduction_wage(deduction_wage);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date date;
						String data=getYear()+"-"+getMonth()+"-"+getDay();
						data = data.toString();
						Double sfgz = salary.getBasesal() + salary.getBonus() + salary.getDeduction_wage()
						- salary.getFine();
						salary.setSfgz(sfgz);
						try {
							date = sdf.parse(data);
							salary.setTime(date);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
					}
					salaryVo.setUsername(username);
					salaryVo.setPositionname(positionname);
					salaryVo.setSalary(salary);

					// 添加到list
					salaryVoList.add(salaryVo);
				}
				return salaryVoList;
	}
	/**
	 * 保存xls到服务器，并返回绝对路径
	 * 
	 * @param sallist
	 *            salaryvolist
	 * @param path
	 *            项目根目录
	 * @return
	 */
	public String saveAsExcl(List<SalaryVo> sallist, String path) {
		String filePath = path + "\\工资表.xls";
		try {
			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFSheet sheet1 = workBook.createSheet("工资表");
			// 设置标题
			HSSFRow row1 = sheet1.createRow(0);
			HSSFCell cell1 = row1.createCell(0);
			cell1.setCellValue("用户id");
			HSSFCell cell2 = row1.createCell(1);
			cell2.setCellValue("用户姓名");
			HSSFCell cell3 = row1.createCell(2);
			cell3.setCellValue("岗位id");
			HSSFCell cell4 = row1.createCell(3);
			cell4.setCellValue("岗位名称");
			HSSFCell cell5 = row1.createCell(4);
			cell5.setCellValue("基本工资");
			HSSFCell cell6 = row1.createCell(5);
			cell6.setCellValue("提成工资");
			HSSFCell cell7 = row1.createCell(6);
			cell7.setCellValue("奖励金额");
			HSSFCell cell8 = row1.createCell(7);
			cell8.setCellValue("处罚金额");
			HSSFCell cell9 = row1.createCell(8);
			cell9.setCellValue("实发工资");
			HSSFCell cell10 = row1.createCell(9);
			cell10.setCellValue("时间");
			// 写入数据
			for (int i = 0; i < sallist.size(); i++) {
				SalaryVo salaryvo = sallist.get(i);
				Salary salary = salaryvo.getSalary();
				HSSFRow dataRow = sheet1.createRow(i + 1);
				// 用户id
				HSSFCell datacell1 = dataRow.createCell(0);
				datacell1.setCellValue(salary.getUserid());
				// 用户姓名
				HSSFCell datacell2 = dataRow.createCell(1);
				datacell2.setCellValue(salaryvo.getUsername());
				// 岗位id
				HSSFCell datacell3 = dataRow.createCell(2);
				datacell3.setCellValue(salary.getPositionid());
				// 岗位名称
				HSSFCell datacell4 = dataRow.createCell(3);
				datacell4.setCellValue(salaryvo.getPositionname());
				// 基本工资
				HSSFCell datacell5 = dataRow.createCell(4);
				// 提成工资
				HSSFCell datacell6 = dataRow.createCell(5);
				// 奖励金额
				HSSFCell datacell7 = dataRow.createCell(6);
				// 处罚金额
				HSSFCell datacell8 = dataRow.createCell(7);
				// 实发工资
				HSSFCell datacell9 = dataRow.createCell(8);
				// 时间
				HSSFCell datacell10 = dataRow.createCell(9);

				// 单元格格式对象
				HSSFCellStyle dateStyle = workBook.createCellStyle();
				HSSFCellStyle numStyle = workBook.createCellStyle();
				// 数据格式对象
				HSSFDataFormat dateformat = workBook.createDataFormat();
				numStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));// 保留两位小数点
				datacell5.setCellStyle(numStyle);
				datacell5.setCellValue(salary.getBasesal());
				datacell6.setCellStyle(numStyle);
				datacell6.setCellValue(salary.getDeduction_wage());
				datacell7.setCellStyle(numStyle);
				datacell7.setCellValue(salary.getBonus());
				datacell8.setCellStyle(numStyle);
				datacell8.setCellValue(salary.getFine());
				datacell9.setCellStyle(numStyle);
				datacell9.setCellValue(salary.getSfgz());
				dateStyle.setDataFormat(dateformat.getFormat("yyyy-MM-dd"));
				datacell10.setCellStyle(dateStyle);
				datacell10.setCellValue(salary.getTime());

			}

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

	@RequestMapping("salarylist")
	private String userlist(@RequestParam(value = "pageCount", required = false) Integer pageCount,
			@RequestParam(value = "currPage", required = false) Integer currPage,
			@RequestParam(value = "year", required = false) String year,
			@RequestParam(value = "month", required = false) String month,
			@RequestParam(value = "v", required = false) String version, Model model, HttpServletRequest request) {
		Map<String, Object> paramMap=new HashMap<String,Object>();
		String time="";
		if(year==null || year.equals("") || month==null || month.equals("")){
			//当前时间（年，月）
			year=getYear();
			month=getMonth();
		}
		if(Integer.parseInt(month)<10){
			month="0"+month;
		}
		time=year+"-"+month;
		System.out.println(time);
		paramMap.put("time", time);
		int totalRow = salaryService.selCount(paramMap);
		int totalPage = (totalRow + pageCount - 1) / pageCount;
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > totalPage) {
			currPage = totalPage;
		}
		paramMap.put("pageCount", pageCount);
		paramMap.put("currPage", currPage);
		List<Salary> salarylist = salaryService.selSalaryListPage(paramMap);
		if (salarylist != null) {
			int total = salarylist.size();
			List<SalaryVo> salaryVoList = new ArrayList<SalaryVo>(total);
			for (int i = 0; i < total; i++) {
				SalaryVo salaryVo = new SalaryVo();
				// 取出users
				Salary salary = salarylist.get(i);

				salaryVo.setSalary(salary);
				// 查出岗位名称、用户名
				String pname = posService.selPositionNameById(salary.getPositionid());
				String username = usersService.selUsernameById(salary.getUserid());
				salaryVo.setPositionname(pname);
				salaryVo.setUsername(username);
				// 添加到list
				salaryVoList.add(salaryVo);
			}
			model.addAttribute("year", year);
			model.addAttribute("month", month);
			model.addAttribute("salaryVoList", salaryVoList);
			model.addAttribute("totalRow", totalRow);
			model.addAttribute("totalPage", totalPage);
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("currPage", currPage);
			return "salarylist";
		} else {
			return "500";
		}
	}

	public String getYear() {
		Date date = new Date();
		@SuppressWarnings("deprecation")
		String dd = date.toLocaleString();
		String year = dd.substring(0, dd.indexOf("-"));
		return year;
	}

	public String getMonth() {
		Date date = new Date();
		@SuppressWarnings("deprecation")
		String dd = date.toLocaleString();
		String month = dd.substring(dd.indexOf("-") + 1, dd.lastIndexOf("-"));
		return month;
	}
	public String getDay() {
		Date date = new Date();
		@SuppressWarnings("deprecation")
		String dd = date.toLocaleString();
		String day = dd.substring(dd.lastIndexOf("-")+1, dd.lastIndexOf("-")+3);
		return day;
	}
}
