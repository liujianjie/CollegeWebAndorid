package com.ht.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ht.common.BaseAction;
import com.ht.service.IPhotoService;
import com.ht.vo.Photos;

public class PhotoAction extends BaseAction {
	IPhotoService ip = (IPhotoService) this.getService("pService");
	private List list = new ArrayList();

	private File[] photo;
	private String[] photoFileName;
	private String[] pnames;
	private String savePath = ServletActionContext.getRequest().getRealPath(
			"imgs")
			+ "\\";

	// 下载的图片路径
	private String savepath2 = ServletActionContext.getRequest().getRealPath(
			"/imgs")
			+ "\\";
	private String fname;

	public File[] getPhoto() {
		return photo;
	}

	public void setPhoto(File[] photo) {
		this.photo = photo;
	}

	public String[] getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String[] photoFileName) {
		this.photoFileName = photoFileName;
	}

	// 查询相册列表
	public String list() {

		list = ip.list();

		return "success";
	}

	public String add() {
		Random ran=new Random();
		try {
			for (int i = 0; i < photoFileName.length; i++) {
				int num=ran.nextInt(100000000);
				FileOutputStream fos = new FileOutputStream(this.savePath
						+ num+ this.photoFileName[i]);
				FileInputStream fis = new FileInputStream(this.photo[i]);
				byte[] bs = new byte[1024];
				int real = fis.read(bs);
				while (real > 0) {
					fos.write(bs, 0, real);
					real = fis.read(bs);
				}
				fos.close();
				fis.close();

				// 保存数据到数据库
				Photos ph = new Photos();
				ph.setPname(pnames[i]);
				ph.setPsrc("imgs/" + photoFileName[i]);
				ip.add(ph);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "toindex";
	}

	public String down() throws Exception {
		
		fname=fname.substring(fname.indexOf("/"), fname.length());
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		String filepath = savepath2 + fname;
		// 设置response的Header
		response.addHeader("Content-Disposition", "attachment;filename="
				+ URLEncoder.encode(fname, "UTF-8"));
		FileInputStream fileinput = new FileInputStream(filepath);
		OutputStream output = response.getOutputStream();
		byte[] bs = new byte[1024];
		int real = fileinput.read(bs);
		while (real > 0) {
			output.write(bs, 0, real);
			real = fileinput.read(bs);
		}
		output.close();
		fileinput.close();
		return null;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String[] getPnames() {
		return pnames;
	}

	public void setPnames(String[] pnames) {
		this.pnames = pnames;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}
}
