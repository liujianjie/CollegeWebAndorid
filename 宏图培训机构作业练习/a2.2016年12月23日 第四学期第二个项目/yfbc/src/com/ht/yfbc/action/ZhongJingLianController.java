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
	@Resource
	private IMsgService msgservice;

	// @RequestMapping("hello")
	// private String hello(){
	// System.out.println("hello");
	// return null;
	// }
	@RequestMapping("findmsglist")
	public String msglist(Model model) {
		List<Msgpojo> msglist = msgservice.selmsglist();
		model.addAttribute("msglist", msglist);
		System.out.println("msglist");
		return "zhongjinlian/msglist";
	}

	@RequestMapping("del")
	public String delmsg(@RequestParam(value = "id", required = false) String id) {
		msgservice.del(id);
		return "redirect:/findpagemsglist.do";
	}

	@RequestMapping("tijiao")
	public String tijiao(Msgpojo msg, @RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "msgstatu", required = false) String msgstatu) {

		msgservice.changestatu(id, msgstatu);
		
		return "redirect:/findpagemsglist.do";
	}

	@RequestMapping("toupdmsg")
	public String toupd(@RequestParam(value = "id", required = false) String id, Model model) {
		Msgpojo msg = msgservice.toupdmsg(id);
		model.addAttribute("msg", msg);
		return "zhongjinlian/updatemsg";
	}

	@RequestMapping("todetil")
	public String todetil(@RequestParam(value = "id", required = false) String id, Model model) {
		Msgpojo msg = msgservice.toupdmsg(id);
		model.addAttribute("msg", msg);
		return "mail_detail";
	}

	@RequestMapping("updmsg")
	public String upd(Msgpojo msg, Model model) {
		msg.setMsgstatu(0 + "");
		msg.setMsgtime(new Date());
		msgservice.updmsg(msg);
		System.out.println("updatemsg coming in");
		return "redirect:/findpagemsglist.do";

	}
	
	@RequestMapping("addmsgs")
	public String upload(Msgpojo msg, HttpServletRequest request,@RequestParam(value = "statu", required = false)String statu,
			@RequestParam(value = "file", required = false) MultipartFile file, Model modle) {
		try {
			CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
	        // 设置编码  
	        commonsMultipartResolver.setDefaultEncoding("utf-8"); 
	        msg.setMsgfile(" ");
			if(!file.isEmpty()){
				String path = request.getSession().getServletContext().getRealPath("uplodeFile");
				String fileName = file.getOriginalFilename();
				msg.setMsgfile(fileName);
				File tfile = new File(path, fileName);
				file.transferTo(tfile);
			}
			msg.setMsgstatu(statu);
			msg.setMsgtime(new Date());
			
			msg.setMsgtopeople("所有人");
			msgservice.addmsg(msg);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/findpagemsglist.do";

	}

	@RequestMapping("download2")
	public void download(HttpServletResponse res, @RequestParam(value = "filename", required = false) String filename,
			HttpServletRequest request) throws IOException {
		
		if(filename != null && !filename.equals(" ")){
		String path = request.getSession().getServletContext().getRealPath("uplodeFile");
		File file = new File(path, filename);
		filename = new String(filename.getBytes(), "ISO-8859-1");
		OutputStream os = res.getOutputStream();
		try {
			res.reset();
			res.setContentType("application/octet-stream; charset=utf-8");
			res.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
			os.write(FileUtils.readFileToByteArray(file));
			os.flush();
		} finally {
			if (os != null) {
				os.close();
			}
		}
		}
	}

	// fen ye list
	@RequestMapping("findpagemsglist")
	public String findpagelist(@RequestParam(value = "cpage", required = false) String cpage, Model model) {
		
		
		int totalRow = 0;

		totalRow = msgservice.selmsglist().size();
		int pageCount = 6;
		int currPage = 1;
		int totalPage = (totalRow + pageCount - 1) / pageCount;
		if (cpage != null && !"".equals(cpage)) {
			currPage = Integer.parseInt(cpage);
		}
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > totalPage) {
			currPage = totalPage;
		}

		System.out.println("findpagemsglist coming in");
		List<Msgpojo> msglist = msgservice.findpagelist(pageCount, currPage);

		model.addAttribute("msglist", msglist);
		model.addAttribute("currPage", currPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("pageCount", pageCount);
		return "mailbox";
	}

	@RequestMapping("findpagemsgmylist")
	public String findpagemylist( HttpServletRequest request,@RequestParam(value = "cpage", required = false) String cpage,
			@RequestParam(value = "msgstatu", required = false) String statu, Model model) {
		HttpSession session = request.getSession();
		Users user = (Users) session.getAttribute("user");
		String msgpeople = user.getUsername();
		int totalRow = 0;

		totalRow = msgservice.selmsgmylist(msgpeople,statu).size();
		int pageCount = 6;
		int currPage = 1;
		int totalPage = (totalRow + pageCount - 1) / pageCount;
		if (cpage != null && !"".equals(cpage)) {
			currPage = Integer.parseInt(cpage);
		}
		if (currPage < 1) {
			currPage = 1;
		}
		if (currPage > totalPage) {
			currPage = totalPage;
		}

		System.out.println("findpagemsglist coming in");
		List<Msgpojo> msglist = msgservice.findpagemylist(pageCount, currPage,msgpeople,statu);

		model.addAttribute("msglist", msglist);
		model.addAttribute("currPage", currPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("pageCount", pageCount);
		if(statu.equals("0")){
			return "mailbox2";
		}else if(statu.equals("1")){
			return "mailbox3";
		}else if(statu.equals("2")){
			return "mailbox4";
		}
		return "mailbox";
		
	}
	
	@RequestMapping("ajaxmsg")
	@ResponseBody
	public Map<String, Object> ajaxmsg(){
		List<Msg2> list = msgservice.ajaxlist();
		int i = msgservice.selmsglist().size();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Msg2 msg2 : list) {
			msg2.setDate(format.format(msg2.getMsgtime()));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("size", i);
		map.put("msg", list);
		
		return map;
		
	}
	
	@RequestMapping("ajaxmsg2")
	@ResponseBody
	public Map<String, Object> ajaxmsg2(){
		List<Msg2> list = msgservice.ajaxlist2();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Msg2 msg2 : list) {
			msg2.setDate(format.format(msg2.getMsgtime()));
		}
		Map<String, Object> map = new HashMap<>();
		map.put("msg", list);
		
		return map;
		
	}

}
