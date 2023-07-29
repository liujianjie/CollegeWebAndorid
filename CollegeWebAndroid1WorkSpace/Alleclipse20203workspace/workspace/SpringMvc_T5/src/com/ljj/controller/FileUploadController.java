package com.ljj.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
public class FileUploadController {
	@RequestMapping("fileUpload")
	public String handleFormUpload(List<MultipartFile> uploadfile, HttpServletRequest request) {
		if(!uploadfile.isEmpty() && uploadfile.size() > 0 ) {
			for(MultipartFile file : uploadfile) {
				String originalFilename = file.getOriginalFilename();
				String dirPath = request.getServletContext().getRealPath("/upload/");
				System.out.println(dirPath);
				File filePath = new File(dirPath);
				if(!filePath.exists()) {
					filePath.mkdirs();
				}
				try {
					file.transferTo(new File(dirPath + originalFilename ));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return "success";
		}else {
			return "error";
		}
	}
	@RequestMapping("test")
	public String Test() {
		return "test";
	}
}
