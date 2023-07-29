package com.dc.controller.goods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import com.dc.util.BaseAction;
import com.dc.util.StringUtil;

public class PrctureAction extends BaseAction{
	private File filename;
	private String filenameContentType;
	private String  filenameFileName;
	private String imageurl;
/**
 * 图片上传
 * */	
	public void Upload(){
        try {
        	if(StringUtil.checkNotNull(filename)){//如果图片为空时不能上传,判断filename不能为空
        		InputStream up=this.getClass().getResourceAsStream("../../../../../config/PrctureAction.properties");
            	Properties pro=new Properties();
        	    pro.load(up);
        		String path=(String) pro.get("pathSrc");
        		
        		FileInputStream is=new FileInputStream(filename);
    			 imageurl=(new Date()).getTime()+filenameFileName;
    			FileOutputStream os=new FileOutputStream(path+"/"+imageurl);
    			byte[] b=new byte[1024];
    			int length=-1;
    			while((length=is.read(b))>-1){
    				os.write(b, 0, length);
    			}
    			is.close();
    			os.close();
        	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.getOut().print(imageurl);
	}
	
	
	public String getImageurl() {
		return imageurl;
	}


	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}


	public File getFilename() {
		return filename;
	}
	public void setFilename(File filename) {
		this.filename = filename;
	}
	public String getFilenameContentType() {
		return filenameContentType;
	}
	public void setFilenameContentType(String filenameContentType) {
		this.filenameContentType = filenameContentType;
	}
	public String getFilenameFileName() {
		return filenameFileName;
	}
	public void setFilenameFileName(String filenameFileName) {
		this.filenameFileName = filenameFileName;
	}
	

}
