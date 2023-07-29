package com.dc.controller.goods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.struts2.ServletActionContext;
/**
 * 图片上传
 * */
public class Picture {
	private File file;
	private String fileContentType;
	private String fileFileName;
	public String pictureinfo(){
		try {
			FileInputStream is=new FileInputStream(file);
			InputStream up2=ServletActionContext.getServletContext().
					getResourceAsStream("/WEB-INF/config/upload.properties");
			Properties pro=new Properties();//类似于map的一个类,
			pro.load(up2);//properties文件的键值对读进来
			String path=(String) pro.get("pathSrc");
			FileOutputStream os=new FileOutputStream(path+'/'+(new Date()).getTime()+fileFileName);
			byte[] b=new byte[1024];
			int length=-1;
			while((length=is.read(b))>1){
				os.write(b, 0, length);
		}
		is.close();
		os.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return "success";
		
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	
	
	
}
