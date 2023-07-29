package action;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class DownloadAction {
	
	
	//��ȡ��Ŀ����·����files�ļ���
	private String savepath2 = ServletActionContext.getRequest().getRealPath(
			"/files")
			+ "\\";
	//���files�ļ����µ��ļ� ������ȡ
	private String fileName = "1-130624203442.png";

	public String execute() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.reset();
		String filepath = savepath2 + fileName;
		// ����response��Header
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
