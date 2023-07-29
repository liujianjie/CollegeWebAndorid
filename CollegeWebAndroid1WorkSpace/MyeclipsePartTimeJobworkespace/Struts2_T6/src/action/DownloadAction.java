package action;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class DownloadAction {
	
	
	//获取项目发布路径的files文件夹
	private String savepath2 = ServletActionContext.getRequest().getRealPath(
			"/files")
			+ "\\";
	//这个files文件夹下的文件 用来获取
	private String fileName = "1-130624203442.png";

	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		String filepath = savepath2 + fileName;
		// 设置response的Header
		response.addHeader("Content-Disposition", "attachment;filename="
				+  URLEncoder.encode(fileName, "UTF-8"));
		FileInputStream fileinput = new FileInputStream(filepath);
		OutputStream output = response.getOutputStream();
		byte[] bs = new byte[1024];
		int real = fileinput.read(bs);
		while (real > 0) {
			output.write(bs,0, real);
			real = fileinput.read(bs);
		}
		output.close();
		fileinput.close();
		return null;
	}
}
