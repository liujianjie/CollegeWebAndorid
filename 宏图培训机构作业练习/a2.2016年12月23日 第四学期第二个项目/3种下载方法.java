package com.ht.yfbc.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.jsf.FacesContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.ht.yfbc.pojo.Msg2;
import com.ht.yfbc.pojo.Msgpojo;
import com.ht.yfbc.pojo.Users;
import com.ht.yfbc.service.IMsgService;
import com.ht.yfbc.service.UsersService;

@Controller
@RequestMapping("/")
public class ZhongJingLianController {
	//3这种下载方法
	@RequestMapping("download2")
	public void download(HttpServletResponse res, @RequestParam(value = "filename", required = false) String filename,
			HttpServletRequest request) throws IOException {
		
//		if(filename != null && !filename.equals(" ")){
//		String path = request.getSession().getServletContext().getRealPath("uplodeFile");
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
		if(filename != null && !filename.equals(" ")){
		res.reset();
		String path = request.getSession().getServletContext().getRealPath("uplodeFile");
		String filepath = path +"\\" +filename;
		System.out.println(filepath);
		// 设置response的Header
		res.addHeader("Content-Disposition", "attachment;filename="
				+  URLEncoder.encode(filename, "UTF-8"));
		FileInputStream fileinput = new FileInputStream(filepath);
		OutputStream output = res.getOutputStream();
		byte[] bs = new byte[1024];
		int real = fileinput.read(bs);
		while (real > 0) {
			output.write(bs,0, real);
			real = fileinput.read(bs);
		}
		output.close();
		fileinput.close();
		}
	}
	// 导出
	@RequestMapping("expSalaryExcel")
	public ResponseEntity<byte[]> expSalaryExcel2(@RequestParam(value = "list", required = false) String tableValue,
			@RequestParam(value = "listsize", required = false) Integer listsize,
			@RequestParam(value = "year", required = false) String year,
			@RequestParam(value = "month", required = false) String month, HttpServletRequest request,
			HttpServletResponse response,Model model) throws IOException {
			
			File file=new File("E:\\宏图课程\\第四学期2\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\yfbc\\uplodeFile\\8053c9ea15ce36d37fb17bf932f33a87eb50b1ad.jpg");
			String fileName = "8053c9ea15ce36d37fb17bf932f33a87eb50b1ad.jpg";
			System.out.println(file.exists());
	        HttpHeaders headers = new HttpHeaders();    
	        String newfileName=new String(fileName.getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题  
	        headers.setContentDispositionFormData("attachment", newfileName);
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);   
	        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
		                                          headers, HttpStatus.CREATED);
	}

}
